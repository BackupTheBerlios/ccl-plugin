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
    SyntaxcheckOfCoconsFromBNF syntaxChecker = new SyntaxcheckOfCoconsFromBNF(cocon);
  }


  public Vector getTargetDirectAssoziations(){
     return syntaxChecker.getDirectElementOfTargetSet(cocon);
  }

  public Vector getScopeDirectAssoziations(){
    return syntaxChecker.getDirectElementOfScopeSet(cocon);
  }

  public ContextConditionImpl getTargetIndirectAssoziations(){
    Vector theSimpleConditions = new Vector();
    Vector targetSet = new Vector();
    targetSet = syntaxChecker.getIndirectElementOfTargetSet(cocon);
    MMultiplicity range = new MMultiplicity( (targetSet.get(0)).toString());
    String baseClass = targetSet.get(1).toString();

    int j = 0;
    for (int i = 0; i<targetSet.size(); i++){
      if (targetSet.get(i).toString().equals("OR")){
        Vector helper = new Vector();
        for (; j<i; j++){
          helper.addElement(targetSet.get(j));
        }
        theSimpleConditions.addElement(buildSimpleCondition(helper));
        j = i+1;
      }
    }
    ContextConditionImpl target = new ContextConditionImpl();
    target = buildTreeRecursive(target,theSimpleConditions, range, baseClass);
    return target;

  }

  public ContextConditionImpl getScopeIndirectAssoziations(){
    Vector theSimpleConditions = new Vector();
    Vector scopeSet = new Vector();
    scopeSet = syntaxChecker.getIndirectElementOfScopeSet(cocon);
    MMultiplicity range = new MMultiplicity( (scopeSet.get(0)).toString());
    String baseClass = scopeSet.get(1).toString();

    int j = 0;
    for (int i = 0; i<scopeSet.size(); i++){
      if (scopeSet.get(i).toString().equals("OR")){
        Vector helper = new Vector();
        for (; j<i; j++){
          helper.addElement(scopeSet.get(j));
        }
        theSimpleConditions.addElement(buildSimpleCondition(helper));
        j = i+1;
      }
    }
    ContextConditionImpl scope = new ContextConditionImpl();
    scope = buildTreeRecursive(scope,theSimpleConditions, range, baseClass);
    return scope;

  }

  public String getCoConType(){
    return syntaxChecker.getCoConsType(cocon);
  }

  public boolean isValid(){
    if ( syntaxChecker != null){
      return syntaxChecker.isValid(cocon);
    }
    else return false;
    }

  protected ComparisonImpl buildSimpleCondition(Vector vect){
    ComparisonImpl comparison = new ComparisonImpl();
    ComparatorFactoryImpl comparatorFactory = new ComparatorFactoryImpl();
    String conditionString = "";
    for (int i = 0; i<vect.size(); i++){
      conditionString = conditionString + vect.get(i) + " " ;
    }
    int comparisonType;
    String tag;
    String value;
    //comparisonType = syntaxChecker.getComparisonType(conditionString);
    comparisonType = 0;
    tag = syntaxChecker.getContextPropertyName(conditionString);
    value = syntaxChecker.getValue(conditionString);

    comparison.setComparator(comparatorFactory.produceComparatorWithType(comparisonType));
    comparison.setTag(tag);
    comparison.setValue(value);
    return comparison;
  }



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
      else System.out.println("Function buildTreeRecursive: theComparisons.size() < 0");
      return target;
  }
}