package org.cocons.argo.diagram.atomic_invocation_path.ui;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.beans.*;

import org.argouml.uml.diagram.sequence.ui.FigSeqObject;
import org.cocons.argo.diagram.cml.ActionSaveCML;
import ru.novosoft.uml.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.behavior.collaborations.*;
import ru.novosoft.uml.behavior.common_behavior.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;

import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.graph.GraphNodeRenderer;
import org.tigris.gef.graph.GraphEdgeRenderer;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Selection;
import org.tigris.gef.base.SelectionManager;
/**
 * Überschrift:
 * Beschreibung:
 * Copyright:     Copyright (c) 2002
 * Organisation:
 * @author oetker
 * @version 1.0
 */

public class FigAtomicObject extends FigSeqObject {

  protected FigRect _lifeline;
  public FigAtomicObject() {
	super();
  }

  public FigAtomicObject(GraphModel gm, Object node) {
    super();
    setOwner(node);
  }

  public Selection makeSelection() {
    return null;
  }

  public Vector getPopUpActions(MouseEvent me) {
	Vector popUpActions = super.getPopUpActions(me);
	popUpActions.add(CreateCallMenu.getJMenu());
    //ContextViewPopUpMenu.getPopUpActions(popUpActions);
	popUpActions.add( ActionSaveCML.SINGLETON );
	return popUpActions;
  }
}