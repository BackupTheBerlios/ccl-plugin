package org.cocons.argo.diagram.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.Vector;

import org.tigris.gef.util.ResourceLoader;

import org.argouml.uml.ui.UMLAction;
import org.argouml.ui.ProjectBrowser;
import org.argouml.kernel.Project;
import org.cocons.argo.util.ModelIterator;
import org.cocons.uml.ccl.context_property1_3.*;

import ru.novosoft.uml.foundation.core.MConstraint;
import ru.novosoft.uml.foundation.core.MConstraintImpl;
import ru.novosoft.uml.foundation.data_types.*;

/**
 * Title:        CCL-Plugin for ArgoUML
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      Technische Universität Berlin
 * @author hyshosha@gmx.de ; hasihola@cs.tu-berlin.de
 * @version 1.0
 */

public class ActionHideAllContextPropertyValues extends UMLAction {

  protected static ImageIcon _infoContextPropertyTagsIcon = ResourceLoader.lookupIconResource("HideAllContextPropertyValues");
  private ModelIterator _modelIterator = ModelIterator.SINGLETON;

  public static ActionHideAllContextPropertyValues SINGLETON = new ActionHideAllContextPropertyValues();

  public ActionHideAllContextPropertyValues() {
    super("HideAllContextPropertyValues");
  }

  ////////////////////////////////////////////////////////////////
  // main methods

  public void actionPerformed(ActionEvent ae) {
    anonymActionPerformed();
  }

  public void anonymActionPerformed() {
    Vector cpTaggedValues = _modelIterator.getAllContextPropertyValues();
    for (int i = 0; i < cpTaggedValues.size(); i++) {
      MContextPropertyValueImpl cpTaggedValue = (MContextPropertyValueImpl)cpTaggedValues.elementAt(i);
      if (cpTaggedValue.getValueVisibility()) {
        cpTaggedValue.negateValueVisibility();
        cpTaggedValue.actualizeFigure();
      }
    }
  }

}