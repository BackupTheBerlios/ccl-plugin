package org.cocons.argo.util;

import java.util.Vector;

/**
 * Title:        CCL-Plugin for ArgoUML
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      Technische Universit�t Berlin
 * @author hyshosha@gmx.de ; hasihola@cs.tu-berlin.de
 * @version 1.0
 */

public class VCPLTranslator {

  public VCPLTranslator() {
  }

  /////////////////////////////////////////////////////////////////////////////
  // main methods -> setzen Korrektheit der �bergebenen Strings im Sinne der
  //                 "VCPL-Syntax" voraus !!!

  public boolean validValueIsListOfStrings(String constraintBody) {
    if (constraintBody.substring(0,2).equals("\"L")) return(true);
    else return(false);
  }

  public boolean validValueIsIntegerNumber(String constraintBody) {
    if (constraintBody.substring(0,2).equals("\"I")) return(true);
    else return(false);
  }

  public boolean validValueIsFloatNumber(String constraintBody) {
    if (constraintBody.substring(0,2).equals("\"F")) return(true);
    else return(false);
  }

  public String getUnit(String constraintBody) {
    String test = constraintBody.substring(0,2);
    String unit = "";
    if (test.equals("\"L")) {return("N/A");}
    else if (test.equals("\"I")) {return(parseUnit(constraintBody));}
    else if (test.equals("\"F")) {return(parseUnit(constraintBody));}
    else {return("N/A");}
  }

  public Vector getValidStrings(String constraintBody) {
    Vector strings = new Vector();
    int beginIndex = 0;
    int endIndex = 0;
    boolean go_on = true;
    for (int i = 0; i < constraintBody.length(); i++) {
      if (constraintBody.charAt(i) == '[') beginIndex = i;
      else if (constraintBody.charAt(i) == ']') {endIndex = i;go_on = false;}
      else {}
    }
    int startIndex = beginIndex;
    for (int i = startIndex; i <= endIndex; i++) {
      if ((constraintBody.charAt(i)==',')||(constraintBody.charAt(i)==']')) {
        strings.addElement(constraintBody.substring(beginIndex+1,i));
        beginIndex = i;
      }
    }
    //for (int i = 0; i < strings.size(); i++)
    //System.out.println((String)strings.elementAt(i));
    return(strings);
  }

  public int[] getIntegerRange(String constraintBody) {
    int[] intRange = new int[2];
    int beginIndex = 0;
    int commaIndex = 0;
    int endIndex = 0;
    boolean go_on = true;
    for (int i = 0; i < constraintBody.length(); i++) {
      if (constraintBody.charAt(i) == '[') beginIndex = i;
      else if (constraintBody.charAt(i) == ',') commaIndex = i;
      else if (constraintBody.charAt(i) == ']') {endIndex = i;go_on = false;}
      else {}
    }
    if ((beginIndex+1==commaIndex)&&(commaIndex+1==endIndex)) {
      intRange[0] = Integer.MIN_VALUE;
      intRange[1] = Integer.MAX_VALUE;
    }
    else if ((beginIndex+1==commaIndex)&&(commaIndex+1!=endIndex)) {
      intRange[0] = Integer.MIN_VALUE;
      intRange[1] = Integer.parseInt(constraintBody.substring(commaIndex+1,endIndex));
    }
    else if ((beginIndex+1!=commaIndex)&&(commaIndex+1==endIndex)) {
      intRange[0] = Integer.parseInt(constraintBody.substring(beginIndex+1,commaIndex));
      intRange[1] = Integer.MAX_VALUE;
    }
    else {
      intRange[0] = Integer.parseInt(constraintBody.substring(beginIndex+1,commaIndex));
      intRange[1] = Integer.parseInt(constraintBody.substring(commaIndex+1,endIndex));
    }
    //System.out.println("Lower: "+intRange[0]+" ; Upper: "+intRange[1]);
    return(intRange);
  }

