package antlr.collections.impl;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: LLCell.java,v 1.1 2003/07/12 18:38:37 layekers Exp $
 */

/**A linked list cell, which contains a ref to the object and next cell.
 * The data,next members are public to this class, but not outside the
 * collections.impl package.
 *
 * @author Terence Parr
 * <a href=http://www.MageLang.com>MageLang Institute</a>
 */
class LLCell {
	Object data;
	LLCell next;


	public LLCell(Object o) { data=o; }
}
