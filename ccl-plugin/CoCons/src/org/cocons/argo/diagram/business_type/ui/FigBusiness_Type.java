// Author: shicathy

package org.cocons.argo.diagram.business_type.ui;

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

public class FigBusiness_Type extends FigClass {


  ////////////////////////////////////////////////////////////////
  // constructors

  public FigBusiness_Type() {
    super();
    _stereo.setEditable(false);
    _stereo.setDisplayed(true);
    //getOperationsFig().setDisplayed(false);
  }

  public FigBusiness_Type(GraphModel gm, Object node) {
    super(gm,node);

    //getOperationsFig().setDisplayed(false);
  }


  public Vector getPopUpActions(MouseEvent me) {

    Vector popUpActions = super.getPopUpActions(me);
    JMenu addMenu = new JMenu("Add");
    addMenu.add(ActionAddAttribute.SINGLETON);
    JMenu copyAsInfoMenu = CopyAsInfoMenu.getJMenu();
    popUpActions.insertElementAt(copyAsInfoMenu, popUpActions.size() - 1);
    popUpActions.insertElementAt(addMenu, popUpActions.size() - 1);
    ContextViewPopUpMenu.getPopUpActions(popUpActions);
    return popUpActions;
  }

  ////////////////////////////////////////////////////////////////
  // accessors

  public Selection makeSelection() {
    return null;
 //   return new SelectionBusiness_Type(this);
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
