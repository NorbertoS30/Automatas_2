package Otros;
import static Otros.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
public |
String |
int |
int |
char |
float |
if |
else |
while {lexeme=yytext(); return Reservadas;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {return Igual;}
"+" {return Suma;}
"-" {return Resta;}
"*" {return Multiplicacion;}
"/" {return Division;}
"||" {return OR;}
"&&" {return AND;}
"!" {return NOT;}
"\("  {lexeme.yytext(); return Parentesis_Apertura}
"\)"  {lexeme.yytext(); return Parentesis_Cierre}
";" {return Delimitador;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
{L}{1} {lexeme=yytext(); return Caracter;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
("(-"{D}+")")|{D}+|({D}+"."{D}+) {lexeme=yytext(); return Flotante;}
 . {return ERROR;}