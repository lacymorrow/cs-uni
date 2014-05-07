
#include "bubbleSort.h"

//use bubbleSort to sort a list of integers
void bubbleSort(int * list, int len)
{
    int i, j;
    for (i = 0; i < len; i++)
    {
        for (j = 0; j < len - i - 1; j++)
        {
            if (list[j] > list[j + 1])
            {
                list[j] = list[j + 1] ^ list[j];
                list[j + 1] = list[j + 1] ^ list[j];
                list[j] = list[j + 1] ^ list[j];
            }
        }
    }
}

