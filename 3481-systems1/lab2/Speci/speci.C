
#include "Headers/Register.h"
#include "Headers/ProcessorStateWord.h"
#include "Headers/FpStatusWord.h"
#include "Headers/IntRegisterFile.h"
#include "Headers/FpRegisterFile.h"
#include "Headers/Memory.h"
#include "Headers/Cpu.h"
#include "Headers/Loader.h"

int main(int argc, char * argv[])
{
	Memory mem;
	Cpu cpu(&mem);
	Loader l(&cpu, &mem);

	cpu.DumpRegs();  
	cpu.DumpMisc(); 
	mem.DumpMp();
}
