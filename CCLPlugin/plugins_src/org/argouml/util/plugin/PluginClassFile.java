package org.argouml.util.plugin;
import java.io.*;

/**
 * Supports plugins packaged as individual class files.
 *
 * These plugins are not in JAR form. This is offered as
 * a alternative plugin loader during the development of plugins.
 * The specified directory in scanned for a text file named <I>pluginIdentifer</I>.txt
 * This file must contain an entry in the form
 * <I>main-class-to-load</I>=<I>classroot-to-classfiles</I>
 *
 * @see PluginManager#scanForClassfilePlugins
 *
 * @author Martin Skinner <mailto:mskinner@cs.tu-berlin.de>
 * @version 1.0
 */

class PluginClassFile extends Object implements PluginSource {

  protected String _sourceDir;
  protected String _classname;
  protected File _file;
  protected FileClassLoader _fileClassLoader;


/**
 * Creates a new object representing a plugin in class file form.
 *
 * @param classname name of main class to be loaded
 * @param sourcedir classpath to the class files of the plugin
 * */
  public PluginClassFile(String classname, String sourceDir) {
    _sourceDir = sourceDir;
    _classname = classname;
    _file = new File(_sourceDir);
    _fileClassLoader = new FileClassLoader(_file);
  }

 /** Gets the name of the plugin main class. This class will be loaded
  *  when loadClass() is called.
  *
  * @return classname of the plugin main class
  */
  public String toString() {
    return _classname;
  }

  /** loads the plugin main class dynamically.
   *
   * @return dynamically loaded main class.
   * @throws ClassNotFoundException when the main class is not in the source.
   */
  public Class loadClass() throws ClassNotFoundException {
    return _fileClassLoader.loadClass(this.toString()) ;
  }
}