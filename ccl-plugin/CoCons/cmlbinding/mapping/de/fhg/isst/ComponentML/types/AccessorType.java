/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: AccessorType.java,v 1.1 2002/03/19 18:56:08 ali Exp $
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
 * AccessorType 
 *     element.
 *    
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:08 $
**/
public class AccessorType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The read type
    **/
    public static final int READ_TYPE = 0;

    /**
     * The instance of the read type
    **/
    public static final AccessorType READ = new AccessorType(READ_TYPE, "read");

    /**
     * The write type
    **/
    public static final int WRITE_TYPE = 1;

    /**
     * The instance of the write type
    **/
    public static final AccessorType WRITE = new AccessorType(WRITE_TYPE, "write");

    /**
     * The access type
    **/
    public static final int ACCESS_TYPE = 2;

    /**
     * The instance of the access type
    **/
    public static final AccessorType ACCESS = new AccessorType(ACCESS_TYPE, "access");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private AccessorType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- de.fhg.isst.ComponentML.types.AccessorType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of
     * AccessorType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this AccessorType
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
        members.put("read", READ);
        members.put("write", WRITE);
        members.put("access", ACCESS);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this AccessorType
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new AccessorType based on the given String value.
     * @param string
    **/
    public static de.fhg.isst.ComponentML.types.AccessorType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid AccessorType";
            throw new IllegalArgumentException(err);
        }
        return (AccessorType) obj;
    } //-- de.fhg.isst.ComponentML.types.AccessorType valueOf(java.lang.String) 

}
