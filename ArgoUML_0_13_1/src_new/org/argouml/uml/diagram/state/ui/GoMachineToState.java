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

package org.argouml.uml.diagram.state.ui;

import java.util.Collection;
import java.util.Vector;

import org.argouml.ui.AbstractGoRule;

import ru.novosoft.uml.behavior.state_machines.MCompositeState;
import ru.novosoft.uml.behavior.state_machines.MStateMachine;

/**
 * Navigation rule for navperspective to navigate from statemachine to its top state.
 * 
 * @author jaap.branderhorst@xs4all.nl
 */
public class GoMachineToState extends AbstractGoRule {

    public String getRuleName() { return "State Machine->State"; }

    /**
     * @see org.argouml.ui.AbstractGoRule#getChildren(Object)
     */
    public Collection getChildren(Object parent) {
        if (parent instanceof MStateMachine) {
            Vector children = new Vector();
            children.addAll(((MCompositeState)((MStateMachine) parent).getTop()).getSubvertices());
            return children;
        }
        return null;
    }

    /**
     * @see javax.swing.tree.TreeModel#isLeaf(Object)
     */
    public boolean isLeaf(Object arg0) {
        return !(arg0 instanceof MStateMachine && getChildCount(arg0) > 0);
    }

}
