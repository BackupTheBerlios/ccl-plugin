package antlr.collections.impl;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: ASTArray.java,v 1.1 2003/07/12 18:30:03 layekers Exp $
 */

import antlr.collections.AST;

/** ASTArray is a class that allows ANTLR to
 * generate code that can create and initialize an array
 * in one expression, like:
 *    (new ASTArray(3)).add(x).add(y).add(z)
 */
public class ASTArray {
    public int size = 0;
    public AST[] array;


    public ASTArray(int capacity) {
        array = new AST[capacity];
    }

    public ASTArray add(AST node) {
        array[size++] = node;
        return this;
    }
}
