package org.cocons.argo.critics;

import org.argouml.cognitive.critics.Agency;
import org.argouml.cognitive.critics.Critic;

import ru.novosoft.uml.foundation.core.MModelElementImpl;

/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Fadi Chabarek
 * @version 1.0
 *
 * A Plugin Initializer registering CCL-supported design critics to ArgoUml.
 *
 */

public class Init implements Runnable {

  public static Critic readabilityCritic = new CrConstrainedReadability();

  /*
   * Constructs an Initilizer
   */
  public Init() {
    super();
  }


  /*
   * Registers the UnReadableBy Critic to the Argo Agency singelton.
   */
  public void run() {

    java.lang.Class modelElementCls = MModelElementImpl.class;

    Agency.register(readabilityCritic, modelElementCls);


  }
}