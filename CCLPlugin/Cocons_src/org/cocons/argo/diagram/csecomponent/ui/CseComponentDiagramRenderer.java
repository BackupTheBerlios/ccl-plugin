/*
 * CseComponentDiagramRenderer.java
 * Created on 23. Januar 2002, 18:56
 */

package org.cocons.argo.diagram.csecomponent.ui ;

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

public class CseComponentDiagramRenderer    
    implements GraphNodeRenderer, GraphEdgeRenderer {
    
    /** Return a Fig that can be used to represent the given node */
    
    public FigNode getFigNodeFor(GraphModel gm, Layer lay, Object node) {
	
	if (node instanceof MClass) return new FigCseComponent(gm, node);
        if (node instanceof MInterface) return new FigConnector(gm,node);
	if (node instanceof MTaggedValue) return new FigContextProperty(gm, node);
	return null;
    }
    
     /** Return a Fig that can be used to represent the given edge */
    public FigEdge getFigEdgeFor(GraphModel gm, Layer lay, Object edge) {
	if (edge instanceof MDependency) {
	    
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
	
        
	 return null;
    }
   
    
    static final long serialVersionUID = 675407719309039112L;
    
} /* end class CseComponentDiagramRenderer */




