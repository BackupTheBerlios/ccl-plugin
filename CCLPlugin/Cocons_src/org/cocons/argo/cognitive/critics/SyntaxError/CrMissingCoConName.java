/**
 * Created on 28.05.2003 
 */
package org.cocons.argo.cognitive.critics.SyntaxError;

import java.util.Collection;
import org.cocons.uml.ccl.util.*;
import org.argouml.cognitive.Designer;
import org.cocons.argo.cognitive.critics.CrCoCon;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;
/**
 * @author Camara Lenuseni, layekers@cs.tu-berlin.de  
 */

public class CrMissingCoConName extends CrCoCon
{
	public CrMissingCoConName()
	{
		super();
		setHeadline("The Name of this CoCon is missing.");
		setKnowledgeTypes(KT_COMPLETENESS);
		setExpertEmail("layekers@cs.tu-berlin.de");
		setPriority(2);
		setDescription("Please enter the name of this CoCon."
									+"\nThe CoCon Name will be used by the Critic Mechanismus to help you find out, which CoCon are involved in a conflict."
									+"\nIf this information is missing, you could spend more time grubbling about the found conflict.");

	}
	
	public boolean predicate2(Object dm, Designer dsgr) {
    if (!(dm instanceof MContextbasedConstraint)) 
    	return NO_PROBLEM;
    	
    MContextbasedConstraintImpl e = (MContextbasedConstraintImpl) dm;    
    
    if(e.getCoConName().equals("anon") ||e.getCoConName().equals(""))
    {
    	return PROBLEM_FOUND;
    }    
	
    return NO_PROBLEM;

}
}
