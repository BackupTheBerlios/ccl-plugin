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

abstract public class PropPanelModelElementCoCons extends PropPanel {

    ////////////////////////////////////////////////////////////////
    // constants

    protected static ImageIcon _objectIcon = ResourceLoader.lookupIconResource("Object");
    protected static ImageIcon _componentInstanceIcon = ResourceLoader.lookupIconResource("ComponentInstance");
    protected static ImageIcon _nodeInstanceIcon = ResourceLoader.lookupIconResource("NodeInstance");
    protected static ImageIcon _instanceIcon = ResourceLoader.lookupIconResource("Instance");
    protected static ImageIcon _linkIcon = ResourceLoader.lookupIconResource("Link");
    protected static ImageIcon _stimulusIcon = ResourceLoader.lookupIconResource("Stimulus");
    protected static ImageIcon _associationIcon = ResourceLoader.lookupIconResource("Association");
    protected static ImageIcon _assocEndIcon = ResourceLoader.lookupIconResource("AssociationEnd");
    protected static ImageIcon _generalizationIcon = ResourceLoader.lookupIconResource("Generalization");
    protected static ImageIcon _realizationIcon = ResourceLoader.lookupIconResource("Realization");
    protected static ImageIcon _classIcon = ResourceLoader.lookupIconResource("Class");
    protected static ImageIcon _interfaceIcon = ResourceLoader.lookupIconResource("Interface");
    protected static ImageIcon _addOpIcon = ResourceLoader.lookupIconResource("AddOperation");
    protected static ImageIcon _addAttrIcon = ResourceLoader.lookupIconResource("AddAttribute");
    protected static ImageIcon _addAssocIcon = ResourceLoader.lookupIconResource("Association");
    protected static ImageIcon _packageIcon = ResourceLoader.lookupIconResource("Package");
    protected static ImageIcon _modelIcon = ResourceLoader.lookupIconResource("Model");
    protected static ImageIcon _innerClassIcon = ResourceLoader.lookupIconResource("InnerClass");
    protected static ImageIcon _nodeIcon = ResourceLoader.lookupIconResource("Node");
    protected static ImageIcon _componentIcon = ResourceLoader.lookupIconResource("Component");
    protected static ImageIcon _dataTypeIcon = ResourceLoader.lookupIconResource("DataType");
    protected static ImageIcon _actorIcon = ResourceLoader.lookupIconResource("Actor");
    protected static ImageIcon _useCaseIcon = ResourceLoader.lookupIconResource("UseCase");
    protected static ImageIcon _dependencyIcon = ResourceLoader.lookupIconResource("Dependency");
    protected static ImageIcon _parameterIcon = ResourceLoader.lookupIconResource("Parameter");
    protected static ImageIcon _operationIcon = ResourceLoader.lookupIconResource("Operation");
    protected static ImageIcon _signalIcon = ResourceLoader.lookupIconResource("SignalSending");
    protected static ImageIcon _stereotypeIcon = ResourceLoader.lookupIconResource("Stereotype");
    protected static ImageIcon _guardIcon = ResourceLoader.lookupIconResource("Guard");
    protected static ImageIcon _transitionIcon = ResourceLoader.lookupIconResource("Transition");
    protected static ImageIcon _classifierRoleIcon = ResourceLoader.lookupIconResource("ClassifierRole");
    protected static ImageIcon _associationRoleIcon = ResourceLoader.lookupIconResource("AssociationRole");
    protected static ImageIcon _callActionIcon = ResourceLoader.lookupIconResource("CallAction");

    protected JTextField targetsetField;
    protected UMLTextField coconsField;
    protected JTextField scopesetField;
    protected JTextField attributeField;
    protected JComboBox coconTypeList;
    private String[] coconTypeName = {"UNWRITEABLEBY",
                                      "WRITEABLEBY",
                                      "UNREADABLEBY",
                                      "READABLEBY",
                                      "ONLYWRITEABLEBY",
                                      "ONLYREADABLEBY"};
    private Hashtable cocons;
    ////////////////////////////////////////////////////////////////
    // constructors
    public PropPanelModelElementCoCons(String name, int columns) {
        this(name,null,columns);
    }

    public PropPanelModelElementCoCons(String name, ImageIcon icon, int columns) {
        super(name,icon,columns);

        Class mclass = MContextbasedConstraintImpl.class;

        targetsetField = new JTextField();
        coconsField = new UMLTextField(this,new UMLTextProperty(mclass,"coconstypeField","getName","setName"));
        scopesetField = new JTextField();
        coconTypeList = new JComboBox();
        attributeField = new JTextField();
        cocons = new Hashtable();
        cocons.put("targetset","TargetSet");
        cocons.put("scopeset","ScopeSet");
        cocons.put("cocontype","MUST BE ");
        cocons.put("attribute","Attribute");
        for (int i =0; i<coconTypeName.length; i++){
            coconTypeList.addItem(coconTypeName[i]);

        }

        targetsetField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            }
            public void focusLost(FocusEvent e){
                String newSelected = (String) targetsetField.getText();
                cocons.remove("targetset");
                cocons.put("targetset",newSelected);
                coconsField.setText(cocons.get("targetset")+ ";" + cocons.get("cocontype")+ ";" + cocons.get("scopeset")+ ";" + cocons.get("attribute") + ";");

            }
        });

        coconTypeList.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                String newSelected = (String) coconTypeList.getSelectedItem();
                cocons.remove("cocontype");
                cocons.put("cocontype",("MUST BE " +newSelected));
                coconsField.setText(cocons.get("targetset")+ ";" + cocons.get("cocontype")+ ";" + cocons.get("scopeset")+ ";" + cocons.get("attribute") + ";");
            }
        });

        scopesetField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            }
            public void focusLost(FocusEvent e){
                String newSelected = (String) scopesetField.getText();
                cocons.remove("scopeset");
                cocons.put("scopeset",newSelected);
                coconsField.setText(cocons.get("targetset")+ ";" + cocons.get("cocontype")+ ";" + cocons.get("scopeset")+ ";" + cocons.get("attribute") + ";");

            }
        });

        attributeField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            }
            public void focusLost(FocusEvent e){
                String newSelected = (String) attributeField.getText();
                cocons.remove("attribute");
                cocons.put("attribute",newSelected);
                coconsField.setText(cocons.get("targetset")+ ";" + cocons.get("cocontype")+ ";" + cocons.get("scopeset")+ ";" + cocons.get("attribute") + ";");

            }
        });


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
