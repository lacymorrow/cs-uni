#include "Headers/Register.h"
#include "Headers/ProcessorStateWord.h"
#include "Headers/FpStatusWord.h"
#include "Headers/IntRegisterFile.h"
#include "Headers/FpRegisterFile.h"
#include "Headers/Memory.h"
#include "Headers/Cpu.h"
#include <stdio.h>

Cpu::Cpu(Memory * m)
{
   mem = m;
}

/************************************************************************
 *  DumpMisc									*
 *									*
 *  Displays the State of Misc Portions of the CPU			*
 ************************************************************************/

void Cpu::DumpMisc()
{
	intRegs.printPSW();
	printProcessorError();
	intRegs.printInstructionCounts();
	fpRegs.printFpStatus();

}


/************************************************************************
 *  DumpRegs									*
 *									*
 *  Displays the Register State						*
 ************************************************************************/

void Cpu::DumpRegs()
{
	intRegs.printRegs(); 
	fpRegs.printACs();
}

void Cpu::printProcessorError()
{
	printf("II: %1d  TO: %1d  BE: %1d  ",illegalInstruction,
                                             mem->getTimeOut(),
                                             mem->getBoundaryError()); 
	printf("SO: %1d               TL: %1d   ",mem->getStackOverflow(),
                                                 timeLimitError);
}


