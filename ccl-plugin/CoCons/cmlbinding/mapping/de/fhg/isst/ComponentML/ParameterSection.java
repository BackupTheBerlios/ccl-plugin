/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ParameterSection.java,v 1.1 2002/03/19 18:56:06 ali Exp $
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
 *     The parameter-section element describes a set of parameters
 * used to 
 *     parametrize that component.
 *     Used in: component-spec.
 *    
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:06 $
**/
public class ParameterSection implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The parameter element describes an external parameter
     * used to 
     *     parametrize the specified component.
     *     Used in: parameter-section.
     *    
    **/
    private java.util.Vector _parameterList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterSection() {
        super();
        _parameterList = new Vector();
    } //-- de.fhg.isst.ComponentML.ParameterSection()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vParameter
    **/
    public void addParameter(Parameter vParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameterList.addElement(vParameter);
    } //-- void addParameter(Parameter) 

    /**
     * 
     * @param index
     * @param vParameter
    **/
    public void addParameter(int index, Parameter vParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameterList.insertElementAt(vParameter, index);
    } //-- void addParameter(int, Parameter) 

    /**
    **/
    public java.util.Enumeration enumerateParameter()
    {
        return _parameterList.elements();
    } //-- java.util.Enumeration enumerateParameter() 

    /**
     * 
     * @param index
    **/
    public Parameter getParameter(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _parameterList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (Parameter) _parameterList.elementAt(index);
    } //-- Parameter getParameter(int) 

    /**
    **/
    public Parameter[] getParameter()
    {
        int size = _parameterList.size();
        Parameter[] mArray = new Parameter[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Parameter) _parameterList.elementAt(index);
        }
        return mArray;
    } //-- Parameter[] getParameter() 

    /**
    **/
    public int getParameterCount()
    {
        return _parameterList.size();
    } //-- int getParameterCount() 

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
    public void removeAllParameter()
    {
        _parameterList.removeAllElements();
    } //-- void removeAllParameter() 

    /**
     * 
     * @param index
    **/
    public Parameter removeParameter(int index)
    {
        Object obj = _parameterList.elementAt(index);
        _parameterList.removeElementAt(index);
        return (Parameter) obj;
    } //-- Parameter removeParameter(int) 

    /**
     * 
     * @param index
     * @param vParameter
    **/
    public void setParameter(int index, Parameter vParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _parameterList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _parameterList.setElementAt(vParameter, index);
    } //-- void setParameter(int, Parameter) 

    /**
     * 
     * @param parameterArray
    **/
    public void setParameter(Parameter[] parameterArray)
    {
        //-- copy array
        _parameterList.removeAllElements();
        for (int i = 0; i < parameterArray.length; i++) {
            _parameterList.addElement(parameterArray[i]);
        }
    } //-- void setParameter(Parameter) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ParameterSection unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ParameterSection) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ParameterSection.class, reader);
    } //-- de.fhg.isst.ComponentML.ParameterSection unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
