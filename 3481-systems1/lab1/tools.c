#include <stdio.h>
#include "bool.h"
#include "tools.h"

/* 
   Replace the return 0 with the code to perform the required function.
   Do not change the function prototypes.
   Be sure to check for errors in input. 
   Document EACH function with a function header (description, parameters,
   return).
*/


/*
 * getBits
 * Takes in two integers and a source to specify a range, and 
 * returns the bits in that range of the source.
 * 
 * Invalid: returns 0
 */
unsigned int getBits(int low, int high, unsigned int source)
{
  //check for valid range of input
  if(low>=0 && high < 32){

    //create mask  and shift
    int m = 0x1<<31;
    m = m >> (31-(high-low+1));

    //shift source to important bits
    source = source>>low;
    return source&~m;
  } else {
    //invalid input
    return 0;
  }
} 

/*
 * setBits
 * Takes in two integers and a source to specify a range, and
 * sets the bits in that range in the source to 1.
 *
 * Invalid: returns source
 */
unsigned int setBits(int low, int high, unsigned int source)
{
  //check valid input
  if (low<0 || high >31 || low>high){ return source; }
  
  //get range
  int r = high-low+1;

  //init mask
  int m = 0;
  //counter i
  int i;

  //for number in range
  for(i=0;i<r;i++){
    //shift mask 1 bit left
    m=m<<1;
    //increment mask (set lowest bit to 1)
    m++;
  }
  //shift mask to specific place
  m=m<<low; 
  return source|m;
}


/*
 * clearBits
 * Takes in two integers and a source to specify a range, and
 * set the bits in that range of the source to 0.
 *
 * Invalid: returns source
 */
unsigned int clearBits(int low, int high, unsigned int source)
{
 //check valid input
  if (low<0 || high >31 || low>high){ return source; }

  //get range
  int r = high-low+1;

  //init mask
  int m = 0;
  //counter i
  int i;

  //for number in range
  for(i=0;i<r;i++){
    //shift mask 1 bit left
    m=m<<1;
    //increment mask (set lowest bit to 1)
    m++;
  }
  //shift mask to specific place
  m=m<<low;
  //flip mask
  m=~m;
  return source&m;
}


/*
 * assignOneBit
 * Takes in a bit number to set, a value, and a source. Sets the
 * bit number in the source to the value provided.
 *
 * Invalid: returns source
 */
unsigned int assignOneBit(int bitNumber, int bitValue, unsigned int source)
{
  //check valid input
  if(bitNumber>31 || bitNumber<0 || bitValue<0||bitValue>1){ return source; }
  //init mask to 1
  int m = 1;
  //shift 1 bit to bitNumber position
  m=m<<bitNumber;
  //depending on bit value, set bitNumber and return
  if(bitValue == 0){
    return source&~m;
  } else {
    return source|m;
  }
}


/*
 * getByteNumber
 * Takes in a byte number and source and returns the value at that byte.
 *
 * Invalid: returns 0
 */
unsigned char getByteNumber(int byteNo, unsigned int source)
{
  //check valid input
  if(byteNo<0 ||byteNo>3){ return 0; }
  
  //shift to source byte
  source >>=((byteNo)*8);
  //AND with 0xFF to output source
  return source&0xFF;
}


/*
 * putByteNumber
 * Takes in a byte number to set, a value, and a source. Sets the
 * byte number in the source to the char value provided.
 *
 * Invalid: returns source
 */
unsigned int putByteNumber(int byteNo, unsigned char byteValue, 
                           unsigned int source)
{
  if(byteNo<0 || byteNo>3){ return source; }
  int m=0;
  int i;
  for(i=0;i<8;i++){
    m<<=1;
    m++;
  }
  m<<=(byteNo*8);
  int b = (int)byteValue;
  b<<=(byteNo*8);
  source =source& ~m;
  return source|b;
}


/*
 * buildWord
 * Takes in four bytes. Returns the bytes combined as one int value
 *
 */
unsigned int buildWord(unsigned char byte0, unsigned char byte1, 
                       unsigned char byte2, unsigned char byte3)
{
    int b0 = byte0;
    int b1 = byte1;
    int b2 = byte2;
    int b3 = byte3;
    b3<<=24;
    b2<<=16;
    b1<<=8;
    return b0|b1|b2|b3;
}


/*
 * isNegative
 * Takes in source, returns positive value if source is negative
 *
 */
bool isNegative(unsigned int source)
{
    return (source>>31);
}


/*
 * expandBits
 * Takes in an array of chars and a source. Copies the source bits into
 * the char array in a string-like format
 *
 */
void expandBits(unsigned int source, char bits[36])
{
  //counter i
  int i=0;
    for(i=34;i>=0;i--){
    if(i==8|i==17|i==26){
      bits[i] = ' ';
    } else {
      if((source&1)==1){
        bits[i] = '1';
      } else {
        bits[i] = '0';
      }
      source>>=1;
    }
  }
  bits[35] = 0;
}


/*
 * clearBuffer
 * Takes in a char array and size and sets all indices to null
 *
 * Invalid: returns source
 */
void clearBuffer(char * buff, int size)
{
  int i;
  for(i=0;i<size;i++){
    buff[i] = 0;
  }
}

