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





// File: CrEmptyPackage.java
// Classes: CrEmptyPackage
// Original Author: jrobbins@ics.uci.edu
// $Id: CrEmptyPackage.java,v 1.1 2003/07/12 18:28:24 layekers Exp $

package org.argouml.uml.cognitive.critics;

import java.util.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.model_management.*;

import org.apache.log4j.Category;
import org.argouml.cognitive.*;

/** A critic whether a package/subsystem/model is empty. */

public class CrEmptyPackage extends CrUML {
    protected static Category cat = Category.getInstance(CrEmptyPackage.class);

  public CrEmptyPackage() {
    setHeadline("Add Elements to Package <ocl>self</ocl>");
       
    addSupportedDecision(CrUML.decMODULARITY);
    addTrigger("ownedElement");
  }

  public boolean predicate2(Object dm, Designer dsgr) {
    cat.debug("predicate2 on " + dm);
    if (!(dm instanceof MPackage)) return NO_PROBLEM;
    MPackage mod = (MPackage) dm;
    Collection elms = mod.getOwnedElements();
    if (elms == null || elms.size() == 0) return PROBLEM_FOUND;
    return NO_PROBLEM;
    //TODO: different critic for packages consisting only
    //of references to elements of other packages?
  }

} /* end class CrEmptyPackage */

