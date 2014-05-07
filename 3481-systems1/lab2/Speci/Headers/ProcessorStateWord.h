
#ifndef PROCESSORSTATEWORD_H
#define PROCESSORSTATEWORD_H

class ProcessorStateWord: public Register
{
	public:
		ProcessorStateWord();
		unsigned int getN();
		unsigned int getZ();
		unsigned int getV();
		unsigned int getC();

};

#endif
