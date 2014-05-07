/**
   The wikipedia array implementation of a stack.

   @author Dr. Fenwick
   @version Fall 2012
*/

#ifndef STACK_H_
#define STACK_H_

#define STACK_SIZE 20 //20 elements maximum in the stack.

typedef struct{
	int size;
	int items[STACK_SIZE];
} Stack;

//Function prototypes.
void initializeStack(Stack * s);
void stackPush(Stack *, int x);
int stackPop(Stack *);

#endif
