/**
 * Created on 03.05.2003
 * @author Lenuseni, layekers@cs.tu-berlin.de 
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

public class ActionSetCoConType extends UMLChangeAction
{
		public static final ActionSetCoConType SINGLETON = new ActionSetCoConType();

    /**
     * Constructor for ActionSetCoConType.
     * @param s
     */
    protected ActionSetCoConType() {
        super(Argo.localize("CoreMenu", "Set"), true, NO_ICON);
    }
   
    /**
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object source = e.getSource();
        MContextbasedConstraint cocon = null;
        String oldcocontype = "";
        String newcocontype = "";
        String empty ="";
        
        if (source instanceof UMLComboBox2) 
        {
            UMLComboBox2 combo = (UMLComboBox2)source;
            newcocontype = (String)combo.getSelectedItem();
            // i must search for a better solution
            if (newcocontype== null)
            {
            	newcocontype = "";
            }	
            if (combo.getTarget() instanceof MContextbasedConstraint) 
            {
                cocon = (MContextbasedConstraintImpl)combo.getTarget();
            }
        }
        oldcocontype = ((MContextbasedConstraintImpl)cocon).getCoConType2();        
      try
      {
        if (!(newcocontype.equals(oldcocontype)) && cocon != null)
         {
         	if (newcocontype.equals(empty))
         	{
         		  ((MContextbasedConstraintImpl)cocon).setCoConType2(oldcocontype);
         		  ((UMLComboBox2)source).setSelectedItem(((MContextbasedConstraintImpl)cocon).getCoConType2()); 
         	}
         	else
         	{
         		((MContextbasedConstraintImpl)cocon).setCoConType2(newcocontype);
         	    ((UMLComboBox2)source).setSelectedItem(((MContextbasedConstraintImpl)cocon).getCoConType2());
         	}
         }
         if(newcocontype.equals(empty) && oldcocontype.equals(empty))
         {
         	((MContextbasedConstraintImpl)cocon).setCoConType2(newcocontype);
         	((UMLComboBox2)source).setSelectedItem(((MContextbasedConstraintImpl)cocon).getCoConType2());
         }    	
      }catch(Exception ex) {System.out.println("Exception caught in ActionSetCoConType");} 
    }

}
