/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: SetoperatorType.java,v 1.1 2003/07/12 18:21:54 layekers Exp $
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
public class SetoperatorType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The equal type
    **/
    public static final int EQUAL_TYPE = 0;

    /**
     * The instance of the equal type
    **/
    public static final SetoperatorType EQUAL = new SetoperatorType(EQUAL_TYPE, "equal");

    /**
     * The notequal type
    **/
    public static final int NOTEQUAL_TYPE = 1;

    /**
     * The instance of the notequal type
    **/
    public static final SetoperatorType NOTEQUAL = new SetoperatorType(NOTEQUAL_TYPE, "notequal");

    /**
     * The contains type
    **/
    public static final int CONTAINS_TYPE = 2;

    /**
     * The instance of the contains type
    **/
    public static final SetoperatorType CONTAINS = new SetoperatorType(CONTAINS_TYPE, "contains");

    /**
     * The notcontains type
    **/
    public static final int NOTCONTAINS_TYPE = 3;

    /**
     * The instance of the notcontains type
    **/
    public static final SetoperatorType NOTCONTAINS = new SetoperatorType(NOTCONTAINS_TYPE, "notcontains");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private SetoperatorType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- org.cocons.uml.ccl.ccldata.types.SetoperatorType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of
     * SetoperatorType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this SetoperatorType
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
        members.put("contains", CONTAINS);
        members.put("notcontains", NOTCONTAINS);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this SetoperatorType
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new SetoperatorType based on the given String
     * value.
     * @param string
    **/
    public static org.cocons.uml.ccl.ccldata.types.SetoperatorType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid SetoperatorType";
            throw new IllegalArgumentException(err);
        }
        return (SetoperatorType) obj;
    } //-- org.cocons.uml.ccl.ccldata.types.SetoperatorType valueOf(java.lang.String) 

}
