/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ReferenceType.java,v 1.1 2002/03/19 18:56:06 ali Exp $
 */

package de.fhg.isst.ComponentML;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 *     The component-impl-ref element describes 
 *     a reference to a possibly remote component implementation
 * which is part
 *     of a deployable component. Specified
 *     properties will be compared to given ones in the referenced
 * spec.
 *     Used in: component.
 *    
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:06 $
**/
public abstract class ReferenceType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _URL;

    /**
     * 
     *     The properties element specifies a sequence of key-value
     * pairs to
     *     contain any information about its parent element.
     *     Used in: component-identifier, import, export, method,
     * type.
     *    
    **/
    private Properties _properties;


      //----------------/
     //- Constructors -/
    //----------------/

    public ReferenceType() {
        super();
    } //-- de.fhg.isst.ComponentML.ReferenceType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public Properties getProperties()
    {
        return this._properties;
    } //-- Properties getProperties() 

    /**
    **/
    public java.lang.String getURL()
    {
        return this._URL;
    } //-- java.lang.String getURL() 

    /**
    **/
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * 
     * @param out
    **/
    public abstract void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException;

    /**
     * 
     * @param handler
    **/
    public abstract void marshal(org.xml.sax.DocumentHandler handler)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException;

    /**
     * 
     * @param properties
    **/
    public void setProperties(Properties properties)
    {
        this._properties = properties;
    } //-- void setProperties(Properties) 

    /**
     * 
     * @param URL
    **/
    public void setURL(java.lang.String URL)
    {
        this._URL = URL;
    } //-- void setURL(java.lang.String) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
