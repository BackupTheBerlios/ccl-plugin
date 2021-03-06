// Copyright (c) 1996-99 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

// File: ClassDiagramRenderer.java
// Classes: ClassDiagramRenderer
// Original jrobbins@ics.uci.edu
// $Id: ClassDiagramRenderer.java,v 1.1 2003/07/12 18:28:32 layekers Exp $

package org.argouml.uml.diagram.static_structure.ui;

import java.util.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.behavior.common_behavior.*;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;

import org.argouml.uml.diagram.ui.*;
import org.apache.log4j.Category;
import org.argouml.uml.MMUtil;

// could be singleton


/** This class defines a renderer object for UML Class Diagrams. In a
 *  Class Diagram the following UML objects are displayed with the
 *  following Figs: <p>
 * <pre>
 *  UML Object      ---  Fig
 *  ---------------------------------------
 *  MClass         ---  FigClass
 *  MInterface       ---  FigClass (TODO?)
 *  MGeneralization  ---  FigGeneralization
 *  Realization     ---  FigDependency (TODO)
 *  MAssociation     ---  FigAssociation
 *  MDependency      ---  FigDependency
 *  </pre>
 */

public class ClassDiagramRenderer
    implements GraphNodeRenderer, GraphEdgeRenderer {

    protected static Category cat = 
        Category.getInstance(ClassDiagramRenderer.class);

    /** Return a Fig that can be used to represent the given node */
    public FigNode getFigNodeFor(GraphModel gm, Layer lay, Object node) {
        if (node instanceof MClass) return new FigClass(gm, node);
        else if (node instanceof MInterface) return new FigInterface(gm, node);
        else if (node instanceof MInstance) return new FigInstance(gm, node);
        else if (node instanceof MPackage) return new FigPackage(gm, node);
        else if (node instanceof MModel) return new FigPackage(gm, node);
        cat.debug("TODO ClassDiagramRenderer getFigNodeFor "+node);
        return null;
    }

    /** Return a Fig that can be used to represent the given edge */
    public FigEdge getFigEdgeFor(GraphModel gm, Layer lay, Object edge) {
        cat.debug("making figedge for " + edge);
        if (edge instanceof MAssociation) {
            MAssociation asc = (MAssociation) edge;
            FigAssociation ascFig = new FigAssociation(asc, lay);
            return ascFig;
        }
        if (edge instanceof MLink) {
            MLink lnk = (MLink) edge;
            FigLink lnkFig = new FigLink(lnk);
            Collection linkEnds = lnk.getConnections();
            if (linkEnds == null) cat.debug("null linkRoles....");
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
            FigGeneralization genFig = new FigGeneralization(gen, lay);
            return genFig;
        }
        if (edge instanceof MPermission) {
            MPermission per = (MPermission) edge;
            FigPermission perFig = new FigPermission(per, lay);
            return perFig;
        }
        if (edge instanceof MUsage) {
            MUsage usage = (MUsage) edge;
            FigUsage usageFig = new FigUsage(usage, lay);
            return usageFig;
        }
        if (edge instanceof MDependency) {
            cat.debug("get fig for "+edge);
            MDependency dep = (MDependency) edge;
            cat.debug("stereo "+dep.getStereotype());
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
                FigDependency depFig = new FigDependency(dep, lay);
                return depFig;
            }
        }
        cat.debug("TODO ClassDiagramRenderer getFigEdgeFor");
        return null;
    }


    static final long serialVersionUID = 675407719309039112L;

} /* end class ClassDiagramRenderer */
