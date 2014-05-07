% Wren Lexical Analyzer
%---------------------------------------------------------------
wrenLex(Tokens) :- nl,
    write('>>> Lexical Analyzer for Wren <<<'), nl,
    write('Enter name of source file: '), nl,
    getfilename(FileName), nl,
    see(FileName), scan(Tokens), seen,
    write('Scan successful').

getfilename(F) :- get0(C), restfilename(C,Cs),
    atom_codes(F,Cs).

restfilename(C,[]) :- \+(filechar(C)).
    restfilename(C,[C|Cs]) :- filechar(C), get0(D),
    restfilename(D,Cs).

%File Check Functions
filechar(C) :- lower(C); upper(C); digit(C); period(C); slash(C).

lower(C) :- 97 =< C, C =< 122.
upper(C) :- 65 =< C, C =< 90.
digit(C) :- 48 =< C, C =< 57.
period(C) :- C is 46.
slash(C) :- C is 47.


%Scan Functions
scan([T|Ts]) :- get0(Ci), gettoken(Ci, T, Co), restprog(T, Co, Ts).

restprog(eop, _, []). % end of file in previous character
restprog(_, Ci, [T|Lt]) :- gettoken(Ci, T, Co), restprog(T, Co, Lt).

%whitespace/EOF
gettoken(Ci, T, Co) :- whitespace(Ci), get0(C), gettoken(C,T,Co).
gettoken(C, eop, 0) :- endfile(C).

%single/double
gettoken(Ci, To, Co) :- double(Ci,Ti),get0(C),buildpair(Ci, C, Co, Ti, To).
gettoken(C, T, _) :- single(C, T).

%identifier/resword
gettoken(Ci, To, Co) :- lower(Ci), restid(Ci, Lc, Co), atom_codes(Ti, Lc), buildid(Ti, To).
gettoken(C, _, _) :- write('Illegal character: '), put(C), nl, abort.

restid(C, [], C ) :- \+(idchar(C)).
restid(C, L, Co ) :- idchar(C), get0(C2), restid(Co,[L|Co],C2).

buildid(Ti, To) :- \+resword(Ti), To = ide(Ti).
buildid(Ti, Ti) :- resword(Ti).

buildpair(C1i, C2i, Co, _, To) :- pair(C1i, C2i, To), get0(Co).
buildpair(C1i, C2i, C2i, Ti, Ti) :- /+(pair(C1i, C2i, Ti)).


%Keyword Functions

idchar(C) :- lower(C); upper(C).

single(40, lparen).
single(41, rparen).
single(42, mult).
single(43, plus).
single(44, comma).
single(45, minus).
single(47, div).
single(58, colon).
single(59, semicolon).
single(60, less).
single(61, equals).
single(62, grtr).

double(58,colon). % : (colon) or := (assign)
double(60,less).  % < (less) or <> (neq) or <= (leq)
double(62,grtr).  % > (grtr) or >= (geq)

pair(58, 61, assign). % :=
pair(60, 62, neq).    % <>
pair(60, 61, leq).    % <=
pair(62, 61, geq).    % >=
pair(60, 61, leq).    % <=

whitespace(C) :- space(C); tabch(C); endline(C).

space(32).
tabch(9).
endline(10).

endfile(26).
endfile(-1).

resword(program).
resword(is).
resword(begin).
resword(end).
resword(var).
resword(integer).
resword(boolean).
resword(read).
resword(write).
resword(skip).
resword(while).
resword(do).
resword(if).
resword(then).
resword(else).
resword(and).
resword(or).
resword(false).
resword(true).
resword(not).

