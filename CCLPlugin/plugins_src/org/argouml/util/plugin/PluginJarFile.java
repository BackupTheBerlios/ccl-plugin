package org.argouml.util.plugin;

/**
 * Supports plugins packaged as distributable Java Archives (JAR-Files).
 * The main plugin class (the class to be initially loaded) is specified
 * in the manifest file.
 *
 * @author Martin Skinner <mailto:mskinner@cs.tu-berlin.de>
 * @version 1.0
 */

import java.util.jar.JarFile;
import java.io.*;

class PluginJarFile extends Object implements PluginSource {

  protected String _pluginClassname;
  protected JarFile jarFile;
  protected JarClassLoader jarClassLoader;

 /**
  * Constructs a new object representing a JAR plugin.
  *
  * @param file path to JAR file
  * @param manifestAttribute attribute where the plugin main class is specified
  */
  public PluginJarFile(File file, String manifestAttribute)
    throws IOException {
    jarFile = new JarFile(file);
    _pluginClassname = readManifestAttribute(manifestAttribute);
    jarClassLoader = new JarClassLoader(jarFile);
  }

 /** Gets the name of the plugin main class. The main class is the class which
  *  will initially be loaded by the loadClass() method. Usually, this
  *  is part of the plugin source (e.g.: in JAR files, the class is
  *  specified in the manifest file).
  *
  * @return classname of the plugin main class
  */
  private String readManifestAttribute(String manifestAttribute)
    throws IOException {

    String s = jarFile.getManifest().getMainAttributes().getValue(manifestAttribute);
    if (s==null)
      throw new IOException("Manifest Attribute '"+manifestAttribute+"' not found in archive");
    return s;
  }

 /** Gets the name of the plugin main class as specified in the
  *  manifest attribute.
  *
  * @return classname of the plugin main class
  */
  public String toString() {
    return _pluginClassname;
  }

  /** loads the plugin main class dynamically.
   *
   * @return dynamically loaded main class.
   * @throws ClassNotFoundException when the main class is not in the source.
   */
  public Class loadClass() throws ClassNotFoundException {
    return jarClassLoader.loadClass(this.toString()) ;
  }
}