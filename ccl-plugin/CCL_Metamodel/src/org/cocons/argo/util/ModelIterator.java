package org.cocons.argo.util;

import org.argouml.kernel.Project;
import ru.novosoft.uml.foundation.core.MModelElement;
import ru.novosoft.uml.foundation.core.*;
import java.util.Vector;
import java.util.Iterator;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JOptionPane;
import org.argouml.ui.ProjectBrowser;
import org.argouml.ui.ArgoDiagram;
import java.util.Enumeration;
import ru.novosoft.uml.model_management.MModel;
import org.argouml.uml.diagram.ProjectMemberDiagram;
import org.argouml.uml.diagram.static_structure.ui.FigClass;
import org.cocons.uml.ccl.context_property1_3.*;
import org.cocons.argo.diagram.ui.CCLDiagram;
import org.cocons.argo.diagram.business_type.ui.CCLBusiness_TypeDiagram;
import org.cocons.argo.diagram.interface_spec.ui.CCLInterface_SpecDiagram;
import org.cocons.argo.diagram.component_spec.ui.CCLComponent_SpecDiagram;

/**
 * Util class for iterating the ArgoUML model.
 *
 * @author Fadi Chabarek, Stefan Tang, Philip Schumacher
 * @version $Revision 1.1$
 */
public class ModelIterator {

  public static ModelIterator SINGLETON = new ModelIterator();

  /**
  * Default Constructor
  */
  public ModelIterator() {
    createContextPropertyTagList();
  }

  public void addContextPropertyTag(MContextPropertyTag me) {
    addCPTag(me);
  }

  public MContextPropertyTag getContextPropertyTag(String tagName) {
    return(getCPTag(tagName));
  }

  public void removeContextPropertyTag(String tagName, int references) {
    delCPTag(tagName,references);
  }

  public void changeContextPropertyTagName(String oldTagName, String newTagName, int references) {
    changeCPTagName(oldTagName,newTagName,references);
  }

  public Vector getAllContextPropertyTagNames() {
    return(getAllCPTagNames());
  }

  public Vector getAllContextPropertyTagConstraints() {
    return(getAllCPTagConstraints());
  }

  public int getCountContextPropertyTags() {
    return(countCPTags());
  }

  public void registerTagListObserver(Observer obs) {
    addObserver(obs);
  }

  public void changeObservable(MessageContainer messCon) {
    notifyObservers(messCon);
  }

      /**
        * Returns all MContextPropertyValues from the current project
        * Erstellungsdatum: (31.12.2001 02:56:51)
        * @return java.util.Vector
        */
        public Vector getAllContextPropertyValues() {
	  Vector propertyValues = new Vector();
	  Vector modelElements = getAllModelElements();
	  for (int i = 0; i < modelElements.size(); i++) {
			if ( modelElements.elementAt(i) instanceof MContextPropertyValue) {
				propertyValues.addElement((MContextPropertyValue)modelElements.elementAt(i));
			}
	  }
	  return propertyValues;
        }

