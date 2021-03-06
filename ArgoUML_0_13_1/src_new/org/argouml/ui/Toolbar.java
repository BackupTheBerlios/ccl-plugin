// Copyright (c) 1996-2002 The Regents of the University of California. All
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

/*
 * Toolbar.java
 *
 * Created on 29 September 2002, 21:01
 */

package org.argouml.ui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.Insets;

/**
 *
 * @author  administrator
 */
public class Toolbar extends JToolBar {
    
    /** Creates a new instance of Toolbar */
    public Toolbar(String title) {
        this.setFloatable(true);
        this.putClientProperty("JToolBar.isRollover", Boolean.TRUE);
        this.setMargin(new Insets(0,0,0,0));
    }
    
    /** Creates a new instance of Toolbar */
    public Toolbar() {
        super();
        this.setFloatable(false);
        this.putClientProperty("JToolBar.isRollover", Boolean.TRUE);
        this.setMargin(new Insets(0,0,0,0));
    }
    
    public Toolbar(int orientation) {
        super(orientation);
        this.setFloatable(false);
        this.putClientProperty("JToolBar.isRollover", Boolean.TRUE);
        this.setMargin(new Insets(0,0,0,0));
    }
}