  public float[] getFloatRange(String constraintBody) {
    float[] floatRange = new float[2];
    int beginIndex = 0;
    int commaIndex = 0;
    int endIndex = 0;
    boolean go_on = true;
    for (int i = 0; i < constraintBody.length(); i++) {
      if (constraintBody.charAt(i) == '[') beginIndex = i;
      else if (constraintBody.charAt(i) == ',') commaIndex = i;
      else if (constraintBody.charAt(i) == ']') {endIndex = i;go_on = false;}
      else {}
    }
    if ((beginIndex+1==commaIndex)&&(commaIndex+1==endIndex)) {
      floatRange[0] = Float.MAX_VALUE * -1;
      floatRange[1] = Float.MAX_VALUE;
    }
    else if ((beginIndex+1==commaIndex)&&(commaIndex+1!=endIndex)) {
      floatRange[0] = Float.MAX_VALUE * -1;
      floatRange[1] = Float.parseFloat(constraintBody.substring(commaIndex+1,endIndex));
    }
    else if ((beginIndex+1!=commaIndex)&&(commaIndex+1==endIndex)) {
      floatRange[0] = Float.parseFloat(constraintBody.substring(beginIndex+1,commaIndex));
      floatRange[1] = Float.MAX_VALUE;
    }
    else {
      floatRange[0] = Float.parseFloat(constraintBody.substring(beginIndex+1,commaIndex));
      floatRange[1] = Float.parseFloat(constraintBody.substring(commaIndex+1,endIndex));
    }
    //System.out.println("Lower: "+floatRange[0]+" ; Upper: "+floatRange[1]);
    return(floatRange);
  }

  //////////////////////////////////////////////////////////////////////////////
  // private methods
  private String parseUnit(String constraintBody) {
    int index = 0;
    int i = constraintBody.length()-1;
    while (constraintBody.charAt(i) != '|') i--;
    return(constraintBody.substring(i+7));
  }

  //////////////////////////////////////////////////////////////////////////////
  // folgende Methoden nur f�r Tag-Erzeugung benutzen !!!
  public boolean checkListOfStrings(String string) {
    /* Regeln: (kann man beliebig erweitern)
       - zulaessige Zeichen: Buchstaben, Zahlen, "-" und "_"
       - Strings durch Kommata getrennt
       - als erstes und letztes Zeichen des �bergebenen Strings wird
         ein zul�ssiges Zeichen (s.o.) erwartet
       - Leerzeichen sind unzul�ssig
       - aufeinanderfolgende Kommata sind unzul�ssig
    */
    // Test auf korrekten Anfang und korrektes Ende
    if (!(isValidCharacter_ListOfStrings(string.charAt(0))&&isValidCharacter_ListOfStrings(string.charAt(string.length()-1)))) return(false);
    // Test, ob nur Kommata und zul�ssige Zeichen
    for (int i = 0; i < string.length(); i++) {
      char sign = string.charAt(i);
      if (!(isValidCharacter_ListOfStrings(sign)||(sign==','))) return(false);
    }
    // Test auf aufeinanderfolgende Kommata
    for (int i = 0; i < string.length()-1; i++) {
      if (string.charAt(i)==',')
        if (string.charAt(i+1)==',') return(false);
    }
    return(true);
  }

  private boolean isValidCharacter_ListOfStrings(char sign) {
    if (Character.isLetter(sign)||Character.isDigit(sign)||(sign=='-')||(sign=='_')) return(true);
    else return(false);
  }

  public String getConstraintString_ListOfStrings(String string) {
    return("\"List Of Strings\" ["+string+"]");
  }

  public boolean checkIntegerNumberRange(String integerRange) {
    /* Regeln: (kann man beliebig erweitern)
       - zulaessige Zeichen: Zahlen, "-"
       - LowerValue und UpperValue durch "," getrennt
       - als erstes Zeichen wird "[" erwartet
       - als letztes Zeichen wird "]" erwartet
       - Leerzeichen sind unzul�ssig
       - "[,]" steht f�r keine Range
       - "[,xxx]" steht f�r fehlende untere Grenze
       - "[xxx,]" steht f�r fehlende obere Grenze
    */
    if (integerRange.equals("[,]")) return(true);
    if (integerRange.length()<3) return(false);
    if ((integerRange.charAt(0)!='[')||(integerRange.charAt(integerRange.length()-1)!=']')) return(false);
    int commaCount = 0;
    int commaIndex = 0;
    for (int i = 1; i < integerRange.length()-1;i++) {
      if (!((integerRange.charAt(i)==',')||Character.isDigit(integerRange.charAt(i))||(integerRange.charAt(i)=='-'))) return(false);
      if (integerRange.charAt(i)==',') {
        commaCount++;
        commaIndex = i;
      }
    }
    if (commaCount!=1) return(false);
    int test1_int = 0;
    boolean test1_set = false;
    if (!(integerRange.substring(0,2).equals("[,"))) {
      String test1 = integerRange.substring(1,commaIndex);
      try {
        test1_int = Integer.parseInt(test1);
        test1_set = true;
      }
      catch (NumberFormatException nfe) {return(false);}
    }
    int test2_int = 0;
    boolean test2_set = false;
    if (!(integerRange.substring(integerRange.length()-2).equals(",]"))) {
      String test2 = integerRange.substring(commaIndex+1,integerRange.length()-1);
      try {
        test2_int = Integer.parseInt(test2);
        test2_set = true;
      }
      catch (NumberFormatException nfe) {return(false);}
    }
    if (test1_set&&test2_set&&(test1_int >= test2_int)) return(false);
    return(true);
  }

