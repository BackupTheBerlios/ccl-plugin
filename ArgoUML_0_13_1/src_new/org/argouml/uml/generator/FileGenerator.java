// Copyright (c) 2002 The Regents of the University of California. All
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

package org.argouml.uml.generator;

import ru.novosoft.uml.foundation.core.*;
//import ru.novosoft.uml.foundation.data_types.*;
//import ru.novosoft.uml.foundation.extension_mechanisms.*;
//import ru.novosoft.uml.foundation.data_types.MMultiplicity;
//import ru.novosoft.uml.foundation.data_types.MExpression;
//import ru.novosoft.uml.behavior.common_behavior.*;
//import ru.novosoft.uml.behavior.collaborations.*;
//import ru.novosoft.uml.behavior.state_machines.*;
//import ru.novosoft.uml.model_management.*;
import java.util.*;

/** This class is the interface that tells that a certain generator
 * can generate a file.
 */
public interface FileGenerator {	   /**   * The fileseperation for this operating system.   */	public final static String FILE_SEPARATOR = System.getProperty("file.separator");
    /** Generates a file for this classifier.
     * TODO:
     * This will only work for languages that have each node
     * in a separate files (one or more).
     * @returns filename
     */
    public String GenerateFile(MClassifier node, String path);
}
