/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: NoViableAltForCharException.cpp,v 1.1 2003/07/12 18:27:40 layekers Exp $
 */

#include "antlr/NoViableAltForCharException.hpp"
#include "antlr/String.hpp"

#ifdef ANTLR_CXX_SUPPORTS_NAMESPACE
namespace antlr {
#endif

NoViableAltForCharException::NoViableAltForCharException(int c, CharScanner* scanner)
  : RecognitionException("NoViableAlt",
                         scanner->getFilename(),
								 scanner->getLine(),scanner->getColumn()),
    foundChar(c)
{
}

NoViableAltForCharException::NoViableAltForCharException(
					int c,
               const ANTLR_USE_NAMESPACE(std)string& fileName_,
					int line_, int column_)
  : RecognitionException("NoViableAlt",fileName_,line_,column_),
    foundChar(c)
{
}

ANTLR_USE_NAMESPACE(std)string NoViableAltForCharException::getMessage() const
{
	return ANTLR_USE_NAMESPACE(std)string("unexpected char: ")+charName(foundChar);
}

#ifdef ANTLR_CXX_SUPPORTS_NAMESPACE
}
#endif
