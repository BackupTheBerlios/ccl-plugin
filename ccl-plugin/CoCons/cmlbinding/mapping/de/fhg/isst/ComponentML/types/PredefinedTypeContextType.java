/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: PredefinedTypeContextType.java,v 1.1 2002/03/19 18:56:08 ali Exp $
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
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:08 $
**/
public class PredefinedTypeContextType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The JAVA type
    **/
    public static final int JAVA_TYPE = 0;

    /**
     * The instance of the JAVA type
    **/
    public static final PredefinedTypeContextType JAVA = new PredefinedTypeContextType(JAVA_TYPE, "JAVA");

    private static java.util.Hashtable _memberTable = init();

    private int type = -1;

    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private PredefinedTypeContextType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- de.fhg.isst.ComponentML.types.PredefinedTypeContextType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns an enumeration of all possible instances of
     * PredefinedTypeContextType
    **/
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Returns the type of this PredefinedTypeContextType
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
        members.put("JAVA", JAVA);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Returns the String representation of this
     * PredefinedTypeContextType
    **/
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Returns a new PredefinedTypeContextType based on the given
     * String value.
     * @param string
    **/
    public static de.fhg.isst.ComponentML.types.PredefinedTypeContextType valueOf(java.lang.String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid PredefinedTypeContextType";
            throw new IllegalArgumentException(err);
        }
        return (PredefinedTypeContextType) obj;
    } //-- de.fhg.isst.ComponentML.types.PredefinedTypeContextType valueOf(java.lang.String) 

}
