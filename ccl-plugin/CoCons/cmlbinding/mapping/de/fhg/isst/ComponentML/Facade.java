/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: Facade.java,v 1.1 2002/03/19 18:56:06 ali Exp $
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
 *     The facade element describes an individual component facade.
 *     Used in: export-section.
 *    
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:06 $
**/
public class Facade implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _facadeName;

    /**
     * 
     *     The business-export element specifies a collection 
     * methods
     *     exported by the specified component.
     *     Used in: export-section.
     *    
    **/
    private java.util.Vector _businessExportList;

    /**
     * 
     *     The type-export element specifies a set of types
     * exported by the
     *     specified component.
     *    
    **/
    private TypeExport _typeExport;

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

    public Facade() {
        super();
        _businessExportList = new Vector();
    } //-- de.fhg.isst.ComponentML.Facade()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vBusinessExport
    **/
    public void addBusinessExport(BusinessExport vBusinessExport)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_businessExportList.size() < 3)) {
            throw new IndexOutOfBoundsException();
        }
        _businessExportList.addElement(vBusinessExport);
    } //-- void addBusinessExport(BusinessExport) 

    /**
     * 
     * @param index
     * @param vBusinessExport
    **/
    public void addBusinessExport(int index, BusinessExport vBusinessExport)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_businessExportList.size() < 3)) {
            throw new IndexOutOfBoundsException();
        }
        _businessExportList.insertElementAt(vBusinessExport, index);
    } //-- void addBusinessExport(int, BusinessExport) 

    /**
    **/
    public java.util.Enumeration enumerateBusinessExport()
    {
        return _businessExportList.elements();
    } //-- java.util.Enumeration enumerateBusinessExport() 

    /**
     * 
     * @param index
    **/
    public BusinessExport getBusinessExport(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _businessExportList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (BusinessExport) _businessExportList.elementAt(index);
    } //-- BusinessExport getBusinessExport(int) 

    /**
    **/
    public BusinessExport[] getBusinessExport()
    {
        int size = _businessExportList.size();
        BusinessExport[] mArray = new BusinessExport[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (BusinessExport) _businessExportList.elementAt(index);
        }
        return mArray;
    } //-- BusinessExport[] getBusinessExport() 

    /**
    **/
    public int getBusinessExportCount()
    {
        return _businessExportList.size();
    } //-- int getBusinessExportCount() 

    /**
    **/
    public java.lang.String getFacadeName()
    {
        return this._facadeName;
    } //-- java.lang.String getFacadeName() 

    /**
    **/
    public Properties getProperties()
    {
        return this._properties;
    } //-- Properties getProperties() 

    /**
    **/
    public TypeExport getTypeExport()
    {
        return this._typeExport;
    } //-- TypeExport getTypeExport() 

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
    public void removeAllBusinessExport()
    {
        _businessExportList.removeAllElements();
    } //-- void removeAllBusinessExport() 

    /**
     * 
     * @param index
    **/
    public BusinessExport removeBusinessExport(int index)
    {
        Object obj = _businessExportList.elementAt(index);
        _businessExportList.removeElementAt(index);
        return (BusinessExport) obj;
    } //-- BusinessExport removeBusinessExport(int) 

    /**
     * 
     * @param index
     * @param vBusinessExport
    **/
    public void setBusinessExport(int index, BusinessExport vBusinessExport)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _businessExportList.size())) {
            throw new IndexOutOfBoundsException();
        }
        if (!(index < 3)) {
            throw new IndexOutOfBoundsException();
        }
        _businessExportList.setElementAt(vBusinessExport, index);
    } //-- void setBusinessExport(int, BusinessExport) 

    /**
     * 
     * @param businessExportArray
    **/
    public void setBusinessExport(BusinessExport[] businessExportArray)
    {
        //-- copy array
        _businessExportList.removeAllElements();
        for (int i = 0; i < businessExportArray.length; i++) {
            _businessExportList.addElement(businessExportArray[i]);
        }
    } //-- void setBusinessExport(BusinessExport) 

    /**
     * 
     * @param facadeName
    **/
    public void setFacadeName(java.lang.String facadeName)
    {
        this._facadeName = facadeName;
    } //-- void setFacadeName(java.lang.String) 

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
     * @param typeExport
    **/
    public void setTypeExport(TypeExport typeExport)
    {
        this._typeExport = typeExport;
    } //-- void setTypeExport(TypeExport) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.Facade unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.Facade) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.Facade.class, reader);
    } //-- de.fhg.isst.ComponentML.Facade unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
