

#ifndef FpRegisterFile_H
#define FpRegisterFile_H

const int NUM_ACS = 6;

class FpRegisterFile
{
	private:
		FpStatusWord fps;
		Register fec;
		Register AChigh[NUM_ACS];
		Register AClow[NUM_ACS];
	public:
		FpRegisterFile();
		void printFpStatus();
		void printACs();
};

#endif	

