/**
 * Created on 08.05.2003 
 */
package org.cocons.argo.cognitive.critics.Accessibility;
/**
 * This class implements the "AccessibleTo" Design Critic with no condition type
 * @author layekers

 */
import java.io.*;
import java.util.Collection;
import java.util.Vector;
import org.argouml.cognitive.Designer;
import org.cocons.argo.util.ModelIterator;
import org.cocons.argo.cognitive.critics.CrCoCon;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;
import ru.novosoft.uml.foundation.extension_mechanisms.MStereotypeImpl;

public class CrAccessibleTo extends CrCoCon
{
	public CrAccessibleTo()
	{
		super();
		setHeadline("Accessibility problem(s) have encountered.");
		setKnowledgeTypes(KT_CONSISTENCY, KT_CORRECTNESS,KT_SEMANTICS);
		setExpertEmail("layekers@cs.tu-berlin.de");
		setPriority(1);
		setDescription("An << ACCESSIBLE TO>> CoCon defines that the components in its target set are accessible to the components in the scope set"
								 +"\n Please check the existing Accessibiltity Cocons in your model");
	}	
	
	public boolean predicate2(Object dm, Designer dsgr) 
	{
    if (!(dm instanceof MContextbasedConstraint)) 
    	return NO_PROBLEM;
    MContextbasedConstraintImpl e = (MContextbasedConstraintImpl) dm;       
    /**
     * first check whether the cocon type is actually of type "ACCESSIBLE TO"
     */
    if (!e.getCoConType2().equals("ACCESSIBLE TO"))
    	return NO_PROBLEM;
    	    
    /**
     * Now let's check whether the condition type is matches empty string
     */    
    if (!e.getConditionType().equals("") ||e.getConditionType().length() != 0)
    	return NO_PROBLEM;	
	  
    //We group CoCons of the same family and retain ONLY those with a correct syntax and which could stand for a possible conflict 
    Vector Suspected_Family1 = ModelIterator.SINGLETON.getCoConsWithTypeCondition(e.getCoConType2(), "NOT");
    Vector Suspected_Family2 = ModelIterator.SINGLETON.getCoConsWithTypeCondition(e.getCoConType2(), "ONLY");    
    /*
     * First Level
     * Automatically discovered Conflicts 
     */
    
    if(Suspected_Family1.size() > 0)    // we have at least two CoCons of the same family...
    {
    	for(int i = 0; i < Suspected_Family1.size(); i++)
    	{
	     if (ModelIterator.SINGLETON.SearchForConflictWithinAccessibilityFamily(e,(MContextbasedConstraint)Suspected_Family1.elementAt(i), c_info) == true)	
	     {
	    	return PROBLEM_FOUND;	
	     }
    	}
    }	
    // That means that no conflicting "NOT ACCESSIBLE TO" cocon has been found, so what about "ONLY ACCESSIBLE TO" cocons?? 
    if(Suspected_Family2.size() > 0)    // we have at least two CoCons of the same family...
    {
    	for(int i = 0; i < Suspected_Family2.size(); i++)
    	{
	     if (ModelIterator.SINGLETON.SearchForConflictWithinAccessibilityFamily(e,(MContextbasedConstraint)Suspected_Family2.elementAt(i), c_info) == true)	
	     {
	    	return PROBLEM_FOUND;	
	     }
    	}
    }
    	
	/**
	 * Second Level
	 * Check all our project and search for forbidden dependencies 
	 */
	
	 if (ModelIterator.SINGLETON.SearchForAccessibilityConflictWithinProject(e, c_info) == true)	
	     {
	    	return PROBLEM_FOUND;	
	     }

	return NO_PROBLEM;
	}

}

