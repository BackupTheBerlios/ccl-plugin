// File: ContextViewPopUpMenue.java
// Classes: FigBusiness_Type
// Original Author: jgusulde
// $Id: ContextViewPopUpMenu.java,v 1.1 2001/12/05 06:51:02 jgusulde Exp $

package org.cocons.argo.diagram.ui;

import java.util.*;
import java.awt.event.*;

import java.beans.*;
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
import org.argouml.uml.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.generator.*;
import org.argouml.uml.diagram.ui.*;

import org.argouml.ui.*;


public class ContextViewPopUpMenu{


/*  public static void getPopUpActions(MouseEvent me,Object owner){
    Vector popUpActions = super.getPopUpActions(me);
    this.getPopUpActions(popUpActions);
  }
*/

  public static void getPopUpActions(Vector popUpActions) {
    System.out.println("<--jan: getPopUpActions(Vector) aufgerufen  -->");
    JMenu CCLMenu = new JMenu("CoCons");
    //CCLMenu.add(ActionAddAttribute.SINGLETON);

    // die Strings sollen nach und nach durch Action Elemente ersetzt werden!!
    CCLMenu.add(new ActionAddContextProperty());
    CCLMenu.addSeparator();
    // die Strings sollen nach und nach durch Action Elemente ersetzt werden!!
    CCLMenu.add("Add Context Property to this Model Element");
    CCLMenu.add("Define CoCon for this Model Element");
    CCLMenu.add("Auto Layout The Context Properties of this Model Element");
    CCLMenu.add("Context Specific View");
    CCLMenu.add("Context Property Definition");
    JMenu showHideMenu = new JMenu("Show/Hide");
    showHideMenu.add(new JRadioButtonMenuItem("Constrained Elements",true));
    showHideMenu.add(new JRadioButtonMenuItem("Scope Elements",true));
    showHideMenu.add(new JRadioButtonMenuItem("Conflicting CoCons",true));
    showHideMenu.add(new JRadioButtonMenuItem("Belongs-To Releation",true));
    CCLMenu.add("Set Context Property Values");
    CCLMenu.add("Help");
    CCLMenu.add(showHideMenu);

    popUpActions.insertElementAt(CCLMenu, popUpActions.size() - 1);
    //return popUpActions;
  }


} /* end class ContextViewPopUpMenue */
