package org.cocons.argo.ui;

import org.tigris.gef.util.*;

import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.foundation.core.*;

import org.argouml.ui.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
import org.argouml.uml.ui.foundation.extension_mechanisms.PropPanelStereotype;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.event.*;

import org.cocons.argo.util.*;
import org.cocons.uml.ccl.*;
import org.cocons.argo.diagram.ui.*;
import org.cocons.uml.ccl.context_property1_3.*;

/**
 * Title:        CCL-Plugin for ArgoUML
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      Technische Universität Berlin
 * @author hyshosha@gmx.de ; hasihola@cs.tu-berlin.de
 * @version 1.0
 */

public class PropPanelContextPropertyValue extends PropPanelModelElement implements Observer,TableModelListener{

  protected static ImageIcon _contextPropertyIcon = ResourceLoader.lookupIconResource("ContextProperty");
  private ModelIterator _modelIterator = ModelIterator.SINGLETON;

  private String _validValuesType;
  private Vector _validStrings;
  private int _lowerIntRange;
  private int _upperIntRange;
  private float _lowerFloatRange;
  private float _upperFloatRange;

  ///////////////////////////////////////////////////////////////
  // Layout-Komponenten
  protected static ImageIcon _manageContextPropertyTagsIcon = ResourceLoader.lookupIconResource("ManageContextPropertyTags");
  ActionManageContextPropertyTags _actManCPT = ActionManageContextPropertyTags.SINGLETON;
  protected static ImageIcon _infoContextPropertyTagsIcon = ResourceLoader.lookupIconResource("InfoContextPropertyTags");
  ActionInfoContextPropertyTags _actInfoCPT = ActionInfoContextPropertyTags.SINGLETON;
  protected static ImageIcon _identifyContextPropertyTagsIcon = ResourceLoader.lookupIconResource("IdentifyContextProperty");
  ActionIdentifyContextProperty _actIdentifyCP = ActionIdentifyContextProperty.SINGLETON;
  protected static ImageIcon _contextPropertyArrow1Icon = ResourceLoader.lookupIconResource("ContextPropertyArrow1");
  protected static ImageIcon _contextPropertyArrow2Icon = ResourceLoader.lookupIconResource("ContextPropertyArrow2");
  protected static ImageIcon _contextPropertyArrow3Icon = ResourceLoader.lookupIconResource("ShowAllContextPropertyValues");
  ActionShowAllContextPropertyValues _actAllValues = ActionShowAllContextPropertyValues.SINGLETON;
  protected static ImageIcon _contextPropertyArrow4Icon = ResourceLoader.lookupIconResource("HideAllContextPropertyValues");
  ActionHideAllContextPropertyValues _actNoValues = ActionHideAllContextPropertyValues.SINGLETON;

  private JComboBox _nameBox;
  private JComboBox _stereoBox;
  private JTable _valueTable;
  private JLabel _typeLabel;
  private JLabel _unitLabel;
  private boolean _locked = false;
  //
  ///////////////////////////////////////////////////////////////

  private MContextPropertyValueImpl _target;

  public PropPanelContextPropertyValue() {
    super("Context Property",_contextPropertyIcon, 2);
    _modelIterator.registerTagListObserver(this);
    initLayout();
  }

