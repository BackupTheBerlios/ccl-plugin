package org.cocons.argo.diagram.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.Vector;
import java.util.Collection;

import org.tigris.gef.util.ResourceLoader;

import org.argouml.uml.ui.UMLAction;
import org.argouml.ui.ProjectBrowser;
import org.argouml.kernel.Project;
import org.cocons.argo.util.*;
import org.cocons.uml.ccl.context_property1_3.*;

import ru.novosoft.uml.foundation.core.MConstraint;
import ru.novosoft.uml.foundation.core.MConstraintImpl;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValue;
import ru.novosoft.uml.foundation.core.MModelElement;

/**
 * Title:        CCL-Plugin for ArgoUML
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      Technische Universität Berlin
 * @author hyshosha@gmx.de ; hasihola@cs.tu-berlin.de
 * @version 1.0
 */

public class ActionManageContextPropertyTags extends UMLAction  {

  protected static ImageIcon _manageContextPropertyTagsIcon = ResourceLoader.lookupIconResource("ManageContextPropertyTags");
  private ModelIterator _modelIterator = ModelIterator.SINGLETON;
  private VCPLTranslator _translator = new VCPLTranslator();

  public static ActionManageContextPropertyTags SINGLETON = new ActionManageContextPropertyTags();

  public ActionManageContextPropertyTags() {
    super("ManageContextPropertyTags");
  }

  ////////////////////////////////////////////////////////////////
  // main methods

  public void actionPerformed(ActionEvent ae) {
    anonymActionPerformed();
  }

  public void anonymActionPerformed() {
    String[] option = new String[4];
    option[0] = "Create"; option[1] = "Change"; option[2] = "Delete"; option[3] = "Cancel";

    int selection = JOptionPane.showOptionDialog(null,"         What do you want to do ... ?","  ... with Context Property Tags",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
                                                _manageContextPropertyTagsIcon,option,"Cancel");

    if (selection == 0) {
      TagCreator creator = new TagCreator();
      creator.show();
    }

    else if (selection == 1) {
      if (_modelIterator.getCountContextPropertyTags() > 0) {
        String[] changeOption = new String[3];
        changeOption[0] = "Tag Name"; changeOption[1] = "Definition"; changeOption[2] = "Cancel";
        int selection2 = JOptionPane.showOptionDialog(null,"         What do you want to do change ?","  Change Context Property Tags",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
                                                      _manageContextPropertyTagsIcon,changeOption,"Cancel");
        if (selection2 == 0) {
          TagNameChanger tagNameChanger = new TagNameChanger();
          tagNameChanger.show();
        }
        else if (selection2 == 1) {
          JOptionPane.showMessageDialog(null,"This feature is currently not available.");
        }
        else {}
      }
      else JOptionPane.showMessageDialog(null,"No Context Property Tags defined.");
    }

    else if (selection == 2) {
      if (_modelIterator.getCountContextPropertyTags() > 0) {
        TagKiller killer = new TagKiller();
        killer.show();
      }
      else JOptionPane.showMessageDialog(null,"No Context Property Tags defined.");
    }
    else if (selection == 3) {
      // "cancel" -> do nothing
    }
    else {}
  }

  ////////////////////////////////////////////////////////////////
  // helper classes

  // ===========================================================================
  // ----- Class TagCreator -----
  class TagCreator {

    private JDialog _dialog;
    private JTextField _nameTextField;
    private JLabel _validValuesLabel;
    private JComboBox _validValuesBox;
    private JTextField _definitionTextField;
    private JLabel _definitionLabel;
    private boolean _listOfStrings = true;
    private boolean _integerNumber = false;
    private boolean _floatNumber = false;

    private JDialog _dialog2;
    private JTextField _unitTextField;
    private String _unitForNumericValues;

    public TagCreator() {
      initLayout();
    }

