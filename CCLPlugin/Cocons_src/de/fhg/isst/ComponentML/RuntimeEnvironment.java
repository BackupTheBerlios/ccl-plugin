/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: RuntimeEnvironment.java,v 1.1 2003/07/12 18:21:47 layekers Exp $
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
 *     The runtime-environment element contains a collection 
 *     of runtime-requirements like transaction behaviour, security
 * 
 *     requiremente etc needed by the specified  component to work
 * properly.
 *     Used in. component-spec.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:47 $
**/
public class RuntimeEnvironment implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The parameter-section element describes a set of
     * parameters used to 
     *     parametrize that component.
     *     Used in: component-spec.
     *    
    **/
    private ParameterSection _parameterSection;

    /**
     * 
     *     The external-resources element describes a collection of
     * external 
     *     resources needed by the specified component to work
     * properly.
     *     Used in: component-spec.
     *    
    **/
    private ExternalResources _externalResources;

    /**
     * 
     *     The security-requirements element specifies a collection
     * of 
     *     secuirty requirements.
     *     Used in: runtime-environment.
     *    
    **/
    private SecurityRequirements _securityRequirements;

    /**
     * 
     *     The txn-requrements element specifies a collection of 
     *     txn-requirements.
     *     Used in: runtime-environment.
     *    
    **/
    private TxnRequirements _txnRequirements;


      //----------------/
     //- Constructors -/
    //----------------/

    public RuntimeEnvironment() {
        super();
    } //-- de.fhg.isst.ComponentML.RuntimeEnvironment()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public ExternalResources getExternalResources()
    {
        return this._externalResources;
    } //-- ExternalResources getExternalResources() 

    /**
    **/
    public ParameterSection getParameterSection()
    {
        return this._parameterSection;
    } //-- ParameterSection getParameterSection() 

    /**
    **/
    public SecurityRequirements getSecurityRequirements()
    {
        return this._securityRequirements;
    } //-- SecurityRequirements getSecurityRequirements() 

    /**
    **/
    public TxnRequirements getTxnRequirements()
    {
        return this._txnRequirements;
    } //-- TxnRequirements getTxnRequirements() 

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
     * @param externalResources
    **/
    public void setExternalResources(ExternalResources externalResources)
    {
        this._externalResources = externalResources;
    } //-- void setExternalResources(ExternalResources) 

    /**
     * 
     * @param parameterSection
    **/
    public void setParameterSection(ParameterSection parameterSection)
    {
        this._parameterSection = parameterSection;
    } //-- void setParameterSection(ParameterSection) 

    /**
     * 
     * @param securityRequirements
    **/
    public void setSecurityRequirements(SecurityRequirements securityRequirements)
    {
        this._securityRequirements = securityRequirements;
    } //-- void setSecurityRequirements(SecurityRequirements) 

    /**
     * 
     * @param txnRequirements
    **/
    public void setTxnRequirements(TxnRequirements txnRequirements)
    {
        this._txnRequirements = txnRequirements;
    } //-- void setTxnRequirements(TxnRequirements) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.RuntimeEnvironment unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.RuntimeEnvironment) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.RuntimeEnvironment.class, reader);
    } //-- de.fhg.isst.ComponentML.RuntimeEnvironment unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
