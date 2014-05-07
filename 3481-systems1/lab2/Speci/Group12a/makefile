CC = g++
H = Headers
HDRS = $(H)/Register.h $(H)/ProcessorStateWord.h $(H)/FpStatusWord.h\
$(H)/IntRegisterFile.h $(H)/FpRegisterFile.h $(H)/Memory.h \
$(H)/Cpu.h $(H)/Instruction.h $(H)/Group12a.h

all: Group12a.o Trap.o
Group12a.o: $(HDRS)
Trap.o: $(HDRS) $(H)/Trap.h
clean:
	rm -f *.o
