/*
 * FigClassSpec.java
 * @version 1.0
 */
package org.cocons.argo.diagram.component_spec.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.beans.*;
import java.io.IOException;
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
import org.argouml.language.helpers.*;
import org.argouml.uml.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.generator.*;
import org.argouml.uml.diagram.ui.*;
import org.argouml.uml.diagram.static_structure.ui.*;
import org.argouml.ui.*;

import org.cocons.argo.diagram.ui.ContextViewPopUpMenu;
import org.cocons.argo.diagram.cml.ActionSaveCML;


public class FigClassSpec extends FigClass{
   protected FigRect _bigPort = new FigRect(10, 10, 90, 40, Color.cyan, Color.cyan);


    ////////////////////////////////////////////////////////////////
    // constructors

    public FigClassSpec() {
	super();
        _name.setLineWidth(1);
	_name.setFilled(true);

        addFig(_bigPort);
        Rectangle r = getBounds();
	setBounds(10, 10, 90, 40);

        getOperationsFig().setDisplayed(false);
        getAttributesFig().setDisplayed(false);
    }


    public FigClassSpec(GraphModel gm, Object node) {
    super(gm,node);

    getOperationsFig().setDisplayed(false);
    getAttributesFig().setDisplayed(false);
    }

    public Vector getPopUpActions(MouseEvent me) {
	Vector popUpActions = super.getPopUpActions(me);
        JMenu copyToDeploymentDiagram = CopyToDeploymentDiagram.getJMenu(); // ComponentType
        popUpActions.insertElementAt(copyToDeploymentDiagram, popUpActions.size() - 1); // add im Menu.
        JMenu copyAsComponentInstance = CopyAsComponentInstance.getJMenu(); // ComponentInstance.
        popUpActions.insertElementAt(copyAsComponentInstance, popUpActions.size() - 1);

        ContextViewPopUpMenu.getPopUpActions(popUpActions);
	popUpActions.add( ActionSaveCML.SINGLETON );
        

	return popUpActions;
    }
     public Selection makeSelection() {
	return null;//new SelectionMoveClarifiers(this);
    }
}

