/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: RaisedExceptions.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
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
 *     The raised-exceptions element specifies a collection of 
 *     exception-type-ref elements describing the types of
 * exceptions 
 *     raised by that method.
 *     Used in: method.
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class RaisedExceptions implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The exception-type-ref element specifies a reference of
     * a type of an 
     *     exception.
     *     Used in: raised-exceptions.
     *    
    **/
    private java.util.Vector _exceptionTypeRefList;


      //----------------/
     //- Constructors -/
    //----------------/

    public RaisedExceptions() {
        super();
        _exceptionTypeRefList = new Vector();
    } //-- de.fhg.isst.ComponentML.RaisedExceptions()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vExceptionTypeRef
    **/
    public void addExceptionTypeRef(java.lang.String vExceptionTypeRef)
        throws java.lang.IndexOutOfBoundsException
    {
        _exceptionTypeRefList.addElement(vExceptionTypeRef);
    } //-- void addExceptionTypeRef(java.lang.String) 

    /**
     * 
     * @param index
     * @param vExceptionTypeRef
    **/
    public void addExceptionTypeRef(int index, java.lang.String vExceptionTypeRef)
        throws java.lang.IndexOutOfBoundsException
    {
        _exceptionTypeRefList.insertElementAt(vExceptionTypeRef, index);
    } //-- void addExceptionTypeRef(int, java.lang.String) 

    /**
    **/
    public java.util.Enumeration enumerateExceptionTypeRef()
    {
        return _exceptionTypeRefList.elements();
    } //-- java.util.Enumeration enumerateExceptionTypeRef() 

    /**
     * 
     * @param index
    **/
    public java.lang.String getExceptionTypeRef(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _exceptionTypeRefList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_exceptionTypeRefList.elementAt(index);
    } //-- java.lang.String getExceptionTypeRef(int) 

    /**
    **/
    public java.lang.String[] getExceptionTypeRef()
    {
        int size = _exceptionTypeRefList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_exceptionTypeRefList.elementAt(index);
        }
        return mArray;
    } //-- java.lang.String[] getExceptionTypeRef() 

    /**
    **/
    public int getExceptionTypeRefCount()
    {
        return _exceptionTypeRefList.size();
    } //-- int getExceptionTypeRefCount() 

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
    public void removeAllExceptionTypeRef()
    {
        _exceptionTypeRefList.removeAllElements();
    } //-- void removeAllExceptionTypeRef() 

    /**
     * 
     * @param index
    **/
    public java.lang.String removeExceptionTypeRef(int index)
    {
        Object obj = _exceptionTypeRefList.elementAt(index);
        _exceptionTypeRefList.removeElementAt(index);
        return (String)obj;
    } //-- java.lang.String removeExceptionTypeRef(int) 

    /**
     * 
     * @param index
     * @param vExceptionTypeRef
    **/
    public void setExceptionTypeRef(int index, java.lang.String vExceptionTypeRef)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _exceptionTypeRefList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _exceptionTypeRefList.setElementAt(vExceptionTypeRef, index);
    } //-- void setExceptionTypeRef(int, java.lang.String) 

    /**
     * 
     * @param exceptionTypeRefArray
    **/
    public void setExceptionTypeRef(java.lang.String[] exceptionTypeRefArray)
    {
        //-- copy array
        _exceptionTypeRefList.removeAllElements();
        for (int i = 0; i < exceptionTypeRefArray.length; i++) {
            _exceptionTypeRefList.addElement(exceptionTypeRefArray[i]);
        }
    } //-- void setExceptionTypeRef(java.lang.String) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.RaisedExceptions unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.RaisedExceptions) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.RaisedExceptions.class, reader);
    } //-- de.fhg.isst.ComponentML.RaisedExceptions unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
