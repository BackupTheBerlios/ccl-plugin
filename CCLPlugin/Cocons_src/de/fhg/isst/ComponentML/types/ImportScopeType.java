/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ImportScopeType.java,v 1.1 2003/07/12 18:21:48 layekers Exp $
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
 * ImportScopeType 
 *     element.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:48 $
**/
public class ImportScopeType implements java.io.Serializable {


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
    public static final ImportScopeType LOCAL = new ImportScopeType(LOCAL_TYPE, "local");

    /**
     * The remote type
    **/
    public static final int REMOTE_TYPE = 1;

    /**
     * The instance of the remote type
    **/
    public static final ImportScopeType REMOTE = new ImportScopeType(REMOTE_TYPE, "remote");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private ImportScopeType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- de.fhg.isst.ComponentML.types.ImportScopeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of
     * ImportScopeType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this ImportScopeType
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
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this ImportScopeType
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new ImportScopeType based on the given String
     * value.
     * @param string
    **/
    public static de.fhg.isst.ComponentML.types.ImportScopeType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid ImportScopeType";
            throw new IllegalArgumentException(err);
        }
        return (ImportScopeType) obj;
    } //-- de.fhg.isst.ComponentML.types.ImportScopeType valueOf(java.lang.String) 

}
