package org.cocons.uml.ccl.util;

import org.cocons.uml.ccl.BaseClasses;
import org.cocons.uml.ccl.Comparator;
import org.cocons.uml.ccl.Comparison;
import org.cocons.uml.ccl.Condition;
import org.cocons.uml.ccl.ContextCondition;
import org.cocons.uml.ccl.ContextConditionImpl;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;

import org.cocons.uml.ccl.comparators.Contains;
import org.cocons.uml.ccl.comparators.Equation;
import org.cocons.uml.ccl.comparators.Greater;
import org.cocons.uml.ccl.comparators.Less;

import org.cocons.uml.ccl.logic_operations.And;
import org.cocons.uml.ccl.logic_operations.Or;

import org.cocons.uml.ccl.ccldata.CoCon;
import org.cocons.uml.ccl.ccldata.CoConSet;
import org.cocons.uml.ccl.ccldata.CoConSetCondition;
import org.cocons.uml.ccl.ccldata.CoConSetConditionChoice;
import org.cocons.uml.ccl.ccldata.CoConSetConditionIntersection;
import org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem;
import org.cocons.uml.ccl.ccldata.CoConSetConditionQueryForSetValue;
import org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySet;
import org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySingleValue;
import org.cocons.uml.ccl.ccldata.CoConSetConditionRestriction;
import org.cocons.uml.ccl.ccldata.CoConSetConditionUnion;
import org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem;
import org.cocons.uml.ccl.ccldata.CoConSetItem;

import org.cocons.uml.ccl.ccldata.types.RestrictionType;
import org.cocons.uml.ccl.ccldata.types.SetoperatorType;
import org.cocons.uml.ccl.ccldata.types.SingleoperatorType;

/**
 * Title: Parser for ContextConditions
 * Description: coming soon
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author: Fadi Chabarek, Philipp Schumacher, Stefan Tang
 * @version 1.0
 */

public class Parser {

  public static CoCon MCoCon2CoCon (MContextbasedConstraint mcocon) {
    CoCon cocon = new CoCon();
//set the type
    cocon.setType(mcocon.getCoConType());
//get all contextConditions of the TARGETSET
    CoConSet target = new CoConSet();
    for (int i = 0; i < mcocon.getTargetSetContextConditions().size(); i++) {
      if (mcocon.getTargetSetContextConditions().elementAt(i) instanceof ContextCondition) {
        ContextCondition cc =
          (ContextCondition)mcocon.getTargetSetContextConditions().elementAt(i);
        CoConSetCondition setCondition = new CoConSetCondition();
//range
        setCondition.setRange(cc.getRange());
//baseClass -- restriction
        setCondition.addCoConSetConditionRestriction(getRestriction(cc.getBaseClass()));
//fill in the conditions
        CoConSetConditionChoice setChoice = getConditionChoice(cc);
        setCondition.setCoConSetConditionChoice(setChoice);
        CoConSetItem setItem = new CoConSetItem();
        setItem.setCoConSetCondition(setCondition);
        target.addCoConSetItem(setItem);
      }
    }

    return cocon;
  }

  public static MContextbasedConstraint CoCon2MCoCon (CoCon cocon) {
    MContextbasedConstraint mcocon = new MContextbasedConstraintImpl();

    return mcocon;
  }

  /**
   * gets a baseClass and returns the same as restriction
   */
  private static CoConSetConditionRestriction getRestriction(String baseClass) {
    CoConSetConditionRestriction setRestriction = new CoConSetConditionRestriction();
    if(baseClass.equals(BaseClasses.BUSINESS_TYPE)) {
      setRestriction.setRestriction(RestrictionType.BUSINESSTYPES);
    }
    if(baseClass.equals(BaseClasses.COMPONENT)) {
      setRestriction.setRestriction(RestrictionType.COMPONENTS);
    }
    if(baseClass.equals(BaseClasses.COMPUTER)) {
      setRestriction.setRestriction(RestrictionType.COMPUTERS);
    }
    if(baseClass.equals(BaseClasses.CONTAINER)) {
      setRestriction.setRestriction(RestrictionType.CONTAINERS);
    }
    if(baseClass.equals(BaseClasses.ELEMENT)) {
      setRestriction.setRestriction(RestrictionType.ELEMENTS);
    }
    if(baseClass.equals(BaseClasses.INFO_TYPE)) {
      setRestriction.setRestriction(RestrictionType.INFOTYPES);
    }
    if(baseClass.equals(BaseClasses.INTERFACE)) {
      setRestriction.setRestriction(RestrictionType.INTERFACES);
    }
    return setRestriction;
  }

  /**
   * creates a ConditionChoice from a ContextCondition by steping through the whole tree
   */
  private static CoConSetConditionChoice getConditionChoice(ContextCondition cc) {
    CoConSetConditionChoice choice = new CoConSetConditionChoice();
// if the tree is only one leaf
    if(cc.isLeaf()) {
      Comparison comp = cc.getComparison();
      Comparator comparator = comp.getComparator();
      if (comparator instanceof Greater || comparator instanceof Less) {
        choice.setCoConSetConditionQuerySingleValue(toQuerySingleValue(comp));
      }
      if (comparator instanceof Contains || comparator instanceof Equation) {
        choice.setCoConSetConditionQuerySet(toQuerySet(comp));
      }
    } else {
// if the tree is more than one leaf
      if(cc.getLogicOperation() instanceof And) {
        CoConSetConditionIntersection isec = new CoConSetConditionIntersection();
        isec.addCoConSetConditionIntersectionItem(calculateIntersection(cc.getFirstChild()));
        isec.addCoConSetConditionIntersectionItem(calculateIntersection(cc.getSecondChild()));
        choice.setCoConSetConditionIntersection(isec);
      }
      if(cc.getLogicOperation() instanceof Or) {
        CoConSetConditionUnion union = new CoConSetConditionUnion();
        union.addCoConSetConditionUnionItem(calculateUnion(cc.getFirstChild()));
        union.addCoConSetConditionUnionItem(calculateUnion(cc.getSecondChild()));
        choice.setCoConSetConditionUnion(union);
      }
    }
    return choice;
  }

