CC = gcc
C_FILES = wici.c instruction.c table.c stack.c
OBJ = $(C_FILES:.c=.o)
OUT = wici

all: $(OBJ)
	$(CC -o $(OUT) $(OBJ)
	
.c.o:
	$(CC) -c -o $@ $<
	
clean:
	rm -rf *.o==$(OBJ) debug

debug: $(CC) -g $(C_FILES) -o debug
