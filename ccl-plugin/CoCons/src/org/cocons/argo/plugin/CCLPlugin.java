package org.cocons.argo.plugin;

import javax.swing.*;
import java.util.*;
import java.io.*;
import org.tigris.gef.util.*;
import org.argouml.util.plugin.ArgoPlugin;


/**
 * This is the main plugin class
 * @author
 * @version 0.9
 */

public class CCLPlugin implements ArgoPlugin {

  private static String IMAGEDIR = "/org/cocons/argo/Images";

  public CCLPlugin() {
  }

  public void init() {
    System.out.println("CCL Plugin init() called.");
    ResourceLoader.addResourceLocation(IMAGEDIR);
  }

  public Vector getPostLoadActions() {
    Vector pla = new Vector();

    pla.add(new org.cocons.argo.diagram.Init());
    pla.add(new org.cocons.argo.ui.Init());
    pla.add(new org.cocons.argo.critics.Init());
    return pla;
  }


}