package org.cocons.uml.ccl.util;

import org.cocons.uml.ccl.util.CCLLexer;
import org.cocons.uml.ccl.util.CCLParser;
import org.cocons.uml.ccl.util.CCLElementParser;
import java.io.*;
import antlr.LexerSharedInputState;
import antlr.CommonAST;
import antlr.debug.misc.ASTFrame;
import antlr.ASTIterator;
import antlr.collections.AST;
import antlr.ASTPair;
import ru.novosoft.uml.foundation.core.MModelElement;
import org.cocons.argo.util.ElementSelectionContainer;
import org.cocons.argo.util.ContextPropertyContainer;
import java.util.Vector;
import java.io.IOException;
import java.lang.Integer;


/**
 * <p>Überschrift: CCLEvaluation</p>
 * <p>Beschreibung: Prüfung CoCons</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Organisation: TU-Berlin</p>
 * @author Ute von Angern
 * @version 0.1
 */

public class CCLEvaluation {

  private int level = 0;
  private int level2 = 0;
  private Vector cc = new Vector();
  public Vector Modelelem = new Vector();
  private String operator = "";
  private boolean logical = false;
  private int ccCount = 0;
  private boolean first = false;
  private Vector logEval = new Vector();

  /**
   * Konstruktor
   */
  public CCLEvaluation() {
  }

  /**
   * Baumstruktur des TargetSets aufbauen
   * @param target - String TargetSet
   * @return Baum
   */
  public CommonAST buildTreeTargetSet(String target) {
    try {
      StringReader sr = new StringReader(target);
      CCLLexer lexer = new CCLLexer(sr);
      CCLElementParser parser = new CCLElementParser(lexer);
      //CCLParser parser = new CCLParser(lexer);
      parser.targetset_statement();
      CommonAST parseTree = (CommonAST) parser.getAST();
      ASTFrame frame = new ASTFrame(parser.getTokenName(0), parseTree);
      frame.setVisible(true);
      //System.out.println("Range: " + parseTree.getFirstChild());
      //System.out.println("Anzahl Kinder: " + parseTree.getNumberOfChildren());
      //ASTIterator currentAST = new ASTIterator(parseTree);
      //this.visit(parser.getAST(), allElements);
      return parseTree;
    }
    catch (Exception e) {
      System.out.println("exception: " + e);
      return null;
    }
  }

  /**
   * Baumstruktur des ScopeSets aufbauen
   * @param scopet - String ScopeSet
   * @return Baum
   */
  public CommonAST buildTreeScopeSet(String scope) {
    try {
      StringReader sr = new StringReader(scope);
      CCLLexer lexer = new CCLLexer(sr);
      CCLElementParser parser = new CCLElementParser(lexer);
      //CCLParser parser = new CCLParser(lexer);
      parser.scopeset_statement();
      CommonAST parseTree = (CommonAST) parser.getAST();
      ASTFrame frame = new ASTFrame(parser.getTokenName(0), parseTree);
      frame.setVisible(true);
      //System.out.println("Range: " + parseTree.getFirstChild());
      //System.out.println("Anzahl Kinder: " + parseTree.getNumberOfChildren());
      //ASTIterator currentAST = new ASTIterator(parseTree);
      //this.visit(parser.getAST(), allElements);
      return parseTree;
    }
    catch (Exception e) {
      System.out.println("exception: " + e);
      return null;
    }
  }


