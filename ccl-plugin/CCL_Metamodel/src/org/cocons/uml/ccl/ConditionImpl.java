package org.cocons.uml.ccl;

import org.cocons.uml.ccl.context_property1_3.MContextPropertyValue;

import java.util.Vector;

import ru.novosoft.uml.foundation.core.MModelElement;

/**
* A conditional tree node.
* Creation date: (21.12.2001 20:39:49)
* @author: Fadi Chabarek, Stefan Tang, Philipp Schumacher.
*/
public class ConditionImpl implements Condition {

	/**
	 * The comparison this condition.
	 */
	private Comparison _comparison;

	/**
	* The first coditional child of this condition.
	*/
	private Condition _firstChild = null;

	/**
	* Shows if this condition is marked.
	* Used to validate that this tree has no circles.
	*/
	private boolean _isMarked;

	/**
	* The logic operation of this condition.
	*/
	private LogicOperation _logicOperation;

	/**
	* The coditional parent of this condition.
	*/
	private Condition _parent;

	/**
	* The second coditional child of this condition.
	*/
	private Condition _secondChild = null;

	/**
	 * Constructs a ConditionImpl.
	 */
	public ConditionImpl() {

		setComparison(null);
		setFirstChild(null);
		setSecondChild(null);
		setLogicOperation(null);
		setParent(null);
		_isMarked = false;

	}

	/**
	 * Constructs this condition as an conditional leaf with a comparison.
	 * Creation date: (10.02.2002 13:31:38)
	 * @param comp org.cocons.uml.ccl.Comparison a comparison.
	 */
	public ConditionImpl(Comparison comp) {
		this();
		this.setComparison(comp);
	}
    
	/**
	 * Constructs this Condition as a node. A conditional node consists of an logic operation
	 * and two conditonal childs.
	 * Creation date: (10.02.2002 13:34:40)
	 * @param firstChild Condition the first child to be set for this condition.
	 * @param lo LogicOperation the logic operation to be set for this condition.
	 * @param secondChild Condition the second child to be set for this condition.
	 */
	public ConditionImpl(Condition firstChild, LogicOperation lo, Condition secondChild) {
		this();
		this.setFirstChild(firstChild);
		this.setLogicOperation(lo);
		this.setSecondChild(secondChild);
	}

	/**
	 * Checks if this condition is complied with a given model element.
	 * Creation date: (21.12.2001 20:39:49)
	 * @return boolean if the condtion is complied.
	 */
	public boolean isCompliedWith(MModelElement modelElement) {

		boolean comply = false;

		try {
			if (this.isLeaf()) {
				Object[] taggedValues = modelElement.getTaggedValues().toArray();
				for (int i = 0; i < taggedValues.length; i++) {
					if (taggedValues[i] instanceof MContextPropertyValue) {
						// now we have one of our yellow pinups.
						// Lets see if it's in our comparison!?!
						comply = this.getComparison().covers((MContextPropertyValue) taggedValues[i]);

					}
				}

			} else {
				// Step recursivly down the conditionial tree relating the children with our logical operation.
				comply = 
					this.getLogicOperation().apply(
						getFirstChild().isCompliedWith(modelElement), 
						getSecondChild().isCompliedWith(modelElement)); 

			}
		} catch (NullPointerException npe) {
			// if that's the case the model element or this tree isn't valid
			return false;
		}

		return comply;
	}

	/**
	 * Returns the children of the reciever as an Enumeration.
	 */
	public java.util.Enumeration children() {
		Vector children = new Vector();
		children.addElement(this.getFirstChild());
		children.addElement(this.getSecondChild());

		return children.elements();
	}

	/**
	 * Returns true if the receiver allows children.
	 */
	public boolean getAllowsChildren() {
		return isLeaf();
	}

	/**
	 * Returns the comparison the condition obtains.
	 * Creation date: (21.12.2001 20:39:49)
	 * @return org.cocons.uml.ccl.Comperator .
	 */
	public Comparison getComparison() {
		return _comparison;
	}

	/**
	 * Returns the child <code>TreeNode</code> at index
	 * <code>childIndex</code>.
	 */
	public javax.swing.tree.TreeNode getChildAt(int childIndex) {

		Condition child = null;

		switch (childIndex) {
			case 1 :
				{
					child = this.getFirstChild();
				}
			case 2 :
				{
					child = this.getSecondChild();
				}
		}

		return child;
	}

	/**
	 * Returns the number of children <code>TreeNode</code>s the receiver
	 * contains.
	 */
	public int getChildCount() {

		int childCount = 2;
		if (this.isLeaf()) {
			childCount = 0;
		}
		return childCount;
	}

	/**
	 * Returns the first child of this condition or node respectivly.
	 * Creation date: (21.12.2001 20:39:49)
	 * @return org.cocons.uml.ccl.Condition the first child.
	 */
	public Condition getFirstChild() {
		return _firstChild;
	}

