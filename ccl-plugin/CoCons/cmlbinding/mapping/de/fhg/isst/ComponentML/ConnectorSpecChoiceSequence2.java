/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ConnectorSpecChoiceSequence2.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
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
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class ConnectorSpecChoiceSequence2 implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The business-import element specifies a collection of
     * business methods 
     *     a component imports from a given component.
     *     If the rename-as attribute of the method-name element is
     * specified the 
     *     method is imported with the name given there.
     *     Used in: import-section, connector-spec.
     *    
    **/
    private java.util.Vector _businessImportList;

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
     *     The type-import element specifies a collection of types
     * imported 
     *     from the given component.
     *     If the rename-as attribute is specified a type will be
     * known with the 
     *     name specified there.
     *     Used in: connector-spec, import-section.
     *    
    **/
    private TypeImport _typeImport;

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

    public ConnectorSpecChoiceSequence2() {
        super();
        _businessImportList = new Vector();
        _businessExposeList = new Vector();
    } //-- de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence2()


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
     * 
     * @param vBusinessImport
    **/
    public void addBusinessImport(BusinessImport vBusinessImport)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_businessImportList.size() < 2)) {
            throw new IndexOutOfBoundsException();
        }
        _businessImportList.addElement(vBusinessImport);
    } //-- void addBusinessImport(BusinessImport) 

    /**
     * 
     * @param index
     * @param vBusinessImport
    **/
    public void addBusinessImport(int index, BusinessImport vBusinessImport)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_businessImportList.size() < 2)) {
            throw new IndexOutOfBoundsException();
        }
        _businessImportList.insertElementAt(vBusinessImport, index);
    } //-- void addBusinessImport(int, BusinessImport) 

    /**
    **/
    public java.util.Enumeration enumerateBusinessExpose()
    {
        return _businessExposeList.elements();
    } //-- java.util.Enumeration enumerateBusinessExpose() 

    /**
    **/
    public java.util.Enumeration enumerateBusinessImport()
    {
        return _businessImportList.elements();
    } //-- java.util.Enumeration enumerateBusinessImport() 

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
     * 
     * @param index
    **/
    public BusinessImport getBusinessImport(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _businessImportList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (BusinessImport) _businessImportList.elementAt(index);
    } //-- BusinessImport getBusinessImport(int) 

    /**
    **/
    public BusinessImport[] getBusinessImport()
    {
        int size = _businessImportList.size();
        BusinessImport[] mArray = new BusinessImport[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (BusinessImport) _businessImportList.elementAt(index);
        }
        return mArray;
    } //-- BusinessImport[] getBusinessImport() 

    /**
    **/
    public int getBusinessImportCount()
    {
        return _businessImportList.size();
    } //-- int getBusinessImportCount() 

    /**
    **/
    public TypeExpose getTypeExpose()
    {
        return this._typeExpose;
    } //-- TypeExpose getTypeExpose() 

    /**
    **/
    public TypeImport getTypeImport()
    {
        return this._typeImport;
    } //-- TypeImport getTypeImport() 

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
    **/
    public void removeAllBusinessImport()
    {
        _businessImportList.removeAllElements();
    } //-- void removeAllBusinessImport() 

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
    **/
    public BusinessImport removeBusinessImport(int index)
    {
        Object obj = _businessImportList.elementAt(index);
        _businessImportList.removeElementAt(index);
        return (BusinessImport) obj;
    } //-- BusinessImport removeBusinessImport(int) 

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
     * @param index
     * @param vBusinessImport
    **/
    public void setBusinessImport(int index, BusinessImport vBusinessImport)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _businessImportList.size())) {
            throw new IndexOutOfBoundsException();
        }
        if (!(index < 2)) {
            throw new IndexOutOfBoundsException();
        }
        _businessImportList.setElementAt(vBusinessImport, index);
    } //-- void setBusinessImport(int, BusinessImport) 

    /**
     * 
     * @param businessImportArray
    **/
    public void setBusinessImport(BusinessImport[] businessImportArray)
    {
        //-- copy array
        _businessImportList.removeAllElements();
        for (int i = 0; i < businessImportArray.length; i++) {
            _businessImportList.addElement(businessImportArray[i]);
        }
    } //-- void setBusinessImport(BusinessImport) 

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
     * @param typeImport
    **/
    public void setTypeImport(TypeImport typeImport)
    {
        this._typeImport = typeImport;
    } //-- void setTypeImport(TypeImport) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence2 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence2) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence2.class, reader);
    } //-- de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence2 unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