  /**
   * Auswertung des Baumes TargetSet oder ScopeSet
   * @param child - Baum
   * @param allElements - Modellelemente
   */
  public void visit(AST child, Vector allElements) {
    AST child2;
    boolean quoted = false;
    String tmp = "";
    Vector cpv = new Vector();
    String oper = "";
    String ccVal = "";

    for (child2 = child; child2 != null; child2 = child2.getNextSibling()) {

      if (child2.getText() == null) {
        System.out.print("nil");
      }
      else {
        System.out.println(child2.getText());
        if (child2.getText().equals("Logic")) {
          level2 = level + 1;
          System.out.println("Logic " + level);
        }
        if (child2.getText().equals(")")) {
          level2--;
        }
        if (level2 == level) {
          if ( (child2.getText().equals("AND")) || (child2.getText().equals("OR"))) {
            logEval.add(child2.getText());
            logEval.add("" + level);
            System.out.println("Operator " + level);
          }
        }
        if (level2 + 1 == level) {
          ccCount = 0;
          if(child2.getText().equals("Logical")) {
            logical = true;
          }
          if(child2.getText().equals("EXACTLY")) {
            operator = "AND";
          }
          if(child2.getText().equals("AT")) {
            operator = "OR";
          }
          if(child2.getText().equals("ONLY")) {
            operator = "EQUAL";
          }
          if (child2.getText().equals("'")) {
            if (quoted) {
              System.out.println("Name tmp " + tmp.trim());
              cc.addElement(tmp.trim());
              System.out.println("Name " + tmp + " " + cc.toString());
              if (cc.size() == 3) {
                cpv.addElement(cc.elementAt(2));
                System.out.println("selectConditions aufrufen");
                logEval.add(selectCondition( (String) cc.elementAt(0), allElements, cpv,(String) cc.elementAt(1), operator));
                cc.removeAllElements();
                cpv.removeAllElements();
                operator = "";
              }
              quoted = false;
              tmp = "";
            }
            else {
              quoted = true;
            }
          }
          else {
            if (quoted) {
              tmp = tmp + child2.getText() + " ";
            }
          }
        }
        if ( (level2 + 2 == level) && (! (child2.getText().equals("WHERE")))) {
          if (child2.getText().equals("'")) {
            if (quoted) {
              cc.addElement(tmp);
              quoted = false;
              tmp = "";
            }
            else {
              quoted = true;
            }
          }
          else {
            if (quoted) {
              tmp = tmp + child2.getText() + " ";
            }
            else {
              ccCount++;
              if(ccCount > 1) {
                ccVal = (String) cc.elementAt(1);
                ccVal = ccVal + " " + child2.getText();
                cc.removeElementAt(1);
                cc.insertElementAt(ccVal,1);
              }
              else {
                cc.addElement(child2.getText());
              }
            }
          }
          System.out.println("Condition " + child2.getText() + " " + cc.toString());
        }
      }

      if (child2.getFirstChild() != null) {
        level++;
        visit(child2.getFirstChild(), allElements);
        level--;
      }
    }
    if(logical) {
      if (cc.size() > 3) {
        System.out.println("Vector " + tmp + " " + cc.toString());
        for (int i = 2; i < cc.size(); i++) {
          oper = (String) cc.elementAt(i);
          if (oper.trim().equals("AND")) {
            operator = oper.trim();
          }
          else {
            cpv.addElement(cc.elementAt(i));
            System.out.println("values bestimmen " + cpv.toString());
          }
        }
        System.out.println("cc " + cc.toString());
        logEval.add(selectCondition( (String) cc.elementAt(0), allElements, cpv, (String) cc.elementAt(1), operator));
        cc.removeAllElements();
        cpv.removeAllElements();
        operator = "";
        logical = false;
      }
    }
  }

  public void evaluate() {
    Vector v = new Vector();
    int index = -1;

    if(logEval.size() == 1) {
      v = (Vector) logEval.elementAt(0);
      for(int i=0; i<v.size(); i++) {
        Modelelem.add(v.elementAt(i));
      }
    }
    else {
      if(logEval.size() == 4) {
        Modelelem = quantity((Vector) logEval.elementAt(0), (Vector) logEval.elementAt(3), (String) logEval.elementAt(1));
      }
      else {
        if(logEval.size() > 4) {
          while (!logEval.isEmpty()) {
            index = getfirstIndex(logEval);
            if(index >= 2) {
              v = quantity((Vector) logEval.elementAt(index-2), (Vector) logEval.elementAt(index + 1), (String) logEval.elementAt(index - 1));
            }
            for(int j=0; j<4; j++) {
              logEval.removeElementAt(index - 2);
            }
            if(logEval.size() > 0) {
              System.out.println("Ergebnis " + v.toString());
              logEval.add(index - 2, v);
            }
            else {
              for(int i=0; i<v.size(); i++) {
                Modelelem.add(v.elementAt(i));
              }
            }
          }
        }
      }
    }
  }

