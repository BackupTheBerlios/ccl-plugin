package org.cocons.argo.ui;

import java.awt.*;
import javax.swing.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import org.argouml.uml.ui.*;

import javax.swing.*;

import org.tigris.gef.util.*;

import org.argouml.uml.ui.foundation.core.*;
import org.argouml.uml.ui.*;

/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Alex Bork
 * @version 1.0
 */

public class PropPanelBusiness_Type extends PropPanelClassifier {

  protected static ImageIcon _business_TypeIcon = ResourceLoader.lookupIconResource("Business_Type");

  public PropPanelBusiness_Type() {
    super("Business Type", _business_TypeIcon, 3);

    //
    //   this will cause the components on this page to be notified
    //      anytime a stereotype, namespace, operation, etc
    //      has its name changed or is removed anywhere in the model
    Class[] namesToWatch = { MStereotype.class,MNamespace.class,MAttribute.class,MAssociation.class,MClassifier.class };
    setNameEventListening(namesToWatch);

    addCaption("Name:",1,0,0);
    addField(nameField,1,0,0);

    addCaption("Stereotype:",2,0,0);
    addField(new UMLComboBoxNavigator(this,"NavStereo",stereotypeBox),2,0,0);

    addCaption("Namespace:",3,0,0);
    addField(namespaceScroll,3,0,0);

    addCaption("Extends:",4,0,0);
    addField(extendsScroll,4,0,0);

    addCaption("Associations:",0,1,0);
    addField(connectScroll,0,1,0.5);

    addCaption("Attributes:",1,2,0.4);
    addField(attrScroll,1,2,0.4);

    new PropPanelButton(this,buttonPanel,_navUpIcon,localize("Go up"),"navigateNamespace",null);
    new PropPanelButton(this,buttonPanel,_navBackIcon,localize("Go back"),"navigateBackAction","isNavigateBackEnabled");
    new PropPanelButton(this,buttonPanel,_navForwardIcon,localize("Go forward"),"navigateForwardAction","isNavigateForwardEnabled");
    new PropPanelButton(this,buttonPanel,_addAttrIcon,localize("Add attribute"),"addAttribute",null);
  }

  protected boolean isAcceptibleBaseMetaClass(String baseClass) {
      return baseClass.equals("Business_Type");
  }




    public boolean isAcceptibleStereotype(MModelElement element) {
        boolean isAcceptible = false;
	if(element instanceof MStereotype) {
	    String stereoName = ((MStereotype) element).getName();
	    isAcceptible = (stereoName.equals("type") || stereoName.equals("util"));
	}
        return isAcceptible;
    }
}
