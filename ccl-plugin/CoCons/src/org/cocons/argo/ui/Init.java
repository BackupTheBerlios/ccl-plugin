package org.cocons.argo.ui;

import ru.novosoft.uml.foundation.extension_mechanisms.*;
import org.cocons.uml.ccl.*;
import org.cocons.uml.ccl.context_property1_3.*;
import org.argouml.ui.*;
import ru.novosoft.uml.foundation.core.MClassImpl;

/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Martin Skinner
 * @version 1.0
 */

public class Init implements Runnable {

    public Init() {
    }
    public void run() {
	// add property pages

	ProjectBrowser pb = ProjectBrowser.TheInstance;
	pb.getDetailsPane().addToPropTab(MContextbasedConstraintImpl.class, new PropPanelContextbasedConstraint());
	pb.getDetailsPane().addToPropTab(MStereotypeImpl.class, new PropPanelStereotype());
	pb.getDetailsPane().addToPropTab(MContextPropertyValueImpl.class, new PropPanelContextPropertyValue());
	pb.getDetailsPane().addToPropTab(MClassImpl.class, new PropPanelComponent_Spec());
    }
}





