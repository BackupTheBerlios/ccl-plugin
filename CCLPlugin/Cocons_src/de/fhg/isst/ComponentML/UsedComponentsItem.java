/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: UsedComponentsItem.java,v 1.1 2003/07/12 18:21:47 layekers Exp $
 */

package de.fhg.isst.ComponentML;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import org.exolab.castor.xml.*;

/**
 * 
 *     The used-components element contains a collection of specs
 *     of used components.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:47 $
**/
public class UsedComponentsItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The connector-spec element specifies a component and the
     * entities imported 
     *     from a component.
     *     Used in: configuration-section.
     *    
    **/
    private ConnectorSpec _connectorSpec;

    /**
     * 
     *     The connector-spec-ref element describes a reference to
     * a possibly 
     *     remote connector-spec described by an URL element.
     * Specified
     *     properties will be compared to given ones in the
     * referenced spec.
     *     Used in: composed-components, used-components.
     *    
    **/
    private ConnectorSpecRef _connectorSpecRef;


      //----------------/
     //- Constructors -/
    //----------------/

    public UsedComponentsItem() {
        super();
    } //-- de.fhg.isst.ComponentML.UsedComponentsItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public ConnectorSpec getConnectorSpec()
    {
        return this._connectorSpec;
    } //-- ConnectorSpec getConnectorSpec() 

    /**
    **/
    public ConnectorSpecRef getConnectorSpecRef()
    {
        return this._connectorSpecRef;
    } //-- ConnectorSpecRef getConnectorSpecRef() 

    /**
     * 
     * @param connectorSpec
    **/
    public void setConnectorSpec(ConnectorSpec connectorSpec)
    {
        this._connectorSpec = connectorSpec;
    } //-- void setConnectorSpec(ConnectorSpec) 

    /**
     * 
     * @param connectorSpecRef
    **/
    public void setConnectorSpecRef(ConnectorSpecRef connectorSpecRef)
    {
        this._connectorSpecRef = connectorSpecRef;
    } //-- void setConnectorSpecRef(ConnectorSpecRef) 

}
