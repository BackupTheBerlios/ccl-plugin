package org.cocons.argo.diagram.ui;

import ru.novosoft.uml.foundation.core.MNamespace;
import org.argouml.uml.diagram.ui.UMLDiagram;

import org.cocons.uml.ccl.context_property1_3.xmlembed.ContextPropertyNotifications;

/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Martin Skinner
 * @version 1.0
 */

public abstract class CCLDiagram extends UMLDiagram {

	public CCLDiagram() {
	}
	
	public CCLDiagram(MNamespace m) {
		super(m);
	}

	public void postLoad()
	{
		ContextPropertyNotifications.SINGLETON.postLoad(this);
		super.postLoad();
	}
	
	public void preSave()
	{
		ContextPropertyNotifications.SINGLETON.preSave(this);
		super.preSave();
	}

	public void postSave()
	{
		ContextPropertyNotifications.SINGLETON.postSave(this);
		super.postSave();
	}


}
