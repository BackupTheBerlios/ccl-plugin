package org.cocons.argo.diagram.constraint;

import java.util.*;
import java.beans.*;

import ru.novosoft.uml.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.behavior.use_cases.*;
import ru.novosoft.uml.model_management.*;

import org.cocons.uml.ccl.*;
import org.tigris.gef.graph.*;

import org.argouml.uml.MMUtil;

/** This class defines a bridge between the UML meta-model
 *  representation of the design and the GraphModel interface used by
 *  GEF.  This class handles only UML Use Case Digrams.  */

public class ConstraintDiagramGraphModel extends MutableGraphSupport
implements MutableGraphModel, MElementListener {
  ////////////////////////////////////////////////////////////////
  // instance variables
  protected Vector _nodes = new Vector();

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
  public Vector getEdges() { return new Vector(); }

  /** Return all ports on node or edge */
  public Vector getPorts(Object nodeOrEdge) { return new Vector(); }

  /** Return the node or edge that owns the given port */
  public Object getOwner(Object port) {
    return port;
  }

  /** Return all edges going to given port */
  public Vector getInEdges(Object port) {
    return new Vector();
  }

  /** Return all edges going from given port */
  public Vector getOutEdges(Object port) {
    return new Vector(); // needs-more-work?
  }

  /** Return one end of an edge */
  public Object getSourcePort(Object edge) {
    return null;
  }

  /** Return  the other end of an edge */
  public Object getDestPort(Object edge) {
    return null;
  }


  ////////////////////////////////////////////////////////////////
  // MutableGraphModel implementation

  /** Return true if the given object is a valid node in this graph */
  public boolean canAddNode(Object node) {
    return (node instanceof MContextbasedConstraint ||
            node instanceof MClass) ;
  }

  /** Return true if the given object is a valid edge in this graph */
  public boolean canAddEdge(Object edge)  {
    return false;
  }

  /** Remove the given node from the graph. */
  public void removeNode(Object node) {
    if (!_nodes.contains(node)) return;
    _nodes.removeElement(node);
    fireNodeRemoved(node);
  }

  /** Add the given node to the graph, if valid. */
  public void addNode(Object node) {
    if (_nodes.contains(node)) return;
    _nodes.addElement(node);
      if (node instanceof MContextbasedConstraint) {
      	_model.addOwnedElement((MContextbasedConstraint) node);
      }
      // Test
      if (node instanceof MClass) {
      	_model.addOwnedElement((MClass) node);
      }
    fireNodeAdded(node);
  }

  /** Add the given edge to the graph, if valid. */
  public void addEdge(Object edge) {
  }

  public void addNodeRelatedEdges(Object node) {
  }


  /** Remove the given edge from the graph. */
  public void removeEdge(Object edge) {
  }

  /** Return true if the two given ports can be connected by a
   * kind of edge to be determined by the ports. */
  public boolean canConnect(Object fromP, Object toP) {
    return false;
  }


  /** Contruct and add a new edge of a kind determined by the ports */
  public Object connect(Object fromPort, Object toPort) {
    System.out.println("should not enter here! connect2");
    return null;
  }

  /** Contruct and add a new edge of the given kind */
  public Object connect(Object fromPort, Object toPort,
			java.lang.Class edgeClass)
  {
    return null;
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
    if (mee.getSource() == _model)
    {
      // something was removed from the model
      Object removed = mee.getRemovedValue();
      if ( "ownedElement".equals(mee.getName()) )
      {
        if (_nodes.contains(removed))
          _nodes.removeElement(removed);
      }
    }
	}

} /* end class UseCaseDiagramGraphModel */

