/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: BindingSection.java,v 1.1 2002/03/19 18:56:06 ali Exp $
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
 *     The binding-section element describes the binding of
 * component-specs with
 *     their implementation.
 *     Used in: component-application.
 *    
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:06 $
**/
public class BindingSection implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The binding element describes a binding of a
     * component-spec 
     *     with its implementation.
     *     Used in: binding-section.
     *    
    **/
    private java.util.Vector _bindingList;


      //----------------/
     //- Constructors -/
    //----------------/

    public BindingSection() {
        super();
        _bindingList = new Vector();
    } //-- de.fhg.isst.ComponentML.BindingSection()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vBinding
    **/
    public void addBinding(Binding vBinding)
        throws java.lang.IndexOutOfBoundsException
    {
        _bindingList.addElement(vBinding);
    } //-- void addBinding(Binding) 

    /**
     * 
     * @param index
     * @param vBinding
    **/
    public void addBinding(int index, Binding vBinding)
        throws java.lang.IndexOutOfBoundsException
    {
        _bindingList.insertElementAt(vBinding, index);
    } //-- void addBinding(int, Binding) 

    /**
    **/
    public java.util.Enumeration enumerateBinding()
    {
        return _bindingList.elements();
    } //-- java.util.Enumeration enumerateBinding() 

    /**
     * 
     * @param index
    **/
    public Binding getBinding(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _bindingList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (Binding) _bindingList.elementAt(index);
    } //-- Binding getBinding(int) 

    /**
    **/
    public Binding[] getBinding()
    {
        int size = _bindingList.size();
        Binding[] mArray = new Binding[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Binding) _bindingList.elementAt(index);
        }
        return mArray;
    } //-- Binding[] getBinding() 

    /**
    **/
    public int getBindingCount()
    {
        return _bindingList.size();
    } //-- int getBindingCount() 

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
    public void removeAllBinding()
    {
        _bindingList.removeAllElements();
    } //-- void removeAllBinding() 

    /**
     * 
     * @param index
    **/
    public Binding removeBinding(int index)
    {
        Object obj = _bindingList.elementAt(index);
        _bindingList.removeElementAt(index);
        return (Binding) obj;
    } //-- Binding removeBinding(int) 

    /**
     * 
     * @param index
     * @param vBinding
    **/
    public void setBinding(int index, Binding vBinding)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _bindingList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _bindingList.setElementAt(vBinding, index);
    } //-- void setBinding(int, Binding) 

    /**
     * 
     * @param bindingArray
    **/
    public void setBinding(Binding[] bindingArray)
    {
        //-- copy array
        _bindingList.removeAllElements();
        for (int i = 0; i < bindingArray.length; i++) {
            _bindingList.addElement(bindingArray[i]);
        }
    } //-- void setBinding(Binding) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.BindingSection unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.BindingSection) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.BindingSection.class, reader);
    } //-- de.fhg.isst.ComponentML.BindingSection unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
