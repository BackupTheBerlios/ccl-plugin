package org.cocons.argo.util;

import org.argouml.kernel.Project;
import ru.novosoft.uml.foundation.core.MModelElement;
import java.util.Vector;
import java.util.Iterator;
import org.argouml.ui.ProjectBrowser;
import org.argouml.ui.ArgoDiagram;
import java.util.Enumeration;
import ru.novosoft.uml.model_management.MModel;
import org.argouml.uml.diagram.ProjectMemberDiagram;
import org.argouml.uml.diagram.static_structure.ui.FigClass;

/**
 * Util class for iterating the ArgoUML model.
 *
 * @author Fadi Chabarek, Stefan Tang, Philip Schumacher
 * @version $Revision 1.1$
 */
public class ModelIterator {

  /**
   * Default Constructor
   */
  public ModelIterator() {
  }

  /**
   * Looks up all model elements in the ArgoUML model.
   *
   * @return A Vector containing model elements
   */
  public Vector getAllModelElements() {
    Vector modelElements = new Vector();
    Project theProject = ProjectBrowser.TheInstance.getProject();
    Vector projectMembers = theProject.getMembers();
    for (int i=0; i<projectMembers.size(); i++) {
      if (projectMembers.elementAt(i) instanceof ProjectMemberDiagram) {
        ProjectMemberDiagram memberDiag = (ProjectMemberDiagram)projectMembers.elementAt(i);
        ArgoDiagram diagram = memberDiag.getDiagram();
        Vector nodes = diagram.getNodes();
        for (int j=0; j<nodes.size(); j++) {
          MModelElement modelElement = (MModelElement)nodes.elementAt(j);
          modelElements.addElement(modelElement);
        }

      }
    }
    return modelElements;
  }

  /**
   * Looks up a specific class from the ArgoUML model.
   *
   * @param name the name of the class
   * @return The ModelElement class if existant, else null.
   */
  public MModelElement getModelElementClass(String name) {
    MModelElement mclass = null;
    Vector modelElements = getAllModelElements();
    for (int i=0; i<modelElements.size(); i++) {
      mclass = (MModelElement)modelElements.elementAt(i);
      if (mclass.getName().equals(name)) {
        return mclass;
      }
    }
    return mclass;
  }

}