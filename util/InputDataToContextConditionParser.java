package org.cocons.uml.ccl.util;

import java.awt.*;
import java.util.*;

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
 * @author Rolf Exner & Nghia Dang
 * @version 1.0
 */

public class InputDataToContextConditionParser {

  private String targetString;
  private Vector compoString;
  private StringTokenizer st;
  private Vector conditionStrings;
  private Vector indirectAssoziations;
  private Vector directAssoziations;
  private int act;

  //TO DO: Make sure that the input is correct due to the BNF!!!

  public InputDataToContextConditionParser(String input) {
    targetString = input;
    System.out.println("Der ganze String: " + targetString);
    compoString = new Vector();
    st = new StringTokenizer(targetString);
    conditionStrings = new Vector();
    indirectAssoziations = new Vector();
    directAssoziations = new Vector();
    act = 0;

    // fill compoString with the plain text in the targetSet
    while (st.hasMoreTokens()) {
    compoString.addElement(st.nextToken());
    }

    // fill conditionStrings with the Vectors with the conditions
    for (int k = 0; k < compoString.size(); k++){
      if (compoString.get(k).toString().equals("or") || compoString.get(k).toString().equals("OR")){
        if(compoString.get(k+1).toString().equals("THE") || compoString.get(k+1).toString().equals("ALL")){
          //act = k;
          Vector helpString = new Vector();
          for (int i = act; i < k; i++){
            helpString.addElement(compoString.get(i));
          }
          conditionStrings.addElement(helpString);
          act = k+1;
        }
      }
    }
    int zähler=0;
    System.out.println("Size of COnditionStrings: " + conditionStrings.size());
    while (conditionStrings.size()> zähler){
      System.out.println(conditionStrings.get(zähler));
      zähler++;
    }
    //compute the conditions and set the Target-Set
    for (int i = 0; i < conditionStrings.size(); i++){
      Vector actVect = (Vector) conditionStrings.get(i);
      if (actVect == null)
      System.out.println("scheisse");
      System.out.println(actVect);
      //if indirect assoziation
      if (actVect.get(0).toString().equals("all") || actVect.get(0).toString().equals("ALL")){
        ContextCondition indirectConditionTree = buildConditionTree(actVect);
        indirectAssoziations.addElement(indirectConditionTree);
      }
      //if direct assoziation
      else{
        //me.setTargetSetDirectElements(actVect);
        if(actVect.get(0).toString().equals("the") || actVect.get(0).toString().equals("THE")){
          directAssoziations.addElement(actVect.get(2));
        }
      }
    }
    //Now all Assoziations lay in the Vectors directAssoziations and indirectAssoziations

  }

  public Vector getDirectAssoziations(){
    return directAssoziations;
  }

  public ContextCondition getIndirectAssoziations(){
    //if there are no indirect assoziations, the result is "null"
    if (indirectAssoziations.size()<1){
      return null;
    }
    if (indirectAssoziations.size()==1){
      return (ContextConditionImpl) indirectAssoziations.get(0);
    }
    if (indirectAssoziations.size()>1){
      ContextConditionImpl target = (ContextConditionImpl) indirectAssoziations.get(0);
      indirectAssoziations.removeElementAt(0);
      target = this.concatenateContextCondition (target, indirectAssoziations);
      return target;
    }
    return null;
  }

  //build a ContextCondition Tree out of a description like:
  //ALL components WHERE tag1=val1 OR tag2=val2 OR tag3=val3 ...
  protected ContextCondition buildConditionTree(Vector compoString){

    ContextConditionImpl target = new ContextConditionImpl();
    ComparatorFactoryImpl comparatorFactory = new ComparatorFactoryImpl();
    Vector theComparisons = new Vector();

    MMultiplicity hallo = new MMultiplicity("ALL");
    System.out.println(hallo);


    MMultiplicity range = new MMultiplicity( (compoString.get(0)).toString());
    System.out.println(range.toString());
    String baseClass = (compoString.get(1)).toString();
    int i = 3;
    for (int l = 3; (compoString.get(l)).toString().equals("OR")|| l < compoString.size(); l++){
      Vector firstVect = new Vector();
      for(; i < l; i++){
        firstVect.addElement(compoString.get(i));
        System.out.println(compoString.get(i));
      }
      Comparison comparison = simpleComparison(firstVect);
      theComparisons.addElement(comparison);
      i = l + 1;
    }
    target = buildTreeRecursive(target, theComparisons, range, baseClass);
    return target;
  }

  //helps the method buildConditionTree to compute a ContextConditionTree
  protected ContextConditionImpl buildTreeRecursive (ContextConditionImpl target, Vector theComparisons, MMultiplicity range, String baseClass){

      LogicFactoryImpl lf = new LogicFactoryImpl();
      LogicOperation logOp = lf.produceLogicOperationWithType(LogicFactory.OR);

      if(theComparisons.size()>1){
        ContextConditionImpl firstChild = new ContextConditionImpl();
        firstChild.setRange(range);
        firstChild.setBaseClass(baseClass);
        firstChild.setComparison(((ComparisonImpl)theComparisons.get(0)));
        theComparisons.removeElementAt(0);
        target.setFirstChild(firstChild);
        ContextConditionImpl secondChild = new ContextConditionImpl();
        secondChild = buildTreeRecursive (secondChild, theComparisons, range, baseClass);
        target.setSecondChild(secondChild);
      }
      if(theComparisons.size()==1){
        target.setRange(range);
        target.setBaseClass(baseClass);
        target.setComparison(((ComparisonImpl)theComparisons.get(0)));
        return target;
      }
      if(theComparisons.size()==0){
        return target;
        }

      else {
        System.out.println("Function buildTreeRecursive: theComparisons.size() < 0");
        return null;

      }

   }

  //builds a ContextConditionTree out of several ContextConditionTrees
  //the original description was like the following:
  //ALL type1 WHERE tag1=val1 OR tag2=val2 OR tag3=val3 ...
  //OR
  //ALL type2 WHERE tag1=val1 OR tag2=val2 OR tag3=val3 ...
  //OR....
  protected ContextConditionImpl concatenateContextCondition(ContextConditionImpl target, Vector vect){
    if (vect.size()>0){
      ContextConditionImpl newRoot = new ContextConditionImpl();
      newRoot.setFirstChild(target);
      newRoot.setSecondChild(((ContextConditionImpl)vect.get(0)));
      vect.removeElementAt(0);
      return concatenateContextCondition(newRoot, vect);
    }
    else return target;
  }

  //Vector vect has the form: tag comparator value
  protected  Comparison simpleComparison(Vector vect){
    ComparisonImpl comparison = new ComparisonImpl();
    ComparatorFactoryImpl comparatorFactory = new ComparatorFactoryImpl();
    String condition = "";
    String value = "";
    for (int i = 0; i < vect.size(); i++) {
      if (((vect.get(i)).toString()).equals("=") ||((vect.get(i)).toString()).equals("EQUALS")) {
        comparison.setComparator(comparatorFactory.produceComparatorWithType(ComparatorFactory.EQUAL));
        for(int j=0; j < i; j++){
          condition = condition + compoString.get(j) + " ";
        }
        for(int h = i+1; h < vect.size(); h++){
           value =value + compoString.get(h) + " ";
        }
      }
    }
    comparison.setTag(condition);
    comparison.setValue(value);
    return comparison;
  }
}

