package org.cocons.uml.ccl.context_property1_3;

import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValueImpl;
import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValue;
import ru.novosoft.uml.foundation.core.MModelElement;
import ru.novosoft.uml.foundation.core.MNamespace;

import org.cocons.argo.diagram.ui.FigContextProperty;

import org.argouml.ui.ProjectBrowser;
import org.argouml.uml.UUIDManager;

import java.util.Vector;
import java.util.Collection;
import java.util.Iterator;
import java.util.Enumeration;
import javax.swing.JOptionPane;

import org.cocons.uml.ccl.context_property1_3.xmlembed.*;
import org.cocons.uml.ccl.context_property1_3.xmlembed.castor.ECPVEntry;
import org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types.TypeType;

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

	public static String LIST_OF_STRINGS_ID = "List Of Strings";
	public static String FLOAT_NUMBER_ID    = "Float Number";
	public static String INTEGER_NUMBER_ID  = "Integer Number";

	// private MTaggedValueImpl _taggedValue; // ??? wozu ??? (hyshosha@gmx.de)
        private MContextPropertyTag _contextTag = null;

        private String _tagStringBak;
        private String _valStringBak;

        private String _validValuesType;
        private String _stereoString = "";
        private String _valString_horizontal = "no values selected or defined ";
        private String _valString_vertical = "\n> no values selected or defined \n";

        private boolean _figureOrientation = false; // horizontal
        private boolean _valueVisibility = true; // Values und Stereo werden in der Figure angezeigt

        private Vector _validStrings;
        private Vector _stringSelection;
        private Vector _stringDependencies;

        private int _valuesCount;
        private boolean _valuesSelected = false;

        private Vector _definedIntegers;
        private Vector _intSelection;
        private Vector _intDependencies;

        private Vector _definedFloats;
        private Vector _floatSelection;
        private Vector _floatDependencies;

	private boolean _currentlySaving = false;

	/**
	 * MContextPropertyTag constructor comment.
	 */
	public MContextPropertyValueImpl() {
          // _taggedValue = new MTaggedValueImpl(); // ??? wozu ??? (hyshosha@gmx.de)
	}


	public boolean initializeFromEmbeddedXML( MContextPropertyTag tag,
															TypeType type,
															Enumeration entries,
															String stereo )
	{
		Vector values     = new Vector();
		Vector selections = new Vector();
		Vector deps       = new Vector();

		setCPValue("hello?");

		setCPTag( tag.getName() );
		internalRefByContextPropertyTag( tag );
		setStereoString( stereo );

		_valuesCount=0;

		switch( type.getType() ) {
		case TypeType.STRINGS_TYPE:
			//System.out.println("STRINGS_TYPE");
			_validValuesType    = LIST_OF_STRINGS_ID;
			_validStrings       = values     = new Vector();
			_stringSelection    = selections = new Vector();
			_stringDependencies = deps       = new Vector();
			break;
		case TypeType.FLOATS_TYPE:
			//System.out.println("FLOATS_TYPE");
			_validValuesType   = FLOAT_NUMBER_ID;
			_definedFloats     = values     = new Vector();
			_floatSelection    = selections = new Vector();
			_floatDependencies = deps       = new Vector();
			break;
		case TypeType.INTEGERS_TYPE:
			//System.out.println("INTEGERS_TYPE");
			_validValuesType = INTEGER_NUMBER_ID;
			_definedIntegers = values       = new Vector();
			_intSelection    = selections   = new Vector();
			_intDependencies = deps         = new Vector();
			break;
		default:
			//System.out.println("DEFAULT");
			return false;
		}
		//System.out.println("PRE0::" + _stringSelection + " " + selections);

		while( entries.hasMoreElements() )
			{
				ECPVEntry ent = (ECPVEntry)entries.nextElement();
				_valuesCount ++;
				values.add( ent.getValue() );
				Boolean b = new Boolean(ent.getSelected());
				selections.add( b );
				//System.out.println("ADDED " + b );
				deps.add( ent.getDependency() );
			}

// 		Iterator it = selections.iterator();
// 		while( it.hasNext() )
// 			System.out.println(" PRE " + it.next() );
// 		System.out.println("PRE::" + _stringSelection + " " + selections);

		switch( type.getType() ) {
		case TypeType.STRINGS_TYPE:
			checkValueSelection_ListOfString();
			break;
		case TypeType.FLOATS_TYPE:
			checkValueSelection_Float();
			break;
		case TypeType.INTEGERS_TYPE:
			checkValueSelection_Integer();
		}

// 		it = selections.iterator();
// 		while( it.hasNext() )
// 			System.out.println(" POST " + it.next() );
// 		System.out.println("POST::" + _stringSelection);

		setCPValue( getValueString_Horizontal() );
		return true;
	}

	/**
	* Returns the related tag for this context based value.
	* Creation date: (21.12.2001 18:18:06)
	* @return MContextPropertyTag The related context property tag.
	*/
	public MContextPropertyTag getContextPropertyTag() {
          return _contextTag;
	}

        public void internalRefByContextPropertyTag (MContextPropertyTag __arg){
          setContextPropertyTag(__arg);
          /*
          MContextPropertyTag __saved = _contextTag;
          fireRefSet("propertyTag", __saved, __arg);
          _contextTag = __arg;
          _validValuesType = ((MContextPropertyTagImpl)__arg).getValidValuesType();
          if (_validValuesType.equals("List Of Strings")) {
            _validStrings = ((MContextPropertyTagImpl)_contextTag).getValidStrings();
            _valuesCount = _validStrings.size();
            _stringSelection = new Vector();
            _stringDependencies = new Vector();
            for (int i = 0; i < _valuesCount; i++) {
              _stringSelection.addElement(new Boolean(false));
              String dependency = "";
              _stringDependencies.addElement(dependency);
            }
          }
          else if (_validValuesType.equals("Integer Number")) {
          }
          else if (_validValuesType.equals("Float Number")) {
          }
          else {}
          */
        }

        public void removeScopedTag(){
			  //System.out.println("removeScopedTag()");
          _contextTag = null;
          _validValuesType = null;
          _validStrings = null;
          _stringDependencies = null;
          _stringSelection = null;
          _definedIntegers = null;
          _intSelection = null;
          _intDependencies = null;
          _definedFloats = null;
          _floatSelection = null;
          _floatDependencies = null;
        }
	/**
	* Sets the tag for this context based property value.
	* Creation date: (21.12.2001 18:18:34)
	* @param contextTag MContextPropertyTag The related context based property tag.
	*/
	public void setContextPropertyTag(MContextPropertyTag contextTag) {
		//System.out.println("setContextPropertyTag()");
          _contextTag = contextTag;
          _valuesSelected = false;
          try {
            _validValuesType = ((MContextPropertyTagImpl)_contextTag).getValidValuesType();
          }
          catch (NullPointerException npe) {
            _contextTag = null;
            System.out.println("CP-Tag has no ValidValue-Definition!");
            return;
          }
          if (_validValuesType.equals("List Of Strings")) {
            _validStrings = ((MContextPropertyTagImpl)_contextTag).getValidStrings();
            _valuesCount = _validStrings.size();
            _stringSelection = new Vector();
            _stringDependencies = new Vector();
            for (int i = 0; i < _valuesCount; i++) {
              _stringSelection.addElement(new Boolean(false));
              String dependency = "";
              _stringDependencies.addElement(dependency);
            }
          }
          else if (_validValuesType.equals("Integer Number")) {
            _definedIntegers = new Vector();
            _intSelection = new Vector();
            _intDependencies = new Vector();
            addEmptyIntegerValue();
          }
          else if (_validValuesType.equals("Float Number")) {
            _definedFloats = new Vector();
            _floatSelection = new Vector();
            _floatDependencies = new Vector();
            addEmptyFloatValue();
          }
          else {
            _contextTag = null;
            System.out.println("CP-Tag has unknown ValidValue-Definition!");
            return;
          }
	}

        // -------------- by hyshosha@gmx.de -----------------------
        private MModelElement _objectWithContextProperty = null;
        private FigContextProperty _myFigure;

        /*
        public MModelElement getNamespace() {
          return(_objectWithContextProperty.getNamespace());
        }
        */

        public void setCPTag(String tagString) {
          _tagStringBak = tagString;
          super.setTag(tagString);
        }

        public void setCPValue(String valString) {
          _valStringBak = valString;
          super.setValue(valString);
        }

        public void forceTagAndValueConsistency() {

			  // while saving, tag contains some temporary ID
			  // and is always inconsistent.
			  if( _currentlySaving )
				  return;

          if (!_objectWithContextProperty.isRemoved()) {
            Collection col = _objectWithContextProperty.getTaggedValues();
            ProjectBrowser pb = ProjectBrowser.TheInstance;
            if (col.contains(this)) {
              if ((getTag().equals(_tagStringBak))&&(getValue().equals(_valStringBak))) return;
              else {
                if  (!(getTag().equals(_tagStringBak))) {
                  this.setTag(_tagStringBak);
                  pb.getDetailsPane().updateUI();
                  pb.getNavPane().forceUpdate();
                }
                if  (!(getValue().equals(_valStringBak))) {
                  this.setValue(_valStringBak);
                  pb.getDetailsPane().updateUI();
                }
                JOptionPane.showMessageDialog(null,"You tried to modify a Context Property.\nThis is not possible in the TaggedValues-Panel.\nUse instead the ContextProperty-PropertiesPanel !");
              }
            }
            else {
              this.setTag(_tagStringBak);
              this.setValue(_valStringBak);
              _objectWithContextProperty.addTaggedValue(this);
              pb.getDetailsPane().updateUI();
              pb.getNavPane().forceUpdate();
              pb.getDetailsPane().selectTabNamed("Properties");
              pb.getDetailsPane().selectTabNamed("TaggedValues");
              pb.getNavPane().forceUpdate();
              JOptionPane.showMessageDialog(null,"You tried to modify a Context Property.\nThis is not possible in the TaggedValues-Panel.\nUse instead the ContextProperty-PropertiesPanel !");
            }
          }
          else {
            // Let's work FigTerminator !
          }
        }

        public void removeMe() {
          _myFigure.destroyMe();
        }

        public void logicalRefByModelElement(MModelElement __arg) {
          _objectWithContextProperty = __arg;
        }

        public MModelElement getReferencedModelElement() {
          return(_objectWithContextProperty);
        }

        public void internalRefToMyFigure(FigContextProperty figure) {
          _myFigure = figure;
        }

        public void markFigure() {
          _myFigure.setColor(java.awt.Color.green);
          _myFigure.damage();
        }

        public void actualizeFigure() {
          _myFigure.actualizeEntries();
          _myFigure.damage();
        }

        public void resetFigureColor() {
          if (this.hasSelectedValues()) _myFigure.setColor(java.awt.Color.yellow);
          else _myFigure.setColor(java.awt.Color.lightGray);
          _myFigure.damage();
        }

        public String getValidValuesType() {
          return _validValuesType;
	}

        public void setValidValuesType(String type) {
          _validValuesType = type;
	}

        public String getStereoString() {
          return _stereoString;
	}

        public void setStereoString(String string) {
          _stereoString = string;
	}

        public String getValueString_Horizontal() {
          return _valString_horizontal;
	}

        public String getValueString_Vertical() {
          return _valString_vertical;
	}

        public void setValueString_Horizontal(String string) {
          _valString_horizontal = string;
	}

        public void setValueString_Vertical(String string) {
          _valString_vertical = string;
	}

        public int getValuesCount() {
          return(_valuesCount);
        }

        /////////////////////////////////////////////////////
        // List of Strings
        public Boolean getStringSelectionAt(int index) {
			  //System.out.println("getStringSelectionAt("+index+") : " +_stringSelection.elementAt(index));
// 			  Iterator vals=_stringSelection.iterator();
// 			  while( vals.hasNext() )
// 				  System.out.println(" >> " + vals.next() );
// 			  System.out.println(">>>>>> " + _stringSelection);
          return((Boolean)_stringSelection.elementAt(index));
        }

        public String getStringDependencyAt(int index) {
          return((String)_stringDependencies.elementAt(index));
        }

        public void setStringDependencyAt(int index,String dependency) {
          _stringDependencies.setElementAt(dependency,index);
          checkValueSelection_ListOfString();
        }

        public void negateStringSelectionAt(int index) {
			  //System.out.println("negateStringSelectionAt " + index);
          boolean old = ((Boolean)_stringSelection.elementAt(index)).booleanValue();
          Boolean newSelection = new Boolean(!old);
          _stringSelection.setElementAt(newSelection,index);
          checkValueSelection_ListOfString();
        }

        public void checkValueSelection_ListOfString() {
			  //System.out.println("checkValueSelection_ListOfString");
          boolean valuesSelected = false;
          boolean actual = false;
          _valString_horizontal = "";
          _valString_vertical = "\n> ";
          _valuesCount = _validStrings.size();
          for (int i = 0; i < _valuesCount; i++) {
            actual = ((Boolean)_stringSelection.elementAt(i)).booleanValue();
            valuesSelected = valuesSelected||actual;
            if (actual) {
              if (((String)_stringDependencies.elementAt(i)).equals("")) {
                _valString_horizontal = _valString_horizontal + (String)_validStrings.elementAt(i) + ", ";
                _valString_vertical = _valString_vertical + (String)_validStrings.elementAt(i) + " \n> ";
              }
              else {
                _valString_horizontal = _valString_horizontal + (String)_validStrings.elementAt(i)+" ("+ (String)_stringDependencies.elementAt(i)+")" + ", ";
                _valString_vertical = _valString_vertical + (String)_validStrings.elementAt(i)+" ("+ (String)_stringDependencies.elementAt(i)+")" + " \n> ";
              }
            }
          }
          _valuesSelected = valuesSelected;
          if (!valuesSelected) {
            _valString_horizontal = "no values selected or defined ";
            _valString_vertical = "\n> no values selected or defined \n";
          }
          else {
            _valString_horizontal = _valString_horizontal.substring(0,_valString_horizontal.length()-2) + " ";
            _valString_vertical = _valString_vertical.substring(0,_valString_vertical.length()-2);
          }
        }

        ////////////////////////////////////////////////////////////////////////
        // Integer Number
        public void addEmptyIntegerValue() {
          String empty1 = "";
          String empty2 = "";
          _definedIntegers.addElement(empty1);
          _intDependencies.addElement(empty2);
          _intSelection.addElement(new Boolean(false));
        }

        public int getIntegerValuesCount() {
          return(_definedIntegers.size());
        }

        public boolean isEmptyIntegerValue(int index) {
          if ((((String)_definedIntegers.elementAt(index)).equals("")&&(!((Boolean)_intSelection.elementAt(index)).booleanValue()))) {
            return(true);
          }
          else return(false);
        }

        public void removeIntegerValueAt(int index) {
          _definedIntegers.removeElementAt(index);
          _intSelection.removeElementAt(index);
          _intDependencies.removeElementAt(index);
        }

        public void negateIntegerSelectionAt(int index) {
          boolean old = ((Boolean)_intSelection.elementAt(index)).booleanValue();
          Boolean newSelection = new Boolean(!old);
          _intSelection.setElementAt(newSelection,index);
          checkValueSelection_Integer();
        }

        public void checkValueSelection_Integer() {
          boolean valuesSelected = false;
          boolean actual = false;
          _valString_horizontal = "";
          _valString_vertical = "\n> ";
          _valuesCount = _definedIntegers.size();
          for (int i = 0; i < _valuesCount; i++) {
            actual = ((Boolean)_intSelection.elementAt(i)).booleanValue();
            valuesSelected = valuesSelected||actual;
            if (actual) {
              if (((String)_intDependencies.elementAt(i)).equals("")) {
                _valString_horizontal = _valString_horizontal + (String)_definedIntegers.elementAt(i) + ", ";
                _valString_vertical = _valString_vertical + (String)_definedIntegers.elementAt(i) + " \n> ";
              }
              else {
                _valString_horizontal = _valString_horizontal + (String)_definedIntegers.elementAt(i)+" ("+ (String)_intDependencies.elementAt(i)+")" + ", ";
                _valString_vertical = _valString_vertical + (String)_definedIntegers.elementAt(i)+" ("+ (String)_intDependencies.elementAt(i)+")" + " \n> ";
              }
            }
          }
          _valuesSelected = valuesSelected;
          if (!valuesSelected) {
            _valString_horizontal = "no values selected or defined ";
            _valString_vertical = "\n> no values selected or defined \n";
          }
          else {
            _valString_horizontal = _valString_horizontal.substring(0,_valString_horizontal.length()-2) + " ";
            _valString_vertical = _valString_vertical.substring(0,_valString_vertical.length()-2);
          }
        }

        public Boolean getIntegerSelectionAt(int index) {
          return((Boolean)_intSelection.elementAt(index));
        }

        public String getIntegerDependencyAt(int index) {
          return((String)_intDependencies.elementAt(index));
        }

        public void setIntegerDependencyAt(int index,String dependency) {
          _intDependencies.setElementAt(dependency,index);
          checkValueSelection_Integer();
        }

        public String getIntegerValueAt(int index) {
          return((String)_definedIntegers.elementAt(index));
        }

        public void setIntegerValueAt(int index,String value) {
          _definedIntegers.setElementAt(value,index);
        }

        public void cleanIntegerValues() {
          for (int i = _definedIntegers.size()-1; i >= 0; i--) {
            if (isEmptyIntegerValue(i)) removeIntegerValueAt(i);
          }
          addEmptyIntegerValue();
          checkValueSelection_Integer();
        }

        ////////////////////////////////////////////////////////////////////////
        // Float Number
        public void addEmptyFloatValue() {
          String empty1 = "";
          String empty2 = "";
          _definedFloats.addElement(empty1);
          _floatDependencies.addElement(empty2);
          _floatSelection.addElement(new Boolean(false));
        }

        public int getFloatValuesCount() {
          return(_definedFloats.size());
        }

        public boolean isEmptyFloatValue(int index) {
          if ((((String)_definedFloats.elementAt(index)).equals("")&&(!((Boolean)_floatSelection.elementAt(index)).booleanValue()))) {
            return(true);
          }
          else return(false);
        }

        public void removeFloatValueAt(int index) {
          _definedFloats.removeElementAt(index);
          _floatSelection.removeElementAt(index);
          _floatDependencies.removeElementAt(index);
        }

        public void negateFloatSelectionAt(int index) {
          boolean old = ((Boolean)_floatSelection.elementAt(index)).booleanValue();
          Boolean newSelection = new Boolean(!old);
          _floatSelection.setElementAt(newSelection,index);
          checkValueSelection_Float();
        }

        public void checkValueSelection_Float() {
          boolean valuesSelected = false;
          boolean actual = false;
          _valString_horizontal = "";
          _valString_vertical = "\n> ";
          _valuesCount = _definedFloats.size();
          for (int i = 0; i < _valuesCount; i++) {
            actual = ((Boolean)_floatSelection.elementAt(i)).booleanValue();
            valuesSelected = valuesSelected||actual;
            if (actual) {
              if (((String)_floatDependencies.elementAt(i)).equals("")) {
                _valString_horizontal = _valString_horizontal + (String)_definedFloats.elementAt(i) + ", ";
                _valString_vertical = _valString_vertical + (String)_definedFloats.elementAt(i) + " \n> ";
              }
              else {
                _valString_horizontal = _valString_horizontal + (String)_definedFloats.elementAt(i)+" ("+ (String)_floatDependencies.elementAt(i)+")" + ", ";
                _valString_vertical = _valString_vertical + (String)_definedFloats.elementAt(i)+" ("+ (String)_floatDependencies.elementAt(i)+")" + " \n> ";
              }
            }
          }
          _valuesSelected = valuesSelected;
          if (!valuesSelected) {
            _valString_horizontal = "no values selected or defined ";
            _valString_vertical = "\n> no values selected or defined \n";
          }
          else {
            _valString_horizontal = _valString_horizontal.substring(0,_valString_horizontal.length()-2) + " ";
            _valString_vertical = _valString_vertical.substring(0,_valString_vertical.length()-2);
          }
        }

        public Boolean getFloatSelectionAt(int index) {
          return((Boolean)_floatSelection.elementAt(index));
        }

        public String getFloatDependencyAt(int index) {
          return((String)_floatDependencies.elementAt(index));
        }

        public void setFloatDependencyAt(int index,String dependency) {
          _floatDependencies.setElementAt(dependency,index);
          checkValueSelection_Float();
        }

        public String getFloatValueAt(int index) {
          return((String)_definedFloats.elementAt(index));
        }

        public void setFloatValueAt(int index,String value) {
          _definedFloats.setElementAt(value,index);
        }

        public void cleanFloatValues() {
          for (int i = _definedFloats.size()-1; i >= 0; i--) {
            if (isEmptyFloatValue(i)) removeFloatValueAt(i);
          }
          addEmptyFloatValue();
          checkValueSelection_Float();
        }
        //
        ////////////////////////////////////////////////////////////////////////

        public boolean hasSelectedValues() {
          return(_valuesSelected);
        }

        public boolean getFigureOrientation() {
          return(_figureOrientation);
        }

        public void negateFigureOrientation() {
          _figureOrientation = !_figureOrientation;
        }

        public void resetFigureOrientation() {
          _figureOrientation = false;
        }

        public boolean getValueVisibility() {
          return(_valueVisibility);
        }

        public void negateValueVisibility() {
          _valueVisibility = !_valueVisibility;
        }

        public void resetValueVisibility() {
          _valueVisibility = true;
        }
	
	//	public String getTag()
	// { return super.getTag()+"X"; }
	public void preSave()
	{
		_currentlySaving = true;
		ensureUUIDAssigned();
		
// 		System.out.println("MY UUID : " + getUUID());
// 		System.out.println("MY TAG : " + getContextPropertyTag().getUUID() );
// 		xx("_validStrings"       , _validStrings        );
// 		xx("_stringSelection"    , _stringSelection     );
// 		xx("_stringDependencies" , _stringDependencies  );
// 		xx("_definedIntegers"    , _definedIntegers     );
// 		xx("_intSelection"       , _intSelection        );
// 		xx("_intDependencies"    , _intDependencies     );
// 		xx("_definedFloats"      , _definedFloats       );
// 		xx("_floatSelection"     , _floatSelection      );
// 		xx("_floatDependencies"  , _floatDependencies   );

		setTag(EMBEDDED_XML_IDENTIFIER);

		EmbeddedContextPropertyValueCreator creator = 
			new EmbeddedContextPropertyValueCreator();

		creator.setType( _validValuesType );
		creator.setStereotype( getStereoString() );
		if ( LIST_OF_STRINGS_ID.equals(_validValuesType) )			
			creator.setContent(  _validStrings.iterator(),
										_stringSelection.iterator(),
										_stringDependencies.iterator() );
		else if( INTEGER_NUMBER_ID.equals(_validValuesType) )			
			creator.setContent(  _definedIntegers.iterator(),
										_intSelection.iterator(),
										_intDependencies.iterator() );
		else
			creator.setContent(  _definedFloats.iterator(),
										_floatSelection.iterator(),
										_floatDependencies.iterator() );

		creator.setTag( getContextPropertyTag() );

		setValue( creator.create() );
	}

	protected void ensureUUIDAssigned()
	{
		if( getUUID() == null )
			setUUID(UUIDManager.SINGLETON.getNewUUID());
	}

// 	public void xx(String n, Vector v )
// 	{
// 		System.out.println("++++++++++++++++++++ " + n );

// 		if( v == null )
// 			{
// 				System.out.println("  vec=null");
// 			}
// 		else
// 			{
// 				Iterator it = v.iterator();
// 				while( it.hasNext() )
// 					{
// 						Object o = it.next();
// 						System.out.println("  " + o.getClass() + " ==> " + o );
// 					}
// 			}
// 		System.out.println("==================== " + n );
// 	}

	public void postSave()
	{
		super.setTag( _tagStringBak );
		super.setValue( _valStringBak );
		_currentlySaving = false;
	}

}
