/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ExportScopeType.java,v 1.1 2002/03/19 18:56:08 ali Exp $
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
 * ExportScopeType 
 *     element.
 *    
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:08 $
**/
public class ExportScopeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The local type
    **/
    public static final int LOCAL_TYPE = 0;

    /**
     * The instance of the local type
    **/
    public static final ExportScopeType LOCAL = new ExportScopeType(LOCAL_TYPE, "local");

    /**
     * The remote type
    **/
    public static final int REMOTE_TYPE = 1;

    /**
     * The instance of the remote type
    **/
    public static final ExportScopeType REMOTE = new ExportScopeType(REMOTE_TYPE, "remote");

    /**
     * The full type
    **/
    public static final int FULL_TYPE = 2;

    /**
     * The instance of the full type
    **/
    public static final ExportScopeType FULL = new ExportScopeType(FULL_TYPE, "full");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private ExportScopeType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- de.fhg.isst.ComponentML.types.ExportScopeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of
     * ExportScopeType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this ExportScopeType
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
        members.put("local", LOCAL);
        members.put("remote", REMOTE);
        members.put("full", FULL);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this ExportScopeType
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new ExportScopeType based on the given String
     * value.
     * @param string
    **/
    public static de.fhg.isst.ComponentML.types.ExportScopeType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid ExportScopeType";
            throw new IllegalArgumentException(err);
        }
        return (ExportScopeType) obj;
    } //-- de.fhg.isst.ComponentML.types.ExportScopeType valueOf(java.lang.String) 

}
