/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: TypeAttrs.java,v 1.1 2003/07/12 18:21:47 layekers Exp $
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
 *     The type-attrs element describes a collection of attributes
 * of a type. 
 *     Used in: type.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:47 $
**/
public class TypeAttrs implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The type-attr element describes an attribute of a type.
     *     The container-type attribute describes a typ of a
     * container used to
     *     represent a type-attr-element. The following values are
     * allowed:
     *     array
     *     collection
     *     none
     *     If the container-type attribute is not specified or the
     * value is 
     *     "none" the type-attr is a scalar type.
     *     The acessor attribute describes which accessors will be
     * available for 
     *     that attribute. The following values are allowed:
     *     read  - a get<attr-name> accessor is available
     *     write - a set<attr-name> accessor is available
     *     acess - a getter and a setter are available
     *     none  - neither a reader nor a writer method is
     * available
     * 
     *     Used in: type-attrs.
     *    
    **/
    private java.util.Vector _typeAttrList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TypeAttrs() {
        super();
        _typeAttrList = new Vector();
    } //-- de.fhg.isst.ComponentML.TypeAttrs()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vTypeAttr
    **/
    public void addTypeAttr(TypeAttr vTypeAttr)
        throws java.lang.IndexOutOfBoundsException
    {
        _typeAttrList.addElement(vTypeAttr);
    } //-- void addTypeAttr(TypeAttr) 

    /**
     * 
     * @param index
     * @param vTypeAttr
    **/
    public void addTypeAttr(int index, TypeAttr vTypeAttr)
        throws java.lang.IndexOutOfBoundsException
    {
        _typeAttrList.insertElementAt(vTypeAttr, index);
    } //-- void addTypeAttr(int, TypeAttr) 

    /**
    **/
    public java.util.Enumeration enumerateTypeAttr()
    {
        return _typeAttrList.elements();
    } //-- java.util.Enumeration enumerateTypeAttr() 

    /**
     * 
     * @param index
    **/
    public TypeAttr getTypeAttr(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _typeAttrList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (TypeAttr) _typeAttrList.elementAt(index);
    } //-- TypeAttr getTypeAttr(int) 

    /**
    **/
    public TypeAttr[] getTypeAttr()
    {
        int size = _typeAttrList.size();
        TypeAttr[] mArray = new TypeAttr[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (TypeAttr) _typeAttrList.elementAt(index);
        }
        return mArray;
    } //-- TypeAttr[] getTypeAttr() 

    /**
    **/
    public int getTypeAttrCount()
    {
        return _typeAttrList.size();
    } //-- int getTypeAttrCount() 

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
    public void removeAllTypeAttr()
    {
        _typeAttrList.removeAllElements();
    } //-- void removeAllTypeAttr() 

    /**
     * 
     * @param index
    **/
    public TypeAttr removeTypeAttr(int index)
    {
        Object obj = _typeAttrList.elementAt(index);
        _typeAttrList.removeElementAt(index);
        return (TypeAttr) obj;
    } //-- TypeAttr removeTypeAttr(int) 

    /**
     * 
     * @param index
     * @param vTypeAttr
    **/
    public void setTypeAttr(int index, TypeAttr vTypeAttr)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _typeAttrList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _typeAttrList.setElementAt(vTypeAttr, index);
    } //-- void setTypeAttr(int, TypeAttr) 

    /**
     * 
     * @param typeAttrArray
    **/
    public void setTypeAttr(TypeAttr[] typeAttrArray)
    {
        //-- copy array
        _typeAttrList.removeAllElements();
        for (int i = 0; i < typeAttrArray.length; i++) {
            _typeAttrList.addElement(typeAttrArray[i]);
        }
    } //-- void setTypeAttr(TypeAttr) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.TypeAttrs unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.TypeAttrs) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.TypeAttrs.class, reader);
    } //-- de.fhg.isst.ComponentML.TypeAttrs unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
