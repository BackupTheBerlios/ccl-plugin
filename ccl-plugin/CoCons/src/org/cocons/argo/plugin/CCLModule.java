package org.cocons.argo.plugin;

import org.argouml.application.api.ArgoModule;
import java.util.Vector;
import org.argouml.cognitive.critics.Agency;
import org.cocons.argo.cognitive.critics.*;

/**
 * The module that loads the CoCons into ArgoUML.
 *
 * @author Stefan Tang
 * @version $Revision 1.0$
 */
public class CCLModule implements ArgoModule {

  public CCLModule() {
  }
  public boolean initializeModule() {
    Agency.register(new CrNotAllowedToExistIn(),CrNotAllowedToExistIn.class);
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
    return "Stefan Tang, Technical University of Berlin, Dept. of Computer Science";
  }
  public Vector getModulePopUpActions(Vector popUpActions, Object context) {
    /**@todo: Implement this org.argouml.application.api.ArgoModule method*/
    throw new java.lang.UnsupportedOperationException("Method getModulePopUpActions() not yet implemented.");
  }
  public String getModuleKey() {
    return "module.cocons";
  }
}