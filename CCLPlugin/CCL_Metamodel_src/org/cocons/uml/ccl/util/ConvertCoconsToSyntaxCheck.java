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
     private String [] condition= {"=",
								   "!=",
								   "<",
								   ">",
								   "<=",
								   ">="
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

    public String apostropheConvert (String cocons) {
		String result = "";
		int counter = 0;
		Vector fetchString = new Vector();
		if (cocons.equals("") || cocons != null) {
			StringTokenizer st = new StringTokenizer(cocons, "\"", true);
			while (st.hasMoreTokens()) {
				 fetchString.addElement(st.nextToken());
			}
		}
		else {
			fetchString.addElement("null");
        }

		if (! ((fetchString.get(0)).toString()).equals("\"")) {
			result = (fetchString.get(0)).toString();
		}
		else {
			result = "'";
		}

		for (int i = 1; i < fetchString.size(); i++) {
			if (! ((fetchString.get(i)).toString()).equals("\"")) {
				if (counter%2 == 0) {
					result = result + " "+(fetchString.get(i)).toString();
				}
				else {
					result = result + (fetchString.get(i)).toString();
				}
			}
			else {
				counter++;
				result = result + "'";
			}
		}
		return result;
	}

	public String conditionConvert (String cocons, String condition) {
		String result = "";
		int counter = 0;
		Vector fetchString = new Vector();
		if (cocons.equals("") || cocons != null) {
			StringTokenizer st = new StringTokenizer(cocons, condition, true);
			while (st.hasMoreTokens()) {
				 fetchString.addElement(st.nextToken());
			}
		}
		else {
			fetchString.addElement("null");
		}

		if (1 < fetchString.size()) {
			result = (fetchString.get(0)).toString();
			for (int i = 1; i < fetchString.size(); i++) {
				if (! ((fetchString.get(i)).toString()).equals(condition)) {
					result = result + " "+(fetchString.get(i)).toString();
				}
				else {
					result = result + " " + condition + " ";
				}
			}
			return result;
		}
		else {
			return cocons;
		}
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
        String _cocons = "";
        String finalString = "";
        _cocons = apostropheConvert(cocons);
        for (int cCounter = 0; cCounter < condition.length; cCounter++) {
			_cocons = conditionConvert(_cocons, condition[cCounter]);
		}
        Vector elements = new Vector();
        elements = fetchStringDetail(_cocons);
        Vector convert = new Vector();
        convert = newConvert(toConvertString, elements);
        for (int i = 0; i < convert.size() - 1; i++) {
            finalString = finalString + (convert.get(i)).toString() + " ";
        }
        finalString = finalString + (convert.lastElement()).toString();
        return finalString;
    }

    /*
	 * main methode for test
	 */

	public static void main(String args[]) {
		//String cocons = "ALL CLASSES WHERE personal 'data' = 'yes' OR THE componets 'test runtime' OR THE componets 'test upload'  MUST BE UnreadableBy THE component 'Datawarehouse' WITH 'PRIORITY' = '5'";
		//String cocons = "ALL COMPONENTS WHERE ('personal data' = 'yes' AND 'public' = 'false' AND 'value1' = 'const1') OR 'Operatinal Area' = 'Headquartes' OR 'Workflow' CONTAINS 'New Customer' OR ALL componets WHERE 'test time' EQUALS 'systemruntime' OR THE component 'Systemcheck' MUST BE UnreadableBy THE component 'Datawarehouse' WITH 'PRIORITY' = '5' AND 'n' = '3' ";
		//String cocons ="ALL COMPONENTS WHERE 'Personal Data' EQUALS 'Yes' MUST BE UnreadableBy ALL COMPONENTS WHERE 'Operational Area' CONTAINS 'Controlling'";
		//String cocons ="ALL COMPONENTS WHERE 'Personal Data' EQUALS 'Yes' MUST BE UnreadableBy ";
		String cocons ="all COMPONENTS WHERE \"Personal Data\" EQUALS \"Yes' MUST BE UnreadableBy ALL COMPONENTS WHERE 'Personal Data' EQUALS 'Yes' OR ALL COMPONENTS WHERE ('Personal Data' EQUALS 'Yes' AND 'y'='x') or 'dfgss'='wwwww\"";
		//String cocons ="all COMPONENTS where 'Personal Data' equals 'Yes' MUST BE UnreadableBy All COMPONENTS Where ('Personal Data' EQUALS 'Yes' and 'y' = 'x')";
		//String cocons ="THE component 'Systemcheck' MUST BE UnreadableBy THE component 'Datawarehouse'";
		//String cocons =" the component 'Systemcheck' MUST BE UnreadableBy THE component 'Datawarehouse' OR THE component 'Datawarehouse'";
		//String cocons ="MUST BE UnreadableBy THE component 'Systemcheck'";

		//SyntaxcheckOfCoconsFromBNF coconsBNF = new SyntaxcheckOfCoconsFromBNF();
		//coconsBNF.printNoEmptyElementHashtable(coconsBNF.parserCoCons(cocons));
		//coconsBNF.printAllElementHashtable(coconsBNF.parserCoCons(cocons));
		//
		//
		//checklevel1
		//System.out.println("###### final ######"+ coconsBNF.isValid(cocons));
		//System.out.println("-------------------------------------------------");
		ConvertCoconsToSyntaxCheck convert2 = new ConvertCoconsToSyntaxCheck();
		System.out.println(cocons);
		System.out.println("-------------------------------------------------");
		System.out.println(convert2.finalConvert(cocons));
		//System.out.println(coconsBNF.getFirstComparison("ALL COMPONENTS WHERE ('personal data' = 'yes' AND 'public' = 'false' AND 'value1' = 'const1') OR 'Operatinal Area' = 'Headquartes' OR 'Workflow' CONTAINS 'New Customer'"));
   }

}
