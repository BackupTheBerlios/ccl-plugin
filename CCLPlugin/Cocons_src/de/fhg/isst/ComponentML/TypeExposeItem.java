/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: TypeExposeItem.java,v 1.1 2003/07/12 18:21:47 layekers Exp $
 */

package de.fhg.isst.ComponentML;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import org.exolab.castor.xml.*;

/**
 * 
 *     The type-expose element specifies a collection of types
 * imported 
 *     from the given and exported by the specified component.
 *     If the rename-as attribute is specified a type will be known
 * 
 *     and exported with the name specified there.
 *     Used in: connector-spec, import-section.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:47 $
**/
public class TypeExposeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The type element specifies a type.
     *     Used in: type-export.
     *    
    **/
    private Type _type;

    /**
     * 
     *     The type-name element specifies the name of a type.
     *     To rename the corresponding type the rename-as attribute
     * could be used.
     *     Used in: type.
     *    
    **/
    private TypeName _typeName;


      //----------------/
     //- Constructors -/
    //----------------/

    public TypeExposeItem() {
        super();
    } //-- de.fhg.isst.ComponentML.TypeExposeItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public Type getType()
    {
        return this._type;
    } //-- Type getType() 

    /**
    **/
    public TypeName getTypeName()
    {
        return this._typeName;
    } //-- TypeName getTypeName() 

    /**
     * 
     * @param type
    **/
    public void setType(Type type)
    {
        this._type = type;
    } //-- void setType(Type) 

    /**
     * 
     * @param typeName
    **/
    public void setTypeName(TypeName typeName)
    {
        this._typeName = typeName;
    } //-- void setTypeName(TypeName) 

}
