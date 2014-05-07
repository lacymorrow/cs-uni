
#ifndef FPSTATUSWORD_H
#define FPSTATUSWORD_H

class FpStatusWord : public Register
{
	public:
		FpStatusWord();
		void printFpStatusWord();
		unsigned int getFER();
		unsigned int getFID();
		unsigned int getFIUV();
		unsigned int getFIU();
		unsigned int getFIV();
		unsigned int getFIC();
		unsigned int getFD();
		unsigned int getFL();
		unsigned int getFT();
		unsigned int getFMM();
		unsigned int getFN();
		unsigned int getFZ();
		unsigned int getFV();
		unsigned int getFC();
};

#endif	

