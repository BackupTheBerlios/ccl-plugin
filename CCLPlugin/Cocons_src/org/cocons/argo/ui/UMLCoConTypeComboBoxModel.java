/**
 * Created on 03.05.2003
  */
package org.cocons.argo.ui;

import java.lang.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

import ru.novosoft.uml.MBase;
import org.argouml.uml.ui.*;
import org.cocons.uml.ccl.*;
import org.argouml.model.uml.UmlModelEventPump;
import ru.novosoft.uml.foundation.core.MNamespace;
/**
 * @author Camara Lenuseni, layekers@cs.tu-berlin.de
 */
public class UMLCoConTypeComboBoxModel extends UMLComboBoxModel2
{
	/**
     * Constructor for UMLCoConTypeComboBoxModel.
     * @param container
     */
    public UMLCoConTypeComboBoxModel(UMLUserInterfaceContainer container) {
        super(container, "cocontype", false);
        UmlModelEventPump.getPump().addClassModelEventListener(this, MNamespace.class, "ownedElement");
    }

    /**
     * @see org.argouml.uml.ui.UMLComboBoxModel2#buildModelList()
     */
    protected void buildModelList() {
        MContextbasedConstraint cocon = (MContextbasedConstraint)getTarget();
        if (cocon == null)
        	 return; 
        	 Collection col = new Vector();
        for(int i=0; i< PropPanelModelElementCoCons.coconTypeName.length; i++)
        	col.add(PropPanelModelElementCoCons.coconTypeName[i]);
        
        this.setElements(col);
        }
    
    /**
     * @see org.argouml.uml.ui.UMLComboBoxModel2#getSelectedModelElement()
     */
    protected Object getSelectedModelElement() 
    {  String result = "";
        if (getTarget() != null)         
        	result = ((MContextbasedConstraintImpl)getTarget()).getCoConType2();
          
        return result;
    }
	
    /**
     * @see org.argouml.uml.ui.UMLComboBoxModel2#isValidElement(ru.novosoft.uml.MBase)
     */
    protected boolean isValidElement(MBase element) {
        return element instanceof MContextbasedConstraint;
    }

}
