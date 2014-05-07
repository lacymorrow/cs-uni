app([],L,L).
app([H|T],L2,[H|L3]) :- app(T,L2,L3).
