package org.cocons.argo.diagram.business_type.ui;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import org.argouml.ui.*;
import org.argouml.kernel.*;

public class KnownBusinessTypes {


  private static Vector knownBTs = new Vector();
  //private static JMenu menu = new JMenu("belongs to");

  public static void add(MClass c) {
    knownBTs.add(c);
    System.err.println("added known BT");
  }

  public static void remove(MClass c) {
    knownBTs.remove(c);
    System.err.println("removed known BT");
  }

  public static JMenu getJMenu() {
    JMenu menu = new JMenu("belongs to");
    menu.add(new RemoveBelongsToAction());
    menu.addSeparator();
    for (Iterator it = knownBTs.iterator(); it.hasNext();) {
      MClass c = (MClass)it.next();
      menu.add(new BelongsToAction(c));
    }

    return menu;
  }

  private static class RemoveBelongsToAction extends AbstractAction{
    public RemoveBelongsToAction(){
      super("remove belongs to");
    }

    public void actionPerformed(ActionEvent e) {
        ProjectBrowser pb = ProjectBrowser.TheInstance;
        Project p = pb.getProject();
        Object target = pb.getDetailsTarget();
        if (target instanceof MClass) {
          MClass c = (MClass)target;
          MTaggedValue tv = null;
          for (Iterator it = c.getTaggedValues().iterator();
               it.hasNext();) {
               MTaggedValue tv2 = (MTaggedValue)it.next();
               if (tv2.getTag().equals("belongs to")) {
                 tv = tv2;
                 c.removeTaggedValue(tv);
               }
          }
        }
        else {
          System.err.println("!!!!!!! target ist kein MClass,sondern "+target.getClass());
        }
      }
  }

  private static class BelongsToAction extends AbstractAction {
    private MClass businessType;

    public BelongsToAction(MClass businessType) {
      super(businessType.getName());
      this.businessType = businessType;
    }

    public void actionPerformed(ActionEvent e) {
        ProjectBrowser pb = ProjectBrowser.TheInstance;
        Project p = pb.getProject();
        Object target = pb.getDetailsTarget();
        if (target instanceof MClass) {
          MClass c = (MClass)target;
          MTaggedValue tv = null;
          for (Iterator it = c.getTaggedValues().iterator();
               it.hasNext();) {
               MTaggedValue tv2 = (MTaggedValue)it.next();
               if (tv2.getTag().equals("belongs to")) {
                 tv = tv2;
               }
          }
          if (tv == null) {
            tv = new MTaggedValueImpl();
            tv.setModelElement(c);
            tv.setTag("belongs to");
          }
          //tv.setNamespace(p.getModel());
          System.err.println("calling MTaggedValue.setValue()..");
          tv.setValue(businessType.getName());
          //c.addTaggedValue(tv);
        }
        else {
          System.err.println("!!!!!!! target ist kein MClass,sondern "+target.getClass());
        }
    }

  }

}