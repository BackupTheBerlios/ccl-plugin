package org.cocons.uml.ccl;

import ru.novosoft.uml.foundation.core.MElement;
import ru.novosoft.uml.foundation.core.MInterface;
import ru.novosoft.uml.foundation.core.MClass;

import ru.novosoft.uml.foundation.core.MModelElement;

/**
 * Contains the possible base classes to observe by contextbased
 * constraint and context condition respectivly and provides 
 * evaluating methods for them.
 */
public class BaseClasses {

	/**
	 * Describing model elements that are interfaces.
	 */
	public static final String INTERFACE = "INTERFACE(S)";

	/**
	 * Describing pure model elements. 
	 */
	public static final String ELEMENT = "ELEMENT(S)";

	/**
	 * Describing model elements that are business types.
	 */
	public static final String BUSINESS_TYPE = "BUSINESS TYPE(S)";

	/**
	 * Describing model elements that are components.
	 */
	public static final String COMPONENT = "COMPONENT(S)";

	/**
	 * Describing model elements that are components.
	 */
	public static final String COMPUTER = "COMPUTER(S)";

	/**
	 * Describing model elements that are components.
	 */
	public static final String CONTAINER = "CONTAINER(S)";

	/**
	 * Describing model elements that are business types.
	 */
	public static final String INFO_TYPE = "INFO TYPE(S)";

	/**
	 * Returns all defined base class types.
	 * Creation date: (07.02.2002 19:32:04)
	 * @return java.lang.String[] the defined base class types.
	 */
	public static String[] getAllAvailableTypes() {

		String[] types = new String[7];

		types[0] = ELEMENT;
		types[1] = INTERFACE;
		types[2] = BUSINESS_TYPE;
		types[3] = INFO_TYPE;
		types[4] = CONTAINER;
		types[5] = COMPONENT;
		types[6] = COMPUTER;

		return types;
	}

	/**
	* Checks weather the given model element matchs the given base class type.
	* Creation date: (07.02.2002 18:35:41)
	* @return boolean true if the type is defined and the object matchs 
	* that type
	* @param possClass MModelElement the possible matching model element.
	* @param baseClassType java.lang.String the type to be matched
	*/
	public static boolean objectMatchsType(MModelElement possClass, String baseClassType) {

		if (baseClassType != null) {
			if (baseClassType.compareTo(INTERFACE) == 0) {
				return possClass instanceof MInterface;
			}

			if (baseClassType.compareTo(ELEMENT) == 0) {
				return possClass instanceof MElement;
			}

			if (possClass instanceof MClass && ((MClass) possClass).getStereotype() != null) {
				String name = ((MClass) possClass).getStereotype().getName();

				if (name != null) {

					if (BUSINESS_TYPE.equals(baseClassType)) {
						return CCLConstants.TYPE.equals(name) || CCLConstants.INFO_TYPE.equals(name);
					}

					if (INFO_TYPE.equals(baseClassType)) {
						return CCLConstants.INFO_TYPE.equals(name);
					}

					if (COMPONENT.equals(baseClassType)) {
						return CCLConstants.COMP_SPEC.equals(name);
					}
				}
			}
		}

		return false;
	}
}