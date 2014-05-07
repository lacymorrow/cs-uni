toolstest: main.o tools.o
	gcc main.o tools.o -o toolstest

tools.o: bool.h tools.h tools.c
	gcc -c tools.c

