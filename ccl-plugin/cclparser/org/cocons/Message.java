package org.cocons;

import ru.novosoft.uml.foundation.core.MModelElement;
/**
 * <p>Überschrift: </p>
 * <p>Beschreibung: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Organisation: </p>
 * @author Ute von Angern
 * @version 1.0
 */

public class Message {
  /**
   * switch on/off Informations
   */
  private boolean infos = true;

  /**
   * switch on/off Debugmessage
   */
  private boolean debugs = true;


  public Message() {
  }

  public void info(String className, String method, String inf) {
    if(infos) {
      System.out.println("Class: " + className + " | " + "Method: " + method + " | " + "Info: " + inf);
    }
  }

  public void debug(String className, String method, String deb) {
    if(infos) {
      System.out.println("Class: " + className + " | " + "Method: " + method + " | " + "Info: " + deb);
    }
  }


}