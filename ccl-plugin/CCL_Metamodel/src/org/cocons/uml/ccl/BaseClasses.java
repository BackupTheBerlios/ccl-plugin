package org.cocons.uml.ccl;

import ru.novosoft.uml.foundation.core.MElement;
import ru.novosoft.uml.foundation.core.MInterface;
import ru.novosoft.uml.foundation.core.MClass;

import ru.novosoft.uml.foundation.core.MModelElement;/**
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
	/**
	* Checks weather the given model element matchs the given base class type.
	* Creation date: (07.02.2002 18:35:41)
	* @return boolean true if the type is defined and the object matchs 
	* that type
	* @param possClass MModelElement the possible matching model element.
	* @param baseClassType java.lang.String the type to be matched
	*/
	public boolean objectMatchsType(MModelElement possClass, String baseClassType) {

		try {
			if (baseClassType.compareTo(INTERFACE) == 0) {
				return possClass instanceof MInterface;
			}

			if (baseClassType.compareTo(ELEMENT) == 0) {
				return possClass instanceof MElement;
			}

			if (baseClassType.compareTo(BUSINESS_TYPE) == 0) {
				if (possClass instanceof MClass) {
					return CCLConstants.TYPE.compareTo(((MClass) possClass).getStereotype().getName()) == 0
						|| CCLConstants.INFO_TYPE.compareTo(((MClass) possClass).getStereotype().getName()) == 0; 
				}
			}

			if (baseClassType.compareTo(COMPONENT) == 0) {
				if (possClass instanceof MClass) {
					return CCLConstants.COMP_SPEC.compareTo(((MClass) possClass).getStereotype().getName()) == 0;
				}
			}
		} catch (NullPointerException npe) {
		}
		return false;
	}}