package org.cocons.argo.diagram.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import org.argouml.ui.*;
import org.argouml.kernel.*;
import org.argouml.uml.diagram.ui.ActionAddExistingNode;
import org.argouml.uml.ui.*;
import org.argouml.uml.diagram.sequence.ui.*;

import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.behavior.common_behavior.*;

import org.tigris.gef.base.*;

import org.cocons.argo.util.ModelIterator;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class ActionAddInterfaceSpec extends UMLAction {

  protected JPopupMenu _jp;
  protected Component _c;
  protected MNamespace _ns;

  public ActionAddInterfaceSpec(Component c,MNamespace ns) {
    super("interface spec");
    _c = c;
    _ns = ns;
  }

  public void actionPerformed(ActionEvent e) {
    _jp  = new JPopupMenu("Add Interface");
    _jp.add(new CmdCreateNodeStereotype(MInterfaceImpl.class,
          "new Interface", findStereotype("interface spec") ));
    _jp.addSeparator();

    for(Iterator mi = new ModelIterator().getAllModelElements().iterator();mi.hasNext();){
      Object o = mi.next();
      if (o instanceof MInterface){
        MInterface minterface = (MInterface)o;
        if (minterface.getStereotype().getName().equals("interface spec")
            && minterface.getName()!=null){
          _jp.add(new ActionAddExistingNode(minterface.getName(),minterface));
        }
      }
    }
    _jp.show(_c,100,100);
  }

  protected MStereotype findStereotype(String name) {

    // just create a new one
    // needs-more-work
    // should check to see if the stereotype already exists

    MStereotype st = new MStereotypeImpl();
    st.setNamespace(_ns);
    st.setName(name);
    return st;
  }

}