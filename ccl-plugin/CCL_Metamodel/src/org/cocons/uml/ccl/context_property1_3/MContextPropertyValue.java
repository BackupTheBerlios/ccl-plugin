package org.cocons.uml.ccl.context_property1_3;

import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValue;

/**
 * Describes a contextbased tag-value pair. In the sense of contextbased
 * constraints it's a yellow pinup having alyseable properties.
 * Creation date: (21.12.2001 18:20:45)
 * @author: Fadi Chabarek
 */
public interface MContextPropertyValue extends MTaggedValue {

	/**
	 * Returns the related tag for this context based value.
	 * Creation date: (21.12.2001 18:23:05)
	 * @return MContextPropertyTag The related tag.
	 */
	MContextPropertyTag getContextPropertyTag();

	/**
	 * Sets the tag for this context based property value.
	 * Creation date: (21.12.2001 18:23:32)
	 * @param MContextPropertyTag The context based property tag.
	 */
  void internalRefByContextPropertyTag (MContextPropertyTag __arg);  

/**
 * This method removed the tag, that the value is belonging to.
 */

void removeScopedTag();
}