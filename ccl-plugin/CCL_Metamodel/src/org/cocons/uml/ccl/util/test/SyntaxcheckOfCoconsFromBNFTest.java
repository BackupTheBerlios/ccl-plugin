package org.cocons.uml.ccl.util.test;

/**
 * Title:        SyntaxcheckOfCoconsFromBNFTest
 * Description:
 * Copyright:    Copyright (c) 2001-2002
 * Company:      TU Berlin, CIS
 * @author Nghia Dang Duc (dangdoni@cs.tu-berlin.de)
 * @version 1.0
 */

import junit.framework.*;
import java.util.*;
import org.cocons.uml.ccl.util.*;
public class SyntaxcheckOfCoconsFromBNFTest extends TestCase {
    private String[] cocons = { "ALL CLASSES WHERE personal data = yes OR THE componets test runtime MUST BE UNREADABLEBY THE component Datawarehouse"
                              ,"ALL COMPONENTS WHERE ('personal data' = 'yes' AND 'public' = 'false') OR 'Operatinal Area' = 'Headquartes' OR 'Workflow' CONTAINS 'New Customer' OR ALL componets WHERE 'test time' EQUALS 'systemruntime' OR THE component 'Systemcheck' MUST BE UNREADABLEBY THE component 'Datawarehouse'"
                              ,"ALL COMPONENTS WHERE `Personal Data' EQUALS `Yes' MUST BE UnreadableBy ALL COMPONENTS WHERE `Operational Area' CONTAINS `Controlling'"
                              ,"ALL COMPONENTS WHERE `Personal Data' EQUALS `Yes' MUST BE UnreadableBy THE component Datawarehouse"
                              ,"THE CLASSE testing MUST BE ReadableBy ALL CLASSES WHERE personal data = no"
                             };
    private String[] keys = {"Context-Based Constraints"
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
                            ,"ElementName Of DirectElement From TargetSet"

                            ,"ContextQuerys Of IndirectElement From TargetSet"
                            ,"ContextQuerys Of IndirectElement From ScopeSet"

                            ,"ContextQuery Of IndirectElement From Target"
                            ,"ContextQuery Of IndirectElement From ScopeSet"

                            ,"ContextQueryDetail Of IndirectElement From TargetSet"
                            ,"ContextQueryDetail Of IndirectElement From ScopeSet"
                            };


    public SyntaxcheckOfCoconsFromBNFTest(String name) {
        super(name);
    }
    public static void main(String args[]) {
        junit.textui.TestRunner.run(SyntaxcheckOfCoconsFromBNFTest.class);
        junit.swingui.TestRunner.run(SyntaxcheckOfCoconsFromBNFTest.class);
    }

    public void testExitedMUSTBE() {
        SyntaxcheckOfCoconsFromBNF coconsBNF1= new SyntaxcheckOfCoconsFromBNF();;
        assertTrue( true == coconsBNF1.exitedMUSTBE(cocons[0]));
    }
    public void testExitedWHERE() {
        SyntaxcheckOfCoconsFromBNF coconsBNF1= new SyntaxcheckOfCoconsFromBNF();
        assertTrue( true == coconsBNF1.exitedWHERE(cocons[0]));
    }
    public void testExitedCondition() {
        SyntaxcheckOfCoconsFromBNF coconsBNF1= new SyntaxcheckOfCoconsFromBNF();
        assertTrue( true == coconsBNF1.exitedCondition(cocons[0]));
    }

    public void testGetTargetSets() {
        SyntaxcheckOfCoconsFromBNF coconsBNF= new SyntaxcheckOfCoconsFromBNF();
        assertEquals( "ALL COMPONENTS WHERE `Personal Data' EQUALS `Yes' ", coconsBNF.getTargetSets(cocons[2]));
    }

    public void testGetCoConsType() {
        SyntaxcheckOfCoconsFromBNF coconsBNF= new SyntaxcheckOfCoconsFromBNF();
        assertEquals( "UnreadableBy", coconsBNF.getCoConsType(cocons[2]));
    }

    public void testGetScopeSets() {
        SyntaxcheckOfCoconsFromBNF coconsBNF= new SyntaxcheckOfCoconsFromBNF();
        assertEquals( "ALL COMPONENTS WHERE `Operational Area' CONTAINS `Controlling' ", coconsBNF.getScopeSets(cocons[2]));
    }

    public void testIsIndirect() {
        SyntaxcheckOfCoconsFromBNF coconsBNF1= new SyntaxcheckOfCoconsFromBNF();
        assertTrue( true == coconsBNF1.isIndirect(coconsBNF1.getTargetSets(cocons[2])));
        assertTrue( true == coconsBNF1.isIndirect(coconsBNF1.getScopeSets(cocons[2])));
    }

    public void testIsDirect1() {
        SyntaxcheckOfCoconsFromBNF coconsBNF1= new SyntaxcheckOfCoconsFromBNF();
        assertTrue( false == coconsBNF1.isDirect(coconsBNF1.getTargetSets(cocons[2])));
        assertTrue( true == coconsBNF1.isDirect(coconsBNF1.getScopeSets(cocons[3])));
    }

    public void testIsDirect2() {
        SyntaxcheckOfCoconsFromBNF coconsBNF1= new SyntaxcheckOfCoconsFromBNF();
        assertTrue( true == coconsBNF1.isDirect(coconsBNF1.getScopeSets(cocons[3])));
    }
    public void testKesOfParserCoCons() {
        SyntaxcheckOfCoconsFromBNF coconsBNF1 = new SyntaxcheckOfCoconsFromBNF();
        Hashtable hash = coconsBNF1.parserCoCons (cocons[3]);
        Vector keysToComparison = new Vector();
        for (Enumeration k = hash.keys () ; k.hasMoreElements () ;) {
            String key = (k.nextElement()).toString();
            keysToComparison.addElement(key);
        }
        String[] toComparison = new String[keysToComparison.size()];
        for(int i = 0; i < keysToComparison.size(); i++) {
            toComparison[i] = (keysToComparison.get(i)).toString();
        }
        String[] keytest = keys;
        assertEquals(keytest.length, toComparison.length);
    }

    public void testCheckMarkValue() {
        SyntaxcheckOfCoconsFromBNF coconsBNF1= new SyntaxcheckOfCoconsFromBNF();
        assertTrue( true == coconsBNF1.checkMarkValue(cocons[1]));
    }
    public void testCheckClip() {
        SyntaxcheckOfCoconsFromBNF coconsBNF1= new SyntaxcheckOfCoconsFromBNF();
        assertTrue( true == coconsBNF1.checkClip(cocons[1]));
    }
}
