package org.cocons.argo.diagram;

import org.argouml.ui.*;
import org.cocons.argo.diagram.ui.*;
import javax.swing.*;


/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Martin Skinner
 * @version 1.0
 */


public class Init implements Runnable {

  private static int MENU_INDEX_DIAGRAM = 3;

  public void run() {
    ProjectBrowser pb = ProjectBrowser.TheInstance;
    // add menu bar items
    JMenuBar mainMenuBar = pb.getJMenuBar();
    JMenu diagramMenu = mainMenuBar.getMenu(MENU_INDEX_DIAGRAM);
    diagramMenu.add(new ActionCCLConstraintDiagram());
  }
}