    private void initLayout() {
      JPanel buttonPanel = new JPanel();
      JButton createButton = new JButton("Create");
      createButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          createTag();
        }
      });
      JButton cancelButton = new JButton("Cancel");
      cancelButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          finishDialog();
        }
      });
      JButton helpButton = new JButton("Info");
      helpButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          //JOptionPane.showMessageDialog(null,"If you need any help mail to fbuebl@cs.tu-berlin.de !","Syntax",JOptionPane.INFORMATION_MESSAGE);
          VCPLInfo info = new VCPLInfo();
          info.show();
        }
      });
      buttonPanel.add(createButton,"West");
      buttonPanel.add(cancelButton,"Center");
      buttonPanel.add(helpButton,"East");

      JPanel namePanel = new JPanel();
      JLabel nameLabel = new JLabel(" Tag Name :");
      _nameTextField = new JTextField(16);
      namePanel.add(nameLabel,"West");
      namePanel.add(_nameTextField,"East");

      JPanel validValuesPanel = new JPanel();
      validValuesPanel.setLayout(new GridLayout(2,2));
      _validValuesLabel = new JLabel("  Valid Values ........ :");

      Object[] validValues = { "List Of Strings", "Integer Number", "Float Number" };
      _validValuesBox = new JComboBox(validValues);
      _validValuesBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          if (((String)_validValuesBox.getSelectedItem()).equals("List Of Strings")) {
            _listOfStrings = true;
            _integerNumber = false;
            _floatNumber = false;
            _definitionLabel.setText("  Allowed Strings ... :");
            _definitionTextField.setText("");
          }
          else if (((String)_validValuesBox.getSelectedItem()).equals("Integer Number")) {
            _listOfStrings = false;
            _integerNumber = true;
            _floatNumber = false;
            _definitionLabel.setText("  Range .... [from,to] :");
            _definitionTextField.setText("[,]");
          }
          else if (((String)_validValuesBox.getSelectedItem()).equals("Float Number")) {
            _listOfStrings = false;
            _integerNumber = false;
            _floatNumber = true;
            _definitionLabel.setText("  Range .... [from,to] :");
            _definitionTextField.setText("[,]");
          }
          else {}
        }
      });
      _definitionLabel = new JLabel("  Allowed Strings ... :");
      _definitionTextField = new JTextField(10);

      validValuesPanel.add(_validValuesLabel);
      validValuesPanel.add(_validValuesBox);
      validValuesPanel.add(_definitionLabel);
      validValuesPanel.add(_definitionTextField);

      JFrame parent = new JFrame();
      _dialog = new JDialog(parent,"Create Context Property Tag",true);

      _dialog.getContentPane().add(buttonPanel,"South");
      _dialog.getContentPane().add(namePanel,"North");
      _dialog.getContentPane().add(validValuesPanel,"Center");

      _dialog.setSize(220,135);
