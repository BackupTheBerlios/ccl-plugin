package org.cocons.uml.ccl.context_property1_3;

import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValueImpl;

import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValue;

/**
* Wraps a MTaggedValue, but deprecats its get/setValue()-Method, so that a
* change from argouml's nsuml 1.3 to nsuml 1.4 is easily made.
* Unfortunatly an Extension from MTaggedValueImpl is not possible, because
* the methods to deprecate are final, thus shadowing won't work.
*
* TO_DO: binary association with MContextPropertyValueImpl.
*
* Creation date: (21.12.2001 12:12:17)
* @author: Fadi Chabarek, Stefan Tang, Philipp Schumacher.
*/
public class MContextPropertyTagImpl extends MTaggedValueImpl implements MContextPropertyTag {

	private MTaggedValue taggedValue;
		private MContextPropertyValue contextValue;

	/**
	 * MContextPropertyTag constructor comment.
	 */
	public MContextPropertyTagImpl() {
		taggedValue = new MTaggedValueImpl();
	}

		public MContextPropertyValue getContextPropertyValue() {
		  return contextValue;
		}

		public void internalRefByContextPropertyValue (MContextPropertyValue __arg){
		  MContextPropertyValue __saved = contextValue;
			if (contextValue != null) {
			  contextValue.removeScopedTag(this);
			}
		  fireRefSet("propertyValue", __saved, __arg);
		  contextValue = __arg;
		}

		public void internalUnrefByContextPropertyValue (MContextPropertyValue __arg) {
		  fireRefSet("propertyValue", contextValue, null);
		  contextValue = null;
		}

		public void removeScopedValue(MContextPropertyValue __arg){
		  //remove the value...
		}

	/**
	* Sets the value for this context based property tag.
	* Creation date: (21.12.2001 18:18:34)
	* @param contextValue MContextPropertyValue The related context based property value.
	*/
	public void setContextPropertyValue(MContextPropertyValue contextValue) {
		this.contextValue = contextValue;
	}
}