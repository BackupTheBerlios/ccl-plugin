/*
 * ActionAddContextProperty.java
 *
 * Created on 11. November 2001, 16:31
 * Changed by hyshosha
 */
/**
 * * @author  shicathy
 * @version 0.1
 */

package org.cocons.argo.diagram.ui;

import org.argouml.uml.ui.*;
import org.argouml.kernel.*;
import org.argouml.uml.*;
import org.argouml.ui.*;
import ru.novosoft.uml.foundation.core.*;
import java.awt.event.*;
import org.cocons.uml.ccl.*;
import org.cocons.argo.util.ModelIterator;
import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;

// -------------- additional imports ----------------
import java.awt.*;
import java.util.*;
import org.argouml.uml.diagram.static_structure.ui.*;
import org.argouml.uml.diagram.ui.*;
import org.tigris.gef.base.*;
import org.tigris.gef.graph.*;
import org.tigris.gef.presentation.*;
import java.util.Vector;
import java.util.Collection;
import javax.swing.*;
import org.cocons.argo.diagram.ui.FigContextProperty;
import org.cocons.uml.ccl.context_property1_3.*;
// --------------------------------------------------

public class ActionAddContextProperty extends UMLAction {

    private ModelIterator _modelIterator = ModelIterator.SINGLETON;

    ////////////////////////////////////////////////////////////////
    // static variables

    public static ActionAddContextProperty SINGLETON = new ActionAddContextProperty();

     ////////////////////////////////////////////////////////////////
    // constructors

    public ActionAddContextProperty() { super("ContextProperty"); }

    ////////////////////////////////////////////////////////////////
    // main methods

    public void actionPerformed(ActionEvent ae) {
        // are there any defined ContPropTags ?
        if (_modelIterator.getCountContextPropertyTags()==0) {
          JOptionPane.showMessageDialog(null,"No defined Context Properties Tags found !");
          return;
        }
        else {
          // users will be forced to choose a defined CPTag
          TagChooser tagChooser = new TagChooser();
          tagChooser.show();
          if (tagChooser.getChoosenName()==null) return;
          else {
            String choosenTag = tagChooser.getChoosenName();

            ProjectBrowser pb = ProjectBrowser.TheInstance;
            Project p = pb.getProject();
            Object target = pb.getDetailsTarget();

            if (tagIsAlreadyAssignedToTarget(choosenTag,target)) {
              JOptionPane.showMessageDialog(null,"The model element \""+((MModelElement)target).getName()+"\" has already\n a Context Property \""+choosenTag+"\" !");
              return;
            }
            if (tagIsStandardTaggedValue(choosenTag,target)) {
              JOptionPane.showMessageDialog(null,"The model element \""+((MModelElement)target).getName()+"\" has already\n a Tagged Value \""+choosenTag+"\" !\nYou should rename this Tagged Value first !");
              return;
            }

            if (!((target instanceof MClassifier)||(target instanceof MPackage))) return;

            Editor ce = Globals.curEditor();
	    GraphModel gm = ce.getGraphModel();
	    GraphNodeRenderer renderer = ce.getGraphNodeRenderer();
	    Layer lay = ce.getLayerManager().getActiveLayer();

            MContextPropertyValueImpl figureOwner = new MContextPropertyValueImpl();
            MContextPropertyTag referencedTag = _modelIterator.getContextPropertyTag(choosenTag);
            figureOwner.internalRefByContextPropertyTag(referencedTag);
            figureOwner.logicalRefByModelElement((MModelElement)target);
            figureOwner.setCPTag(choosenTag);
            figureOwner.setCPValue("no values selected or defined");
            ((MModelElement)target).addTaggedValue(figureOwner);
            FigContextProperty contextProperty = new FigContextProperty(gm,figureOwner);

            // place the note a few pixels right of the selected figure
	    Fig f = null;  // The figure for the associated object.
	    Rectangle targetBounds=null;  // The bounds of this figure.
            Vector figs = ce.getSelectionManager().getFigs();  // Get all the figures of the current diagram.
            int size = figs.size();
            for (int i = 0; i < size; i++) {  // Now search the figure for the active element
	      f = (Fig)figs.elementAt(i);
	      Object owner = f.getOwner();  // Get the owner of the current figure.
	      if((owner instanceof MModelElement) && (owner == target)) {  // If this is the figure,
		targetBounds = f.getBounds();   // get the bounds of it.
		// Place the contextProperty right of the figure,
                contextProperty.setLocation(targetBounds.x + targetBounds.width + 80, targetBounds.y);
		// And finish the search.
		break;
	      }
            }
            lay.add(contextProperty);

            // Add a link from note to associated figure
	    //
            Rectangle contextPropertyBounds = contextProperty.getBounds();

	    // Simulate a mouseclick in the middle of the figure to get a port to connect
	    // the link to.
            Object startPort = contextProperty.deepHitPort( contextPropertyBounds.x + contextPropertyBounds.width/2, contextPropertyBounds.y + contextPropertyBounds.height/2);
	    Fig startPortFigure = contextProperty.getPortFig(startPort);

	    MutableGraphModel mgm = (MutableGraphModel)gm;

	    if (f instanceof FigNode) {
	      FigNode destFigNode = (FigNode)f;

	      // Place the port in the middle of the figure.
	      Object foundPort = destFigNode.deepHitPort(targetBounds.x + targetBounds.width/2, targetBounds.y + targetBounds.height/2);

	      if (foundPort != null) {
		Fig destPortFig = destFigNode.getPortFig(foundPort);
		FigEdgeNote fe = new FigEdgeNote();
                // -------------------------------------------------
                //ArrowHeadQualifier arrow = new ArrowHeadQualifier();
                //arrow.setLineColor(Color.blue);
                //arrow.setFillColor(Color.yellow);
                //fe.setSourceArrowHead(arrow);
                //fe.setDestArrowHead(arrow);
                fe.setLineColor(Color.blue);
                // -------------------------------------------------
		fe.setSourcePortFig( startPortFigure);

                fe.setSourceFigNode( contextProperty);
		fe.setDestPortFig( destPortFig);
		fe.setDestFigNode( (FigNode)f);
		// Compute the route for this edge. That methods basically adds a snap point at
		// the edge of the figures, so you can mode the edge at the edge of the figures.
		fe.computeRoute();
                // Add the edge to the current layer.
		lay.add(fe);
		lay.sendToBack(fe);
		// set the new edge in place
                contextProperty.addFigEdge(fe);
		destFigNode.addFigEdge(fe);
                contextProperty.updateEdges();
		destFigNode.updateEdges();
		ce.damaged(fe);
                contextProperty.damage();
		f.damage();
	      }
	    }
            //super.actionPerformed(ae);
            pb.getNavPane().forceUpdate();
            pb.getDetailsPane().updateUI();
            pb.selectTabNamed("Properties");
            pb.selectTabNamed("TaggedValues");
            contextProperty.startKiller();
            figureOwner.actualizeFigure();
          }
        }
    }

