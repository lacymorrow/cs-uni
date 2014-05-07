#include "Headers/Register.h"
#include "Headers/ProcessorStateWord.h"

ProcessorStateWord::ProcessorStateWord()
{

}

unsigned int ProcessorStateWord::getN()
{
	return getBit(3);
}

unsigned int ProcessorStateWord::getZ()
{
	return getBit(2);
}

unsigned int ProcessorStateWord::getV()
{
	return getBit(1);
}

unsigned int ProcessorStateWord::getC()
{
	return getBit(0);
}
