package antlr;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: AlternativeElement.java,v 1.1 2003/07/12 18:38:09 layekers Exp $
 */

abstract class AlternativeElement extends GrammarElement {
	AlternativeElement next;
	protected int autoGenType = AUTO_GEN_NONE;

	protected String enclosingRuleName;


	public AlternativeElement(Grammar g) {
		super(g);
	}
	public AlternativeElement(Grammar g, int autoGenType_) {
		super(g);
		autoGenType = autoGenType_;
	}
	public int getAutoGenType() {
		return autoGenType;
	}
	public String getLabel() {
		return null;
	}
	public void setLabel(String label) {}
}
