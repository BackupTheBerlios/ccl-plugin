/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ContainerTypeType.java,v 1.1 2003/07/12 18:21:48 layekers Exp $
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
 * ContainerTypeType 
 *     element.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:48 $
**/
public class ContainerTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The array type
    **/
    public static final int ARRAY_TYPE = 0;

    /**
     * The instance of the array type
    **/
    public static final ContainerTypeType ARRAY = new ContainerTypeType(ARRAY_TYPE, "array");

    /**
     * The collection type
    **/
    public static final int COLLECTION_TYPE = 1;

    /**
     * The instance of the collection type
    **/
    public static final ContainerTypeType COLLECTION = new ContainerTypeType(COLLECTION_TYPE, "collection");

    /**
     * The none type
    **/
    public static final int NONE_TYPE = 2;

    /**
     * The instance of the none type
    **/
    public static final ContainerTypeType NONE = new ContainerTypeType(NONE_TYPE, "none");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private ContainerTypeType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- de.fhg.isst.ComponentML.types.ContainerTypeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of
     * ContainerTypeType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this ContainerTypeType
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
        members.put("array", ARRAY);
        members.put("collection", COLLECTION);
        members.put("none", NONE);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this ContainerTypeType
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new ContainerTypeType based on the given String
     * value.
     * @param string
    **/
    public static de.fhg.isst.ComponentML.types.ContainerTypeType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid ContainerTypeType";
            throw new IllegalArgumentException(err);
        }
        return (ContainerTypeType) obj;
    } //-- de.fhg.isst.ComponentML.types.ContainerTypeType valueOf(java.lang.String) 

}