  public int getfirstIndex(Vector v) {
    int index = -1;
    int val = 0;
    int m = -1;

    for(int i=2; i<v.size(); i+=3) {
      m = new Integer((String) v.elementAt(i)).intValue();
      if(val < m) {
        val = m;
        index = i;
      }
    }
    return index;
  }

  public Vector quantity(Vector v1, Vector v2, String op) {
    Vector v = new Vector();

    System.out.println("menge1 " + v1.toString());
    System.out.println("menge2 " + v2.toString());
    System.out.println("op " + op);
    if(op.equals("AND")) {
      for(int i=0; i< v1.size(); i++) {
        ElementSelectionContainer cont = (ElementSelectionContainer) v1.elementAt(i);
        if(isName(cont.getModelelement().getName(),v2)) {
           v.add(v1.elementAt(i));
        }
      }
    }
    if(op.equals("OR")) {
      for(int i=0; i< v1.size(); i++) {
         v.add(v1.elementAt(i));
      }
      for(int j=0; j< v2.size(); j++) {
         v.add(v2.elementAt(j));
      }
    }
    return v;
  }

  public boolean isName(String name, Vector v) {
    boolean in = false;

    System.out.println("Name " + name);
    for(int i=0; i< v.size(); i++) {
      ElementSelectionContainer cont = (ElementSelectionContainer) v.elementAt(i);
      if(name.equals(cont.getModelelement().getName())) {
        in = true;
        break;
      }
    }
    return in;
  }

  /**
   * liefert alle Modellelemente mit ContextPropertyName = cpName
   * @param cpName - Name des ContextProperty
   * @param allElements - Modellelemente
   * @return Modellelemente mit ContextPropertyName = cpName
   */
  public Vector getElementsWith(String cpName, Vector allElements) {
    Vector v = new Vector();
    Vector cpl = new Vector();

    System.out.println("getElementsWith " + allElements.toString());
    for(int i=0; i< allElements.size(); i++) {
      ElementSelectionContainer esc = (ElementSelectionContainer) allElements.elementAt(i);
      cpl = esc.getContextPropertyList();
      //System.out.println("getElementsWith " + esc.getModelelement().toString());
      for(int j=0; j< cpl.size(); j++) {
        ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
        System.out.println("getElementsWith " + cp.getContextPropertyName() + " " + cpName.trim());
        if (cpName.trim().equals( (String) cp.getContextPropertyName())) {
          System.out.println("getElementsWith " + cp.getContextPropertyName());
          v.addElement(allElements.elementAt(i));
        }
      }
    }
    return v;
  }

  /**
   * Liefert true, wenn der Wert im Vector enthalten ist
   * @param value - zu überprüfende wert
   * @param values - Vector
   * @return boolean
   */
  public boolean isContain(String value, Vector values) {
    boolean iscon = false;

    System.out.println("isContains " + values.toString());
    for(int i=0; i<values.size(); i++) {
      if (value.trim().equals( (String) values.elementAt(i))) {
        iscon = true;
        break;
      }
      else {
        iscon = iscon || false;
      }
    }
    System.out.println("isContains " + iscon);
    return iscon;
  }

