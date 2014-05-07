puzzle(P) :- length(X, Y), Y < 15, solution([e, e, e, e], X),
append([[e, e, e, e]], X, P), printSolution(P).


solution([w,w,w,w], []).

solution(X, [Y|Z]) :- move(X, Y), solution(Y, Z).

move([F1,W,G,C], [F2,W,G,C]) :- opposite(F1,F2),
safe([F2,W,G,C]).

move([F1,F1,G,C], [F2,F2,G,C]) :- opposite(F1,F2),
safe([F2,F2,G,C]).

move([F1,W,F1,C], [F2,W,F2,C]) :- opposite(F1,F2),
safe([F2,W,F2,C]).

move([F1,W,G,F1], [F2,W,G,F2]) :- opposite(F1,F2),
safe([F2,W,G,F2]).

safe([F, W, G, C]) :- \+(unsafe([F, W, G, C])).

unsafe([F, W, W, _]) :- opposite(F, W).
unsafe([F, _, G, G]) :- opposite(F, G).


printSolution([X|Y]) :- write('Start. '), writeLocation(X),
printMoves([X|Y]), write('Solved. \n').

writeLocation(X) :- getList(X, e, E), getList(X, w, W),
write('East: '), writeList(E),
write('West: '), writeList(W), write('\n').

%NEED getList and writeList

printMoves([]).
printMoves([_]).

printMoves([X, Y|Z]) :- X = [A, B, C, D], Y = [E, B, C, D],
opposite(A, E),
write('Farmer takes self. '),
writeLocation(Y),
printMoves([Y|Z]).

printMoves([X, Y|Z]) :- X = [A, A, C, D], Y = [E, E, C, D],
opposite(A, E),
write('Farmer takes wolf. '),
writeLocation(Y),
printMoves([Y|Z]).

printMoves([X, Y|Z]) :- X = [A, B, A, D], Y = [E, B, E, D],
opposite(A, E),
write('Farmer takes goat. '),
writeLocation(Y),
printMoves([Y|Z]).

printMoves([X, Y|Z]) :- X = [A, B, C, A], Y = [E, B, C, E],
opposite(A, E),
write('Farmer takes cabbage. '),
writeLocation(Y),
printMoves([Y|Z]).
