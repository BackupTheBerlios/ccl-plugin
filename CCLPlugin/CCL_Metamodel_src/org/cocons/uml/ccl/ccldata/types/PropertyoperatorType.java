/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: PropertyoperatorType.java,v 1.1 2003/07/12 18:21:54 layekers Exp $
 */

package org.cocons.uml.ccl.ccldata.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import org.exolab.castor.xml.*;

/**
 * 
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:54 $
**/
public class PropertyoperatorType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The lowerthan type
    **/
    public static final int LOWERTHAN_TYPE = 2;

    /**
     * The instance of the lowerthan type
    **/
    public static final PropertyoperatorType LOWERTHAN = new PropertyoperatorType(LOWERTHAN_TYPE, "lowerthan");

    /**
     * The lowerequal type
    **/
    public static final int LOWEREQUAL_TYPE = 3;

    /**
     * The instance of the lowerequal type
    **/
    public static final PropertyoperatorType LOWEREQUAL = new PropertyoperatorType(LOWEREQUAL_TYPE, "lowerequal");

    /**
     * The greaterthan type
    **/
    public static final int GREATERTHAN_TYPE = 4;

    /**
     * The instance of the greaterthan type
    **/
    public static final PropertyoperatorType GREATERTHAN = new PropertyoperatorType(GREATERTHAN_TYPE, "greaterthan");

    /**
     * The greaterequal type
    **/
    public static final int GREATEREQUAL_TYPE = 5;

    /**
     * The instance of the greaterequal type
    **/
    public static final PropertyoperatorType GREATEREQUAL = new PropertyoperatorType(GREATEREQUAL_TYPE, "greaterequal");

    /**
     * The equal type
    **/
    public static final int EQUAL_TYPE = 6;

    /**
     * The instance of the equal type
    **/
    public static final PropertyoperatorType EQUAL = new PropertyoperatorType(EQUAL_TYPE, "equal");

    /**
     * The notequal type
    **/
    public static final int NOTEQUAL_TYPE = 7;

    /**
     * The instance of the notequal type
    **/
    public static final PropertyoperatorType NOTEQUAL = new PropertyoperatorType(NOTEQUAL_TYPE, "notequal");

    /**
     * The contains type
    **/
    public static final int CONTAINS_TYPE = 8;

    /**
     * The instance of the contains type
    **/
    public static final PropertyoperatorType CONTAINS = new PropertyoperatorType(CONTAINS_TYPE, "contains");

    /**
     * The notcontains type
    **/
    public static final int NOTCONTAINS_TYPE = 9;

    /**
     * The instance of the notcontains type
    **/
    public static final PropertyoperatorType NOTCONTAINS = new PropertyoperatorType(NOTCONTAINS_TYPE, "notcontains");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private PropertyoperatorType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- org.cocons.uml.ccl.ccldata.types.PropertyoperatorType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of
     * PropertyoperatorType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this PropertyoperatorType
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
        members.put("equal", EQUAL);
        members.put("notequal", NOTEQUAL);
        members.put("lowerthan", LOWERTHAN);
        members.put("lowerequal", LOWEREQUAL);
        members.put("greaterthan", GREATERTHAN);
        members.put("greaterequal", GREATEREQUAL);
        members.put("contains", CONTAINS);
        members.put("notcontains", NOTCONTAINS);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this PropertyoperatorTyp
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new PropertyoperatorType based on the given String
     * value.
     * @param string
    **/
    public static org.cocons.uml.ccl.ccldata.types.PropertyoperatorType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid PropertyoperatorType";
            throw new IllegalArgumentException(err);
        }
        return (PropertyoperatorType) obj;
    } //-- org.cocons.uml.ccl.ccldata.types.PropertyoperatorType valueOf(java.lang.String) 

}
