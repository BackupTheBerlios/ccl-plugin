
// File: Business_TypeDiagramRenderer.java
// Classes: Business_TypeDiagramRenderer
// Original jgusulde@cs.tu-berlin.de
// $Id: Business_TypeDiagramRenderer.java,v 1.1 2001/10/31 14:19:31 jgusulde Exp $

package org.cocons.argo.diagram.business_type.ui;

import java.util.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.behavior.common_behavior.*;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;

import org.argouml.uml.diagram.ui.*;
import org.argouml.uml.MMUtil;

// could be singleton


/** This class defines a renderer object for UML Class Diagrams. In a
 *  Class Diagram the following UML objects are displayed with the
 *  following Figs: <p>
 * <pre>
 *  UML Object      ---  Fig
 *  ---------------------------------------
 *  MClass         ---  FigClass
 *  MInterface       ---  FigClass (needs-more-work?)
 *  MGeneralization  ---  FigGeneralization
 *  Realization     ---  FigDependency (needs-more-work)
 *  MAssociation     ---  FigAssociation
 *  MDependency      ---  FigDependency
 *  </pre>
 */

public class Business_TypeDiagramRenderer
implements GraphNodeRenderer, GraphEdgeRenderer {

  /** Return a Fig that can be used to represent the given node */
  public FigNode getFigNodeFor(GraphModel gm, Layer lay, Object node) {
    if (node instanceof MClass) return new FigClass(gm, node);
    else if (node instanceof MInterface) return new FigInterface(gm, node);
    else if (node instanceof MInstance) return new FigInstance(gm, node);
    else if (node instanceof MPackage) return new FigPackage(gm, node);
    else if (node instanceof MModel) return new FigPackage(gm, node);
    System.out.println("needs-more-work ClassDiagramRenderer getFigNodeFor "+node);
    return null;
  }

  /** Return a Fig that can be used to represent the given edge */
  public FigEdge getFigEdgeFor(GraphModel gm, Layer lay, Object edge) {
    //System.out.println("making figedge for " + edge);
    if (edge instanceof MAssociation) {
      MAssociation asc = (MAssociation) edge;
      FigAssociation ascFig = new FigAssociation(asc);
      Collection connections = asc.getConnections();
      if (connections == null) System.out.println("null connections....");
	  Object[] connArray = connections.toArray();
      MAssociationEnd fromEnd = (MAssociationEnd) connArray[0];
      MClassifier fromCls = (MClassifier) fromEnd.getType();
      MAssociationEnd toEnd = (MAssociationEnd) connArray[1];
      MClassifier toCls = (MClassifier) toEnd.getType();
      FigNode fromFN = (FigNode) lay.presentationFor(fromCls);
      FigNode toFN = (FigNode) lay.presentationFor(toCls);
      ascFig.setSourcePortFig(fromFN);
      ascFig.setSourceFigNode(fromFN);
      ascFig.setDestPortFig(toFN);
      ascFig.setDestFigNode(toFN);
      ascFig.getFig().setLayer(lay);
      return ascFig;
    }
    if (edge instanceof MLink) {
      MLink lnk = (MLink) edge;
      FigLink lnkFig = new FigLink(lnk);
      Collection linkEnds = lnk.getConnections();
      if (linkEnds == null) System.out.println("null linkRoles....");
	  Object[] leArray = linkEnds.toArray();
      MLinkEnd fromEnd = (MLinkEnd) leArray[0];
      MInstance fromInst = fromEnd.getInstance();
      MLinkEnd toEnd = (MLinkEnd) leArray[1];
      MInstance toInst = toEnd.getInstance();
      FigNode fromFN = (FigNode) lay.presentationFor(fromInst);
      FigNode toFN = (FigNode) lay.presentationFor(toInst);
      lnkFig.setSourcePortFig(fromFN);
      lnkFig.setSourceFigNode(fromFN);
      lnkFig.setDestPortFig(toFN);
      lnkFig.setDestFigNode(toFN);
      lnkFig.getFig().setLayer(lay);
      return lnkFig;
    }
    if (edge instanceof MGeneralization) {
      MGeneralization gen = (MGeneralization) edge;
      FigGeneralization genFig = new FigGeneralization(gen);
      MGeneralizableElement subType = gen.getChild();
      MGeneralizableElement superType = gen.getParent();
      FigNode subTypeFN = (FigNode) lay.presentationFor(subType);
      FigNode superTypeFN = (FigNode) lay.presentationFor(superType);
      genFig.setSourcePortFig(subTypeFN);
      genFig.setSourceFigNode(subTypeFN);
      genFig.setDestPortFig(superTypeFN);
      genFig.setDestFigNode(superTypeFN);
      genFig.getFig().setLayer(lay);
      return genFig;
    }
	/*    if (edge instanceof Realization) {
      Realization real = (Realization) edge;
      FigRealization realFig = new FigRealization(real);
      MGeneralizableElement subType = real.getSubtype();
      MGeneralizableElement superType = real.getSupertype();
      FigNode subTypeFN = (FigNode) lay.presentationFor(subType);
      FigNode superTypeFN = (FigNode) lay.presentationFor(superType);
      realFig.setSourcePortFig(subTypeFN);
      realFig.setSourceFigNode(subTypeFN);
      realFig.setDestPortFig(superTypeFN);
      realFig.setDestFigNode(superTypeFN);
      realFig.getFig().setLayer(lay);
      return realFig;
	  }*/
    if (edge instanceof MDependency) {
	//System.out.println("get fig for "+edge);
      MDependency dep = (MDependency) edge;
      //System.out.println("stereo "+dep.getStereotype());
      if (dep.getStereotype() != null && dep.getStereotype().getName().equals("realize")) {
		  FigRealization realFig = new FigRealization(dep);

		  MModelElement supplier = (MModelElement)((dep.getSuppliers().toArray())[0]);
		  MModelElement client = (MModelElement)((dep.getClients().toArray())[0]);

		  FigNode supFN = (FigNode) lay.presentationFor(supplier);
		  FigNode cliFN = (FigNode) lay.presentationFor(client);

		  realFig.setSourcePortFig(cliFN);
		  realFig.setSourceFigNode(cliFN);
		  realFig.setDestPortFig(supFN);
		  realFig.setDestFigNode(supFN);
		  realFig.getFig().setLayer(lay);
		  realFig.getFig().setDashed(true);
		  return realFig;
	  }
	  else {
		  FigDependency depFig = new FigDependency(dep);

		  MModelElement supplier = (MModelElement)((dep.getSuppliers().toArray())[0]);
		  MModelElement client = (MModelElement)((dep.getClients().toArray())[0]);

		  FigNode supFN = (FigNode) lay.presentationFor(supplier);
		  FigNode cliFN = (FigNode) lay.presentationFor(client);

		  depFig.setSourcePortFig(cliFN);
		  depFig.setSourceFigNode(cliFN);
		  depFig.setDestPortFig(supFN);
		  depFig.setDestFigNode(supFN);
		  depFig.getFig().setLayer(lay);
		  depFig.getFig().setDashed(true);
		  return depFig;
	  }
	}
    // what about realizations? They are not distince objects in my UML model
    // maybe they should be, just as an implementation issue, dont
    // remove any of the methods that are there now.

    System.out.println("needs-more-work ClassDiagramRenderer getFigEdgeFor");
    return null;
  }


  static final long serialVersionUID = 675407719309039112L;

} /* end class ClassDiagramRenderer */