/**
 * Created on 24.05.2003 
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

public class CrMissingAttribute extends CrCoCon
{
	public CrMissingAttribute()
	{
		super();
		setHeadline("The Attribute(s) of this CoCon is missing.");
		setKnowledgeTypes(KT_COMPLETENESS);
		setExpertEmail("layekers@cs.tu-berlin.de");
		setPriority(3);
		setDescription("Please enter the Attribute(s). It not tremendous, but these Informations could be important within a big project"
									+"\ne.g. who have edited this CoCon, or further expected actions.");

	}
	
	public boolean predicate2(Object dm, Designer dsgr) {
    if (!(dm instanceof MContextbasedConstraint)) 
    	return NO_PROBLEM;
    	
    MContextbasedConstraintImpl e = (MContextbasedConstraintImpl) dm;    
       
    if(e.getAttribute().trim().equals("") || e.getAttribute().length()==0)
    {
    	return PROBLEM_FOUND;
    }    
	
    return NO_PROBLEM;

}
}
