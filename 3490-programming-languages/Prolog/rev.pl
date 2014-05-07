rev([],[]).
rev([Hd|Tl],R) :- rev(Tl,Nr),append(Nr,[Hd],R).

incr(X,R) :- R = (X+1).
