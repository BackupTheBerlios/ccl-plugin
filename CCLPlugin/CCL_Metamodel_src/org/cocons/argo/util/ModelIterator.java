package org.cocons.argo.util;

import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectMember;
import java.io.*;
import ru.novosoft.uml.foundation.core.MModelElement;
import ru.novosoft.uml.foundation.core.*;
import java.util.Vector;
import java.util.Iterator;
import java.util.Collection;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JOptionPane;
import org.argouml.ui.ProjectBrowser;
import org.argouml.ui.ArgoDiagram;
import org.cocons.uml.ccl.*;
import org.cocons.uml.ccl.util.*;
import antlr.NoViableAltException;
import antlr.RecognitionException;
import antlr.TokenStreamException;
import java.util.Enumeration;
import org.cocons.argo.cognitive.critics.CriticInfo;
import ru.novosoft.uml.model_management.MModel;
import ru.novosoft.uml.foundation.data_types.MBooleanExpression;
import org.argouml.uml.diagram.ProjectMemberDiagram;
import org.argouml.uml.diagram.static_structure.ui.FigClass;
import org.cocons.uml.ccl.context_property1_3.*;
import org.cocons.argo.diagram.ui.CCLDiagram;
import org.cocons.argo.diagram.business_type.ui.CCLBusiness_TypeDiagram;
import org.cocons.argo.diagram.interface_spec.ui.CCLInterface_SpecDiagram;
import org.cocons.argo.diagram.component_spec.ui.CCLComponent_SpecDiagram;
import org.cocons.uml.ccl.context_property1_3.xmlembed.EmbeddedContextPropertyTagCreator;
import org.cocons.uml.ccl.context_property1_3.xmlembed.EmbeddedContextPropertyTagDecoder;
import org.argouml.uml.ProjectMemberModel;
import org.argouml.uml.UUIDManager;
import org.argouml.xml.argo.ArgoParser;

//Ute von Angern 05.05.2003
import org.cocons.uml.ccl.util.CCLEvaluation;

/**
 * Util class for iterating the ArgoUML model.
 *
 * @author Fadi Chabarek, Stefan Tang, Philip Schumacher
 * @version $Revision 1.1$
 * @author Camara Lenuseni, layekers@cs.tu-berlin.de (modified 24.5.03)
 */
public class ModelIterator {

	public static String EMBEDDED_TAG_XML_PREFIX = "<CCLModelIterator.EmbeddedXMLTags>:";

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

  public void changeContextPropertyTagDefinition(String tagName, String oldValidValues, String newValidValues, String definition, String unit, int references) {
    changeCPTagDefinition(tagName,oldValidValues,newValidValues,definition,unit,references);
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
    messCon.setString(((MContextPropertyTag)me).getTag());
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

	private void dumbDelCPTag( String tagName )
	{
      for (int i = _contextPropertyTagList.size()-1; i >= 0; i--)
			if (((MContextPropertyTagImpl)_contextPropertyTagList.elementAt(i)).getTag().equals(tagName))
				_contextPropertyTagList.removeElementAt(i);
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

  private void changeCPTagDefinition(String tagName, String oldValidValues, String newValidValues, String definition, String unit, int references) {
    MessageContainer messCon = new MessageContainer();
    VCPLTranslator translator = new VCPLTranslator();
    boolean use_this;

    Object detailsTarget;
    CCLDiagram startDiagram = null;

    ProjectBrowser pb = ProjectBrowser.TheInstance;
    detailsTarget=pb.getDetailsTarget();

    MContextPropertyTagImpl changedTag = null;
    for (int i = _contextPropertyTagList.size()-1; i >=0 ; i--) {
      if (((MContextPropertyTagImpl)_contextPropertyTagList.elementAt(i)).getTag().equals(tagName)) {
        changedTag = (MContextPropertyTagImpl)_contextPropertyTagList.elementAt(i);
      }
    }

    if (oldValidValues.equals(newValidValues)) {
      use_this = false;
      messCon.setMessage("tag def changed");
    }
    else {
      use_this = true;
      messCon.setMessage("valid values changed");
    }
    messCon.setString(tagName);
    if (detailsTarget instanceof MContextPropertyValueImpl) {
      messCon.setObject(detailsTarget);
    }

    if (newValidValues.equals("List Of Strings")) {
      ((MConstraint)(changedTag.getConstraints().toArray())[0]).setBody(new MBooleanExpression(null,translator.getConstraintString_ListOfStrings(definition)));
    }
    else if (newValidValues.equals("Integer Number")) {
      ((MConstraint)(changedTag.getConstraints().toArray())[0]).setBody(new MBooleanExpression(null,translator.getConstraintString_Integer(definition) + " | Unit: " + unit));
    }
    else if (newValidValues.equals("Float Number")) {
      ((MConstraint)(changedTag.getConstraints().toArray())[0]).setBody(new MBooleanExpression(null,translator.getConstraintString_Float(definition) + " | Unit: " + unit));
    }
    else {}

    if (references > 0) {
      // die einzelnen CCL-Diagramme werden nacheinander durchsucht
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
              if (((MContextPropertyValueImpl)diagramNodes.elementAt(j)).getTag().equals(changedTag.getTag())) {
                if (use_this) {
                  ((MContextPropertyValueImpl)diagramNodes.elementAt(j)).refreshWhenValidValuesTypeWasChanged();
                  ((MContextPropertyValueImpl)diagramNodes.elementAt(j)).actualizeFigure();
                  ((MContextPropertyValueImpl)diagramNodes.elementAt(j)).markFigureOrange();
                }
                else {
                  ((MContextPropertyValueImpl)diagramNodes.elementAt(j)).refreshWhenValidValuesDefinitionWasChanged();
                  ((MContextPropertyValueImpl)diagramNodes.elementAt(j)).actualizeFigure();
                  if (((MContextPropertyValueImpl)diagramNodes.elementAt(j)).valueDefinitionWasChanged()) {
                    ((MContextPropertyValueImpl)diagramNodes.elementAt(j)).markFigureOrange();
                  }
                }
              }
            }
          }
        }
      }

      notifyObservers(messCon);

      if (detailsTarget != null) {
        pb.navigateTo(startDiagram);
        pb.select(detailsTarget);
      }

