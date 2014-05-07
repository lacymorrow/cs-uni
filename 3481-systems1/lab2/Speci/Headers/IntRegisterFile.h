/***************************************************************************
 *  IntRegisterFile.h					 
 ***************************************************************************/


#ifndef INTREGISTERFILE_H
#define INTREGISTERFILE_H

const int NUM_REGS = 8;

class IntRegisterFile
{
	public:
		IntRegisterFile();
		void printPSW();
		void printRegs();
		void printInstructionCounts();

	private:
		Register regs[NUM_REGS];
		ProcessorStateWord psw;

		Register IC;
		Register IR;
		Register IL;

};

#endif
