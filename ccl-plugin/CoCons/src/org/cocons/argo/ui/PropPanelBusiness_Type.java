package org.cocons.argo.ui;

import javax.swing.*;

import org.tigris.gef.util.*;

import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
import org.argouml.uml.ui.*;

/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Alex Bork
 * @version 1.0
 */

public class PropPanelBusiness_Type extends PropPanelModelElement {

  protected static ImageIcon _business_TypeIcon = ResourceLoader.lookupIconResource("Class");

  public PropPanelBusiness_Type() {
    super("Class", _business_TypeIcon, 3);

    addCaption("Name:",1,0,0);
    addField(nameField,1,0,0);

    addCaption("Stereotype:",2,0,0);
    addField(new UMLComboBoxNavigator(this,"NavStereo",stereotypeBox),2,0,0);

    addCaption("Namespace:",3,0,0);
    addField(namespaceScroll,3,0,0);

  }

  protected boolean isAcceptibleBaseMetaClass(String baseClass) {
      return baseClass.equals("Class");
  }
}
