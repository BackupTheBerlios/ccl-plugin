package antlr;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: StringLiteralSymbol.java,v 1.1 2003/07/12 18:49:16 layekers Exp $
 */

class StringLiteralSymbol extends TokenSymbol {
	protected String label;	// was this string literal labeled?


	public StringLiteralSymbol(String r) {
		super(r);
	}
	public String getLabel() { return label; }
	public void setLabel(String label) {this.label = label;}
}
