/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: TypeAttr.java,v 1.1 2002/03/19 18:56:06 ali Exp $
 */

package de.fhg.isst.ComponentML;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import de.fhg.isst.ComponentML.types.AccessorType;
import de.fhg.isst.ComponentML.types.ContainerTypeType;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 *     The type-attr element describes an attribute of a type.
 *     The container-type attribute describes a typ of a container
 * used to
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
 *     none  - neither a reader nor a writer method is available
 * 
 *     Used in: type-attrs.
 *    
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:06 $
**/
public class TypeAttr implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private de.fhg.isst.ComponentML.types.ContainerTypeType _containerType = de.fhg.isst.ComponentML.types.ContainerTypeType.valueOf("none");;

    private int _arrayDimension = 0;

    /**
     * keeps track of state for field: _arrayDimension
    **/
    private boolean _has_arrayDimension;

    private de.fhg.isst.ComponentML.types.AccessorType _accessor = de.fhg.isst.ComponentML.types.AccessorType.valueOf("access");;

    private java.lang.String _readerName;

    private java.lang.String _writerName;

    private java.lang.String _description;

    private java.lang.String _attrName;

    private java.lang.String _attrTypeRef;

    /**
     * 
     *     The properties element specifies a sequence of key-value
     * pairs to
     *     contain any information about its parent element.
     *     Used in: component-identifier, import, export, method,
     * type.
     *    
    **/
    private Properties _properties;


      //----------------/
     //- Constructors -/
    //----------------/

    public TypeAttr() {
        super();
    } //-- de.fhg.isst.ComponentML.TypeAttr()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public void deleteArrayDimension()
    {
        this._has_arrayDimension= false;
    } //-- void deleteArrayDimension() 

    /**
    **/
    public de.fhg.isst.ComponentML.types.AccessorType getAccessor()
    {
        return this._accessor;
    } //-- de.fhg.isst.ComponentML.types.AccessorType getAccessor() 

    /**
    **/
    public int getArrayDimension()
    {
        return this._arrayDimension;
    } //-- int getArrayDimension() 

    /**
    **/
    public java.lang.String getAttrName()
    {
        return this._attrName;
    } //-- java.lang.String getAttrName() 

    /**
    **/
    public java.lang.String getAttrTypeRef()
    {
        return this._attrTypeRef;
    } //-- java.lang.String getAttrTypeRef() 

    /**
    **/
    public de.fhg.isst.ComponentML.types.ContainerTypeType getContainerType()
    {
        return this._containerType;
    } //-- de.fhg.isst.ComponentML.types.ContainerTypeType getContainerType() 

    /**
    **/
    public java.lang.String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

    /**
    **/
    public Properties getProperties()
    {
        return this._properties;
    } //-- Properties getProperties() 

    /**
    **/
    public java.lang.String getReaderName()
    {
        return this._readerName;
    } //-- java.lang.String getReaderName() 

    /**
    **/
    public java.lang.String getWriterName()
    {
        return this._writerName;
    } //-- java.lang.String getWriterName() 

    /**
    **/
    public boolean hasArrayDimension()
    {
        return this._has_arrayDimension;
    } //-- boolean hasArrayDimension() 

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
     * 
     * @param accessor
    **/
    public void setAccessor(de.fhg.isst.ComponentML.types.AccessorType accessor)
    {
        this._accessor = accessor;
    } //-- void setAccessor(de.fhg.isst.ComponentML.types.AccessorType) 

    /**
     * 
     * @param arrayDimension
    **/
    public void setArrayDimension(int arrayDimension)
    {
        this._arrayDimension = arrayDimension;
        this._has_arrayDimension = true;
    } //-- void setArrayDimension(int) 

    /**
     * 
     * @param attrName
    **/
    public void setAttrName(java.lang.String attrName)
    {
        this._attrName = attrName;
    } //-- void setAttrName(java.lang.String) 

    /**
     * 
     * @param attrTypeRef
    **/
    public void setAttrTypeRef(java.lang.String attrTypeRef)
    {
        this._attrTypeRef = attrTypeRef;
    } //-- void setAttrTypeRef(java.lang.String) 

    /**
     * 
     * @param containerType
    **/
    public void setContainerType(de.fhg.isst.ComponentML.types.ContainerTypeType containerType)
    {
        this._containerType = containerType;
    } //-- void setContainerType(de.fhg.isst.ComponentML.types.ContainerTypeType) 

    /**
     * 
     * @param description
    **/
    public void setDescription(java.lang.String description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.String) 

    /**
     * 
     * @param properties
    **/
    public void setProperties(Properties properties)
    {
        this._properties = properties;
    } //-- void setProperties(Properties) 

    /**
     * 
     * @param readerName
    **/
    public void setReaderName(java.lang.String readerName)
    {
        this._readerName = readerName;
    } //-- void setReaderName(java.lang.String) 

    /**
     * 
     * @param writerName
    **/
    public void setWriterName(java.lang.String writerName)
    {
        this._writerName = writerName;
    } //-- void setWriterName(java.lang.String) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.TypeAttr unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.TypeAttr) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.TypeAttr.class, reader);
    } //-- de.fhg.isst.ComponentML.TypeAttr unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
