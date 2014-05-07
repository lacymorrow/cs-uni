unsigned int getBits(int low, int high, unsigned int source);
unsigned int setBits(int low, int high, unsigned int source);
unsigned int clearBits(int low, int high, unsigned int source);
unsigned int assignOneBit(int bitNumber, int bitValue, unsigned int source);
unsigned char getByteNumber(int byteNo, unsigned int source);
unsigned int putByteNumber(int byteNo, unsigned char byteValue, 
                           unsigned int source);
unsigned int buildWord(unsigned char byte0, unsigned char byte1, 
                       unsigned char byte2, unsigned char byte3);
bool isNegative(unsigned int source);
void expandBits(unsigned int source, char bits[36]);
void clearBuffer(char * buff, int size);
