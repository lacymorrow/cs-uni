/***************************************************************************
 *								 
 *  Cpu.h								
 ***************************************************************************/

#ifndef CPU_H
#define CPU_H
class Cpu
{
	public:
		Cpu(Memory * mem);

		// The CPU's Dumping Procedures
		void DumpMisc();
		void DumpRegs();
	private:
                void printProcessorError();
		bool activity;
		IntRegisterFile intRegs;
		FpRegisterFile fpRegs;
		bool illegalInstruction;
		bool timeLimitError;
                Memory * mem;
};
#endif


