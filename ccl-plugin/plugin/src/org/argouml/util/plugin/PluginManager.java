package org.argouml.util.plugin;

/**
 * This class is responsible for locating installed plugins.
 * Actually loading the plugins is up to the application.
 *
 * @author Martin Skinner <mailto:mskinner@cs.tu-berlin.de>
 * @version 1.0
 */

import java.io.*;
import java.util.*;
import java.util.jar.*;

public class PluginManager {

  /** default directory where plugins are expected
   */
  protected static String DEFAULT_PLUGIN_DIRECTORY = "plugins";

  /** Application-specific label to identify valid plugins.
   *
   *  JAR Plugins must contain this manifest attribute. The value
   *  of this attribute is the name of the class to be dynamically
   *  loaded.
   *
   *  @see PluginJarFile
   */
  protected String _pluginIdentifier;

  /** subdirectory where plugins are expected
   */
  protected String _pluginDir;

  /** contains only PluginSources
   *  @see PluginSource
   */
  protected Vector pluginFiles = new Vector();

  /** Create a new PluginManager and search the default plugin directory for plugins.
   *
   *  @param pluginIdentifier application-specific label to identify plugins
   *  JAR Plugins must contain this manifest attribute. The value
   *  of this attribute is the name of the class to be dynamically
   *  loaded.
   */
  public PluginManager(String pluginIdentifier) {
    this(pluginIdentifier, DEFAULT_PLUGIN_DIRECTORY);
  }

  /** Creates a new PluginManager and searches the specified directory for plugins.
   *
   *  @param pluginDirectory directory where plugins are expected
   *  @param pluginIdentifier application-specific label to identify plugins
   *  JAR Plugins must contain this manifest attribute. The value
   *  of this attribute is the name of the class to be dynamically
   *  loaded.
   */
  public PluginManager(String pluginIdentifier, String pluginDirectory) {
    this._pluginIdentifier = pluginIdentifier;
    this._pluginDir = pluginDirectory;
    scanForPlugins();
  }
  /** gets all identifed plugins
   *  @returns vector of PluginSources
   *  @see PluginSource
   */
  public Vector getPluginFiles()
  {
    return pluginFiles;
  }

  private void scanForPlugins() {
    try {
      File fPluginDir = new File(_pluginDir);
      if (!fPluginDir.exists() )
        {
          fPluginDir.mkdir();
          System.out.println("Created plugin directory " + fPluginDir.getCanonicalPath() );
        }
      if (fPluginDir.isDirectory())
        {
          scanForJarPlugins(fPluginDir);
          scanForClassfilePlugins(fPluginDir);
        }
    } catch(IOException e) {
        e.printStackTrace();
    }
  }
  /** scans a directory for JAR plugins.
   *
   * @param fPluginDir directory to scan
   */
  protected void scanForJarPlugins(File fPluginDir) throws IOException {

    System.out.println("Scanning for .jar Plugins in " + fPluginDir.getCanonicalPath() );
      class JarFileFilter implements FilenameFilter {
        public boolean accept (File dir, String name) {
          return name.endsWith (".jar");
        }
      }

    File[] fPlugin = fPluginDir.listFiles(new JarFileFilter());
    for (int i=0; i < fPlugin.length; i++)
      try {
         pluginFiles.add(new PluginJarFile(fPlugin[i],_pluginIdentifier));
         System.out.println("Found plugin in " + fPlugin[i].getName());
      }
      catch (IOException e) {
        System.out.println("Error opening " + fPlugin[i].getName() + " : " + e.getLocalizedMessage());
      }
  }

  /** scans for classfile plugins.
   *
   * Classfile plugins are plugins which are not in JAR form. This is offered as
   * a alternative plugin loader during the development of plugins.
   * The specified directory in scanned for a text file named <I>pluginIdentifer</I>.txt
   * This file must contain an entry in the form
   * <I>class-to-load</I>=<I>classroot-to-classfile</I>
   *
   * @param fPluginDir directory to scan
   */
  protected void scanForClassfilePlugins(File fPluginDir) throws IOException {
    String propFilename = fPluginDir.getCanonicalPath()+ java.io.File.separator+_pluginIdentifier+".txt";

    File propFile = new File(propFilename);
    if (propFile.isFile())
      {
        System.out.println("Scanning for .class Plugins in " + propFilename );
        Properties props = new Properties();

        try {
          FileInputStream is = new FileInputStream(propFile);
          props.load(is);
        }
        catch (IOException e) {
          System.out.println("Error opening " + propFilename + " : " + e.getLocalizedMessage());
          return;
        }
        for (Enumeration e = props.propertyNames(); e.hasMoreElements();) {
          String curPluginClassname = (String) e.nextElement();
          String curPluginPath = (String) props.getProperty(curPluginClassname);
          pluginFiles.add(new PluginClassFile(curPluginClassname, curPluginPath));
          System.out.println(curPluginClassname + " found in "+curPluginPath);
        }
      }
  }

}
