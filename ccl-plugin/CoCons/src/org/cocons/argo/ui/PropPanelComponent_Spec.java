package org.cocons.argo.ui;

import javax.swing.*;

import org.tigris.gef.util.*;

import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
import org.argouml.uml.ui.*;



public class PropPanelComponent_Spec extends PropPanelModelElement {

  protected static ImageIcon _Component_SpecIcon = ResourceLoader.lookupIconResource("ComponentSpecification");

  public PropPanelComponent_Spec() {
    super("Component_Spec",_Component_SpecIcon, 3);

    addCaption("Name:",1,0,0);
    addField(nameField,1,0,0);

    addCaption("Stereotype:",2,0,0);
    //    stereotypeBox.setEnabled(false);
    addField(new UMLComboBoxNavigator(this,"NavStereo",stereotypeBox),2,0,0);

    addCaption("Namespace:",3,0,0);
    addField(namespaceScroll,3,0,0);

  }

  protected boolean isAcceptibleBaseMetaClass(String baseClass) {
      return baseClass.equals("ComponentSpecification");
  }
}