import antlr.BaseAST;
import antlr.Token;
import antlr.collections.AST;
import java.io.*;

/** A simple node to represent an INT */
public class INTNode extends CalcAST {
    int v=0;

    public INTNode(Token tok) {
	v = Integer.parseInt(tok.getText());
    }

    /** Compute value of subtree; this is heterogeneous part :) */
    public int value() {
	return v;
    }

    public String toString() {
	return " "+v;
    }

    public void xmlSerializeNode(Writer out) throws IOException {
	out.write("<int>"+v+"</int>");
    }

    // satisfy abstract methods from BaseAST
    public void initialize(int t, String txt) {
    }
    public void initialize(AST t) {
    }
    public void initialize(Token tok) {
    }
}
