package org.cocons.argo.diagram.atomic_invocation_path.ui;

import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
import ru.novosoft.uml.foundation.core.*;
import java.beans.PropertyVetoException;

public class CCLAtomicInvocationPathDiagram extends UMLSequenceDiagram {

  static protected int _AtomicInvocationPathDiagramSerial=1;

  public CCLAtomicInvocationPathDiagram() {
    super();
    try { setName("Atomic Invocation Path diagram " + _AtomicInvocationPathDiagramSerial++); }
    catch (PropertyVetoException pve) { }
  }
  public CCLAtomicInvocationPathDiagram(MNamespace m) {
    super(m);
    try { setName("Atomic Invocation Path diagram " + _AtomicInvocationPathDiagramSerial++); }
    catch (PropertyVetoException pve) { }

  }

}