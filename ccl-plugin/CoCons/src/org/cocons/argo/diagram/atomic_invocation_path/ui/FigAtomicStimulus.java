package org.cocons.argo.diagram.atomic_invocation_path.ui;

// File: FigAtomicStimulus.java
// Original Author: oetker@cs.tu-berlin.de
// $Id: FigAtomicStimulus.java,v 1.1 2002/02/12 21:15:56 oetker Exp $

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.beans.*;
import javax.swing.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.behavior.collaborations.*;
import ru.novosoft.uml.behavior.common_behavior.*;

import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;
import org.tigris.gef.base.*;

import org.argouml.application.api.*;
import org.argouml.kernel.*;
import org.argouml.ui.*;
import org.argouml.uml.generator.*;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.argouml.uml.diagram.sequence.ui.*;


public class FigAtomicStimulus extends FigSeqStimulus {

  public FigAtomicStimulus() {
      super();
  }

  public FigAtomicStimulus(GraphModel gm, Object node) {
    super();
    setOwner(node);
  }

  public String placeString() { return "new Stimulus"; }

  protected void modelChanged() {

    super.modelChanged();

    MStimulus sti = (MStimulus) getOwner();
    if (sti == null) return;
    if (sti.getDispatchAction() != null ) {
	MCallAction action = (MCallAction) sti.getDispatchAction();
	MOperation oper = action.getOperation();
	_name.setText(oper.getOwner().getName() + "." + oper.getName() + "()");
    }
    if (getLayer() != null) ((SequenceDiagramLayout)getLayer()).placeAllFigures();
    
  }

} /* end class FigAtomicStimulus */
