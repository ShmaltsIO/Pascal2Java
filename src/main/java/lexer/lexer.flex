import java_cup.runtime.*;

%%

%class CalcLexer

%cup    // enables CUP compatibility
%line   // yyline var
%column // yycolumn var

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

// Regular expressions

LineTerminator = \r|\n|\r\n
Whitespace     = {LineTerminator}|[ \t\f]
Digit = [0-9]
IntegerNumber  = 0|[1-9]{Digit}*|"-"[1-9]{Digit}*
Letter = [a-zA-Z]
IdentifierCharacter = {Letter} | {Digit} | "_"
Identifier = [A-Za-z] [A-Za-z0-9]*

%%

/* Rules */

"program"       { return symbol(sym.PROGRAM); }

"+"             { return symbol(sym.PLUS); }
"-"             { return symbol(sym.MINUS); }
"*"             { return symbol(sym.TIMES); }
"/"             { return symbol(sym.DIVIDE); }

"("             { return symbol(sym.PARENTHESESLEFT); }
")"             { return symbol(sym.PARENTHESESRIGHT); }

"var"           { return symbol(sym.VAR); }

"integer"       { return symbol(sym.INTEGER); }

":="            { return symbol(sym.EQUAL); }

"read"          { return symbol(sym.READ, yytext()); }
"writeln"       { return symbol(sym.WRITE, yytext()); }

"begin"         { return symbol(sym.BEGIN); }
"end"           { return symbol(sym.END); }

"."             { return symbol(sym.DOT); }
":"             { return symbol(sym.COLON); }
";"             { return symbol(sym.SEMICOLON); }

{IntegerNumber} { return symbol(sym.NUMBER, Integer.valueOf(yytext())); }

{Whitespace}    { /* Ignore */ }

{Identifier}    { return symbol(sym.IDENTIFIER, yytext()); }

.               { throw new RuntimeException("Invalid character: " + yytext()); }