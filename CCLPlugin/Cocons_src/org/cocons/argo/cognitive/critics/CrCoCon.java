package org.cocons.argo.cognitive.critics;

import org.argouml.ui.ProjectBrowser;
import org.argouml.kernel.Project;
import org.argouml.cognitive.Decision;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.critics.Critic;
import org.argouml.cognitive.DesignMaterial;
import org.cocons.uml.ccl.MContextbasedConstraint;
import java.util.Collection;

/**
 * Title: CoCons
 * Description: Abstract Critic subclass that defines and registers
 * the CONSTRAINT-category of design decision that the critics can
 * address. In contrast to the CrUML-class this class can be placed in a plugin
 * without placing static variables in the UMLCognitiveResourceBundle to define
 * the headline of this DesignCritic.
 *
 * TODO: ResourceBundles instead of setHeadline and setDescription resprectivly
 *		, maybe better extending CrUML instead of Critic.
 *
 * @see org.argouml.cognitive.Designer
 * @see org.argouml.cognitive.DecisionModel
 * @see org.argouml.uml.cognitive.critics.UMLCognitiveResourceBundle
 * @see org.argouml.uml.cognitive.critics.CrUML

 * Copyright:    Copyright (c) 2001
 * Company: TU Berlin, CIS
 * @author Fadi Chabarek
 * @author Camara Lenuseni, layekers@cs.tu-berlin.de
 * @version 1.0
 */
 

public class CrCoCon extends Critic 
{
	/**
	 * This Field has been introduced to give more information about the reason of the conflict
	 */
  protected CriticInfo c_info = new CriticInfo(); 
  
  /**
   * Contains a Contraint-Decision
   */
  public static final Decision decCONSTRAINT = new Decision("Constraint", 1);
  
 /**
  * @author Camara Lenuseni, layekers@cs.tu-berlin.de
   * For the wrong Syntax Design Critics Decision
   */
  public static final Decision decWRONG_SYNTAX = new Decision("Constraint", 2);
  
   /**
  * @author Camara Lenuseni, layekers@cs.tu-berlin.de
   * For the Missing Part of a CoCon  Design Critics Decision
   */
  public static final Decision decMISSING_PART = new Decision("Constraint", 3);
  /**
   *  The more info url
   */
  public static final String MORE_INFO_URL = "www.cocons.org";

   /** Static initializer for this class. Called when the class is
	*  loaded (which is before any subclass instances are instanciated).
	*  The decision will now be considered by the designer, so that
	*  extending classes just have to add the Contraint-Decision to their
	*  supported Decisions.
	*/
  static {
	Designer d = Designer.theDesigner();
	d.startConsidering(decCONSTRAINT);
	d.startConsidering(decWRONG_SYNTAX);
	d.startConsidering(decMISSING_PART);
  }

  /**
   * Constructs a CrCoCon.
   */
  public CrCoCon() {
	// makes the critique active
	addSupportedDecision(CrCoCon.decCONSTRAINT);
	addSupportedDecision(CrCoCon.decWRONG_SYNTAX);
	addSupportedDecision(CrCoCon.decMISSING_PART);
	setMoreInfoURL(MORE_INFO_URL);
  }    

  /**
   * Returns true if a Contextbased Constraint is violated.
   */
  public boolean predicate(Object dm, Designer dsgr) 
  {
	Project p = ProjectBrowser.TheInstance.getProject();
    if (p.isInTrash(dm)) 
    {
      cat.debug("in trash:" + dm);
      return NO_PROBLEM;
    }
    else 
    	return predicate2(dm, dsgr);
  } 	 
  
 public boolean predicate2(Object dm, Designer dsgr) {
    return super.predicate(dm, dsgr);
  }

  public void postItem(ToDoItem item, Object dm, Designer dsgr) 
  {
  	if(!c_info.getCriticHeadLine().equals(""))
  		item.setHeadline(c_info.getCriticHeadLine());
  	if(!c_info.getCriticReason().equals(""))
  		item.setDescription(c_info.getCriticReason());
    if (dm instanceof DesignMaterial) 
    	((DesignMaterial)dm).inform(item);
    dsgr.inform(item);
  }

}	