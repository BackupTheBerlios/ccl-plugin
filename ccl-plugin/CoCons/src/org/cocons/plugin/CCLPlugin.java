package org.cocons.plugin;

import javax.swing.*;
import java.io.*;
import org.argouml.ui.*;
import org.tigris.gef.util.*;
import org.argouml.util.plugin.ArgoPlugin;

/**
 * This is the main plugin class
 * @author
 * @version 0.9
 */

public class CCLPlugin implements ArgoPlugin {

  private static int MENU_INDEX_DIAGRAM = 3;
  private static String IMAGEDIR = "/org/cocons/Images";

  protected Action _actionCCLConstraintDiagram;

  public CCLPlugin() {
    ResourceLoader.addResourceLocation(IMAGEDIR);
    _actionCCLConstraintDiagram = new ActionCCLConstraintDiagram();
  }

  public void init() {
    System.out.println("CCL Plugin init() called.");
    ProjectBrowser pb = ProjectBrowser.TheInstance;
    JMenuBar mainMenuBar = pb.getJMenuBar();
    JMenu diagramMenu = mainMenuBar.getMenu(MENU_INDEX_DIAGRAM);
    diagramMenu.add(_actionCCLConstraintDiagram);
  }
}