// Author: shicathy

package org.cocons.argo.diagram.interface_spec.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.model_management.*;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;

import org.argouml.application.api.*;
import org.argouml.uml.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.generator.*;
import org.argouml.uml.diagram.ui.*;
import org.argouml.ui.*;
import org.argouml.uml.diagram.static_structure.ui.*;

import org.cocons.argo.diagram.business_type.ui.KnownBusinessTypes;
import org.cocons.argo.diagram.ui.ContextViewPopUpMenu;

public class FigInterface_Spec extends FigClass {


  ////////////////////////////////////////////////////////////////
  // constructors

  public FigInterface_Spec() {
    super();


    _stereo.setEditable(false);
    _stereo.setDisplayed(true);

    //_stereoLineBlinder = new FigRect(10, 15, 2, 60, Color.white, Color.white);
    //_stereoLineBlinder.setLineWidth(2);
    //_stereoLineBlinder.setDisplayed(true);

  }

  public FigInterface_Spec(GraphModel gm, Object node) {
    //this();
    super(gm,node);

    /*
    setOwner(node);
    if (node instanceof MClassifier && (((MClassifier)node).getName() != null))
	  _name.setText(((MModelElement)node).getName());
*/

    /*MStereotype stereo = ((MModelElement) node).getStereotype();
    if (stereo == null){
	  stereo = new MStereotypeImpl();
      stereo.setName("interface spec");
	  ((MModelElement) node).setStereotype(stereo);
    }*/
    //((MModelElement) node).getStereotype().setName("interface spec");
  }

  public Vector getPopUpActions(MouseEvent me) {

    Vector popUpActions = super.getPopUpActions(me);
    ContextViewPopUpMenu.getPopUpActions(popUpActions);
    Object owner = this.getOwner();
    System.err.println("StereoType name: "+((MClass)owner).getStereotype().getName());
    if (owner instanceof MClass &&
        ((MClass)owner).getStereotype().getName().equals("info type")) {
        System.err.println("BTmenu...");
        popUpActions.add(KnownBusinessTypes.getJMenu());
    }

    return popUpActions;
  }

  ////////////////////////////////////////////////////////////////
  // accessors

  public Selection makeSelection() {
     return null;
//    return new SelectionInterface_Spec(this);
  }

/*
  // internal Methods
  protected void textEdited(FigText ft) throws PropertyVetoException {
    super.textEdited(ft);

    MModelElement me = (MModelElement) getOwner();
    if (me == null) return;
    if ( me.getStereotype() == null ) return;

    if (ft == _stereo) {
      String s = ft.getText();
      if ( ! (me.getStereotype().getName().equals(s)) )
        me.getStereotype().setName(s);
    }
  }


  ////////////////////////////////////////////////////////////////
  // user interaction methods

  /*public void mousePressed(MouseEvent me) {
    super.mousePressed(me);
    Editor ce = Globals.curEditor();
    Selection sel = ce.getSelectionManager().findSelectionFor(this);
    if (sel instanceof SelectionInterface_Spec)
      ((SelectionInterface_Spec)sel).hideButtons();
  }*/


}
