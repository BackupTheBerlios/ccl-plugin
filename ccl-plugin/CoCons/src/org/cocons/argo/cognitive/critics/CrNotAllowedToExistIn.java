package org.cocons.argo.cognitive.critics;

import org.cocons.argo.cognitive.critics.CrCoCon;
import org.argouml.cognitive.Designer;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;
import org.cocons.uml.ccl.ContextCondition;
import java.util.Vector;
import org.argouml.ui.ProjectBrowser;
import org.argouml.kernel.Project;
/**
 * The design critique that checks the NotAllowedToExistIn CoCon.
 *
 * @author Stefan Tang
 * @version $Revision 1.1$
 */

public class CrNotAllowedToExistIn extends CrCoCon {

  public CrNotAllowedToExistIn() {
  }

  public boolean predicate(Object dm, Designer dsgr) {
    return true;
  }

}