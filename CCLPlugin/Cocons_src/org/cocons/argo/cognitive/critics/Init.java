package org.cocons.argo.cognitive.critics;

import org.argouml.cognitive.critics.Agency;
import org.argouml.cognitive.critics.Critic;
import org.cocons.argo.cognitive.critics.SyntaxError.*;
import org.cocons.argo.cognitive.critics.Accessibility.*;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;
import org.cocons.argo.cognitive.critics.ValueBinding.*;

import ru.novosoft.uml.foundation.core.MModelElementImpl;

/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      Technical University of Berlin, Dept. of Computer Science
 * @author Fadi Chabarek, Stefan Tang, Philipp Schumacher
 *@author Camara Lenuseni , layekers@cs.tu-berlin.de
 *  @version 1.0
 *
 * A Plugin Initializer registering CCL-supported design critics to ArgoUml.
 *
 */

public class Init implements Runnable 
{

private Critic[] allcritics ={
												new CrTheSameAs(),
												new CrNotTheSameAs(),	
												new CrAccessibleTo(), 
												new CrNotAccessibleTo(), 
												new CrOnlyAccessibleTo(), 
												new CrFulfillingTheContextConditionOf(), 
												new CrNotFulfillingTheContextConditionOf(), 
												new CrWrongTargetSet(), 
												new CrWrongScopeSet(), 
												new CrMissingTargetSet(), 
												new CrMissingScopeSet(), 
												new CrMissingAttribute(), 
												new CrWrongAttribute(), 
												new CrMissingCoConName(), 	 					
											};
  /*
   * Constructs an Initilizer
   */
  public Init() {
	super();
  }
/**
 * This Method registers each Critic Class i've implemented with the Agency 
 * @author Camara Lenuseni, layekers@cs.tu-berlin.de
 */
private void RegisterAllCritics()
{
	java.lang.Class cls = MContextbasedConstraintImpl.class ; //MModelElementImpl.class;
	for(int i= 0; i< allcritics.length; i++)
		Agency.register(allcritics[i],cls);
			
}
/**
 * This Method force the Activation of each Critic Class i've implemented.
 * @author Camara Lenuseni, layekers@cs.tu-berlin.de
 */
 private void ActivateAllCritics()
 {
 	for(int i =0; i< allcritics.length; i++)
 		allcritics[i].beActive();
 }
  /*
   * Registers And make all the Critics active.
   */
  public void run() 
  {
  	RegisterAllCritics();
  	ActivateAllCritics();  	
  }
}