	/**
	 * Looks up all model elements in the ArgoUML model.
	 *
	 * @return A Vector containing model elements
	 */
	public Vector getAllModelElements() {
		Project theProject = ProjectBrowser.TheInstance.getProject();
		return getAllModelElements(theProject);
	}
	/**
	 * Returns all model elements for a given project.
	 * Creation date: (15.01.2002 17:58:50)
	 * @return java.util.Vector the vector of the model elements.
	 * @param project org.argouml.kernel.Project a given project.
         *
         * Vorsicht ! Der zurückgegebene Vector enthält Objecte vom "Typ"
         *            MModelElement sowie vom "Typ" MContextPropertyValue...
         * (hyshosha@gmx.de)
	 */
	public Vector getAllModelElements(Project theProject) {
		Vector modelElements = new Vector();
		Vector projectMembers = theProject.getMembers();
		for (int i = 0; i < projectMembers.size(); i++) {
			if (projectMembers.elementAt(i) instanceof ProjectMemberDiagram) {
				ProjectMemberDiagram memberDiag = (ProjectMemberDiagram) projectMembers.elementAt(i);
				ArgoDiagram diagram = memberDiag.getDiagram();
				Vector nodes = diagram.getNodes();
				for (int j = 0; j < nodes.size(); j++) {
                                        if (nodes.elementAt(j) instanceof MContextPropertyValue) {
                                          // MContextPropertyValue kommt nicht von MModelElement sondern von MElement
                                          MContextPropertyValue cpTaggedValue = (MContextPropertyValue)nodes.elementAt(j);
                                          modelElements.addElement(cpTaggedValue);
                                        }
                                        else {
					  MModelElement modelElement = (MModelElement) nodes.elementAt(j);
					  modelElements.addElement(modelElement);
                                        }
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
		for (int i = 0; i < modelElements.size(); i++) {
                  if (modelElements.elementAt(i) instanceof MModelElement) {
                    /*
                      !!! getAllModelElements() sammelt auch ContectPropertyValues
                      auf - die sind keine MModelElements !!!
                    */
                    mclass = (MModelElement) modelElements.elementAt(i);
                    if (mclass.getName().equals(name)) {
                      return mclass;
                    }
                  }
		}
		return mclass;
	}

  //////////////////////////////////////////////////////////////////////////////
  // Manage the ContextPropertyTag-List ( by hyshosha@gmx.de )
  private static Vector _contextPropertyTagList;
  private TagListObservable _tlObs = new TagListObservable();

  private void createContextPropertyTagList() {
    _contextPropertyTagList = new Vector();
  }

  private void addObserver(Observer obs) {
    _tlObs.addObserver(obs);
  }
  private void notifyObservers(MessageContainer messCon) {
    _tlObs.setObservableChanged();
    _tlObs.notifyObservers(messCon);
  }

  private int countCPTags() {
    if (_contextPropertyTagList == null) return(0);
    else return(_contextPropertyTagList.size());
  }

  private void addCPTag(MModelElement me) {
    _contextPropertyTagList.addElement(me);
    MessageContainer messCon = new MessageContainer();
    messCon.setMessage("tag added");
    messCon.setString(((MContextPropertyTagImpl)me).getTag());
    notifyObservers(messCon);
  }

  private MContextPropertyTag getCPTag(String tagName) {
    for (int i = 0; i < countCPTags(); i++) {
      MContextPropertyTag tag = (MContextPropertyTag)_contextPropertyTagList.elementAt(i);
      if (tag.getTag().equals(tagName)) return(tag);
    }
    return(null);
  }

  private Vector getAllCPTagNames() {
    int counter = countCPTags();
    if (counter == 0) {
      return(null);
    }
    else {
      Vector tagNameList = new Vector();
      for (int i = 0; i < counter;i++) {
        String tagNameAt_i = ((MModelElement)_contextPropertyTagList.elementAt(i)).getName();
        tagNameList.addElement(tagNameAt_i);
      }
      return(tagNameList);
    }
  }

  private Vector getAllCPTagConstraints() {
    int counter = countCPTags();
    if (counter == 0) {
      return(null);
    }
    else {
      Vector constraintList = new Vector();
      for (int i = 0; i < counter;i++) {
        String constraintAt_i = ((MContextPropertyTagImpl)_contextPropertyTagList.elementAt(i)).getConstraintBody();
        constraintList.addElement(constraintAt_i);
      }
      return(constraintList);
    }
  }

  private void delCPTag(String tagName, int references) {
    MessageContainer messCon = new MessageContainer();
    messCon.setMessage("tag removed");
    messCon.setString(tagName);
    if (references == 0) {
      for (int i = _contextPropertyTagList.size()-1; i >= 0; i--) {
        if (((MContextPropertyTagImpl)_contextPropertyTagList.elementAt(i)).getTag().equals(tagName)) {
          _contextPropertyTagList.removeElementAt(i);
          messCon.setInt(i);
        }
      }
      notifyObservers(messCon);
    }
    else {
      // die einzelnen CCL-Diagramme werden nacheinander durchsucht
      ProjectBrowser pb = ProjectBrowser.TheInstance;
      Vector diagrams = pb.getProject().getDiagrams();
      CCLDiagram diagram = null;
      int count = 0;
      for (int i = 0; i < diagrams.size(); i++) {
        if ((diagrams.elementAt(i) instanceof CCLBusiness_TypeDiagram)||
            (diagrams.elementAt(i) instanceof CCLInterface_SpecDiagram)||
            (diagrams.elementAt(i) instanceof CCLComponent_SpecDiagram)) {
          diagram = (CCLDiagram)diagrams.elementAt(i);
          Vector diagramNodes = diagram.getNodes();
          pb.navigateTo(diagram);
          count++;
          for (int j = 0; j < diagramNodes.size(); j++) {
            if (diagramNodes.elementAt(j) instanceof MContextPropertyValueImpl) {
              if (((MContextPropertyValueImpl)diagramNodes.elementAt(j)).getTag().equals(tagName)) {
                ((MContextPropertyValueImpl)diagramNodes.elementAt(j)).removeMe();
              }
            }
          }
        }
      }

      // Tag aus der TagList entfernen
      for (int i = _contextPropertyTagList.size()-1; i >=0 ; i--) {
        if (((MContextPropertyTagImpl)_contextPropertyTagList.elementAt(i)).getTag().equals(tagName)) {
          _contextPropertyTagList.removeElementAt(i);
          messCon.setInt(i);
        }
      }
      notifyObservers(messCon);
      pb.getNavPane().forceUpdate();

      if (count > 1) {
        String message = "Context Property Tag \""+tagName+"\" was deleted.\nYou were kicked to \""+diagram.getName().toUpperCase()+"\" !";
        JOptionPane.showMessageDialog(null,message,"Ready !",JOptionPane.INFORMATION_MESSAGE);
      }
      else {
        String message = "Context Property Tag \""+tagName+"\" was deleted.";
        JOptionPane.showMessageDialog(null,message,"Ready !",JOptionPane.INFORMATION_MESSAGE);
      }

    }
  }

  private void changeCPTagName(String oldTagName, String newTagName, int references) {
    MessageContainer messCon = new MessageContainer();
    messCon.setMessage("tagname changed");

    Object detailsTarget;
    CCLDiagram startDiagram = null;

    ProjectBrowser pb = ProjectBrowser.TheInstance;
    detailsTarget=pb.getDetailsTarget();

    for (int i = _contextPropertyTagList.size()-1; i >=0 ; i--) {
      if (((MContextPropertyTagImpl)_contextPropertyTagList.elementAt(i)).getTag().equals(oldTagName)) {
        ((MContextPropertyTagImpl)_contextPropertyTagList.elementAt(i)).setTag(newTagName);
      }
    }

    if (references > 0) {
      // die einzelnen CCL-Diagramme werden nacheinander durchsucht
      //ProjectBrowser pb = ProjectBrowser.TheInstance;
      Vector diagrams = pb.getProject().getDiagrams();
      CCLDiagram diagram = null;
      int count = 0;
      for (int i = 0; i < diagrams.size(); i++) {
        if ((diagrams.elementAt(i) instanceof CCLBusiness_TypeDiagram)||
            (diagrams.elementAt(i) instanceof CCLInterface_SpecDiagram)||
            (diagrams.elementAt(i) instanceof CCLComponent_SpecDiagram)) {
          diagram = (CCLDiagram)diagrams.elementAt(i);
          Vector diagramNodes = diagram.getNodes();
          pb.navigateTo(diagram);
          count++;
          for (int j = 0; j < diagramNodes.size(); j++) {
            if (diagramNodes.elementAt(j).equals(detailsTarget)) startDiagram = diagram;
            if (diagramNodes.elementAt(j) instanceof MContextPropertyValueImpl) {
              if (((MContextPropertyValueImpl)diagramNodes.elementAt(j)).getTag().equals(oldTagName)) {
                ((MContextPropertyValueImpl)diagramNodes.elementAt(j)).setCPTag(newTagName);
                ((MContextPropertyValueImpl)diagramNodes.elementAt(j)).actualizeFigure();
              }
            }
          }
        }
      }

      notifyObservers(messCon);
      pb.getNavPane().forceUpdate();

      if (detailsTarget != null) {
        pb.navigateTo(startDiagram);
        pb.select(detailsTarget);
      }

      if ((count > 1)&&(detailsTarget == null)) {
        String message = "Context Property Tag \""+oldTagName+"\" was changed to \""+newTagName+"\".\nYou were kicked to \""+diagram.getName().toUpperCase()+"\" !";
        JOptionPane.showMessageDialog(null,message,"Ready !",JOptionPane.INFORMATION_MESSAGE);
      }
      else {
        String message = "Context Property Tag \""+oldTagName+"\" was changed to \""+newTagName+"\".";
        JOptionPane.showMessageDialog(null,message,"Ready !",JOptionPane.INFORMATION_MESSAGE);
      }

    }
  }
  //
  //////////////////////////////////////////////////////////////////////////////

  //////////////////////////////////////////////////////////////////////////////
  //  TagListObservable ( by hyshosha@gmx.de )
  class TagListObservable extends Observable {

    public TagListObservable() {
    }

    public void setObservableChanged() {
      this.setChanged();
    }

  }
  //
  //////////////////////////////////////////////////////////////////////////////

}
