package org.cocons.uml.ccl.logic_operations;

import org.cocons.uml.ccl.LogicOperation;

/**
 * Produces logic operations.
 * Creation date: (26.12.2001 15:46:07)
 * @author: Fadi Chabarek
 */
public interface LogicFactory {

	/*
	 * Type of the logic operation OR.
	 */
	public final static int OR = 0;

	/*
	 * Type of the logic operation AND.
	 */
	public final static int AND = 1; 

	/**
	 * Returns all available types of operations.
	 * Creation date: (26.12.2001 17:03:08)
	 * @return int[] the available types.
	 */
	int[] getAvailableTypes();

	/**
	 * Constructs a logical operation from the given operation type.
	 * Creation date: (26.12.2001 15:46:57)
	 * @return org.cocons.uml.ccl.LogicOperation the constructed logical operation
	 * @param operationType int the type of the logic operation.
	 */
	LogicOperation produceLogicOperationWithType(int operationType);
    
	/**
	* Produces all available types of logic operations.
	* Creation date: (28.12.2001 17:08:12)
	* @return org.cocons.uml.ccl.LogicOperation[] the logic operations.
	*/
	LogicOperation[] produceAllAvailableLogicOperations();
}