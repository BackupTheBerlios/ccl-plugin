/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: OperatorType.java,v 1.1 2002/02/06 12:11:21 ali Exp $
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
 * @version $Revision: 1.1 $ $Date: 2002/02/06 12:11:21 $
**/
public class OperatorType implements java.io.Serializable {


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
    public static final OperatorType EQUAL = new OperatorType(EQUAL_TYPE, "equal");

    /**
     * The notequal type
    **/
    public static final int NOTEQUAL_TYPE = 1;

    /**
     * The instance of the notequal type
    **/
    public static final OperatorType NOTEQUAL = new OperatorType(NOTEQUAL_TYPE, "notequal");

    /**
     * The lowerthan type
    **/
    public static final int LOWERTHAN_TYPE = 2;

    /**
     * The instance of the lowerthan type
    **/
    public static final OperatorType LOWERTHAN = new OperatorType(LOWERTHAN_TYPE, "lowerthan");

    /**
     * The lowerequal type
    **/
    public static final int LOWEREQUAL_TYPE = 3;

    /**
     * The instance of the lowerequal type
    **/
    public static final OperatorType LOWEREQUAL = new OperatorType(LOWEREQUAL_TYPE, "lowerequal");

    /**
     * The greaterthan type
    **/
    public static final int GREATERTHAN_TYPE = 4;

    /**
     * The instance of the greaterthan type
    **/
    public static final OperatorType GREATERTHAN = new OperatorType(GREATERTHAN_TYPE, "greaterthan");

    /**
     * The greaterequal type
    **/
    public static final int GREATEREQUAL_TYPE = 5;

    /**
     * The instance of the greaterequal type
    **/
    public static final OperatorType GREATEREQUAL = new OperatorType(GREATEREQUAL_TYPE, "greaterequal");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private OperatorType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- org.cocons.uml.ccl.ccldata.types.OperatorType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of
     * OperatorType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this OperatorType
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
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this OperatorType
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new OperatorType based on the given String value.
     * @param string
    **/
    public static org.cocons.uml.ccl.ccldata.types.OperatorType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid OperatorType";
            throw new IllegalArgumentException(err);
        }
        return (OperatorType) obj;
    } //-- org.cocons.uml.ccl.ccldata.types.OperatorType valueOf(java.lang.String) 

}
