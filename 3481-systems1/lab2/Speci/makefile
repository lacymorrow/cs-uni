
CC = g++

H=Headers
HDRS=$(H)/Register.h $(H)/ProcessorStateWord.h $(H)/FpStatusWord.h\
$(H)/IntRegisterFile.h $(H)/FpRegisterFile.h $(H)/Memory.h \
$(H)/Cpu.h
build:
	(cd Group12a; make)
	(cd Group9; make)
	make speci

speci: Group12a/Group12a.o Group12a/Trap.o \
Group9/Group9.o Group9/Halt.o Register.o ProcessorStateWord.o \
FpStatusWord.o IntRegisterFile.o FpRegisterFile.o \
Memory.o Cpu.o Instruction.o Loader.o speci.o

Register.o: $(H)/Register.h
ProcessorStateWord.o:$(H)/ProcessorStateWord.h $(H)/Register.h
FpStatusWord.o:$(H)/FpStatusWord.h $(H)/Register.h
IntRegisterFile.o:$(H)/IntRegisterFile.h $(H)/Register.h
FpRegisterFile.o:$(H)/FpRegisterFile.h $(H)/FpStatusWord.h $(H)/Register.h
Memory.o: $(H)/Memory.h
Cpu.o:$(HDRS)
Instruction.o:$(HDRS) $(H)/Instruction.h
Loader.o:$(HDRS) $(H)/Loader.h
speci.o:$(HDRS)

clean:
	rm -f *.o
	(cd Group12a; make clean)
	(cd Group9; make clean)
