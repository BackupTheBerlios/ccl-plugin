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

// File: CrCompInstanceWithoutNode.java
// Classes: CrCompInstanceWithoutNode
// Original Author: 5eichler@informatik.uni-hamburg.de
// $Id: CrCompInstanceWithoutNode.java,v 1.1 2003/07/12 18:28:24 layekers Exp $

package org.argouml.uml.cognitive.critics;

import java.util.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.behavior.common_behavior.*;

import org.tigris.gef.util.*;

import org.argouml.cognitive.*;
import org.argouml.uml.diagram.deployment.ui.*;

/**
 * A critic to detect when there are component-instances that
 * are not inside a node-instance
 **/

public class CrCompInstanceWithoutNode extends CrUML {

  public CrCompInstanceWithoutNode() {
    setHeadline("ComponentInstances normally are inside nodes");
    addSupportedDecision(CrUML.decPATTERNS);
  }

  public boolean predicate2(Object dm, Designer dsgr) {
    if (!(dm instanceof UMLDeploymentDiagram)) return NO_PROBLEM;
    UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
    VectorSet offs = computeOffenders(dd); 
    if (offs == null) return NO_PROBLEM; 
    return PROBLEM_FOUND; 
  }

  public ToDoItem toDoItem(Object dm, Designer dsgr) { 
    UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
    VectorSet offs = computeOffenders(dd); 
    return new ToDoItem(this, offs, dsgr); 
  } 
 
  public boolean stillValid(ToDoItem i, Designer dsgr) { 
    if (!isActive()) return false; 
    VectorSet offs = i.getOffenders(); 
    UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.firstElement();
       //if (!predicate(dm, dsgr)) return false; 
    VectorSet newOffs = computeOffenders(dd); 
    boolean res = offs.equals(newOffs); 
    return res; 
  } 

  /**
   * If there are component-instances that have no enclosing FigMNodeInstance
   * the returned vector-set is not null. Then in the vector-set
   * are the UMLDeploymentDiagram and all FigComponentInstances with no
   * enclosing FigMNodeInstance
   **/
  public VectorSet computeOffenders(UMLDeploymentDiagram dd) { 

    Vector figs = dd.getLayer().getContents();
    VectorSet offs = null;
    int size = figs.size();
    boolean isNode = false;
    for (int j=0; j<size; j++) {
      Object obj = figs.elementAt(j);
      if (obj instanceof FigMNodeInstance) isNode = true;
    }
    for (int i=0; i<size; i++) {
      Object obj = figs.elementAt(i);
      if (!(obj instanceof FigComponentInstance)) continue;
      FigComponentInstance fc = (FigComponentInstance) obj;
      if (fc.getEnclosingFig() == null && isNode == true) {
        if (offs == null) {
          offs = new VectorSet();
          offs.addElement(dd);
        }
        offs.addElement(fc);
      }
      else if (fc.getEnclosingFig() != null &&
                 (((MComponentInstance)fc.getOwner()).getNodeInstance() == null)) {
        if (offs == null) {
          offs = new VectorSet();
          offs.addElement(dd);
        }
        offs.addElement(fc);
      }
     
    }

    return offs; 
  } 

} /* end class CrCompInstanceWithoutNode.java */

