package org.cocons.uml.ccl.util;

import java.util.Vector;
import java.util.Collection;

/**
 * Insert the type's description here.
 * Creation date: (21.02.2002 13:51:44)
 * @author: Fadi Chabarek
 */
public class SetCalculator {
/**
 * ConstexSetCalculator constructor comment.
 */
public SetCalculator() {
	super();
}
/**
 * Calculates the complement of a set.
 * Creation date: (21.02.2002 13:57:13)
 * @return java.util.Collection the complement of the set.
 * @param target java.util.Collection the set to be targeted.
 * @param all java.util.Collection the set that contains all elements, especially the targeted.
 */
public Collection calculateComplement(Collection target, Collection all) {

	Collection complement = new Vector();
	Object[] allObjects = all.toArray();
	
	for (int i = 0; i < allObjects.length; i++){
		if(!target.contains(allObjects[i])) {
			complement.add(allObjects[i]);
		}	
	}
	
	return complement;
}
/**
 * Calculates the intersection between two sets.
 * Creation date: (21.02.2002 13:53:21)
 * @return java.util.Collection the intersection of target and scope.
 * @param target java.util.Collection the first set.
 * @param scope java.util.Collection the second set.
 */
public Collection calculateIntersection(Collection target, Collection scope) {
	
	Collection intersection = new Vector();
	Object[] targetObjects = target.toArray();
	
	for (int i = 0; i < targetObjects.length; i++){
		if(scope.contains(targetObjects[i])) {
			intersection.add(targetObjects[i]);
		}	
	}
	
	return intersection;
}
/**
 * Calculates the Unification of two sets.
 * Creation date: (21.02.2002 13:58:25)
 * @return java.util.Collection the Unification of target and scope.
 * @param target java.util.Collection the first set.
 * @param scope java.util.Collection the second set.
 */
public Collection calculateUnification(Collection target, Collection scope) {

	Object[] targetObjects = target.toArray();
	
	for (int i = 0; i < targetObjects.length; i++){
		if(!scope.contains(targetObjects[i])) {
			scope.add(targetObjects[i]);
		}
	}
	
	return scope;
}
}
