package org.cocons.argo.diagram.atomic_invocation_path.ui;

import java.util.*;
import java.awt.*;
import java.beans.*;
import javax.swing.*;

import org.argouml.uml.diagram.sequence.ui.*;
import ru.novosoft.uml.foundation.core.*;
import java.beans.PropertyVetoException;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.ui.*;

import org.cocons.argo.diagram.atomic_invocation_path.*;

public class CCLAtomicInvocationPathDiagram extends UMLSequenceDiagram {

  static protected int _AtomicInvocationPathDiagramSerial=1;

  protected static Action _actionAddComp;
  protected static Action _actionAddCall;

  public CCLAtomicInvocationPathDiagram() {
    super();
    try { setName("Atomic Invocation Path diagram " + _AtomicInvocationPathDiagramSerial++); }
    catch (PropertyVetoException pve) { }
  }
  public CCLAtomicInvocationPathDiagram(MNamespace m) {
    super(m);
    try { setName("Atomic Invocation Path diagram " + _AtomicInvocationPathDiagramSerial++); }
    catch (PropertyVetoException pve) { }

  }

  public void setNamespace(MNamespace m) {
    super.setNamespace(m);
    AtomicInvocationPathDiagramGraphModel gm = new AtomicInvocationPathDiagramGraphModel();
    gm.setNamespace(m);
    setGraphModel(gm);
    LayerPerspective lay = new SequenceDiagramLayout(m.getName(), gm);
    setLayer(lay);
    AtomicInvocationPathRenderer rend = new AtomicInvocationPathRenderer(); // singleton
    lay.setGraphNodeRenderer(rend);
    lay.setGraphEdgeRenderer(rend);
  }

  /** initialize the toolbar for this diagram type */
  protected void initToolBar() {
    _toolBar = new ToolBar();
    _toolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
//     _toolBar.add(Actions.Cut);
//     _toolBar.add(Actions.Copy);
//     _toolBar.add(Actions.Paste);
//     _toolBar.addSeparator();

    _toolBar.add(_actionSelect);
    _toolBar.add(_actionBroom);
    _toolBar.addSeparator();

	_actionAddComp = new ActionAddComp(_toolBar, this);
	_toolBar.add(_actionAddComp);
    //_toolBar.add(_actionObject);
    _toolBar.addSeparator();

	_actionAddCall = new ActionAddCall();
	//_toolBar.add(_actionAddCall);
    //_toolBar.add(_actionLinkWithStimulusCall);
    //_toolBar.add(_actionLinkWithStimulusCreate);
    //_toolBar.add(_actionLinkWithStimulusDestroy);
    //_toolBar.add(_actionLinkWithStimulusSend);
    //_toolBar.add(_actionLinkWithStimulusReturn);

    // other actions
    _toolBar.addSeparator();

    _toolBar.add(_actionRectangle);
    _toolBar.add(_actionRRectangle);
    _toolBar.add(_actionCircle);
    _toolBar.add(_actionLine);
    _toolBar.add(_actionText);
    _toolBar.add(_actionPoly);
    _toolBar.add(_actionSpline);
    _toolBar.add(_actionInk);
    _toolBar.addSeparator();

    _toolBar.add(_diagramName);
  }


}