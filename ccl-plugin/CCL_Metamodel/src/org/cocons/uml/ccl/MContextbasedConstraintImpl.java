package org.cocons.uml.ccl;

import java.lang.reflect.*;
import java.util.*;
import org.cocons.uml.*;
import ru.novosoft.uml.foundation.core.*;
import org.cocons.uml.ccl.ccldata.*;
import org.cocons.uml.ccl.util.*;
import org.cocons.argo.util.ModelIterator;
import org.cocons.uml.ccl.xml.CCLXMLParserImpl;

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
	 * Contains the CCL String in XML notation.
	 */
	private String _xmlCCL;

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
	 * Data Class for the XML definition of this CoCon.
	 */
	private CoConData parsedCoCon = null;

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
		if (parsedCoCon == null) {
			return null;
		} else {
			if (parsedCoCon.getTargetSet().getDirectReferences() != null) {
				// direct references
				return _targetSetDirectReferences;
			} else {
				// indirect references
				return _targetElements;
			}
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
		if (parsedCoCon == null) {
			return null;
		} else {
			if (parsedCoCon.getScopeSet().getDirectReferences() != null) {
				// direct references
				return _scopeSetDirectReferences;
			} else {
				// indirect references
				return _scopeElements;
			}
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
	 * Sets the CCL String that defines the functionality of this CoCon. The
	 * String that is given must be in XML CCL syntax.
	 *
	 * @param xmlCCL the CCL String in XML notation.
	 */
	public void setXMLCCLString(String xmlCCL) {
		_xmlCCL = xmlCCL;
		updateSets();
	}

	/**
	 * Updates the TargetSet and ScopeSet
	 */
	private void updateSets() {
		// parse into XML Data
		CCLXMLParserImpl cclXmlParser = new CCLXMLParserImpl();
		parsedCoCon = null; //cclXmlParser.
		_coconType = parsedCoCon.getType();

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

	}

	/**
	 * Returns the CCL String that defines this CoCon in XML syntax.
	 *
	 * @return the CCL String in XML notation.
	 */
	public String getXMLCCLString() {
		return _xmlCCL;
	}
    
	/**
	 * Returns the scope' context condition.
	 * Creation date: (15.01.2002 14:38:23)
	 * @return org.cocons.uml.ccl.ContextCondition the scope's context condition.
	 */
	public ContextCondition getScopeContextCondition() {
		return _scopeSet;
	} 
    
	/**
	* Returns the target context condition.
	* Creation date: (15.01.2002 14:37:44)
	* @return org.cocons.uml.ccl.ContextCondition the target context condition.
	*/
	public ContextCondition getTargetContextCondition() {
		return _targetSet;
	}
}