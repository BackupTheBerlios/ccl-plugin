package org.argouml.util.plugin;

/**
 * This interface defines the methods all sources of plugins must implement.
 *
 * @author Martin Skinner <mailto:mskinner@cs.tu-berlin.de>
 * @version 1.0
 */

public interface PluginSource {
 /** Gets the name of the plugin main class. The main class is the class which
  *  will initially be loaded by the loadClass() method. Usually, this
  *  is part of the plugin source (e.g.: in JAR files, the class is
  *  specified in the manifest file).
  *
  * @return classname of the plugin main class
  */
  public String toString();

  /** loads the plugin main class dynamically.
   *
   * @return dynamically loaded class.
   * @throws ClassNotFoundException when the main class is not in the source.
   */
  public Class loadClass() throws ClassNotFoundException;
}