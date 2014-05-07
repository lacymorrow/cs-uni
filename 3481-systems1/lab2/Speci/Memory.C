/***************************************************************************
 *                                                                         *
 *  Memory.C                                                               *
 *                                                                         *
 *  This file includes the implementation for the mem class.  It is meant  *
 *  to simulate the memory system of the PDP-11, but may be used for any   *
 *  16-bit wide byte-addressable memory modules.                           *
 *                                                                         *
 *                                                                         *
 ***************************************************************************/

#include "Headers/Memory.h"
#include <stdio.h>

Memory::Memory()
{
	init();
}

void Memory::init()
{
	for (int i = 0; i < MEM_SIZE; i++)
		Mp[i] = 0;
}

/************************************************************************
 *  compare                                                             *
 *                                                                      *
 *  Compare two lines and return 1 if they are equal, 0 if not          *
 ************************************************************************/
//Used in Dumping Procedures
int Memory::compare(long *line1, long *line2)
{
	int i,equal = 1;

	for (i=0;i<NOPERLINE;i++)
		equal = equal && ( line1[i] == line2[i] );

	return equal;
}

/************************************************************************
 *  showline                                                            *
 *                                                                      *
 *  Prints the addr and the contents at the addr of an entire line      *
 *  Params:  addr - start address of the line to print			*
 *	     line - an array of contents of addressess in a line	*
 ************************************************************************/

// Used in Dumping Procedures
void Memory::showline(int addr, long *line)
{
	int i;

	printf("%06o:  ",addr * 2);
	for (i=0;i<NOPERLINE;i++)
		printf("%06o  ",(int)line[i]);
}

/************************************************************************
 *  copyline                                                            *
 *                                                                      *
 *  This copies the contents of one line into another                   *
 ************************************************************************/

// Used in Dumping Procedures
void Memory::copyline(long *line, long *line2)
{
	int i;

	for (i=0;i<NOPERLINE;i++)
		line[i] = line2[i];
}

/************************************************************************
 *  DumpMp()                                                            *
 *                                                                      *
 *  Author:  unknown	                                                *
 *                                                                      *
 *  This dumps memory to the screen				        *
 ************************************************************************/

void Memory::DumpMp()
{
	long DumpStr[NOPERLINE],PrevDumpStr[NOPERLINE];
	int i,j,Printed=0;

	for (i=0;i<NOPERLINE;i++)
	{
		PrevDumpStr[i]=(long)i;
	}

	for (i=0;i < ( MEM_SIZE ); i+=NOPERLINE)
	{

		for (j=0; j < NOPERLINE ; j++)
	   	DumpStr[j] = Mp[i+j];

	 	if ( compare(DumpStr,PrevDumpStr) != 1)
	 	{
			if(Printed)	Printed = 0;
	    		showline(i,DumpStr);
	    		printf("\n");
	 	}
	 	else if (!Printed)
	 	{
			showline(i,DumpStr);
		 	printf("*\n");
		 	Printed = 1;
	 	}

	  	copyline(PrevDumpStr,DumpStr);
	}

	printf("\n");
}

bool Memory::getTimeOut()
{
   return timeOut;
}

bool Memory::getStackOverflow()
{
   return stackOverflow;
}

bool Memory::getBoundaryError()
{
   return boundaryError;
}
