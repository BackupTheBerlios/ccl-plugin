/**
 * Created on 24.05.2003
 */
package org.cocons.argo.cognitive.critics.SyntaxError;

import java.io.*;
import java.util.Collection;
import org.cocons.uml.ccl.util.*;
import antlr.NoViableAltException;
import antlr.RecognitionException;
import antlr.TokenStreamException;
import org.argouml.cognitive.Designer;
import org.cocons.argo.cognitive.critics.CrCoCon;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;
/**
 * @author Camara Lenuseni, layekers@cs.tu-berlin.de 
 */

public class CrWrongAttribute extends CrCoCon
{
	public CrWrongAttribute()
	{
		super();
		setHeadline("The actual Attribute(s) part of this CoCon is not conform to the CCL Syntax.");
		setKnowledgeTypes(KT_SYNTAX, KT_CONSISTENCY);
		setExpertEmail("layekers@cs.tu-berlin.de");
		setPriority(2);
		setDescription("According to the CCL-EBNF, the Attribute(s) part is not correct.Please check its syntax again"
								+"\nMore about the whole Syntax is available on http://www.cocons.org or in my Thesis.");

	}
	
	public boolean predicate2(Object dm, Designer dsgr) {
    if (!(dm instanceof MContextbasedConstraint)) 
    	return NO_PROBLEM;
    MContextbasedConstraintImpl e = (MContextbasedConstraintImpl) dm;    
    String myAttribute = e.getAttribute();
    /**
     * Let the CCL-Parser check whether the attribute(s) conforms to the CCL-Syntax
     */
    
	StringReader sr = new StringReader(myAttribute);
	CCLLexer lexer = new CCLLexer(sr);
	CCLElementParser parser = new CCLElementParser(lexer);      	
    
    if(e.getAttribute().trim().equals("") || e.getAttribute().length()==0)
    {
    	return NO_PROBLEM;
    } 
    
    else
    {
    	 try
    	 {
      		parser.attribute_statement();    		 		
    	 }
    	catch(NoViableAltException ex3){return PROBLEM_FOUND; }
    	catch(RecognitionException ex1){ return PROBLEM_FOUND;}
        catch(TokenStreamException ex2){ return PROBLEM_FOUND;}
    }           
    return NO_PROBLEM;
    
  }

}
