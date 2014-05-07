
#include "Headers/Register.h"

Register::Register()
{
	reg = 0;
}

void Register::set(unsigned int n)
{
	reg = n;
}

unsigned int Register::get()
{
	return reg;
}

unsigned int Register::getBit(unsigned int n)
{
	//modify code to return bit n of reg
	return 0;
}  