    private boolean tagIsAlreadyAssignedToTarget(String selectedTag, Object target) {
      Vector cpTaggedValues = _modelIterator.getAllContextPropertyValues();
      MContextPropertyValue actValue = null;
      if ((cpTaggedValues == null)||(cpTaggedValues.size()==0)) return(false);
      else {
        for (int i = 0; i < cpTaggedValues.size(); i++) {
            actValue = (MContextPropertyValue)cpTaggedValues.elementAt(i);
            if (actValue.getReferencedModelElement().equals(target)) {
              if (actValue.getTag().equals(selectedTag)) return(true);
            }
        }
      }
      return(false);
    }

    private boolean tagIsStandardTaggedValue(String selectedTag, Object target) {
      Collection col = ((MModelElement)target).getTaggedValues();
      if (col != null) {
        Object[] taggedValues = col.toArray();
        for (int i = 0; i < taggedValues.length; i++) {
          if (((MTaggedValue)taggedValues[i]).getTag().equals(selectedTag)) return(true);
        }
        return(false);
      }
      else return(false);
    }

    public boolean shouldBeEnabled() {
        ProjectBrowser pb = ProjectBrowser.TheInstance;
        Object target = pb.getDetailsTarget();
        return( super.shouldBeEnabled() &&
              ( target instanceof MClassifier || target instanceof MPackage ) );
    }

    ////////////////////////////////////////////////////////////////
  // helper classes

  // ===========================================================================
  // ----- Class TagChooser -----
  class TagChooser {

    private String _choosenTag = "";
    private JDialog _dialog;
    private JComboBox _nameBox;

    public TagChooser() {
      initLayout();
    }

    public String getChoosenName() {
      if (_choosenTag.equals("")) return(null);
      else return(_choosenTag);
    }

    private void initLayout() {
      JPanel buttonPanel = new JPanel();
      JButton selectButton = new JButton("Select");
      selectButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          _choosenTag = (String)_nameBox.getSelectedItem();
          _dialog.dispose();
        }
      });
      JButton cancelButton = new JButton("Cancel");
      cancelButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          _choosenTag = "";
          _dialog.dispose();
        }
      });
      buttonPanel.add(selectButton,"West");
      buttonPanel.add(cancelButton,"East");

      JPanel namePanel = new JPanel();
      JLabel nameLabel = new JLabel(" Tag Name :");
      _nameBox = new JComboBox();
      _nameBox.setBackground(Color.white);
      Vector tagNames = _modelIterator.getAllContextPropertyTagNames();
      for (int i = 0; i < _modelIterator.getCountContextPropertyTags(); i++) {
        _nameBox.addItem(tagNames.elementAt(i));
      }

      namePanel.add(nameLabel,"West");
      namePanel.add(_nameBox,"East");

      JFrame parent = new JFrame();
      _dialog = new JDialog(parent,"Select Context Property Tag",true);

      _dialog.getContentPane().add(buttonPanel,"South");
      _dialog.getContentPane().add(namePanel,"North");


      _dialog.setSize(220,95);
//*nix friendly      _dialog.setResizable(false);
       _dialog.setResizable(true);
      Toolkit tk = Toolkit.getDefaultToolkit();
      int screenWidth = tk.getScreenSize().width;
      int screenHeight = tk.getScreenSize().height;
      _dialog.setLocation((screenWidth-220)/2,(screenHeight-95)/5);
    }

    public void show() {
      _dialog.show();
    }

  }
  // ----- Class TagChooser -----
  // ===========================================================================

} /* end class ActionAddContextProperty */