  public String getConstraintString_Integer(String string) {
    return("\"Integer Number\" Range "+string);
  }

  public boolean checkFloatNumberRange(String floatRange) {
    /* Regeln: (kann man beliebig erweitern)
       - zulaessige Zeichen: Zahlen, "-", "."
       - LowerValue und UpperValue durch "," (Komma) getrennt
       - als erstes Zeichen wird "[" erwartet
       - als letztes Zeichen wird "]" erwartet
       - Leerzeichen sind unzul�ssig
       - "[,]" steht f�r keine Range
       - "[,xxx]" steht f�r fehlende untere Grenze
       - "[xxx,]" steht f�r fehlende obere Grenze
    */
    if (floatRange.equals("[,]")) return(true);
    if (floatRange.length()<3) return(false);
    if ((floatRange.charAt(0)!='[')||(floatRange.charAt(floatRange.length()-1)!=']')) return(false);
    int commaCount = 0;
    int commaIndex = 0;
    for (int i = 1; i < floatRange.length()-1;i++) {
      if (!((floatRange.charAt(i)==',')||Character.isDigit(floatRange.charAt(i))||(floatRange.charAt(i)=='-')||(floatRange.charAt(i)=='.'))) return(false);
      if (floatRange.charAt(i)==',') {
        commaCount++;
        commaIndex = i;
      }
    }
    if (commaCount!=1) return(false);
    float test1_float = 0;
    boolean test1_set = false;
    if (!(floatRange.substring(0,2).equals("[,"))) {
      String test1 = floatRange.substring(1,commaIndex);
      try {
        test1_float = Float.parseFloat(test1);
        test1_set = true;
      }
      catch (NumberFormatException nfe) {return(false);}
    }
    float test2_float = 0;
    boolean test2_set = false;
    if (!(floatRange.substring(floatRange.length()-2).equals(",]"))) {
      String test2 = floatRange.substring(commaIndex+1,floatRange.length()-1);
      try {
        test2_float = Float.parseFloat(test2);
        test2_set = true;
      }
      catch (NumberFormatException nfe) {return(false);}
    }
    if (test1_set&&test2_set&&(test1_float >= test2_float)) return(false);
    return(true);
  }

  public String getConstraintString_Float(String floatRange) {
    if (floatRange.equals("[,]")) return("\"Float Number\" Range " + floatRange);
    int commaIndex = 0;
    for (int i = 1; i < floatRange.length()-1;i++) {
      if (floatRange.charAt(i)==',') {
        commaIndex = i;
      }
    }
    float test1_float = 0;
    boolean test1_set = false;
    String test1 = "[";
    if (!(floatRange.substring(0,2).equals("[,"))) {
      test1 = floatRange.substring(1,commaIndex);
      try {
        test1_float = Float.parseFloat(test1);
        test1_set = true;
        test1 = "[" + Float.toString(test1_float);
      }
      catch (NumberFormatException nfe) {return(null);}
    }
    float test2_float = 0;
    boolean test2_set = false;
    String test2 = "]";
    if (!(floatRange.substring(floatRange.length()-2).equals(",]"))) {
      test2 = floatRange.substring(commaIndex+1,floatRange.length()-1);
      try {
        test2_float = Float.parseFloat(test2);
        test2_set = true;
        test2 = Float.toString(test2_float) + "]";
      }
      catch (NumberFormatException nfe) {return(null);}
    }
    return("\"Float Number\" Range "+test1+","+test2);
  }

}