package org.cocons.argo.diagram.component_spec.ui.tests;

/**
 * Title: TestCopyComponent
 * Description: Testklasse fuer die CopyToDeploymentDiagram und CopyAsComponentInstance
 * Copyright:    Copyright (c) 2002
 * Company: TU-Berlin, CIS
 * @author Sundui Baatarjav
 * @author Simo Nasri
 * @version 1.0
 */

import org.cocons.argo.diagram.component_spec.ui.*;
import org.argouml.ui.*;
import org.argouml.kernel.*;
import junit.framework.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import javax.swing.*;
import java.awt.*;

import org.argouml.application.api.*;
import org.argouml.util.*;

// Testklasse fuer die CopyToDeploymentDiagram und CopyAsComponentInstance
public class TestCopyComponent extends TestCase {

    public TestCopyComponent(String name) {
        super(name);
    }


    public void setUp() {

    }

    public void tearDown() {
    }

    public void testMenu() {

        JMenu value = CopyToDeploymentDiagram.getJMenu();
        final String text ="copy to DeploymentDiagram as ComponentType";
        JMenu expected = new JMenu(text);
        assertEquals (expected, value );
         }
    public static void main(String[] args) {
    junit.swingui.TestRunner.run(TestCopyComponent.class);
  }

    public static Test suite() {
        TestSuite suite=new TestSuite();
        suite.addTest(new TestCopyComponent("testMenu") );
        return suite;
    }

}