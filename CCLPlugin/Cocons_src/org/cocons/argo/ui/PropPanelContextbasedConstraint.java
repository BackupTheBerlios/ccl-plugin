package org.cocons.argo.ui;

import javax.swing.*;

import org.tigris.gef.util.*;
import org.argouml.uml.ui.*;

/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001-2002
 * Company:      TU Berlin, CIS
 * @author       Nghia Dang Duc modify
 * @author Camara Lenuseni (c)2003
 * @version 0.1
 */

public class PropPanelContextbasedConstraint extends PropPanelModelElementCoCons {

  protected static ImageIcon _contextbasedConstraintIcon = ResourceLoader.lookupIconResource("ContextbasedConstraint");


  public PropPanelContextbasedConstraint() {

    super("ContextbasedConstraint",_contextbasedConstraintIcon, 1);

    addCaption("   Coconname",1,0,0);
    addField(this.coconNameField,1,0,0);
    
    addCaption("   TargetSet:",2,0,0);
    addField(targetsetField,2,0,0);
	
	addCaption("   TypeCondition:",3,0,0);
    addField(conditionTypeList,3,0,0);
    
    addCaption("   CoconType:",4,0,0);
    addField(coconTypeList,4,0,0);

    addCaption("   ScopeSet:",5,0,0);
    addField(scopesetField,5,0,0);

    addCaption("   Attribute:",6,0,0);
    addField(attributeField,6,0,0);
  }

  protected boolean isAcceptibleBaseMetaClass(String baseClass) {
      return baseClass.equals("ContextbasedConstraint");
  }
}