package org.cocons.argo.cognitive.critics;

import org.argouml.cognitive.critics.Agency;
import org.argouml.cognitive.critics.Critic;

import ru.novosoft.uml.foundation.core.MModelElementImpl;

/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      Technical University of Berlin, Dept. of Computer Science
 * @author Fadi Chabarek, Stefan Tang, Philipp Schumacher
 * @version 1.0
 *
 * A Plugin Initializer registering CCL-supported design critics to ArgoUml.
 *
 */

public class Init implements Runnable {

  /*
   * Constructs an Initilizer
   */
  public Init() {
    super();
  }


  /*
   * Registers the Critics to the Argo Agency singelton.
   */
  public void run() {

    Agency.register(new CrSetToValueIn(), CrSetToValueIn.class);
    Agency.register(new CrNotAllowedToExistIn(), CrNotAllowedToExistIn.class);
  }
}