package org.cocons.uml.ccl.util;
import java.util.*;
import java.text.*;
import java.lang.*;
/**
 * Title:        SyntaxcheckOfCoconsFromBNF
 * Description:
 * Copyright:    Copyright (c) 2001-2002
 * Company:      TU Berlin, CIS
 * @author Nghia Dang Duc (dangdoni@cs.tu-berlin.de)
 * @version 1.1
 * @date    02/01/2002  05:14
 */

/*
 * no implement method getRange of Range ::= | Number | `[' LowerBoundNumber `,' UpperBoundNumber `]'
 * Range of ContextCondition from indirect Element
 */
/*
    CoCon ::= ElementSelection+OR `MUST BE ...'
    ElementSelection+OR [`WITH'
    Attribute+AND]
    ElementSelection ::= ContextCondition | DirectSelection | `THIS'
    DirectSelection ::= `THE' Restriction ElementName
    ContextCondition ::= Range (Restrictions | `ELEMENTS')
    [`WHERE' ContextQuery+AND or OR]
    Range ::= `ALL' | Number | `[' LowerBoundNumber `,'
    UpperBoundNumber `]'
    ContextQuery ::= ContextPropertyName Condition
    (ContextPropertyValue | SetOfConPropValues)
    SetOfConPropValues ::= (`{' (ContextPropertyValue)+Comma`}') | ContextPropertyName
    Condition ::= `CONTAINS' | `DOES NOT CONTAIN' | `=' | `!=' | `<' | `>' | `<=' | `>='
    Attribute ::= (`CoConNAME =' Name) | (`PRIORITY ='PriorityValue)
*/
public class SyntaxcheckOfCoconsFromBNF {

    private String _cocons;

    public String[] coconTypeName = { "UNWRITEABLEBY",
                                      "WRITEABLEBY",
                                      "UNREADABLEBY",
                                      "READABLEBY",
                                      "ONLYWRITEABLEBY",
                                      "ONLYREADABLEBY"};

    public String[] condition = {"EQUALS",
                                  "CONTAINS",
                                  "DOES NOT CONTAIN",
                                  "=",
                                  "!=",
                                  "<",
                                  ">",
                                  "<=",
                                  ">="};
    public String[] keys = {"Context-Based Constraints"
                            ,"TargetSet"
                            ,"CoConsType"
                            ,"ScopeSet"

                            ,"ElementSelection of TargetSet"
                            ,"ElementSelection of ScopeSet"

                            ,"IndirectSelection of TargetSet"
                            ,"DirectSelection of TargetSet"
                            ,"IndirectSelection of ScopeSet"
                            ,"DirectSelection of ScopeSet"

                            ,"Range Of IndirectElement From TargetSet"
                            ,"Range Of IndirectElement From ScopeSet"
                            ,"Range Of DirectElement From TargetSet"
                            ,"Range Of DirectElement From ScopeSet"

                            ,"Restriction Of IndirectElement From TargetSet"
                            ,"Restriction Of IndirectElement From ScopeSet"
                            ,"Restriction Of DirectElement From TargetSet"
                            ,"Restriction Of DirectElement From ScopeSet"

                            ,"ElementName Of DirectElement From TargetSet"
                            ,"ElementName Of DirectElement From ScopeSet"
                            ,"ContextQuerys Of IndirectElement From TargetSet"
                            ,"ContextQuerys Of IndirectElement From ScopeSet"

                            ,"ContextQuery Of IndirectElement From TargetSet"
                            ,"ContextQuery Of IndirectElement From ScopeSet"

                            ,"ContextQueryDetail Of IndirectElement From TargetSet"
                            ,"ContextQueryDetail Of IndirectElement From ScopeSet"
                            };
    public String[] indirectWithAND = {"("
                                        ,")"
                                       };
    public String markValue = "'";
    /**
     * SyntaxcheckOfCoconsFromBNF constructor comment.
     */
    public SyntaxcheckOfCoconsFromBNF() {
        super();
    }
    /**
     * SyntaxcheckOfCoconsFromBNF constructor comment.
     * @param cocons java.lang.String
     */
    public SyntaxcheckOfCoconsFromBNF(String cocons) {
        super();
        _cocons = cocons;
    }

    /**
     * @methode: exitedMUSTBE
     * @param cocons java.lang.String
     * @return exited java.lang.Boolean.
     */

    public boolean exitedMUSTBE( String cocons) {
        boolean exited = false;
        Vector elements = new Vector();
        StringTokenizer st = new StringTokenizer(cocons);
        while (st.hasMoreTokens()) {
             elements.addElement(st.nextToken());
        }
        int i = 0;
        while (i < elements.size() -1) {
            if(!((elements.get(i)).toString()).equals("MUST") && !((elements.get(i+1)).toString()).equals("BY")) {
                exited = false;
            }
            else {
                exited = true;
                break;
            }
            i++;
        }
        return exited;
    }

    /**
     * @methode: exitedWHERE
     * @param cocons java.lang.String
     * @return exited java.lang.Boolean.
     */

    public boolean exitedWHERE( String cocons) {
        boolean exited = false;
        Vector elements = new Vector();
        StringTokenizer st = new StringTokenizer(cocons);
        while (st.hasMoreTokens()) {
             elements.addElement(st.nextToken());
        }
        int i = 0;
        while (i < elements.size() -1) {
            if(!((elements.get(i)).toString()).equals("WHERE")) {
                exited = false;
            }
            else {
                exited = true;
                break;
            }
            i++;
        }
        return exited;
    }

    /**
     * @methode: exitedCondition
     * @param cocons java.lang.String
     * @return exited java.lang.Boolean.
     */

    public boolean exitedCondition( String cocons) {
        boolean exited = false;
        Vector elements = new Vector();
        StringTokenizer st = new StringTokenizer(cocons);
        while (st.hasMoreTokens()) {
             elements.addElement(st.nextToken());
        }
        int i = 0;
        while (i < elements.size() -1) {
            for (int j = 0; j < condition.length; j++) {
                if(((elements.get(i)).toString()).equals(condition[j])) {
                    exited = true;
                    break;
                }
                else {
                    exited = false;
                }
            }
            if(exited == true) break;
            i++;
        }
        return exited;
    }

    /**
     * @methode: exitedKey
     * @param element java.lang.String, key java.lang.String
     * @return exited java.lang.Boolean.
     */

    public boolean exitedKey( String element, String key) {
        boolean exited = false;
        Vector elements = new Vector();
        StringTokenizer st = new StringTokenizer(element);
        while (st.hasMoreTokens()) {
             elements.addElement(st.nextToken());
        }
        int i = 0;
        while (i < elements.size()) {
            if(!((elements.get(i)).toString()).equals(key)) {
                exited = false;
            }
            else {
                exited = true;
                break;
            }
            i++;
        }
        return exited;
    }



    /**
     * @methode: checkMarkValue
     * @param cocons java.lang.String
     * @return check java.lang.Boolean.
     */
    public boolean checkMarkValue( String cocons) {
        boolean check = false;
        if(!exitedCondition(cocons)) {
            check = true;
            return check;
        }
        else {
            Vector element = new Vector();
            StringTokenizer stc = new StringTokenizer(cocons);
            while (stc.hasMoreTokens()) {
                 element.addElement(stc.nextToken());
            }
            int conterOfCondition = 0;
            int i = 0;
            while (i < element.size() -1) {
                for (int j = 0; j < condition.length; j++) {
                    if(((element.get(i)).toString()).equals(condition[j])) {
                        conterOfCondition++;
                    }
                    else {
                        conterOfCondition = conterOfCondition;
                    }
                }
                i++;
            }
            Vector elements = new Vector();
            StringTokenizer st = new StringTokenizer(cocons,"'",true);
            while (st.hasMoreTokens()) {
                 elements.addElement(st.nextToken());
            }

            int conterOfMark = 0;
            int j = 0;
            while (j < elements.size()) {
                if(((elements.get(j)).toString()).equals(markValue)) {
                    conterOfMark++;
                }
                else {
                    conterOfMark = conterOfMark;
                }
                j++;
            }

            if ((conterOfMark % 2 == 0)) {
                check = true;
            }
            else check = false;
            return check;
        }
    }

