package org.cocons.uml.ccl.logic_operations;

import org.cocons.uml.ccl.LogicOperation;

/**
 * Factory constructing logical operations.
 * Creation date: (21.12.2001 13:59:40)
 * @author: Fadi Chabarek, Stefan Tang, Philipp Schumacher.
 */
public class LogicFactoryImpl implements LogicFactory {

	/**
	* Constructs a logical operation from the given operation type.
	* Creation date: (21.12.2001 14:05:22)
	* @return org.cocons.uml.ccl.LogicOperation the constructed logical operation 
	* and null if the operationType is unknown.
	* @param operation int the type of the logic operation.
	*/
	public LogicOperation produceLogicOperationWithType(int operationType) {

		LogicOperation lo = null;

		switch (operationType) {
			case OR :
				{
					lo = new Or();
					break;
				}
			case AND: {
					lo = new And();
					break;
			}

		}

		return lo;
	}
   
	/**
	 * Constructs a logic Factory.
	 * Creation date: (26.12.2001 15:54:41)
	 */
	public LogicFactoryImpl() {
	} 
	
	/**
	* Returns all avaiable types of logic operations.
	* Creation date: (26.12.2001 17:03:14)
	* @return int[] the available types.
	*/
	public int[] getAvailableTypes() {

		int[] types = {LogicFactory.OR, LogicFactory.AND};

		return types;
	}
/**
 * Returns all available types of logic operations.
 * Creation date: (28.12.2001 17:08:12)
 * @return org.cocons.uml.ccl.LogicOperation[]
 */
public LogicOperation[] produceAllAvailableLogicOperations() {
	
	int[] availableTypes = getAvailableTypes();
	LogicOperation[] operations = new LogicOperation[availableTypes.length];
	
	
	for (int i = 0; i < availableTypes.length; i++){
		operations[i] = this.produceLogicOperationWithType(availableTypes[i]);	
	}
	
	return operations;
}}