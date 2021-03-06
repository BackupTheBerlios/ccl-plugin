header {
#include "antlr/TokenStreamSelector.hpp"
}

options {
	language="Cpp";
}

class DemoJavaDocLexer extends Lexer;
options {
	k=2;
	importVocab = Common;
	exportVocab = JavaDoc;
	filter=true;
}

{
private:
	ANTLR_USE_NAMESPACE(antlr)TokenStreamSelector* selector;
public:
	void setSelector(ANTLR_USE_NAMESPACE(antlr)TokenStreamSelector* selector_) {
		selector=selector_;
	}
}

PARAM
	:	"@param" ' ' ID
	;

EXCEPTION
	:	"@exception" ' ' ID
	;

protected
ID	:	('a'..'z'|'A'..'Z')+
	;

/** This rule simply prevents JAVADOC_CLOSE from being
 *  called for every '*' in a comment.  Calling JAVADOC_CLOSE
 *  will fail for simple '*' and cause an exception, which
 *  is slow.  In other words, the grammar will work without
 *  this rule, but is slower.
 */
STAR:	'*' {$setType(ANTLR_USE_NAMESPACE(antlr)Token::SKIP);}
	;

JAVADOC_CLOSE
	:	"*/" {selector->pop();}
	;

/** Ignore whitespace inside JavaDoc comments */
NEWLINE
	:	(	"\r\n"  // Evil DOS
		|	'\r'    // Macintosh
		|	'\n'    // Unix (the right way)
		)
		{ newline(); $setType(ANTLR_USE_NAMESPACE(antlr)Token::SKIP); }
	;
