/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: SecurityRequirements.java,v 1.1 2002/03/19 18:56:06 ali Exp $
 */

package de.fhg.isst.ComponentML;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 *     The security-requirements element specifies a collection of 
 *     secuirty requirements.
 *     Used in: runtime-environment.
 *    
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:06 $
**/
public class SecurityRequirements implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The security-requirement element specifies a single 
     *     security requirement.
     *     Used in: security-requirements.
     *    
    **/
    private java.util.Vector _securityRequirementList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SecurityRequirements() {
        super();
        _securityRequirementList = new Vector();
    } //-- de.fhg.isst.ComponentML.SecurityRequirements()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vSecurityRequirement
    **/
    public void addSecurityRequirement(SecurityRequirement vSecurityRequirement)
        throws java.lang.IndexOutOfBoundsException
    {
        _securityRequirementList.addElement(vSecurityRequirement);
    } //-- void addSecurityRequirement(SecurityRequirement) 

    /**
     * 
     * @param index
     * @param vSecurityRequirement
    **/
    public void addSecurityRequirement(int index, SecurityRequirement vSecurityRequirement)
        throws java.lang.IndexOutOfBoundsException
    {
        _securityRequirementList.insertElementAt(vSecurityRequirement, index);
    } //-- void addSecurityRequirement(int, SecurityRequirement) 

    /**
    **/
    public java.util.Enumeration enumerateSecurityRequirement()
    {
        return _securityRequirementList.elements();
    } //-- java.util.Enumeration enumerateSecurityRequirement() 

    /**
     * 
     * @param index
    **/
    public SecurityRequirement getSecurityRequirement(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _securityRequirementList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (SecurityRequirement) _securityRequirementList.elementAt(index);
    } //-- SecurityRequirement getSecurityRequirement(int) 

    /**
    **/
    public SecurityRequirement[] getSecurityRequirement()
    {
        int size = _securityRequirementList.size();
        SecurityRequirement[] mArray = new SecurityRequirement[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (SecurityRequirement) _securityRequirementList.elementAt(index);
        }
        return mArray;
    } //-- SecurityRequirement[] getSecurityRequirement() 

    /**
    **/
    public int getSecurityRequirementCount()
    {
        return _securityRequirementList.size();
    } //-- int getSecurityRequirementCount() 

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
    **/
    public void removeAllSecurityRequirement()
    {
        _securityRequirementList.removeAllElements();
    } //-- void removeAllSecurityRequirement() 

    /**
     * 
     * @param index
    **/
    public SecurityRequirement removeSecurityRequirement(int index)
    {
        Object obj = _securityRequirementList.elementAt(index);
        _securityRequirementList.removeElementAt(index);
        return (SecurityRequirement) obj;
    } //-- SecurityRequirement removeSecurityRequirement(int) 

    /**
     * 
     * @param index
     * @param vSecurityRequirement
    **/
    public void setSecurityRequirement(int index, SecurityRequirement vSecurityRequirement)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _securityRequirementList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _securityRequirementList.setElementAt(vSecurityRequirement, index);
    } //-- void setSecurityRequirement(int, SecurityRequirement) 

    /**
     * 
     * @param securityRequirementArray
    **/
    public void setSecurityRequirement(SecurityRequirement[] securityRequirementArray)
    {
        //-- copy array
        _securityRequirementList.removeAllElements();
        for (int i = 0; i < securityRequirementArray.length; i++) {
            _securityRequirementList.addElement(securityRequirementArray[i]);
        }
    } //-- void setSecurityRequirement(SecurityRequirement) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.SecurityRequirements unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.SecurityRequirements) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.SecurityRequirements.class, reader);
    } //-- de.fhg.isst.ComponentML.SecurityRequirements unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
