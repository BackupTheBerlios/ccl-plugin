package org.cocons.uml.ccl.util;

import java.util.Vector;

import org.cocons.uml.ccl.BaseClasses;
import org.cocons.uml.ccl.Comparator;
import org.cocons.uml.ccl.Comparison;
import org.cocons.uml.ccl.Condition;
import org.cocons.uml.ccl.ConditionImpl;
import org.cocons.uml.ccl.ContextCondition;
import org.cocons.uml.ccl.ContextConditionImpl;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;
import org.cocons.uml.ccl.SetComparison;
import org.cocons.uml.ccl.ValueComparison;

import org.cocons.uml.ccl.comparators.ComparatorFactory;
import org.cocons.uml.ccl.comparators.ComparatorFactoryImpl;
import org.cocons.uml.ccl.comparators.Contains;
import org.cocons.uml.ccl.comparators.Equation;
import org.cocons.uml.ccl.comparators.Greater;
import org.cocons.uml.ccl.comparators.Less;

import org.cocons.uml.ccl.logic_operations.And;
import org.cocons.uml.ccl.logic_operations.LogicFactory;
import org.cocons.uml.ccl.logic_operations.LogicFactoryImpl;
import org.cocons.uml.ccl.logic_operations.Or;

import org.cocons.uml.ccl.ccldata.CoCon;
import org.cocons.uml.ccl.ccldata.CoConSet;
import org.cocons.uml.ccl.ccldata.CoConSetCondition;
import org.cocons.uml.ccl.ccldata.CoConSetConditionChoice;
import org.cocons.uml.ccl.ccldata.CoConSetConditionIntersection;
import org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem;
import org.cocons.uml.ccl.ccldata.CoConSetConditionQueryForSetValue;
import org.cocons.uml.ccl.ccldata.CoConSetConditionQueryProperty;
import org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySet;
import org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySingleValue;
import org.cocons.uml.ccl.ccldata.CoConSetConditionRestriction;
import org.cocons.uml.ccl.ccldata.CoConSetConditionUnion;
import org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem;
import org.cocons.uml.ccl.ccldata.CoConSetItem;

