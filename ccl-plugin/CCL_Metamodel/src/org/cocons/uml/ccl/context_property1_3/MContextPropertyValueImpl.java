package org.cocons.uml.ccl.context_property1_3;

import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValueImpl;
import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValue;

/**
* Wraps a MTaggedValue, but deprecates its set/getTag()-Method, so that a
* change from argouml's nsuml 1.3 to nsuml 1.4 is easily made.
* Unfortunatly an Extension from MTaggedValueImpl is not possible, because
* the methods to deprecate are final, thus shadowing won't work.
* It implements a contextbased tag-value pair. In the sense of contextbased
* constraints it's a yellow pinup having analyseable properties.
*
* TO_DO: binary association with MContextPropertyValueImpl.
*
* Creation date: (21.12.2001 12:12:17)
* @author: Fadi Chabarek, Stefan Tang, Philipp Schumacher.
*/
public class MContextPropertyValueImpl extends MTaggedValueImpl implements MContextPropertyValue {

	private MTaggedValue taggedValue;
		private MContextPropertyTag contextTag = null;

	/**
	 * MContextPropertyTag constructor comment.
	 */
	public MContextPropertyValueImpl() {
		taggedValue = new MTaggedValueImpl();
	}

	/**
	* Returns the related tag for this context based value.
	* Creation date: (21.12.2001 18:18:06)
	* @return MContextPropertyTag The related context property tag.
	*/
	public MContextPropertyTag getContextPropertyTag() {
		return contextTag;
	}

		public void internalRefByContextPropertyTag (MContextPropertyTag __arg){
		  MContextPropertyTag __saved = contextTag;
			if (contextTag != null) {
			  contextTag.removeScopedValue(this);
			}
		  fireRefSet("propertyTag", __saved, __arg);
		  contextTag = __arg;
		}

		public void internalUnrefByContextPropertyTag (MContextPropertyTag __arg) {
		  fireRefSet("propertyTag", contextTag, null);
		  contextTag = null;
		}

		public void removeScopedTag(MContextPropertyTag __arg){
		  //remove the tag...
		}

	/**
	* Sets the tag for this context based property value.
	* Creation date: (21.12.2001 18:18:34)
	* @param contextTag MContextPropertyTag The related context based property tag.
	*/
	public void setContextPropertyTag(MContextPropertyTag contextTag) {
		this.contextTag = contextTag;
	}
}