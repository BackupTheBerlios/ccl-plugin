/**
 * Created on 23.05.2003 
 */

package org.cocons.argo.cognitive.critics.SyntaxError;

import java.util.Collection;
import org.cocons.uml.ccl.util.*;
import org.argouml.cognitive.Designer;
import org.cocons.argo.cognitive.critics.CrCoCon;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;

/**
 * @author Camara Lenuseni , layekers@cs.tu-berlin.de 
 */
public class CrMissingTargetSet extends CrCoCon
{
	public CrMissingTargetSet()
	{
		super();
		setHeadline("The Target Set of this CoCon is empty.");
		setKnowledgeTypes(KT_COMPLETENESS);
		setExpertEmail("layekers@cs.tu-berlin.de");
		setPriority(3);
		setDescription("Please enter the target set. A missing target set expresses an incomplete CoCon, implies an Syntax Error and"
								+"\ncan not be considered by the Critic mechanism.");

	}
	
	public boolean predicate2(Object dm, Designer dsgr) {
    if (!(dm instanceof MContextbasedConstraint)) 
    	return NO_PROBLEM;
    	
    MContextbasedConstraintImpl e = (MContextbasedConstraintImpl) dm;    
    
    if(e.getTargetSet().equals(""))
    {
    	return PROBLEM_FOUND;
    }    
	
    return NO_PROBLEM;
    
  }

}
