package org.cocons.argo.diagram.ui;

import ru.novosoft.uml.foundation.core.MNamespace;
import org.argouml.uml.diagram.ui.UMLDiagram;

/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Martin Skinner
 * @version 1.0
 */

public abstract class CoConDiagram extends UMLDiagram {

  public CoConDiagram() {
  }

  public CoConDiagram(MNamespace m) {
    super(m);
  }
}