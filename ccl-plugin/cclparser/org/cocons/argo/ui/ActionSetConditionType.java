/**
 * Created on 03.05.2003
 *@author Camara Lenuseni, layekers@cs.tu-berlin.de 
 */

package org.cocons.argo.ui;
/**
 * @author  Camara Lenuseni, layekers@cs.tu-berlin.de 
 */
import org.cocons.uml.ccl.*;
import java.awt.event.ActionEvent;

import org.argouml.application.api.Argo;
import org.argouml.model.uml.behavioralelements.usecases.UseCasesHelper;
import org.argouml.uml.ui.UMLChangeAction;
import org.argouml.uml.ui.UMLComboBox2;

public class ActionSetConditionType extends UMLChangeAction
{
	public static final ActionSetConditionType SINGLETON = new ActionSetConditionType();

    /** 
     * Constructor for ActionSetConditionType.
     * @param s
     */
    protected ActionSetConditionType() {
        super(Argo.localize("CoreMenu", "Set"), true, NO_ICON);
    }
   
    /**
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
     public void actionPerformed(ActionEvent e) 
     {             
        super.actionPerformed(e);
        Object source = e.getSource();
        MContextbasedConstraint cocon = null;
        String oldconditiontype = null; ;//= "";
        String newconditiontype =  "";
        String empty ="";
        
         if (source instanceof UMLComboBox2) 
        {
            UMLComboBox2 combo = (UMLComboBox2)source;
            newconditiontype = (String)combo.getSelectedItem();
                         	            
            if (combo.getTarget() instanceof MContextbasedConstraint)             
                cocon = (MContextbasedConstraintImpl)combo.getTarget();
            
        }
        oldconditiontype = ((MContextbasedConstraintImpl)cocon).getConditionType();          
      
      try
      	  { if (newconditiontype == null) 
      	  	{
      	  		((UMLComboBox2)source).setSelectedItem(((MContextbasedConstraintImpl)cocon).getConditionType()); 
      	  		return;      	  		
      	  	}           
                
		        if ( !newconditiontype.equals(oldconditiontype) && cocon != null)
		         {
				         	if(newconditiontype.equals(empty))
				         	{
				         		((MContextbasedConstraintImpl)cocon).setConditionType(empty);
				         		((UMLComboBox2)source).setSelectedItem(((MContextbasedConstraintImpl)cocon).getConditionType()); 
				         	}
				         	if (!(newconditiontype.equals(empty)))
				         	{         		
				         		  ((MContextbasedConstraintImpl)cocon).setConditionType(newconditiontype);
				         		  ((UMLComboBox2)source).setSelectedItem(((MContextbasedConstraintImpl)cocon).getConditionType()); 
				         	}
				         	else 
				         	{
				         		((MContextbasedConstraintImpl)cocon).setConditionType(newconditiontype);
				         	    ((UMLComboBox2)source).setSelectedItem(((MContextbasedConstraintImpl)cocon).getConditionType());
				         	}
		         }
		         
		         if(newconditiontype.equals(empty) && oldconditiontype.equals(empty))
		         {
				         	((MContextbasedConstraintImpl)cocon).setConditionType(newconditiontype);
				         	((UMLComboBox2)source).setSelectedItem(((MContextbasedConstraintImpl)cocon).getConditionType());
		         }         
		         
      	  }catch(Exception ex) {System.out.println("Exception caught in ActionSetConditionType");} 
     }      
      
    }

    
    
    
    
    
   