// Autor shicathy

package org.cocons.argo.diagram.ui;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import org.tigris.gef.base.*;



public class ModeCreateEdgeStereotype extends ModeCreatePolyEdge {

  MStereotype defaultStereotype = new MStereotypeImpl();

  public ModeCreateEdgeStereotype() {
    super();
    defaultStereotype.setName("interface spec");
  }

   public ModeCreateEdgeStereotype(Editor par) {
      super(par);
      defaultStereotype.setName("interface spec");

  }

  public MStereotype getStereotype() {
    return defaultStereotype;
  }

  public void setStereotype( MStereotype stereo ) {
    defaultStereotype = stereo;
  }

}