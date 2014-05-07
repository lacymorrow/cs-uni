/***************************************************************************
 *                                                                         *
 *  IntRegisterFile.C                                                      * 
 *                                                                         *
 *                                                                         *
 ***************************************************************************/
#include <stdio.h>

#include "Headers/Register.h"
#include "Headers/ProcessorStateWord.h"
#include "Headers/IntRegisterFile.h"

IntRegisterFile::IntRegisterFile()
{
}


void IntRegisterFile::printPSW()
{
   
	printf("Z:  %1d  N:  %1d  C:  %1d  V:  %1d\n",psw.getZ(),
                                                      psw.getN(),
                                                      psw.getC(),
                                                      psw.getV());
}

void IntRegisterFile::printInstructionCounts()
{

	printf("IC: %06o  IL: %06o\n\n",IC.get(),IL.get());
}




void IntRegisterFile::printRegs()
{
	int i;

	printf("R0-R7:   ");
	for (i=0;i<NUM_REGS;i++)
		printf("%06o  ",(int) regs[i].get());
    		printf("\n\n");

}




