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

public class PropPanelComponent_Spec extends PropPanelClassifier {
    
    protected static ImageIcon _Component_SpecIcon = ResourceLoader.lookupIconResource("ComponentSpecificationDiagram");
    
    public PropPanelComponent_Spec() {
	super("ComponentSpecification", _Component_SpecIcon, 3);
	
	Class[] namesToWatch = { MStereotype.class,MNamespace.class,MClassifier.class };
	setNameEventListening(namesToWatch);
	
	addCaption("Name:",1,0,0);
	addField(nameField,1,0,0);
	
	addCaption("Stereotype:",2,0,0);
	addField(new UMLComboBoxNavigator(this,"NavStereo",stereotypeBox),2,0,0);
	
	addCaption("Namespace:",3,0,0);
	addField(namespaceScroll,3,0,0);
	
	addCaption("Extends:",4,0,0);
	addField(extendsScroll,4,0,0);
	
	//addCaption("Import:",0,1,0);
	//addField(connectScroll,0,1,0.5);
	
	//addCaption("Export:",1,2,0.4);
	//addField(connectScroll,1,2,0.4);
	
	new PropPanelButton(this,buttonPanel,_navUpIcon,localize("Go up"),"navigateNamespace",null);
	new PropPanelButton(this,buttonPanel,_navBackIcon,localize("Go back"),"navigateBackAction","isNavigateBackEnabled");
	new PropPanelButton(this,buttonPanel,_navForwardIcon,localize("Go forward"),"navigateForwardAction","isNavigateForwardEnabled");
	
    }
    
    protected boolean isAcceptibleBaseMetaClass(String baseClass) {
	return baseClass.equals("Component_Spec");
    }
    
    
    
    
    public boolean isAcceptibleStereotype(MModelElement element) {
        boolean isAcceptible = false;
	if(element instanceof MStereotype) {
	    String stereoName = ((MStereotype) element).getName();
	    isAcceptible = (stereoName.equals("comp spec") || stereoName.equals("interface spec")||stereoName.equals("util"));
	}
        return isAcceptible;
    }
}