//*nix friendly     _dialog.setResizable(false);
      _dialog.setResizable(true);
      Toolkit tk = Toolkit.getDefaultToolkit();
      int screenWidth = tk.getScreenSize().width;
      int screenHeight = tk.getScreenSize().height;
      _dialog.setLocation((screenWidth-220)/2,(screenHeight-135)/2);
    }

    private void createTag() {
      String tagName = _nameTextField.getText();
      String definitionString = _definitionTextField.getText();
      Vector tagNameList = _modelIterator.getAllContextPropertyTagNames();
      int tagListSize = _modelIterator.getCountContextPropertyTags();
      MContextPropertyTagImpl newTag;

      // check, if a valid TagName was defined
      if ((tagName == null)||(tagName.equals(""))) {
        JOptionPane.showMessageDialog(null,"You should define a name for the tag first !","Oops",JOptionPane.WARNING_MESSAGE);
        return;
      }
      if (!checkTagName(tagName)) {
        JOptionPane.showMessageDialog(null,"Illegal character in tag name definition !","Oops",JOptionPane.WARNING_MESSAGE);
        return;
      }
      if (!isNewTag(tagNameList,tagListSize,tagName)) {
        JOptionPane.showMessageDialog(null,"The tag name you defined is already used !","Oops",JOptionPane.WARNING_MESSAGE);
        return;
      }

      if (_listOfStrings) {
        if ((definitionString == null)||(definitionString.equals(""))) {
          JOptionPane.showMessageDialog(null,"You should define any allowed strings !","Oops",JOptionPane.WARNING_MESSAGE);
          return;
        }
        if (_translator.checkListOfStrings(definitionString)) {
          //ProjectBrowser pb = ProjectBrowser.TheInstance;
          //Project p = pb.getProject();
          newTag = new MContextPropertyTagImpl();
          newTag.setName(tagName);
          //newTag.setNamespace(p.getModel());
          MConstraintImpl con = new MConstraintImpl();
          con.setBody(new MBooleanExpression(null,_translator.getConstraintString_ListOfStrings(definitionString)));
          newTag.addConstraint(con);
          _modelIterator.addContextPropertyTag(newTag);
        }
        else {
          JOptionPane.showMessageDialog(null,"False definition of List Of Strings !","Oops",JOptionPane.WARNING_MESSAGE);
          return;
        }
      }
      else if (_integerNumber) {
        if (_translator.checkIntegerNumberRange(definitionString)) {
          //ProjectBrowser pb = ProjectBrowser.TheInstance;
          //Project p = pb.getProject();
          newTag = new MContextPropertyTagImpl();
          newTag.setName(tagName);
          //newTag.setNamespace(p.getModel());
          getUnitDialog("Integer Number");
          MConstraintImpl con = new MConstraintImpl();
          con.setBody(new MBooleanExpression(null,_translator.getConstraintString_Integer(definitionString)+" | Unit: "+_unitForNumericValues));
          newTag.addConstraint(con);
          _modelIterator.addContextPropertyTag(newTag);
        }
        else {
          JOptionPane.showMessageDialog(null,"False range definition for Integer Number !","Oops",JOptionPane.WARNING_MESSAGE);
          return;
        }
      }
      else if (_floatNumber) {
        if (_translator.checkFloatNumberRange(definitionString)) {
          //ProjectBrowser pb = ProjectBrowser.TheInstance;
          //Project p = pb.getProject();
          newTag = new MContextPropertyTagImpl();
          newTag.setName(tagName);
          //newTag.setNamespace(p.getModel());
          getUnitDialog("Float Number");
          MConstraintImpl con = new MConstraintImpl();
          con.setBody(new MBooleanExpression(null,_translator.getConstraintString_Float(definitionString)+" | Unit: "+_unitForNumericValues));
          newTag.addConstraint(con);
          _modelIterator.addContextPropertyTag(newTag);
        }
        else {
          JOptionPane.showMessageDialog(null,"False range definition for Float Number !","Oops",JOptionPane.WARNING_MESSAGE);
          return;
        }
      }
      else {}
      finishDialog();
    }

    // ----- Check methods for user inserts -----
    /* first version
    private boolean checkTagName(String tagName) {
      for (int i = 0; i < tagName.length(); i++) {
        if (Character.isLetterOrDigit(tagName.charAt(i))||(tagName.charAt(i)=='_')||(tagName.charAt(i)=='-')) {
          if (((tagName.charAt(i)=='_')||(tagName.charAt(i)=='-'))&&(i == tagName.length()-1)) return(false);
        }
        else return(false);
      }
      return(true);
    }
    */
    private boolean checkTagName(String tagName) {
      if ((tagName.charAt(0)=='_')||(tagName.charAt(0)=='-')||(tagName.charAt(0)==' ')) return(false);
      int stringLength = tagName.length();
      if ((tagName.charAt(stringLength-1)=='_')||(tagName.charAt(stringLength-1)=='-')||(tagName.charAt(stringLength-1)==' ')) return(false);

      for (int i = 0; i < stringLength; i++) {
        if (Character.isLetterOrDigit(tagName.charAt(i))||(tagName.charAt(i)=='_')||(tagName.charAt(i)=='-')||(tagName.charAt(i)==' ')) {
          // alles bestens
        }
        else return(false);
      }
      return(true);
    }

    private boolean isNewTag(Vector tagNameList, int tagListSize, String tagName) {
      if (tagListSize==0) return(true);
      for (int i = 0; i < tagListSize; i++) {
        //if (((MContextPropertyTagImpl)tagList.elementAt(i)).getTag().equals(tagName)) return(false);
        if (((String)tagNameList.elementAt(i)).equals(tagName)) return(false);
      }
      return(true);
    }

    private void getUnitDialog(String numberType) {
      JFrame parent = new JFrame();
      _dialog2 = new JDialog(parent,"Unit for "+numberType+" ?",true);
      _unitTextField = new JTextField(20);
      JLabel unitLabel = new JLabel("      Insert a unit or leave it blank...");
      JButton okayButton = new JButton("Okay");
      okayButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (_unitTextField.getText().equals("")) {
            _unitForNumericValues = "N/A";
            _dialog2.dispose();;
          }
          else {
            String test = _unitTextField.getText();
            _unitForNumericValues = "";
            for (int i = 0; i < test.length(); i++) {
              if (test.charAt(i)=='|') _unitForNumericValues = _unitForNumericValues + "#";
              else _unitForNumericValues = _unitForNumericValues + test.charAt(i);
            }
            _dialog2.dispose();
          }
        }
      });
      _dialog2.getContentPane().add(unitLabel,"North");
      _dialog2.getContentPane().add(okayButton,"South");
      _dialog2.getContentPane().add(_unitTextField,"Center");
      _dialog2.setSize(200,90);
