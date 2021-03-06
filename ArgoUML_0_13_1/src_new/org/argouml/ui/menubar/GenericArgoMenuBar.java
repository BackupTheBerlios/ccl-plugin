// Copyright (c) 1996-2002 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.


package org.argouml.ui.menubar;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import org.tigris.gef.base.*;
import org.tigris.gef.ui.*;
import org.tigris.gef.util.*;

import org.argouml.application.api.*;
import org.argouml.application.events.*;
import org.argouml.ui.*;
import org.argouml.uml.ui.*;

/** GenericArgoMenuBar defines the menubar for all
 *  operating systems which do not explicitely ask
 *  for a different kind of menu bar, such as
 *  Mac OS X.
 */
public class GenericArgoMenuBar extends JMenuBar 
    implements ArgoModuleEventListener {

    private MultiToolbar _multiToolbar;
    
    protected JMenu _import = null;

    /** Edit menu
     */
    protected JMenu _edit = null;
    /** unknown where this appears in the UI
     */
    protected JMenu _select = null;
    /** toolbar: view under which is the goto diagram/ find
     * zoom!!! this should be activated as a right click command.
     * editor tabs/details tabs/ adjust grid etc.
     */
    protected ArgoJMenu _view = null;
    /** Toolbar:create diagram
     */
    protected JMenu _createDiagrams = null;
    /** currently disactivated
     */
    protected JMenu _tools = null;
    /** currently supports rudimentary java generation,
     * new modules for php and html/javadocs are planned
     * feel free to contribute here!
     */
    protected JMenu _generate = null;
    /** this should be invoked automatically when
     * importing sources.
     */
    protected ArgoJMenu _arrange = null;
    /** currently undergoing significant testing
     */
    protected ArgoJMenu _critique = null;
    /** It needs it. Currently there is only an
     * about text. hyperlinking to online docs at
     * argouml.org considered basic improvement.
     */
    protected JMenu _help = null;


    public GenericArgoMenuBar() {
        _multiToolbar = new MultiToolbar();
        initMenus();
    }

    public MultiToolbar getMultiToolbar() {
        return _multiToolbar;
    }
    
    static final protected KeyStroke getShortcut(String key) {
        return Localizer.getShortcut("CoreMenu",key);
    }

    /** This should be a user specified option. New laws
     * for handicapped people who cannot use the
     * mouse require software developers in US to
     * make all components of User interface accessible
     * through keyboard
     */
    static final protected void setMnemonic(JMenuItem item,String key,char defMnemonic) {
        String localMnemonic = Argo.localize("CoreMenu","Mnemonic_" + key);
        char mnemonic = defMnemonic;
        if(localMnemonic != null && localMnemonic.length() == 1) {
            mnemonic = localMnemonic.charAt(0);
        }
        item.setMnemonic(mnemonic);
    }

    static final protected String menuLocalize(String key) {
        return Argo.localize("CoreMenu",key);
    }

    static final void setAccelerator(JMenuItem item,KeyStroke keystroke) {
        if(keystroke != null) {
            item.setAccelerator(keystroke);
        }
    }


    /** Scans through all loaded modules to see if it has an item to add
     * in this diagram.
     *
     * @param menuitem The menuitem which this menuitem would attach to.
     * @param key Non-localized string that tells the module where we are.
     */
    private void appendPluggableMenus(JMenuItem menuitem, String key) {
        Object[] context = { menuitem, key };
        ArrayList arraylist = Argo.getPlugins(PluggableMenu.class, context);
        ListIterator iterator = arraylist.listIterator();
        while (iterator.hasNext()) {
            PluggableMenu module = (PluggableMenu)iterator.next();
            menuitem.add(module.getMenuItem(context));
            menuitem.setEnabled(true);
        }
    }

    public void moduleLoaded(ArgoModuleEvent event) {
        if (event.getSource() instanceof PluggableMenu) {
            PluggableMenu module = (PluggableMenu)event.getSource();
            Object[] context = new Object[] { _tools, "Tools" };
            if (module.inContext(context)) {
                _tools.add(module.getMenuItem(context));
                _tools.setEnabled(true);
            }
            context = new Object[] { _import, "File:Import" };
            if (module.inContext(context)) {
                _import.add(module.getMenuItem(context));
            }
            context = new Object[] { _generate, "Generate" };
            if (module.inContext(context)) {
                _generate.add(module.getMenuItem(context));
            }
            context = new Object[] { _edit, "Edit" };
            if (module.inContext(context)) {
                _edit.add(module.getMenuItem(context));
            }
            context = new Object[] { _view, "View" };
            if (module.inContext(context)) {
      	        _view.add(module.getMenuItem(context));
            }
            context = new Object[] { _createDiagrams, "Create Diagrams" };
            if (module.inContext(context)) {
       	        _createDiagrams.add(module.getMenuItem(context));
            }
            context = new Object[] { _arrange, "Arrange" };
            if (module.inContext(context)) {
       	        _arrange.add(module.getMenuItem(context));
            }
            context = new Object[] { _help, "Help" };
            if (module.inContext(context)) {
                if (_help.getItemCount() == 1) {
                    _help.insertSeparator(0);
                }
                _help.insert(module.getMenuItem(context), 0);
            }
        }
	}

    public void moduleUnloaded(ArgoModuleEvent event) {
        // TODO:  Disable menu
    }

    public void moduleEnabled(ArgoModuleEvent event) {
        // TODO:  Enable menu
    }

    public void moduleDisabled(ArgoModuleEvent event) {
        // TODO:  Disable menu
    }
  


    /** construct the ordinary all purpose Argo Menu Bar.
     */
    protected void initMenus() {
        KeyStroke ctrlN = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK);
        KeyStroke ctrlO = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK);
        KeyStroke ctrlS = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK);
        KeyStroke ctrlP = KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK);
        KeyStroke ctrlA = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK);
        KeyStroke ctrlC = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK);
        KeyStroke ctrlV = KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK);
        KeyStroke ctrlX = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK);

        KeyStroke F3 = KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0);
        KeyStroke F7 = KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0);
        KeyStroke altF4 = KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK);

        KeyStroke delKey  = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);
        KeyStroke ctrlDel = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, KeyEvent.CTRL_MASK);

        JMenuItem mi;
        // File Menu
        JMenu _file = new JMenu(menuLocalize("File"));
        add(_file);
        setMnemonic(_file,"File",'F');
        Toolbar fileToolbar = new Toolbar("File Toolbar");
        _multiToolbar.add(fileToolbar);
        JMenuItem newItem = _file.add(ActionNew.SINGLETON);
        setMnemonic(newItem,"New",'N');
        setAccelerator(newItem,ctrlN);
        fileToolbar.add((ActionNew.SINGLETON));
        JMenuItem openProjectItem = _file.add(ActionOpenProject.SINGLETON);
        setMnemonic(openProjectItem,"Open",'O');
        setAccelerator(openProjectItem,ctrlO);
        fileToolbar.add((ActionOpenProject.SINGLETON));
    
        //JMenuItem saveItem = _file.add(_actionSave);
        //file.add(_actionSaveAs);
        //file.add(_actionSaveAsXMI);
        JMenuItem saveProjectItem = _file.add(ActionSaveProject.SINGLETON);
        setMnemonic(saveProjectItem,"Save",'S');
        setAccelerator(saveProjectItem,ctrlS);
        fileToolbar.add((ActionSaveProject.SINGLETON));
        JMenuItem saveProjectAsItem = _file.add(ActionSaveProjectAs.SINGLETON);
        setMnemonic(saveProjectAsItem,"SaveAs",'A');
        _file.addSeparator();

        _import = new JMenu(menuLocalize("Import"));
        JMenuItem importProjectAsItem = _import.add(ActionImportFromSources.SINGLETON);
        appendPluggableMenus(_import, PluggableMenu.KEY_FILE_IMPORT);
        _file.add(_import);

        _file.addSeparator();
        // JMenuItem loadModelFromDBItem = _file.add(ActionLoadModelFromDB.SINGLETON);
        // JMenuItem storeModelToDBItem = _file.add(ActionStoreModelToDB.SINGLETON);
        // _file.addSeparator();
        JMenuItem printItem = _file.add(Actions.Print);
        setMnemonic(printItem,"Print",'P');
        setAccelerator(printItem,ctrlP);
        fileToolbar.add((Actions.Print));
        JMenuItem pageSetupItem = _file.add(Actions.PageSetup);
        JMenuItem saveGraphicsItem = _file.add(ActionSaveGraphics.SINGLETON);
        setMnemonic(saveGraphicsItem,"SaveGraphics",'G');
        // JMenuItem savePSItem = _file.add(Actions.SavePS);
        _file.addSeparator();
        _file.add(ActionSaveConfiguration.SINGLETON);
        _file.addSeparator();
        JMenuItem exitItem = _file.add(ActionExit.SINGLETON);
        setMnemonic(exitItem,"Exit",'x');
        setAccelerator(exitItem,altF4);

        _edit = (JMenu) add(new JMenu(menuLocalize("Edit")));
        setMnemonic(_edit,"Edit",'E');
        Toolbar editToolbar = new Toolbar("Edit Toolbar");
        _multiToolbar.add(editToolbar);

        _select = new JMenu(menuLocalize("Select"));
        _edit.add(_select);
        JMenuItem selectAllItem = _select.add(new CmdSelectAll());
        setAccelerator(selectAllItem,ctrlA);
        JMenuItem selectNextItem = _select.add(new CmdSelectNext(false));
        //tab
        JMenuItem selectPrevItem = _select.add(new CmdSelectNext(true));
        // shift tab
        _select.add(new CmdSelectInvert());

        //These are not yet implmeneted - Bob Tarling 12 Oct 2002
        //_edit.add(Actions.Undo);
        //editToolbar.add((Actions.Undo));
        //_edit.add(Actions.Redo);
        //editToolbar.add((Actions.Redo));
        
        _edit.addSeparator();
        
        JMenuItem cutItem = _edit.add(ActionCut.SINGLETON);
        setMnemonic(cutItem,"Cut",'X');
        setAccelerator(cutItem,ctrlX);
        editToolbar.add(ActionCut.SINGLETON);
        
        JMenuItem copyItem = _edit.add(ActionCopy.SINGLETON);
        setMnemonic(copyItem,"Copy",'C');
        setAccelerator(copyItem,ctrlC);
        editToolbar.add(ActionCopy.SINGLETON);
        
        JMenuItem pasteItem = _edit.add(ActionPaste.SINGLETON);
        setMnemonic(pasteItem,"Paste",'V');
        setAccelerator(pasteItem,ctrlV);
        editToolbar.add(ActionPaste.SINGLETON);
        
        _edit.addSeparator();
        
        JMenuItem removeItem = _edit.add(ActionDeleteFromDiagram.SINGLETON);
        setMnemonic(removeItem,"Remove",'R');
        setAccelerator(removeItem,ctrlDel);
        editToolbar.add(ActionDeleteFromDiagram.SINGLETON);
        
        JMenuItem deleteItem = _edit.add(ActionRemoveFromModel.SINGLETON);
        setMnemonic(deleteItem,"Delete",'D');
        setAccelerator(deleteItem,delKey);
        editToolbar.add(ActionRemoveFromModel.SINGLETON);
        
        JMenuItem emptyItem = _edit.add(ActionEmptyTrash.SINGLETON);
        
        _edit.addSeparator();
        
        _edit.add(ActionSettings.getInstance());

        _view = (ArgoJMenu) add(new ArgoJMenu(menuLocalize("View")));
        // maybe should be Navigate instead of view
        setMnemonic(_view,"View",'V');
        Toolbar viewToolbar = new Toolbar("View Toolbar");
        _multiToolbar.add(viewToolbar);

        //     JMenu nav = (JMenu) view.add(new JMenu("Navigate"));
        //     JMenuItem downItem = nav.add(_actionNavDown);
        //     downItem.setAccelerator(ctrldown);
        //     JMenuItem upItem = nav.add(_actionNavUp);
        //     upItem.setAccelerator(ctrlup);
        //     JMenuItem backItem = nav.add(_actionNavBack);
        //     backItem.setAccelerator(ctrlleft);
        //     JMenuItem forwItem = nav.add(_actionNavForw);
        //     forwItem.setAccelerator(ctrlright);

        _view.add(Actions.GotoDiagram);
        JMenuItem findItem =  _view.add(Actions.Find);
        setAccelerator(findItem,F3);
        viewToolbar.add((Actions.Find));

        _view.addSeparator();

        JMenu zoom = (JMenu) _view.add(new JMenu(menuLocalize("Zoom")));
        zoom.add(new ActionZoom(10));
        zoom.add(new ActionZoom(25));
        zoom.add(new ActionZoom(50));
        zoom.add(new ActionZoom(75));
        zoom.add(new ActionZoom(100));
        zoom.add(new ActionZoom(150));

        _view.addSeparator();

        JMenu editTabs = (JMenu) _view.add(new JMenu(menuLocalize("Editor Tabs")));

        //view.addSeparator();
        //view.add(_actionAddToFavorites);
        JMenu detailsTabs = (JMenu) _view.add(new JMenu(menuLocalize("Details Tabs")));

        _view.addSeparator();
        _view.add(new CmdAdjustGrid());
        _view.add(new CmdAdjustGuide());
        _view.add(new CmdAdjustPageBreaks());
        _view.addCheckItem(Actions.ShowRapidButtons);
        //_view.addCheckItem(Actions.ShowDiagramList);
        //_view.addCheckItem(Actions.ShowToDoList);
        //_showDetailsMenuItem = _view.addCheckItem(Actions.ShowDetails);

        _view.addSeparator();
        _view.add(org.argouml.language.ui.ActionNotation.getInstance().getMenu());

        appendPluggableMenus(_view, PluggableMenu.KEY_VIEW);

        //JMenu create = (JMenu) add(new JMenu(menuLocalize("Create")));
        //setMnemonic(create,"Create",'C');
        //create.add(Actions.CreateMultiple);
        //create.addSeparator();

        _createDiagrams = (JMenu) add(new JMenu(menuLocalize("Create Diagram")));
        setMnemonic(_createDiagrams, "Create Diagram",'C');
        Toolbar createDiagramToolbar = new Toolbar("Create Diagram Toolbar");
        _multiToolbar.add(createDiagramToolbar);
        _createDiagrams.add(ActionClassDiagram.SINGLETON);
        createDiagramToolbar.add((ActionClassDiagram.SINGLETON));
        _createDiagrams.add(ActionUseCaseDiagram.SINGLETON);
        createDiagramToolbar.add((ActionUseCaseDiagram.SINGLETON));
        _createDiagrams.add(ActionStateDiagram.SINGLETON);
        createDiagramToolbar.add((ActionStateDiagram.SINGLETON));
        _createDiagrams.add(ActionActivityDiagram.SINGLETON);
        createDiagramToolbar.add((ActionActivityDiagram.SINGLETON));
        _createDiagrams.add(ActionCollaborationDiagram.SINGLETON);
        createDiagramToolbar.add((ActionCollaborationDiagram.SINGLETON));
        _createDiagrams.add(ActionDeploymentDiagram.SINGLETON);
        createDiagramToolbar.add((ActionDeploymentDiagram.SINGLETON));
        _createDiagrams.add(ActionSequenceDiagram.SINGLETON);
        createDiagramToolbar.add((ActionSequenceDiagram.SINGLETON));
        appendPluggableMenus(_createDiagrams, PluggableMenu.KEY_CREATE_DIAGRAMS);

        //JMenu createModelElements = (JMenu) create.add(new JMenu("Model Elements"));
        //createModelElements.add(Actions.AddTopLevelPackage);
        //createModelElements.add(_actionClass);
        //createModelElements.add(_actionInterface);
        //createModelElements.add(_actionActor);
        //createModelElements.add(_actionUseCase);
        //createModelElements.add(_actionState);
        //createModelElements.add(_actionPseudostate);
        //createModelElements.add(_actionAttr);
        //createModelElements.add(_actionOper);

        //JMenu createFig = (JMenu) create.add(new JMenu("Shapes"));
        //createFig.add(_actionRectangle);
        //createFig.add(_actionRRectangle);
        //createFig.add(_actionCircle);
        //createFig.add(_actionLine);
        //createFig.add(_actionText);
        //createFig.add(_actionPoly);
        //createFig.add(_actionInk);

        _arrange = (ArgoJMenu) add(new ArgoJMenu(menuLocalize("Arrange")));
        setMnemonic(_arrange,"Arrange",'A');

        JMenu align = (JMenu) _arrange.add(new JMenu(menuLocalize("Align")));
        JMenu distribute = (JMenu) _arrange.add(new JMenu(menuLocalize("Distribute")));
        JMenu reorder = (JMenu) _arrange.add(new JMenu(menuLocalize("Reorder")));
        JMenu nudge = (JMenu) _arrange.add(new JMenu(menuLocalize("Nudge")));

        JMenu setPreferredSize = 
            (JMenu) _arrange.add(new JMenu(menuLocalize("Set size")));
        _arrange.addCheckItem((UMLAction) new ActionAutoResize());

        JMenu layout = (JMenu) _arrange.add(new JMenu(menuLocalize("Layout")));
        appendPluggableMenus(_arrange, PluggableMenu.KEY_ARRANGE);

        Runnable initLater = new InitMenusLater(align, distribute, 
                                                reorder, nudge, 
                                                setPreferredSize, layout, 
                                                editTabs, detailsTabs);

        org.argouml.application.Main.addPostLoadAction(initLater);

        _generate = (JMenu) add(new JMenu(menuLocalize("Generation")));
        setMnemonic(_generate,"Generate",'G');
        _generate.add(ActionGenerateOne.SINGLETON);
        JMenuItem genAllItem = _generate.add(ActionGenerateAll.SINGLETON);
        setAccelerator(genAllItem,F7);
        //generate.add(Actions.GenerateWeb);
        appendPluggableMenus(_generate, PluggableMenu.KEY_GENERATE);

        _critique = (ArgoJMenu) add(new ArgoJMenu(menuLocalize("Critique")));
        setMnemonic(_critique,"Critique",'R');
        _critique.addCheckItem(Actions.AutoCritique);
        _critique.addSeparator();
        _critique.add(Actions.OpenDecisions);
        _critique.add(Actions.OpenGoals);
        _critique.add(Actions.OpenCritics);

        // Tools Menu
        _tools = new JMenu(menuLocalize("Tools"));
        _tools.setEnabled(false);
        appendPluggableMenus(_tools, PluggableMenu.KEY_TOOLS);
        add(_tools);

        // tools.add(ActionTest.getInstance());

        // Help Menu
        _help = new JMenu(menuLocalize("Help"));
        setMnemonic(_help,"Help",'H');
        appendPluggableMenus(_help, PluggableMenu.KEY_HELP);
        if (_help.getItemCount() > 0) {
            _help.insertSeparator(0);
        }

        _help.add(Actions.SystemInfo);
        _help.addSeparator();
        _help.add(Actions.AboutArgoUML);

        //setHelpMenu(help);
        add(_help);

        ArgoEventPump.addListener(ArgoEventTypes.ANY_MODULE_EVENT, this);
    }

}    
