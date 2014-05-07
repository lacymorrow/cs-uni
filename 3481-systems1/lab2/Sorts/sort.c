
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

#include "bubbleSort.h"
#include "mergeSort.h"
#include "quickSort.h"
#include "types.h"

/* functions that are local to this file */
static bool checkInput(char * buffer, int bufsize);
static void printList(int * list, int length);
static int getCount();
static void fillList(int * list, int count);
static void sort(int * list, int count);

#define BUFFERSIZE 8

int main()
{
    int count, i;
    int * list;
    char buffer[BUFFERSIZE];
    char c;
 
    count = getCount();
    list = malloc(sizeof(int) * count);
    fillList(list, count);
    sort(list, count);
    printf("\nDo you want to see the sorted list (y or n)? ");
    c = getc(stdin);
    printf("\n");
    if (c == 'Y' || c == 'y')
        printList(list, count);
}

void sort(int * list, int count)
{
    bool goodInput;
    int which;
    char buffer[BUFFERSIZE];
    do
    {
        printf("\nWhich sort technique do you want to use?\n");
        printf("1. Bubblesort\n");
        printf("2. Mergesort\n");
        printf("3. Quicksort\n");
        printf("Choose 1, 2, or 3: ");
        fgets(buffer, sizeof(buffer), stdin);
        goodInput = checkInput(buffer, BUFFERSIZE);
        if (goodInput) which = atoi(buffer);
        if (goodInput && (which == 1 || which == 2 || which == 3)) 
            break;
        else 
            printf("Invalid input.\n\n");
    } while (1);
    clock_t begin, end;
    double timeSpent;
    if (which == 1)
    {
        begin = clock();
        bubbleSort(list,count);
        end = clock();
    } else if (which == 2)
    {
        begin = clock();
        mergeSort(list, count);
        end = clock();
    } else
    {
        begin = clock();
        quickSort(list, count);
        end = clock();
    }
    timeSpent = (double)(end - begin)/ CLOCKS_PER_SEC;
    printf("The sort took %f seconds.\n", timeSpent);
}    

void fillList(int * list, int count)
{
    int i;
    unsigned int iseed = (unsigned int)time(NULL);
    srand (iseed);
    for (i = 0; i < count; i++)
        list[i] = rand() % 10000;

}

int getCount()
{
    int count;
    bool goodInput;
    char buffer[BUFFERSIZE];
    do 
    {
        printf("How many random numbers do you want generated for sorting?\n");
        printf("Enter a number between 1 and 500000: ");
        fgets(buffer, sizeof(buffer), stdin);
        goodInput = checkInput(buffer, BUFFERSIZE);
        if (goodInput) count = atoi(buffer);
        if (goodInput && (count >= 1 && count <= 500000))
        {
           return count;
        } 
        else printf("Invalid input.\n\n");
    }
    while (1);
}

void printList(int * list, int length)
{
    int i;
    for (i = 0; i < length; i++) 
    {
        printf("%5d ", list[i]);
        if (((i + 1) % 10) == 0) printf("\n");
    }
    printf("\n");
}

//check to make sure each character in buffer up to the
//newline is a digit.  buffer[0] could be a '-'
bool checkInput(char * buffer, int bufsize)
{
    char c;
    int i = 0;
    int len = strlen(buffer);
    if (buffer[len - 1] != '\n')
    {
        //buffer not long enough to hold characters entered
        do
        {
            c = fgetc(stdin);
        } while (c != '\n');
        return FALSE;
    }

    int minEndpoint = 1;
    if (buffer[0] == '-') { i++; minEndpoint++; }
    while (i < bufsize)
    {
        if (!isdigit(buffer[i]) && (buffer[i] != '\n')) 
           return FALSE;  //invalid character
        else if ((buffer[i] == '\n') && (i < minEndpoint)) //no data entered
           return FALSE;
        else if (buffer[i] == '\n')  //all is well
           return TRUE;
        i++;
    }
}

