package org.cocons.uml.ccl.util;

import org.cocons.uml.ccl.*;

import org.cocons.uml.ccl.logic_operations.*;

import org.cocons.uml.ccl.comparators.*;/**
 * Generates limited random conditional tree.
 * Creation date: (28.12.2001 16:09:01)
 * @author: Fadi Chabarek
 */
public class ConditionalTreeGenerator {
	/**
	 * ConditionalTreeGenerator constructor comment.
	 */
	public ConditionalTreeGenerator() {
		super();
	}
	/**
	 * Fills a conditional tree with boundaries and logic operations, assuming
	 * that the tree consists of ConditionImpls and is valid. This is a classic
	 * help method ;).
	 * Creation date: (28.12.2001 19:43:59)
	 * @return org.cocons.uml.ccl.Condition the resulting condition.
	 * @param tree org.cocons.uml.ccl.Condition condition to enrich with operations.
	 */
	private static Condition fillTreeWithOperations(ConditionImpl tree) {

		if (tree.isLeaf()) {
			tree.setComparison(generateComparison());
		} else {
			tree.setLogicOperation(generateLogicOperation());
			fillTreeWithOperations((ConditionImpl) tree.getFirstChild());
			fillTreeWithOperations((ConditionImpl) tree.getSecondChild());
		}

		return tree;
	}
	/**
	 * Generates a random Comparison with tag length 10.
	 * Creation date: (28.12.2001 18:34:30)
	 * @return Comparison the random Comparison.
	 */
	public static Comparison generateComparison() {

		ComparisonImpl Comparison = new ComparisonImpl();

		Comparison.setTag(generateTag(10));
		Comparison.setValue(String.valueOf(Math.random()));
		Comparison.setComparator(generateComparator());

		return Comparison;
	}
	/**
	 * Generates a random Comparison.
	 * Creation date: (28.12.2001 18:34:30)
	 * @return Comparison the random Comparison.
	 */
	public static Comparison generateComparison(int tagLength) {

		ComparisonImpl Comparison = new ComparisonImpl();

		Comparison.setTag(generateTag(tagLength));
		Comparison.setValue(String.valueOf(Math.random()));
		Comparison.setComparator(generateComparator());

		return Comparison;
	}
	/**
	 * Generates a random Comparator.
	 * Creation date: (28.12.2001 18:41:15)
	 * @return org.cocons.uml.ccl.Comparator a random Comparator.
	 */
	public static Comparator generateComparator() {

		ComparatorFactory factory = new ComparatorFactoryImpl();
		Comparator[] Comparators = factory.produceAllAvailableComparators();
		int comIndex = new Double(Math.random() * Comparators.length).intValue();

		return Comparators[comIndex];

	}
	/**
	 * Generates a limited 'random' conditional Tree. 
	 * Creation date: (28.12.2001 16:10:57)
	 * @return java.lang.Object
	 * @param maxNodes int the maximal node count of the tree.
	 */
	public static Condition generateConditionalTree(int maxNodes) {

		// calculate an odd random node count
		int nodeCount = (new Double(Math.random() * maxNodes)).intValue();

		if (nodeCount % 2 == 0) {
			nodeCount++;
		}

		ConditionImpl tree = new ConditionImpl();
		ConditionImpl node;
		ConditionImpl child1 = null;
		ConditionImpl child2 = null;

		int a = 1;

		// construct tree
		while (a < nodeCount) {
			node = tree;
			while (node.getFirstChild() != null) {

				// choose one of the two pathes
				if (Math.random() < 0.5) {
					node = (ConditionImpl) node.getFirstChild();
				} else {
					node = (ConditionImpl) node.getSecondChild();
				}

			}

			// put another two childs into the tree
			child1 = new ConditionImpl();
			child2 = new ConditionImpl();
			child1.setParent(node);
			child2.setParent(node);

			node.setFirstChild(child1);
			node.setSecondChild(child2);
			a += 2;
		}

		return fillTreeWithOperations(tree);
	}
	/**
	 * Generates a random logic operation.
	 * Creation date: (28.12.2001 18:41:37)
	 * @return org.cocons.uml.ccl.LogicOperation
	 */
	public static LogicOperation generateLogicOperation() {

		LogicFactory factory = new LogicFactoryImpl();
		LogicOperation[] los = factory.produceAllAvailableLogicOperations();

		return los[new Double(Math.random() * los.length).intValue()];
	}
	/**
	 * Generates a String containing random letter.
	 * Creation date: (28.12.2001 20:23:21)
	 * @return java.lang.String a capital string with length length.
	 */
	public static String generateTag(int length) {

		char[] alphabet = 
			{
				'a', 
				'b', 
				'c', 
				'd', 
				'e', 
				'f', 
				'g', 
				'h', 
				'i', 
				'j', 
				'k', 
				'l', 
				'm', 
				'n', 
				'o', 
				'p', 
				'q', 
				'r', 
				's', 
				't', 
				'u', 
				'v', 
				'w', 
				'x', 
				'y', 
				'z'}; 

		char[] string = new char[length];

		for (int i = 0; i < string.length; i++) {
			if (i == 0) {
				string[i] = Character.toUpperCase(alphabet[(new Double(Math.random() * 26)).intValue()]);
			} else {
				string[i] = alphabet[(new Double(Math.random() * 26)).intValue()];
			}
		}

		return new String(string);
	}
}