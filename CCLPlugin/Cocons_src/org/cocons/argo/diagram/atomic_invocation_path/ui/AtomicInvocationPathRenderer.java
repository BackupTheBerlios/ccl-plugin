package org.cocons.argo.diagram.atomic_invocation_path.ui;

import java.util.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.behavior.collaborations.*;
import ru.novosoft.uml.behavior.common_behavior.*;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;

import org.argouml.uml.diagram.ui.*;
import org.argouml.uml.diagram.sequence.ui.FigSeqLink;

public class AtomicInvocationPathRenderer
implements GraphNodeRenderer, GraphEdgeRenderer {

  /** Return a Fig that can be used to represent the given node */
  public FigNode getFigNodeFor(GraphModel gm, Layer lay, Object node) {
    if (node instanceof MObject) return new FigAtomicObject(gm, node);
    if (node instanceof MStimulus) return new FigAtomicStimulus(gm, node);
	return null;
  }
  /** Return a Fig that can be used to represent the given edge */
  /** Generally the same code as for the ClassDiagram, since its
      very related to it. */
  public FigEdge getFigEdgeFor(GraphModel gm, Layer lay, Object edge) {
    if (edge instanceof MLink) {
      MLink ml = (MLink) edge;
      FigSeqLink mlFig = new FigSeqLink(ml);
      Collection connections = ml.getConnections();
      if (connections == null) System.out.println("null connections....");
      MLinkEnd fromEnd = (MLinkEnd) ((Object[])connections.toArray())[0];
      MInstance fromInst = (MInstance) fromEnd.getInstance();
      MLinkEnd toEnd = (MLinkEnd) ((Object[])connections.toArray())[1];
      MInstance toInst = (MInstance) toEnd.getInstance();
      FigNode fromFN = (FigNode) lay.presentationFor(fromInst);
      FigNode toFN = (FigNode) lay.presentationFor(toInst);
      mlFig.setSourcePortFig(fromFN);
      mlFig.setSourceFigNode(fromFN);
      mlFig.setDestPortFig(toFN);
      mlFig.setDestFigNode(toFN);
      return mlFig;
    }

    System.out.println("needs-more-work SequenceDiagramRenderer getFigEdgeFor");
    return null;
  }


}