    /**
     * @methode: checkClip
     * @param cocons java.lang.String
     * @return check java.lang.Boolean.
     */
    public boolean checkClip ( String cocons) {
        boolean check = false;
        if(exitedKey(cocons, "OR") && exitedKey(cocons, "AND")){
            Vector element1 = new Vector();
            StringTokenizer st1 = new StringTokenizer(cocons, indirectWithAND[0],true);
            while (st1.hasMoreTokens()) {
                 element1.addElement(st1.nextToken());
            }
            int conterOfClip1 = 0;
            int i1 = 0;
            while (i1 < element1.size()) {
                if(((element1.get(i1)).toString()).equals(indirectWithAND[0])) {
                    conterOfClip1++;
                }
                else {
                    conterOfClip1 = conterOfClip1;
                }
                i1++;
            }

            Vector element2 = new Vector();
            StringTokenizer st2 = new StringTokenizer(cocons, indirectWithAND[1],true);
            while (st2.hasMoreTokens()) {
                 element2.addElement(st2.nextToken());
            }
            int conterOfClip2 = 0;
            int i2 = 0;
            while (i2 < element2.size()) {
                if(((element2.get(i2)).toString()).equals(indirectWithAND[1])) {
                    conterOfClip2++;
                }
                else {
                    conterOfClip2 = conterOfClip2;
                }
                i2++;
            }

           if((conterOfClip1 > 0) && (conterOfClip2 > 0) && (conterOfClip1 == conterOfClip2)) {
                check = true;
                return check;
            }
            else {
                check = false;
                return check;
            }
        }
        else{
            if (exitedKey(cocons, "AND")) {
                if ( !exitedChar(cocons, ")") && !exitedChar(cocons, "(")){
                    check = false;
                    return check;
                }
                else {
                    check = true;
                    return check;
                }
            }
            else {
                if ( exitedChar(cocons, ")") || exitedChar(cocons, "(")){
                    check = false;
                    return check;
                }
                else {
                    check = true;
                    return check;
                }
            }
        }

    }


    /**
     * @methode: getTargetSetsCoConsTypeAndScopeSets
     * Gets the TargetSets, CoConsType, ScopeSets
     * @param cocons java.lang.String
     * @return components java.util.Vector.
     */
    public Vector getTargetSetsCoConsTypeAndScopeSets( String cocons) {

        Vector components = new Vector();
        Vector elements = new Vector();

        StringTokenizer st = new StringTokenizer(cocons);
        while (st.hasMoreTokens()) {
             elements.addElement(st.nextToken());
        }


        int targetSetCounter = 0;
        while (!((elements.get(targetSetCounter)).toString()).equals("MUST") && !((elements.get(targetSetCounter+1)).toString()).equals("BY")) {
            targetSetCounter++;
        }

        String targetsets = "";
        for (int i = 0; i < targetSetCounter; i++ ) {
            targetsets = targetsets + elements.get(i).toString() + " ";
        }

        String coconstype = "";
        coconstype = (elements.get(targetSetCounter + 2)).toString();

        String scopessets = "";
        for (int i = targetSetCounter + 3; i < elements.size(); i++ ) {
            scopessets = scopessets + (elements.get(i)).toString() + " ";
        }
        components.addElement(targetsets);
        components.addElement(coconstype);
        components.addElement(scopessets);
        return components;

    }

    /**
     * @methode: getTargetSets
     * Gets the TargetSets
     * @param cocons java.lang.String
     * @return targetsets java.lang.String.
     */
    public String getTargetSets (String cocons) {
        String targetsets = "";
        targetsets = (getTargetSetsCoConsTypeAndScopeSets(cocons).get(0)).toString();
        return targetsets;
    }

    /**
     * @methode: getCoConsType
     * Gets the CoConsType
     * @param cocons java.lang.String
     * @return coconstype java.lang.String.
     */
    public String getCoConsType (String cocons) {
        String coconstype = "";
        coconstype = (getTargetSetsCoConsTypeAndScopeSets(cocons).get(1)).toString();
        return coconstype;
    }

    /**
     * @methode: getScopeSets
     * Gets the ScopeSets
     * @param cocons java.lang.String
     * @return scopesets java.lang.String.
     */
    public String getScopeSets (String cocons) {
        String scopesets = "";
        scopesets = (getTargetSetsCoConsTypeAndScopeSets(cocons).get(2)).toString();
        return scopesets;
    }

    /**
     * @methode: orCounterOfElementSelections
     * @param urElementSelection (TargetSet or ScopeSet) java.lang.String
     * @return orCounter java.lang.Integer
     */
    public int orCounterOfElementSelections(String urElementSelections) {
        if ( !urElementSelections.equals("") || urElementSelections != null) {
            int orCounter = 1;
            Vector elements = new Vector();
            StringTokenizer st = new StringTokenizer(urElementSelections);
            while (st.hasMoreTokens()) {
                elements.addElement(st.nextToken());
            }
            for(int i = 0; i < elements.size()-1; i++) {
                if (((elements.get(i)).equals("OR")) && ((elements.get(i+1)).equals("ALL"))) {
                    orCounter++;
                }
                else{
                    if (((elements.get(i)).equals("OR")) && ((elements.get(i+1)).equals("THE"))) {
                        orCounter++;
                    }
                    else{
                        orCounter = orCounter;
                    }
                }
            }
            return orCounter;
        }
        else{
            return 0;
        }
    }

