/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConSetConditionChoice.java,v 1.1 2003/07/12 18:21:54 layekers Exp $
 */

package org.cocons.uml.ccl.ccldata;

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
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:54 $
**/
public class CoConSetConditionChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private CoConSetConditionQuerySingleValue _coConSetConditionQuerySingleValue;

    private CoConSetConditionQuerySet _coConSetConditionQuerySet;

    private CoConSetConditionQueryProperty _coConSetConditionQueryProperty;

    private CoConSetConditionUnion _coConSetConditionUnion;

    private CoConSetConditionIntersection _coConSetConditionIntersection;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConSetConditionChoice() {
        super();
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionChoice()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public CoConSetConditionIntersection getCoConSetConditionIntersection()
    {
        return this._coConSetConditionIntersection;
    } //-- CoConSetConditionIntersection getCoConSetConditionIntersection() 

    /**
    **/
    public CoConSetConditionQueryProperty getCoConSetConditionQueryProperty()
    {
        return this._coConSetConditionQueryProperty;
    } //-- CoConSetConditionQueryProperty getCoConSetConditionQueryProperty() 

    /**
    **/
    public CoConSetConditionQuerySet getCoConSetConditionQuerySet()
    {
        return this._coConSetConditionQuerySet;
    } //-- CoConSetConditionQuerySet getCoConSetConditionQuerySet() 

    /**
    **/
    public CoConSetConditionQuerySingleValue getCoConSetConditionQuerySingleValue()
    {
        return this._coConSetConditionQuerySingleValue;
    } //-- CoConSetConditionQuerySingleValue getCoConSetConditionQuerySingleValue() 

    /**
    **/
    public CoConSetConditionUnion getCoConSetConditionUnion()
    {
        return this._coConSetConditionUnion;
    } //-- CoConSetConditionUnion getCoConSetConditionUnion() 

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
     * @param coConSetConditionIntersection
    **/
    public void setCoConSetConditionIntersection(CoConSetConditionIntersection coConSetConditionIntersection)
    {
        this._coConSetConditionIntersection = coConSetConditionIntersection;
    } //-- void setCoConSetConditionIntersection(CoConSetConditionIntersection) 

    /**
     * 
     * @param coConSetConditionQueryProperty
    **/
    public void setCoConSetConditionQueryProperty(CoConSetConditionQueryProperty coConSetConditionQueryProperty)
    {
        this._coConSetConditionQueryProperty = coConSetConditionQueryProperty;
    } //-- void setCoConSetConditionQueryProperty(CoConSetConditionQueryProperty) 

    /**
     * 
     * @param coConSetConditionQuerySet
    **/
    public void setCoConSetConditionQuerySet(CoConSetConditionQuerySet coConSetConditionQuerySet)
    {
        this._coConSetConditionQuerySet = coConSetConditionQuerySet;
    } //-- void setCoConSetConditionQuerySet(CoConSetConditionQuerySet) 

    /**
     * 
     * @param coConSetConditionQuerySingleValue
    **/
    public void setCoConSetConditionQuerySingleValue(CoConSetConditionQuerySingleValue coConSetConditionQuerySingleValue)
    {
        this._coConSetConditionQuerySingleValue = coConSetConditionQuerySingleValue;
    } //-- void setCoConSetConditionQuerySingleValue(CoConSetConditionQuerySingleValue) 

    /**
     * 
     * @param coConSetConditionUnion
    **/
    public void setCoConSetConditionUnion(CoConSetConditionUnion coConSetConditionUnion)
    {
        this._coConSetConditionUnion = coConSetConditionUnion;
    } //-- void setCoConSetConditionUnion(CoConSetConditionUnion) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.ccldata.CoConSetConditionChoice unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionChoice) Unmarshaller.unmarshal(org.cocons.uml.ccl.ccldata.CoConSetConditionChoice.class, reader);
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionChoice unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
