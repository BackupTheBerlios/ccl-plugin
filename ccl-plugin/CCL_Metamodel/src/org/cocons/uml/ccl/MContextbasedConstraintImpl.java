package org.cocons.uml.ccl;

import java.lang.reflect.*;
import java.util.*;
import org.cocons.uml.*;
import ru.novosoft.uml.foundation.core.*;
import org.cocons.uml.ccl.util.*;
import org.cocons.argo.util.ModelIterator;

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


        /**
         * The type of this CoCon.
         */
        private String _coconType;

        /**
         * The scope set of this CoCon.
         */
        private ContextCondition _scopeSet;

        /**
         * The target set of this CoCon.
         */
        private ContextCondition _targetSet;

	/**
	 * The Vector that stores the Elements in the TargetSet, but only those
	 * that are bind indirect via a context condition.
	 */
	private Vector _targetElements = new Vector();

	/**
	 * The Vector that stores the Elements in the ScopeSet, but only those that
	 * are bind indirect via a context condition.
	 */
	private Vector _scopeElements = new Vector();

	/**
	 * This Vector contains all the direct elements that are in the TargetSet,
	 * if the TargetSet doesn't have any direct references, this Vector is null.
	 * This field is neccessary in order to distinct between the direct
	 * references of the scope and taret set that are stored together in the
	 * parent Constraint.
	 */
	private Vector _targetSetDirectReferences = null;

	/**
	 * This Vector contains all the direct elements that are in the ScopeSet,
	 * if the ScopeSet doesn't have any direct references, this Vector is null.
	 * This field is neccessary in order to distinct between the direct
	 * references of the scope and taret set that are stored together in the
	 * parent Constraint.
	 */
	private Vector _scopeSetDirectReferences = null;

	/**
	 * Constructor that creates a new Contextbased Constraint.
	 */
	public MContextbasedConstraintImpl() {
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
          return null;
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
          return null;
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
	 * Updates the TargetSet and ScopeSet
	 */
	private void updateSets() {
          /*      //_coconType = _xmlCCL.getType();

		ModelIterator ite = new ModelIterator();
		Vector modelElements = ite.getAllModelElements();

		// parse into Syntax tree
		XMLDataToContextConditionParser parser = new XMLDataToContextConditionParserImpl();

		// evaluate TargetSet
		if (parsedCoCon.getTargetSet().getDirectReferences() != null) {
			// direct references
			_targetSetDirectReferences = new Vector();
			Collection directReferences = parsedCoCon.getTargetSet().getDirectReferences();
			while (directReferences.iterator().hasNext()) {
				String directName = directReferences.iterator().next().toString();
				MModelElement directElement = ite.getModelElementClass(directName);
				if (directElement != null) {
					_targetSetDirectReferences.addElement(directElement);
					addConstrainedElement(directElement);
				}
			}
		} else {
			// indirect references
			_targetSetDirectReferences = null;
			_targetSet = parser.generateContextCondition(parsedCoCon.getTargetSet());
			for (int i = 0; i < modelElements.size(); i++) {
				MModelElement element = (MModelElement) modelElements.elementAt(i);
				if (_targetSet.isCompliedWith(element)) {
					_targetElements.addElement(element);
				}
			}
		}

		// evaluate ScopeSet
		if (parsedCoCon.getScopeSet().getDirectReferences() != null) {
			// direct references
			_scopeSetDirectReferences = new Vector();
			Collection directReferences = parsedCoCon.getScopeSet().getDirectReferences();
			while (directReferences.iterator().hasNext()) {
				String directName = directReferences.iterator().next().toString();
				MModelElement directElement = ite.getModelElementClass(directName);
				if (directElement != null) {
					_scopeSetDirectReferences.addElement(directElement);
					addConstrainedElement(directElement);
				}
			}
		} else {
			// indirect references
			_scopeSetDirectReferences = null;
			_scopeSet = parser.generateContextCondition(parsedCoCon.getScopeSet());
			for (int i = 0; i < modelElements.size(); i++) {
				MModelElement element = (MModelElement) modelElements.elementAt(i);
				if (_scopeSet.isCompliedWith(element)) {
					_scopeElements.addElement(element);
				}
			}
		}
          */
	}



	/**
	 * Returns the scope set context condition.
	 *
	 * @return ContextCondition the scope's context condition.
	 */
	public ContextCondition getScopeSetContextCondition() {
		return _scopeSet;
	}

	/**
	* Returns the target set context condition.
	*
	* @return ContextCondition the target context condition.
	*/
	public ContextCondition getTargetSetContextCondition() {
		return _targetSet;
	}

	/**
	 * Sets the type of this Contextbased Constraint.
	 */
	public void setCoConType(String coConType) {
		_coconType = coConType;
	}

	/**
	 * Sets the context condition for the scope set.
         *
	 * @param condition the ContextCondition
	 */
	public void setScopeSetContextCondition(ContextCondition condition) {
		_scopeSet = condition;
	}

	/**
	 * Sets the context condition for the target set.
	 *
	 * @param condition the ContextCondition
         */
	public void setTargetSetContextCondition(ContextCondition condition) {
		_targetSet = condition;
	}

        /**
         * Sets the direct associated elements for the target set.
         *
         * @param directElements the vector that contains the direct
         *        elements for the target set. Each element is a String,
         *        the name of the direct associated element.
         */
        public void setTargetSetDirectElements(Vector directElements) {

        }

        /**
         * Sets the direct associated elements for the scope set.
         *
         * @param directElements the vector that contains the direct
         *        elements for the scope set. Each element is a String,
         *        the name of the direct associated element.
         */
        public void setScopeSetDirectElements(Vector directElements) {
        }

        /**
         * Returns the complete CCL String that defines this CoCon.
         *
         * @return the CCL String that defines this CoCon, returns null
         *         if the CoCon hasn't been initialized yet.
         */
        public String toString() {
          return null;
        }

        /**
         * Returns the part of the CCL String that defines the target set.
         *
         * @return the CCL String that defines the target set.
         */
        public String getTargetSetCCLString() {
          return null;
        }

        /**
         * Returns the part of the CCL String that defines the scope set.
         *
         * @return the CCL String that defines the scope set.
         */
        public String getScopeSetCCLString() {
          return null;
        }
}