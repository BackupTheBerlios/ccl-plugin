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

public class FigInfoType extends FigClass {


  ////////////////////////////////////////////////////////////////
  // constructors

  public FigInfoType() {
    super();
    _stereo.setEditable(false);
    getOperationFig().setDisplayed(false);
  }

  public FigInfoType(GraphModel gm, Object node) {
    super(gm,node);
    _stereo.setEditable(false);
    getOperationFig().setDisplayed(false);
  }

  public Vector getPopUpActions(MouseEvent me) {

    Vector popUpActions = super.getPopUpActions(me);
    ContextViewPopUpMenu.getPopUpActions(popUpActions);
    Object owner = this.getOwner();
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
  }
}
