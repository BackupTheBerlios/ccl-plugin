/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: Property.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
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
 *     A property Element describes a name-value pair.
 *     Used in: properties.
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class Property implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _description;

    private java.lang.String _key;

    private java.util.Vector _valueList;

    /**
     * 
     *     The constraint element describes a constraint holding
     * for all values 
     *     of a property element.
     *     Used in: property.
     *    
    **/
    private Constraints _constraints;


      //----------------/
     //- Constructors -/
    //----------------/

    public Property() {
        super();
        _valueList = new Vector();
    } //-- de.fhg.isst.ComponentML.Property()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vValue
    **/
    public void addValue(java.lang.String vValue)
        throws java.lang.IndexOutOfBoundsException
    {
        _valueList.addElement(vValue);
    } //-- void addValue(java.lang.String) 

    /**
     * 
     * @param index
     * @param vValue
    **/
    public void addValue(int index, java.lang.String vValue)
        throws java.lang.IndexOutOfBoundsException
    {
        _valueList.insertElementAt(vValue, index);
    } //-- void addValue(int, java.lang.String) 

    /**
    **/
    public java.util.Enumeration enumerateValue()
    {
        return _valueList.elements();
    } //-- java.util.Enumeration enumerateValue() 

    /**
    **/
    public Constraints getConstraints()
    {
        return this._constraints;
    } //-- Constraints getConstraints() 

    /**
    **/
    public java.lang.String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

    /**
    **/
    public java.lang.String getKey()
    {
        return this._key;
    } //-- java.lang.String getKey() 

    /**
     * 
     * @param index
    **/
    public java.lang.String getValue(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _valueList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_valueList.elementAt(index);
    } //-- java.lang.String getValue(int) 

    /**
    **/
    public java.lang.String[] getValue()
    {
        int size = _valueList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_valueList.elementAt(index);
        }
        return mArray;
    } //-- java.lang.String[] getValue() 

    /**
    **/
    public int getValueCount()
    {
        return _valueList.size();
    } //-- int getValueCount() 

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
    public void removeAllValue()
    {
        _valueList.removeAllElements();
    } //-- void removeAllValue() 

    /**
     * 
     * @param index
    **/
    public java.lang.String removeValue(int index)
    {
        Object obj = _valueList.elementAt(index);
        _valueList.removeElementAt(index);
        return (String)obj;
    } //-- java.lang.String removeValue(int) 

    /**
     * 
     * @param constraints
    **/
    public void setConstraints(Constraints constraints)
    {
        this._constraints = constraints;
    } //-- void setConstraints(Constraints) 

    /**
     * 
     * @param description
    **/
    public void setDescription(java.lang.String description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.String) 

    /**
     * 
     * @param key
    **/
    public void setKey(java.lang.String key)
    {
        this._key = key;
    } //-- void setKey(java.lang.String) 

    /**
     * 
     * @param index
     * @param vValue
    **/
    public void setValue(int index, java.lang.String vValue)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _valueList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _valueList.setElementAt(vValue, index);
    } //-- void setValue(int, java.lang.String) 

    /**
     * 
     * @param valueArray
    **/
    public void setValue(java.lang.String[] valueArray)
    {
        //-- copy array
        _valueList.removeAllElements();
        for (int i = 0; i < valueArray.length; i++) {
            _valueList.addElement(valueArray[i]);
        }
    } //-- void setValue(java.lang.String) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.Property unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.Property) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.Property.class, reader);
    } //-- de.fhg.isst.ComponentML.Property unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
