package antlr.collections;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: Enumerator.java,v 1.1 2003/07/12 18:49:35 layekers Exp $
 */

public interface Enumerator {
	/**Return the element under the cursor; return null if !valid() or
	 * if called before first next() call.
	 */
	public Object cursor();
	/**Return the next element in the enumeration; first call to next()
	 * returns the first element.
	 */
	public Object next();
	/**Any more elements in the enumeration? */
	public boolean valid();
}