  private void initLayout() {
    new PropPanelButton(this,buttonPanel,_manageContextPropertyTagsIcon,localize("Create / Change / Delete CP-Tags"),"manageContPropTags",null);
    new PropPanelButton(this,buttonPanel,_infoContextPropertyTagsIcon,localize("Show defined CP-Tags"),"infoContPropTags",null);
    new PropPanelButton(this,buttonPanel,_identifyContextPropertyTagsIcon,localize("Look for special Context Properties"),"identifyContPropTags",null);
    new PropPanelButton(this,buttonPanel,_contextPropertyArrow3Icon,localize("Show values in all figures"),"showAllFigureValues",null);
    new PropPanelButton(this,buttonPanel,_contextPropertyArrow4Icon,localize("Hide values in all figures"),"hideAllFigureValues",null);
    new PropPanelButton(this,buttonPanel,_contextPropertyArrow1Icon,localize("Show / Hide values in the figure"),"showHideFigureValues",null);
    new PropPanelButton(this,buttonPanel,_contextPropertyArrow2Icon,localize("Arrange values vertical or horizontal"),"verticalHorizontal",null);
    new PropPanelButton(this,buttonPanel,_navUpIcon,localize("Go to referenced model element"),"navigateUp",null);
    //new PropPanelButton(this,buttonPanel,_navBackIcon,localize("Go back"),"navigateBackAction","isNavigateBackEnabled");
    //new PropPanelButton(this,buttonPanel,_navForwardIcon,localize("Go forward"),"navigateForwardAction","isNavigateForwardEnabled");
    new PropPanelButton(this,buttonPanel,_deleteIcon,localize("Delete Context Property"),"removeElement",null);

    addCaption("                       Tag Name     : ",1,0,0);
    _nameBox = new JComboBox();
    //_nameBox.setBackground(Color.yellow);
    _nameBox.setBackground(Color.white);
    _nameBox.setFont(new java.awt.Font("Dialog", 1, 12));
    _nameBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ProjectBrowser pb = ProjectBrowser.TheInstance;
        if (pb.getDetailsTarget() instanceof MContextPropertyValueImpl) {
          if (!_locked) { // siehe update() "focus gained"
            MContextPropertyValueImpl target = (MContextPropertyValueImpl)pb.getDetailsTarget();
            MContextPropertyTagImpl bakTag = (MContextPropertyTagImpl)target.getContextPropertyTag();
            String bakTagName = bakTag.getTag();
            String newTagName = (String)_nameBox.getSelectedItem();
            // jetzt wird getestet, ob der neue Tag noch nicht mit dem referenzierten Modell-
            // element in Referenz steht
            if (!newTagName.equals(bakTagName)) {
              if (tagIsAlreadyAssignedToTarget(newTagName,target.getReferencedModelElement()))  {
                JOptionPane.showMessageDialog(null,"The model element \""+((MModelElement)target.getReferencedModelElement()).getName()+"\" has already\n a Context Property \""+newTagName+"\" !");
                _locked = true;
                _nameBox.setSelectedItem(bakTagName);
                _locked = false;
                return;
              }
              if (tagIsStandardTaggedValue(newTagName,target.getReferencedModelElement())) {
                JOptionPane.showMessageDialog(null,"The model element \""+((MModelElement)target.getReferencedModelElement()).getName()+"\" has already\n a Tagged Value \""+newTagName+"\" !\nYou should rename this Tagged Value first !");
                _locked = true;
                _nameBox.setSelectedItem(bakTagName);
                _locked = false;
                return;
              }
              target.resetFigureOrientation();
              target.resetValueVisibility();
              //
              MContextPropertyTagImpl refTag = (MContextPropertyTagImpl)_modelIterator.getContextPropertyTag(newTagName);
              // 1) CPTag-Referenz aktualisieren
              target.setContextPropertyTag(refTag);
              // 2) CPValue entsprechend umbenennen (darauf horchen das NavPanel und das TaggedValuesPane)
              target.setCPTag(newTagName);
              // 3) ... (Values)
              _valueTable.getModel().removeTableModelListener(getTableModelListener());
              ((ValueTableModel)_valueTable.getModel()).removeAllRows();

              _validValuesType = refTag.getValidValuesType();
              target.setValidValuesType(_validValuesType);
              target.setCPValue("no values selected or defined");
              target.setValueString_Horizontal("no values selected or defined ");
              target.setValueString_Vertical("\n> no values selected or defined \n");
              target.setStereoString("");
              _stereoBox.setSelectedItem("");

              if (_validValuesType.equals("List Of Strings")) {
                _validStrings = refTag.getValidStrings();
                _typeLabel.setText("\"List Of Strings\"   [ "+Integer.toString(_validStrings.size())+" defined strings ] )");
                _unitLabel.setText("N/A )");

                ((ValueTableModel)_valueTable.getModel()).isListOfStrings(true);
                ValueTableModel tableModel = (ValueTableModel)_valueTable.getModel();
                for (int i = 0; i < _validStrings.size(); i++) {
                  tableModel.addTableRow((String)_validStrings.elementAt(i),new Boolean(false),"");
                }
                _valueTable.getModel().addTableModelListener(getTableModelListener());

              }
              else if (_validValuesType.equals("Integer Number")) {
                int[] range = refTag.getIntegerRange();
                _lowerIntRange = range[0];
                _upperIntRange = range[1];
                _typeLabel.setText("\"Integer Number\""+"   Range : [ "+Integer.toString(_lowerIntRange)+" , "+Integer.toString(_upperIntRange)+" ] )");
                _unitLabel.setText(refTag.getUnit()+" )");

                ((ValueTableModel)_valueTable.getModel()).isListOfStrings(false);
                ((ValueTableModel)_valueTable.getModel()).isIntegerNumber(true);
                ValueTableModel tableModel = (ValueTableModel)_valueTable.getModel();
                tableModel.addTableRow("",new Boolean(false),"");
                _valueTable.getModel().addTableModelListener(getTableModelListener());

              }
              else if (_validValuesType.equals("Float Number")) {
                float[] range = refTag.getFloatRange();
                _lowerFloatRange = range[0];
                _upperFloatRange = range[1];
                _typeLabel.setText("\"Float Number\""+"   Range : [ "+Float.toString(_lowerFloatRange)+" , "+Float.toString(_upperFloatRange)+" ] )");
                _unitLabel.setText(refTag.getUnit()+" )");

                ((ValueTableModel)_valueTable.getModel()).isListOfStrings(false);
                ((ValueTableModel)_valueTable.getModel()).isIntegerNumber(false);
                ValueTableModel tableModel = (ValueTableModel)_valueTable.getModel();
                tableModel.addTableRow("",new Boolean(false),"");
                _valueTable.getModel().addTableModelListener(getTableModelListener());

              }
              else {}

              target.actualizeFigure();
              pb.getNavPane().forceUpdate();
            }
          }
        }
      }
    });
    addField(_nameBox,1,0,0);

    addCaption("                       Reference    : ",2,0,0);
    JList ownerList = new UMLList(new UMLReflectionListModel(this,"owner",false,"getReferencedModelElement",null,null,null),true);
    ownerList.addMouseListener(new MouseListener() {
      public void mouseExited(MouseEvent me) {}
      public void mouseEntered(MouseEvent me) {}
      public void mouseReleased(MouseEvent me) {}
      public void mousePressed(MouseEvent me) {}
      public void mouseClicked(MouseEvent me) {navigateReferencedModelElement();}
    });
    ownerList.setSelectionBackground(Color.white);
    JScrollPane ownerScroll=new JScrollPane(ownerList,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    addLinkField(ownerScroll,2,0,0);

    addCaption("                       Namespace  : ",3,0,0);
    JList namespaceList = new UMLList(new UMLReflectionListModel(this,"namespace",false,"getNamespace",null,null,null),true);
    namespaceList.addMouseListener(new MouseListener() {
      public void mouseExited(MouseEvent me) {}
      public void mouseEntered(MouseEvent me) {}
      public void mouseReleased(MouseEvent me) {}
      public void mousePressed(MouseEvent me) {}
      public void mouseClicked(MouseEvent me) {navigateNamespace();}
    });
    namespaceList.setSelectionBackground(Color.white);
    namespaceList.setSelectionForeground(Color.blue);
    namespaceList.setForeground(Color.blue);
    JScrollPane namespaceScroll=new JScrollPane(namespaceList,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    addField(namespaceScroll,3,0,0);

    addCaption("                       Stereotype    : ",4,0,0);
    _stereoBox = new JComboBox();
    _stereoBox.setBackground(Color.white);
    //_stereoBox.setForeground(Color.red);
    _stereoBox.setForeground(Color.black);
    _stereoBox.setFont(new java.awt.Font("Dialog", 0, 12));
    _stereoBox.addItem("");
    _stereoBox.addItem("Quality");
    _stereoBox.addItem("Implement");
    _stereoBox.addItem("Configure");
    _stereoBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!_locked) { // siehe update() "focus gained"
          ProjectBrowser pb = ProjectBrowser.TheInstance;
          String stereo = "";
          if (pb.getDetailsTarget() instanceof MContextPropertyValueImpl) {
            MContextPropertyValueImpl target = (MContextPropertyValueImpl)pb.getDetailsTarget();
            stereo = (String)_stereoBox.getSelectedItem();
            if (!(stereo.equals(target.getStereoString()))) {
              target.setStereoString(stereo);
              target.actualizeFigure();
            }
          }
        }
      }
    });
    addField(_stereoBox,4,0,0);

    _valueTable = new JTable(new ValueTableModel());
    _valueTable.getModel().addTableModelListener(this);
    _valueTable.getColumnModel().getColumn(0).setResizable(false);
    _valueTable.getColumnModel().getColumn(1).setResizable(false);
    _valueTable.getColumnModel().getColumn(2).setResizable(false);
    _valueTable.getColumnModel().getColumn(1).setMaxWidth(20);
    _valueTable.getColumnModel().getColumn(1).setMinWidth(20);
    _valueTable.setSelectionBackground(Color.white);
    _valueTable.setSelectionForeground(Color.black);
    JScrollPane valueTablePane = new JScrollPane(_valueTable);

    addCaption("  ",1,1,0);
    addCaption("        ( Type ... : ",2,1,0);
    _typeLabel = new JLabel("N/A )");
    addField(_typeLabel,2,1,0);
    addCaption("        ( Unit .... : ",3,1,0);
    _unitLabel = new JLabel("N/A )");
    addField(_unitLabel,3,1,0);
    addCaption("         Values  : ",4,1,0);
    addField(valueTablePane,4,1,1);
    addCaption("  ",5,1,0);

  }

  public void manageContPropTags() {_actManCPT.anonymActionPerformed();}
  public void infoContPropTags() {_actInfoCPT.anonymActionPerformed();}
  public void identifyContPropTags() {_actIdentifyCP.anonymActionPerformed();}
  public void showHideFigureValues() {
    Object target = getTarget();
    if(target instanceof MContextPropertyValueImpl) {
      ((MContextPropertyValueImpl)target).negateValueVisibility();
      ((MContextPropertyValueImpl)target).actualizeFigure();
    }
  }
  public void verticalHorizontal() {
    Object target = getTarget();
    if(target instanceof MContextPropertyValueImpl) {
      ((MContextPropertyValueImpl)target).negateFigureOrientation();
      ((MContextPropertyValueImpl)target).actualizeFigure();
    }
  }
  public void showAllFigureValues() {_actAllValues.anonymActionPerformed();}
  public void hideAllFigureValues() {_actNoValues.anonymActionPerformed();}
  public void removeElement() {
    Object target = getTarget();
    if(target instanceof MContextPropertyValueImpl) {
      ((MContextPropertyValueImpl)target).removeMe();
      ProjectBrowser pb = ProjectBrowser.TheInstance;
      pb.getNavPane().forceUpdate();
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

  private boolean tagIsStandardTaggedValue(String selectedTag, MModelElement target) {
      Collection col = target.getTaggedValues();
      if (col != null) {
        Object[] taggedValues = col.toArray();
        for (int i = 0; i < taggedValues.length; i++) {
          if (((MTaggedValue)taggedValues[i]).getTag().equals(selectedTag)) return(true);
        }
        return(false);
      }
      else return(false);
    }

  public Object getReferencedModelElement() {
    Object target = getTarget();
    return(((MContextPropertyValueImpl)target).getReferencedModelElement());
  }

  public MNamespace getNamespace() {
    Object target = getTarget();
    return(((MContextPropertyValueImpl)target).getReferencedModelElement().getNamespace());
  }

  /////////////////////////////////
  // Navigation
  public void navigateNamespace() {
    ProjectBrowser pb = ProjectBrowser.TheInstance;
    Object target = getTarget();
    MContextPropertyValueImpl realTarget;
    if (target instanceof MContextPropertyValue) {
      realTarget = (MContextPropertyValueImpl)target;
      if ((realTarget.getReferencedModelElement() instanceof MClassifier)||(realTarget.getReferencedModelElement() instanceof MPackage)) {
        pb.select(realTarget.getReferencedModelElement().getNamespace());
      }
    }
  }
  public void navigateUp() {
    navigateReferencedModelElement();
  }
  public void navigateReferencedModelElement() {
    ProjectBrowser pb = ProjectBrowser.TheInstance;
    Object target = getTarget();
    MContextPropertyValueImpl realTarget;
    if (target instanceof MContextPropertyValue) {
      realTarget = (MContextPropertyValueImpl)target;
      if ((realTarget.getReferencedModelElement() instanceof MClassifier)||(realTarget.getReferencedModelElement() instanceof MPackage)) {
        pb.select(realTarget.getReferencedModelElement());
      }
    }
  }
  //
  ////////////////////////////////////

  protected boolean isAcceptibleBaseMetaClass(String baseClass) {
      return baseClass.equals("ContextPropertyValue");
  }

  public void update(Observable o, Object arg) {
    MessageContainer messCon = (MessageContainer)arg;
    String message = messCon.getMessage();

    if (message.equals("tag added")) {
      _nameBox.addItem(messCon.getString());
    }
    else if (message.equals("tagname changed")) {
      Vector cpTags = _modelIterator.getAllContextPropertyTagNames();
      int cpTagsCount = _modelIterator.getCountContextPropertyTags();
      _nameBox.removeAllItems();
      for (int i = 0; i < cpTagsCount; i++)
        _nameBox.addItem((String)cpTags.elementAt(i));
      if (this.getTarget() != null) {
        if (this.getTarget() instanceof MContextPropertyValueImpl) {
          _nameBox.setSelectedItem(((MContextPropertyValueImpl)this.getTarget()).getContextPropertyTag().getTag());
        }
      }
    }
    else if (message.equals("valid values changed")) {
      String changedTag = messCon.getString();
      MContextPropertyValueImpl target = null;
      if (messCon.getObject() != null) target = (MContextPropertyValueImpl)messCon.getObject();
      if ((changedTag.equals((String)_nameBox.getSelectedItem()))&&(target != null)) {
        _locked = true;
        MContextPropertyTagImpl refTag = (MContextPropertyTagImpl)_modelIterator.getContextPropertyTag(messCon.getString());

        _validValuesType = refTag.getValidValuesType();
        //_stereoBox.setSelectedItem(target.getStereoString());

        _valueTable.getModel().removeTableModelListener(getTableModelListener());
        ((ValueTableModel)_valueTable.getModel()).removeAllRows();

        if (_validValuesType.equals("List Of Strings")) {
          _validStrings = refTag.getValidStrings();
          _typeLabel.setText("\"List Of Strings\"   [ "+Integer.toString(_validStrings.size())+" defined strings ] )");
          _unitLabel.setText("N/A )");

          ((ValueTableModel)_valueTable.getModel()).isListOfStrings(true);
          ValueTableModel tableModel = (ValueTableModel)_valueTable.getModel();
          for (int i = 0; i < _validStrings.size(); i++) {
            tableModel.addTableRow((String)_validStrings.elementAt(i),target.getStringSelectionAt(i),target.getStringDependencyAt(i));
          }
          _valueTable.getModel().addTableModelListener(getTableModelListener());
        }
        else if (_validValuesType.equals("Integer Number")) {
          int[] range = refTag.getIntegerRange();
          _lowerIntRange = range[0];
          _upperIntRange = range[1];
          _typeLabel.setText("\"Integer Number\""+"   Range : [ "+Integer.toString(_lowerIntRange)+" , "+Integer.toString(_upperIntRange)+" ] )");
          _unitLabel.setText(refTag.getUnit()+" )");

          ((ValueTableModel)_valueTable.getModel()).isListOfStrings(false);
          ((ValueTableModel)_valueTable.getModel()).isIntegerNumber(true);
          target.cleanIntegerValues();
          ValueTableModel tableModel = (ValueTableModel)_valueTable.getModel();
          for (int i = 0; i < target.getValuesCount(); i++) {
            tableModel.addTableRow((String)target.getIntegerValueAt(i),target.getIntegerSelectionAt(i),target.getIntegerDependencyAt(i));
          }
          _valueTable.getModel().addTableModelListener(getTableModelListener());
        }
        else if (_validValuesType.equals("Float Number")) {
          float[] range = refTag.getFloatRange();
          _lowerFloatRange = range[0];
          _upperFloatRange = range[1];
          _typeLabel.setText("\"Float Number\""+"   Range : [ "+Float.toString(_lowerFloatRange)+" , "+Float.toString(_upperFloatRange)+" ] )");
          _unitLabel.setText(refTag.getUnit()+" )");

          ((ValueTableModel)_valueTable.getModel()).isListOfStrings(false);
          ((ValueTableModel)_valueTable.getModel()).isIntegerNumber(false);
          target.cleanFloatValues();
          ValueTableModel tableModel = (ValueTableModel)_valueTable.getModel();
          for (int i = 0; i < target.getValuesCount(); i++) {
            tableModel.addTableRow((String)target.getFloatValueAt(i),target.getFloatSelectionAt(i),target.getFloatDependencyAt(i));
          }
          _valueTable.getModel().addTableModelListener(getTableModelListener());
        }
        else {}
        _locked = false;
      }
    }
    else if (message.equals("tag def changed")) {
      String changedTag = messCon.getString();
      MContextPropertyValueImpl target = null;
      if (messCon.getObject() != null) target = (MContextPropertyValueImpl)messCon.getObject();
      if ((changedTag.equals((String)_nameBox.getSelectedItem()))&&(target != null)) {
        _locked = true;
        MContextPropertyTagImpl refTag = (MContextPropertyTagImpl)_modelIterator.getContextPropertyTag(messCon.getString());

        _validValuesType = refTag.getValidValuesType();
        //_stereoBox.setSelectedItem(target.getStereoString());

        if (_validValuesType.equals("List Of Strings")) {
          _valueTable.getModel().removeTableModelListener(getTableModelListener());
          ((ValueTableModel)_valueTable.getModel()).removeAllRows();

          _validStrings = refTag.getValidStrings();
          _typeLabel.setText("\"List Of Strings\"   [ "+Integer.toString(_validStrings.size())+" defined strings ] )");
          _unitLabel.setText("N/A )");

          ((ValueTableModel)_valueTable.getModel()).isListOfStrings(true);
          ValueTableModel tableModel = (ValueTableModel)_valueTable.getModel();
          for (int i = 0; i < _validStrings.size(); i++) {
            tableModel.addTableRow((String)_validStrings.elementAt(i),target.getStringSelectionAt(i),target.getStringDependencyAt(i));
          }
          _valueTable.getModel().addTableModelListener(getTableModelListener());
        }
        else if (_validValuesType.equals("Integer Number")) {
          int[] range = refTag.getIntegerRange();

          if (!target.valueDefinitionWasChanged()) {
            _lowerIntRange = range[0];
            _upperIntRange = range[1];
            _typeLabel.setText("\"Integer Number\""+"   Range : [ "+Integer.toString(_lowerIntRange)+" , "+Integer.toString(_upperIntRange)+" ] )");
            _unitLabel.setText(refTag.getUnit()+" )");
            _locked = false;
            return;
          }

          _valueTable.getModel().removeTableModelListener(getTableModelListener());
          ((ValueTableModel)_valueTable.getModel()).removeAllRows();

          _lowerIntRange = range[0];
          _upperIntRange = range[1];
          _typeLabel.setText("\"Integer Number\""+"   Range : [ "+Integer.toString(_lowerIntRange)+" , "+Integer.toString(_upperIntRange)+" ] )");
          _unitLabel.setText(refTag.getUnit()+" )");

          ((ValueTableModel)_valueTable.getModel()).isListOfStrings(false);
          ((ValueTableModel)_valueTable.getModel()).isIntegerNumber(true);
          target.cleanIntegerValues();
          ValueTableModel tableModel = (ValueTableModel)_valueTable.getModel();
          for (int i = 0; i < target.getValuesCount(); i++) {
            tableModel.addTableRow((String)target.getIntegerValueAt(i),target.getIntegerSelectionAt(i),target.getIntegerDependencyAt(i));
          }
          _valueTable.getModel().addTableModelListener(getTableModelListener());
        }
        else if (_validValuesType.equals("Float Number")) {
          float[] range = refTag.getFloatRange();

          if (!target.valueDefinitionWasChanged()) {
            _lowerFloatRange = range[0];
            _upperFloatRange = range[1];
            _typeLabel.setText("\"Float Number\""+"   Range : [ "+Float.toString(_lowerFloatRange)+" , "+Float.toString(_upperFloatRange)+" ] )");
            _unitLabel.setText(refTag.getUnit()+" )");
            _locked = false;
            return;
          }

          _valueTable.getModel().removeTableModelListener(getTableModelListener());
          ((ValueTableModel)_valueTable.getModel()).removeAllRows();

          _lowerFloatRange = range[0];
          _upperFloatRange = range[1];
          _typeLabel.setText("\"Float Number\""+"   Range : [ "+Float.toString(_lowerFloatRange)+" , "+Float.toString(_upperFloatRange)+" ] )");
          _unitLabel.setText(refTag.getUnit()+" )");

          ((ValueTableModel)_valueTable.getModel()).isListOfStrings(false);
          ((ValueTableModel)_valueTable.getModel()).isIntegerNumber(false);
          target.cleanFloatValues();
          ValueTableModel tableModel = (ValueTableModel)_valueTable.getModel();
          for (int i = 0; i < target.getValuesCount(); i++) {
            tableModel.addTableRow((String)target.getFloatValueAt(i),target.getFloatSelectionAt(i),target.getFloatDependencyAt(i));
          }
          _valueTable.getModel().addTableModelListener(getTableModelListener());
        }
        else {}
        _locked = false;
      }
    }
    else if (message.equals("tag removed")) {
      _nameBox.removeItemAt(messCon.getInt());
    }
    else if (message.equals("focus gained")) {
		 //System.out.println("HALLO?  1\n");
      // natürlich springen zeitgleich die ActionListener von
      // _nameBox und _stereoBox an und machen Blödsinn; das unterbinden wir mit der
      // _locked-Variable -> nicht schön, tut's aber prima ...
      _locked = true; // actionPerformed() von _nameBox blockiert
      ProjectBrowser pb = ProjectBrowser.TheInstance;
      if (pb.getDetailsTarget() instanceof MContextPropertyValueImpl) {
			//System.out.println("HALLO?  2\n");
        MContextPropertyValueImpl target = (MContextPropertyValueImpl)messCon.getObject();
        target.resetFigureColor();
        MContextPropertyTagImpl refTag = (MContextPropertyTagImpl)_modelIterator.getContextPropertyTag(messCon.getString());

        _nameBox.setSelectedItem(messCon.getString()); // throws ActionEvent !!!
        _validValuesType = refTag.getValidValuesType();
        _stereoBox.setSelectedItem(target.getStereoString()); // throws ActionEvent !!!

        _valueTable.getModel().removeTableModelListener(getTableModelListener());
        ((ValueTableModel)_valueTable.getModel()).removeAllRows();

        if (_validValuesType.equals("List Of Strings")) {
			  //System.out.println("HALLO?  3  // \n"+refTag.getValidStrings().size());
          _validStrings = refTag.getValidStrings();
          _typeLabel.setText("\"List Of Strings\"   [ "+Integer.toString(_validStrings.size())+" defined strings ] )");
          _unitLabel.setText("N/A )");

          ((ValueTableModel)_valueTable.getModel()).isListOfStrings(true);
          ValueTableModel tableModel = (ValueTableModel)_valueTable.getModel();
          for (int i = 0; i < _validStrings.size(); i++) {
				 //System.out.println("addTableRow(" +
				 //						  (String)_validStrings.elementAt(i)+ ", " +
				 //						  target.getStringSelectionAt(i)+ ", " +
				 //						  target.getStringDependencyAt(i)+ ")");
            tableModel.addTableRow((String)_validStrings.elementAt(i),target.getStringSelectionAt(i),target.getStringDependencyAt(i));
          }
          _valueTable.getModel().addTableModelListener(getTableModelListener());

        }
        else if (_validValuesType.equals("Integer Number")) {
          int[] range = refTag.getIntegerRange();
          _lowerIntRange = range[0];
          _upperIntRange = range[1];
          _typeLabel.setText("\"Integer Number\""+"   Range : [ "+Integer.toString(_lowerIntRange)+" , "+Integer.toString(_upperIntRange)+" ] )");
          _unitLabel.setText(refTag.getUnit()+" )");

          ((ValueTableModel)_valueTable.getModel()).isListOfStrings(false);
          ((ValueTableModel)_valueTable.getModel()).isIntegerNumber(true);
          target.cleanIntegerValues();
          ValueTableModel tableModel = (ValueTableModel)_valueTable.getModel();
          for (int i = 0; i < target.getValuesCount(); i++) {
            tableModel.addTableRow((String)target.getIntegerValueAt(i),target.getIntegerSelectionAt(i),target.getIntegerDependencyAt(i));
          }
          _valueTable.getModel().addTableModelListener(getTableModelListener());

        }
        else if (_validValuesType.equals("Float Number")) {
          float[] range = refTag.getFloatRange();
          _lowerFloatRange = range[0];
          _upperFloatRange = range[1];
          _typeLabel.setText("\"Float Number\""+"   Range : [ "+Float.toString(_lowerFloatRange)+" , "+Float.toString(_upperFloatRange)+" ] )");
          _unitLabel.setText(refTag.getUnit()+" )");

          ((ValueTableModel)_valueTable.getModel()).isListOfStrings(false);
          ((ValueTableModel)_valueTable.getModel()).isIntegerNumber(false);
          target.cleanFloatValues();
          ValueTableModel tableModel = (ValueTableModel)_valueTable.getModel();
          for (int i = 0; i < target.getValuesCount(); i++) {
            tableModel.addTableRow((String)target.getFloatValueAt(i),target.getFloatSelectionAt(i),target.getFloatDependencyAt(i));
          }
          _valueTable.getModel().addTableModelListener(getTableModelListener());

        }
        else {}
        pb.getDetailsPane().selectTabNamed("Properties");
      }
      _locked = false; // actionPerformed() von _nameBox wieder frei
    }
    else {}
  }

  public void tableChanged(TableModelEvent e) {
    int changedRow = e.getFirstRow();
    int changedCol = e.getColumn();
    ProjectBrowser pb = ProjectBrowser.TheInstance;
    MContextPropertyValueImpl target = (MContextPropertyValueImpl)pb.getDetailsTarget();
    if (_validValuesType.equals("List Of Strings")) {
      if (changedCol == 1) {
        target.negateStringSelectionAt(changedRow);
        target.actualizeFigure();
        if (target.hasSelectedValues()) target.setCPValue(target.getValueString_Horizontal());
        else target.setCPValue("no values selected or defined");
      }
      else if (changedCol == 2) {
        target.setStringDependencyAt(changedRow,(String)_valueTable.getModel().getValueAt(changedRow,2));
        target.actualizeFigure();
        if (target.hasSelectedValues()) target.setCPValue(target.getValueString_Horizontal());
        else target.setCPValue("no values selected or defined");
      }
      else {}
    }
    else if (_validValuesType.equals("Integer Number")) {
      if (changedCol == 0) {
        String value = (String)_valueTable.getModel().getValueAt(changedRow,0);
        target.setIntegerValueAt(changedRow,value);
        if (value.equals("")) {
          target.removeIntegerValueAt(changedRow);
          ((ValueTableModel)_valueTable.getModel()).removeRow(changedRow);
          if (target.getIntegerValuesCount()==0) {
            target.addEmptyIntegerValue();
            ((ValueTableModel)_valueTable.getModel()).addTableRow("",new Boolean(false),"");
            _valueTable.updateUI();
          }
        }
        if (!(target.isEmptyIntegerValue(target.getIntegerValuesCount()-1))) {
          target.addEmptyIntegerValue();
          ((ValueTableModel)_valueTable.getModel()).addTableRow("",new Boolean(false),"");
          _valueTable.updateUI();
        }
      }
      else if (changedCol == 1) {
        // das TabelModel stellt sicher, dass hier nur Action ist, wenn der eingegebene
        // Wert als Integer interpretierbar und innerhalb der Range ist !!!
        target.negateIntegerSelectionAt(changedRow);
        target.actualizeFigure();
        if (target.hasSelectedValues()) target.setCPValue(target.getValueString_Horizontal());
        else target.setCPValue("no values selected or defined");
      }
      else if (changedCol == 2) {
        target.setIntegerDependencyAt(changedRow,(String)_valueTable.getModel().getValueAt(changedRow,2));
        target.actualizeFigure();
        if (target.hasSelectedValues()) target.setCPValue(target.getValueString_Horizontal());
        else target.setCPValue("no values selected or defined");
      }
    }
    else if (_validValuesType.equals("Float Number")) {
      if (changedCol == 0) {
        String value = (String)_valueTable.getModel().getValueAt(changedRow,0);
        target.setFloatValueAt(changedRow,value);
        if (value.equals("")) {
          target.removeFloatValueAt(changedRow);
          ((ValueTableModel)_valueTable.getModel()).removeRow(changedRow);
          if (target.getFloatValuesCount()==0) {
            target.addEmptyFloatValue();
            ((ValueTableModel)_valueTable.getModel()).addTableRow("",new Boolean(false),"");
            _valueTable.updateUI();
          }
        }
        if (!(target.isEmptyFloatValue(target.getFloatValuesCount()-1))) {
          target.addEmptyFloatValue();
          ((ValueTableModel)_valueTable.getModel()).addTableRow("",new Boolean(false),"");
          _valueTable.updateUI();
        }
      }
      else if (changedCol == 1) {
        // das TabelModel stellt sicher, dass hier nur Action ist, wenn der eingegebene
        // Wert als Float interpretierbar und innerhalb der Range ist !!!
        target.negateFloatSelectionAt(changedRow);
        target.actualizeFigure();
        if (target.hasSelectedValues()) target.setCPValue(target.getValueString_Horizontal());
        else target.setCPValue("no values selected or defined");
      }
      else if (changedCol == 2) {
        target.setFloatDependencyAt(changedRow,(String)_valueTable.getModel().getValueAt(changedRow,2));
        target.actualizeFigure();
        if (target.hasSelectedValues()) target.setCPValue(target.getValueString_Horizontal());
        else target.setCPValue("no values selected or defined");
      }
    }
    else {}
  }

  // Selbstreferenz (siehe actionPerformed() im Konstruktor... )
  private TableModelListener getTableModelListener() {
    return(this);
  }

  //////////////////////////////////////////////////////////////////////////////
  // ----- ValueTableModel -----
  class ValueTableModel extends DefaultTableModel {

    private boolean _isListOfStrings = false;
    private boolean _isIntegerNumber = true;

    public ValueTableModel() {
      super();
      addColumn("Valid Tag Values");
      addColumn("?");
      addColumn("Dependency");
    }

    public void addTableRow(String value, Boolean selection, String dependency) {
      Object[] newRow = new Object[3];
      newRow[0] = value;
      newRow[1] = selection;
      newRow[2] = dependency;
      addRow(newRow);
    }

    public Class getColumnClass(int columnIndex) {
      if (columnIndex == 1) return(Boolean.class);
      else return(Object.class);
    }

    public boolean isCellEditable(int r, int c) {
      if (_isListOfStrings) {
        if (c==0) return(false);
        else return(true);
      }
      else {
        if (c==0) {
          if (((Boolean)this.getValueAt(r,1)).booleanValue()) return(false);
          else return(true);
        }
        else if (c==1) {
          if (_isIntegerNumber) {
            try {
              int intTest = Integer.parseInt((String)this.getValueAt(r,0));
            }
            catch (NumberFormatException nfe) {
              JOptionPane.showMessageDialog(null,"\""+(String)this.getValueAt(r,0)+"\" is not an integer value !");
              return(false);
            }
            int rangeTest = Integer.parseInt((String)this.getValueAt(r,0));
            if ((rangeTest >= _lowerIntRange)&&(rangeTest <= _upperIntRange)) return(true);
            else {
              JOptionPane.showMessageDialog(null,"The value \""+rangeTest+"\" is out of range !");
              return(false);
            }
          }
          else { // Float Number
            try {
              float floatTest = Float.parseFloat((String)this.getValueAt(r,0));
            }
            catch (NumberFormatException nfe) {
              JOptionPane.showMessageDialog(null,"\""+(String)this.getValueAt(r,0)+"\" is not an float value !");
              return(false);
            }
            float rangeTest = Float.parseFloat((String)this.getValueAt(r,0));
            if ((rangeTest >= _lowerFloatRange)&&(rangeTest <= _upperFloatRange)) return(true);
            else {
              JOptionPane.showMessageDialog(null,"The value \""+rangeTest+"\" is out of range !");
              return(false);
            }
          }
        }
        else if (c==2) {
          return(true);
        }
        else return(false);
      }
    }

    public void removeAllRows() {
      for (int i = getRowCount()-1; i >= 0 ; i--) {
        removeRow(i);
      }
    }

    public void isListOfStrings(boolean val) {
      _isListOfStrings = val;
    }
    public void isIntegerNumber(boolean val) {
      _isIntegerNumber = val;
    }
  }
  // ----- ValueTableModel -----
  //////////////////////////////////////////////////////////////////////////////

}
