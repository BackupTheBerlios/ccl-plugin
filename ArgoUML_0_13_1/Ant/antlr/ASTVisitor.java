package antlr;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: ASTVisitor.java,v 1.1 2003/07/12 18:29:28 layekers Exp $
 */

import antlr.collections.AST;

public interface ASTVisitor {
    public void visit(AST node);
}
