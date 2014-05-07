
#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

void initializeStack(Stack * s)
{
  /* assuming that s points to valid Stack memory allocation */
  s->size = 0;
  /* "clearing" array cells is redundant */
}

void stackPush(Stack *s, int x)
{
  if (s->size == STACK_SIZE) {
    /* writes to stdout by default */
    printf("Writing into full stack is illegal. Bye.\n");
    abort();
  }
  else
    {
      s->items[s->size++] = x;
    }
}

int stackPop(Stack *s)
{
  int index;
  int value;
  if (s->size == 0) {
    /* writes to stdout by default */
    printf("Popping from empty stack is illegal. Bye.\n");
    abort();
  }
  else
    {
      index = s->size;
      value = s->items[index-1];
      s->size = index-1;
      return value;

      /*      return s->items[--s->size];*/
      /* s->size = s->size - 1;
	 return s->items[s->size];*/
    }
}

