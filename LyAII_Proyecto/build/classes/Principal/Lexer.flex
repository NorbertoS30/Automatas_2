package Principal;
import static Principal.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%
("String") {lexeme=yytext(); return Cadena;}
( byte | int | char | long | float | double ) {lexeme=yytext(); return T_dato;}
(public) {lexeme=yytext(); return Public;}
(main) {lexeme=yytext(); return Main;}
(if) {lexeme=yytext(); return If;}
(else) {lexeme=yytext(); return Else;}
(do) {lexeme=yytext(); return Do;}
(while) {lexeme=yytext(); return While;}
(for) {lexeme=yytext(); return For;}
(scanner) {lexeme=yytext(); return Scanner;}
(print) {lexeme=yytext(); return Print;}
(println) {lexeme=yytext(); return Print_ln;}
{espacio} {/*Ignore*/}
("//".*) {/*Ignore*/}
("\n") {return S_linea;}
("\"") {lexeme=yytext(); return Comillas;}
("=") {lexeme=yytext(); return Igual;}
("+") {lexeme=yytext(); return Suma;}
("-") {lexeme=yytext(); return Resta;}
("*") {lexeme=yytext(); return Multiplicacion;}
("/") {lexeme=yytext(); return Division;}
( "&&" | "||" | "!" | "&" | "|" ) {lexeme=yytext(); return Op_logico;}
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {lexeme = yytext(); return Op_relacional;}
( "+=" | "-="  | "*=" | "/=" | "%=" ) {lexeme = yytext(); return Op_atribucion;}
( "++" | "--" ) {lexeme = yytext(); return Op_incremento;}
(true | false) {lexeme = yytext(); return Op_booleano;}
("\(") {lexeme=yytext(); return Parentesis_Apertura;}
("\)") {lexeme=yytext(); return Parentesis_Cierre;}
("\{") {lexeme=yytext(); return Llave_Apertura;}
("\}") {lexeme=yytext(); return Llave_Cierre;}
("\[") {lexeme=yytext(); return Corchete_Apertura;}
("\]") {lexeme=yytext(); return Corchete_Cierre;}
(";") {lexeme=yytext(); return P_coma;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}

("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}