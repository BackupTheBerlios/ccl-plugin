package org.cocons.argo.plugin;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import org.argouml.application.api.ArgoModule;
import org.argouml.application.api.PluggableMenu;
import java.util.Vector;
import org.argouml.cognitive.critics.Agency;
import org.cocons.argo.cognitive.critics.*;
import org.cocons.argo.ui.*;
import org.tigris.gef.util.*;
import org.cocons.uml.ccl.xml.ActionImportCoCons;
import org.cocons.uml.ccl.xml.ActionExportCoCons;

/**
 * The module that loads the CoCons into ArgoUML.
 *
 * @author Stefan Tang
 * @version $Revision 1.0$
 */
public class CCLModule 
	implements ArgoModule, PluggableMenu
{
	public static String TOOL_MENU_CONTEXT_ID   = "Tools";
	public static String IMPORT_MENU_CONTEXT_ID = "File:Import";

  private static String IMAGEDIR="/org/cocons/argo/Images";

  public CCLModule() {
  }
  public boolean initializeModule() {
    org.cocons.argo.cognitive.critics.Init criticInit = new org.cocons.argo.cognitive.critics.Init();
    criticInit.run();
    ResourceLoader.addResourceLocation(IMAGEDIR);
    org.cocons.argo.diagram.Init cclDiagInit = new org.cocons.argo.diagram.Init();
    cclDiagInit.run();
    org.cocons.argo.ui.Init cclInit = new org.cocons.argo.ui.Init();
    cclInit.run();
    return true;
  }
  public boolean shutdownModule() {
    /**@todo: Implement this org.argouml.application.api.ArgoModule method*/
    throw new java.lang.UnsupportedOperationException("Method shutdownModule() not yet implemented.");
  }
  public void setModuleEnabled(boolean tf) {
    /**@todo: Implement this org.argouml.application.api.ArgoModule method*/
    throw new java.lang.UnsupportedOperationException("Method setModuleEnabled() not yet implemented.");
  }
  public boolean isModuleEnabled() {
    /**@todo: Implement this org.argouml.application.api.ArgoModule method*/
    throw new java.lang.UnsupportedOperationException("Method isModuleEnabled() not yet implemented.");
  }
  public String getModuleName() {
    return "CCL Module";
  }
  public String getModuleDescription() {
    return "CCL Module";
  }
  public String getModuleVersion() {
    return "$Revision 1.1$";
  }
  public String getModuleAuthor() {
    return "Technical University of Berlin, Dept. of Computer Science";
  }
  public Vector getModulePopUpActions(Vector popUpActions, Object context) {
	  System.out.println("getModulePopUpActions " + context);
    /**@todo: Implement this org.argouml.application.api.ArgoModule method*/
    throw new java.lang.UnsupportedOperationException("Method getModulePopUpActions() not yet implemented.");
  }
  public String getModuleKey() {
    return "module.cocons";
  }


	public JMenuItem getMenuItem(JMenuItem parentMenuItem, String menuType)
	{
		if( TOOL_MENU_CONTEXT_ID.equals(menuType) )
			{
				return getToolsMenuExtensions();
			}

		return null;
	}

	public boolean inContext(Object[] context)
	{
		if( isSelfPluggableContext( context ) )
			return true;

		return false;
	}

	public Object[] buildContext(JMenuItem parentMenuItem, String menuType)
	{
		if( TOOL_MENU_CONTEXT_ID.equals( menuType ) )
			return getPluggableContext();

		return null;
	}

	public Object[] getPluggableContext()
	{
		Object[] res = new Object[1];
		res[0] = getClass();
		return res;
	}

	public boolean isSelfPluggableContext( Object[] o )
	{
		if( o != null )
			if( o.length == 1 )
				if( o[0] instanceof Class )
					if( ((Class)o[0]).equals( getClass() ) )
						return true;

		return false;
	}

	public JMenuItem getToolsMenuExtensions()
	{
		JMenu menu = new JMenu("CoCons");
		menu.add( ActionExportCoCons.SINGLETON );
		menu.add( ActionImportCoCons.SINGLETON );
		return menu;
	}

    /** Return the JMenuItem controlled by the plugin under the specific
     *  context.  One menu plugin may control multiple menu items.
     *
     *  @param context array of objects
     *             as created by {@link #buildContext(JMenuItem, String) }.
     *
     *  @return A JMenuItem object controlled by the plug-in.
     *
     *  @since ARGO0.11.3
     *  @author Thierry Lach
     */
    public JMenuItem getMenuItem(Object[] context) {
		return getToolsMenuExtensions();
	}

}
