
// $Id: Business_TypeDiagramRenderer.java,v 1.4 2001/11/13 16:25:58 oetker Exp $

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
import org.argouml.uml.diagram.static_structure.ui.*;
import org.cocons.uml.ccl.*;
import org.cocons.argo.diagram.ui.*;

// could be singleton


/** This class defines a renderer object for UML Class Diagrams. In a
 *  Class Diagram the following UML objects are displayed with the
 *  following Figs: <p>
 * <pre>
 *  UML Object      ---  Fig
 *  ---------------------------------------
 *  MClass              ---  FigClass
 *  MPackage            ---  FigPakcage
 *  MContextProperty    --   FigContextProperty
 *  MGeneralization     ---  FigGeneralization
 *  MAssociation        ---  FigAssociation
 *  MDependency         ---  FigDependency
 *  </pre>
 */

public class Business_TypeDiagramRenderer
    implements GraphNodeRenderer, GraphEdgeRenderer {

  /** Return a Fig that can be used to represent the given node */
    public FigNode getFigNodeFor(GraphModel gm, Layer lay, Object node) {
        if (node instanceof MClass) {
            FigClass figC = new FigClass(gm, node);
            figC.setOperationVisible(false);
            return figC;
        }
        else if (node instanceof MBusiness_Type) {
            FigBusiness_Type figB = new FigBusiness_Type(gm, node);
            return figB;
        }
        else if (node instanceof MPackage) return new FigPackage(gm, node);         
        else if (node instanceof MContextPropertyTag) return new FigContextProperty(gm, node);
        
        //System.out.println("needs-more-work Business_TypeDiagramRenderer getFigNodeFor "+node);
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
	
        
        if (edge instanceof MDependency) {
            //System.out.println("get fig for "+edge);
            MDependency dep = (MDependency) edge;
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
        
        //System.out.println("needs-more-work Business_TypeDiagramRenderer getFigEdgeFor");
        
        return null;
    }


    static final long serialVersionUID = 675407719309039112L;

}
