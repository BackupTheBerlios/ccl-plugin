/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ConnectorSpecChoice.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
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
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class ConnectorSpecChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence _de_fhg_isst_ComponentML_ConnectorSpecChoiceSequence;

    private de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence2 _de_fhg_isst_ComponentML_ConnectorSpecChoiceSequence2;


      //----------------/
     //- Constructors -/
    //----------------/

    public ConnectorSpecChoice() {
        super();
    } //-- de.fhg.isst.ComponentML.ConnectorSpecChoice()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence getDe_Fhg_Isst_ComponentML_ConnectorSpecChoiceSequence()
    {
        return this._de_fhg_isst_ComponentML_ConnectorSpecChoiceSequence;
    } //-- de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence getDe_Fhg_Isst_ComponentML_ConnectorSpecChoiceSequence() 

    /**
    **/
    public de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence2 getDe_Fhg_Isst_ComponentML_ConnectorSpecChoiceSequence2()
    {
        return this._de_fhg_isst_ComponentML_ConnectorSpecChoiceSequence2;
    } //-- de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence2 getDe_Fhg_Isst_ComponentML_ConnectorSpecChoiceSequence2() 

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
     * @param de_fhg_isst_ComponentML_ConnectorSpecChoiceSequence
    **/
    public void setDe_Fhg_Isst_ComponentML_ConnectorSpecChoiceSequence(de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence de_fhg_isst_ComponentML_ConnectorSpecChoiceSequence)
    {
        this._de_fhg_isst_ComponentML_ConnectorSpecChoiceSequence = de_fhg_isst_ComponentML_ConnectorSpecChoiceSequence;
    } //-- void setDe_Fhg_Isst_ComponentML_ConnectorSpecChoiceSequence(de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence) 

    /**
     * 
     * @param de_fhg_isst_ComponentML_ConnectorSpecChoiceSequence2
    **/
    public void setDe_Fhg_Isst_ComponentML_ConnectorSpecChoiceSequence2(de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence2 de_fhg_isst_ComponentML_ConnectorSpecChoiceSequence2)
    {
        this._de_fhg_isst_ComponentML_ConnectorSpecChoiceSequence2 = de_fhg_isst_ComponentML_ConnectorSpecChoiceSequence2;
    } //-- void setDe_Fhg_Isst_ComponentML_ConnectorSpecChoiceSequence2(de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence2) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ConnectorSpecChoice unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ConnectorSpecChoice) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ConnectorSpecChoice.class, reader);
    } //-- de.fhg.isst.ComponentML.ConnectorSpecChoice unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
