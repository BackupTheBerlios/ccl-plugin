/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ComponentCategoryType.java,v 1.2 2002/10/10 14:06:00 oetker Exp $
 */

package de.fhg.isst.ComponentML.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import org.exolab.castor.xml.*;

/**
 * 
 *     Collection of legal elements for the specification of a 
 *     ComponentCategoryType element.
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:06:00 $
**/
public class ComponentCategoryType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The service-oriented type
    **/
    public static final int VALUE_0_TYPE = 0;

    /**
     * The instance of the service-oriented type
    **/
    public static final ComponentCategoryType VALUE_0 = new ComponentCategoryType(VALUE_0_TYPE, "service-oriented");

    /**
     * The message-driven type
    **/
    public static final int VALUE_1_TYPE = 1;

    /**
     * The instance of the message-driven type
    **/
    public static final ComponentCategoryType VALUE_1 = new ComponentCategoryType(VALUE_1_TYPE, "message-driven");

    /**
     * The type-declaring type
    **/
    public static final int VALUE_2_TYPE = 2;

    /**
     * The instance of the type-declaring type
    **/
    public static final ComponentCategoryType VALUE_2 = new ComponentCategoryType(VALUE_2_TYPE, "type-declaring");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private ComponentCategoryType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- de.fhg.isst.ComponentML.types.ComponentCategoryType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of
     * ComponentCategoryType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this ComponentCategoryType
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
        members.put("service-oriented", VALUE_0);
        members.put("message-driven", VALUE_1);
        members.put("type-declaring", VALUE_2);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this
     * ComponentCategoryType
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new ComponentCategoryType based on the given
     * String value.
     * @param string
    **/
    public static de.fhg.isst.ComponentML.types.ComponentCategoryType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid ComponentCategoryType";
            throw new IllegalArgumentException(err);
        }
        return (ComponentCategoryType) obj;
    } //-- de.fhg.isst.ComponentML.types.ComponentCategoryType valueOf(java.lang.String) 

}