	/**
		 * Returns the index of <code>node</code> in the receivers children.
		 * If the receiver does not contain <code>node</code>, -1 will be
		 * returned.
		 */
	public int getIndex(javax.swing.tree.TreeNode node) {
		int index = -1;

		if (node == this.getFirstChild()) {
			index = 1;
		} else
			if (node == this.getSecondChild()) {
				index = 2;
			}

		return index;
	}

	/**
	* Returns the logic operation relating the children of this condition (node)
	* and null if this condition is a leaf.
	* Creation date: (21.12.2001 20:39:49)
	* @return org.cocons.uml.ccl.LogicOperation the logic operation.
	*/
	public LogicOperation getLogicOperation() {
		return _logicOperation;
	}

	/**
	 * Returns the parent <code>TreeNode</code> of the receiver.
	 */
	public javax.swing.tree.TreeNode getParent() {
		return _parent;
	}

	/**
	* Returns the second child of this condition or node respectivly.
	* Creation date: (21.12.2001 20:39:49)
	* @return org.cocons.uml.ccl.Condition the second child.
	*/
	public Condition getSecondChild() {
		return _secondChild;
	}

	/**
	 * Returns true if the receiver is a leaf.
	 */
	public boolean isLeaf() {
		return this.getFirstChild() == null && this.getSecondChild() == null;
	}

	/**
		 * Checks recursivly if this conditional tree is valid. A valid part (condition)
		 * must have a comparison xor two childs and must be a tree (i.e. has no circles).
		 * Creation date: (23.12.2001 11:43:56)
		 * @return boolean if every tree node is valid.
		 */
	public synchronized boolean isValid() {

		boolean valid = false;

		try {

			// if this node has been visited before, a circle must exist.
			if (this._isMarked) {
				// so we collect the mark and return false.
				this._isMarked = false;
				return false;
			} else {
				//recursivly down -> mark is set
				this._isMarked = true;
			}

			boolean ex1stChild = this.getFirstChild() != null;
			boolean ex2ndChild = this.getSecondChild() != null;
			boolean exComparison = this.getComparison() != null;

			if (ex1stChild && ex2ndChild && !exComparison) {
				// if condition is a valid node.
				valid = this.getFirstChild().isValid() && this.getSecondChild().isValid();

			} else
				if (!ex1stChild && !ex2ndChild && exComparison) {
					//if condition is a valid leaf.
					valid = true;

				} else {
					valid = false;
				}

			// recursivly up, we don't need the mark anymore.
			this._isMarked = false;

		} catch (NullPointerException npe) {
			// if that's the case, the tree can't be valid ;)
			return false;
		}

		return valid;
	}

	/**
	 * Sets the conditional comparison. See further information at the isValid()-Method
	 * to see what is to do to make afterwards this condtion a valid condition.
	 * Creation date: (21.12.2001 21:01:44)
	 * @param newComparison org.cocons.uml.ccl.Comparison the conditional comparison.
	 */
	public void setComparison(Comparison newComparison) {
		_comparison = newComparison;
	}

	/**
	 * Sets the first conditional child. See further information at the isValid()-Method
	 * to see what is to do to make afterwards this condtion a valid condition.
	 * Creation date: (21.12.2001 20:43:35)
	 * @param newFirstChild org.cocons.uml.ccl.Condition the child condition.
	 */
	public void setFirstChild(Condition newFirstChild) {

		_firstChild = newFirstChild;

	}

	/**
	 * Sets the logic operation of this condition.
	 * Creation date: (21.12.2001 21:35:24)
	 * @param newLogicOperation org.cocons.uml.ccl.LogicOperation the logic operation.
	 */
	public void setLogicOperation(LogicOperation newLogicOperation) {
		_logicOperation = newLogicOperation;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (21.12.2001 21:29:07)
	 * @param newParent org.cocons.uml.ccl.Condition
	 */
	public void setParent(Condition newParent) {
		_parent = newParent;
	}

	/**
	 * Sets the second conditional child. See further information at the isValid()-Method
	 * to see what is to do to make afterwards this condtion a valid condition.
	 * Creation date: (21.12.2001 20:43:35)
	 * @param newSecondChild org.cocons.uml.ccl.Condition
	 */
	public void setSecondChild(Condition newSecondChild) {

		_secondChild = newSecondChild;

	}

	/**
		 * Returns a String that represents the value of this object.
		 * @return a string representation of the receiver
		 */
	public String toString() {

		String condition = "";

		if (this.isLeaf()) {
			if (this.getComparison() != null) {
				condition += this.getComparison().toString() + " ";
			} else {
				condition += "no comparison ";
			}
		} else {
			if (this.getFirstChild() != null) {
				condition += this.getFirstChild().toString() + " ";
			} else {
				condition += "no child ";
			}

			if (this.getLogicOperation() != null) {
				condition += this.getLogicOperation().toString() + "  ";
			} else {
				condition += "no logic  ";
			}

			if (this.getSecondChild() != null) {
				condition += this.getSecondChild().toString();
			} else {
				condition += "no child ";
			}

		}
		return condition;
	}

    
}