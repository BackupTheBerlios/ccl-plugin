/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: Expose.java,v 1.1 2002/03/19 18:56:06 ali Exp $
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
 *     The expose element describes imports from and exposes to
 * given facades.
 *     Used in: connector-spec.
 *    
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:06 $
**/
public class Expose implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _from;

    private java.lang.String _to;

    /**
     * 
     *     The business-expose element specifies a collection of
     * business 
     *     methods imported from the given and exported by the
     * specified 
     *     component.
     *     If the rename-as attribute of the method-name element is
     * specified the 
     *     method is imported and re-exported with the name given
     * there.
     *     Used in: connector-spec.
     *    
    **/
    private java.util.Vector _businessExposeList;

    /**
     * 
     *     The type-expose element specifies a collection of types
     * imported 
     *     from the given and exported by the specified component.
     *     If the rename-as attribute is specified a type will be
     * known 
     *     and exported with the name specified there.
     *     Used in: connector-spec, import-section.
     *    
    **/
    private TypeExpose _typeExpose;


      //----------------/
     //- Constructors -/
    //----------------/

    public Expose() {
        super();
        _businessExposeList = new Vector();
    } //-- de.fhg.isst.ComponentML.Expose()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vBusinessExpose
    **/
    public void addBusinessExpose(BusinessExpose vBusinessExpose)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_businessExposeList.size() < 2)) {
            throw new IndexOutOfBoundsException();
        }
        _businessExposeList.addElement(vBusinessExpose);
    } //-- void addBusinessExpose(BusinessExpose) 

    /**
     * 
     * @param index
     * @param vBusinessExpose
    **/
    public void addBusinessExpose(int index, BusinessExpose vBusinessExpose)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_businessExposeList.size() < 2)) {
            throw new IndexOutOfBoundsException();
        }
        _businessExposeList.insertElementAt(vBusinessExpose, index);
    } //-- void addBusinessExpose(int, BusinessExpose) 

    /**
    **/
    public java.util.Enumeration enumerateBusinessExpose()
    {
        return _businessExposeList.elements();
    } //-- java.util.Enumeration enumerateBusinessExpose() 

    /**
     * 
     * @param index
    **/
    public BusinessExpose getBusinessExpose(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _businessExposeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (BusinessExpose) _businessExposeList.elementAt(index);
    } //-- BusinessExpose getBusinessExpose(int) 

    /**
    **/
    public BusinessExpose[] getBusinessExpose()
    {
        int size = _businessExposeList.size();
        BusinessExpose[] mArray = new BusinessExpose[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (BusinessExpose) _businessExposeList.elementAt(index);
        }
        return mArray;
    } //-- BusinessExpose[] getBusinessExpose() 

    /**
    **/
    public int getBusinessExposeCount()
    {
        return _businessExposeList.size();
    } //-- int getBusinessExposeCount() 

    /**
    **/
    public java.lang.String getFrom()
    {
        return this._from;
    } //-- java.lang.String getFrom() 

    /**
    **/
    public java.lang.String getTo()
    {
        return this._to;
    } //-- java.lang.String getTo() 

    /**
    **/
    public TypeExpose getTypeExpose()
    {
        return this._typeExpose;
    } //-- TypeExpose getTypeExpose() 

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
    public void removeAllBusinessExpose()
    {
        _businessExposeList.removeAllElements();
    } //-- void removeAllBusinessExpose() 

    /**
     * 
     * @param index
    **/
    public BusinessExpose removeBusinessExpose(int index)
    {
        Object obj = _businessExposeList.elementAt(index);
        _businessExposeList.removeElementAt(index);
        return (BusinessExpose) obj;
    } //-- BusinessExpose removeBusinessExpose(int) 

    /**
     * 
     * @param index
     * @param vBusinessExpose
    **/
    public void setBusinessExpose(int index, BusinessExpose vBusinessExpose)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _businessExposeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        if (!(index < 2)) {
            throw new IndexOutOfBoundsException();
        }
        _businessExposeList.setElementAt(vBusinessExpose, index);
    } //-- void setBusinessExpose(int, BusinessExpose) 

    /**
     * 
     * @param businessExposeArray
    **/
    public void setBusinessExpose(BusinessExpose[] businessExposeArray)
    {
        //-- copy array
        _businessExposeList.removeAllElements();
        for (int i = 0; i < businessExposeArray.length; i++) {
            _businessExposeList.addElement(businessExposeArray[i]);
        }
    } //-- void setBusinessExpose(BusinessExpose) 

    /**
     * 
     * @param from
    **/
    public void setFrom(java.lang.String from)
    {
        this._from = from;
    } //-- void setFrom(java.lang.String) 

    /**
     * 
     * @param to
    **/
    public void setTo(java.lang.String to)
    {
        this._to = to;
    } //-- void setTo(java.lang.String) 

    /**
     * 
     * @param typeExpose
    **/
    public void setTypeExpose(TypeExpose typeExpose)
    {
        this._typeExpose = typeExpose;
    } //-- void setTypeExpose(TypeExpose) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.Expose unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.Expose) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.Expose.class, reader);
    } //-- de.fhg.isst.ComponentML.Expose unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
