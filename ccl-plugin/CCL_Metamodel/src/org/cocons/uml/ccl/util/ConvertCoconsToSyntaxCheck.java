package org.cocons.uml.ccl.util;


import java.util.*;
import java.text.*;
import java.lang.*;
/**
 * Title:        ConvertCoconsToSyntaxCheck
 * Description:
 * Copyright:    Copyright (c) 2001-2002
 * Company:      TU Berlin, CIS
 * @author Nghia Dang Duc (dangdoni@cs.tu-berlin.de)
 * @version 1.1
 * @date    02/03/2002  22:14
 */

 public class ConvertCoconsToSyntaxCheck {

     private String _cocons;
     private String[] toConvertString = {"All",
                                         "all",
                                         "The",
                                         "the",
                                         "Where",
                                         "where",
                                         "Equals",
                                         "equals",
                                         "Contains",
                                         "contains",
                                         "Does Not Contain",
                                         "does not contain",
                                         "And",
                                         "and",
                                         "Or",
                                         "or"
                                        };

     /**
      * SyntaxcheckOfCoconsFromBNF constructor comment.
      */
     public ConvertCoconsToSyntaxCheck () {
         super();
     }
     /**
      * SyntaxcheckOfCoconsFromBNF constructor comment.
      * @param cocons java.lang.String
      */
     public ConvertCoconsToSyntaxCheck (String cocons) {
         super();
         _cocons = cocons;
    }

    public String convertToUpperCase (String toConvert) {
        String convert = "";
        if (toConvert != null && !toConvert.equals("")) {
            char [] charArray = toConvert.toCharArray();
            int jconter = 0;
            jconter = charArray.length;
            for(int i = 0; i < jconter; i++) {
                if (java.lang.Character.isLowerCase(charArray[i])) {
                    convert = convert + (java.lang.Character.toUpperCase(charArray[i]));
                }
                else {
                    convert = convert + (charArray[i]);
                }
            }
            return convert;
        }
        else {
            return convert;
        }
    }

    public Vector fetchStringDetail (String cocons) {
        Vector fetchString = new Vector();
        if (cocons.equals("") || cocons != null) {
            StringTokenizer st = new StringTokenizer(cocons);
            while (st.hasMoreTokens()) {
                 fetchString.addElement(st.nextToken());
            }
            return fetchString;
        }
        else {
            fetchString.addElement("null");
            return fetchString;
        }

    }

    public boolean isInCocons (String search, Vector elements) {
        boolean isIn = false;
        if(( null != elements ) || (0< elements.size())){
            for (int i = 0; i < elements.size(); i++) {
                if (search.equals((elements.get(i)).toString())) {
                    isIn = true;
                    break;
                }
            }
            return isIn;
        }
        else {
            return isIn;
        }

    }

    public int counterIn (String search, Vector elements) {
        int counter = 0;
        if(( null != elements ) || (0< elements.size())){
            for (int i = 0; i < elements.size(); i++) {
                if (search.equals((elements.get(i)).toString())) {
                    counter++;
                }
                else counter = counter;
            }
            return counter;
        }
        else {
            return counter;
        }
    }

    public Vector positionOfString (String search, Vector elements) {
        Vector position = new Vector();
        if (elements != null) {
            for (int i = 0; i < elements.size(); i++) {
                if (search.equals((elements.get(i)).toString())) {
                    position.addElement(""+i);
                }
            }
        }

        return position;

    }

    public Vector newConvert (String [] search,Vector elements) {
        Vector convert = new Vector();
        convert = elements;
        for (int icounter = 0; icounter < search.length; icounter++) {
            if (isInCocons(search[icounter],elements)) {
                Vector pos = new Vector();
                pos = positionOfString (search[icounter], elements);
                for (int i = 0; i < pos.size(); i++) {
                    int index = Integer.parseInt((pos.get(i)).toString());
                    String obj = "";
                    obj = convertToUpperCase(search[icounter]);
                    convert.setElementAt(obj,index);
                }
            }
            elements = convert;
        }
        return convert;
    }

    public String finalConvert (String cocons) {
        String finalString = "";
        Vector elements = new Vector();
        elements = fetchStringDetail(cocons);
        Vector convert = new Vector();
        convert = newConvert(toConvertString, elements);
        for (int i = 0; i < convert.size() - 1; i++) {
            finalString = finalString + (convert.get(i)).toString() + " ";
        }
        finalString = finalString + (convert.lastElement()).toString();
        return finalString;
    }
}
