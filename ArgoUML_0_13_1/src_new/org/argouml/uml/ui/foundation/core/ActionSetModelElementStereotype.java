// Copyright (c) 1996-99 The Regents of the University of California. All
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

// $header$
package org.argouml.uml.ui.foundation.core;

import java.awt.event.ActionEvent;

import org.argouml.application.api.Argo;
import org.argouml.model.uml.foundation.extensionmechanisms.ExtensionMechanismsHelper;
import org.argouml.uml.ui.UMLChangeAction;
import org.argouml.uml.ui.UMLComboBox2;

import ru.novosoft.uml.foundation.core.MModelElement;
import ru.novosoft.uml.foundation.extension_mechanisms.MStereotype;

/**
 * @since Oct 10, 2002
 * @author jaap.branderhorst@xs4all.nl
 * @stereotype singleton
 */
public class ActionSetModelElementStereotype extends UMLChangeAction {

    public static final ActionSetModelElementStereotype SINGLETON = new ActionSetModelElementStereotype();

    /**
     * Constructor for ActionSetModelElementStereotype.
     * @param s
     */
    protected ActionSetModelElementStereotype() {
        super(Argo.localize("CoreMenu", "Set"), true, NO_ICON);
    }


   
    /**
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object source = e.getSource();
        MStereotype oldStereo = null;
        MStereotype newStereo = null;
        MModelElement target = null;
        if (source instanceof UMLComboBox2) {
            UMLComboBox2 combo = (UMLComboBox2)source;
            if (combo.getSelectedItem() instanceof MStereotype) 
                newStereo = (MStereotype)combo.getSelectedItem();                                
            if (combo.getTarget() instanceof MModelElement) {
                target = (MModelElement)combo.getTarget();
                oldStereo = target.getStereotype();
            }
            if (newStereo != oldStereo && target != null && newStereo != null) {
                ExtensionMechanismsHelper.getHelper().setStereoType(target, newStereo);
            } else
            if (combo.getSelectedItem() != null && combo.getSelectedItem().equals("") && oldStereo != null && target != null) {
                target.setStereotype(null);
            }
        }
        
    }
            
    

}
