package org.argouml.util.plugin;

import java.util.*;

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

/**
 * These post-load actions will be executed by the argo application
 * in a background thread <I>after</I> all the application's
 * post-load actions are executed.
 *
 * @returns vector of post-load actions implementing Runnable
 */
  public Vector getPostLoadActions();
}