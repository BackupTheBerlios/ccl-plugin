/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: MethodParameters.java,v 1.1 2003/07/12 18:21:47 layekers Exp $
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
 *     The method-parameters element describes a collection of
 * method 
 *     parameters.
 *     Used in: method.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:47 $
**/
public class MethodParameters implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The method-parameter element specifies a method
     * parameter.
     *     The type attribute specifies whether the parameter 
     *     is an  input, an output or an in/out parameter. The
     * parameter-attr 
     *     element must be one of the following four:   
     *     Use in method-parameters.
     *    
    **/
    private java.util.Vector _methodParameterList;


      //----------------/
     //- Constructors -/
    //----------------/

    public MethodParameters() {
        super();
        _methodParameterList = new Vector();
    } //-- de.fhg.isst.ComponentML.MethodParameters()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vMethodParameter
    **/
    public void addMethodParameter(MethodParameter vMethodParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        _methodParameterList.addElement(vMethodParameter);
    } //-- void addMethodParameter(MethodParameter) 

    /**
     * 
     * @param index
     * @param vMethodParameter
    **/
    public void addMethodParameter(int index, MethodParameter vMethodParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        _methodParameterList.insertElementAt(vMethodParameter, index);
    } //-- void addMethodParameter(int, MethodParameter) 

    /**
    **/
    public java.util.Enumeration enumerateMethodParameter()
    {
        return _methodParameterList.elements();
    } //-- java.util.Enumeration enumerateMethodParameter() 

    /**
     * 
     * @param index
    **/
    public MethodParameter getMethodParameter(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _methodParameterList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (MethodParameter) _methodParameterList.elementAt(index);
    } //-- MethodParameter getMethodParameter(int) 

    /**
    **/
    public MethodParameter[] getMethodParameter()
    {
        int size = _methodParameterList.size();
        MethodParameter[] mArray = new MethodParameter[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (MethodParameter) _methodParameterList.elementAt(index);
        }
        return mArray;
    } //-- MethodParameter[] getMethodParameter() 

    /**
    **/
    public int getMethodParameterCount()
    {
        return _methodParameterList.size();
    } //-- int getMethodParameterCount() 

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
    public void removeAllMethodParameter()
    {
        _methodParameterList.removeAllElements();
    } //-- void removeAllMethodParameter() 

    /**
     * 
     * @param index
    **/
    public MethodParameter removeMethodParameter(int index)
    {
        Object obj = _methodParameterList.elementAt(index);
        _methodParameterList.removeElementAt(index);
        return (MethodParameter) obj;
    } //-- MethodParameter removeMethodParameter(int) 

    /**
     * 
     * @param index
     * @param vMethodParameter
    **/
    public void setMethodParameter(int index, MethodParameter vMethodParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _methodParameterList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _methodParameterList.setElementAt(vMethodParameter, index);
    } //-- void setMethodParameter(int, MethodParameter) 

    /**
     * 
     * @param methodParameterArray
    **/
    public void setMethodParameter(MethodParameter[] methodParameterArray)
    {
        //-- copy array
        _methodParameterList.removeAllElements();
        for (int i = 0; i < methodParameterArray.length; i++) {
            _methodParameterList.addElement(methodParameterArray[i]);
        }
    } //-- void setMethodParameter(MethodParameter) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.MethodParameters unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.MethodParameters) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.MethodParameters.class, reader);
    } //-- de.fhg.isst.ComponentML.MethodParameters unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
