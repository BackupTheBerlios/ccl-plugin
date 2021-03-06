package org.cocons.uml.ccl;

import java.lang.reflect.*;
import java.util.*;
import org.cocons.uml.*;
import ru.novosoft.uml.foundation.core.*;
import org.cocons.uml.ccl.util.*;
import org.cocons.argo.util.ModelIterator;
import org.cocons.uml.ccl.util.Parser;
import org.cocons.uml.ccl.ccldata.*;
import org.cocons.uml.ccl.xml.CoConXMLWriter;

import ru.novosoft.uml.foundation.data_types.MBooleanExpression;

/**
 * The implementation of a Contextbased Constraint (CoCon).
 * This is the base class for the UML extension. If adding a CoCon to
 * to your model, this is the class you have to instantiate.
 *
 * @author Stefan Tang, Fadi Chabarek, Philip Schumacher
 * @version $Revision 1.1$
 */
public class MContextbasedConstraintImpl
	extends MConstraintImpl
	implements MContextbasedConstraint {

	static public String BODY_LANGUAGE = "CCLXML";

        /**
         * The type of this CoCon.
         */
        private String _coconType;

        /**
         * The scope set of this CoCon.
         */
        private Vector _scopeSet;

        /**
         * The target set of this CoCon.
         */
        private Vector _targetSet;

	/**
	 * The Vector that stores the Elements in the TargetSet, but only those
	 * that are bind indirect via a context condition.
	 */
	private Vector _targetSetIndirectElements = new Vector();

	/**
	 * The Vector that stores the Elements in the ScopeSet, but only those that
	 * are bind indirect via a context condition.
	 */
	private Vector _scopeSetIndirectElements = new Vector();

	/**
	 * This Vector contains all the direct elements that are in the TargetSet,
	 * if the TargetSet doesn't have any direct references, this Vector is null.
	 * This field is neccessary in order to distinct between the direct
	 * references of the scope and taret set that are stored together in the
	 * parent Constraint.
	 */
	private Vector _targetSetDirectElements = null;

	/**
	 * This Vector contains all the direct elements that are in the ScopeSet,
	 * if the ScopeSet doesn't have any direct references, this Vector is null.
	 * This field is neccessary in order to distinct between the direct
	 * references of the scope and taret set that are stored together in the
	 * parent Constraint.
	 */
	private Vector _scopeSetDirectElements = null;

	/**
	 * Constructor that creates a new Contextbased Constraint.
	 */
	public MContextbasedConstraintImpl() {
		System.out.println("MContextbasedConstraintImpl ctor");
		//setBody(new ru.novosoft.uml.foundation.data_types.MBooleanExpression("CCLXML", "<hallo>Hallo!</hallo>"));
	}

	/**
	 * Returns all model elements that are in the target set,
	 * regardless if they are bind directly via MConstraint or indirectly
	 * via the context condition.
	 *
	 * @return A vector containing all model elements that are in the target set,
	 *         return null if this CoCon hasn't been initialized yet.
	 */
	public Vector getTargetElements() {
          if ((_targetSetIndirectElements!=null) && (_targetSetDirectElements!=null)) {
            // return direct and indirect elements
            Vector allElements = new Vector();
            for (int i=0; i<_targetSetDirectElements.size(); i++) {
              allElements.add(_targetSetDirectElements.elementAt(i));
            }
            for (int i=0; i<_targetSetIndirectElements.size(); i++) {
              allElements.add(_targetSetIndirectElements.elementAt(i));
            }
            return allElements;
          } else if (_targetSetIndirectElements!=null) {
            //return only the indirect elements
            return _targetSetIndirectElements;
          } else if (_targetSetDirectElements!=null) {
            //return only direct elements
            return _targetSetDirectElements;
          } else {
            return null;
          }
	}

	/**
	 * Returns all model elements that are in the scope set,
	 * regardless if they are bind directly via MConstraint or indirectly
	 * via the context condition.
	 *
	 * @return A vector containing all model elements that are scoped,
	 *         return null if this CoCon hasn't been initialized yet.
	 */
	public Vector getScopedElements() {
          if ((_scopeSetIndirectElements!=null) && (_scopeSetDirectElements!=null)) {
            // return direct and indirect elements
            Vector allElements = new Vector();
            for (int i=0; i<_scopeSetDirectElements.size(); i++) {
              allElements.add(_scopeSetDirectElements.elementAt(i));
            }
            for (int i=0; i<_scopeSetIndirectElements.size(); i++) {
              allElements.add(_scopeSetIndirectElements.elementAt(i));
            }
            return allElements;
          } else if (_scopeSetIndirectElements!=null) {
            //return only the indirect elements
            return _scopeSetIndirectElements;
          } else if (_scopeSetDirectElements!=null) {
            //return only direct elements
            return _scopeSetDirectElements;
          } else {
            return null;
          }
	}

	/**
	 * Gets the type of this Contextbased Constraint.
	 *
	 * @return the CoCon type.
	 */
	public String getCoConType() {
		return _coconType;
	}

	/**
	 * Returns the scope set context condition(s).
	 *
	 * @return Vector the scope's context condition(s).
	 */
	public Vector getScopeSetContextConditions() {
		return _scopeSet;
	}

	/**
	* Returns the target set context condition(s).
	*
	* @return Vector the target context condition(s).
	*/
	public Vector getTargetSetContextConditions() {
		return _targetSet;
	}

	/**
	 * Sets the type of this Contextbased Constraint.
	 */
	public void setCoConType(String coConType) {
		_coconType = coConType;
	}

	/**
	 * Sets the context condition(s) for the scope set. Calling
         * this method with parameter null will reset the scope set.
         *
	 * @param conditions the ContextConditions, a vector containing
         *        elements of type ContextCondition
	 */
	public void setScopeSetContextConditions(Vector conditions) {
	  if (conditions==null) {
            _scopeSetIndirectElements = null;
            _scopeSet = null;

          } else {
            // all indirect associations are bound by OR
            _scopeSet = conditions;
            _scopeSetIndirectElements = new Vector();
            for (int j=0; j<conditions.size(); j++) {
              ContextCondition condition = (ContextCondition)conditions.elementAt(j);
              // and get all model elements that belong to this condition
              ModelIterator ite = new ModelIterator();
	      Vector modelElements = ite.getAllModelElements();
              for (int i = 0; i < modelElements.size(); i++) {
                if (!(modelElements.elementAt(i) instanceof MModelElement)) continue;
	        MModelElement element = (MModelElement) modelElements.elementAt(i);
                if (condition.isCompliedWith(element)) {
                  _scopeSetIndirectElements.addElement(element);
                }
              }
            }
          }
	}

	/**
	 * Sets the context condition(s) for the target set. Calling
         * this method with parameter null will reset the target set.
         *
	 * @param conditions the ContextConditions, a vector containing
         *        elements of type ContextCondition
         */
	public void setTargetSetContextConditions(Vector conditions) {
	  if (conditions==null) {
            _targetSetIndirectElements = null;
            _targetSet = null;

          } else {
            // all indirect associations are bound by OR
            _targetSet = conditions;
            _targetSetIndirectElements = new Vector();
            for (int j=0; j<conditions.size(); j++) {
              ContextCondition condition = (ContextCondition)conditions.elementAt(j);
              // and get all model elements that belong to this condition
              ModelIterator ite = new ModelIterator();
	      Vector modelElements = ite.getAllModelElements();
              for (int i = 0; i < modelElements.size(); i++) {
                if (!(modelElements.elementAt(i) instanceof MModelElement)) continue;
	        MModelElement element = (MModelElement) modelElements.elementAt(i);
                if (condition.isCompliedWith(element)) {
                  _targetSetIndirectElements.addElement(element);
                }
              }
            }
          }
	}


        /**
         * Updates the CoCons, that means the scope and target set will be
         * updated to be consistent with the current model.
         */
        public void update() {
          setScopeSetContextConditions(_scopeSet);
          setTargetSetContextConditions(_targetSet);

        }

        /**
         * Sets the direct associated elements for the target set. Calling
         * this method with parameter null will reset the direct scope set.
         *
         * @param directElements the vector that contains the direct
         *        elements for the target set. Each element is a String,
         *        the name of the direct associated element.
         */
        public void setTargetSetDirectElements(Vector directElements) {
          if (directElements==null) {
            if (_targetSetDirectElements!=null) {
              // delete the direct elements in the target set from the constraint
              for (int i=0; i<_targetSetDirectElements.size(); i++) {
                MModelElement element = (MModelElement)_targetSetDirectElements.elementAt(i);
                deleteDirectModelElementFromConstraint(element);
              }
            }
            _targetSetDirectElements = null;
            return;

          } else {
            _targetSetDirectElements = new Vector();
            ModelIterator ite = new ModelIterator();
            for (int i=0; i<directElements.size(); i++) {
              String directName = directElements.elementAt(i).toString();
              MModelElement directElement = ite.getModelElementClass(directName);
              if (directElement != null) {
		_targetSetDirectElements.addElement(directElement);
		addConstrainedElement(directElement);
              }
            }
          }
        }

        /**
         * Sets the direct associated elements for the scope set. Calling
         * this method with parameter null will reset the direct scope set.
         *
         * @param directElements the vector that contains the direct
         *        elements for the scope set. Each element is a String,
         *        the name of the direct associated element.
         */
        public void setScopeSetDirectElements(Vector directElements) {
          if (directElements==null) {
            if (_scopeSetDirectElements!=null) {
              // delete the direct elements in the scope set from the constraint
              for (int i=0; i<_scopeSetDirectElements.size(); i++) {
                MModelElement element = (MModelElement)_scopeSetDirectElements.elementAt(i);
                deleteDirectModelElementFromConstraint(element);
              }
            }
            _scopeSetDirectElements = null;
            return;

          } else {
            _scopeSetDirectElements = new Vector();
            ModelIterator ite = new ModelIterator();
            for (int i=0; i<directElements.size(); i++) {
              String directName = directElements.elementAt(i).toString();
              MModelElement directElement = ite.getModelElementClass(directName);
              if (directElement != null) {
		_scopeSetDirectElements.addElement(directElement);
		addConstrainedElement(directElement);
              }
            }
          }
        }

        /**
         * Returns the complete CCL String that defines this CoCon.
         *
         * @return the CCL String that defines this CoCon, returns null
         *         if the CoCon hasn't been initialized yet.
         */
        public String toString() {
          if ((getTargetSetCCLString()!=null)&&(getScopeSetCCLString()!=null)&&(getCoConType()!=null)) {
            return getTargetSetCCLString() + getCoConType() + getScopeSetCCLString();
          } else {
            return null;
          }
        }

        /**
         * Returns the part of the CCL String that defines the target set.
         *
         * @return the CCL String that defines the target set.
         */
        public String getTargetSetCCLString() {
          if (_targetSet==null) {
            return null;
          } else {
            return _targetSet.toString();
          }
        }

        /**
         * Returns the part of the CCL String that defines the scope set.
         *
         * @return the CCL String that defines the scope set.
         */
        public String getScopeSetCCLString() {
          if (_scopeSet==null) {
            return null;
          } else {
            return _scopeSet.toString();
          }
        }

        /**
         * Deletes a direct associated element from the parent Constraint.
         *
         * @param modelElement the model element to delete.
         */
        private void deleteDirectModelElementFromConstraint(MModelElement modelElement) {
          List list = getConstrainedElements();
          while (list.iterator().hasNext()) {
            MModelElement element = (MModelElement)list.iterator().next();
            if (element.equals(modelElement)) {
              list.remove(element);
              return;
            }
          }
        }

	/** Ensures XML-Body is in sync with modelled CoCon */
	public void syncBody()
	{
		System.out.println("MContextbasedConstraintImpl.syncBody()");

		CoCon myself = getIMClassRepresentation();

		String xmlstring =
			CoConXMLWriter.SINGLETON.singleCoConToString( myself );
		super.setBody( new MBooleanExpression(BODY_LANGUAGE, xmlstring) );
	}

	/** Returns XML representation for this CoCon's contents */
	public String getXMLRepresentation()
	{
		syncBody();
		MBooleanExpression body = super.getBody();
		if( (body == null) ||
			 (!BODY_LANGUAGE.equals(body.getLanguage())) )
			{ System.err.println("Weird CoCon-Body contents"); }

		return body.getBody();
	}

	public CoCon getIMClassRepresentation()
	{
		return Parser.MCoCon2CoCon( this );
	}

// 	public void initializeFromIMClass( CoCon cocon )
// 	{
// 		System.out.println("MContextbasedConstraintImpl.initializeFromIMClass " + cocon);
// 	}

	public static
		org.cocons.uml.ccl.ccldata.CoCon
		newSampleCoCon()
	{
		CoCon cocon = new CoCon();

		// type
		cocon.setType("UnreadableBy");


		// scope
		CoConSet scope = new CoConSet();
		scope.setId( org.cocons.uml.ccl.ccldata.types.IdType.SCOPE );
		cocon.addCoConSet(scope);

		// ein item fuer "THE warehouse":
		CoConSetItem thewarehouseitem = new CoConSetItem();
		scope.addCoConSetItem( thewarehouseitem );
		CoConSetDirectReference thewarehouse = new CoConSetDirectReference();
		thewarehouseitem.setCoConSetDirectReference( thewarehouse );
		thewarehouse.setElement("warehouse");

		// ein item fuer
		// all elements where (x < 18 and y > 15) or 'pw' contains 'eins'
		CoConSetItem x18_y15_pweins_item = new CoConSetItem();
		scope.addCoConSetItem( x18_y15_pweins_item );
		CoConSetCondition x18_y15_pweins = new CoConSetCondition();
		x18_y15_pweins_item.setCoConSetCondition( x18_y15_pweins );

		// "... all components ..."
		x18_y15_pweins.setRange("all");
		CoConSetConditionRestriction x18_y15_pweins_restr
			= new CoConSetConditionRestriction();
		x18_y15_pweins_restr.setRestriction(org.cocons.uml.ccl.ccldata.types.RestrictionType.ELEMENTS);
		x18_y15_pweins.
			addCoConSetConditionRestriction( x18_y15_pweins_restr );

		// "where ..."
		CoConSetConditionChoice x18_y15_pweins_choice = new CoConSetConditionChoice();
		x18_y15_pweins.setCoConSetConditionChoice( x18_y15_pweins_choice );

		// "... or ..."
		CoConSetConditionUnion x18_y15_pweins_union = new CoConSetConditionUnion();
		x18_y15_pweins_choice.setCoConSetConditionUnion( x18_y15_pweins_union );

		// "x<18 and y>15"
		CoConSetConditionUnionItem x18_y15_uitem =
			new CoConSetConditionUnionItem();
		x18_y15_pweins_union.addCoConSetConditionUnionItem( x18_y15_uitem );

		CoConSetConditionIntersection x18_y15_isec =
			new CoConSetConditionIntersection();
		x18_y15_uitem.setCoConSetConditionIntersection(x18_y15_isec);

		CoConSetConditionIntersectionItem x18_item =
			new CoConSetConditionIntersectionItem();
		x18_y15_isec.addCoConSetConditionIntersectionItem( x18_item );

		CoConSetConditionQuerySingleValue x18_query =
			new CoConSetConditionQuerySingleValue();
		x18_item.setCoConSetConditionQuerySingleValue( x18_query );
		x18_query.setProperty("x");
		x18_query.setSingleoperator( org.cocons.uml.ccl.ccldata.types.SingleoperatorType.LOWERTHAN );
		x18_query.setValue("18");

		CoConSetConditionIntersectionItem y15item =
			new CoConSetConditionIntersectionItem();
		x18_y15_isec.addCoConSetConditionIntersectionItem( y15item );

		CoConSetConditionQuerySingleValue y15query =
			new CoConSetConditionQuerySingleValue();
		y15item.setCoConSetConditionQuerySingleValue( y15query );
		y15query.setProperty("y");
		y15query.setSingleoperator( org.cocons.uml.ccl.ccldata.types.SingleoperatorType.GREATERTHAN );
		y15query.setValue("15");

		// "pw contains eins"
		CoConSetConditionUnionItem pweins_uitem =
			new CoConSetConditionUnionItem();
		x18_y15_pweins_union.addCoConSetConditionUnionItem( pweins_uitem );

		CoConSetConditionQuerySet pweins_query =
			new CoConSetConditionQuerySet();
		pweins_uitem.setCoConSetConditionQuerySet( pweins_query );

		pweins_query.setProperty("pw");
		pweins_query.setSetoperator( org.cocons.uml.ccl.ccldata.types.SetoperatorType.CONTAINS );
		CoConSetConditionQueryForSetValue pweins_eins_val =
			new CoConSetConditionQueryForSetValue();
		pweins_eins_val.setValue("eins");
		pweins_query.addCoConSetConditionQueryForSetValue( pweins_eins_val );
		//CoConSetConditionQuerySet pweins = new CoConSetConditionQuerySet();










		// target
		CoConSet target = new CoConSet();
		target.setId( org.cocons.uml.ccl.ccldata.types.IdType.TARGET );
		cocon.addCoConSet(target);

		// ein item fuer
		// all components where z>99
		CoConSetItem all_z99_item = new CoConSetItem();
		target.addCoConSetItem( all_z99_item );
		CoConSetCondition all_z99_cond = new CoConSetCondition();
		all_z99_item.setCoConSetCondition( all_z99_cond );

		// "... all components ..."
		all_z99_cond.setRange("all");
		CoConSetConditionRestriction all_z99_cond_r
			= new CoConSetConditionRestriction();
		all_z99_cond_r.setRestriction(org.cocons.uml.ccl.ccldata.types.RestrictionType.COMPONENTS);
		all_z99_cond.
			addCoConSetConditionRestriction( all_z99_cond_r );

		// "where z>99"
		CoConSetConditionChoice all_z99_cond_choice = new CoConSetConditionChoice();
		all_z99_cond.setCoConSetConditionChoice( all_z99_cond_choice );

		CoConSetConditionQuerySingleValue z99_query =
			new CoConSetConditionQuerySingleValue();
		all_z99_cond_choice.setCoConSetConditionQuerySingleValue( z99_query );
		z99_query.setProperty("z");
		z99_query.setSingleoperator( org.cocons.uml.ccl.ccldata.types.SingleoperatorType.GREATERTHAN );
		z99_query.setValue("99");

		// ein item fuer
		// all components where z<50
		CoConSetItem all_z50_item = new CoConSetItem();
		target.addCoConSetItem( all_z50_item );
		CoConSetCondition all_z50_cond = new CoConSetCondition();
		all_z50_item.setCoConSetCondition( all_z50_cond );

		// "... all components ..."
		all_z50_cond.setRange("all");
		CoConSetConditionRestriction all_z50_cond_r
			= new CoConSetConditionRestriction();
		all_z50_cond_r.setRestriction(org.cocons.uml.ccl.ccldata.types.RestrictionType.COMPONENTS);
		all_z50_cond.
			addCoConSetConditionRestriction( all_z50_cond_r );

		// "where z>50"
		CoConSetConditionChoice all_z50_cond_choice = new CoConSetConditionChoice();
		all_z50_cond.setCoConSetConditionChoice( all_z50_cond_choice );

		CoConSetConditionQuerySingleValue z50_query =
			new CoConSetConditionQuerySingleValue();
		all_z50_cond_choice.setCoConSetConditionQuerySingleValue( z50_query );
		z50_query.setProperty("z");
		z50_query.setSingleoperator( org.cocons.uml.ccl.ccldata.types.SingleoperatorType.LOWERTHAN );
		z50_query.setValue("50");








		// attrib
		CoConAttribute attrib = new CoConAttribute();
		attrib.setName("attribute name");
		attrib.setValue("attribute value");
		cocon.addCoConAttribute( attrib );

		return cocon;
	}
}
