package org.cocons.uml.ccl.context_property1_3;

import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValue;

/**
 * Describes a contextbased property tag.
 * Creation date: (21.12.2001 18:20:29)
 * @author: Fadi Chabarek, Stefan Tang, Philipp Schumacher.
 */
public interface MContextPropertyTag extends MTaggedValue {

  MContextPropertyValue getContextPropertyValue();  

  void internalRefByContextPropertyValue (MContextPropertyValue __arg);  

  void internalUnrefByContextPropertyValue (MContextPropertyValue __arg);  

  void removeScopedValue(MContextPropertyValue __arg);  

}