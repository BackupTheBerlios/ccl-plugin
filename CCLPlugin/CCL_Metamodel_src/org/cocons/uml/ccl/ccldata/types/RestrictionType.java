/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: RestrictionType.java,v 1.1 2003/07/12 18:21:54 layekers Exp $
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
public class RestrictionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The Components type
    **/
    public static final int COMPONENTS_TYPE = 0;

    /**
     * The instance of the Components type
    **/
    public static final RestrictionType COMPONENTS = new RestrictionType(COMPONENTS_TYPE, "Components");

    /**
     * The BusinessTypes type
    **/
    public static final int BUSINESSTYPES_TYPE = 1;

    /**
     * The instance of the BusinessTypes type
    **/
    public static final RestrictionType BUSINESSTYPES = new RestrictionType(BUSINESSTYPES_TYPE, "BusinessTypes");

    /**
     * The Interfaces type
    **/
    public static final int INTERFACES_TYPE = 2;

    /**
     * The instance of the Interfaces type
    **/
    public static final RestrictionType INTERFACES = new RestrictionType(INTERFACES_TYPE, "Interfaces");

    /**
     * The Computers type
    **/
    public static final int COMPUTERS_TYPE = 3;

    /**
     * The instance of the Computers type
    **/
    public static final RestrictionType COMPUTERS = new RestrictionType(COMPUTERS_TYPE, "Computers");

    /**
     * The Containers type
    **/
    public static final int CONTAINERS_TYPE = 4;

    /**
     * The instance of the Containers type
    **/
    public static final RestrictionType CONTAINERS = new RestrictionType(CONTAINERS_TYPE, "Containers");

    /**
     * The InfoTypes type
    **/
    public static final int INFOTYPES_TYPE = 5;

    /**
     * The instance of the InfoTypes type
    **/
    public static final RestrictionType INFOTYPES = new RestrictionType(INFOTYPES_TYPE, "InfoTypes");

    /**
     * The Elements type
    **/
    public static final int ELEMENTS_TYPE = 6;

    /**
     * The instance of the Elements type
    **/
    public static final RestrictionType ELEMENTS = new RestrictionType(ELEMENTS_TYPE, "Elements");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private RestrictionType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- org.cocons.uml.ccl.ccldata.types.RestrictionType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of
     * RestrictionType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this RestrictionType
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
        members.put("Components", COMPONENTS);
        members.put("BusinessTypes", BUSINESSTYPES);
        members.put("Interfaces", INTERFACES);
        members.put("Computers", COMPUTERS);
        members.put("Containers", CONTAINERS);
        members.put("InfoTypes", INFOTYPES);
        members.put("Elements", ELEMENTS);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this RestrictionType
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new RestrictionType based on the given String
     * value.
     * @param string
    **/
    public static org.cocons.uml.ccl.ccldata.types.RestrictionType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid RestrictionType";
            throw new IllegalArgumentException(err);
        }
        return (RestrictionType) obj;
    } //-- org.cocons.uml.ccl.ccldata.types.RestrictionType valueOf(java.lang.String) 

}
