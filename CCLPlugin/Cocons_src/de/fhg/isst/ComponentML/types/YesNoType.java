/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: YesNoType.java,v 1.1 2003/07/12 18:21:48 layekers Exp $
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
 * YesNoType 
 *     element.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:48 $
**/
public class YesNoType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The yes type
    **/
    public static final int YES_TYPE = 0;

    /**
     * The instance of the yes type
    **/
    public static final YesNoType YES = new YesNoType(YES_TYPE, "yes");

    /**
     * The no type
    **/
    public static final int NO_TYPE = 1;

    /**
     * The instance of the no type
    **/
    public static final YesNoType NO = new YesNoType(NO_TYPE, "no");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private YesNoType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- de.fhg.isst.ComponentML.types.YesNoType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of YesNoType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this YesNoType
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
        members.put("yes", YES);
        members.put("no", NO);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this YesNoType
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new YesNoType based on the given String value.
     * @param string
    **/
    public static de.fhg.isst.ComponentML.types.YesNoType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid YesNoType";
            throw new IllegalArgumentException(err);
        }
        return (YesNoType) obj;
    } //-- de.fhg.isst.ComponentML.types.YesNoType valueOf(java.lang.String) 

}
