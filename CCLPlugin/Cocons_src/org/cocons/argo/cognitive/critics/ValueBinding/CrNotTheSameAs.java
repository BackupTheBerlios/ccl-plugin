/**
 * Created on 08.05.2003
 *  */

package org.cocons.argo.cognitive.critics.ValueBinding;

/**
 * This class implements the "AccessibleTo" Design Critic with "NOT" as condition type
 * @author Camara Lenuseni, layekers@cs.tu-berlin.de
 *
 */
import java.util.Collection;
import org.argouml.cognitive.Designer;
import org.cocons.argo.util.ModelIterator;
import org.cocons.argo.cognitive.critics.CrCoCon;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;
/**
 * This Cocon type is bi-directional: the both sets must contains exactly the same elements.
 */

public class CrNotTheSameAs extends CrCoCon
{
	public CrNotTheSameAs()
	{
		super();
		setHeadline("Value-Binding problem(s) have encountered. Please check the existing Value-Binding Cocons in your model");
		setKnowledgeTypes(KT_CONSISTENCY, KT_CORRECTNESS,KT_SEMANTICS);
		setExpertEmail("layekers@cs.tu-berlin.de");
		setPriority(1);
		setDescription("The elements of the target set of a << NOT THE SAME AS>> CoCon must NOT be the same as those of the scope");

	}
	
	public boolean predicate2(Object dm, Designer dsgr) {
    if (!(dm instanceof MContextbasedConstraint)) 
    	return NO_PROBLEM;
    MContextbasedConstraintImpl e = (MContextbasedConstraintImpl) dm;        
    /**
     * first check whether the cocon type is actually of type "THE SAME AS"
     */
    if (!e.getCoConType2().equals("THE SAME AS"))
    	return NO_PROBLEM;
    	    
    /**
     * Now let's check whether the condition type is "NOT"
     */    
    if (!e.getConditionType().equals("NOT"))
    	return NO_PROBLEM;	
	/**
     *  So we can process...
     */    
	//We group CoCons of the same family and retain ONLY those with a correct syntax and which could stand for a possible conflict 
    java.util.Vector Suspected_Family = ModelIterator.SINGLETON.getCoConsWithTypeCondition(e.getCoConType2(), "");       
    /*
     * First Level
     * Automatically discovered Conflicts 
     */    
    if(Suspected_Family.size() > 0)    // we have at least two CoCons of the same family...
    {
    	for(int i = 0; i < Suspected_Family.size(); i++)
    	{
	     if (ModelIterator.SINGLETON.SearchForConflictWithinTHESAMEASFamily(e,(MContextbasedConstraint)Suspected_Family.elementAt(i), c_info) == true)	
	     {
	    	return PROBLEM_FOUND;	
	     }
    	}
    }
    
	 if (ModelIterator.SINGLETON.SearchForTHESAMEASConflictWithinProject(e, c_info) == true)	
	     {
	    	return PROBLEM_FOUND;	
	     }
	
    
    return NO_PROBLEM;
    
  }

}
