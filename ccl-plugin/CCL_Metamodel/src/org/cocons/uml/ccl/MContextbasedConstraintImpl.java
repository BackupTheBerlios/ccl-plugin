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
	 * Sets the context condition for the scope set. Calling
         * this method with parameter null will reset the scope set.
         *
	 * @param condition the ContextCondition
	 */
	public void setScopeSetContextCondition(ContextCondition condition) {
	  if (condition==null) {
            _scopeSetIndirectElements = null;
            _scopeSet = null;

          } else {
            _scopeSet = condition;
            // and get all model elements that belong to this condition
            ModelIterator ite = new ModelIterator();
	    Vector modelElements = ite.getAllModelElements();
            for (int i = 0; i < modelElements.size(); i++) {
	      MModelElement element = (MModelElement) modelElements.elementAt(i);
              if (_scopeSet.isCompliedWith(element)) {
                _scopeSetIndirectElements.addElement(element);
              }
            }
          }
	}

	/**
	 * Sets the context condition for the target set. Calling
         * this method with parameter null will reset the target set.
	 *
	 * @param condition the ContextCondition
         */
	public void setTargetSetContextCondition(ContextCondition condition) {
	  if (condition==null) {
            _targetSetIndirectElements = null;
            _targetSet = null;

          } else {
            _targetSet = condition;
            // and get all model elements that belong to this condition
            ModelIterator ite = new ModelIterator();
	    Vector modelElements = ite.getAllModelElements();
            for (int i = 0; i < modelElements.size(); i++) {
	      MModelElement element = (MModelElement) modelElements.elementAt(i);
              if (_targetSet.isCompliedWith(element)) {
                _targetSetIndirectElements.addElement(element);
              }
            }
          }
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
}