      if ((count > 1)&&(detailsTarget == null)) {
        String message = "Context Property Tag \""+changedTag+"\" was changed.\nYou were kicked to \""+diagram.getName().toUpperCase()+"\" !";
        JOptionPane.showMessageDialog(null,message,"Ready !",JOptionPane.INFORMATION_MESSAGE);
      }
      else {
        String message = "Context Property Tag \""+changedTag+"\" was changed.";
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







  //////////////////////////////////////////////////////////////////////////////
  //  Persistence of ContextPropertyTags

	private MComment _smuggledComment      = null;
	private MModel   _smuggledCommentModel = null;

	/** Puts a dummy MComment containing all ContextPropertyTags into the model,
	 *  unless there is already one. */
	public void ensureTagsAreModelled()
	{
		System.out.println("ensureTagsAreModelled()");

		if( _smuggledComment != null )
			return;
                /* Vector models = (Vector) ProjectBrowser.TheInstance.getProject().getModels();
                  Zeile geändert da ClassCastException 11.04.03 uva
                */
                Collection models = ProjectBrowser.TheInstance.getProject().getModels();
                /* neu hinzugefügt */
                Object[] a = models.toArray();
                Vector myvec = new Vector();
                for(int i=0; i < a.length ; i++)
                myvec.add(i,a[i]);

                /* _smuggledCommentModel = (MModel)models.elementAt(0); geändert*/
		_smuggledCommentModel = (MModel)myvec.elementAt(0);
		_smuggledComment = new MCommentImpl();
		_smuggledComment.setName( EMBEDDED_TAG_XML_PREFIX +
										  EmbeddedContextPropertyTagCreator.SINGLETON.
										  create(_contextPropertyTagList.iterator()));

		_smuggledComment.setUUID( UUIDManager.SINGLETON.getNewUUID() );
		_smuggledCommentModel.addOwnedElement(_smuggledComment);
	}

	/** Removes the ContextPropertyTags-Dummy-MComment from the model,
	 *  unless there is none. */
	public void ensureTagsAreNotModelled()
	{
		if( _smuggledComment != null )
			{
				_smuggledCommentModel.removeOwnedElement(_smuggledComment);
				_smuggledComment      = null;
				_smuggledCommentModel = null;
			}
	}

	/** Searches the loaded-but-not-yet-installed model for
	 *  ContextPropertyTags-Dummy-MComments, intiates ContextPropertyTags from
	 *  them, and discards them. */
	public void restoreSmuggledTags()
	{
		Iterator models = ArgoParser.SINGLETON.getProject().getModels().iterator();
		while( models.hasNext() )
			{
				Collection doomedElems = new Vector();
				MModel model = (MModel)models.next();
				Iterator elems = model.getOwnedElements().iterator();
				while( elems.hasNext() )
					{
						Object o = elems.next();
						if( o instanceof MComment )
							if( perhapsReadSmuggledTag((MComment)o) )
								doomedElems.add( o );
					};

				Iterator rm = doomedElems.iterator();
				while( rm.hasNext() )
					model.removeOwnedElement( (MModelElement)rm.next() );
			};
	}

	/** Checks whether a MComment is really a ContextPropertyTags-Dummy-MComment,
	 *  initiates ContextPropertyTags from it. */
	protected boolean perhapsReadSmuggledTag( MComment com )
	{
		String name = com.getName();
		if( name == null )
			return false;

		int headlgt = EMBEDDED_TAG_XML_PREFIX.length();

		if( name.length() < headlgt )
			return false;

		if( !EMBEDDED_TAG_XML_PREFIX.equals( name.substring(0, headlgt) ))
			return false;

		String xml = name.substring( headlgt, name.length() );
		Iterator newtags = EmbeddedContextPropertyTagDecoder.SINGLETON.decode( xml );

		if( newtags == null )
			return false;

		while( newtags.hasNext() )
			{
				MContextPropertyTag tag = (MContextPropertyTag)newtags.next();
				dumbDelCPTag( tag.getName() );
				addCPTag( tag );
			}

		return true;
	}

        /**
         * Liefert alle Modellelemente des TargetSets
         * @param target - String TargetSet
         * @return Modellelemente
         * @author Ute von Angern
         */
        public Vector getTargetSetElements(String target) {
          Vector element = new Vector();
          Object[] obj;
          String str = "";
          Vector v = new Vector();
          Vector elementcontainer = new Vector();
          Vector elem = new Vector();
          Vector el = new Vector();

          element = this.getAllModelElements();
          for(int i=0; i< element.size()-1; i++) {
            if(element.elementAt(i) != null) {
              MModelElement m = (MModelElement) element.elementAt(i);              
              Collection c= (Collection) m.getTaggedValues();
              obj = c.toArray();
              for(int j=0; j<obj.length; j++) {
                str = this.getTaggedName((obj[j]).toString());
                v = this.getTaggedValueList((obj[j]).toString());
              }
              ElementSelectionContainer container = new ElementSelectionContainer();
              container.setModelelement((MModelElement) element.elementAt(i));
              container.setContextPropertyContainer(str,v);
              elementcontainer.addElement(container);
              v.removeAllElements();
            }
          }
          CCLEvaluation eval = new CCLEvaluation();
          eval.visit(eval.buildTreeTargetSet(target), elementcontainer);
          eval.evaluate();
          for(int i=0; i< eval.Modelelem.size(); i++) {
            ElementSelectionContainer cont = (ElementSelectionContainer) eval.Modelelem.elementAt(i);
            el.addElement((MModelElement)cont.getModelelement());
          }          
          return el;
        }

        /**
         * Liefert alle Modellelemente des ScopeSets
         * @param scope - String ScopeSet
         * @return Modellelemente
         * @author Ute von Angern
         */
        public Vector getScopeSetElements(String scope) {
          Vector element = new Vector();
          Object[] obj;
          String str = "";
          Vector v = new Vector();
          Vector elementcontainer = new Vector();
          Vector elem = new Vector();
          Vector el = new Vector();

          element = this.getAllModelElements();
          for(int i=0; i< element.size()-1; i++) {
            if(element.elementAt(i) != null) {
              MModelElement m = (MModelElement) element.elementAt(i);
              System.out.println("Modellelement " + m.getName());
              Collection c= (Collection) m.getTaggedValues();
              obj = c.toArray();
              for(int j=0; j<obj.length; j++) {
                str = this.getTaggedName((obj[j]).toString());
                v = this.getTaggedValueList((obj[j]).toString());
              }
              ElementSelectionContainer container = new ElementSelectionContainer();
              container.setModelelement((MModelElement) element.elementAt(i));
              container.setContextPropertyContainer(str,v);
              elementcontainer.addElement(container);
              v.removeAllElements();
            }
          }
          CCLEvaluation eval = new CCLEvaluation();
          eval.visit(eval.buildTreeScopeSet(scope), elementcontainer);
          eval.evaluate();
          for(int i=0; i< eval.Modelelem.size(); i++) {
            ElementSelectionContainer cont = (ElementSelectionContainer) eval.Modelelem.elementAt(i);
            el.addElement((MModelElement)cont.getModelelement());
          }
          System.out.println("getScopeSet " + el.toString());
          return el;
        }


        /**
         * written by Ute von Angern 04.05.2003
         */
        public String getTaggedName(String taggedValues) {
          String tmp;
          int x;

          x = taggedValues.indexOf("'");
          tmp = taggedValues.substring(x+1 ,taggedValues.length());
          x = tmp.indexOf("'");
          tmp = tmp.substring(0,x);
          return tmp;
        }

        /**
         * written by Ute von Angern 04.05.2003
         */
        public Vector getTaggedValueList(String taggedValues) {
          String tmp;
          int x;
          Vector v = new Vector();

          x = taggedValues.indexOf("=");
          tmp = taggedValues.substring(x+1 ,taggedValues.length());
          x = tmp.indexOf("'");
          tmp = tmp.substring(x+1,tmp.length());
          x = tmp.indexOf("'");
          tmp = tmp.substring(0,x);
          while(tmp.indexOf(",") > 0) {
            v.addElement((tmp.substring(0,tmp.indexOf(","))).trim());
            tmp = tmp.substring(tmp.indexOf(",") + 1, tmp.length());
          }
          v.addElement(tmp.trim());
          return v;
        }

        /**
         * written by Ute von Angern
         */
        public Vector getIntersection(Vector elem1, Vector elem2) {
         Vector v = new Vector();

         if(elem1.size() < elem2.size()) {
           for(int i=0; i<elem1.size(); i++) {
             if(isContain((MModelElement) elem1.elementAt(i), elem2)) {
               v.addElement(elem1.elementAt(i));
             }
           }
         }
         else {
           for(int i=0; i<elem2.size(); i++) {
             if(isContain((MModelElement) elem2.elementAt(i), elem1)) {
               v.addElement(elem2.elementAt(i));
             }
           }
         }
         return v;
        }

        /**
         * written by Ute von Angern
         */
        public boolean isContain(MModelElement el, Vector elem) {
          boolean con = false;

          for(int i=0; i< elem.size(); i++) {
            if(el.equals((MModelElement) elem.elementAt(i))) {
               con = true;
               break;
            }
          }
          return con;
        }

	/**
	 *  @author Camara Lenuseni, layekers@cs.tu-berlin.de
	 *  @param family type
	 * @return family 
	 * CoCons of the same family contained in the Constraint Diagram
	 *  Note: The return vector contains ONLY CoCons with a correct Syntax.  
	 * */
	public static final Vector getCoConsOfSameFamily(String familyType)
	{
		Vector family = new Vector();		
		Project theProject = ProjectBrowser.TheInstance.getProject();		
		Vector projectMembers = theProject.getMembers();
		for (int i = 0; i < projectMembers.size(); i++) 
		{
			if (projectMembers.elementAt(i) instanceof ProjectMemberDiagram) 
			{
				ProjectMemberDiagram memberDiag = (ProjectMemberDiagram) projectMembers.elementAt(i);
				ArgoDiagram diagram = memberDiag.getDiagram();
				
				// we are just interested in Constraint diagram				
				if(diagram.getName().substring(0,diagram.getName().length()-2).equals("ccl constraint diagram"))
				{
					String complete_cocon; // represents the whole syntax of the cocon
					Vector nodes = diagram.getNodes();
					for (int j = 0; j < nodes.size(); j++) 
					{
					if ( nodes.elementAt(j) instanceof MContextbasedConstraint && ( (MContextbasedConstraintImpl)nodes.elementAt(j)).getCoConType2().equals(familyType)) 
					 {
						MContextbasedConstraintImpl cocon = (MContextbasedConstraintImpl)nodes.elementAt(j);
						complete_cocon =""; // reset the value to empty string 
                        complete_cocon += cocon.getTargetSet()+ " MUST " + cocon.getConditionType()+" BE "+ cocon.getCoConType2()+ " " 
                        								+cocon.getScopeSet()+ " WITH "+cocon.getAttribute();
                       
                       // we only collect Context-Based Constraints if any exists                          
                       CCLParser parser = new CCLParser(new CCLLexer(new StringReader(complete_cocon)));      	
					   try
					   {
					      		parser.cocon_command();
					      		family.addElement(cocon);						      			
					   }
				    	catch(NoViableAltException ex3){ }
				    	catch(RecognitionException ex1){ }
				        catch(TokenStreamException ex2){}				        
					  }                               
					}                           
				}
			}
		}	
		return family;		
	}
	/**
	 * @author Camara Lenuseni, layekers@cs.tu-berlin.de 
	 * This Method returns all CoCons within the same family with a certain condition type
	 * @param family
	 * @param cond_type
	 * @return result
	 *  Note: we assume that the CoCons belong to same family 
	 */	
	public static final Vector getCoConsWithTypeCondition(String family, String cond_type)
	{
		Vector family_members = ModelIterator.getCoConsOfSameFamily(family);
		Vector result = new Vector();
		for(int i =0; i < family_members.size(); i++)
		{
			if ( ((MContextbasedConstraintImpl)family_members.elementAt(i)).getConditionType().equals(cond_type))
				{
					result.addElement(family_members.elementAt(i));
				}
		}
		return result;
	}
	/**
	 * @author Camara Lenuseni, layekers@cs.tu-berlin.de 
	 * This Method returns true if a Conflict has been detected within CoCons of the same family
	 * @param cocon
	 * @param members
	 * @return bool
	 *   Note: 
	 *  		1- We assume that the caller of this function checks this condition first...!
	 * 		2- The Syntax of each CoCon has been checked by the CCL-Parser
	 * */
	public static final boolean SearchForConflictWithinAccessibilityFamily(MContextbasedConstraint cocon1, MContextbasedConstraint cocon2, CriticInfo info)
	{	
		// We first retrieve all informations from our CoCon	
		MContextbasedConstraintImpl actual  = (MContextbasedConstraintImpl)cocon1;
		MContextbasedConstraintImpl suspected = (MContextbasedConstraintImpl)cocon2;
		String typecondition = actual.getConditionType();
		String targetset = actual.getTargetSet();
		String scopeset = actual.getScopeSet();
		Vector target_elements = ModelIterator.SINGLETON.getTargetSetElements(targetset);		
		Vector scope_elements = ModelIterator.SINGLETON.getScopeSetElements(scopeset);
		
		//check whether one of the sets is empty; in this case no need to continue because there's no conflict
		 if(!(target_elements.size()>0 || scope_elements.size() >0))
				return false;
		// No Type Condition was indicated
		if(typecondition.equals(""))
		{
			 if (suspected.getConditionType().equals("NOT"))
			 {		    	
		    	 //We retrieve informations to check whether a conflict exists
		    	  String T_set = suspected.getTargetSet();			    	  			    	  
		    	  String S_set = suspected.getScopeSet();
		    	  Vector t_elements = ModelIterator.SINGLETON.getTargetSetElements(T_set);
		    	  Vector s_elements = ModelIterator.SINGLETON.getScopeSetElements(S_set);
		    	  if(t_elements.size()== 0 ||s_elements.size()==0) 
		    	  		return false;		    	  		
		    	  for(int k=0; k < target_elements.size(); k++)
		    	  {
		    			MClassImpl me = (MClassImpl)target_elements.elementAt(k);
		    			if(!t_elements.contains(me)) 
		    				continue; // go..on 
		    			
		    			//Otherwise...
		    			for(int w =0; w < scope_elements.size(); w++)
		    			{
		    				if(s_elements.contains(s_elements.elementAt(w))) // Because of NOT
		    				{
	    						// Eureka....we've found a conflict and can break up the search, but we take care to tell the User more infos about that conflict
	    						info.setCriticHeadLine("Conflicts between(1<-2) "+ actual.getCoConName().toUpperCase() + " and "+suspected.getCoConName().toUpperCase()); 
	    						info.SetCriticReason(("Because of following Contraints Statements:").toUpperCase() 
	    										                 +"\nAccording to"+ actual.getCoConName().toUpperCase()+": The Component "+ me.getName()+ " which belongs to" 
	    										                 +" its target set must be "+ actual.getCoConType2() +" the Component "+ ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +"\nBut According to "+suspected.getCoConName().toUpperCase()+": The Component "+ me.getName()
	    				   										 +" which also belongs to its target set must " +suspected.getConditionType()+ " be "+suspected.getCoConType2()
	    				   										 + " the same element " + ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +("\n\nDiagnostic:").toUpperCase().concat("\nSo There is problem, and you'd better check your conditions again.") 
	    				   										 +("\n\nSuggestion:").toUpperCase().concat("\nMay be you should remove element(s) from one of the target set or the scope set of one CoCon.")); 
		    					return true;
		    				}
		    			}			    			
		    		}		    	
			    }
			
			 if (suspected.getConditionType().equals("ONLY"))
			 {		    	
		    	 //We retrieve informations to check whether a conflict exists
		    	  String T_set = suspected.getTargetSet();			    	  			    	  
		    	  String S_set = suspected.getScopeSet();
		    	  Vector t_elements = ModelIterator.SINGLETON.getTargetSetElements(T_set);
		    	  Vector s_elements = ModelIterator.SINGLETON.getScopeSetElements(S_set);
		    	  if(t_elements.size()== 0 ||s_elements.size()==0) 
		    	  		return false;		    	  		
		    	  for(int k=0; k < target_elements.size(); k++)
		    	  {
		    			MClassImpl me = (MClassImpl)target_elements.elementAt(k);
		    			if(!t_elements.contains(me)) 
		    				continue; // go..on 
		    			
		    			//Otherwise...
		    			for(int w =0; w < scope_elements.size(); w++)
		    			{
		    				if(!s_elements.contains(scope_elements.elementAt(w))) // Because of ONLY
		    				{
	    						// Eureka....we've found a conflict and can break up the search, but we take care to tell the User more infos about that conflict
	    						info.setCriticHeadLine("Conflicts between(1<-2) "+ actual.getCoConName().toUpperCase() + " and "+suspected.getCoConName().toUpperCase()); 
	    						info.SetCriticReason(("Because of following Contraints Statements:").toUpperCase() 
	    										                 +"\nAccording to"+ actual.getCoConName().toUpperCase()+": The Component "+ me.getName()+ " which belongs to" 
	    										                 +" its target set must be "+ actual.getCoConType2() +" the Component "+ ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +"\nBut According to "+suspected.getCoConName().toUpperCase()+": The Component "+ me.getName()
	    				   										 +" which also belongs to its target set must " +suspected.getConditionType()+ " be "+suspected.getCoConType2()
	    				   										 + " the same element " + ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +("\n\nDiagnostic:").toUpperCase().concat("\nSo There is problem, and you'd better check your conditions again.") 
	    				   										 +("\n\nSuggestion:").toUpperCase().concat("\nMay be you should remove element(s) from one of the target set or the scope set of one CoCon.")); 
		    					return true;
		    				}
		    			}			    			
		    		}		    	
			    }			
		}
		// The Type Condition is "NOT"
		else if(typecondition.equals("NOT"))
		{
			if (suspected.getConditionType().equals(""))
			 {		    	
		    	 //We retrieve informations to check whether a conflict exists
		    	  String T_set = suspected.getTargetSet();			    	  			    	  
		    	  String S_set = suspected.getScopeSet();
		    	  Vector t_elements = ModelIterator.SINGLETON.getTargetSetElements(T_set);
		    	  Vector s_elements = ModelIterator.SINGLETON.getScopeSetElements(S_set);
		    	  if(t_elements.size()== 0 ||s_elements.size()==0) 
		    	  		return false;		    	  		
		    	  for(int k=0; k < target_elements.size(); k++)
		    	  {
		    			MClassImpl me = (MClassImpl)target_elements.elementAt(k);
		    			if(!t_elements.contains(me)) 
		    				continue; // go..on 
		    			
		    			//Otherwise...
		    			for(int w =0; w < scope_elements.size(); w++)
		    			{
		    				if(s_elements.contains(s_elements.elementAt(w))) // Because of NOT
		    				{
	    						// Eureka....we've found a conflict and can break up the search, but we take care to tell the User more infos about that conflict
	    						info.setCriticHeadLine("Conflicts between(1<-2) "+ actual.getCoConName().toUpperCase() + " and "+suspected.getCoConName().toUpperCase()); 
	    						info.SetCriticReason(("Because of following Contraints Statements:").toUpperCase() 
	    										                 +"\nAccording to"+ actual.getCoConName().toUpperCase()+": The Component "+ me.getName()+ " which belongs to" 
	    										                 +" its target set must "+actual.getConditionType()+" be "+ actual.getCoConType2() +" the Component "+ ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +"\nBut According to "+suspected.getCoConName().toUpperCase()+": The Component "+ me.getName()
	    				   										 +" which also belongs to its target set must " +suspected.getConditionType()+ " be "+suspected.getCoConType2()
	    				   										 + " the same element" + ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +("\n\nDiagnostic:").toUpperCase().concat("\nSo There is problem, and you'd better check your conditions again.") 
	    				   										 +("\n\nSuggestion:").toUpperCase().concat("\nMay be you should remove element(s) from one of the target set or the scope set of one CoCon.")); 
		    					return true;
		    				}
		    			}			    			
		    		}		    	
			    }
			
			 if (suspected.getConditionType().equals("ONLY"))
			 {		    	
		    	 //We retrieve informations to check whether a conflict exists
		    	  String T_set = suspected.getTargetSet();			    	  			    	  
		    	  String S_set = suspected.getScopeSet();
		    	  Vector t_elements = ModelIterator.SINGLETON.getTargetSetElements(T_set);
		    	  Vector s_elements = ModelIterator.SINGLETON.getScopeSetElements(S_set);
		    	  if(t_elements.size()== 0 ||s_elements.size()==0) 
		    	  		return false;		    	  		
		    	  for(int k=0; k < target_elements.size(); k++)
		    	  {
		    			MClassImpl me = (MClassImpl)target_elements.elementAt(k);
		    			if(!t_elements.contains(me)) 
		    				continue; // go..on 
		    			
		    			//Otherwise...
		    			for(int w =0; w < scope_elements.size(); w++)
		    			{
		    				if(s_elements.contains(scope_elements.elementAt(w))) // Because of ONLY
		    				{
	    						// Eureka....we've found a conflict and can break up the search, but we take care to tell the User more infos about that conflict
	    						info.setCriticHeadLine("Conflicts between(1<-2) "+ actual.getCoConName().toUpperCase() + " and "+suspected.getCoConName().toUpperCase()); 
	    						info.SetCriticReason(("Because of following Contraints Statements:").toUpperCase() 
	    										                 +"\nAccording to"+ actual.getCoConName().toUpperCase()+": The Component "+ me.getName()+ " which belongs to" 
	    										                 +" its target set must "+ actual.getConditionType()+" be "+ actual.getCoConType2() +" the Component "+ ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +"\nBut According to "+suspected.getCoConName().toUpperCase()+": The Component "+ me.getName()
	    				   										 +" which also belongs to its target set must " +suspected.getConditionType()+ " be "+suspected.getCoConType2()
	    				   										 + " the same element " + ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +("\n\nDiagnostic:").toUpperCase().concat("\nSo There is problem, and you'd better check your conditions again.") 
	    				   										 +("\n\nSuggestion:").toUpperCase().concat("\nMay be you should remove element(s) from one of the target set or the scope set of one CoCon.")); 
		    					return true;
		    				}
		    			}			    			
		    		}		    	
			    }					
		}
		// The Type Condition is "ONLY"
		else if(typecondition.equals("ONLY"))	
		{
			if (suspected.getConditionType().equals(""))
			 {		    	
		    	 //We retrieve informations to check whether a conflict exists
		    	  String T_set = suspected.getTargetSet();			    	  			    	  
		    	  String S_set = suspected.getScopeSet();
		    	  Vector t_elements = ModelIterator.SINGLETON.getTargetSetElements(T_set);
		    	  Vector s_elements = ModelIterator.SINGLETON.getScopeSetElements(S_set);
		    	  if(t_elements.size()== 0 ||s_elements.size()==0) 
		    	  		return false;		    	  		
		    	  for(int k=0; k < target_elements.size(); k++)
		    	  {
		    			MClassImpl me = (MClassImpl)target_elements.elementAt(k);
		    			if(!t_elements.contains(me)) 
		    				continue; // go..on 
		    			
		    			//Otherwise...
		    			for(int w =0; w < s_elements.size(); w++)
		    			{
		    				if(!scope_elements.contains(s_elements.elementAt(w))) // Because of ONLY
		    				{
	    						// Eureka....we've found a conflict and can break up the search, but we take care to tell the User more infos about that conflict
	    						info.setCriticHeadLine("Conflicts between(1<-2) "+ actual.getCoConName().toUpperCase() + " and "+suspected.getCoConName().toUpperCase()); 
	    						info.SetCriticReason(("Because of following Contraints Statements:").toUpperCase() 
	    										                 +"\nAccording to"+ actual.getCoConName().toUpperCase()+": The Component "+ me.getName()+ " which belongs to" 
	    										                 +" its target set must "+actual.getConditionType()+ " be "+ actual.getCoConType2() +" the Component "+ ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +"\nBut According to "+suspected.getCoConName().toUpperCase()+": The Component"+ me.getName()
	    				   										 +" which also belongs to its Target Set must " +suspected.getConditionType()+ " be "+suspected.getCoConType2()
	    				   										 + " the same element" + ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +("\nDiagnostic").toUpperCase().concat(": So There is problem, and you'd better check your conditions again.") 
	    				   										 +("\nSuggestion").toUpperCase().concat(": May be you should remove element(s) from one of the target set or the scope set of one CoCon.")); 
		    					return true;
		    				}
		    			}			    			
		    		}		    	
			    }
			
			 if (suspected.getConditionType().equals("NOT"))
			 {		    	
		    	 //We retrieve informations to check whether a conflict exists
		    	  String T_set = suspected.getTargetSet();			    	  			    	  
		    	  String S_set = suspected.getScopeSet();
		    	  Vector t_elements = ModelIterator.SINGLETON.getTargetSetElements(T_set);
		    	  Vector s_elements = ModelIterator.SINGLETON.getScopeSetElements(S_set);
		    	  if(t_elements.size()== 0 ||s_elements.size()==0) 
		    	  		return false;		    	  		
		    	  for(int k=0; k < target_elements.size(); k++)
		    	  {
		    			MClassImpl me = (MClassImpl)target_elements.elementAt(k);
		    			if(!t_elements.contains(me)) 
		    				continue; // go..on 
		    			
		    			//Otherwise...
		    			for(int w =0; w < scope_elements.size(); w++)
		    			{
		    				if(s_elements.contains(scope_elements.elementAt(w))) // Because of NOT
		    				{
	    						// Eureka....we've found a conflict and can break up the search, but we take care to tell the User more infos about that conflict
	    						info.setCriticHeadLine("Conflicts between(1<-2) "+ actual.getCoConName().toUpperCase() + " and "+suspected.getCoConName().toUpperCase()); 
	    						info.SetCriticReason(("Because of following Contraints Statements:").toUpperCase() 
	    										                 +"\nAccording to"+ actual.getCoConName().toUpperCase()+": The Component "+ me.getName()+ " which belongs to" 
	    										                 +" its target set must "+ actual.getConditionType()+ " be "+ actual.getCoConType2() +" the Component "+ ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +"\nBut According to "+suspected.getCoConName().toUpperCase()+": The Component "+ me.getName()
	    				   										 +" which also belongs to its target set must " +suspected.getConditionType()+ " be "+suspected.getCoConType2()
	    				   										 + " the same element " + ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +("\n\nDiagnostic:").toUpperCase().concat("\nSo There is problem, and you'd better check your conditions again.") 
	    				   										 +("\n\nSuggestion:").toUpperCase().concat("\nMay be you should remove element(s) from one of the target set or the scope set of one CoCon.")); 
		    					return true;
		    				}
		    			}			    			
		    		}		    	
			    }					
		}
		return false;	
	}
	/**
	 * @author Camara Lenuseni, layekers@cs.tu-berlin.de 
	 * @param me
	 * @return result
	 * Returns All the dependencies of a Component in the CompSpecDiagram
	 */
	public static final Vector getAllClientDependencies(MClass me)
	{
		Vector result = new Vector();
		Collection col, clients;
		Project theProject = ProjectBrowser.TheInstance.getProject();		
		Vector projectMembers = theProject.getMembers();
		for (int i = 0; i < projectMembers.size(); i++) 
		{
			if (projectMembers.elementAt(i) instanceof ProjectMemberDiagram) 
			{
				ProjectMemberDiagram memberDiag = (ProjectMemberDiagram) projectMembers.elementAt(i);
				ArgoDiagram diagram = memberDiag.getDiagram();
				
				// we are only interested in Component specification diagram				
				if(diagram.getName().substring(0,diagram.getName().length()-2).equals("component specification diagram"))
				{					
					Vector nodes = diagram.getNodes();
					if(nodes.contains(me))
					{
						col = ((MClassImpl)me).getSupplierDependencies();
						Iterator it = col.iterator();
						while(it.hasNext())
						{	
							clients = ((MDependencyImpl)it.next()).getClients();
							Iterator it2 = clients.iterator();
								while(it2.hasNext())
									result.addElement(it2.next());
						}
					}
				}
			}
		}
		return result;
	}
	/**
	 *@author Camara Lenuseni, layekers@cs.tu-berlin.de
	 * @param cocon
	 * @param info
	 * @return bool
	 */
	public static final boolean SearchForAccessibilityConflictWithinProject(MContextbasedConstraint me, CriticInfo info)
	{		
		MContextbasedConstraintImpl cocon =(MContextbasedConstraintImpl)me; 
		Vector targetset_elements = ModelIterator.SINGLETON.getTargetSetElements(cocon.getTargetSet());
		Vector scopeset_elements  = ModelIterator.SINGLETON.getScopeSetElements(cocon.getScopeSet());
		Vector Client_dependencies = new Vector();
		
		if(!(targetset_elements.size()>0 ||scopeset_elements.size() >0))
			return false;
		String typecondition = cocon.getConditionType();
		// No Type Condition was indicated
		if(typecondition.equals(""))
		{
			return false; // ???
		}
		// The Type Condition is "NOT"
		else if(typecondition.equals("NOT"))
		{			
			for(int i = 0; i < targetset_elements.size(); i++)
			{
				Client_dependencies = ModelIterator.getAllClientDependencies((MClass)targetset_elements.elementAt(i));
				for(int j = 0; j < Client_dependencies.size(); j++)
				{
					if(scopeset_elements.contains(Client_dependencies.elementAt(j)))
					{
						info.setCriticHeadLine("Accessibilty CoCon has detected a conflict:");
						info.SetCriticReason("According to the CoCon "+ cocon.getCoConName()+ ":"
														 + "\nThe Component "+((MClassImpl)Client_dependencies.elementAt(j)).getName()+" should not access "
														 +"the component "+ ((MClassImpl)targetset_elements.elementAt(i)).getName()+"."
														 +("\n\nDiagnostic").toUpperCase()+":" + "\nA forbidden Access has been encountered."
														 +("\n\nSuggestion").toUpperCase()+":"+"\nCheck the modelElements or the concerned dependencies in your diagram.");														 
						return true;
					}					
				}				
			}						 
		}
		// The Type Condition is "ONLY"
		else if(typecondition.equals("ONLY"))	
		{
			for(int i = 0; i < targetset_elements.size(); i++)
			{
				Client_dependencies = ModelIterator.getAllClientDependencies((MClass)targetset_elements.elementAt(i));
				for(int j = 0; j < Client_dependencies.size(); j++)
				{
					if(!scopeset_elements.contains(Client_dependencies.elementAt(j)))
					{
						info.setCriticHeadLine("Accessibilty CoCon has detected a conflict:");
						info.SetCriticReason("According to the CoCon "+ cocon.getCoConName()+ ":"
														 + "\nThe Component "+((MClassImpl)Client_dependencies.elementAt(j)).getName()+" does not belong "
														 +"to its scope set, in order to access the component "+ ((MClassImpl)targetset_elements.elementAt(i)).getName()+"."
														 +("\n\nDiagnostic").toUpperCase()+":" + "\nA restricted Access has not been obeyed."
														 +("\n\nSuggestion").toUpperCase()+":"+"\nCheck the modelElements or the concerned dependencies in your diagram.");														 
						return true;
					}					
				}				
			}
		}
		return false;	
	}
/**
	 * @author Camara Lenuseni, layekers@cs.tu-berlin.de 
	 * This Method returns true if a Conflict has been detected within CoCons of the same family
	 * @param cocon
	 * @param members
	 * @return bool
	 *   Note: 
	 *  		1- We assume that the caller of this function checks this condition first...!
	 * 		2- The Syntax of each CoCon has been checked by the CCL-Parser
	 * */
public static final boolean SearchForConflictWithinTHESAMEASFamily(MContextbasedConstraint cocon1, MContextbasedConstraint cocon2, CriticInfo info)
{
		// We first retrieve all informations from our CoCon	
		MContextbasedConstraintImpl actual  = (MContextbasedConstraintImpl)cocon1;
		MContextbasedConstraintImpl suspected = (MContextbasedConstraintImpl)cocon2;
		String typecondition = actual.getConditionType();
		String targetset = actual.getTargetSet();
		String scopeset = actual.getScopeSet();
		Vector target_elements = ModelIterator.SINGLETON.getTargetSetElements(targetset);		
		Vector scope_elements = ModelIterator.SINGLETON.getScopeSetElements(scopeset);
		
		//check whether one of the sets is empty; in this case no need to continue because there's no conflict
		 if(!(target_elements.size()>0 || scope_elements.size() >0))
				return false;
		// No Type Condition was indicated
		if(typecondition.equals(""))
		{
			 if (suspected.getConditionType().equals("NOT"))
			 {		    	
		    	 //We retrieve informations to check whether a conflict exists
		    	  String T_set = suspected.getTargetSet();			    	  			    	  
		    	  String S_set = suspected.getScopeSet();
		    	  Vector t_elements = ModelIterator.SINGLETON.getTargetSetElements(T_set);
		    	  Vector s_elements = ModelIterator.SINGLETON.getScopeSetElements(S_set);
		    	  if(t_elements.size()== 0 ||s_elements.size()==0) 
		    	  		return false;		    	  		
		    	  for(int k=0; k < target_elements.size(); k++)
		    	  {
		    			MClassImpl me = (MClassImpl)target_elements.elementAt(k);
		    			if(!t_elements.contains(me)) 
		    				continue; // go..on 
		    			
		    			//Otherwise...
		    			for(int w =0; w < scope_elements.size(); w++)
		    			{
		    				if(s_elements.contains(s_elements.elementAt(w))) // Because of NOT
		    				{
	    						// Eureka....we've found a conflict and can break up the search, but we take care to tell the User more infos about that conflict
	    						info.setCriticHeadLine("Conflicts between(1<-2) "+ actual.getCoConName().toUpperCase() + " and "+suspected.getCoConName().toUpperCase()); 
	    						info.SetCriticReason(("Because of following Contraints Statements:").toUpperCase() 
	    										                 +"\n\nAccording to"+ actual.getCoConName().toUpperCase()+": The Element "+ me.getName()+ " which belongs to" 
	    										                 +" its target set must be "+ actual.getCoConType2() +" the Element "+ ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +"\n\nBut According to "+suspected.getCoConName().toUpperCase()+": The Element "+ me.getName()
	    				   										 +" which also belongs to its target set must " +suspected.getConditionType()+ " be "+suspected.getCoConType2()
	    				   										 + " the same element " + ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +("\n\nDiagnostic:").toUpperCase().concat("\nSo There is problem, and you'd better check your conditions again.") 
	    				   										 +("\n\nSuggestion:").toUpperCase().concat("\n May be you should remove element(s) from one of the target set or the scope set of one CoCon.")); 
		    					return true;
		    				}
		    			}			    			
		    		}		    	
			    }
		}
		if(typecondition.equals("NOT"))
		{
			 if (suspected.getConditionType().equals(""))
			 {		    	
		    	 //We retrieve informations to check whether a conflict exists
		    	  String T_set = suspected.getTargetSet();			    	  			    	  
		    	  String S_set = suspected.getScopeSet();
		    	  Vector t_elements = ModelIterator.SINGLETON.getTargetSetElements(T_set);
		    	  Vector s_elements = ModelIterator.SINGLETON.getScopeSetElements(S_set);
		    	  if(t_elements.size()== 0 ||s_elements.size()==0) 
		    	  		return false;		    	  		
		    	  for(int k=0; k < target_elements.size(); k++)
		    	  {
		    			MClassImpl me = (MClassImpl)target_elements.elementAt(k);
		    			if(!t_elements.contains(me)) 
		    				continue; // go..on 
		    			
		    			//Otherwise...
		    			for(int w =0; w < scope_elements.size(); w++)
		    			{
		    				if(s_elements.contains(s_elements.elementAt(w))) // Because of NOT
		    				{
	    						// Eureka....we've found a conflict and can break up the search, but we take care to tell the User more infos about that conflict
	    						info.setCriticHeadLine("Conflicts between(1<-2) "+ actual.getCoConName().toUpperCase() + " and "+suspected.getCoConName().toUpperCase()); 
	    						info.SetCriticReason(("Because of following Contraints Statements:").toUpperCase() 
	    										                 +"\n\nAccording to"+ actual.getCoConName().toUpperCase()+": The Element "+ me.getName()+ " which belongs to" 
	    										                 +" its target set must "+actual.getConditionType()+" be "+ actual.getCoConType2() +" the Element "+ ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +"\n\nBut According to "+suspected.getCoConName().toUpperCase()+": The Elemen t"+ me.getName()
	    				   										 +" which also belongs to its target set must " +suspected.getConditionType()+ " be "+suspected.getCoConType2()
	    				   										 + " the same element " + ((MClassImpl)scope_elements.elementAt(w)).getName()+" ."
	    				   										 +("\n\nDiagnostic:").toUpperCase().concat("\nSo There is problem, and you'd better check your conditions again.") 
	    				   										 +("\n\nSuggestion:").toUpperCase().concat("\nMay be you should remove element(s) from one of the target set or the scope set of one CoCon.")); 
		    					return true;
		    				}
		    			}			    			
		    		}		    	
			    }
		}
	return false;	
}
/**
	 *@author Camara Lenuseni, layekers@cs.tu-berlin.de
	 * @param cocon
	 * @param info
	 * @return bool
	 */
public static final boolean SearchForTHESAMEASConflictWithinProject(MContextbasedConstraint me, CriticInfo info)
{
	MContextbasedConstraintImpl cocon =(MContextbasedConstraintImpl)me; 
	Vector targetset_elements = ModelIterator.SINGLETON.getTargetSetElements(cocon.getTargetSet());
	Vector scopeset_elements  = ModelIterator.SINGLETON.getScopeSetElements(cocon.getScopeSet());
		
	if(!(targetset_elements.size()>0 ||scopeset_elements.size() >0))
		return false;
	String typecondition = cocon.getConditionType();
	// No Type Condition was indicated
	if(typecondition.equals(""))
	{		
		     for(int i = 0; i < targetset_elements.size(); i++)
			{				
					if(!scopeset_elements.contains(targetset_elements.elementAt(i)))
					{
						info.setCriticHeadLine("Value-Binding CoCon has detected a conflict:");
						info.SetCriticReason("According to the CoCon "+ cocon.getCoConName()+ ":"
														 + "\nThe Element "+((MClassImpl)targetset_elements.elementAt(i)).getName()+" should be contained "+"in its scope set."
														 +("\n\nDiagnostic:").toUpperCase()+ "\nA Restriction made by "+ cocon.getCoConName()+" has not been considered."
														 +("\n\nSuggestion:").toUpperCase()+"\nCheck the modelElements or the assigned context properties in your diagram.");														 
						return true;   
						
					}									
			}		
		
	}
	if(typecondition.equals("NOT"))
	{
		 for(int i = 0; i < targetset_elements.size(); i++)
			{				
					if(scopeset_elements.contains(targetset_elements.elementAt(i)))
					{
						info.setCriticHeadLine("Value-Binding CoCon has detected a conflict:");
						info.SetCriticReason("According to the CoCon "+ cocon.getCoConName()+ ":"
														 + "\nThe Element "+((MClassImpl)targetset_elements.elementAt(i)).getName()+" should not be contained "+"in its scope set."
														 +("\n\nDiagnostic:").toUpperCase() + "\nA Restriction made by "+ cocon.getCoConName()+" has not been considered."
														 +("\n\nSuggestion:").toUpperCase()+"\nCheck the modelElements or the assigned context properties in your diagram.");														 
						return true;   
						
					}									
			}
	}
	return false;    
}

/**
	 * @author Camara Lenuseni, layekers@cs.tu-berlin.de 
	 * This Method returns true if a Conflict has been detected within CoCons of the same family
	 * @param cocon
	 * @param members
	 * @return bool
	 *   Note: 
	 *  		1- We assume that the caller of this function checks this condition first...!
	 * 		2- The Syntax of each CoCon has been checked by the CCL-Parser
	 * */
public static final boolean SearchForConflictWithinFTCCFamily(MContextbasedConstraint cocon1, MContextbasedConstraint cocon2, CriticInfo info)
{
	return ModelIterator.SINGLETON.SearchForConflictWithinTHESAMEASFamily(cocon1, cocon2, info);
}
/**
	 *@author Camara Lenuseni, layekers@cs.tu-berlin.de
	 * @param cocon
	 * @param info
	 * @return bool
	 */
public static final boolean SearchForFTCCConflictWithinProject(MContextbasedConstraint me, CriticInfo info)
{
	MContextbasedConstraintImpl cocon =(MContextbasedConstraintImpl)me; 
	Vector targetset_elements = ModelIterator.SINGLETON.getTargetSetElements(cocon.getTargetSet());
	Vector scopeset_elements  = ModelIterator.SINGLETON.getScopeSetElements(cocon.getScopeSet());
		
	if(!(targetset_elements.size()>0 ||scopeset_elements.size() >0))
		return false;
	String typecondition = cocon.getConditionType();
	// No Type Condition was indicated
	if(typecondition.equals(""))
	{
		if( !(targetset_elements.size() > scopeset_elements.size() )) // the scope set must at least be greater than or equal to the target set...!
			return false;
		
		     for(int i = 0; i < targetset_elements.size(); i++)
			{				
					if(!scopeset_elements.contains(targetset_elements.elementAt(i)))
					{
						info.setCriticHeadLine("Value-Binding CoCon has detected a conflict:");
						info.SetCriticReason("According to the CoCon "+ cocon.getCoConName()+ ":"
														 + "\nThe Element "+((MClassImpl)targetset_elements.elementAt(i)).getName()+" should be contained "+"in its scope set."
														 +("\n\nDiagnostic:").toUpperCase() + "\nA Restriction made by "+ cocon.getCoConName()+" has not been considered."
														 +("\n\nSuggestion:").toUpperCase()+"\nCheck the modelElements or the assigned context properties in your diagram.");														 
						return true;   
						
					}									
			}		
		
	}
	if(typecondition.equals("NOT"))
	{
		 for(int i = 0; i < targetset_elements.size(); i++)
			{				
					if(scopeset_elements.contains(targetset_elements.elementAt(i)))
					{
						info.setCriticHeadLine("Value-Binding CoCon has detected a conflict:");
						info.SetCriticReason("According to the CoCon "+ cocon.getCoConName()+ ":"
														 + "\nThe Element "+((MClassImpl)targetset_elements.elementAt(i)).getName()+" should not be contained "+"in its scope set."
														 +("\n\nDiagnostic:").toUpperCase() + " A Restriction made by "+ cocon.getCoConName()+" has not been considered."
														 +("\n\nSuggestion:").toUpperCase()+" Check the modelElements or the assigned context properties in your diagram.");														 
						return true;   
						
					}									
			}
	}
	return false;    
}
}