//*nix friendly      _dialog2.setResizable(false);
       _dialog.setResizable(true);
      Toolkit tk = Toolkit.getDefaultToolkit();
      int screenWidth = tk.getScreenSize().width;
      int screenHeight = tk.getScreenSize().height;
      _dialog2.setLocation((screenWidth-200)/2,(screenHeight-90)/2);
      _dialog2.setVisible(false);
      _dialog2.show();
    }

    // ----- Check methods for user inserts -----

    public void show() {
      _dialog.show();
    }

    private void finishDialog() {
      _dialog.dispose();
    }

  }
  // ----- Class TagCreator -----
  // ===========================================================================

  // ----- Class TagNameChanger -----
  class TagNameChanger {

    private String _choosenTag = "";
    private JDialog _dialog;
    private JComboBox _nameBox;
    private JTextField _newNameTextField;
    private ActionIdentifyContextProperty _ident = ActionIdentifyContextProperty.SINGLETON;

    public TagNameChanger() {
      initLayout();
    }

    public String getChoosenName() {
      if (_choosenTag.equals("")) return(null);
      else return(_choosenTag);
    }

    private void initLayout() {
      JPanel buttonPanel = new JPanel();
      JButton changeButton = new JButton("Change");
      changeButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          _choosenTag = (String)_nameBox.getSelectedItem();
          changeContextPropertyTagName();
        }
      });
      JButton cancelButton = new JButton("Cancel");
      cancelButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          _choosenTag = "";
          _dialog.dispose();
        }
      });
      buttonPanel.add(changeButton,"West");
      buttonPanel.add(cancelButton,"East");

      JPanel namePanel = new JPanel();
      JLabel nameLabel = new JLabel(" Tag Name :");
      _nameBox = new JComboBox();
      _nameBox.setBackground(Color.white);
      Vector tagNames = _modelIterator.getAllContextPropertyTagNames();
      for (int i = 0; i < _modelIterator.getCountContextPropertyTags(); i++) {
        _nameBox.addItem(tagNames.elementAt(i));
      }
      namePanel.add(nameLabel,"West");
      namePanel.add(_nameBox,"East");

      JPanel newNamePanel = new JPanel();
      JLabel newNameLabel = new JLabel(" New Name :");
      _newNameTextField = new JTextField(16);
      newNamePanel.add(newNameLabel,"West");
      newNamePanel.add(_newNameTextField,"East");

      JFrame parent = new JFrame();
      _dialog = new JDialog(parent,"Change Context Property Tag",true);
      _dialog.getContentPane().add(namePanel,"North");
      _dialog.getContentPane().add(newNamePanel,"Center");
      _dialog.getContentPane().add(buttonPanel,"South");
      _dialog.setSize(230,130);