  /**
   * CompairCondition Contains liefert alle Modellelemente welche den oder die Werte enthalten
   * @param cpValue - Werte
   * @param partElements - Modellelemente
   * @param operator - logischer Operator [AND, OR, '']
   * @return Vector mit Modellelementen
   */
  public Vector contains(Vector cpValue, Vector partElements, String operator) {
    Vector v = new Vector();
    Vector cpl = new Vector();
    String val = "";
    boolean con = true;
    boolean con2 = false;

    System.out.println("cpValue " + cpValue.toString());
    if(operator.equals("AND")) {
      for (int i = 0; i < partElements.size(); i++) {
        ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
        cpl = esc.getContextPropertyList();
        for (int j = 0; j < cpl.size(); j++) {
          ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
          System.out.println("val " + cp.getContextPropertyValues().toString() + cpValue.size());
          for(int k=0; k<cpValue.size(); k++) {
            val = (String) cpValue.elementAt(k);
            if (isContain(val.trim(), cp.getContextPropertyValues())) {
              con = con && true;
            }
            else {
              con = con && false;
            }
          }
          if(con) {
            v.addElement(partElements.elementAt(i));
          }
        }
      }
    }
    else {
      if(operator.equals("XOR")) {
        for (int i = 0; i < partElements.size(); i++) {
          ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
          cpl = esc.getContextPropertyList();
          for (int j = 0; j < cpl.size(); j++) {
            ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
            System.out.println("val " + cp.getContextPropertyValues().toString() + cpValue.size());
            for(int k=0; k<cpValue.size(); k++) {
              val = (String) cpValue.elementAt(k);
              if (isContain(val.trim(), cp.getContextPropertyValues())) {
                con = con && true;
                con2 = con2 || true;
              }
              else {
                con = con && false;
                con2 = con2 || false;
              }
            }
            if((!(con)) && (con2)) {
              v.addElement(partElements.elementAt(i));
            }
          }
        }
      }
      else {
        for (int i = 0; i < partElements.size(); i++) {
          ElementSelectionContainer esc = (ElementSelectionContainer)
              partElements.elementAt(i);
          cpl = esc.getContextPropertyList();
          for (int j = 0; j < cpl.size(); j++) {
            ContextPropertyContainer cp = (ContextPropertyContainer) cpl.
                elementAt(j);
            for (int k = 0; k < cpValue.size(); k++) {
              val = (String) cpValue.elementAt(k);
              if (isContain(val.trim(), cp.getContextPropertyValues())) {
                v.addElement(partElements.elementAt(i));
                break;
              }
            }
          }
        }
      }
    }
    return v;
  }

  /**
   * CompairCondition Does Not Contains liefert alle Modellelemente welche den oder die Werte nicht enthalten
   * @param cpValue - Werte
   * @param partElements - Modellelemente
   * @param operator - logischer Operator [AND, OR, '']
   * @return Vector mit Modellelementen
   */
  public Vector notContains(Vector cpValue, Vector partElements, String operator) {
    Vector v = new Vector();
    Vector cpl = new Vector();
    String val = "";
    boolean con = true;
    boolean con2 = false;

    if(operator.equals("AND")) {
      for (int i = 0; i < partElements.size(); i++) {
        ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
        cpl = esc.getContextPropertyList();
        for (int j = 0; j < cpl.size(); j++) {
          ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
          System.out.println("val " + cp.getContextPropertyValues().toString() + cpValue.size());
          for(int k=0; k<cpValue.size(); k++) {
            val = (String) cpValue.elementAt(k);
            if (!(isContain(val.trim(), cp.getContextPropertyValues()))) {
              con = con && true;
            }
            else {
              con = con && false;
            }
          }
          if(con) {
            v.addElement(partElements.elementAt(i));
          }
        }
      }
    }
    else {
      if(operator.equals("XOR")) {
        for (int i = 0; i < partElements.size(); i++) {
          ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
          cpl = esc.getContextPropertyList();
          for (int j = 0; j < cpl.size(); j++) {
            ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
            System.out.println("val " + cp.getContextPropertyValues().toString() + cpValue.size());
            for(int k=0; k<cpValue.size(); k++) {
              val = (String) cpValue.elementAt(k);
              if (!(isContain(val.trim(), cp.getContextPropertyValues()))) {
                con = con && true;
                con2 = con2 || true;
              }
              else {
                con = con && false;
                con2 = con2 || false;
              }
            }
            if((!(con)) && (con2)) {
              v.addElement(partElements.elementAt(i));
            }
          }
        }
      }
      else {
        for (int i = 0; i < partElements.size(); i++) {
          ElementSelectionContainer esc = (ElementSelectionContainer)
              partElements.elementAt(i);
          cpl = esc.getContextPropertyList();
          for (int j = 0; j < cpl.size(); j++) {
            ContextPropertyContainer cp = (ContextPropertyContainer) cpl.
                elementAt(j);
            for (int k = 0; k < cpValue.size(); k++) {
              val = (String) cpValue.elementAt(k);
              if (!(isContain(val.trim(), cp.getContextPropertyValues()))) {
                v.addElement(partElements.elementAt(i));
                break;
              }
            }
          }
        }
      }
    }
    return v;
  }