    /**
     * @methode: orCounterOfElementSelections
     * @param urElementSelection (TargetSet or ScopeSet) java.lang.String
     * @return orCounter java.lang.Integer
     */
    public int orCounterOfContextQuerys (String urElementSelection) {
        if ( !urElementSelection.equals("") || urElementSelection != null) {
            int orCounter = 0;
            StringTokenizer st = new StringTokenizer(urElementSelection);
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals("OR")) {
                    orCounter++;
                }
                else {
                    orCounter = orCounter;
                }
            }
            return orCounter;
        }
        else {
            return 0;
        }
    }

    /**
     * @methode: andCounterOfElementSelections
     * @param urElementSelection (TargetSet or ScopeSet) java.lang.String
     * @return andCounter java.lang.Integer
     */
    public int andCounterOfContextQuery (String urElementSelection) {
        if ( !urElementSelection.equals("") || urElementSelection != null) {
            int andCounter = 0;
            StringTokenizer st = new StringTokenizer(urElementSelection);
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals("AND")) {
                    andCounter++;
                }
                else {
                    andCounter = andCounter;
                }
            }
            return andCounter;
        }
        else {
            return 0;
        }
    }

    /**
     * @methode: isIndirect
     * @param urElementSelection (TargetSet or ScopeSet) java.lang.String
     * @return indirect java.lang.Boolean.
     */
    public boolean isIndirect(String urElementSelection) {
        boolean indirect = false;
        if (!urElementSelection.equals("") || urElementSelection != null) {
            StringTokenizer st = new StringTokenizer(urElementSelection);
            while (st.hasMoreTokens()) {
                if ((st.nextToken()).equals("ALL")){
                    indirect = true;
                }
            }
        }
        return indirect;
    }

    /**
     * @methode: isDirect
     * @param urElementSelection (TargetSet or ScopeSet) java.lang.String
     * @return direct java.lang.Boolean.
     */
    public boolean isDirect(String urElementSelection) {
        boolean direct = false;
        if (!urElementSelection.equals("") || urElementSelection != null) {
            StringTokenizer st = new StringTokenizer(urElementSelection);
            while (st.hasMoreTokens()) {
                if ((st.nextToken()).equals("THE")){
                    direct = true;
                }
            }
        }
        return direct;
    }

    /**
     * @methode: getElementSelection
     * @param urElementSelections (TargetSets or ScopeSets) java.lang.String
     * @return elementselection java.util.Vector.
     */
    public Vector getElementSelection (String urElementSelections) {
        if ( urElementSelections.equals("") || urElementSelections == null) {
            return null;
        } else {
            int maxIndex = 0;
            StringTokenizer ind = new StringTokenizer(urElementSelections);
            while (ind.hasMoreTokens()) {
                String e = ind.nextToken();
                if (e.equals("OR")) {
                    maxIndex++;
                } else {
                    maxIndex = maxIndex;
                }
            }
            String[] elements = new String [maxIndex+1];
            for (int i = 0; i < maxIndex+1; i++) {
                elements[i] = "";
            }
            int index = 0;
            StringTokenizer st = new StringTokenizer(urElementSelections);
            while (st.hasMoreTokens()) {
                String e = st.nextToken();
                if (!e.equals("OR")) {
                    elements[index] = elements[index] + e + " ";
                    index = index;
                } else {
                    index++;
                }
            }

            Vector e = new Vector();
            Vector ee = new Vector();
            Vector elementselection = new Vector();
            for (int i = 0; i < index+1; i++) {
                e.addElement(elements[i]);
            }
            for (int i = 0; i < index+1; i++) {
                if (isIndirect((e.get(i)).toString()) || isDirect((e.get(i)).toString())){
                    ee.addElement(e.get(i));
                }
            }
            int[] rere = new int[ee.size()];
            for (int i = 0; i < ee.size()-1; i++) {
                rere[i] = e.indexOf(ee.get(i+1)) - e.indexOf(ee.get(i));
            }
            for(int i= 0; i < ee.size(); i++) {
                String temp1 = "";
                if( rere[i] != 0) {
                    String temp2 = "";
                    for(int j = 0; j < rere[i]-1; j++){
                        temp2 = temp2 + "OR " + (e.get(i+j+1)).toString();
                    }
                    temp1 = (ee.get(i)).toString() + temp2;
                }
                else {
                    temp1 = (ee.get(i)).toString();
                }
                elementselection.addElement(temp1);
            }
            return elementselection;
        }
    }

    /**
     * @methode: getTargetSet
     * @param cocons java.lang.String
     * @return targetset java.util.Vector.
     */
     public Vector getTargetSet (String cocons) {
        String targetsets = getTargetSets(cocons);
        Vector targetset = new Vector();
        targetset = getElementSelection(targetsets);
        return targetset;
     }

    /**
     * @methode: getScopeSet
     * @param cocons java.lang.String
     * @return scopeset java.util.Vector.
     */
     public Vector getScopeSet (String cocons) {
        String scopesets = getScopeSets(cocons);
        Vector scopeset = new Vector();
        scopeset = getElementSelection(scopesets);
        return scopeset;
     }
    /**
     * @methode: getIndirectElement
     * @param ElementSelections (TargetSets or ScopeSets) java.util.Vector
     * @return indirectElement java.util.Vector.
     */
    public Vector getIndirectElement (Vector elementSelection) {
        if(elementSelection == null) {
            return null;
        }
        else {
            Vector indirect = new Vector();
            String[] elements = new String[elementSelection.size()];
            for (int i = 0; i < elementSelection.size(); i++) {
                elements[i] = (elementSelection.get(i)).toString();
            }
            if (elements == null) {
                return null;
            }
            else {
                int _allCounter = 0;
                for (int i= 0; i < elements.length; i++) {
                    StringTokenizer st = new StringTokenizer(elements[i]);
                    while (st.hasMoreTokens()) {
                        String e = st.nextToken();
                        if (e.equals("ALL")) {
                            _allCounter++;
                        } else {
                            _allCounter = _allCounter;
                        }
                    }
                }
                String[] _indirectElement = new String[_allCounter];
                int index = 0;
                if (_allCounter == 0){
                    return null;
                }
                else {
                    for (int i= 0; i < elements.length; i++) {
                        StringTokenizer stTemp = new StringTokenizer(elements[i]);
                        while (stTemp.hasMoreTokens()) {
                            String etemp = stTemp.nextToken();
                            if (etemp.equals("ALL")) {
                                _indirectElement[index] = elements[i];
                                index++;
                            }
                        }
                    }
                    for( int i = 0; i < _indirectElement.length; i++) {
                        indirect.addElement(_indirectElement[i]);
                    }
                    return indirect;
                }
            }
        }
    }

    /**
     * @methode: getIndirectElementOfTargetSets
     * @param cocons java.lang.String
     * @return indirectElementOfTargetSets java.util.Vector.
     */
    public Vector getIndirectElementOfTargetSet (String cocons) {
        String targetsets = getTargetSets (cocons);
        Vector elementSelection = new Vector();
        elementSelection = getElementSelection(targetsets);
        Vector indirectElementOfTargetSets = new Vector();
        indirectElementOfTargetSets = getIndirectElement (elementSelection);
        return indirectElementOfTargetSets;
    }

    /**
     * @methode: getIndirectElementOfScopeSets
     * @param cocons java.lang.String
     * @return indirectElementOfScopeSets java.util.Vector.
     */
    public Vector getIndirectElementOfScopeSet (String cocons) {
        String scopesets = getScopeSets (cocons);
        Vector elementSelection = new Vector();
        elementSelection = getElementSelection(scopesets);
        Vector indirectElementOfScopeSets = new Vector();
        indirectElementOfScopeSets = getIndirectElement (elementSelection);
        return indirectElementOfScopeSets;

    }

    /**
     * @methode: getDirectElement
     * @param ElementSelections (TargetSets or ScopeSets) java.util.Vector
     * @return directElement java.util.Vector.
     */
    public Vector getDirectElement (Vector elementSelection) {
        if(elementSelection == null) {
            return null;
        }
        else {
            Vector direct = new Vector();
            String[] elements = new String[elementSelection.size()];
            for (int i = 0; i < elementSelection.size(); i++) {
                elements[i] = (elementSelection.get(i)).toString();
            }
            if (elements == null) {
                return null;
            }
            else {
                int _allCounter = 0;
                for (int i= 0; i < elements.length; i++) {
                    StringTokenizer st = new StringTokenizer(elements[i]);
                    while (st.hasMoreTokens()) {
                        String e = st.nextToken();
                        if (e.equals("THE")) {
                            _allCounter++;
                        } else {
                            _allCounter = _allCounter;
                        }
                    }
                }
                String[] _directElement = new String[_allCounter];
                int index = 0;
                if (_allCounter == 0){
                    return null;
                }
                else {
                    for (int i= 0; i < elements.length; i++) {
                        StringTokenizer stTemp = new StringTokenizer(elements[i]);
                        while (stTemp.hasMoreTokens()) {
                            String etemp = stTemp.nextToken();
                            if (etemp.equals("THE")) {
                                _directElement[index] = elements[i];
                                index++;
                            }
                        }
                    }
                    for( int i = 0; i < _directElement.length; i++) {
                        direct.addElement(_directElement[i]);
                    }
                    return direct;
                }
            }
        }
    }

    /**
     * @methode: getDirectElementOfTargetSets
     * @param cocons java.lang.String
     * @return directElementOfTargetSets java.util.Vector.
     */
    public Vector getDirectElementOfTargetSet (String cocons) {
        String targetsets = getTargetSets (cocons);
        Vector elementSelection = new Vector();
        elementSelection = getElementSelection(targetsets);
        Vector directElementOfTargetSets = new Vector();
        directElementOfTargetSets = getDirectElement (elementSelection);
        return directElementOfTargetSets;
    }

    /**
     * @methode: getDirectElementOfScopeSets
     * @param cocons java.lang.String
     * @return directElementOfScopeSets java.util.Vector.
     */
    public Vector getDirectElementOfScopeSet (String cocons) {
        String scopesets = getScopeSets (cocons);
        Vector elementSelection = new Vector();
        elementSelection = getElementSelection(scopesets);
        Vector directElementOfScopeSets = new Vector();
        directElementOfScopeSets = getDirectElement (elementSelection);
        return directElementOfScopeSets;
    }

     /**
     * @methode: getRestriction
     * @param elementset (targetset or scopeset) java.lang.Object
     * @return restriction java.lang.String.
     */
    public String getRestriction (Object elementset) {
        String restriction = "";
        int counter = 0;
        String element = elementset.toString();
        StringTokenizer st = new StringTokenizer(element);
        while (st.hasMoreTokens()) {
            st.nextToken();
            counter++;
        }
        String[] e = new String[counter];
        int i = 0;
        StringTokenizer ste = new StringTokenizer(element);
        while (ste.hasMoreTokens()) {
            e[i] = ste.nextToken();
            i++;
        }
        if (isIndirect(element)) {
            int j =1;
            while (!e[j].equals("WHERE")) {
                restriction = restriction + e[j] + " ";
                j++;
            }
            return restriction;
        }
        else {
            if (isDirect(element)) {
                restriction = e[1];
                return restriction;
            }
            else {
                return "Warning: input error";
            }
        }
    }

    /**
         * @methode: getRange
         * @param elementset (targetset or scopeset) java.lang.Object
         * @return range java.lang.String.
         */
        public String getRange (Object elementset) {
            String range = "";
            int counter = 0;
            String element = elementset.toString();
            StringTokenizer st = new StringTokenizer(element);
            while (st.hasMoreTokens()) {
                st.nextToken();
                counter++;
            }
            String[] e = new String[counter];
            int i = 0;
            StringTokenizer ste = new StringTokenizer(element);
            while (ste.hasMoreTokens()) {
                e[i] = ste.nextToken();
                i++;
            }
            if (isIndirect(element)) {
                range = e[0];
                return range;
            }
            else {
                if (isDirect(element)) {
                    range = e[0];
                    return range;
                }
                else {
                    return "Warning: input error";
                }
            }
    }

    /**
     * @methode: getContextQuerys
     * @param elementset (targetset or scopeset) java.lang.Object
     * @return contextQuerys java.lang.String.
     */
    public String getContextQuerys (Object elementset) {
        String contextQuery = "";
        int counter = 0;
        String element = elementset.toString();
        StringTokenizer st = new StringTokenizer(element);
        while (st.hasMoreTokens()) {
            st.nextToken();
            counter++;
        }
        String[] e = new String[counter];
        int i = 0;
        StringTokenizer ste = new StringTokenizer(element);
        while (ste.hasMoreTokens()) {
            e[i] = ste.nextToken();
            i++;
        }
        if (isIndirect(element)) {
            int j =1;
            while (!e[j].equals("WHERE")) {
                j++;
            }
            for (int k = j+1; k < i; k++) {
                contextQuery = contextQuery + e[k] + " ";
            }
            return contextQuery;
        }
        else {
            if (isDirect(element)) {
                for (int j = 2; j < i; j++) {
                    contextQuery = contextQuery + e[j] + " ";
                }
                return contextQuery;
            }
            else {
                return "Warning: input error";
            }
        }
    }

    /**
     * @methode: removeClip
     * @param object java.lang.String
     * @return result java.lang.String
     */
    public String removeClip (String object) {
        String result = "";
        int i = object.length();
        if ( i < 3 ){
            result = object;
        }
        else {
            if ((object.substring(0, 1)).equals("(") && (object.substring(i-1, i)).equals(")")) {
                result = object.substring(1, i-1);
            }
            else{
                if ((object.substring(0, 1)).equals("(")) {
                    result = object.substring(1, i);
                }
                else {
                    if ((object.substring(i-2, i-1)).equals(")")) {
                       result = object.substring(0, i-2);
                    }
                    else result = object;
                }
            }
        }
        return result;
    }

    /**
     * @methode: getContextQuery
     * @param elementset (targetset or scopeset) java.lang.Object
     * @return contextQuery java.util.Vector.
     */
    public Vector getContextQuery (Object elementset) {
        Vector contextQuery = new Vector();
        String element = elementset.toString();
        if ( element.equals("") || element == null) {
            contextQuery.addElement("isEmpty");
            return contextQuery;
        } else {
            int index = 0;
            int maxIndex = 0;
            maxIndex = orCounterOfContextQuerys(element);
            String[] elements = new String [maxIndex+1];
            for (int i = 0; i < maxIndex+1; i++) {
                elements[i] = "";
            }
            StringTokenizer st = new StringTokenizer(element);
            while (st.hasMoreTokens()) {
                String e = st.nextToken();
                if (!e.equals("OR")) {
                    elements[index] = elements[index] + e + " ";
                    index = index;
                } else {
                    index++;
                }
            }
            for(int i = 0; i < elements.length; i++){
                contextQuery.addElement(elements[i]);
            }
            return contextQuery;
        }
    }


    /**
     * @methode: mustDetail
     * @param contextQueryElement of targetset or scopeset java.util.Vector
     * @return must java.lang.Boolean.
     */
     public boolean mustDetail(Object contextQueryElement) {
        boolean must = false;
        String temp = contextQueryElement.toString();
        StringTokenizer st = new StringTokenizer(temp);
        while (st.hasMoreTokens()) {
            String e = st.nextToken();
            if (e.equals("AND")) {
                must = true;
                break;
            }
            else{
                must = false;
            }
        }

        return must;
     }

     /**
      * @methode: getElementMustDetails
      * @param contextQuery of targetset or scopeset java.util.Vector
      * @return elementMustDetails java.util.Vector.
      */
      public Vector getElementMustDetails(Vector contextQuery) {
          Vector elementMustDetails = new Vector();
          for (int i = 0 ; i < contextQuery.size(); i ++) {
              if(mustDetail(contextQuery.get(i))) {
                  elementMustDetails.addElement(contextQuery.get(i));
              }
          }
          return elementMustDetails;

     }

    /**
    * @methode: getCondition
    * @param contextQuery from ElementSelection Indirect (targetset or scopeset) java.lang.String
    * @return cdt java.lang.String.
    */
    public String getCondition (String contextQuery) {
        String cdt = "";
        int length = condition.length;
        boolean exited = false;
        StringTokenizer st = new StringTokenizer(contextQuery);
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            for (int i = 0; i < condition.length; i++) {
                if(temp.equals(condition[i])) {
                    exited = true;
                    cdt = temp;
                }
                else{
                    exited = false;
                }
            }
            if (exited == true) break;
        }
        return cdt;
    }
    /**
    * @methode: getContextPropertyName
    * @param contextQuery from ElementSelection Indirect (targetset or scopeset) java.lang.String
    * @return contextPropertyName java.lang.String.
    */
    public String getContextPropertyName (String contextQuery) {
        String contextPropertyName = "";
        String condition = getCondition(contextQuery);
        StringTokenizer st = new StringTokenizer(contextQuery);
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            if (!temp.equals(condition)) {
                contextPropertyName = contextPropertyName + temp + " ";
            }
            else{
                break;
            }

        }

        return contextPropertyName;
    }

    /**
    * @methode: getValue
    * @param contextQuery from ElementSelection Indirect (targetset or scopeset) java.lang.String
    * @return values java.lang.String.
    */
    public String getValue (String contextQuery) {
        String values = "";
        String condition = getCondition(contextQuery);
        StringTokenizer st = new StringTokenizer(contextQuery);
        int counter = 0;
        while (st.hasMoreTokens()) {
            st.nextToken();
            counter++;
        }
        String[] e = new String[counter];
        int i = 0;
        StringTokenizer ste = new StringTokenizer(contextQuery);
        while (ste.hasMoreTokens()) {
            e[i] = ste.nextToken();
            i++;
        }
        int j =0;
        while (!e[j].equals(condition)) {
            j++;
        }
        for (int k = j+1; k < i; k++) {
            values = values + e[k] + " ";
        }
        return values;
    }

    /**
     * @methode: getContextQueryDetail
     * @param contextQuery of targetset or scopeset java.util.Vector
     * @return result java.util.Vector.
     */
    public Vector getContextQueryDetail (Vector contextQuery) {
        Vector result = new Vector();
        Vector detailTest = new Vector();
        detailTest = (Vector)(contextQuery.get(0));
        String test = (detailTest.get(0)).toString();
        if (test.equals("isEmpty")) {
            Vector result1 = new Vector();
            Vector result2 = new Vector();
            Vector result3 = new Vector();
            result3.addElement("isEmpty");
            result2.addElement(result3);
            result1.addElement(result2);
            result.addElement(result1);
            return result;
        }
        else {
            for (int k = 0; k < contextQuery.size(); k++) {
                Vector detailResult = new Vector();
                Vector detail = new Vector();
                detail = (Vector)(contextQuery.get(k));
                for( int i = 0; i < detail.size(); i++) {
                    Vector e = new Vector();
                    if ( !mustDetail(detail.get(i))) {
                        Vector r = new Vector();
                        r.addElement(getContextPropertyName((detail.get(i)).toString()));
                        r.addElement(getCondition((detail.get(i)).toString()));
                        r.addElement(getValue((detail.get(i)).toString()));
                        e.addElement(r);
                    }
                    if (mustDetail(detail.get(i))) {
                        Vector elementMustDetails = new Vector();
                        String element = (detail.get(i)).toString();
                        int index = 0;
                        int maxIndex = 0;
                        maxIndex = andCounterOfContextQuery(element);
                        String[] elements = new String [maxIndex+1];
                        for (int j = 0; j < maxIndex+1; j++) {
                            elements[j] = "";
                        }
                        StringTokenizer st = new StringTokenizer(element);
                        while (st.hasMoreTokens()) {
                            String t = st.nextToken();
                            if (!t.equals("AND")) {
                                elements[index] = elements[index] + t + " ";
                                index = index;
                            }
                            else {
                                index++;
                            }
                        }
                        for(int j = 0; j < elements.length; j++){
                            elementMustDetails.addElement(removeClip(elements[j]));
                        }
                        for(int j = 0; j < elementMustDetails.size(); j++) {
                            Vector r = new Vector();
                            r.addElement(getContextPropertyName((elementMustDetails.get(j)).toString()));
                            r.addElement(getCondition((elementMustDetails.get(j)).toString()));
                            r.addElement(getValue((elementMustDetails.get(j)).toString()));
                            e.addElement(r);
                        }
                    }
                    detailResult.addElement(e);
                }
                result.addElement(detailResult);
            }
            return result;
        }
    }

    /**
    * @methode: getElementName
    * @param contextQueryElement from ElementSelection Direct (targetset or scopeset) java.lang.Object
    * @return contextPropertyName java.lang.String.
    */
    public String getElementName (Object contextQueryElement) {
        String elementName = "";
        elementName = getContextQuerys(contextQueryElement);
        return elementName;
    }

    public Hashtable parserCoCons (String cocons) {
        Hashtable codes = new Hashtable();
        Vector c = new Vector();
        c.addElement(cocons);
        codes.put("Context-Based Constraints", c); // Object value java.util.Vector
        Vector targetsets = new Vector();
        if ( getTargetSet(cocons) == null || getTargetSet(cocons).equals("")) {
            targetsets.addElement("ALL components");
        }
        else {
            targetsets.addElement(getTargetSets(cocons));
        }
        codes.put("TargetSet", targetsets); // Object value java.util.Vector
        Vector coconstype= new Vector();
        coconstype.addElement(getCoConsType(cocons));
        codes.put("CoConsType", coconstype); // Object value java.util.Vector
        Vector scopesets= new Vector();
        if (getScopeSet(cocons) == null || getScopeSet(cocons).equals("")) {
            scopesets.addElement("ALL components");
        }
        else {
            scopesets.addElement(getScopeSets(cocons));
        }
        codes.put("ScopeSet", scopesets);   // Object value java.util.Vector
        Vector targetset = new Vector();
        if ( getTargetSet(cocons) == null || getTargetSet(cocons).equals("")) {
            targetset.addElement("ALL components");
        }
        else {
            targetset = getTargetSet(cocons);
        }
        codes.put("ElementSelection of TargetSet", targetset); // Object value java.util.Vector
        Vector scopeset = new Vector();
        if (getScopeSet(cocons) == null || getScopeSet(cocons).equals("")) {
            scopeset.addElement("ALL components");
        }
        else {
            scopeset = getScopeSet(cocons);
        }
        codes.put("ElementSelection of ScopeSet", scopeset); // Object value java.util.Vector
        Vector indirectElementOfTargetSet = new Vector();
        if ( getIndirectElementOfTargetSet(cocons) == null) {
            indirectElementOfTargetSet.addElement("isEmpty");
        }
        else {
            indirectElementOfTargetSet = getIndirectElementOfTargetSet(cocons);
        }
        codes.put("IndirectSelection of TargetSet", indirectElementOfTargetSet); // Object value java.util.Vector
        Vector directElementOfTargetSet = new Vector();
        if ( getDirectElementOfTargetSet(cocons) == null) {
            directElementOfTargetSet.addElement("isEmpty");
        }
        else {
            directElementOfTargetSet = getDirectElementOfTargetSet(cocons);
        }
        codes.put("DirectSelection of TargetSet", directElementOfTargetSet); // Object value java.util.Vector
        Vector indirectElementOfScopeSet = new Vector();
        if ( getIndirectElementOfScopeSet(cocons) == null) {
            indirectElementOfScopeSet.addElement("isEmpty");
        }
        else {
            indirectElementOfScopeSet = getIndirectElementOfScopeSet(cocons);
        }
        codes.put("IndirectSelection of ScopeSet", indirectElementOfScopeSet); // Object value java.util.Vector
        Vector directElementOfScopeSet = new Vector();
        if ( getDirectElementOfScopeSet(cocons) == null) {
            directElementOfScopeSet.addElement("isEmpty");
        }
        else {
            directElementOfScopeSet = getDirectElementOfScopeSet(cocons);
        }
        codes.put("DirectSelection of ScopeSet", directElementOfScopeSet); // Object value java.util.Vector
        Vector rangeoiefts = new Vector(); // rangeoiefts = Range Of IndirectElement From TargetSet
        if ( getIndirectElementOfTargetSet(cocons) == null) {
            rangeoiefts.addElement("isEmpty");
        }
        else {
            for (int i = 0; i < getIndirectElementOfTargetSet(cocons).size(); i++) {
                rangeoiefts.addElement(getRange(getIndirectElementOfTargetSet(cocons).get(i)));
            }
        }
        codes.put("Range Of IndirectElement From TargetSet", rangeoiefts); // Object value java.util.Vector
        Vector rangeoiefss = new Vector(); // roidfss= Range Of IndirectElement From ScopeSet
        if ( getIndirectElementOfScopeSet(cocons) == null) {
            rangeoiefss.addElement("isEmpty");
        }
        else {
            for (int i = 0; i < getIndirectElementOfScopeSet(cocons).size(); i++) {
                rangeoiefss.addElement(getRange(getIndirectElementOfScopeSet(cocons).get(i)));
            }
        }
        codes.put("Range Of IndirectElement From ScopeSet", rangeoiefss); // Object value java.util.Vector
        Vector rangeodefts = new Vector(); // rodefts= Range Of DirectElement From TargetSet
        if ( getDirectElementOfTargetSet(cocons) == null) {
            rangeodefts.addElement("isEmpty");
        }
        else {
            for (int i = 0; i < getDirectElementOfTargetSet(cocons).size(); i++) {
                rangeodefts.addElement(getRange(getDirectElementOfTargetSet(cocons).get(i)));
            }
        }
        codes.put("Range Of DirectElement From TargetSet", rangeodefts); // Object value java.util.Vector
        Vector rangeodefss = new Vector(); // rodefss= Range Of DirectElement From ScopeSet
        if ( getDirectElementOfScopeSet(cocons) == null) {
            rangeodefss.addElement("isEmpty");
        }
        else {
            for (int i = 0; i < getDirectElementOfScopeSet(cocons).size(); i++) {
                rangeodefss.addElement(getRange(getDirectElementOfScopeSet(cocons).get(i)));
            }
        }
        codes.put("Range Of DirectElement From ScopeSet", rangeodefss); // Object value java.util.Vector
        Vector roiefts = new Vector(); // roiefts= Restriction Of IndirectElement From TargetSet
        if ( getIndirectElementOfTargetSet(cocons) == null) {
            roiefts.addElement("isEmpty");
        }
        else {
            for (int i = 0; i < getIndirectElementOfTargetSet(cocons).size(); i++) {
                roiefts.addElement(getRestriction(getIndirectElementOfTargetSet(cocons).get(i)));
            }
        }
        codes.put("Restriction Of IndirectElement From TargetSet", roiefts); // Object value java.util.Vector
        Vector roiefss = new Vector(); // roidfss= Restriction Of IndirectElement From ScopeSet
        if ( getIndirectElementOfScopeSet(cocons) == null) {
            roiefss.addElement("isEmpty");
        }
        else {
            for (int i = 0; i < getIndirectElementOfScopeSet(cocons).size(); i++) {
                roiefss.addElement(getRestriction(getIndirectElementOfScopeSet(cocons).get(i)));
            }
        }
        codes.put("Restriction Of IndirectElement From ScopeSet", roiefss); // Object value java.util.Vector
        Vector rodefts = new Vector(); // rodefts= Restriction Of DirectElement From TargetSet
        if ( getDirectElementOfTargetSet(cocons) == null) {
            rodefts.addElement("isEmpty");
        }
        else {
            for (int i = 0; i < getDirectElementOfTargetSet(cocons).size(); i++) {
                rodefts.addElement(getRestriction(getDirectElementOfTargetSet(cocons).get(i)));
            }
        }
        codes.put("Restriction Of DirectElement From TargetSet", rodefts); // Object value java.util.Vector
        Vector rodefss = new Vector(); // rodefss= Restriction Of DirectElement From ScopeSet
        if ( getDirectElementOfScopeSet(cocons) == null) {
            rodefss.addElement("isEmpty");
        }
        else {
            for (int i = 0; i < getDirectElementOfScopeSet(cocons).size(); i++) {
                rodefss.addElement(getRestriction(getDirectElementOfScopeSet(cocons).get(i)));
            }
        }
        codes.put("Restriction Of DirectElement From ScopeSet", rodefss); // Object value java.util.Vector
        // parser ElementName of DirectSelection
        Vector enodefts = new Vector(); // enodefts = ElementName Of DirectElement From TargetSet
        if ( getDirectElementOfTargetSet(cocons) == null) {
            enodefts.addElement("isEmpty");
        }
        else {
            for (int i = 0; i < getDirectElementOfTargetSet(cocons).size(); i++) {
                enodefts.addElement(getElementName(getDirectElementOfTargetSet(cocons).get(i)));
            }
        }
        codes.put("ElementName Of DirectElement From TargetSet", enodefts); // Object value java.util.Vector
        Vector enodefss = new Vector(); // enodefss = ElementName Of DirectElement From ScopeSet
        if ( getDirectElementOfScopeSet(cocons) == null) {
            enodefss.addElement("isEmpty");
        }
        else {
            for (int i = 0; i < getDirectElementOfScopeSet(cocons).size(); i++) {
                enodefss.addElement(getElementName(getDirectElementOfScopeSet(cocons).get(i)));
            }
        }
        codes.put("ElementName Of DirectElement From ScopeSet", enodefss); // Object value java.util.Vector
        // parser ContextQuerys of IndirectSelection
        Vector cqoiefts = new Vector(); // cqoiefts = ContextQuerys Of IndirectElement From TargetSet
        if ( getIndirectElementOfTargetSet(cocons) == null) {
            cqoiefts.addElement("isEmpty");
        }
        else {
            for (int i = 0; i < getIndirectElementOfTargetSet(cocons).size(); i++) {
                cqoiefts.addElement(getContextQuerys(getIndirectElementOfTargetSet(cocons).get(i)));
            }
        }
        codes.put("ContextQuerys Of IndirectElement From TargetSet", cqoiefts); // Object value java.util.Vector
        Vector cqoiefss = new Vector(); // cqoiefss = ContextQuerys Of IndirectElement From ScopeSet
        if ( getIndirectElementOfScopeSet(cocons) == null) {
            cqoiefss.addElement("isEmpty");
        }
        else {
            for (int i = 0; i < getIndirectElementOfScopeSet(cocons).size(); i++) {
                cqoiefss.addElement(getContextQuerys(getIndirectElementOfScopeSet(cocons).get(i)));
            }
        }
        codes.put("ContextQuerys Of IndirectElement From ScopeSet", cqoiefss); // Object value java.util.Vector
        //  contextQuery of IndirectElement From TargetSet
        Vector numberCQTSN = new  Vector();
        int contextQuerysTSSize = cqoiefts.size();
        Vector cqts = new Vector();
        Vector cqt = new Vector();
        if (((cqoiefts.get(0)).toString()).equals("isEmpty")) {
            cqts.addElement("isEmpty");
            cqt.addElement(cqts);
        }
        else {
            for (int i = 0; i < contextQuerysTSSize; i++) {
                cqts = getContextQuery(cqoiefts.get(i));
                cqt.addElement(cqts);
            }
        }
        codes.put("ContextQuery Of IndirectElement From TargetSet", cqt); // Object value java.util.Vector
        //  contextQuery of IndirectElement From ScopeSet
        Vector numberCQSSN = new  Vector();
        int contextQuerysSSSize = cqoiefss.size();
        Vector cqss = new Vector();
        Vector cqs = new Vector();
        if (((cqoiefss.get(0)).toString()).equals("isEmpty")) {
                    cqss.addElement("isEmpty");
                    cqs.addElement(cqoiefss);
                }
        else {
            for (int i = 0; i < contextQuerysSSSize; i++) {
                cqss = getContextQuery(cqoiefss.get(i));
                cqs.addElement(cqss);
            }
        }
        codes.put("ContextQuery Of IndirectElement From ScopeSet", cqs); // Object value java.util.Vector
        // contextQueryDetail


        //Vector getContextQueryDetail (Vector contextQuery)

        codes.put("ContextQueryDetail Of IndirectElement From TargetSet", getContextQueryDetail(cqt)); // Object value java.util.Vector
        codes.put("ContextQueryDetail Of IndirectElement From ScopeSet", getContextQueryDetail(cqs)); // Object value java.util.Vector
        return codes;
    }

    /**
    * @methode: printAllElementHashtable
    * @param  codes java.util.Hashtable
    * @return
    */
    public void printAllElementHashtable ( Hashtable codes) {

        for (Enumeration k = codes.keys () ; k.hasMoreElements () ;) {
            String key = (k.nextElement()).toString();
            System.out.println (key + " : ");
            System.out.println (codes.get(key));
        }
    }

    /**
    * @methode: printNoEmptyElementHashtable
    * @param  codes java.util.Hashtable
    * @return
    */
    public void printNoEmptyElementHashtable ( Hashtable codes) {
        Enumeration e = codes.elements();
        for (Enumeration k = codes.keys () ; k.hasMoreElements () ;) {
            String key = (k.nextElement()).toString();
            Vector t = (Vector)e.nextElement();
            String s =  (t.get(0)).toString();
            if(!s.equals("isEmpty")) {
                System.out.println (key + " : ");
                System.out.println (codes.get(key));
            }
        }
    }


    /**
    * @methode: searchElementOfHashtable
    * @param  codes java.util.Hashtable, key java.lang.String
    * @return object java.lang.Object
    */
    public Object searchElementOfHashtable (Hashtable codes , String key) {
        Object o = codes.get (key);
        if (o != null) {
            return (o);
        }
        else {
            return null;
        }

    }

    /**
     * @methode: stringToVector
     * @param object java.lang.String
     * @return toVector java.util.Vector.
     */

    public Vector stringToVector( String object) {
        Vector toVector = new Vector();
        StringTokenizer st = new StringTokenizer(object);
        while (st.hasMoreTokens()) {
             toVector.addElement(st.nextToken());
        }
        return toVector;
    }

    /**
     * @methode: exitedString
     * @param object java.lang.String, searchString java.lang.String
     * @return exited java.lang.Boolean.
     */

    public boolean exitedString( String object, String searchString) {
        boolean exited = false;
        Vector elements = new Vector();
        StringTokenizer st = new StringTokenizer(object);
        while (st.hasMoreTokens()) {
             elements.addElement(st.nextToken());
        }
        int i = 0;
        while (i < elements.size()) {
            if(((elements.get(i)).toString()).equals(searchString)) {
                exited = true;
                break;
            }
            else {
                exited = false;
            }
            i++;
        }
        return exited;
    }

    /**
     * @methode: stringCounter
     * @param object java.lang.String, searchString java.lang.String
     * @return exited java.lang.Boolean.
     */

    public int stringCounter( String object, String searchString) {
        int number = 0;
        Vector elements = new Vector();
        StringTokenizer st = new StringTokenizer(object);
        while (st.hasMoreTokens()) {
             elements.addElement(st.nextToken());
        }
        int i = 0;
        while (i < elements.size()) {
            if(((elements.get(i)).toString()).equals(searchString)) {
                number++;
            }
            else {
                number = number;
            }
            i++;
        }
        return number;
    }

    /**
     * @methode: exitedChar
     * @param object java.lang.String, searchString java.lang.String
     * @return exited java.lang.Boolean.
     */

    public boolean exitedChar( String object, String searchString) {
        boolean exited = false;
        Vector elements = new Vector();
        int i = 0;
        while (i <= object.length()-1) {
            elements.addElement(object.substring(i, i+1));
            i++;
        }
        int  j = 0;
        while (j < elements.size()) {
            if(((elements.get(j)).toString()).equals(searchString)) {
                exited = true;
                break;
            }
            else {
                exited = false;
            }
            j++;
        }
        return exited;
    }

    /**
     * @methode: charCounter
     * @param object java.lang.String, searchString java.lang.String
     * @return number java.lang.int.
     */

    public int charCounter( String object, String searchString) {
        int number = 0;
        Vector elements = new Vector();
        int i = 0;
        while (i <= object.length()-1) {
            elements.addElement(object.substring(i, i+1));
            i++;
        }
        int  j = 0;
        while (j < elements.size()) {
            if(((elements.get(j)).toString()).equals(searchString)) {
               number++;
            }
            else {
                number = number;
            }
            j++;
        }
        return number;
    }

    /**
     * @methode: exitedString
     * @param object java.lang.String, searchStrings java.lang.String[]
     * @return exited java.lang.Boolean.
     */

    public boolean exitedString( String object, String[] searchStrings) {
        boolean exited = false;
        Vector elements = new Vector();
        StringTokenizer st = new StringTokenizer(object);
        while (st.hasMoreTokens()) {
             elements.addElement(st.nextToken());
        }
        int i = 0;
        while (i < elements.size()) {
            for (int j = 0; j < searchStrings.length; j++) {
                if(((elements.get(i)).toString()).equals(searchStrings[j])) {
                    exited = true;
                    break;
                }
                else {
                    exited = false;
                }
            }
            if(exited == true) break;
            i++;
        }
        return exited;
    }

    /**
     * @methode: stringsCounter
     * @param object java.lang.String, searchStrings java.lang.String[]
     * @return counter java.lang.int
     */

    public int stringsCounter( String object, String[] searchStrings) {
        int counter = 0;
        Vector elements = new Vector();
        StringTokenizer st = new StringTokenizer(object);
        while (st.hasMoreTokens()) {
             elements.addElement(st.nextToken());
        }
        int i = 0;
        while (i < elements.size()) {
            for (int j = 0; j < searchStrings.length; j++) {
                if(((elements.get(i)).toString()).equals(searchStrings[j])) {
                    counter++;
                }
                else {
                    counter = counter;
                }
            }
            i++;
        }
        return counter;
    }

    /**
     * @methode: checkLevel0 check existing of "MUST BE" & "CoConsType"
     * @param cocons
     * @return level0 java.lang.Boolean.
     */
    public boolean checkLevel0 (String cocons) {
        boolean level0 = false;
        if (exitedMUSTBE(cocons)) {
            if (exitedString( cocons, coconTypeName)) {
                level0 = true;
            }
            else {
                level0 = false;
            }
        }
        else {
            level0 = false;
        }
      return level0;
    }

    /**
     * @methode: checkLevel1 check existing of "ALL" or "THE" in TargetSet or ScopeSet
     * @param cocons
     * @return level1 java.lang.Boolean.
     */
    public boolean checkLevel1 (String cocons) {
        boolean level1 = false;
        String[] searchStrings = {"ALL"
                                 ,"all"
                                 ,"THE"
                                 ,"the"};
        if ((getTargetSets(cocons).equals("")) && (getScopeSets(cocons).equals(""))) {
            level1 = false;
        }
        if (!(getTargetSets(cocons).equals("")) && (getScopeSets(cocons).equals(""))) {
            String targetset = getTargetSets(cocons);
            if ( exitedString((stringToVector(targetset).get(0)).toString(), searchStrings) && exitedString( targetset, searchStrings)) {
               level1 = true;
            }
        }
        if ((getTargetSets(cocons).equals("")) && !(getScopeSets(cocons).equals(""))) {
            String scopeset = getScopeSets(cocons);
            if (exitedString((stringToVector(scopeset).get(0)).toString(), searchStrings) && exitedString( scopeset, searchStrings)) {
                level1 = true;
            }
        }
        if (!(getTargetSets(cocons).equals("")) && !(getScopeSets(cocons).equals(""))) {
            String targetset = getTargetSets(cocons);
            String scopeset  = getScopeSets(cocons);
            if (exitedString((stringToVector(targetset).get(0)).toString(), searchStrings) && exitedString((stringToVector(scopeset).get(0)).toString(), searchStrings) && exitedString( targetset, searchStrings) && exitedString( scopeset, searchStrings)) {
                level1 = true;
            }
        }
        return level1;
    }

    /**
     * @methode: checkLevel2 check only "THE" with existing of "OR", "WHERE", "AND" & Clip
     * @param object java.lang.String.
     * @return level2 java.lang.Boolean.
     */
    public boolean checkLevel2 (String object) {
        boolean level2 = true;
        if (!exitedString(object, "ALL")) {
            if (exitedString(object, "WHERE") || exitedString(object, "AND")) {
                level2 = false;
            }
            for (int i = 0; i < condition.length; i++) {
                if (exitedString(object, condition[i])) {
                    level2 = false;
                    break;
                }
            }

            if (exitedChar(object, "(") || exitedChar(object, ")")) {
            level2 = false;
            }
            if (!exitedChar(object, "'")) {
                level2 = false;
            }
            if (!exitedChar(object, "'")) {
                level2 = false;
            }
            if (!exitedString(object, "OR") && charCounter(object, "'") != 2) {
               level2 = false;
            }
            if (exitedString(object, "OR") && charCounter(object, "'") != 2 * (1+stringCounter(object, "OR"))) {
                           level2 = false;
            }
            if (exitedString(object, "OR")) {
                if (stringCounter(object, "THE") != 1 + stringCounter(object, "OR"))
                    level2 = false;
            }

        }
        return level2;
    }

     /**
     * @methode: checkLevel3 check only "ALL" with existing of "OR", "WHERE", "AND" & Clip
     * @param object java.lang.String.
     * @return level3 java.lang.Boolean.
     */
    public boolean checkLevel3 (String object) {
        boolean level3 = true;
        if (!exitedString(object, "THE")) {
            if (!exitedString(object, "WHERE")) {
                level3 = false;
            }
            if(stringCounter(object, "ALL") != stringCounter(object, "WHERE")) {
                level3 = false;
            }
            if(stringCounter(object, "ALL") > 1 + stringCounter(object, "OR")) {
                level3 = false;
            }
            if(4 * stringsCounter(object, condition) != charCounter(object, "'")) {
                level3 = false;
            }
            if(stringsCounter(object, condition) != 1 + stringCounter(object, "OR") + stringCounter(object, "AND")) {
                level3 = false;
            }
            if(exitedString(object, "AND") && ( !exitedChar(object, ")") || !exitedChar(object, "(") )) {
                level3 = false;
            }
            if(exitedString(object, "AND") && !exitedString(object, "OR")) {
                if ((charCounter(object, "(") != 1) || (charCounter(object, ")") != 1 )) {
                    level3 = false;
                }
            }

        }
        return level3;
    }

    /**
     * @methode: checkLevel4 check only "ALL" with existing of "OR", "WHERE", "AND" & Clip
     * @param object java.lang.String.
     * @return level4 java.lang.Boolean.
     */
    public boolean checkLevel4 (String object) {
        //getIndirectElementOfScopeSet(cocons)
        boolean level4 = true;
        if (!exitedString(object, "THE") && exitedString(object, "AND") && exitedString(object, "OR")) {
            Vector elementSelection = new Vector();
            elementSelection = getElementSelection(object);
            Vector indirectElementOfTargetSets = new Vector();
            indirectElementOfTargetSets = getIndirectElement (elementSelection);
            for ( int i = 0; i < indirectElementOfTargetSets.size(); i++) {
                if (!checkLevel3((indirectElementOfTargetSets.get(i)).toString())) {
                    level4 = false;
                    break;
                }
            }
        }
        return level4;
    }

    /**
     * @methode: checkLevel5 check only "ALL" with existing of "OR", "WHERE", "AND" & Clip
     * @param object java.lang.String.
     * @return level5 java.lang.Boolean.
     */
    public boolean checkLevel5 (String object) {
        //getIndirectElementOfScopeSet(cocons)
        boolean level5 = true;

        Vector elementSelection = new Vector();
        elementSelection = getElementSelection(object);
        Vector directElement = new Vector();
        directElement = getDirectElement (elementSelection);
        if (directElement != null) {
            for ( int i = 0; i < directElement.size(); i++) {
                if (!checkLevel2((directElement.get(i)).toString())) {
                    level5 = false;
                    break;
                }
            }
        }
        if (level5 == false){
            return level5;
        }
        Vector indirectElement = new Vector();
        indirectElement = getIndirectElement (elementSelection);
        if (indirectElement != null) {
            for ( int j = 0; j < indirectElement.size(); j++) {
                if (!checkLevel3((indirectElement.get(j)).toString())) {
                    level5 = false;
                    break;
                }
            }
        }
        if (level5 == false){
            return level5;
        }
        else
            return level5;
    }

    /**
     * @methode: checkLevel6 check only "ALL" with existing of "OR", "WHERE", "AND" & Clip
     * @param object java.lang.String.
     * @return level5 java.lang.Boolean.
     */
    public boolean checkLevel6 (String object) {
        boolean level6 = true;
        int or = 0;
        if (orCounterOfElementSelections(object) > 0) {
            or = orCounterOfElementSelections(object)-1;
        }
        int allthe = stringCounter(object, "ALL") + stringCounter(object, "THE");
        if ((allthe - 2) == or) {
            return level6;
        }
        else {
            return false;
        }

    }

    /**
    * @methode: isValid check cocons
    * @param cocons java.lang.String.
    * @return valid java.lang.Boolean.
    */
    public boolean isValid (String cocons){
        boolean valid = false;
        boolean ts = true;
        if ( getTargetSet(cocons) == null || getTargetSet(cocons).equals("")) {
            ts = false;
        }
        boolean ss = true;
        if ( getScopeSet(cocons) == null || getScopeSet(cocons).equals("")) {
            ss = false;
        }
        if(ts && ss) {
            boolean [] level = new boolean [9];
            for (int i = 0; i < level.length; i++) {
                level[i] = false;
            }
            level[0] = checkLevel0(cocons);
            level[1] = checkLevel1(cocons);
            if (level[0] && level[1]) {
              if(checkLevel2(getTargetSets(cocons)) && checkLevel2(getScopeSets(cocons))) {
                  level[2] = true;
              }
              else {
                  level[2] = false;
              }
            }
            if (level[0] && level[1]) {
              if(checkLevel3(getTargetSets(cocons)) && checkLevel3(getScopeSets(cocons))) {
                  level[3] = true;
              }
              else {
                  level[3] = false;
              }
            }
            if (level[3]) {
              if(checkLevel4(getTargetSets(cocons)) && checkLevel4(getScopeSets(cocons))) {
                  level[4] = true;
              }
              else {
                  level[4] = false;
              }
            }

            if (level[2] && level[4]) {
              if(checkLevel5(getTargetSets(cocons)) && checkLevel5(getScopeSets(cocons))) {
                  level[5] = true;
              }
              else {
                  level[5] = false;
              }
            }
            level[6] = checkLevel6(cocons);
            level[7] = checkClip (cocons);
            level[8] = checkMarkValue (cocons);
            if(level[0] && level[1] && level[2] && level[3] && level[4] && level[5] && level[6] && level[7] && level[8]) {
                valid = true;
            }
        }
        if( !ts && !ss){
            valid = false;
        }
        if(ts && !ss){
            boolean [] level = new boolean [9];
            for (int i = 0; i < level.length; i++) {
                level[i] = false;
            }
            level[0] = checkLevel0(cocons);
            level[1] = checkLevel1(cocons);
            if (level[0] && level[1]) {
              if(checkLevel2(getTargetSets(cocons))) {
                  level[2] = true;
              }
              else {
                  level[2] = false;
              }
            }
            if (level[0] && level[1]) {
              if(checkLevel3(getTargetSets(cocons))) {
                  level[3] = true;
              }
              else {
                  level[3] = false;
              }
            }
            if (level[3]) {
              if(checkLevel4(getTargetSets(cocons))) {
                  level[4] = true;
              }
              else {
                  level[4] = false;
              }
            }

            if (level[2] && level[4]) {
              if(checkLevel5(getTargetSets(cocons))) {
                  level[5] = true;
              }
              else {
                  level[5] = false;
              }
            }
            level[7] = checkClip (cocons);
            level[8] = checkMarkValue (cocons);
            if(level[0] && level[1] && level[2] && level[3] && level[4] && level[5] && level[7] && level[8]) {
                valid = true;
            }
        }
        if(!ts && ss){
            boolean [] level = new boolean [9];
            for (int i = 0; i < level.length; i++) {
                level[i] = false;
            }
            level[0] = checkLevel0(cocons);
            level[1] = checkLevel1(cocons);
            if (level[0] && level[1]) {
              if(checkLevel2(getScopeSets(cocons))) {
                  level[2] = true;
              }
              else {
                  level[2] = false;
              }
            }
            if (level[0] && level[1]) {
              if(checkLevel3(getScopeSets(cocons))) {
                  level[3] = true;
              }
              else {
                  level[3] = false;
              }
            }
            if (level[3]) {
              if(checkLevel4(getScopeSets(cocons))) {
                  level[4] = true;
              }
              else {
                  level[4] = false;
              }
            }

            if (level[2] && level[4]) {
              if(checkLevel5(getScopeSets(cocons))) {
                  level[5] = true;
              }
              else {
                  level[5] = false;
              }
            }
            level[7] = checkClip (cocons);
            level[8] = checkMarkValue (cocons);
            if(level[0] && level[1] && level[2] && level[3] && level[4] && level[5] && level[7] && level[8]) {
                valid = true;
            }
        }
        return valid;
    }

    /*
     * main methode for test
     */
    public static void main(String args[]) {
        //String cocons = "ALL CLASSES WHERE personal 'data' = 'yes' OR THE componets 'test runtime' OR THE componets 'test upload'  MUST BE UNREADABLEBY THE component 'Datawarehouse'";
        //String cocons = "ALL COMPONENTS WHERE ('personal data' = 'yes' AND 'public' = 'false' AND 'value1' = 'const1') OR 'Operatinal Area' = 'Headquartes' OR 'Workflow' CONTAINS 'New Customer' OR ALL componets WHERE 'test time' EQUALS 'systemruntime' OR THE component 'Systemcheck' MUST BE UNREADABLEBY THE component 'Datawarehouse'";
        //String cocons ="ALL COMPONENTS WHERE 'Personal Data' EQUALS 'Yes' MUST BE UNWRITEABLEBY ALL COMPONENTS WHERE 'Operational Area' CONTAINS 'Controlling'";
        //String cocons ="ALL COMPONENTS WHERE 'Personal Data' EQUALS 'Yes' MUST BE UNWRITEABLEBY ";
        //String cocons ="ALL COMPONENTS WHERE 'Personal Data' EQUALS 'Yes' MUST BE UNWRITEABLEBY ALL COMPONENTS WHERE 'Personal Data' EQUALS 'Yes' OR ALL COMPONENTS WHERE ('Personal Data' EQUALS 'Yes' AND 'y' = 'x') OR 'dfgss' = 'wwwww'";
        //String cocons ="ALL COMPONENTS WHERE 'Personal Data' EQUALS 'Yes' MUST BE UNWRITEABLEBY ALL COMPONENTS WHERE ('Personal Data' EQUALS 'Yes' AND 'y' = 'x')";
        //String cocons ="THE component 'Systemcheck' MUST BE UNREADABLEBY THE component 'Datawarehouse'";
        //String cocons ="THE component 'Systemcheck' MUST BE UNREADABLEBY THE component 'Datawarehouse' OR THE component 'Datawarehouse'";
        //String cocons ="MUST BE UNWRITEABLEBY THE component 'Systemcheck'";

        //SyntaxcheckOfCoconsFromBNF coconsBNF = new SyntaxcheckOfCoconsFromBNF();
        //coconsBNF.printNoEmptyElementHashtable(coconsBNF.parserCoCons(cocons));
        //
        //
        //checklevel1
        //System.out.println("###### final ######"+ coconsBNF.isValid(cocons));

    }
}


