/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Camara Lenuseni (c)2003
 * @version 1.1
 */
package org.cocons.argo.ui;

import org.argouml.uml.ui.foundation.core.*;
import org.argouml.uml.ui.foundation.core.PropPanelModelElement.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import org.argouml.application.api.*;
import org.argouml.uml.ui.*;

import org.tigris.gef.util.*;
import java.util.*;

import org.cocons.uml.ccl.*;

abstract public class PropPanelModelElementCoCons extends PropPanel{

	protected JTextField targetsetField;    
    protected JTextField coconNameField;
    protected JComboBox coconTypeList;
    protected JComboBox conditionTypeList;
    protected JTextField scopesetField;
    protected JTextField attributeField;
        
    /* Camara L.
     * This is Field contains the 21 Cocontypes defined by Felix Bübl. in Bericht-Nr.2002-20, ISSN 1436-9915
     * The Context-Based Constraint Language CCL for Components
     */
    public static final String[] coconTypeName = 
    								{"ACCESSIBLE TO",
                                     " READABLE BY",
                                      "WRITEABLE BY",
                                      "EXECUTEABLE BY",
                                      "THE SAME AS",
                                      "REMOVEABLE BY",
                                      "ALLOCATED TO",
                                      "SYNCHRONOUSLY REPLICATED TO",
                                      "ASYNCHRONOUSLY REPLICATED TO",
                                      "THE SAME AS",
                                      "FULFILLING THE CONTEXT CONDITION OF",
                                      "ENCRYPTED WHEN CALLING",
                                      "ERRORHANDLED WHEN CALLING",
                                      "LOGGED WHEN CALLING",
                                      "REDIRECTED WHEN CALLING",
                                      "PROTECTED BY A TRANSACTION WHEN CALLING",
                                      "ASYSNCHRONOUSLY CALLING",
                                      "SYSNCHRONOUSLY CALLING",
                                      "INFORMED OF",
                                      "AS INTERESTING AS",
                                      "AVAILABLE TO ANYONE INTERESTED IN"                                     
                                      };
   /*
    * Camara L.
    * This field contains the two type condition defined by F. Bübl in CCL for Components
    */
   public static final String[] ConditionType = {"","ONLY","NOT"};
    
    ////////////////////////////////////////////////////////////////
    // constructors
    public PropPanelModelElementCoCons(String name, int columns) {
        this(name,null,columns);
    }

    public PropPanelModelElementCoCons(String name, ImageIcon icon, int columns) {
        super(name,icon,columns);

        Class mclass = MContextbasedConstraintImpl.class;
        
        coconNameField = new UMLTextField(this,new UMLTextProperty(mclass,"coconNameField","getCoConName","setCoConName"));
        targetsetField = new UMLTextField(this,new UMLTextProperty(mclass,"targetsetField","getTargetSet","setTargetSet"));
        scopesetField = new UMLTextField(this,new UMLTextProperty(mclass,"scopesetField","getScopeSet","setScopeSet"));
        conditionTypeList = new UMLComboBox2(this,new UMLConditionTypeComboBoxModel(this),ActionSetConditionType.SINGLETON);
        coconTypeList = new UMLComboBox2(this,new UMLCoConTypeComboBoxModel(this), ActionSetCoConType.SINGLETON);
        attributeField = new UMLTextField(this,new UMLTextProperty(mclass,"attributtField","getAttribute","setAttribute"));
           }

    public void navigateUp() {
        Object target = getTarget();
        if(target instanceof MModelElement) {
            MNamespace namespace = ((MModelElement) target).getNamespace();
            if(namespace != null) {
                navigateTo(namespace);
            }
        }
    }

    public void addRealization() {
        Object target = getTarget();
        if(target instanceof MModelElement) {
            MModelElement modelElement = (MModelElement) target;
            MNamespace ns = modelElement.getNamespace();
            if(ns != null) {
//                MGeneralization newGen = ns.getFactory().createGeneralization();
//                if(newGen != null) {
//                    newGen.addSpecialization(genElem);
//                    ns.addOwnedElement(newGen);
//                    navigateTo(newGen);
//                }
            }
        }
    }

    public void addDataType() {
        Object target = getTarget();
        if(target instanceof MNamespace) {
            MNamespace ns = (MNamespace) target;
            MModelElement ownedElem = ns.getFactory().createDataType();
            ns.addOwnedElement(ownedElem);
            navigateTo(ownedElem);
        }
    }

    public void navigateNamespace() {
        Object target = getTarget();
        if(target instanceof MModelElement) {
            MModelElement elem = (MModelElement) target;
            MNamespace ns = elem.getNamespace();
            if(ns != null) {
                navigateTo(ns);
            }
        }
    }

    //
    // Pluggable Property Panel support
    //
    // THIS CLASS MUST NOT IMPLEMENT PluggablePropertyPanel.  These
    // are present to provide default implementations for any
    // property panel that extends this class.
    public PropPanel getPropertyPanel() { return this; }
    public boolean isModuleEnabled() { return true; }
    public Vector getModulePopUpActions(Vector v, Object o) { return null; }
    public boolean shutdownModule() { return true; }
    public boolean initializeModule() {
        ArgoModule.cat.debug("initializeModule()");
        return true;
    }
    public void setModuleEnabled(boolean enabled) { }
    public boolean inContext(Object[] o) { return true; }
}

