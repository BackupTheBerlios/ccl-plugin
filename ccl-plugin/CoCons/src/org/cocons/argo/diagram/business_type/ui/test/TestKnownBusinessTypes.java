package org.cocons.argo.diagram.business_type.ui.test;

// File: TestKnownBusinessTypes.java
// Classes: TestKnownBusinessTypes
// Original Author: klischat@cs.tu-berlin.de
// $Id: TestKnownBusinessTypes.java,v 1.4 2002/10/10 14:06:01 oetker Exp $


import org.cocons.argo.diagram.business_type.ui.*;
import org.argouml.ui.*;
import org.argouml.kernel.*;
import junit.framework.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import javax.swing.*;
import java.awt.*;

import org.argouml.application.api.*;
import org.argouml.util.*;

//TODO: beware: doesn't work yet:
//NullPointerException in
//org.argouml.uml.ui.UMLComboBoxNavigator.<init>(UMLComboBoxNavigator.java:60)
//somehow, GEF doesn't seem to find its resources/images?
public class TestKnownBusinessTypes extends TestCase {

    public TestKnownBusinessTypes(String name) {
        super(name);
    }

    private MClass targetMClass;

    public void setUp() {
        //set up a "faked" ArgoUML application environment
        //so the KnownBusinessType methods we want to test
        //can run properly

        Configuration.load();
        String directory = Argo.getDirectory();
        System.err.println("GEF directory = "+directory);
        org.tigris.gef.base.Globals.setLastDirectory(directory);
        //org.argouml.util.Tools.logVersionInfo();

        new ProjectBrowser("JUnitFakeApp", new StatusBar(),0); //puts itself into ProjectBrowser.TheInstance
        /*Project project = */ProjectBrowser.TheInstance.getProject();  //creates a new project
        targetMClass = new MClassImpl();
        targetMClass.setName("TargetClass");
        ProjectBrowser.TheInstance.setDetailsTarget(targetMClass);
    }

    public void tearDown() {
    }

    public void testAddBelongsTo() {
	/*
	  final String otherMClassName = "OtherClass";
	  
	  MClass otherMClass = new MClassImpl();
	  otherMClass.setName(otherMClassName);
	  
	  KnownBusinessTypes.add(otherMClass);
	  
	  JMenu menu = KnownBusinessTypes.getJMenu();
	  assertTrue(menu.getMenuComponentCount() == 3);
	  
	  Component i0 = menu.getMenuComponent(0);
	  Component i1 = menu.getMenuComponent(1);
	  Component i2 = menu.getMenuComponent(2);
	  
	  assertTrue(i0 instanceof JMenuItem);
	  assertTrue(i1 instanceof JSeparator);
	  assertTrue(i2 instanceof JMenuItem);
	  assertEquals(((JMenuItem)i0).getText(),"remove belongs to");
	  assertEquals(((JMenuItem)i2).getText(),otherMClassName);
	*/	
    }	
    
    public void testRemoveBelongsTo() {
    }
    
    
    
    /**
     * Factory method to create a test suite containing all
     * individual tests.
     */
    public static Test suite() {
        TestSuite suite=new TestSuite();
        suite.addTest(new TestKnownBusinessTypes("testAddBelongsTo") );
        suite.addTest(new TestKnownBusinessTypes("testRemoveBelongsTo") );
        return suite;
    }

}
