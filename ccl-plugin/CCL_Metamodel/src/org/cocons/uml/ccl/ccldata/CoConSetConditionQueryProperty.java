/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConSetConditionQueryProperty.java,v 1.1 2002/02/06 12:11:20 ali Exp $
 */

package org.cocons.uml.ccl.ccldata;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.cocons.uml.ccl.ccldata.types.OperatorType;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 * @version $Revision: 1.1 $ $Date: 2002/02/06 12:11:20 $
**/
public class CoConSetConditionQueryProperty implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _property;

    private org.cocons.uml.ccl.ccldata.types.OperatorType _operator;

    private java.lang.String _targetproperty;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConSetConditionQueryProperty() {
        super();
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionQueryProperty()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public org.cocons.uml.ccl.ccldata.types.OperatorType getOperator()
    {
        return this._operator;
    } //-- org.cocons.uml.ccl.ccldata.types.OperatorType getOperator() 

    /**
    **/
    public java.lang.String getProperty()
    {
        return this._property;
    } //-- java.lang.String getProperty() 

    /**
    **/
    public java.lang.String getTargetproperty()
    {
        return this._targetproperty;
    } //-- java.lang.String getTargetproperty() 

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
     * @param operator
    **/
    public void setOperator(org.cocons.uml.ccl.ccldata.types.OperatorType operator)
    {
        this._operator = operator;
    } //-- void setOperator(org.cocons.uml.ccl.ccldata.types.OperatorType) 

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
     * @param targetproperty
    **/
    public void setTargetproperty(java.lang.String targetproperty)
    {
        this._targetproperty = targetproperty;
    } //-- void setTargetproperty(java.lang.String) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.ccldata.CoConSetConditionQueryProperty unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionQueryProperty) Unmarshaller.unmarshal(org.cocons.uml.ccl.ccldata.CoConSetConditionQueryProperty.class, reader);
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionQueryProperty unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
