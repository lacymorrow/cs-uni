del(_, [], []).
del(H, [H|T], Res) :- del(H, T, Res).
del(I, [H|T], [H|R]) :- I \== H,del(I, T, R).

el([],[]).
el([H|T], R) :- ll(H,T,[N|R1]),el(R1,R2),append(R1,R2,R).
ll(I,[H|T], R) :- I \= H,ll(I,T,[H|R]).
ll(H,[H|T], [R|T]).

qs([],[]).
qs([H|T],R) :- smaller(H,T,R1,R2),qs(R2,Rs),qs(R1,Rg),append(Rs,[H|Rg],R).

smaller(_,[],[],[]).
smaller(I,[H|T],[H|R1],R2) :- I < H, smaller(I,T,R1,R2).
smaller(I,[H|T],R1,[H|R2]) :- H < I, smaller(I,T,R1,R2).