  /**
   * CompairCondition = liefert alle Modellelemente welche gleich dem Wert sind
   * @param cpValue - Werte
   * @param partElements - Modellelemente
   * @param operator - logischer Operator [AND, OR, XOR, '']
   * @return Vector mit Modellelementen
   */
  public Vector equals(Vector cpValue, Vector partElements, String operator) {
    Vector v = new Vector();
    Vector cpl = new Vector();
    String val = "";
    boolean con = true;
    boolean con2 = false;

    if(operator.equals("AND")) {
      for (int i = 0; i < partElements.size(); i++) {
        ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
        cpl = esc.getContextPropertyList();
        for (int j = 0; j < cpl.size(); j++) {
          ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
          if(cpValue.size() == cp.getContextPropertyValues().size()) {
            for(int k=0; k<cpValue.size(); k++) {
              val = (String) cpValue.elementAt(k);
              if (isContain(val.trim(), cp.getContextPropertyValues())) {
                con = con && true;
              }
              else {
                con = con && false;
              }
            }
          }
          if(con) {
            v.addElement(partElements.elementAt(i));
          }
        }
      }
    }
    else {
      if(operator.equals("XOR")) {
        for (int i = 0; i < partElements.size(); i++) {
          ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
          cpl = esc.getContextPropertyList();
          for (int j = 0; j < cpl.size(); j++) {
            ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
            if(cpValue.size() == cp.getContextPropertyValues().size()) {
              for (int k = 0; k < cpValue.size(); k++) {
                val = (String) cpValue.elementAt(k);
                if (isContain(val.trim(), cp.getContextPropertyValues())) {
                  con = con && true;
                  con2 = con2 || true;
                }
                else {
                  con = con && false;
                  con2 = con2 || false;
                }
              }
            }
            if((!(con)) && (con2)) {
              v.addElement(partElements.elementAt(i));
            }
          }
        }
      }
      else {
        for (int i = 0; i < partElements.size(); i++) {
          ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
          cpl = esc.getContextPropertyList();
          for (int j = 0; j < cpl.size(); j++) {
            ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
            if (cp.getContextPropertyValues().size() == 1) {
              for (int k = 0; k < cpValue.size(); k++) {
                val = (String) cpValue.elementAt(k);
                if (isContain(val.trim(), cp.getContextPropertyValues())) {
                  v.addElement(partElements.elementAt(i));
                  break;
                }
              }
            }
          }
        }
      }
    }
    return v;
  }

  /**
   * CompairCondition Does not Equal liefert alle Modellelemente welche ungleich dem Wert sind
   * @param cpValue - Werte
   * @param partElements - Modellelemente
   * @param operator - logischer Operator [AND, OR, XOR, '']
   * @return Vector mit Modellelementen
   */
  public Vector notEquals(Vector cpValue, Vector partElements, String operator) {
    Vector v = new Vector();
    Vector cpl = new Vector();
    String val = "";
    boolean con = true;
    boolean con2 = false;

    if(operator.equals("AND")) {
      for (int i = 0; i < partElements.size(); i++) {
        ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
        cpl = esc.getContextPropertyList();
        for (int j = 0; j < cpl.size(); j++) {
          ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
          if(cpValue.size() == cp.getContextPropertyValues().size()) {
            for(int k=0; k<cpValue.size(); k++) {
              val = (String) cpValue.elementAt(k);
              if (!(isContain(val.trim(), cp.getContextPropertyValues()))) {
                con = con && true;
              }
              else {
                con = con && false;
              }
            }
          }
          if(con) {
            v.addElement(partElements.elementAt(i));
          }
        }
      }
    }
    else {
      if(operator.equals("XOR")) {
        for (int i = 0; i < partElements.size(); i++) {
          ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
          cpl = esc.getContextPropertyList();
          for (int j = 0; j < cpl.size(); j++) {
            ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
            if(cpValue.size() == cp.getContextPropertyValues().size()) {
              for (int k = 0; k < cpValue.size(); k++) {
                val = (String) cpValue.elementAt(k);
                if (!(isContain(val.trim(), cp.getContextPropertyValues()))) {
                  con = con && true;
                  con2 = con2 || true;
                }
                else {
                  con = con && false;
                  con2 = con2 || false;
                }
              }
            }
            if((!(con)) && (con2)) {
              v.addElement(partElements.elementAt(i));
            }
          }
        }
      }
      else {
        for (int i = 0; i < partElements.size(); i++) {
          ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
          cpl = esc.getContextPropertyList();
          for (int j = 0; j < cpl.size(); j++) {
            ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
            if (cp.getContextPropertyValues().size() == 1) {
              for (int k = 0; k < cpValue.size(); k++) {
                val = (String) cpValue.elementAt(k);
                if (!(isContain(val.trim(), cp.getContextPropertyValues()))) {
                  v.addElement(partElements.elementAt(i));
                  break;
                }
              }
            }
          }
        }
      }
    }
    return v;
  }


