/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: IOType.java,v 1.1 2003/07/12 18:21:48 layekers Exp $
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
 *     Collection of legal elements for the specification of an
 * IOType 
 *     element.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:48 $
**/
public class IOType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The in type
    **/
    public static final int IN_TYPE = 0;

    /**
     * The instance of the in type
    **/
    public static final IOType IN = new IOType(IN_TYPE, "in");

    /**
     * The out type
    **/
    public static final int OUT_TYPE = 1;

    /**
     * The instance of the out type
    **/
    public static final IOType OUT = new IOType(OUT_TYPE, "out");

    /**
     * The inout type
    **/
    public static final int INOUT_TYPE = 2;

    /**
     * The instance of the inout type
    **/
    public static final IOType INOUT = new IOType(INOUT_TYPE, "inout");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private IOType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- de.fhg.isst.ComponentML.types.IOType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of IOType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this IOType
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
        members.put("in", IN);
        members.put("out", OUT);
        members.put("inout", INOUT);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this IOType
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new IOType based on the given String value.
     * @param string
    **/
    public static de.fhg.isst.ComponentML.types.IOType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid IOType";
            throw new IllegalArgumentException(err);
        }
        return (IOType) obj;
    } //-- de.fhg.isst.ComponentML.types.IOType valueOf(java.lang.String) 

}
