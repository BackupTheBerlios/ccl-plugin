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



// File: CheckManager.java
// Class: CheckManager
// Original Author: jrobbins@ics.uci.edu
// $Id: CheckManager.java,v 1.1 2003/07/12 18:27:51 layekers Exp $

package org.argouml.cognitive.checklist;

import java.util.*;

/** The CheckManager keeps track of whcih Checklists should be
 *  presented for a given design material.  CheckManager also keeps
 *  track of which CheckItem's are checked off for a given design
 *  element.  */

public class CheckManager implements java.io.Serializable {

  ////////////////////////////////////////////////////////////////
  // static variables

  protected static Hashtable _lists = new Hashtable();
  protected static Hashtable _stats = new Hashtable();

  ////////////////////////////////////////////////////////////////
  // constructor
  public CheckManager() { }

  ////////////////////////////////////////////////////////////////
  // static accessors

  public static Checklist getChecklistFor(Object dm) {
    Checklist cl = (Checklist) _lists.get(dm);
    if (cl != null) return cl;
    java.lang.Class cls = dm.getClass();
    while (cls != null) {
      cl = (Checklist) _lists.get(cls);
      if (cl != null) return cl;
      cls = cls.getSuperclass();
    }
    return null;
  }

  public static void register(Object dm, Checklist cl) {
    _lists.put(dm, cl);
  }

  public static ChecklistStatus getStatusFor(Object dm) {
    ChecklistStatus cls = (ChecklistStatus) _stats.get(dm);
    if (cls == null) {
      cls = new ChecklistStatus();
      _stats.put(dm, cls);
    }
    return cls;
  }
} /* end class CheckManager */