  /**
   * CompairCondition < liefert alle Modellelemente welche < dem Wert sind
   * @param cpValue - Werte
   * @param partElements - Modellelemente
   * @param operator - logischer Operator [AND, OR, '']
   * @return Vector mit Modellelementen
   */
  public Vector lessThan(int cpValue, Vector partElements) {
    Vector v = new Vector();
    Vector cpl = new Vector();

    for (int i = 0; i < partElements.size(); i++) {
      ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
      cpl = esc.getContextPropertyList();
      for (int j = 0; j < cpl.size(); j++) {
        ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
        if(cp.getContextPropertyValues().size() == 1) {
          if(cpValue > new Integer ((String) cp.getContextPropertyValues().elementAt(0)).intValue()) {
            v.addElement(partElements.elementAt(i));
          }
        }
      }
    }
    System.out.println("< " + v.toString());
    return v;
  }

  /**
   * CompairCondition > liefert alle Modellelemente welche > dem Wert sind
   * @param cpValue - Werte
   * @param partElements - Modellelemente
   * @param operator - logischer Operator [AND, OR, '']
   * @return Vector mit Modellelementen
   */
  public Vector greaterThan(int cpValue, Vector partElements) {
    Vector v = new Vector();
    Vector cpl = new Vector();

    for (int i = 0; i < partElements.size(); i++) {
      ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
      cpl = esc.getContextPropertyList();
      for (int j = 0; j < cpl.size(); j++) {
        ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
        if(cp.getContextPropertyValues().size() == 1) {
          if(cpValue < new Integer ((String) cp.getContextPropertyValues().elementAt(0)).intValue()) {
            v.addElement(partElements.elementAt(i));
          }
        }
      }
    }
    System.out.println("> " + v.toString());
    return v;
  }

  /**
   * CompairCondition <= liefert alle Modellelemente welche <= dem Wert sind
   * @param cpValue - Wert
   * @param partElements - Modellelemente
   * @return Vector mit Modellelementen
   */
  public Vector lessEquals(int cpValue, Vector partElements) {
    Vector v = new Vector();
    Vector cpl = new Vector();

    for (int i = 0; i < partElements.size(); i++) {
      ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
      cpl = esc.getContextPropertyList();
      for (int j = 0; j < cpl.size(); j++) {
        ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
        if(cp.getContextPropertyValues().size() == 1) {
          if(cpValue >= new Integer ((String) cp.getContextPropertyValues().elementAt(0)).intValue()) {
            v.addElement(partElements.elementAt(i));
          }
        }
      }
    }
    System.out.println("<= " + v.toString());
    return v;
  }

