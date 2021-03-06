/*
 * Make sure to run antlr.Tool on the lexer.g file first!
 */
options {
	mangleLiteralPrefix = "TK_";
	language = "Sather";
}

class TINYC_LEXER extends Lexer;
options {
	k=2;
	exportVocab=TINYC;
	charVocabulary = '\3'..'\377';
}

tokens {
	"int"; "char"; "if"; "else"; "while";
}

WS	:	(' '
	|	'\t'
	|	'\n'	{newline;}
	|	'\r')
		{ sa_ttype := ANTLR_COMMON_TOKEN::SKIP; }
	;


SL_COMMENT : 
	"//" 
	(~'\n')* '\n'
	{ sa_ttype := ANTLR_COMMON_TOKEN::SKIP; newline; }
	;

ML_COMMENT
	:	"/*"
		(	{ LA(2) /= '/' }? '*'
		|	'\n' { newline; }
		|	~('*'|'\n')
		)*
		"*/"
			{  sa_ttype := ANTLR_COMMON_TOKEN::SKIP; }
	;


LPAREN
options {
	paraphrase="'('";
}
	:	'('
	;

RPAREN
options {
	paraphrase="')'";
}
	:	')'
	;

LCURLY:	'{'
	;

RCURLY:	'}'
	;

STAR:	'*'
	;

PLUS:	'+'
	;

ASSIGN
	:	'='
	;

SEMI:	';'
	;

COMMA
	:	','
	;

CHAR_LITERAL
	:	'\'' (ESC|~'\'') '\''
	;

STRING_LITERAL
	:	'"' (ESC|~'"')* '"'
	;

protected
ESC	:	'\\'
		(	'n'
		|	'r'
		|	't'
		|	'b'
		|	'f'
		|	'"'
		|	'\''
		|	'\\'
		|	'0'..'3'
			(
				options {
					warnWhenFollowAmbig = false;
				}
			:	DIGIT
				(
					options {
						warnWhenFollowAmbig = false;
					}
				:	DIGIT
				)?
			)?
		|	'4'..'7'
			(
				options {
					warnWhenFollowAmbig = false;
				}
			:	DIGIT
			)?
		)
	;

protected
DIGIT
	:	'0'..'9'
	;

INT	:	(DIGIT)+
	;

ID
options {
	testLiterals = true;
	paraphrase = "an identifier";
}
	:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
	;


