#include "quickSort.h"

static void swap(int *x,int *y);
static int choose_pivot(int i,int j );
static void quicksort(int list[],int m,int n);

void quickSort(int * list, int count)
{
    quicksort(list, 0, count - 1);
}

void swap(int *x,int *y)
{
   int tmp = *x;
   *x = *y;
   *y = tmp;
}
 
int choose_pivot(int i,int j )
{
   return((i+j) /2);
}
 
void quicksort(int list[],int m,int n)
{
   int key,i,j,k;
   if( m < n)
   {
      k = choose_pivot(m,n);
      swap(&list[m],&list[k]);
      key = list[m];
      i = m+1;
      j = n;
      while(i <= j)
      {
         while((i <= n) && (list[i] <= key))
                i++;
         while((j >= m) && (list[j] > key))
                j--;
         if( i < j)
                swap(&list[i],&list[j]);
      }
      // swap two elements
      swap(&list[m],&list[j]);
      // recursively sort the lesser list
      quicksort(list,m,j-1);
      quicksort(list,j+1,n);
   }
}
