/***************************************************************************
 *  Memory.h							
 ***************************************************************************/

#ifndef MEMA_H
#define MEMA_H

// Define memory sizes and sections
const int MEM_SIZE = 04000;

// Definitions for Dumping routine
const int NOPERLINE =8;

class Memory
{
	public:
		Memory();
		void DumpMp();
		void init();
                bool getTimeOut();
                bool getStackOverflow();
                bool getBoundaryError();

	private:
		unsigned int Mp[MEM_SIZE];
                bool boundaryError;
                bool stackOverflow;
                bool timeOut;
		int  compare  (long *, long *);
		void showline (int, long *);
		void copyline (long *, long *);
};

#endif
