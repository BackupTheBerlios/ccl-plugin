// Author: shicathy

package org.cocons.argo.diagram.interface_spec;

import java.util.*;
import java.beans.*;

import ru.novosoft.uml.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.behavior.common_behavior.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;

import org.tigris.gef.graph.*;

import org.argouml.uml.MMUtil;
import org.cocons.uml.ccl.*;

/** This class defines a bridge between the UML meta-model
 *  representation of the design and the GraphModel interface used by
 *  GEF.  This class handles only UML Class digrams.  */

public class Interface_SpecDiagramGraphModel extends MutableGraphSupport
    implements MutableGraphModel, GraphModel,VetoableChangeListener, MElementListener {

  ////////////////////////////////////////////////////////////////
  // instance variables
  protected Vector _nodes = new Vector();
  protected Vector _edges = new Vector();

  /** The "home" UML model of this diagram, not all ModelElements in this
   *  graph are in the home model, but if they are added and don't
   *  already have a model, they are placed in the "home model".
   *  Also, elements from other models will have their FigNodes add a
   *  line to say what their model is. */

  protected MNamespace _model;

  ////////////////////////////////////////////////////////////////
  // accessors

  public MNamespace getNamespace() { return _model; }
  public void setNamespace(MNamespace m) {
    if (_model != null) _model.removeMElementListener(this);
    _model = m;
    if (_model != null) _model.addMElementListener(this);
  }

  ////////////////////////////////////////////////////////////////
  // GraphModel implementation

  /** Return all nodes in the graph */
  public Vector getNodes() { return _nodes; }

  /** Return all nodes in the graph */
  public Vector getEdges() { return _edges; }

  /** Return all ports on node or edge */
  public Vector getPorts(Object nodeOrEdge) {
    Vector res = new Vector();  //wasteful!
    if (nodeOrEdge instanceof MClass) res.addElement(nodeOrEdge);
    if (nodeOrEdge instanceof MTaggedValue) res.addElement(nodeOrEdge);
    if (nodeOrEdge instanceof MAssociation) res.addElement(nodeOrEdge);
    return res;
  }

  /** Return the node or edge that owns the given port */
  public Object getOwner(Object port) {
    return port;
  }

  /** Return all edges going to given port */
  public Vector getInEdges(Object port) {

    Vector res = new Vector(); //wasteful!

    if (port instanceof MClass) {
      MClass cls = (MClass) port;
      Collection ends = cls.getAssociationEnds();

      if (ends == null) return res; // empty Vector
      //java.util.Enumeration endEnum = ends.elements();
      Iterator iter = ends.iterator();
      while (iter.hasNext()) {
		  MAssociationEnd ae = (MAssociationEnd) iter.next();
		  res.add(ae.getAssociation());
      }
    }
/*  Achtung  Jan
    if (port instanceof MTaggedValue) {
      MTaggedValue tv = (MTaggedValue) port;
      Collection sd = tv.getSupplierDependencies();
      if (sd == null) return res; // empty Vector
      Iterator it = sd.iterator();
      while (it.hasNext()) {
        MDependency sdmd = (MDependency) it.next();
        res.addElement(sdmd);
      }
      Collection cd = tv.getClientDependencies();
      if (cd == null) return res; // empty Vector
      it = cd.iterator();
      while (it.hasNext()) {
        MDependency cdmd = (MDependency) it.next();
        res.addElement(cdmd);
      }
    }
*/
    return res;
  }

  /** Return all edges going from given port */
  public Vector getOutEdges(Object port) {
    return getInEdges(port);
  }

  /** Return one end of an edge */
  public Object getSourcePort(Object edge) {

    if (edge instanceof MAssociation) {
      MAssociation assoc = (MAssociation) edge;
      List conns = assoc.getConnections();
      return conns.get(0);
    }

    //System.out.println("needs-more-work getSourcePort");
    return null;
  }

  /** Return  the other end of an edge */
  public Object getDestPort(Object edge) {

    if (edge instanceof MAssociation) {
      MAssociation assoc = (MAssociation) edge;
      List conns = assoc.getConnections();
      return conns.get(1);
    }

    //System.out.println("needs-more-work getDestPort");
    return null;
  }


  ////////////////////////////////////////////////////////////////
  // MutableGraphModel implementation

  /** Return true if the given object is a valid node in this graph */
  public boolean canAddNode(Object node) {
    if (_nodes.contains(node)) return false;
    if ( node instanceof MClass ) {
      MClass nodeClass = (MClass)node;
      MStereotype stereotype = nodeClass.getStereotype();
      if ( stereotype == null ) {
	stereotype = new MStereotypeImpl();
	stereotype.setName("interface spec");
	nodeClass.setStereotype(stereotype);
      }
      String stereotypeN = nodeClass.getStereotype().getName();
      return ( stereotypeN.equals("interface spec") || stereotypeN.equals("type") ||
	    stereotypeN.equals("info type") );
    }
    else return false;
  }


  /** Add the given node to the graph, if valid. */
  public void addNode(Object node) {
    System.out.println("adding class node!!");
    if (!canAddNode(node) ) return;
    System.out.println("adding class node (really)!!");
    _nodes.addElement(node);

    if (node instanceof MModelElement && ((MModelElement)node).getNamespace() == null) {
	_model.addOwnedElement((MModelElement) node);
    }

    /*if (node instanceof MInterface){
    //System.out.println("Interface stereo: "+MMUtil.STANDARDS.lookup("interface"));
	((MInterface)node).setStereotype((MStereotype)MMUtil.STANDARDS.lookup("interface"));
    }*/

    fireNodeAdded(node);
    // System.out.println("adding "+node+" OK");
  }

    /** Remove the given node from the graph. */
  public void removeNode(Object node) {
     if (!_nodes.contains(node)) return;
	_nodes.removeElement(node);
	fireNodeRemoved(node);
    }



  /** Return true if the given object is a valid edge in this graph */
  public boolean canAddEdge(Object edge)  {
    if(_edges.contains(edge)) return false;
    Object end0 = null, end1 = null;

    if (edge instanceof MAssociation) {
      List conns = ((MAssociation)edge).getConnections();
      if (conns.size() < 2) return false;
      MAssociationEnd ae0 = (MAssociationEnd) conns.get(0);
      MAssociationEnd ae1 = (MAssociationEnd) conns.get(1);
      if (ae0 == null || ae1 == null) return false;
      end0 = ae0.getType();
      end1 = ae1.getType();
    }

    if (end0 == null || end1 == null) return false;
    if (!_nodes.contains(end0)) return false;
    if (!_nodes.contains(end1)) return false;
    if ( !(( end0 instanceof MClass && end1 instanceof MTaggedValue) ||
	   ( end0 instanceof MTaggedValue && end1 instanceof MClass) ||
	   ( end0 instanceof MClass && end1 instanceof MClass))  ) return false;

    return true;
  }


  /** Add the given edge to the graph, if valid. */
  public void addEdge(Object edge) {
    //System.out.println("adding class edge!!!!!!");
    if ( !canAddEdge(edge) ) return;
    _edges.addElement(edge);

    // needs-more-work: assumes public
    if (edge instanceof MModelElement &&
       ((MModelElement)edge).getNamespace() == null) {
      _model.addOwnedElement((MModelElement) edge);
    }
    fireEdgeAdded(edge);
  }


    /** Remove the given edge from the graph. */
  public void removeEdge(Object edge) {
    if (!_edges.contains(edge)) return;
    _edges.removeElement(edge);
    fireEdgeRemoved(edge);
  }




  public void addNodeRelatedEdges(Object node) {
/*  Achtung Jan
    if ( node instanceof MTaggedValue ) {
      Collection ends = ((MTaggedValue)node).getClientDependencies();
      ends.addAll(((MTaggedValue)node).getSupplierDependencies());
      Iterator iter = ends.iterator();
      while (iter.hasNext()) {
	 MDependency dep = (MDependency) iter.next();
	 if(canAddEdge(dep))  addEdge(dep);
      }
    }
*/
    if ( node instanceof MClass ) {
      Collection ends = ((MClass)node).getAssociationEnds();
      Iterator iter = ends.iterator();
      while (iter.hasNext()) {
	 MAssociationEnd ae = (MAssociationEnd) iter.next();
	 if(canAddEdge(ae.getAssociation()))  addEdge(ae.getAssociation());
      }
    }

  }



  /** Return true if the two given ports can be connected by a
   * kind of edge to be determined by the ports. */
  public boolean canConnect(Object fromP, Object toP) {
    if ( (fromP instanceof MClass) && (toP instanceof MClass) ) return true;
    return false;
  }


  /** Contruct and add a new edge of a kind determined by the ports */
  public Object connect(Object fromPort, Object toPort) {
    System.out.println("should not enter here! connect2");
    return null;
  }

  /** Contruct and add a new edge of the given kind */
  public Object connect(Object fromPort, Object toPort, java.lang.Class edgeClass) {
	 //    System.out.println("connecting: "+fromPort+toPort+edgeClass);

   if (edgeClass == MAssociationImpl.class) {
	MClassifier m1 = (MClassifier) fromPort;
	MClassifier m2 = (MClassifier) toPort;
		MAssociation asc = MMUtil.SINGLETON.buildAssociation(m1, m2);
	    addEdge(asc);
		return asc;
	 }
    else {
	System.out.println("connect: Cannot make a "+ edgeClass.getName() +
	    " between a " + fromPort.getClass().getName() +
			   " and a " + toPort.getClass().getName());
	     return null;
	 }

  }


  ////////////////////////////////////////////////////////////////
  // VetoableChangeListener implementation

  public void vetoableChange(PropertyChangeEvent pce) {
    //throws PropertyVetoException

    if ("ownedElement".equals(pce.getPropertyName())) {
      Vector oldOwned = (Vector) pce.getOldValue();
      MElementImport eo = (MElementImport) pce.getNewValue();
      MModelElement me = eo.getModelElement();

      if (oldOwned.contains(eo)) {
	//System.out.println("model removed " + me);
	if (me instanceof MClass) removeNode(me);
	if (me instanceof MTaggedValue) removeNode(me);
	if (me instanceof MAssociation) removeEdge(me);
      }
      else {
	//System.out.println("model added " + me);
      }
    }
  }


	public void propertySet(MElementEvent mee) {
	}
	public void listRoleItemSet(MElementEvent mee) {
	}
	public void recovered(MElementEvent mee) {
	}
	public void removed(MElementEvent mee) {
	}
	public void roleAdded(MElementEvent mee) {
	}
	public void roleRemoved(MElementEvent mee) {
	}


  static final long serialVersionUID = -2638688086415040146L;

}

