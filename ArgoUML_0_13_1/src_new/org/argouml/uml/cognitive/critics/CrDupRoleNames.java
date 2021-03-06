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



// File: CrDupRoleNames.java
// Classes: CrDupRoleNames
// Original Author: jrobbins@ics.uci.edu
// $Id: CrDupRoleNames.java,v 1.1 2003/07/12 18:28:24 layekers Exp $

// 12 Mar 2002: Jeremy Bennett (mail@jeremybennett.com). Code corrected as part
// of fix to issue 619.


package org.argouml.uml.cognitive.critics;

import java.util.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.behavior.collaborations.*;

import org.argouml.cognitive.*;

/**
 * <p> A critic to check that the ends of an association all have distinct
 *   names.</p>
 *
 * <p>This is the first well-formedness rule for associations in the UML 1.3
 *   standard (see section 2.5.3 of the standard).</p>
 *
 * <p>Internally we use some of the static utility methods of the {@link
 * org.argouml.cognitive.critics.CriticUtils CriticUtils} class.</p>
 *
 * @see <a href="http://argouml.tigris.org/documentation/snapshots/manual/argouml.html/#s2.ref.critics_dup_role_names">ArgoUML User Manual: Duplicate end (role) names for &lt;association&gt;</a>
 */

public class CrDupRoleNames extends CrUML {

    /**
     * <p>Constructor for the critic.</p>
     *
     * <p>Sets up the resource name, which will allow headline and description
     * to found for the current locale. Provides a design issue category
     * (NAMING) and add triggers for "connection" and "end_name".</p>
     */

    public CrDupRoleNames() {

        setResource("CrDupRoleNames");

        addSupportedDecision(CrUML.decNAMING);

        // These may not actually make any difference at present (the code
        // behind addTrigger needs more work).

        addTrigger("connection");
        addTrigger("end_name");
    }


    /**
     * <p>The trigger for the critic.</p>
     *
     * <p>We do not handle association roles, which are a subclass of
     *   association. An association role should be fine, if its parent is OK,
     *   since it must have the same or fewer ends than its parent.</p>
     *
     * <p><em>Note</em>. ArgoUML does not currently have a constructor to check
     *   that an association role is more tightly constrained than its
     *   parent.</p>
     *
     * <p>Then loop through the ends, building a vector of end names that we
     *   have seen, and looking to see if the current end is already in that
     *   vector. We ignore any ends that are unnamed, or have the empty string
     *   as name.</p>
     *
     * <p>Whilst this is an O(n^2) algorithm, most associations have only two
     *   ends, so this is unlikely to cause difficulty.</p>
     *
     * @param  dm    the {@link java.lang.Object Object} to be checked against
     *               the critic.
     *
     * @param  dsgr  the {@link org.argouml.cognitive.Designer Designer}
     *               creating the model. Not used, this is for future
     *               development of ArgoUML.
     *
     * @return       {@link #PROBLEM_FOUND PROBLEM_FOUND} if the critic is
     *               triggered, otherwise {@link #NO_PROBLEM NO_PROBLEM}.  
     */
    
    public boolean predicate2(Object dm, Designer dsgr) {

        // Only work for associations

        if (!(dm instanceof MAssociation)) {
            return NO_PROBLEM;
        }

        // Get the assocations and connections. No problem if there are no
        // connections defined, or this is an association role.

        MAssociation asc = (MAssociation) dm;

        if (asc instanceof MAssociationRole) {
            return NO_PROBLEM;
        }

        Collection   conns = asc.getConnections();

        if (conns == null) {
            return NO_PROBLEM;
        }

        // Loop through all the ends, comparing the name against those already
        // seen (ignoring any with no name).

        Vector   namesSeen = new Vector();
        Iterator enum      = conns.iterator();

        while (enum.hasNext()) {

            MAssociationEnd ae     = (MAssociationEnd) enum.next();
            String          aeName = ae.getName();

            // Ignore non-existent and empty names

            if ((aeName == null) || aeName.equals("")) {
                continue;
            }

            // Is the name already in the vector of those seen, if not add it
            // and go on round.

            if (namesSeen.contains(aeName)) {
                return PROBLEM_FOUND;
            }

            namesSeen.addElement(aeName);
        }

        // If we drop out there were no clashes

        return NO_PROBLEM;
    }

} /* end class CrDupRoleNames */