  /**
   * CompairCondition >= liefert alle Modellelemente welche >= dem Wert sind
   * @param cpValue - Wert
   * @param partElements - Modellelemente
   * @return Vector mit Modellelementen
   */
  public Vector greaterEquals(int cpValue, Vector partElements) {
    Vector v = new Vector();
    Vector cpl = new Vector();

    for (int i = 0; i < partElements.size(); i++) {
      ElementSelectionContainer esc = (ElementSelectionContainer) partElements.elementAt(i);
      cpl = esc.getContextPropertyList();
      for (int j = 0; j < cpl.size(); j++) {
        ContextPropertyContainer cp = (ContextPropertyContainer) cpl.elementAt(j);
        if(cp.getContextPropertyValues().size() == 1) {
          if(cpValue <= new Integer ((String) cp.getContextPropertyValues().elementAt(0)).intValue()) {
            v.addElement(partElements.elementAt(i));
          }
        }
      }
    }
    System.out.println(">= " + v.toString());
    return v;
  }

  /**
   * CompairCondition Intersects With liefert eine Schnittmenge von Modellelemente
   * @param cpValue - Wert
   * @param partElements - Modellelemente
   * @return Vector mit Modellelementen
   */
  public Vector intersects(Vector partElements1, Vector partElements2, String operator, String name1, String name2) {
    Vector v = new Vector();
    Vector cpl1 = new Vector();
    Vector cpl2 = new Vector();
    int valCount = 0;

    for(int i = 0; i < partElements1.size(); i++) {
      ElementSelectionContainer esc1 = (ElementSelectionContainer) partElements1.elementAt(i);
      int m = esc1.getIndexOf(name1);
      cpl1 = esc1.getContextPropertyValueList(m);
      for(int j=0; j< partElements2.size(); j++) {
        ElementSelectionContainer esc2 = (ElementSelectionContainer) partElements2.elementAt(j);
        int n = esc2.getIndexOf(name2);
        cpl2 = esc2.getContextPropertyValueList(n);
        if(operator.equals("AND")) {
          if(isEqual(cpl1,cpl2)) {
            v.addElement(partElements1.elementAt(i));
          }
        }
        if(operator.equals("OR")) {
          for(int k=0; k < cpl1.size(); k++) {
            if(isContain((String) cpl1.elementAt(k), cpl2)) {
              v.addElement(partElements1.elementAt(i));
              break;
            }
          }
        }
        if(operator.equals("ONLY")) {
          for(int k=0; k < cpl1.size(); k++) {
            if(isContain((String) cpl1.elementAt(k), cpl2)) {
              valCount++;
            }
          }
          if(valCount == 1) {
            v.addElement(partElements1.elementAt(i));
          }
        }
      }
    }
    return v;
  }

  /**
   * CompairCondition Intersects With liefert eine Schnittmenge von Modellelemente
   * @param cpValue - Wert
   * @param partElements - Modellelemente
   * @return Vector mit Modellelementen
   */
  public Vector notIntersects(Vector partElements1, Vector partElements2, String operator, String name1, String name2) {
    Vector v = new Vector();
    Vector cpl1 = new Vector();
    Vector cpl2 = new Vector();
    int valCount = 0;
    boolean isFound = false;

    for(int i = 0; i < partElements1.size(); i++) {
      ElementSelectionContainer esc1 = (ElementSelectionContainer) partElements1.elementAt(i);
      int m = esc1.getIndexOf(name1);
      cpl1 = esc1.getContextPropertyValueList(m);
      for(int j=0; j< partElements2.size(); j++) {
        ElementSelectionContainer esc2 = (ElementSelectionContainer) partElements2.elementAt(j);
        int n = esc2.getIndexOf(name2);
        cpl2 = esc2.getContextPropertyValueList(n);
        if(operator.equals("AND")) {
          if(!(isEqual(cpl1,cpl2))) {
            v.addElement(partElements1.elementAt(i));
          }
        }
        if(operator.equals("OR")) {
          for(int k=0; k < cpl1.size(); k++) {
            if(isContain((String) cpl1.elementAt(k), cpl2)) {
              isFound = isFound || true;
            }
          }
          if(!(isFound)) {
            v.addElement(partElements1.elementAt(i));
            isFound = false;
          }
        }
        if(operator.equals("ONLY")) {
          for(int k=0; k < cpl1.size(); k++) {
            if(isContain((String) cpl1.elementAt(k), cpl2)) {
              valCount++;
            }
          }
          if(valCount == 0) {
            v.addElement(partElements1.elementAt(i));
          }
        }
      }
    }
    return v;
  }


