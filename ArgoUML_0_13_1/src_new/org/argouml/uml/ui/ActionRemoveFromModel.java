// Copyright (c) 1996-01 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.uml.ui;

import org.argouml.kernel.*;
import org.argouml.ui.*;
import org.argouml.uml.diagram.ui.UMLDiagram;
import org.argouml.application.api.*;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.model_management.MModel;
import ru.novosoft.uml.model_management.MModelImpl;

import java.util.*;
import java.awt.event.*;
import java.text.MessageFormat;

import javax.swing.*;
import javax.swing.tree.TreePath;

/**
 * Action for removing (moving to trash) objects from the model. Objects can be:
 * - Modelelements (NSUML)
 * - Diagrams (argodiagram and it's children)
 * The root model and the last diagram in the project can not be removed. The 
 * reason for this is to prevent problems updating the detailspane and the 
 * navpane. Besides that, it is not possible to make a new root model.
 * 
 * @author original author not known.
 * @author jaap.branderhorst@xs4all.nl extensions
 * @stereotype singleton
 */

public class ActionRemoveFromModel extends UMLChangeAction {
 
    ////////////////////////////////////////////////////////////////
    // static variables
    
    public static ActionRemoveFromModel SINGLETON = new ActionRemoveFromModel();
    
    ////////////////////////////////////////////////////////////////
    // constructors
    
    public ActionRemoveFromModel() {
        super(Argo.localize("CoreMenu", "Delete From Model"));
    }
    
    protected ActionRemoveFromModel(boolean global) {
        super(Argo.localize("CoreMenu", "Delete From Model"),global);
    }
    
    /**
     * Returns the selected object. It is possible that the selected target on
     * the detailspane is not selected on the navpane. This is a defect. 
     * Therefore we give priority to the selection at the detailspane.
     * @return Object
     */
    protected Object getTarget() {
    	ProjectBrowser pb = ProjectBrowser.TheInstance;
    	Object target = pb.getDetailsTarget();
    	if (target == null) { // nothing selected on detailspane
    		target = pb.getNavPane().getSelectedObject();
    	}
    	return target;
    }
    
    /**
     * Only disabled when nothing is selected. Necessary to use since this 
     * option works via the menu too. A user cannot delete the last diagram. 
     * A user cannot delete the root model.
     * @see org.argouml.uml.ui.UMLAction#shouldBeEnabled()
     */	
    public boolean shouldBeEnabled() {
        if (getTarget() instanceof Diagram) { // we cannot delete the last diagram
            return ProjectBrowser.TheInstance.getProject().getDiagrams().size() > 1;
        }
        if (getTarget() instanceof MModel &&  // we cannot delete the model itself
            getTarget().equals(ProjectBrowser.TheInstance.getProject().getModel())) {
                return false;
        }
    	return getTarget() != null;
    	
    }
    
    /**
     * Moves the selected target to the trash bin. Moves the selected target 
     * after the remove to the parent of the selected target (that is: the next
     * level up in the navpane). In case of a diagram the selected target will 
     * be the next diagram in the list with diagrams.
     * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
     */
    public void actionPerformed(ActionEvent ae) {
        Object target = getTarget();
        if (target != null) {
            if (sureRemove(target)) {
                // Argo.log.info("deleting "+target+"+ "+(((MModelElement)target).getMElementListeners()).size());
                // move the pointer to the target in the NavPane to some other target (up)
                ProjectBrowser pb = ProjectBrowser.TheInstance;
                TreePath path = pb.getNavPane().getParentPath();
                if (path != null) {
                    Object o = path.getLastPathComponent();
                    Project pr = pb.getProject();
                    if (o instanceof MModel && // root model
                        o.equals(pr.getModel()) &&
                        target instanceof Diagram) {
                        int targetIndex = 
                            pr.getDiagrams().indexOf(target);
                        o = targetIndex == 0? pr.getDiagrams().get(1): 
                            pr.getDiagrams().get(targetIndex-1);
                    }
                    if (o instanceof Diagram) {
                        ProjectBrowser.TheInstance.setTarget(o);
                    } else {
                        ProjectBrowser.TheInstance.select(o);
                    }
                }
                ProjectBrowser.TheInstance.getProject().moveToTrash(target); 
            } 
            		
        }
        super.actionPerformed(ae);
    }
    
    /**
     * A utility method that asks the user if he is sure to remove the selected
     * target. 
     * @param target
     * @return boolean
     */
    public static boolean sureRemove(Object target) {
    	// usage of other sureRemove method is legacy. They should be integrated.
    	boolean sure = false;
    	if (target instanceof MModelElement) {
    		sure = sureRemove((MModelElement)target); 
    	} else 
    	if (target instanceof UMLDiagram) {
    		// lets see if this diagram has some figs on it
    		UMLDiagram diagram = (UMLDiagram)target;
    		Vector nodes = diagram.getNodes();
    		Vector edges = diagram.getNodes();
    		if ((nodes.size() + edges.size()) > 0) {
    			 // the diagram contains figs so lets ask the user if he/she is sure
    			 String confirmStr = MessageFormat.format(Argo.localize("Actions",
                                         "template.remove_from_model.confirm_delete"),
                                          new Object[] {diagram.getName(), ""});
                 int response = JOptionPane.showConfirmDialog(ProjectBrowser.TheInstance, confirmStr,
                                            Argo.localize("Actions", 
                                            "text.remove_from_model.confirm_delete_title"),
                                            JOptionPane.YES_NO_OPTION);
        		sure = (response == JOptionPane.YES_OPTION);
    		} else { // no content of diagram
    			sure = true;
    		}
    	} else
    	if (target instanceof Fig) { // we can delete figs like figrects now too
    		sure = true;
    	}
    	return sure;
    }
    
    /**
     * An utility method that asks the user if he is sure to remove a selected 
     * modelement.
     * @see ActionRemoveFromModel#sureRemove(Object)
     * @param me
     * @return boolean
     */
    public static boolean sureRemove(MModelElement me) {
        ProjectBrowser pb = ProjectBrowser.TheInstance;
        Project p = pb.getProject();
        
        int count = p.getPresentationCountFor(me);
        
        boolean doAsk = false;
        String confirmStr = "";
        if (count > 1) {
            confirmStr += Argo.localize("Actions",
                                    "text.remove_from_model.will_remove_from_diagrams");
            doAsk = true;
        }
        
        Collection beh = me.getBehaviors();
        if (beh != null && beh.size() > 0) {
            confirmStr += Argo.localize("Actions",
                                    "text.remove_from_model.will_remove_subdiagram");
            doAsk = true;
        }
        
        if (!doAsk) {
            return true;
        }
        
        String name = me.getName();
        if (name == null || name.equals("")) {
            name = Argo.localize("Actions", "text.remove_from_model.anon_element_name");
        }
        
        confirmStr = MessageFormat.format(Argo.localize("Actions",
                                         "template.remove_from_model.confirm_delete"),
                                          new Object[] {name, confirmStr});
        int response = JOptionPane.showConfirmDialog(pb, confirmStr,
                                            Argo.localize("Actions", 
                                            "text.remove_from_model.confirm_delete_title"),
                                            JOptionPane.YES_NO_OPTION);
        
        return (response == JOptionPane.YES_OPTION);
    }
} /* end class ActionRemoveFromModel */
