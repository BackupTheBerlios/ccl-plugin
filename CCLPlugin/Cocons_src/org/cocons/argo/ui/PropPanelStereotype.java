package org.cocons.argo.ui;

/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Martin Skinner
 * @version 1.0
 */

import javax.swing.*;
import org.argouml.uml.ui.*;
import java.awt.*;
import java.awt.event.*;

public class PropPanelStereotype extends
  org.argouml.uml.ui.foundation.extension_mechanisms.PropPanelStereotype {

  public PropPanelStereotype() {
    super();
    addCaption("Tag Definitions:",1,1,1);
    JList derivedList = new UMLList(new UMLSpecializationListModel(this,null,true),true);
    derivedList.setForeground(Color.blue);
    derivedList.setVisibleRowCount(1);
    addField(new JScrollPane(derivedList),1,1,1);
  }
}