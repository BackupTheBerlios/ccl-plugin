/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: TypeExport.java,v 1.1 2002/03/19 18:56:06 ali Exp $
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
 *     The type-export element specifies a set of types exported by
 * the
 *     specified component.
 *    
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:06 $
**/
public class TypeExport implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The type element specifies a type.
     *     Used in: type-export.
     *    
    **/
    private java.util.Vector _typeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TypeExport() {
        super();
        _typeList = new Vector();
    } //-- de.fhg.isst.ComponentML.TypeExport()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vType
    **/
    public void addType(Type vType)
        throws java.lang.IndexOutOfBoundsException
    {
        _typeList.addElement(vType);
    } //-- void addType(Type) 

    /**
     * 
     * @param index
     * @param vType
    **/
    public void addType(int index, Type vType)
        throws java.lang.IndexOutOfBoundsException
    {
        _typeList.insertElementAt(vType, index);
    } //-- void addType(int, Type) 

    /**
    **/
    public java.util.Enumeration enumerateType()
    {
        return _typeList.elements();
    } //-- java.util.Enumeration enumerateType() 

    /**
     * 
     * @param index
    **/
    public Type getType(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _typeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (Type) _typeList.elementAt(index);
    } //-- Type getType(int) 

    /**
    **/
    public Type[] getType()
    {
        int size = _typeList.size();
        Type[] mArray = new Type[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Type) _typeList.elementAt(index);
        }
        return mArray;
    } //-- Type[] getType() 

    /**
    **/
    public int getTypeCount()
    {
        return _typeList.size();
    } //-- int getTypeCount() 

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
    public void removeAllType()
    {
        _typeList.removeAllElements();
    } //-- void removeAllType() 

    /**
     * 
     * @param index
    **/
    public Type removeType(int index)
    {
        Object obj = _typeList.elementAt(index);
        _typeList.removeElementAt(index);
        return (Type) obj;
    } //-- Type removeType(int) 

    /**
     * 
     * @param index
     * @param vType
    **/
    public void setType(int index, Type vType)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _typeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _typeList.setElementAt(vType, index);
    } //-- void setType(int, Type) 

    /**
     * 
     * @param typeArray
    **/
    public void setType(Type[] typeArray)
    {
        //-- copy array
        _typeList.removeAllElements();
        for (int i = 0; i < typeArray.length; i++) {
            _typeList.addElement(typeArray[i]);
        }
    } //-- void setType(Type) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.TypeExport unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.TypeExport) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.TypeExport.class, reader);
    } //-- de.fhg.isst.ComponentML.TypeExport unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
