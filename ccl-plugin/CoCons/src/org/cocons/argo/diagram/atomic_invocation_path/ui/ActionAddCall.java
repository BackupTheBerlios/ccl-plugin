package org.cocons.argo.diagram.atomic_invocation_path.ui;

import ru.novosoft.uml.behavior.common_behavior.MCallActionImpl;
import org.argouml.uml.diagram.sequence.ui.ActionAddLink;

/**
 * Überschrift:
 * Beschreibung:
 * Copyright:     Copyright (c) 2002
 * Organisation:
 * @author oetker
 * @version 1.0
 */

public class ActionAddCall extends ActionAddLink {

    public ActionAddCall() {
		super(MCallActionImpl.class, "StimulusCall");
    }

  public void doIt() {
	super.doIt();
  }
}