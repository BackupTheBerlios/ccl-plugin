/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ComposedComponents.java,v 1.1 2002/03/19 18:56:06 ali Exp $
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
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:06 $
**/
public class ComposedComponents implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComposedComponents() {
        super();
        _items = new Vector();
    } //-- de.fhg.isst.ComponentML.ComposedComponents()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vComposedComponentsItem
    **/
    public void addComposedComponentsItem(de.fhg.isst.ComponentML.ComposedComponentsItem vComposedComponentsItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vComposedComponentsItem);
    } //-- void addComposedComponentsItem(de.fhg.isst.ComponentML.ComposedComponentsItem) 

    /**
     * 
     * @param index
     * @param vComposedComponentsItem
    **/
    public void addComposedComponentsItem(int index, de.fhg.isst.ComponentML.ComposedComponentsItem vComposedComponentsItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vComposedComponentsItem, index);
    } //-- void addComposedComponentsItem(int, de.fhg.isst.ComponentML.ComposedComponentsItem) 

    /**
    **/
    public java.util.Enumeration enumerateComposedComponentsItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateComposedComponentsItem() 

    /**
     * 
     * @param index
    **/
    public de.fhg.isst.ComponentML.ComposedComponentsItem getComposedComponentsItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.fhg.isst.ComponentML.ComposedComponentsItem) _items.elementAt(index);
    } //-- de.fhg.isst.ComponentML.ComposedComponentsItem getComposedComponentsItem(int) 

    /**
    **/
    public de.fhg.isst.ComponentML.ComposedComponentsItem[] getComposedComponentsItem()
    {
        int size = _items.size();
        de.fhg.isst.ComponentML.ComposedComponentsItem[] mArray = new de.fhg.isst.ComponentML.ComposedComponentsItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (ComposedComponentsItem) _items.elementAt(index);
        }
        return mArray;
    } //-- de.fhg.isst.ComponentML.ComposedComponentsItem[] getComposedComponentsItem() 

    /**
    **/
    public int getComposedComponentsItemCount()
    {
        return _items.size();
    } //-- int getComposedComponentsItemCount() 

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
    public void removeAllComposedComponentsItem()
    {
        _items.removeAllElements();
    } //-- void removeAllComposedComponentsItem() 

    /**
     * 
     * @param index
    **/
    public de.fhg.isst.ComponentML.ComposedComponentsItem removeComposedComponentsItem(int index)
    {
        Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (de.fhg.isst.ComponentML.ComposedComponentsItem) obj;
    } //-- de.fhg.isst.ComponentML.ComposedComponentsItem removeComposedComponentsItem(int) 

    /**
     * 
     * @param index
     * @param vComposedComponentsItem
    **/
    public void setComposedComponentsItem(int index, de.fhg.isst.ComponentML.ComposedComponentsItem vComposedComponentsItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vComposedComponentsItem, index);
    } //-- void setComposedComponentsItem(int, de.fhg.isst.ComponentML.ComposedComponentsItem) 

    /**
     * 
     * @param composedComponentsItemArray
    **/
    public void setComposedComponentsItem(de.fhg.isst.ComponentML.ComposedComponentsItem[] composedComponentsItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < composedComponentsItemArray.length; i++) {
            _items.addElement(composedComponentsItemArray[i]);
        }
    } //-- void setComposedComponentsItem(de.fhg.isst.ComponentML.ComposedComponentsItem) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ComposedComponents unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ComposedComponents) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ComposedComponents.class, reader);
    } //-- de.fhg.isst.ComponentML.ComposedComponents unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
