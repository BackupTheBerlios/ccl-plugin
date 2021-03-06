/**
 * Created on 08.05.2003
 * 
 */
package org.cocons.argo.cognitive.critics.ValueBinding;
/**
 * This class implements the "FulfillingTheContextConditionOf" Design Critic with no condition type
 * @author Camara Lenuseni, layekers@cs.tu-berlin.de
 */
import java.util.Collection;
import org.argouml.cognitive.Designer;
import org.cocons.argo.util.ModelIterator;
import org.cocons.argo.cognitive.critics.CrCoCon;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;

public class CrFulfillingTheContextConditionOf extends CrCoCon
{
	public CrFulfillingTheContextConditionOf()
	{
		super();
		setHeadline("Value-Binding problem(s) have encountered. Please check the existing Value-Binding Cocons in your model");
		setKnowledgeTypes(KT_CONSISTENCY, KT_CORRECTNESS,KT_SEMANTICS);
		setExpertEmail("layekers@cs.tu-berlin.de");
		setPriority(1);
		setDescription("The elements of the target set of a << FULFILLING THE CONTEXT CONDITION OF>> CoCon must fulfill the scope set's context condition");

	}
	public boolean predicate2(Object dm, Designer dsgr) {
    if (!(dm instanceof MContextbasedConstraint)) 
    	return NO_PROBLEM;
    MContextbasedConstraintImpl e = (MContextbasedConstraintImpl) dm;        
    /**
     * first check whether the cocon type is actually of type "FULFILLING THE CONTEXT CONDITION OF"
     */
    if (!e.getCoConType2().equals("FULFILLING THE CONTEXT CONDITION OF"))
    	return NO_PROBLEM;    	    
    /**
     * Now let's check whether the condition type is matches empty string
     */    
    if (!e.getConditionType().equals("") ||e.getConditionType().length() != 0)
    	return NO_PROBLEM;
	
	/**
     *  So we can process...
     */    
   //We group CoCons of the same family and retain ONLY those with a correct syntax and which could stand for a possible conflict 
    java.util.Vector Suspected_Family = ModelIterator.SINGLETON.getCoConsWithTypeCondition(e.getCoConType2(), "NOT");       
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
