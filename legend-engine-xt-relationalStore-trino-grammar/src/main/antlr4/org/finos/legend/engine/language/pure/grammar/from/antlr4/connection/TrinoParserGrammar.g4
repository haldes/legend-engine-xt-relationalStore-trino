parser grammar TrinoParserGrammar;

import CoreParserGrammar;

options
{
    tokenVocab = TrinoLexerGrammar;
}

identifier:                                 VALID_STRING
;

