/*
 * ActionAddContextProperty.java
 *
 * Created on 11. November 2001, 16:31
 */
/**
 * * @author  shicathy
 * @version 0.1
 */

package org.cocons.argo.diagram.ui;

import org.argouml.uml.ui.*;
import org.argouml.kernel.*;
import org.argouml.uml.*;
import org.argouml.ui.*;
import ru.novosoft.uml.foundation.core.*;
import java.awt.event.*;
import org.cocons.uml.ccl.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;

public class ActionAddContextProperty extends UMLAction {

     ////////////////////////////////////////////////////////////////
    // constructors

    public ActionAddContextProperty() { super("Add ContextProperty"); }


    ////////////////////////////////////////////////////////////////
    // main methods

    public void actionPerformed(ActionEvent ae) {
        ProjectBrowser pb = ProjectBrowser.TheInstance;
        Project p = pb.getProject();
        Object target = pb.getDetailsTarget();
        if (!(target instanceof MTaggedValue)) return;
        MTaggedValue mcp = (MTaggedValue) target;
        super.actionPerformed(ae);
    }

    public boolean shouldBeEnabled() {
        ProjectBrowser pb = ProjectBrowser.TheInstance;
        Object target = pb.getDetailsTarget();
        return super.shouldBeEnabled() && target instanceof MClass;
    }
} /* end class ActionAddContextProperty */
