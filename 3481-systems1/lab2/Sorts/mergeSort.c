#include <stdlib.h>
#include "mergeSort.h"

static void mSort(int numbers[], int temp[], int left, int right);
static void merge(int numbers[], int temp[], int left, int mid, int right);

void mergeSort(int numbers[], int size)
{
  int * temp = malloc(sizeof(int) * size);
  mSort(numbers, temp, 0, size - 1);
}
 
void mSort(int numbers[], int temp[], int left, int right)
{
  int mid;
 
  if (right > left)
  {
    mid = (right + left) / 2;
    mSort(numbers, temp, left, mid);
    mSort(numbers, temp, mid+1, right);
 
    merge(numbers, temp, left, mid+1, right);
  }
}
 
void merge(int numbers[], int temp[], int left, int mid, int right)
{
  int i, leftEnd, numElements, tmpPos;
 
  leftEnd = mid - 1;
  tmpPos = left;
  numElements = right - left + 1;
 
  while ((left <= leftEnd) && (mid <= right))
  {
    if (numbers[left] <= numbers[mid])
    {
      temp[tmpPos] = numbers[left];
      tmpPos = tmpPos + 1;
      left = left +1;
    }
    else
    {
      temp[tmpPos] = numbers[mid];
      tmpPos = tmpPos + 1;
      mid = mid + 1;
    }
  }
 
  while (left <= leftEnd)
  {
    temp[tmpPos] = numbers[left];
    left = left + 1;
    tmpPos = tmpPos + 1;
  }
  while (mid <= right)
  {
    temp[tmpPos] = numbers[mid];
    mid = mid + 1;
    tmpPos = tmpPos + 1;
  }
 
  for (i=0; i <= numElements; i++)
  {
    numbers[right] = temp[right];
    right = right - 1;
  }
}

