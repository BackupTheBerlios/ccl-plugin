/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConSetConditionQuerySingleValue.java,v 1.3 2002/02/09 18:47:49 ali Exp $
 */

package org.cocons.uml.ccl.ccldata;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.cocons.uml.ccl.ccldata.types.SingleoperatorType;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 * @version $Revision: 1.3 $ $Date: 2002/02/09 18:47:49 $
**/
public class CoConSetConditionQuerySingleValue implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _property;

    private org.cocons.uml.ccl.ccldata.types.SingleoperatorType _singleoperator;

    private java.lang.String _value;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConSetConditionQuerySingleValue() {
        super();
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySingleValue()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public java.lang.String getProperty()
    {
        return this._property;
    } //-- java.lang.String getProperty() 

    /**
    **/
    public org.cocons.uml.ccl.ccldata.types.SingleoperatorType getSingleoperator()
    {
        return this._singleoperator;
    } //-- org.cocons.uml.ccl.ccldata.types.SingleoperatorType getSingleoperator() 

    /**
    **/
    public java.lang.String getValue()
    {
        return this._value;
    } //-- java.lang.String getValue() 

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
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * 
     * @param handler
    **/
    public void marshal(org.xml.sax.DocumentHandler handler)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.DocumentHandler) 

    /**
     * 
     * @param property
    **/
    public void setProperty(java.lang.String property)
    {
        this._property = property;
    } //-- void setProperty(java.lang.String) 

    /**
     * 
     * @param singleoperator
    **/
    public void setSingleoperator(org.cocons.uml.ccl.ccldata.types.SingleoperatorType singleoperator)
    {
        this._singleoperator = singleoperator;
    } //-- void setSingleoperator(org.cocons.uml.ccl.ccldata.types.SingleoperatorType) 

    /**
     * 
     * @param value
    **/
    public void setValue(java.lang.String value)
    {
        this._value = value;
    } //-- void setValue(java.lang.String) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySingleValue unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySingleValue) Unmarshaller.unmarshal(org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySingleValue.class, reader);
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySingleValue unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
