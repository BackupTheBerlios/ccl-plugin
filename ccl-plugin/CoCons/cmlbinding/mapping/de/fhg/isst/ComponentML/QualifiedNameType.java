/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: QualifiedNameType.java,v 1.1 2002/03/19 18:56:06 ali Exp $
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
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:06 $
**/
public abstract class QualifiedNameType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _alias;

    private java.lang.String _name;

    private java.lang.String _namespace;


      //----------------/
     //- Constructors -/
    //----------------/

    public QualifiedNameType() {
        super();
    } //-- de.fhg.isst.ComponentML.QualifiedNameType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public java.lang.String getAlias()
    {
        return this._alias;
    } //-- java.lang.String getAlias() 

    /**
    **/
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
    **/
    public java.lang.String getNamespace()
    {
        return this._namespace;
    } //-- java.lang.String getNamespace() 

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
     * @param alias
    **/
    public void setAlias(java.lang.String alias)
    {
        this._alias = alias;
    } //-- void setAlias(java.lang.String) 

    /**
     * 
     * @param name
    **/
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * 
     * @param namespace
    **/
    public void setNamespace(java.lang.String namespace)
    {
        this._namespace = namespace;
    } //-- void setNamespace(java.lang.String) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
