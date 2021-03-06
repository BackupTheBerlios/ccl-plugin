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

package org.argouml.cognitive.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.model_management.*;

import org.argouml.cognitive.*;

/** A dialog to set the priorities for decisions. These will be evulated
 *  against the critics, so that the user will only see todo items which match
 *  the priorties for a certain decision.
 */
public class DesignIssuesDialog extends JDialog
    implements ActionListener, ChangeListener {
    public static int _numDecisionModel = 0;

    ////////////////////////////////////////////////////////////////
    // constants
    public final int WIDTH = 300;
    public final int HEIGHT = 450;

    ////////////////////////////////////////////////////////////////
    // instance variables
    protected JPanel  _mainPanel = new JPanel();
    protected JButton _okButton = new JButton("OK");
    protected Hashtable _slidersToDecisions = new Hashtable();
    protected Hashtable _slidersToDigits = new Hashtable();

    ////////////////////////////////////////////////////////////////
    // constructors

    public DesignIssuesDialog(Frame parent) {
        super(parent, "Design Issues", false);

        int x = parent.getLocation().x + (parent.getSize().width - WIDTH) / 2;
        int y = parent.getLocation().y + (parent.getSize().height - HEIGHT) / 2;
        setLocation(x, y);
        setSize(WIDTH, HEIGHT);
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        initMainPanel();
        JScrollPane scroll =
            new JScrollPane(_mainPanel,
                            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        content.add(scroll, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JPanel buttonInner = new JPanel(new GridLayout(1, 1));
        buttonInner.add(_okButton);
        buttonPanel.add(buttonInner);

        content.add(buttonPanel, BorderLayout.SOUTH);
        _okButton.addActionListener(this);

        getRootPane().setDefaultButton(_okButton);

        _numDecisionModel++;
    }


    public void initMainPanel() {
        DecisionModel dm = Designer.TheDesigner.getDecisionModel();
        Vector decs = dm.getDecisions();

        GridBagLayout gb = new GridBagLayout();
        _mainPanel.setLayout(gb);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.ipadx = 3; c.ipady = 3;


        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 1;
        JLabel decTitleLabel = new JLabel("Decision");
        gb.setConstraints(decTitleLabel, c);
        _mainPanel.add(decTitleLabel);

        c.gridy = 0;
        c.gridx = 2;
        c.gridwidth = 8;
        JLabel priLabel = new JLabel("Priority");
        gb.setConstraints(priLabel, c);
        _mainPanel.add(priLabel);

        c.gridy = 1;
        c.gridx = 2;
        c.gridwidth = 2;
        JLabel offLabel = new JLabel("Off");
        gb.setConstraints(offLabel, c);
        _mainPanel.add(offLabel);

        c.gridy = 1;
        c.gridx = 4;
        c.gridwidth = 2;
        JLabel lowLabel = new JLabel("Low");
        gb.setConstraints(lowLabel, c);
        _mainPanel.add(lowLabel);

        c.gridy = 1;
        c.gridx = 6;
        c.gridwidth = 2;
        JLabel mediumLabel = new JLabel("Medium");
        gb.setConstraints(mediumLabel, c);
        _mainPanel.add(mediumLabel);

        c.gridy = 1;
        c.gridx = 8;
        c.gridwidth = 2;
        JLabel highLabel = new JLabel("High");
        gb.setConstraints(highLabel, c);
        _mainPanel.add(highLabel);


        c.gridy = 2;
        java.util.Enumeration enum = decs.elements();
        while (enum.hasMoreElements()) {
            Decision d = (Decision) enum.nextElement();
            JLabel decLabel = new JLabel(d.getName());
            JLabel valueLabel = new JLabel(getValueText(d.getPriority()));
            JSlider decSlide = 
                new JSlider(SwingConstants.HORIZONTAL,
                            1, 4, (d.getPriority() == 0 ? 4 : d.getPriority()));

            decSlide.setInverted(true);
            decSlide.setMajorTickSpacing(1);
            decSlide.setPaintTicks(true);
            decSlide.setSnapToTicks(true);
            // decSlide.setPaintLabels(true);
            decSlide.addChangeListener(this);
            Dimension origSize = decSlide.getPreferredSize();
            Dimension smallSize = 
                new Dimension(origSize.width/2, origSize.height);
            decSlide.setSize(smallSize);
            decSlide.setPreferredSize(smallSize);

            _slidersToDecisions.put(decSlide, d);
            _slidersToDigits.put(decSlide, valueLabel);

            c.gridx = 0;
            c.gridwidth = 1;
            c.weightx = 0.0;
            c.ipadx = 3;
            gb.setConstraints(decLabel, c);
            _mainPanel.add(decLabel);

            c.gridx = 1;
            c.gridwidth = 1;
            c.weightx = 0.0;
            c.ipadx = 0;
            gb.setConstraints(valueLabel, c);
            _mainPanel.add(valueLabel);

            c.gridx = 2;
            c.gridwidth = 8;
            c.weightx = 1.0;
            gb.setConstraints(decSlide, c);
            _mainPanel.add(decSlide);

            c.gridy++;
        }
    }
  
    ////////////////////////////////////////////////////////////////
    // event handlers
  
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == _okButton) {
            setVisible(false);
            dispose();
        }
    }


    public void stateChanged(ChangeEvent ce) {
        JSlider srcSlider = (JSlider) ce.getSource();
        Decision d = (Decision) _slidersToDecisions.get(srcSlider);
        JLabel valLab = (JLabel) _slidersToDigits.get(srcSlider);
        int pri = srcSlider.getValue();
        d.setPriority((pri == 4) ? 0 : pri);
        valLab.setText(getValueText(pri));
    }

    protected String getValueText(int priority) {
        String label = "";
        switch(priority) {
        case 0: label = " off"; break;
        case 1: label = "   1"; break;
        case 2: label = "   2"; break;
        case 3: label = "   3"; break;
        case 4: label = " off"; break;
        }
        return label;
    }
 
} /* end class DesignIssuesDialog */



////////////////////////////////////////////////////////////////