//*nix Friendly      _dialog.setResizable(false);
      _dialog.setResizable(true);
      Toolkit tk = Toolkit.getDefaultToolkit();
      int screenWidth = tk.getScreenSize().width;
      int screenHeight = tk.getScreenSize().height;
      _dialog.setLocation((screenWidth-230)/2,(screenHeight-130)/2);
    }

    public void show() {
      _dialog.show();
    }

    private void finishDialog() {
      _dialog.dispose();
    }


    private void changeContextPropertyTagName() {
      Vector tagNameList = _modelIterator.getAllContextPropertyTagNames();
      int tagListSize = _modelIterator.getCountContextPropertyTags();
      // check, if a valid new TagName was defined
      String tagName = _newNameTextField.getText();
      if (tagName.equals(_choosenTag)) {
        JOptionPane.showMessageDialog(null,"Try again, baby ...","Oops",JOptionPane.WARNING_MESSAGE);
        return;
      }
      if ((tagName == null)||(tagName.equals(""))) {
        JOptionPane.showMessageDialog(null,"You should define a new name for the tag first !","Oops",JOptionPane.WARNING_MESSAGE);
        return;
      }
      if (!checkTagName(tagName)) {
        JOptionPane.showMessageDialog(null,"Illegal character in tag name definition !","Oops",JOptionPane.WARNING_MESSAGE);
        return;
      }
      if (!isNewTag(tagNameList,tagListSize,tagName)) {
        JOptionPane.showMessageDialog(null,"The tag name you defined is already used !","Oops",JOptionPane.WARNING_MESSAGE);
        return;
      }

      if (_choosenTag.equals("")) return;

      Vector cpTaggedValues = _modelIterator.getAllContextPropertyValues();
      int targetCounter = 0;
      int targetCounter2 = 0;
      for (int i = 0; i < cpTaggedValues.size(); i++) {
        MContextPropertyValueImpl cpTaggedValue = (MContextPropertyValueImpl)cpTaggedValues.elementAt(i);
        if (cpTaggedValue.getContextPropertyTag().getTag().equals(_choosenTag)) {
          targetCounter++;
          if (this.tagIsStandardTaggedValue(tagName,cpTaggedValue.getReferencedModelElement())) targetCounter2++;
        }
      }

      int selection = 0;
      if (targetCounter2 > 0) {
        Object[] options = { "Identify","Cancel" };
        selection = JOptionPane.showOptionDialog(null,"   "+targetCounter2+" Context Properties reference\n   model elements with a TaggedValue \""+tagName+"\" !\n   You should rename these TaggedValues first !","Information",JOptionPane.CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,_manageContextPropertyTagsIcon,options,"Identify");
        if (selection == 0) {
          // markieren
          for (int i = 0; i < cpTaggedValues.size(); i++) {
            MContextPropertyValueImpl cpTaggedValue = (MContextPropertyValueImpl)cpTaggedValues.elementAt(i);
            cpTaggedValue.resetFigureColor();
            if (cpTaggedValue.getContextPropertyTag().getTag().equals(_choosenTag)) {
              if (this.tagIsStandardTaggedValue(tagName,cpTaggedValue.getReferencedModelElement())) cpTaggedValue.markFigure();
            }
          }
          _ident.setResetMode();
        }
        else {}
      }
      else {
        selection = 0;
        if (targetCounter > 0) {
          Object[] options = { "Change","Cancel","Identify" };
          selection = JOptionPane.showOptionDialog(null,"   "+targetCounter+" Context Properties reference\n   the Context Property Tag \""+_choosenTag+"\"\n   that you want to change !","Information",JOptionPane.CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,_manageContextPropertyTagsIcon,options,"Cancel");
        }
        else {
          Object[] options = { "Change","Cancel" };
          selection = JOptionPane.showOptionDialog(null,"Change Context Property Tag \""+_choosenTag+"\" ?","Warning",JOptionPane.CANCEL_OPTION,JOptionPane.ERROR_MESSAGE,_manageContextPropertyTagsIcon,options,"Cancel");
        }
        if (selection == 1) {}
        else if (selection == 0) {
          _modelIterator.changeContextPropertyTagName(_choosenTag,tagName,targetCounter);
        }
        else {
          // markieren
          for (int i = 0; i < cpTaggedValues.size(); i++) {
            MContextPropertyValueImpl cpTaggedValue = (MContextPropertyValueImpl)cpTaggedValues.elementAt(i);
            if (cpTaggedValue.getContextPropertyTag().getTag().equals(_choosenTag)) cpTaggedValue.markFigure();
            else cpTaggedValue.resetFigureColor();
          }
          _ident.setResetMode();
        }
      }
      finishDialog();
    }

    // ----- Check methods for user inserts -----
    /* first version
    private boolean checkTagName(String tagName) {
      for (int i = 0; i < tagName.length(); i++) {
        if (Character.isLetterOrDigit(tagName.charAt(i))||(tagName.charAt(i)=='_')||(tagName.charAt(i)=='-')) {
          if (((tagName.charAt(i)=='_')||(tagName.charAt(i)=='-'))&&(i == tagName.length()-1)) return(false);
        }
        else return(false);
      }
      return(true);
    }
    */
    private boolean checkTagName(String tagName) {
      if ((tagName.charAt(0)=='_')||(tagName.charAt(0)=='-')||(tagName.charAt(0)==' ')) return(false);
      int stringLength = tagName.length();
      if ((tagName.charAt(stringLength-1)=='_')||(tagName.charAt(stringLength-1)=='-')||(tagName.charAt(stringLength-1)==' ')) return(false);

      for (int i = 0; i < stringLength; i++) {
        if (Character.isLetterOrDigit(tagName.charAt(i))||(tagName.charAt(i)=='_')||(tagName.charAt(i)=='-')||(tagName.charAt(i)==' ')) {
          // alles bestens
        }
        else return(false);
      }
      return(true);
    }

    private boolean tagIsStandardTaggedValue(String selectedTag, MModelElement target) {
      Collection col = target.getTaggedValues();
      if (col != null) {
        Object[] taggedValues = col.toArray();
        for (int i = 0; i < taggedValues.length; i++) {
          if (((MTaggedValue)taggedValues[i]).getTag().equals(selectedTag)) return(true);
        }
        return(false);
      }
      else return(false);
    }

    private boolean isNewTag(Vector tagNameList, int tagListSize, String tagName) {
      if (tagListSize==0) return(true);
      for (int i = 0; i < tagListSize; i++) {
        if (((String)tagNameList.elementAt(i)).equals(tagName)) return(false);
      }
      return(true);
    }

  }
  // ----- Class TagNameChanger -----
  // ===========================================================================

  // ----- Class TagDefinitionChanger -----
  // ... needs more work
  // ----- Class TagDefinitionChanger -----
  // ===========================================================================

  // ----- Class TagKiller -----
  class TagKiller {

    private String _choosenTag = "";
    private JDialog _dialog;
    private JComboBox _nameBox;
    private ActionIdentifyContextProperty _ident = ActionIdentifyContextProperty.SINGLETON;

    public TagKiller() {
      initLayout();
    }

    public String getChoosenName() {
      if (_choosenTag.equals("")) return(null);
      else return(_choosenTag);
    }

    private void initLayout() {
      JPanel buttonPanel = new JPanel();
      JButton selectButton = new JButton("Delete");
      selectButton.setBackground(Color.white);
      selectButton.setForeground(Color.red);
      selectButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          _choosenTag = (String)_nameBox.getSelectedItem();
          _dialog.dispose();
          deleteContextPropertyTag();
        }
      });
      JButton cancelButton = new JButton("Cancel");
      cancelButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          _choosenTag = "";
          _dialog.dispose();
        }
      });
      buttonPanel.add(selectButton,"West");
      buttonPanel.add(cancelButton,"East");

      JPanel namePanel = new JPanel();
      JLabel nameLabel = new JLabel(" Tag Name :");
      _nameBox = new JComboBox();
      _nameBox.setBackground(Color.white);
      Vector tagNames = _modelIterator.getAllContextPropertyTagNames();
      for (int i = 0; i < _modelIterator.getCountContextPropertyTags(); i++) {
        _nameBox.addItem(tagNames.elementAt(i));
      }
      namePanel.add(nameLabel,"West");
      namePanel.add(_nameBox,"East");

      JFrame parent = new JFrame();
      _dialog = new JDialog(parent,"Delete Context Property Tag",true);
      _dialog.getContentPane().add(buttonPanel,"South");
      _dialog.getContentPane().add(namePanel,"North");
      _dialog.setSize(220,95);
