package org.cocons.argo.diagram.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.Vector;

import org.tigris.gef.util.ResourceLoader;

import org.argouml.uml.ui.UMLAction;
import org.argouml.ui.ProjectBrowser;
import org.argouml.kernel.Project;
import org.cocons.argo.util.ModelIterator;
import org.cocons.uml.ccl.context_property1_3.*;

import ru.novosoft.uml.foundation.core.MConstraint;
import ru.novosoft.uml.foundation.core.MConstraintImpl;
import ru.novosoft.uml.foundation.data_types.*;

/**
 * Title:        CCL-Plugin for ArgoUML
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      Technische Universität Berlin
 * @author hyshosha@gmx.de ; hasihola@cs.tu-berlin.de
 * @version 1.0
 */

public class ActionInfoContextPropertyTags extends UMLAction  {

  protected static ImageIcon _infoContextPropertyTagsIcon = ResourceLoader.lookupIconResource("InfoContextPropertyTags");
  private ModelIterator _modelIterator = ModelIterator.SINGLETON;


  public static ActionInfoContextPropertyTags SINGLETON = new ActionInfoContextPropertyTags();

  public ActionInfoContextPropertyTags() {
    super("InfoContextPropertyTags");
  }

  ////////////////////////////////////////////////////////////////
  // main methods

  public void actionPerformed(ActionEvent ae) {
    anonymActionPerformed();
  }

  public void anonymActionPerformed() {

    if (_modelIterator.getCountContextPropertyTags()==0) {
      JOptionPane.showMessageDialog(null,"No defined Context Properties Tags found !");
      return;
    }
    else {
      TagInfo tagInfo = new TagInfo();
      tagInfo.show();
    }
  }

  ////////////////////////////////////////////////////////////////
  // helper classes

  // ===========================================================================
  // ----- Class TagInfo -----
  class TagInfo {

    private JDialog _dialog;

    public TagInfo() {
      initLayout();
    }

    private void initLayout() {
      JPanel buttonPanel = new JPanel();
      JButton okayButton = new JButton("OK");
      okayButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          _dialog.dispose();
        }
      });
      buttonPanel.add(okayButton,"Center");

      JTextArea infoText = new JTextArea();
      infoText.setEditable(false);
      infoText.setText("                   Defined Context Property Tags:\n");
      infoText.append("                 -----------------------------------------------\n");
      Vector tagNames = _modelIterator.getAllContextPropertyTagNames();
      Vector tagConstraints = _modelIterator.getAllContextPropertyTagConstraints();
      for (int i = 0; i < _modelIterator.getCountContextPropertyTags(); i++) {
        int j = i+1;
        infoText.append("  "+j+". "+tagNames.elementAt(i)+" : "+tagConstraints.elementAt(i)+"\n");
      }
      infoText.setFont(new java.awt.Font("Dialog", 1, 12));
      infoText.setBackground(Color.getHSBColor(100,100,255));
      infoText.setForeground(Color.blue);
      JScrollPane infoPanel = new JScrollPane(infoText);

      JFrame parent = new JFrame();
      parent.setIconImage(_infoContextPropertyTagsIcon.getImage());
      _dialog = new JDialog(parent,"Information",true);

      _dialog.getContentPane().add(buttonPanel,"South");
      _dialog.getContentPane().add(infoPanel,"Center");

      _dialog.setSize(300,200);
      Toolkit tk = Toolkit.getDefaultToolkit();
      int screenWidth = tk.getScreenSize().width;
      int screenHeight = tk.getScreenSize().height;
      _dialog.setLocation((screenWidth-300)/2,(screenHeight-200)/2);

    }

    public void show() {
      _dialog.show();
    }

  }

}