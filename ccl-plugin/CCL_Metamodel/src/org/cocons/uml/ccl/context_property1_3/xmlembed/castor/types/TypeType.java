/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: TypeType.java,v 1.2 2002/02/11 23:55:45 ali Exp $
 */

package org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import org.exolab.castor.xml.*;

/**
 * 
 * @version $Revision: 1.2 $ $Date: 2002/02/11 23:55:45 $
**/
public class TypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The strings type
    **/
    public static final int STRINGS_TYPE = 0;

    /**
     * The instance of the strings type
    **/
    public static final TypeType STRINGS = new TypeType(STRINGS_TYPE, "strings");

    /**
     * The floats type
    **/
    public static final int FLOATS_TYPE = 1;

    /**
     * The instance of the floats type
    **/
    public static final TypeType FLOATS = new TypeType(FLOATS_TYPE, "floats");

    /**
     * The integers type
    **/
    public static final int INTEGERS_TYPE = 2;

    /**
     * The instance of the integers type
    **/
    public static final TypeType INTEGERS = new TypeType(INTEGERS_TYPE, "integers");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private TypeType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types.TypeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of TypeType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this TypeType
    **/
    public int getType()
    {
        return this.type;
    } //-- int getType() 

    /**
    **/
    private static java.util.Hashtable init()
    {
        Hashtable members = new Hashtable();
        members.put("strings", STRINGS);
        members.put("floats", FLOATS);
        members.put("integers", INTEGERS);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this TypeType
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new TypeType based on the given String value.
     * @param string
    **/
    public static org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types.TypeType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid TypeType";
            throw new IllegalArgumentException(err);
        }
        return (TypeType) obj;
    } //-- org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types.TypeType valueOf(java.lang.String) 

}
