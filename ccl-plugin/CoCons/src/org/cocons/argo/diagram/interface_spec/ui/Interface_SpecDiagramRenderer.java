// Autor: shicathy

package org.cocons.argo.diagram.interface_spec.ui;

import java.util.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.behavior.common_behavior.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;

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
 *  MContextProperty    --   FigContextProperty
 *  MAssociation        ---  FigAssociation
 *  </pre>
 */

public class Interface_SpecDiagramRenderer
    implements GraphNodeRenderer, GraphEdgeRenderer {

  /** Return a Fig that can be used to represent the given node */
    public FigNode getFigNodeFor(GraphModel gm, Layer lay, Object node) {

        if (node instanceof MClass) {
          System.out.println("Renderer: node "+((MClass)node).getStereotype());
          return new FigClass(gm,node);//FigInterface_Spec(gm, node);//
        }
        else if (node instanceof MTaggedValue) return new FigContextProperty(gm, node);

        //System.out.println("needs-more-work Interface_SpecDiagramRenderer getFigNodeFor "+node);
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


        //System.out.println("needs-more-work Interface_SpecDiagramRenderer getFigEdgeFor");

        return null;
    }


    static final long serialVersionUID = 675407719309039112L;

}