//*nix Friendly      _dialog.setResizable(false);
      _dialog.setResizable(true);
      Toolkit tk = Toolkit.getDefaultToolkit();
      int screenWidth = tk.getScreenSize().width;
      int screenHeight = tk.getScreenSize().height;
      _dialog.setLocation((screenWidth-220)/2,(screenHeight-95)/2);
    }

    private void deleteContextPropertyTag() {
      if (_choosenTag.equals("")) return;
      Vector cpTaggedValues = _modelIterator.getAllContextPropertyValues();
      int targetCounter = 0;
      for (int i = 0; i < cpTaggedValues.size(); i++) {
        MContextPropertyValueImpl cpTaggedValue = (MContextPropertyValueImpl)cpTaggedValues.elementAt(i);
        if (cpTaggedValue.getContextPropertyTag().getTag().equals(_choosenTag)) targetCounter++;
      }

      int selection = 0;
      if (targetCounter > 0) {
        Object[] options = { "Delete","Cancel","Identify" };
        selection = JOptionPane.showOptionDialog(null,"   "+targetCounter+" Context Properties reference\n   the Context Property Tag \""+_choosenTag+"\"\n   that you want to delete !\n           ??? ARE YOU SURE ???","Warning",JOptionPane.CANCEL_OPTION,JOptionPane.ERROR_MESSAGE,_manageContextPropertyTagsIcon,options,"Cancel");
      }
      else {
        Object[] options = { "Delete","Cancel" };
        selection = JOptionPane.showOptionDialog(null,"Delete Context Property Tag \""+_choosenTag+"\" ?","Warning",JOptionPane.CANCEL_OPTION,JOptionPane.ERROR_MESSAGE,_manageContextPropertyTagsIcon,options,"Cancel");
      }
      if (selection == 1) return;
      else if (selection == 0) {
        _modelIterator.removeContextPropertyTag(_choosenTag,targetCounter);
      }
      else {
        // markieren
        for (int i = 0; i < cpTaggedValues.size(); i++) {
          MContextPropertyValueImpl cpTaggedValue = (MContextPropertyValueImpl)cpTaggedValues.elementAt(i);
          if (cpTaggedValue.getContextPropertyTag().getTag().equals(_choosenTag)) cpTaggedValue.markFigure();
          else cpTaggedValue.resetFigureColor();
        }
        _ident.setResetMode();
      }
    }

    public void show() {
      _dialog.show();
    }

  }
  // ----- Class TagKiller -----
  // ===========================================================================

  // ----- Class VCPL-Info -----
  class VCPLInfo {

    private ImageIcon _infoContextPropertyTagsIcon = ResourceLoader.lookupIconResource("InfoContextPropertyTags");
    private JDialog _dialog;

    public VCPLInfo() {
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
      infoText.setText(infoVCPL);

      infoText.setFont(new java.awt.Font("Dialog", 1, 12));
      infoText.setBackground(Color.getHSBColor(100,100,255));
      infoText.setForeground(Color.blue);
      JScrollPane infoPanel = new JScrollPane(infoText);

      JFrame parent = new JFrame();
      parent.setIconImage(_infoContextPropertyTagsIcon.getImage());
      _dialog = new JDialog(parent,"\"VCPL-Syntax\"",true);

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

    // ----- der Info-Text -----
    private String infoVCPL = "\n"+
    "  Okay, hier kurz etwas zu den Konventionen, die bei der Definition\n"+
    "  von Context Property Tags zu beachten sind, weil wir sie so festgelegt haben.\n"+
    "  \n"+
    "  Tag Name:\n"+
    "  Gültige Zeichen für die Eingabe sind Buchstaben, Ziffern, \"_\" und \"-\" und Leerzeichen.\n"+
    "  Ein gültiger Tag-Name muss mit einem Buchstaben oder einer Ziffer beginnen und enden. \n"+
    "  (Insbesondere führende Leerzeichen werden hier als fehlerhafte Eingabe betrachtet.)\n"+
    "\n"+
    "  List Of Strings:\n"+
    "  Gültige Zeichen für die Definition eines validen Strings sind Buchstaben, Ziffern, \"_\" und \"-\" und Leerzeichen.\n"+
    "  Die einzelnen Strings werden voneinander durch Kommata getrennt.\n"+
    "  An Anfang und Ende des Definitionsstrings werden zulässige Zeichen erwartet (keine Kommata).\n"+
    "  Aufeinanderfolgende Kommata werden als Fehleingabe angesehen.\n"+
    "  Führende und abschliessende Leerzeichen eines Strings werden entfernt.\n"+
    "\n"+
    "  Integer Number:\n"+
    "  Gültige Zeichen für die Eingabe einer unteren/oberen Schranke sind Ziffern und \"-\".\n"+
    "  Untere und obere Schranke werden durch genau ein Komma voneinander getrennt.\n"+
    "  Eine gültige Range-Definition wird mit einem \"[\" eingeleitet und einem \"]\" abgeschlossen.\n"+
    "  (Leerzeichen sind an jeder Stelle zulässig, sie werden jedoch vor der Evaluation der Eingabe entfernt.)\n"+
    "  Soll auf eine explizite Range-Definition verzichtet werden, ist die Eingabe \"[,]\" zulässig.\n"+
    "  Soll auf eine untere/obere Schranke verzichtet werden, sind die Eingaben \"[,xxx]\" bzw. \"[xxx,]\" zulässig.\n"+
    "  Es wird erwartet, dass gilt: Unterschranke < Oberschranke .\n"+
    "  (Selbstverständlich müssen alle als numerische Angabe erwarteten Eingaben auch als\n"+
    "   solche interpretierbar sein.)\n"+
    "\n"+
    "  Float Number:\n"+
    "  Es gelten sinngemäss dieselben Vereinbarungen wie für Integer Number.\n"+
    "  Als zusätzliches zulässiges Zeichen kommt natürlich der Dezimalpunkt \".\" dazu.\n"+
    "\n"+
    "  Unit:\n"+
    "  Für die optionale Angabe einer Einheit für Integer/Float Number gelten keine Einschränkungen.\n"+
    "  Es werden allerdings alle \"|\" durch \"#\" ersetzt.\n"+
    "\n"+
    "  ***\n\n\n"+
    "    Context Property - Gruppe:\n"+
    "    Heiko Voigt <hyshosha@gmx.de>\n"+
    "    Jerry Hasiholan <hasihola@cs.tu-berlin.de>\n"+
    "    ( Berlin, 1o.o2.2oo2 )\n";
    // -------------------------

  }
  // ----- Class VCPL-Info -----
  // ===========================================================================

}