  /**
   * evaluates a condition if the logic operation for this node is OR
   */
  private static CoConSetConditionUnionItem calculateUnion(Condition c) {
    CoConSetConditionUnionItem unionItem = new CoConSetConditionUnionItem();
//if this node/conditon is a leaf
    if(c.isLeaf()) {
      Comparison comp = c.getComparison();
      Comparator comparator = comp.getComparator();
      if (comparator instanceof Greater || comparator instanceof Less) {
        unionItem.setCoConSetConditionQuerySingleValue(toQuerySingleValue(comp));
      }
      if (comparator instanceof Contains || comparator instanceof Equation) {
        unionItem.setCoConSetConditionQuerySet(toQuerySet(comp));
      }
    } else {
//if this node/condition is a tree (not a leaf)
      if (c.getLogicOperation() instanceof And) {
        CoConSetConditionIntersection isec = new CoConSetConditionIntersection();
        isec.addCoConSetConditionIntersectionItem(calculateIntersection(c.getFirstChild()));
        isec.addCoConSetConditionIntersectionItem(calculateIntersection(c.getSecondChild()));
        unionItem.setCoConSetConditionIntersection(isec);
      }
      if(c.getLogicOperation() instanceof Or) {
        CoConSetConditionUnion union = new CoConSetConditionUnion();
        union.addCoConSetConditionUnionItem(calculateUnion(c.getFirstChild()));
        union.addCoConSetConditionUnionItem(calculateUnion(c.getSecondChild()));
        unionItem.setCoConSetConditionUnion(union);
      }
    }
    return unionItem;
  }

  /**
   * evaluates a condition if the logic operation for this node is AND
   */
  private static CoConSetConditionIntersectionItem calculateIntersection (Condition c) {
    CoConSetConditionIntersectionItem intersectionItem = new CoConSetConditionIntersectionItem();
//if this node/conditon is a leaf
    if(c.isLeaf()) {
      Comparison comp = c.getComparison();
      Comparator comparator = comp.getComparator();
      if (comparator instanceof Greater || comparator instanceof Less) {
        intersectionItem.setCoConSetConditionQuerySingleValue(toQuerySingleValue(comp));
      }
      if (comparator instanceof Contains || comparator instanceof Equation) {
        intersectionItem.setCoConSetConditionQuerySet(toQuerySet(comp));
      }
    } else {
//if this node/condition is a tree (not a leaf)
      if (c.getLogicOperation() instanceof And) {
        CoConSetConditionIntersection isec = new CoConSetConditionIntersection();
        isec.addCoConSetConditionIntersectionItem(calculateIntersection(c.getFirstChild()));
        isec.addCoConSetConditionIntersectionItem(calculateIntersection(c.getSecondChild()));
        intersectionItem.setCoConSetConditionIntersection(isec);
      }
      if(c.getLogicOperation() instanceof Or) {
        CoConSetConditionUnion union = new CoConSetConditionUnion();
        union.addCoConSetConditionUnionItem(calculateUnion(c.getFirstChild()));
        union.addCoConSetConditionUnionItem(calculateUnion(c.getSecondChild()));
        intersectionItem.setCoConSetConditionUnion(union);
      }
    }
    return intersectionItem;
  }

  /**
   * gets a comparison and evalulates the corresponding querySingleValue
   */
  private static CoConSetConditionQuerySingleValue toQuerySingleValue(Comparison comp) {
    CoConSetConditionQuerySingleValue singleValue = new CoConSetConditionQuerySingleValue();
    singleValue.setProperty(comp.getTag());
    singleValue.setValue(comp.getValue());
    if (comp.getComparator() instanceof Greater) {
      if (comp.isNegated()) {
        singleValue.setSingleoperator(SingleoperatorType.LOWEREQUAL);
      } else {
        singleValue.setSingleoperator(SingleoperatorType.GREATERTHAN);
      }
    }
    if (comp.getComparator() instanceof Less) {
      if (comp.isNegated()) {
        singleValue.setSingleoperator(SingleoperatorType.GREATEREQUAL);
      } else {
        singleValue.setSingleoperator(SingleoperatorType.LOWERTHAN);
      }
    }
    return singleValue;
  }

  /**
   * gets a comparison and evalulates the corresponding QuerySet
   */
  private static CoConSetConditionQuerySet toQuerySet(Comparison comp) {
    CoConSetConditionQuerySet querySet = new CoConSetConditionQuerySet();
    querySet.setProperty(comp.getTag());
    CoConSetConditionQueryForSetValue value = new CoConSetConditionQueryForSetValue();
    value.setValue(comp.getValue());
    querySet.addCoConSetConditionQueryForSetValue(value);
    if(comp.getComparator() instanceof Contains) {
      if (comp.isNegated()) {
        querySet.setSetoperator(SetoperatorType.NOTCONTAINS);
      }else {
        querySet.setSetoperator(SetoperatorType.CONTAINS);
      }
    }
    if(comp.getComparator() instanceof Equation) {
      if (comp.isNegated()) {
        querySet.setSetoperator(SetoperatorType.NOTEQUAL);
      }else {
        querySet.setSetoperator(SetoperatorType.EQUAL);
      }
    }
    return querySet;
  }

}