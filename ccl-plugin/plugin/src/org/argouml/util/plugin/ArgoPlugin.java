package org.argouml.util.plugin;

/**
 * Application-specific interface to plugins. All ArgoUML plugins must
 * implement this interface.
 *
 * @author Martin Skinner <mailto:mskinner@cs.tu-berlin.de>
 * @version 1.0
 */

public interface ArgoPlugin {
/**
 * This method will be called after the plugin is loaded.
 * In the implementation of this method the plugin can perform any necessary
 * initialization, for example, creating new menu items.
 */
  public void init();
}