/*
 * FigBody.java
 * Created on 11. Februar 2002, 00:11
 */

package org.cocons.argo.diagram.csecomponent.ui;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.model_management.*;

import org.argouml.application.api.*;
import org.argouml.language.helpers.*;
import org.argouml.uml.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.generator.*;
import org.argouml.uml.diagram.ui.*;
import org.argouml.uml.diagram.static_structure.ui.*;
import org.argouml.ui.*;


public class FigBody extends FigGroup{    
    MClass _owner;
    FigBody(){
        this(null);
         }
    FigBody(MClass owner){
        super();
        setOwner(owner);
    }
void setOwner(MClass owner){
    _owner = owner;
    this.removeAll();
    if(_owner== null)
        this.addFig(new FigRect(10,10,120,60));
    }
}
