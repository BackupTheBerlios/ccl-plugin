/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ExternalResources.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
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
 *     The external-resources element describes a collection of
 * external 
 *     resources needed by the specified component to work
 * properly.
 *     Used in: component-spec.
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class ExternalResources implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The resource element describes a single resource.
     *     To be specified later.
     *     Used in: resource-section.
     *    
    **/
    private java.util.Vector _resourceList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ExternalResources() {
        super();
        _resourceList = new Vector();
    } //-- de.fhg.isst.ComponentML.ExternalResources()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vResource
    **/
    public void addResource(Resource vResource)
        throws java.lang.IndexOutOfBoundsException
    {
        _resourceList.addElement(vResource);
    } //-- void addResource(Resource) 

    /**
     * 
     * @param index
     * @param vResource
    **/
    public void addResource(int index, Resource vResource)
        throws java.lang.IndexOutOfBoundsException
    {
        _resourceList.insertElementAt(vResource, index);
    } //-- void addResource(int, Resource) 

    /**
    **/
    public java.util.Enumeration enumerateResource()
    {
        return _resourceList.elements();
    } //-- java.util.Enumeration enumerateResource() 

    /**
     * 
     * @param index
    **/
    public Resource getResource(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _resourceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (Resource) _resourceList.elementAt(index);
    } //-- Resource getResource(int) 

    /**
    **/
    public Resource[] getResource()
    {
        int size = _resourceList.size();
        Resource[] mArray = new Resource[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Resource) _resourceList.elementAt(index);
        }
        return mArray;
    } //-- Resource[] getResource() 

    /**
    **/
    public int getResourceCount()
    {
        return _resourceList.size();
    } //-- int getResourceCount() 

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
    public void removeAllResource()
    {
        _resourceList.removeAllElements();
    } //-- void removeAllResource() 

    /**
     * 
     * @param index
    **/
    public Resource removeResource(int index)
    {
        Object obj = _resourceList.elementAt(index);
        _resourceList.removeElementAt(index);
        return (Resource) obj;
    } //-- Resource removeResource(int) 

    /**
     * 
     * @param index
     * @param vResource
    **/
    public void setResource(int index, Resource vResource)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _resourceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _resourceList.setElementAt(vResource, index);
    } //-- void setResource(int, Resource) 

    /**
     * 
     * @param resourceArray
    **/
    public void setResource(Resource[] resourceArray)
    {
        //-- copy array
        _resourceList.removeAllElements();
        for (int i = 0; i < resourceArray.length; i++) {
            _resourceList.addElement(resourceArray[i]);
        }
    } //-- void setResource(Resource) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ExternalResources unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ExternalResources) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ExternalResources.class, reader);
    } //-- de.fhg.isst.ComponentML.ExternalResources unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
