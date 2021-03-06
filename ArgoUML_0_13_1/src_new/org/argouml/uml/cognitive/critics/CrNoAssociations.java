// Copyright (c) 1996-02 The Regents of the University of California. All
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

// File: CrNoAssociations.javoa
// Classes: CrNoAssociations
// Original Author: jrobbins@ics.uci.edu
// $Id: CrNoAssociations.java,v 1.1 2003/07/12 18:28:25 layekers Exp $

package org.argouml.uml.cognitive.critics;

import java.util.*;
import javax.swing.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;

import org.argouml.cognitive.*;
import org.argouml.cognitive.critics.*;

/** A critic to detect when a class can never have instances (of
 *  itself of any subclasses). */

public class CrNoAssociations extends CrUML {

  public CrNoAssociations() {
    setHeadline("Add Associations to <ocl>self</ocl>");
    addSupportedDecision(CrUML.decRELATIONSHIPS);
    setKnowledgeTypes(Critic.KT_COMPLETENESS);
    addTrigger("associationEnd");
  }

  public boolean predicate2(Object dm, Designer dsgr) {
    if (!(dm instanceof MClassifier)) return NO_PROBLEM;
    MClassifier cls = (MClassifier) dm;
    if (!(CriticUtils.isPrimaryObject(cls))) return NO_PROBLEM;


    // types can probably have associations, but we should not nag at them
    // not having any.
    // utility is a namespace collection - also not strictly required to have
    // associations.
    if (CriticUtils.hasStereotype(cls, "type") ||
        CriticUtils.hasStereotype(cls, "utility"))
        return NO_PROBLEM;

    //TODO: different critic or special message for classes
    //that inherit all ops but define none of their own.

    Collection asc = getInheritedAssociationEnds(cls,0);
    if (asc == null || asc.size() == 0) return PROBLEM_FOUND;
    return NO_PROBLEM;
  }

  private Collection getInheritedAssociationEnds(MClassifier cls,int depth)
  {
     Vector res = new Vector(cls.getAssociationEnds());
     Collection inh = cls.getGeneralizations();
     for (Iterator iter = inh.iterator(); iter.hasNext();) {
        MGeneralization gen = (MGeneralization) iter.next();
	MGeneralizableElement parent = gen.getParent();
        if (parent != cls && parent instanceof MClassifier && depth < 50) {
            Collection superassocs = getInheritedAssociationEnds((MClassifier) parent,depth+1);
            res.addAll(superassocs);
        }
     }
     return res;
  };
} /* end class CrNoAssociations */