import org.cocons.uml.ccl.ccldata.types.IdType;
import org.cocons.uml.ccl.ccldata.types.PropertyoperatorType;
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
    target.setId(IdType.TARGET);
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
//get all contextConditions of the SCOPESET
    CoConSet scope = new CoConSet();
    scope.setId(IdType.SCOPE);
    for (int i = 0; i < mcocon.getScopeSetContextConditions().size(); i++) {
      if (mcocon.getScopeSetContextConditions().elementAt(i) instanceof ContextCondition) {
        ContextCondition cc =
          (ContextCondition)mcocon.getScopeSetContextConditions().elementAt(i);
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
        scope.addCoConSetItem(setItem);
      }
    }
    cocon.addCoConSet(target);
    cocon.addCoConSet(scope);
    return cocon;
  }

	public static MContextbasedConstraint CoCon2MCoCon (CoCon cocon)
	{
		MContextbasedConstraint mcocon = new MContextbasedConstraintImpl();
		Parser.CoCon2ExistingMCoCon( cocon, mcocon );
		return mcocon;
	}

	public static void CoCon2ExistingMCoCon( CoCon cocon,
														  MContextbasedConstraint mcocon )
	{
		System.out.println("CCC 1 " + cocon + " " +mcocon);
//set the type
    mcocon.setCoConType(cocon.getType());
		System.out.println("CCC 2");
//step through all CoConSets
    Vector target = new Vector();
    Vector scope = new Vector();
    for(int i = 0; i < cocon.getCoConSet().length; i++) {
		System.out.println("CCC 3");
      CoConSet set = cocon.getCoConSet(i);
//step through all CoConSetItems of the CoConSet
      for(int j = 0; j < set.getCoConSetItem().length; j++) {
		System.out.println("CCC 4");
        CoConSetItem setItem = set.getCoConSetItem(j);
		System.out.println("CCC 4.1");
        CoConSetCondition coconCondition = setItem.getCoConSetCondition();
		System.out.println("CCC 4.2");
        ContextConditionImpl cc = getContextCondition(coconCondition.getCoConSetConditionChoice());
		System.out.println("CCC 5");
        cc.setRange(coconCondition.getRange());
        cc.setBaseClass(getBaseClass(coconCondition.getCoConSetConditionRestriction(0).getRestriction()));
        if(set.getId().getType() == IdType.TARGET_TYPE) {
          target.addElement(cc);
        } else {
          scope.addElement(cc);
        }
      }
    }
    mcocon.setScopeSetContextConditions(scope);
    mcocon.setTargetSetContextConditions(target);
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
   * gets a RestrictionType and returns the equivalent BaseClass as String
   */
  private static String getBaseClass(RestrictionType resType) {
    if(resType.getType() == RestrictionType.BUSINESSTYPES_TYPE)
      return BaseClasses.BUSINESS_TYPE;
    if(resType.getType() == RestrictionType.COMPONENTS_TYPE)
      return BaseClasses.COMPONENT;
    if(resType.getType() == RestrictionType.COMPUTERS_TYPE)
      return BaseClasses.COMPUTER;
    if(resType.getType() == RestrictionType.CONTAINERS_TYPE)
      return BaseClasses.CONTAINER;
    if(resType.getType() == RestrictionType.ELEMENTS_TYPE)
      return BaseClasses.ELEMENT;
    if(resType.getType() == RestrictionType.INFOTYPES_TYPE)
      return BaseClasses.INFO_TYPE;
    if(resType.getType() == RestrictionType.INTERFACES_TYPE)
      return BaseClasses.INTERFACE;
    return null;
  }

  /**
   * creates a ConditionChoice from a ContextCondition by steping through the whole tree
   */
  private static CoConSetConditionChoice getConditionChoice(ContextCondition ccond) {
    ConditionImpl cc = (ConditionImpl) ccond;
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
   * creates a ContextCondition from the given ConditionChoice
   */
  private static ContextConditionImpl getContextCondition(CoConSetConditionChoice choice) {
    ContextConditionImpl cond = new ContextConditionImpl();
//if this choice contains only one singleValue/set/propertySet
    if (choice.getCoConSetConditionQuerySingleValue() != null ||
        choice.getCoConSetConditionQuerySet() != null ||
        choice.getCoConSetConditionQueryProperty() != null) {
      if (choice.getCoConSetConditionQuerySingleValue() != null) {
        cond.setComparison(calculateComparison(choice.getCoConSetConditionQuerySingleValue()));
      }
      if (choice.getCoConSetConditionQuerySet() != null) {
        cond.setComparison(calculateComparison(choice.getCoConSetConditionQuerySet()));
      }
      if (choice.getCoConSetConditionQueryProperty() != null) {
        cond.setComparison(calculateComparison(choice.getCoConSetConditionQueryProperty()));
      }
    } else {
//this choice contains a union or a intersection
      LogicFactory lf = new LogicFactoryImpl();
      if (choice.getCoConSetConditionUnion() != null) {
        cond.setLogicOperation(lf.produceLogicOperationWithType(lf.OR));
        cond.setFirstChild(getCondition(choice.getCoConSetConditionUnion().getCoConSetConditionUnionItem(0)));
        cond.setSecondChild(getCondition(choice.getCoConSetConditionUnion().getCoConSetConditionUnionItem(1)));
      }
      if (choice.getCoConSetConditionUnion() != null) {
        cond.setLogicOperation(lf.produceLogicOperationWithType(lf.AND));
        cond.setFirstChild(getCondition(choice.getCoConSetConditionIntersection().getCoConSetConditionIntersectionItem(0)));
        cond.setSecondChild(getCondition(choice.getCoConSetConditionIntersection().getCoConSetConditionIntersectionItem(1)));
      }
    }
    return cond;
  }

  /**
   * evaluates a condition if the logic operation for this node is OR
   */
  private static CoConSetConditionUnionItem calculateUnion(Condition cond) {
    ConditionImpl c = (ConditionImpl) cond;
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
  private static CoConSetConditionIntersectionItem calculateIntersection (Condition cond) {
    ConditionImpl c = (ConditionImpl) cond;
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
    singleValue.setValue(comp.getValue().toString());
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
    value.setValue(comp.getValue().toString());
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

  /**
   * creates a Comparison from a given singleValue
   */
  private static Comparison calculateComparison(CoConSetConditionQuerySingleValue singleValue) {
    ValueComparison comp = new ValueComparison();
    comp.setTag(singleValue.getProperty());
    comp.setValue(singleValue.getValue());
    ComparatorFactory compFac = new ComparatorFactoryImpl();
    if(singleValue.getSingleoperator().getType() == SingleoperatorType.EQUAL_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.EQUAL));
      comp.setNegated(false);
    }
    if(singleValue.getSingleoperator().getType() == SingleoperatorType.NOTEQUAL_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.EQUAL));
      comp.setNegated(true);
    }
    if(singleValue.getSingleoperator().getType() == SingleoperatorType.GREATERTHAN_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.GREATER));
      comp.setNegated(false);
    }
    if(singleValue.getSingleoperator().getType() == SingleoperatorType.GREATEREQUAL_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.LESS));
      comp.setNegated(true);
    }
    if(singleValue.getSingleoperator().getType() == SingleoperatorType.LOWERTHAN_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.LESS));
      comp.setNegated(false);
    }
    if(singleValue.getSingleoperator().getType() == SingleoperatorType.LOWEREQUAL_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.GREATER));
      comp.setNegated(true);
    }
    return (Comparison)comp;
  }

  /**
   * creates a Comparison from a given querySet
   */
  private static Comparison calculateComparison(CoConSetConditionQuerySet set) {
    SetComparison comp = new SetComparison();
    comp.setTag(set.getProperty());
    Vector newValue = new Vector();
    newValue.addElement(set.getCoConSetConditionQueryForSetValue(0).getValue());
    comp.setValue(newValue);
    ComparatorFactory compFac = new ComparatorFactoryImpl();
    if(set.getSetoperator().getType() == SetoperatorType.CONTAINS_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.CONTAINS));
      comp.setNegated(false);
    }
    if(set.getSetoperator().getType() == SetoperatorType.NOTCONTAINS_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.CONTAINS));
      comp.setNegated(true);
    }
    if(set.getSetoperator().getType() == SetoperatorType.EQUAL_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.EQUAL));
      comp.setNegated(false);
    }
    if(set.getSetoperator().getType() == SetoperatorType.NOTEQUAL_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.EQUAL));
      comp.setNegated(true);
    }
    return (Comparison)comp;
  }

  /**
   * creates a Comparison from a given queryProperty
   */
  private static Comparison calculateComparison(CoConSetConditionQueryProperty prop) {
    SetComparison comp = new SetComparison();
    comp.setTag(prop.getProperty());
    Vector newValue = new Vector();
    newValue.addElement(prop.getTargetproperty());
    comp.setValue(newValue);
    ComparatorFactory compFac = new ComparatorFactoryImpl();
    if(prop.getPropertyoperator().getType() == PropertyoperatorType.CONTAINS_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.CONTAINS));
      comp.setNegated(false);
    }
    if(prop.getPropertyoperator().getType() == PropertyoperatorType.NOTCONTAINS_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.CONTAINS));
      comp.setNegated(true);
    }
    if(prop.getPropertyoperator().getType() == PropertyoperatorType.EQUAL_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.EQUAL));
      comp.setNegated(false);
    }
    if(prop.getPropertyoperator().getType() == PropertyoperatorType.NOTEQUAL_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.EQUAL));
      comp.setNegated(true);
    }
    if(prop.getPropertyoperator().getType() == PropertyoperatorType.GREATERTHAN_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.GREATER));
      comp.setNegated(false);
    }
    if(prop.getPropertyoperator().getType() == PropertyoperatorType.GREATEREQUAL_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.LESS));
      comp.setNegated(true);
    }
    if(prop.getPropertyoperator().getType() == PropertyoperatorType.LOWERTHAN_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.LESS));
      comp.setNegated(false);
    }
    if(prop.getPropertyoperator().getType() == PropertyoperatorType.LOWEREQUAL_TYPE) {
      comp.setComparator(compFac.produceComparatorWithType(compFac.GREATER));
      comp.setNegated(true);
    }
    return (Comparison)comp;
  }

  /**
   * evaluates a unionItem and creates a corresponding Condition
   */
  private static Condition getCondition(CoConSetConditionUnionItem unionItem) {
    ConditionImpl cond = new ConditionImpl();
    //if this unioItem contains only one singleValue/set/propertySet
    if (unionItem.getCoConSetConditionQuerySingleValue() != null ||
        unionItem.getCoConSetConditionQuerySet() != null ||
        unionItem.getCoConSetConditionQueryProperty() != null) {
      if (unionItem.getCoConSetConditionQuerySingleValue() != null) {
        cond.setComparison(calculateComparison(unionItem.getCoConSetConditionQuerySingleValue()));
      }
      if (unionItem.getCoConSetConditionQuerySet() != null) {
        cond.setComparison(calculateComparison(unionItem.getCoConSetConditionQuerySet()));
      }
      if (unionItem.getCoConSetConditionQueryProperty() != null) {
        cond.setComparison(calculateComparison(unionItem.getCoConSetConditionQueryProperty()));
      }
    } else {
//this unionItem contains a union or a intersection
      LogicFactory lf = new LogicFactoryImpl();
      if (unionItem.getCoConSetConditionUnion() != null) {
        cond.setLogicOperation(lf.produceLogicOperationWithType(lf.OR));
        cond.setFirstChild(getCondition(unionItem.getCoConSetConditionUnion().getCoConSetConditionUnionItem(0)));
        cond.setSecondChild(getCondition(unionItem.getCoConSetConditionUnion().getCoConSetConditionUnionItem(1)));
      }
      if (unionItem.getCoConSetConditionUnion() != null) {
        cond.setLogicOperation(lf.produceLogicOperationWithType(lf.AND));
        cond.setFirstChild(getCondition(unionItem.getCoConSetConditionIntersection().getCoConSetConditionIntersectionItem(0)));
        cond.setSecondChild(getCondition(unionItem.getCoConSetConditionIntersection().getCoConSetConditionIntersectionItem(1)));
      }
    }
    return (Condition)cond;
  }

  /**
   * evaluates a intersectionItem and creates a corresponding Condition
   */
  private static Condition getCondition(CoConSetConditionIntersectionItem itersectionItem) {
    ConditionImpl cond = new ConditionImpl();
//if this intersectionItem contains only one singleValue/set/propertySet
    if (itersectionItem.getCoConSetConditionQuerySingleValue() != null ||
        itersectionItem.getCoConSetConditionQuerySet() != null ||
        itersectionItem.getCoConSetConditionQueryProperty() != null) {
      if (itersectionItem.getCoConSetConditionQuerySingleValue() != null) {
        cond.setComparison(calculateComparison(itersectionItem.getCoConSetConditionQuerySingleValue()));
      }
      if (itersectionItem.getCoConSetConditionQuerySet() != null) {
        cond.setComparison(calculateComparison(itersectionItem.getCoConSetConditionQuerySet()));
      }
      if (itersectionItem.getCoConSetConditionQueryProperty() != null) {
        cond.setComparison(calculateComparison(itersectionItem.getCoConSetConditionQueryProperty()));
      }
    } else {
//this itersectionItem contains a union or a intersection
      LogicFactory lf = new LogicFactoryImpl();
      if (itersectionItem.getCoConSetConditionUnion() != null) {
        cond.setLogicOperation(lf.produceLogicOperationWithType(lf.OR));
        cond.setFirstChild(getCondition(itersectionItem.getCoConSetConditionUnion().getCoConSetConditionUnionItem(0)));
        cond.setSecondChild(getCondition(itersectionItem.getCoConSetConditionUnion().getCoConSetConditionUnionItem(1)));
      }
      if (itersectionItem.getCoConSetConditionUnion() != null) {
        cond.setLogicOperation(lf.produceLogicOperationWithType(lf.AND));
        cond.setFirstChild(getCondition(itersectionItem.getCoConSetConditionIntersection().getCoConSetConditionIntersectionItem(0)));
        cond.setSecondChild(getCondition(itersectionItem.getCoConSetConditionIntersection().getCoConSetConditionIntersectionItem(1)));
      }
    }
    return (Condition)cond;
  }

}
