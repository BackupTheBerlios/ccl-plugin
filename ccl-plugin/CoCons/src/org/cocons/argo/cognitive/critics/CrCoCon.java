package org.cocons.argo.cognitive.critics;

import org.argouml.cognitive.Decision;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.critics.Critic;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author Fadi Chabarek
 * @version 1.0
 * "abstract" base class. Ressource Bundle nicht über Pluginmechanismus erweiterbar.
 * Daher alle DesignCritics hiervon erben lassen.
 */

public abstract class CrCoCon extends Critic {

  public static final Decision decCONSTRAINT = new
     Decision("Constraint", 5);

  static {
    Designer d = Designer.theDesigner();
    d.startConsidering(decCONSTRAINT);

  }

  public CrCoCon() {


  }

  public abstract boolean predicate(Object dm, Designer dsgr);

}