  /**
   * Vergleicht die Inhalte von zwei Vektoren
   * @param v1 - Vektor 1
   * @param v2 - Vektor 2
   * @return true wenn Inhalt v1= Inhalt v2, sonst false
   */
  public boolean isEqual(Vector v1, Vector v2) {
    boolean eq = true;

    if(v1.size() == v2.size()) {
     for(int i=0; i<v1.size(); i++) {
       if (isContain((String) v1.elementAt(i), v2)) {
         eq = eq && true;
       }
       else {
         eq = false;
         break;
       }
     }
    }
    else {
      eq = false;
    }
    return eq;
  }

  /**
   * Auswahl und Aufruf der CompaireCondition
   *
   */
  public Vector selectCondition(String cpName, Vector allElements, Vector cpValue, String vergleich, String op) throws ArithmeticException {
    Vector v = new Vector();
    Vector part = new Vector();
    Vector part2 = new Vector();
    String val = "";
    int x=0;

    part = getElementsWith(cpName, allElements);
    if(cpValue.size() == 1) {
      val = (String) cpValue.elementAt(0);
      val = val.trim();
    }
    if(vergleich.equals("CONTAINS")) {
      x=1;
    }
    if(vergleich.equals("=")) {
      x=2;
    }
    if(vergleich.equals("<")) {
      x=3;
    }
    if(vergleich.equals(">")) {
      x=4;
    }
    if(vergleich.equals(">=")) {
      x=5;
    }
    if(vergleich.equals("<=")) {
      x=6;
    }
    if(vergleich.equals("DOES NOT CONTAIN")) {
      x=7;
    }
    if(vergleich.equals("DOES NOT EQUAL")) {
      x=8;
    }
    if(vergleich.equals("INTERSECTS WITH")) {
      x=9;
    }
    if(vergleich.equals("DOES NOT INTERSECT WITH")) {
      x=10;
    }

    switch (x) {
      case 1:
        System.out.println("CONTAINS " + cpValue.toString());
        v = contains(cpValue, part, op);
        break;
      case 2:
        System.out.println("EQUALS " + cpValue.toString());
        v = equals(cpValue, part, op);
        break;
      case 3:
        if(isInt(val.trim())) {
          v = lessThan(new Integer(val).intValue(), part);
        }
        else {
          throw new ArithmeticException("CompareCondition \"" + vergleich + "\" expected number");
        }
        break;
      case 4:
        if(isInt(val.trim())) {
          v = greaterThan(new Integer(val).intValue(), part);
        }
        else {
          throw new ArithmeticException("CompareCondition \"" + vergleich + "\" expected number");
        }
        break;
      case 5:
        if(isInt(val.trim())) {
          v = greaterEquals(new Integer(val).intValue(), part);
        }
        else {
          throw new ArithmeticException("CompareCondition \"" + vergleich + "\" expected number");
        }
        break;
      case 6:
        if(isInt(val.trim())) {
          v = lessEquals(new Integer(val).intValue(), part);
        }
        else {
          throw new ArithmeticException("CompareCondition \"" + vergleich + "\" expected number");
        }
        break;
      case 7:
        System.out.println("DOES NOT CONTAIN " + cpValue.toString());
        v = notContains(cpValue, part, op);
        break;
      case 8:
        System.out.println("DOES NOT EQUAL " + cpValue.toString());
        v = notEquals(cpValue, part, op);
        break;
      case 9:
        System.out.println("INTERSECTS WITH " + val + op);
        part2 = getElementsWith(val, allElements);
        v = intersects(part, part2, op, cpName, val);
        break;
    }
    System.out.println("selectCompareCondition " + v.toString());
    return v;
  }

  public boolean isInt(String value) {
    int x=0;
    try {
      x= Integer.parseInt(value);
      return true;
    }
    catch(NumberFormatException nfe) {
      return false;
    }
  }

}