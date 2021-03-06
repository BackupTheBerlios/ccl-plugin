package org.cocons.uml.ccl.util;

import java.util.*;
import java.text.*;
import java.lang.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.foundation.data_types.MMultiplicity;
import org.cocons.uml.ccl.comparators.*;
import org.cocons.uml.ccl.logic_operations.*;
import org.cocons.uml.ccl.*;


/**
 * Überschrift:
 * Beschreibung:
 * Copyright:     Copyright (c) 2001
 * Organisation:
 * @author: Rolf Exner (rolf.exner@gmx.de)
 * @version 1.0
 */


public class ContextConditionFactory{
  private String cocon;
  private SyntaxcheckOfCoconsFromBNF syntaxChecker;

  public ContextConditionFactory(String s){
    cocon = s;
    syntaxChecker = new SyntaxcheckOfCoconsFromBNF(cocon);
  }

  public Vector getTargetDirectAssoziations(){
    Vector vect = new Vector();
    vect = syntaxChecker.getDirectElementOfTargetSet(cocon);
    if(null != vect) {
          if (vect.size()== 0){
        return null;
          }
          return vect;
        }
    else
    return vect;
  }

  public Vector getScopeDirectAssoziations(){
    Vector vect = new Vector();
    vect = syntaxChecker.getDirectElementOfScopeSet(cocon);
    if(null != vect) {
          if (vect.size()== 0)
           return null;
          else
            return vect;
        }
    else
    return vect;
  }

  public Vector getTargetIndirectAssoziations(){

    Vector targetSet = new Vector();
    targetSet = syntaxChecker.getIndirectElementOfTargetSet(cocon);
    if (targetSet == null) {
      return null;
    }
    else {
      if (targetSet.get(0).toString().equals("isEmpty")){
        return null;
      }
    }
    Vector theTrees = new Vector();
    for (int i = 0; i<targetSet.size(); i++){
      Vector vect = new Vector();
      vect = syntaxChecker.getFirstComparison((targetSet.get(i)).toString());
      ContextConditionImpl tree = buildTree(vect);
      theTrees.addElement(tree);
    }
    return theTrees;
    //ContextConditionImpl target = unionTrees(theTrees);
    //return target;
  }


  public Vector getScopeIndirectAssoziations(){
    Vector scopeSet = new Vector();
    scopeSet = syntaxChecker.getIndirectElementOfScopeSet(cocon);
    if (scopeSet == null) {
      return null;
    }
    else {
      if (scopeSet.get(0).toString().equals("isEmpty")){
        return null;
      }
    }

    Vector theTrees = new Vector();
    for (int i = 0; i<scopeSet.size(); i++){
      Vector vect = new Vector();
      vect = syntaxChecker.getFirstComparison((scopeSet.get(i)).toString());
      ContextConditionImpl tree = buildTree(vect);
      theTrees.addElement(tree);
    }
    return theTrees;
    //ContextConditionImpl scope = unionTrees(theTrees);
    //return scope;
  }

  public String getCoConType(){
    return syntaxChecker.getCoConsType(cocon);
  }

  public Vector getAttributes() {
        return syntaxChecker.getAttributeElements(cocon);
  }

  public boolean isValid(){
    if ( syntaxChecker != null){
        return syntaxChecker.isValid(cocon);
    }
    else {
            return false;
    }
  }

  public boolean isValidTarget(String s){
      String target = "";
      target = s + " MUST BE InaccessibleBy THE component 'a'";
      return syntaxChecker.isValid(target);
  }

  public boolean isValidScope(String s){
      String cocons = "";
      cocons = "THE component 'a' MUST BE InaccessibleBy " + s;
      return syntaxChecker.isValidScope(cocons);
  }

  protected ContextConditionImpl unionTrees(Vector vect){
        if (vect.size()==1){
      return (ContextConditionImpl) vect.get(0);
    }
    if(vect.size()> 1){
      ContextConditionImpl newRoot = new ContextConditionImpl();
      newRoot.setFirstChild((ContextConditionImpl) vect.get(0));
      vect.removeElementAt(0);
      ContextConditionImpl secondChild = new ContextConditionImpl();
      secondChild = unionTrees(vect);
      newRoot.setSecondChild(secondChild);
      LogicFactoryImpl lf = new LogicFactoryImpl();
      LogicOperation logOp;
      logOp = lf.produceLogicOperationWithType(LogicFactory.OR);
      newRoot.setLogicOperation(logOp);
      return newRoot;
    }
    else return null;
  }


  protected ContextConditionImpl buildTree(Vector vect){
      String string1 = (String) vect.get(0);
      String string2 = (String) vect.get(1);
      String logic = (String) vect.get(2);
      String rangeString = (String) vect.get(3);
      String baseClass = (String) vect.get(4);

      if (string2.equals("empty")){//in string1 is a condition like "tag = val"

            //build comparison
            ValueComparison comparison = new ValueComparison();
            ComparatorFactoryImpl comparatorFactory = new ComparatorFactoryImpl();
            int comparisonType;
            String tag;
                        String value;
            comparisonType = syntaxChecker.getComparisonType(string1);

                        tag = syntaxChecker.getTag(string1);
                        value = syntaxChecker.getValue(string1);

            comparison.setComparator(comparatorFactory.produceComparatorWithType(comparisonType));
            comparison.setTag(tag);
            comparison.setValue(value);

            ContextConditionImpl leaf = new ContextConditionImpl();
            leaf.setComparison(comparison);
                    leaf.setBaseClass(baseClass);
            leaf.setRange(rangeString);
            return leaf;

      }
      else {
          ContextConditionImpl newRoot = new ContextConditionImpl();

                  Vector vector1 = new Vector();
                  Vector vector2 = new Vector();

                  String string3 = rangeString + " " + baseClass + " WHERE " + string1;

                  vector1 = syntaxChecker.getFirstComparison(string3);
                  vector2 = syntaxChecker.getFirstComparison(string2);

          newRoot.setFirstChild(buildTree(vector1));
          newRoot.setSecondChild(buildTree(vector2));

          LogicFactoryImpl lf = new LogicFactoryImpl();
                  LogicOperation logOp;
          if (logic.equals("OR")){
               logOp = lf.produceLogicOperationWithType(LogicFactory.OR);
          }
          else {
                          logOp = lf.produceLogicOperationWithType(LogicFactory.AND);
          }
          newRoot.setLogicOperation(logOp);
          newRoot.setRange(rangeString);
          newRoot.setBaseClass(baseClass);

          return newRoot;
      }
  }
}