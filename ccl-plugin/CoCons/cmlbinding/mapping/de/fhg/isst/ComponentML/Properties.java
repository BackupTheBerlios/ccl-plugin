/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: Properties.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
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
 *     The properties element specifies a sequence of key-value
 * pairs to
 *     contain any information about its parent element.
 *     Used in: component-identifier, import, export, method, type.
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class Properties implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     A property Element describes a name-value pair.
     *     Used in: properties.
     *    
    **/
    private java.util.Vector _propertyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Properties() {
        super();
        _propertyList = new Vector();
    } //-- de.fhg.isst.ComponentML.Properties()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vProperty
    **/
    public void addProperty(Property vProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _propertyList.addElement(vProperty);
    } //-- void addProperty(Property) 

    /**
     * 
     * @param index
     * @param vProperty
    **/
    public void addProperty(int index, Property vProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _propertyList.insertElementAt(vProperty, index);
    } //-- void addProperty(int, Property) 

    /**
    **/
    public java.util.Enumeration enumerateProperty()
    {
        return _propertyList.elements();
    } //-- java.util.Enumeration enumerateProperty() 

    /**
     * 
     * @param index
    **/
    public Property getProperty(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _propertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (Property) _propertyList.elementAt(index);
    } //-- Property getProperty(int) 

    /**
    **/
    public Property[] getProperty()
    {
        int size = _propertyList.size();
        Property[] mArray = new Property[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Property) _propertyList.elementAt(index);
        }
        return mArray;
    } //-- Property[] getProperty() 

    /**
    **/
    public int getPropertyCount()
    {
        return _propertyList.size();
    } //-- int getPropertyCount() 

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
    public void removeAllProperty()
    {
        _propertyList.removeAllElements();
    } //-- void removeAllProperty() 

    /**
     * 
     * @param index
    **/
    public Property removeProperty(int index)
    {
        Object obj = _propertyList.elementAt(index);
        _propertyList.removeElementAt(index);
        return (Property) obj;
    } //-- Property removeProperty(int) 

    /**
     * 
     * @param index
     * @param vProperty
    **/
    public void setProperty(int index, Property vProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _propertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _propertyList.setElementAt(vProperty, index);
    } //-- void setProperty(int, Property) 

    /**
     * 
     * @param propertyArray
    **/
    public void setProperty(Property[] propertyArray)
    {
        //-- copy array
        _propertyList.removeAllElements();
        for (int i = 0; i < propertyArray.length; i++) {
            _propertyList.addElement(propertyArray[i]);
        }
    } //-- void setProperty(Property) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.Properties unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.Properties) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.Properties.class, reader);
    } //-- de.fhg.isst.ComponentML.Properties unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
