package org.cocons.uml.ccl;

import javax.swing.tree.TreeNode;

import ru.novosoft.uml.foundation.core.MModelElement;

/**
* A conditional tree containing childs related via a logic operation (as node) xor
* a comparison (as leaf) that model elements must fit in to comply this condition.
* @see javax.swing.tree.TreeNode
* Creation date: (20.12.2001 23:47:18)
* @author: Fadi Chabarek, Stefan Tang, Philipp Schumacher.
*/
public interface Condition extends TreeNode {

	/**
	* Returns the logic operation relating the children of this condition (node)
	* Creation date: (21.12.2001 01:40:36)
	* @return org.cocons.uml.ccl.LogicOperation the logic operation.
	*/
	public LogicOperation getLogicOperation();

	/**
	* Checks if this condition is complied with a given model element.
	* Creation date: (21.12.2001 13:11:01)
	* @return boolean true - if the condtion is complied.
	*/
	public boolean isCompliedWith(MModelElement modelElement);

	/**
	* Checks if this conditional tree is valid.
	* Creation date: (23.12.2001 11:38:17)
	* @return boolean true - if the tree is valid.
	*/
	boolean isValid();
    
	/**
	 * Returns a comparison setting up the domain of this condition.
	 * Creation date: (21.12.2001 00:46:17)
	 * @return comparison the comparison for this condition .
	 */
	public Comparison getComparison();
}