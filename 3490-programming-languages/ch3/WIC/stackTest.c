/*
 * stackTest is a TDD unit test for the stack
 * @author Dr.Fenwick
 * @version Spring 2012
 */
#include <stdio.h>
#include "stack.h"

int main(void) 
{
    Stack myStack;
    int tmp;

    printf("initializing stack...\n");
    initializeStack(&myStack);
    printf("pushing onto stack...\n");
    stackPush(&myStack, 3);
    printf("pushing onto stack...\n");
    stackPush(&myStack, 99);
    printf("pushing onto stack...\n");
    stackPush(&myStack, 79);

    printf("popping from stack...\n");
    tmp = stackPop(&myStack); 
    if (tmp != 79)
        printf("You suck at writing a stack\n");
    printf("popping from stack...\n");
    tmp = stackPop(&myStack); 
    if (tmp != 99)
        printf("You suck at writing a stack\n");
    printf("popping from stack...\n");
    tmp = stackPop(&myStack); 
    if (tmp != 3)
        printf("You suck at writing a stack\n");
        
    /* test popping an empty stack????? */
    /* spec says it writes to stderr and aborts */

    /* test pushing into a full stack ????? */
    /* spec says it writes to stderr and aborts */

    printf("All tests passed!\n");
    return 0;
}
