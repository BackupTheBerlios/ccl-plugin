// Original Author: jgusulde
// $Id: Business_TypeDiagramGraphModel.java,v 1.2 2001/11/13 11:36:05 oetker Exp $

package org.cocons.argo.diagram.business_type;

import java.util.*;
import java.beans.*;

import ru.novosoft.uml.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.behavior.common_behavior.*;
import ru.novosoft.uml.foundation.extension_mechanisms.MStereotype;

import org.tigris.gef.graph.*;

import org.argouml.uml.MMUtil;
import org.cocons.uml.ccl.*;

/** This class defines a bridge between the UML meta-model
 *  representation of the design and the GraphModel interface used by
 *  GEF.  This class handles only UML Class digrams.  */

public class Business_TypeDiagramGraphModel extends MutableGraphSupport
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
    if (nodeOrEdge instanceof MPackage) res.addElement(nodeOrEdge);
    if (nodeOrEdge instanceof MContextPropertyTag) res.addElement(nodeOrEdge);
    if (nodeOrEdge instanceof MAssociation) res.addElement(nodeOrEdge);
    if (nodeOrEdge instanceof MDependency) res.addElement(nodeOrEdge);
    if (nodeOrEdge instanceof MGeneralization) res.addElement(nodeOrEdge);
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
    
    if (port instanceof MPackage) {
      MPackage pa = (MPackage) port;
      Collection sp = pa.getSpecializations();
      if (sp == null) return res; // empty Vector
      Iterator spEnum = sp.iterator();
      while (spEnum.hasNext()) {
	    MGeneralization spG = (MGeneralization) spEnum.next();
	    res.addElement(spG);
      }
      Collection ge = pa.getGeneralizations();
      if ( ge == null) return res;
      Iterator geEnum = ge.iterator();
      while ( geEnum.hasNext() ) {
         MGeneralization geG = (MGeneralization) spEnum.next();
         res.addElement(geG);
      }      
    }
    
    if (port instanceof MContextPropertyTag) {
      MContextPropertyTag cpt = (MContextPropertyTag) port;
      Collection sd = cpt.getSupplierDependencies();
      if (sd == null) return res; // empty Vector
      Iterator it = sd.iterator();
      while (it.hasNext()) {
        MDependency sdmd = (MDependency) it.next();
        res.addElement(sdmd);
      }
      Collection cd = cpt.getClientDependencies();
      if (cd == null) return res; // empty Vector
      it = cd.iterator();
      while (it.hasNext()) {
        MDependency cdmd = (MDependency) it.next();
        res.addElement(cdmd);
      }
    }
   
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
    
    if (edge instanceof MGeneralization) {
      MGeneralization gen = (MGeneralization) edge;
      MGeneralizableElement child = gen.getChild();
      return child;
    }
    
    if (edge instanceof MDependency) {
      MDependency denp = (MDependency) edge;
      Collection clients = denp.getClients();
      return ((Object[])clients.toArray())[0];
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
    
    if (edge instanceof MGeneralization) {
      MGeneralization gen = (MGeneralization) edge;
      MGeneralizableElement parent = gen.getParent();
      return parent;
    }
    
    if (edge instanceof MDependency) {
      MDependency denp = (MDependency) edge;
      Collection supplier = denp.getSuppliers();
      return ((Object[])supplier.toArray())[0];
    }
    //System.out.println("needs-more-work getDestPort");
    return null;
  }


  ////////////////////////////////////////////////////////////////
  // MutableGraphModel implementation

  /** Return true if the given object is a valid node in this graph */
  public boolean canAddNode(Object node) {
    if (_nodes.contains(node)) return false;
    return ( (node instanceof MClass) || (node instanceof MPackage) || 
            (node instanceof MContextPropertyTag) );
  }


  /** Add the given node to the graph, if valid. */
  public void addNode(Object node) {
    //System.out.println("adding class node!!");
    if (!canAddNode(node) ) return;
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
    else if (edge instanceof MGeneralization) {
      end0 = ((MGeneralization)edge).getChild();
      end1 = ((MGeneralization)edge).getParent();
    }
    else if (edge instanceof MDependency) {
      Collection clients = ((MDependency)edge).getClients();
      Collection suppliers = ((MDependency)edge).getSuppliers();
      if (clients == null || suppliers == null) return false;
      end0 = ((Object[])clients.toArray())[0];
      end1 = ((Object[])suppliers.toArray())[0];
    }
    
    if (end0 == null || end1 == null) return false;
    if (!_nodes.contains(end0)) return false;
    if (!_nodes.contains(end1)) return false;
    if ( !( end0 instanceof MClass && end1 instanceof MClass) ) return false;
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
    
    if ( node instanceof MClass ) {
      Collection ends = ((MClass)node).getAssociationEnds();
      Iterator iter = ends.iterator();
      while (iter.hasNext()) {
         MAssociationEnd ae = (MAssociationEnd) iter.next();
         if(canAddEdge(ae.getAssociation()))  addEdge(ae.getAssociation());
      }
    }
    
    
    if ( node instanceof MPackage ) {
      Collection gn = ((MPackage)node).getGeneralizations();
      Iterator iter = gn.iterator();
      while (iter.hasNext()) {
         MGeneralization g = (MGeneralization) iter.next();
         if(canAddEdge(g))  addEdge(g);
      }
      
      Collection sp = ((MPackage)node).getSpecializations();
      iter = sp.iterator();
      while (iter.hasNext()) {
         MGeneralization s = (MGeneralization) iter.next();
         if(canAddEdge(s))  addEdge(s);
      }
    }
    
    
    if ( node instanceof MDependency ) {
      Vector specs = new Vector(((MDependency)node).getClientDependencies());
      specs.addAll(((MDependency)node).getSupplierDependencies());
      Iterator iter = specs.iterator();
      while (iter.hasNext()) {
         MDependency dep = (MDependency) iter.next();
         if(canAddEdge(dep))  addEdge(dep);
      }
    }
  }



  /** Return true if the two given ports can be connected by a
   * kind of edge to be determined by the ports. */
  public boolean canConnect(Object fromP, Object toP) { 
    if ( (fromP instanceof MClass) && (toP instanceof MClass) ) return true;
    else return false; 
  }
 
 
  /** Contruct and add a new edge of a kind determined by the ports */
  public Object connect(Object fromPort, Object toPort) {
    System.out.println("should not enter here! connect2");
    return null;
  }

  /** Contruct and add a new edge of the given kind */
  public Object connect(Object fromPort, Object toPort, java.lang.Class edgeClass) {
	 //    System.out.println("connecting: "+fromPort+toPort+edgeClass);

    if (edgeClass == MGeneralizationImpl.class) {
         MGeneralizableElement child = (MGeneralizableElement) fromPort;
         MGeneralizableElement parent = (MGeneralizableElement) toPort;
			MGeneralization gen = MMUtil.SINGLETON.buildGeneralization(child, parent);
			addEdge(gen);
			return gen;
	 }
	 
    else if (edgeClass == MAssociationImpl.class) {
        MClassifier m1 = (MClassifier) fromPort;
        MClassifier m2 = (MClassifier) toPort;
		  MAssociation asc = MMUtil.SINGLETON.buildAssociation(m1, m2);
 	     addEdge(asc);
		  return asc;
	 }
	 
    else if (edgeClass == MDependencyImpl.class) {
			MModelElement client = (MModelElement) fromPort;
         MModelElement supplier = (MModelElement) toPort;
			MDependency dep = MMUtil.SINGLETON.buildDependency(client, supplier);
			addEdge(dep);
			return dep;
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
        if (me instanceof MPackage) removeNode(me);
        if (me instanceof MContextPropertyTag) removeNode(me);
        if (me instanceof MAssociation) removeEdge(me);
        if (me instanceof MDependency) removeEdge(me);
        if (me instanceof MGeneralization) removeEdge(me);    
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

