/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: TypeExpose.java,v 1.1 2002/03/19 18:56:06 ali Exp $
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
public class TypeExpose implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public TypeExpose() {
        super();
        _items = new Vector();
    } //-- de.fhg.isst.ComponentML.TypeExpose()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vTypeExposeItem
    **/
    public void addTypeExposeItem(de.fhg.isst.ComponentML.TypeExposeItem vTypeExposeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vTypeExposeItem);
    } //-- void addTypeExposeItem(de.fhg.isst.ComponentML.TypeExposeItem) 

    /**
     * 
     * @param index
     * @param vTypeExposeItem
    **/
    public void addTypeExposeItem(int index, de.fhg.isst.ComponentML.TypeExposeItem vTypeExposeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vTypeExposeItem, index);
    } //-- void addTypeExposeItem(int, de.fhg.isst.ComponentML.TypeExposeItem) 

    /**
    **/
    public java.util.Enumeration enumerateTypeExposeItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateTypeExposeItem() 

    /**
     * 
     * @param index
    **/
    public de.fhg.isst.ComponentML.TypeExposeItem getTypeExposeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.fhg.isst.ComponentML.TypeExposeItem) _items.elementAt(index);
    } //-- de.fhg.isst.ComponentML.TypeExposeItem getTypeExposeItem(int) 

    /**
    **/
    public de.fhg.isst.ComponentML.TypeExposeItem[] getTypeExposeItem()
    {
        int size = _items.size();
        de.fhg.isst.ComponentML.TypeExposeItem[] mArray = new de.fhg.isst.ComponentML.TypeExposeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (TypeExposeItem) _items.elementAt(index);
        }
        return mArray;
    } //-- de.fhg.isst.ComponentML.TypeExposeItem[] getTypeExposeItem() 

    /**
    **/
    public int getTypeExposeItemCount()
    {
        return _items.size();
    } //-- int getTypeExposeItemCount() 

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
    public void removeAllTypeExposeItem()
    {
        _items.removeAllElements();
    } //-- void removeAllTypeExposeItem() 

    /**
     * 
     * @param index
    **/
    public de.fhg.isst.ComponentML.TypeExposeItem removeTypeExposeItem(int index)
    {
        Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (de.fhg.isst.ComponentML.TypeExposeItem) obj;
    } //-- de.fhg.isst.ComponentML.TypeExposeItem removeTypeExposeItem(int) 

    /**
     * 
     * @param index
     * @param vTypeExposeItem
    **/
    public void setTypeExposeItem(int index, de.fhg.isst.ComponentML.TypeExposeItem vTypeExposeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vTypeExposeItem, index);
    } //-- void setTypeExposeItem(int, de.fhg.isst.ComponentML.TypeExposeItem) 

    /**
     * 
     * @param typeExposeItemArray
    **/
    public void setTypeExposeItem(de.fhg.isst.ComponentML.TypeExposeItem[] typeExposeItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < typeExposeItemArray.length; i++) {
            _items.addElement(typeExposeItemArray[i]);
        }
    } //-- void setTypeExposeItem(de.fhg.isst.ComponentML.TypeExposeItem) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.TypeExpose unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.TypeExpose) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.TypeExpose.class, reader);
    } //-- de.fhg.isst.ComponentML.TypeExpose unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
