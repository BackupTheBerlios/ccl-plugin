package org.cocons.argo.diagram.atomic_invocation_path;

import org.argouml.uml.diagram.sequence.SequenceDiagramGraphModel;

import ru.novosoft.uml.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.behavior.use_cases.*;
import ru.novosoft.uml.behavior.collaborations.*;
import ru.novosoft.uml.behavior.common_behavior.*;
import ru.novosoft.uml.model_management.*;


public class AtomicInvocationPathDiagramGraphModel extends SequenceDiagramGraphModel {

  public AtomicInvocationPathDiagramGraphModel() {
    super();
  }

  public Object connect(Object fromPort, Object toPort,
			java.lang.Class edgeClass) {

    if (edgeClass == MLinkImpl.class &&
      (fromPort instanceof MObject && toPort instanceof MObject)) {
	  return super.connect(fromPort, toPort, edgeClass);
    } else {
      System.out.println("Incorrect edge");
      return null;
    }
  }

}