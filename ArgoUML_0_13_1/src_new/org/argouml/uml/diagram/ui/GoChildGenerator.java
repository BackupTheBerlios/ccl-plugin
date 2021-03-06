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

package org.argouml.uml.diagram.ui;

import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

import org.argouml.ui.*;
import org.tigris.gef.util.*;

public class GoChildGenerator extends AbstractGoRule {

    ChildGenerator _cg;
    String _name;

    public GoChildGenerator(ChildGenerator cg, String name) {
	_cg = cg;
	_name = name;
    }

    public String getRuleName() {
	return _name;
    }

    public Object getRoot() {
	throw 
	    new UnsupportedOperationException("should never be called");
    }
    public void setRoot(Object r) { }

    public Object getChild(Object parent, int index) {
	Enumeration e = _cg.gen(parent);
	while (e.hasMoreElements())
	{
	    if (index-- == 0)
		return e.nextElement();
	    e.nextElement();
	}
	return null;
    }

    public Collection getChildren(Object parent) { 
      throw
          new UnsupportedOperationException("getChildren should not be called");
    }

    public int getChildCount(Object parent) {
	int count = 0;
	Enumeration e = _cg.gen(parent);
	while (e.hasMoreElements())
	{
	    count++;
	    e.nextElement();
	}
	return count;
    }

    public int getIndexOfChild(Object parent, Object child) {
	int index = 0;
	Enumeration e = _cg.gen(parent);
	while (e.hasMoreElements())
	{
	    if (child == e.nextElement())
		return index;
	    index++;
	}
	return -1;
    }

    public boolean isLeaf(Object node) {
	return !(getChildCount(node) > 0);
    }

    public void valueForPathChanged(TreePath path, Object newValue) { }
    public void addTreeModelListener(TreeModelListener l) { }
    public void removeTreeModelListener(TreeModelListener l) { }

}
