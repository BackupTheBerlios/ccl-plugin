package org.cocons.argo.diagram.ui;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.MStereotype;
import org.tigris.gef.base.CmdCreateNode;

/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Martin Skinner
 * @version 1.0
 */

public class CmdCreateNodeStereotype extends CmdCreateNode {

  MStereotype _stereotype;

  public CmdCreateNodeStereotype(Class nodeClass, String name,
                                 MStereotype stereotype) {
    super(nodeClass, name);
    _stereotype = stereotype;
  }

  public Object makeNode() {
    Object newNode = super.makeNode();
    if (newNode instanceof MModelElement)
    {
      ((MModelElement)newNode).setStereotype(_stereotype);
    }
    return newNode;
  }
}