CC = g++
H = Headers
HDRS = $(H)/Register.h $(H)/ProcessorStateWord.h $(H)/FpStatusWord.h\
$(H)/IntRegisterFile.h $(H)/FpRegisterFile.h $(H)/Memory.h \
$(H)/Cpu.h $(H)/Instruction.h $(H)/Group9.h

all: Group9.o Halt.o
Group9.o: $(HDRS)
Halt.o: $(HDRS) $(H)/Halt.h
clean:
	rm -f *.o
