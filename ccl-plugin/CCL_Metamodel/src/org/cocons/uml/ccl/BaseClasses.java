package org.cocons.uml.ccl;

import ru.novosoft.uml.foundation.core.MElement;
import ru.novosoft.uml.foundation.core.MInterface;
import ru.novosoft.uml.foundation.core.MClass;

/**
* Collection of constants describing model element's base classes.
* Creation date: (15.01.2002 16:57:24)
* @author: Fadi Chabarek
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
	* Checks weather the given object matchs the given base class type.
	* Creation date: (07.02.2002 18:35:41)
	* @return boolean true if the type is defined and the object matchs 
	* that type
	* @param possClass java.lang.Object the possible matching object.
	* @param baseClassType java.lang.String the type to be matched
	*/
	public boolean objectMatchsType(Object possClass, String baseClassType) {

		try {
			if (baseClassType.compareTo(INTERFACE) == 0) {
				return possClass instanceof MInterface;
			}

			if (baseClassType.compareTo(ELEMENT) == 0) {
				return possClass instanceof MElement;
			}

			//TODO: Define or find constants for type, info type and comp spec...

			if (baseClassType.compareTo(BUSINESS_TYPE) == 0) {
				if (possClass instanceof MClass) {
					return "<<type>>".compareTo(((MClass) possClass).getStereotype().getName()) == 0
						|| "<<info type>>".compareTo(((MClass) possClass).getStereotype().getName()) == 0; 
				}
			}

			if (baseClassType.compareTo(COMPONENT) == 0) {
				if (possClass instanceof MClass) {
					return "<<comp spec>>".compareTo(((MClass) possClass).getStereotype().getName()) == 0;
				}
			}
		} catch (NullPointerException npe) {
		}
		return false;
	}

	/**
	 * Returns all defined base class types.
	 * Creation date: (07.02.2002 19:32:04)
	 * @return java.lang.String[] the defined base class types.
	 */
	public String[] getAllAvailableTypes() {

		String[] types = new String[4];

		types[0] = ELEMENT;
		types[1] = INTERFACE;
		types[2] = BUSINESS_TYPE;
		types[3] = COMPONENT;

		return types;
	}
}