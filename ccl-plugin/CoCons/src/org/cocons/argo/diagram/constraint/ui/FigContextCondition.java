package org.cocons.argo.diagram.constraint.ui;

import java.awt.*;
import java.util.*;
import java.beans.*;
import javax.swing.*;

import org.cocons.uml.ccl.*;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;

import org.argouml.uml.diagram.ui.*;


public class FigContextCondition extends FigGroup {

  MContextCondition _owner;

  FigContextCondition()
  {
    this(null);
  }

  FigContextCondition(MContextCondition owner)
  {
    super();
    setOwner(owner);
  }

  void setOwner(MContextCondition owner)
  {
    _owner = owner;
    this.removeAll();
    if (_owner==null)
      this.addFig(new FigRect(0,0,40,40));
  }



}