#include <stdlib.h>
#include <stdio.h>
#include "transpose.h"
#include "matrix.h"

/* Create matrix of specified length */
matrix_ptr new_matrix(long int len)
{
    int i;
    /* Allocate header structure */
    matrix_ptr result = (matrix_ptr) malloc(sizeof(matrix_rec));
    if (!result)
        return NULL;  /* Couldn't allocate storage */
    result->len = len;
    /* $end matrix */
    /* Allocate array */
    if (len > 0) {
        result->data = (data_t *)calloc(len * len, sizeof(data_t *));
        if (!result->data) return NULL; /* Couldn't allocate storage */
    } else
        result->data = NULL;
    return result;
}

/* initialize elements of the matrix */
void init_matrix(matrix_ptr m)
{
   int i, j;
   for (i = 0; i < m->len; i++)
      for (j = 0; j < m->len; j++)
         set_matrix_element(m, i, j, i);
}

/*
 *  Set matrix element. Assumes row, col are within bounds.
 *    
*/
void set_matrix_element(matrix_ptr m, int row, int col, data_t val)
{
    int index = row * m->len + col;
    m->data[index] = val;
}

/*
 *  Get matrix element. Assumes row, col are within bounds.
 *    
*/
data_t get_matrix_element(matrix_ptr m, int row, int col)
{
    int index = row * m->len + col;
    return m->data[index];
}


/*  Print the message and the matrix elements. */
void print_matrix(matrix_ptr m, char * msg)
{
   int i, j;
   printf("%s\n", msg);
   for (i = 0; i < m->len; i++)
   {
      for (j = 0; j < m->len; j++)
         printf("%d ", get_matrix_element(m, i, j));
      printf("\n");
   }
   printf("\n");
}

