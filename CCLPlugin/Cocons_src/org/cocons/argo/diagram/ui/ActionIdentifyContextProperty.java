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
import org.cocons.argo.util.*;
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

public class ActionIdentifyContextProperty  extends UMLAction  {

  protected static ImageIcon _identifyContextPropertyIcon = ResourceLoader.lookupIconResource("IdentifyContextProperty");
  private ModelIterator _modelIterator = ModelIterator.SINGLETON;

  public static ActionIdentifyContextProperty SINGLETON = new ActionIdentifyContextProperty();

  private static boolean _identifyMode = true;

  public ActionIdentifyContextProperty() {
    super("IdentifyContextProperty");
  }

  ////////////////////////////////////////////////////////////////
  // main methods

  public void actionPerformed(ActionEvent ae) {
    anonymActionPerformed();
  }

  public void anonymActionPerformed() {
    if (_identifyMode) {
      if (_modelIterator.getCountContextPropertyTags() > 0) {
        TagIdentifier ident = new TagIdentifier();
        ident.show();
        if (ident.wasCanceled()) _identifyMode = true;
        else {
          _identifyMode = false;
        }
      }
      else JOptionPane.showMessageDialog(null,"No Context Property Tags defined.");
    }
    else {
      reset();
      _identifyMode = true;
    }
  }

  public void setResetMode() {
    _identifyMode = false;
  }

  private void reset() {
    Vector cpTaggedValues = _modelIterator.getAllContextPropertyValues();
    if (cpTaggedValues.size() > 0) {
      for (int i = 0; i < cpTaggedValues.size(); i++) {
        MContextPropertyValueImpl cpTaggedValue = (MContextPropertyValueImpl)cpTaggedValues.elementAt(i);
        cpTaggedValue.resetFigureColor();
      }
    }
  }

  // ----- Class TagIdentifier -----
  class TagIdentifier {

    private String _choosenTag = "";
    private JDialog _dialog;
    private JComboBox _nameBox;
    private JComboBox _modeBox;
    private JLabel _nameLabel;

    private boolean _canceled = false;
    private boolean _tagMode = true;

    public TagIdentifier() {
      initLayout();
    }

    public String getChoosenName() {
      if (_choosenTag.equals("")) return(null);
      else return(_choosenTag);
    }

    private void initLayout() {
      JPanel buttonPanel = new JPanel();
      JButton selectButton = new JButton("Identify");
      selectButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          _choosenTag = (String)_nameBox.getSelectedItem();
          _dialog.dispose();
          identifyTag();
          _canceled = false;
        }
      });
      JButton cancelButton = new JButton("Cancel");
      cancelButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          _choosenTag = "";
          _dialog.dispose();
          _canceled = true;
        }
      });
      _modeBox = new JComboBox();
      _modeBox.addItem(" by Tag Name");
      _modeBox.addItem(" by Stereotype");
      _modeBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          if ((_modeBox.getSelectedIndex()==0)&&(!_tagMode)) {
            _nameBox.removeAllItems();
            _nameLabel.setText(" Tag Name :");
            Vector tagNames = _modelIterator.getAllContextPropertyTagNames();
            for (int i = 0; i < _modelIterator.getCountContextPropertyTags(); i++) {
              _nameBox.addItem(tagNames.elementAt(i));
            }
            //_nameBox.setBackground(Color.yellow);
            //_nameBox.setForeground(Color.black);
            _tagMode = true;
          }
          else if ((_modeBox.getSelectedIndex()==1)&&(_tagMode)) {
            _nameBox.removeAllItems();
            _nameLabel.setText(" Stereotype :");
            _nameBox.addItem("no stereotype");
            _nameBox.addItem("Quality");
            _nameBox.addItem("Implement");
            _nameBox.addItem("Configure");
            //_nameBox.setBackground(Color.white);
            //_nameBox.setForeground(Color.red);
            _tagMode = false;
          }
          else {}
        }
      });
      buttonPanel.add(selectButton,"West");
      buttonPanel.add(_modeBox,"Center");
      buttonPanel.add(cancelButton,"East");

      JPanel namePanel = new JPanel();
      _nameLabel = new JLabel(" Tag Name :");
      _nameBox = new JComboBox();
      //_nameBox.setBackground(Color.yellow);
      _nameBox.setBackground(Color.white);
      Vector tagNames = _modelIterator.getAllContextPropertyTagNames();
      for (int i = 0; i < _modelIterator.getCountContextPropertyTags(); i++) {
        _nameBox.addItem(tagNames.elementAt(i));
      }

      namePanel.add(_nameLabel,"West");
      namePanel.add(_nameBox,"East");

      JFrame parent = new JFrame();
      _dialog = new JDialog(parent,"Find Context Properties",true);

      _dialog.getContentPane().add(buttonPanel,"South");
      _dialog.getContentPane().add(namePanel,"North");

      _dialog.setSize(280,95);
      //_dialog.setResizable(false);
      Toolkit tk = Toolkit.getDefaultToolkit();
      int screenWidth = tk.getScreenSize().width;
      int screenHeight = tk.getScreenSize().height;
      _dialog.setLocation((screenWidth-280)/2,(screenHeight-95)/2);
    }

    private void identifyTag() {
      if (_tagMode) {
        if (_choosenTag.equals("")) return;
        Vector cpTaggedValues = _modelIterator.getAllContextPropertyValues();
        if (cpTaggedValues.size() > 0) {
          for (int i = 0; i < cpTaggedValues.size(); i++) {
            MContextPropertyValueImpl cpTaggedValue = (MContextPropertyValueImpl)cpTaggedValues.elementAt(i);
            if (cpTaggedValue.getContextPropertyTag().getTag().equals(_choosenTag)) cpTaggedValue.markFigure();
          }
        }
      }
      else {
        String testString = _choosenTag;
        if (_choosenTag.equals("no stereotype")) testString = "";
        Vector cpTaggedValues = _modelIterator.getAllContextPropertyValues();
        if (cpTaggedValues.size() > 0) {
          for (int i = 0; i < cpTaggedValues.size(); i++) {
            MContextPropertyValueImpl cpTaggedValue = (MContextPropertyValueImpl)cpTaggedValues.elementAt(i);
            if (cpTaggedValue.getStereoString().equals(testString)) cpTaggedValue.markFigure();
          }
        }
      }
    }

    public void show() {
      _dialog.show();
    }

    public boolean wasCanceled() {
      return(_canceled);
    }

  }
  // ----- Class TagIdentifier -----

}