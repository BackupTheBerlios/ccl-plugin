/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConSetConditionRestriction.java,v 1.3 2002/02/09 18:47:49 ali Exp $
 */

package org.cocons.uml.ccl.ccldata;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.cocons.uml.ccl.ccldata.types.RestrictionType;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 * @version $Revision: 1.3 $ $Date: 2002/02/09 18:47:49 $
**/
public class CoConSetConditionRestriction implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private org.cocons.uml.ccl.ccldata.types.RestrictionType _restriction;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConSetConditionRestriction() {
        super();
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionRestriction()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public org.cocons.uml.ccl.ccldata.types.RestrictionType getRestriction()
    {
        return this._restriction;
    } //-- org.cocons.uml.ccl.ccldata.types.RestrictionType getRestriction() 

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
     * @param restriction
    **/
    public void setRestriction(org.cocons.uml.ccl.ccldata.types.RestrictionType restriction)
    {
        this._restriction = restriction;
    } //-- void setRestriction(org.cocons.uml.ccl.ccldata.types.RestrictionType) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.ccldata.CoConSetConditionRestriction unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionRestriction) Unmarshaller.unmarshal(org.cocons.uml.ccl.ccldata.CoConSetConditionRestriction.class, reader);
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionRestriction unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
