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
 * @version 0.1
 */

public class PropPanelContextbasedConstraint extends PropPanelModelElementCoCons {

  protected static ImageIcon _contextbasedConstraintIcon = ResourceLoader.lookupIconResource("ContextbasedConstraint");


  public PropPanelContextbasedConstraint() {

    super("ContextbasedConstraint",_contextbasedConstraintIcon, 4);

    addCaption("TargetSet:",1,0,0);
    addField(targetsetField,2,1,0);

    addCaption("CoConsType:",2,0,0);
    addField(coconTypeList,3,1,0);

    addCaption("ScopeSet:",3,0,0);
    addField(scopesetField,4,1,0);

    addField(coconstypeField ,5,1,0);
    coconstypeField.setVisible(false);




  }

  protected boolean isAcceptibleBaseMetaClass(String baseClass) {
      return baseClass.equals("ContextbasedConstraint");
  }
}