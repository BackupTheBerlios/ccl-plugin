package antlr.collections;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: Stack.java,v 1.1 2003/07/12 18:30:03 layekers Exp $
 */

import java.util.NoSuchElementException;

/** A simple stack definition; restrictive in that you cannot
 * access arbitrary stack elements.
 *
 * @author Terence Parr
 * <a href=http://www.MageLang.com>MageLang Institute</a>
 */
public interface Stack {
    public int height();

    public Object pop() throws NoSuchElementException;

    public void push(Object o);

    public Object top() throws NoSuchElementException;
}
