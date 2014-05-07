
#include "Headers/Register.h"
#include "Headers/FpStatusWord.h"

#include <stdio.h>

FpStatusWord::FpStatusWord()
{
	set(0);
}


void FpStatusWord::printFpStatusWord()
{

	printf("FER: %1d  FID: %1d  FIUV: %1d  ", getFER(), 
             					  getFID(), 
						  getFIUV());
	printf(" FIU: %1d  FIV: %1d  FIC: %1d   FD: %1d\n", getFIU(), 
	               					    getFIV(), 
						            getFIC(),
							    getFD());
	printf(" FL: %1d   FT: %1d  FMM: %1d             ", getFL(), 
                                                            getFT(), 
                                                            getFMM());
	printf("FN: %1d   FZ: %1d   FV: %1d   FC: %1d\n\n", getFN(), getFZ(), 
						      getFV(),
                                                      getFC());
}


unsigned int FpStatusWord::getFER()
{
	return getBit(15);
}

unsigned int FpStatusWord::getFID()
{
	return getBit(14);
}

unsigned int FpStatusWord::getFIUV()
{
	return getBit(11);
}

unsigned int FpStatusWord::getFIU()
{
	return getBit(10);
}

unsigned int FpStatusWord::getFIV()
{
	return getBit(9);
}

unsigned int FpStatusWord::getFIC()
{
	return getBit(8);
}

unsigned int FpStatusWord::getFD()
{
	return getBit(7);
}

unsigned int FpStatusWord::getFL()
{
	return getBit(6);
}

unsigned int FpStatusWord::getFT()
{
	return getBit(5);
}

unsigned int FpStatusWord::getFMM()
{
	return getBit(4);
}

unsigned int FpStatusWord::getFN()
{
	return getBit(3);
}

unsigned int FpStatusWord::getFZ()
{
	return getBit(2);
}

unsigned int FpStatusWord::getFV()
{
	return getBit(1);
}

unsigned int FpStatusWord::getFC()
{
	return getBit(0);
}

