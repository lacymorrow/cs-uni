
#include "Headers/Register.h"
#include "Headers/FpStatusWord.h"
#include "Headers/FpRegisterFile.h"
#include <stdio.h>

FpRegisterFile::FpRegisterFile()
{

}

void FpRegisterFile::printFpStatus()
{
	printf("FEC: %d  ", fec.get());
	fps.printFpStatusWord();
}


void FpRegisterFile::printACs()
{
	int i;
    char noSpace[] = "";
    char space[] = "    ";
	char * spacer;

	printf("AC0-AC2: "); 
	spacer = noSpace;
	for (i=0;i<3;i++)
	{
		printf("%s%06lo  %06lo", spacer, AChigh[i].get(), 
                                                 AClow[i].get());
		spacer = space;
	}
	printf("\n");

	printf("AC3-AC5: ");
	spacer = noSpace;
	for (i=3;i<6;i++)
	{
		printf("%s%06lo  %06lo", spacer, AChigh[i].get(), 
                                                 AClow[i].get());
		spacer = space;
	 }
	 printf("\n\n");
}

