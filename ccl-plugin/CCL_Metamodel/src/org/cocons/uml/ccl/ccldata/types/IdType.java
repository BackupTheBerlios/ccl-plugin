/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: IdType.java,v 1.3 2002/02/09 18:47:50 ali Exp $
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
 * @version $Revision: 1.3 $ $Date: 2002/02/09 18:47:50 $
**/
public class IdType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The target type
    **/
    public static final int TARGET_TYPE = 0;

    /**
     * The instance of the target type
    **/
    public static final IdType TARGET = new IdType(TARGET_TYPE, "target");

    /**
     * The scope type
    **/
    public static final int SCOPE_TYPE = 1;

    /**
     * The instance of the scope type
    **/
    public static final IdType SCOPE = new IdType(SCOPE_TYPE, "scope");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private IdType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- org.cocons.uml.ccl.ccldata.types.IdType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of IdType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this IdType
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
        members.put("target", TARGET);
        members.put("scope", SCOPE);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this IdType
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new IdType based on the given String value.
     * @param string
    **/
    public static org.cocons.uml.ccl.ccldata.types.IdType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid IdType";
            throw new IllegalArgumentException(err);
        }
        return (IdType) obj;
    } //-- org.cocons.uml.ccl.ccldata.types.IdType valueOf(java.lang.String) 

}
