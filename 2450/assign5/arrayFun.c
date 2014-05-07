#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#define SIZE 20
#define NUMMAX 9

/*
 * Programmer:
 * Userid:
 * Description: This program randomly generates an array and calls functions
 *              to sort the array, count the number of occurrences of each
 *              value in the array, reverse the contents of the array, and 
 *              find the mean, mode, and median.
 */

//This is the prototype for the initialize function.  You'll need
//to add prototypes for each of your array functions.
void initialize(int numbers[], int size, int maxnum);
void print(int numbers[], int size);
void countNumbers(int numbers[], int size1, int numberCount[], int size2);
void reverseNumbers(int numbers[], int size);
void sortNumbers(int numbers[], int size);
float averageNumbers(int numbers[], int size);
float medianNumbers(int numbers[], int size);
void modeNumbers(int numbers[], int size, int modes[], int numberCount[]);

int main()
{
    int numbers[SIZE];  
    int numbersCount[NUMMAX + 1];
    int modes[SIZE];
    int i;
    float average, median;

    initialize(numbers, SIZE, NUMMAX);
    printf("The original list: \n");

    print(numbers, SIZE);

    countNumbers(numbers, SIZE, numbersCount, NUMMAX + 1);
    printf("The number of entries of each value: \n");
    for (i = 0; i < NUMMAX + 1; i++) printf("%2d ", i);
    printf("\n");
    for (i = 0; i < NUMMAX + 1; i++) printf("---");
    printf("\n ");
    print(numbersCount, NUMMAX + 1);
	
    reverseNumbers(numbers, SIZE);
    printf("The reverse of the list: \n");
    print(numbers, SIZE);

    sortNumbers(numbers, SIZE);
    printf("The sort of the list: \n");
    print(numbers, SIZE);
	
    printf("The average of the list: ");
    average = averageNumbers(numbers, SIZE);
    printf("%.2f\n", average); 
	
    printf("The median of the list: ");
    median = medianNumbers(numbers, SIZE);
    printf("%.2f\n", median); 

    modeNumbers(numbers, SIZE, modes, numbersCount);
    if (modes[0] == -1)
        printf("The list has no mode.\n");
    else
    {
        printf("The modes in the list are: ");
        for (i = 0; modes[i] != -1; i++)
            printf("%2d ", modes[i]);
        printf("\n");
    }
}


/*
 * Function: print
 * Description: print takes as input an array of integers and the number of elements and 
 * prints out the elements of that array (all on one line)
 * Param: numbers - the array to be initialized
 * Param: size - the number of elements in the array
 * Returns: none
 */
void print(int numbers[], int size){
	int i;
	for (i = 0; i < size; i++)
	{
		printf("%d ",numbers[i]);
	}
	printf("\n");
}
/*
 * Function: countNumbers
 * Description: takes as input two arrays and the sizes of arrays. The first array contains 
 * integer values in the range of 0 to size2 - 1. The second array is set tothe count 
 * of the number of occurrences of each element in the first array. For example, numbers 
 * array contains 3 occurrences of the number 4, then numberCount[4] should be set to 3.
 * Param: numbers - the array to be initialized
 * Param: size1 - the number of elements in the first array
 * Param: numberCount - the second array
 * Param: size2 - value range 0 to size2-1
 * Returns: none
 */
void countNumbers(int numbers[], int size1, int numberCount[], int size2){
	int i;
	for (i = 0; i < size1; i++) {
		if (numbers[i]<size2) {
			numberCount[numbers[i]]++;
		}
	}
}

/*
 * Function: reverseNumbers
 * Description: takes as input an array of integer values and the number of elements in that 
 * array and modifies the array so that it contains the same numbers but in reverse order
 * Param: numbers - the array to be initialized
 * Param: size - size of the array
 * Returns: none
 */
void reverseNumbers(int numbers[], int size){
	int i;
	size--;
	for (i = 0; i < size/2; i++)
	{
		int a = numbers[i];
		numbers[i] = numbers[size-i];
		numbers[size-i] = a;
	}
}

/*
 * Function: sortNumbers
 * Description: takes as input an array of integer values and the number of elements in that 
 * array and modifies the array so that it contains the same numbers in sorted order (you 
 * pick the sort technique)
 * Param: numbers - the array to be initialized
 * Param: size - size of the array
 * Returns: none
 */
void sortNumbers(int numbers[], int size){
	int i;
	for (i=0; i < size; i++)
	{
		int a, b = numbers[i];
		
		for (a = i - 1; a >= 0; a--)
		{
			if (numbers[a] <= b) break;
			numbers[a + 1] = numbers[a];
		}
		numbers[a + 1] = b;	
	}
}

/*
 * Function: averageNumbers
 * Description: takes as input an array of integer values and the number of elements in that 
 * array and returns the average of the numbers in the array
 * Param: numbers - the array to be initialized
 * Param: size - size of the array
 * Returns: average
 */
float averageNumbers(int numbers[], int size){
	double a;
	int i;
	for (i = 0; i < size; i++)
	{
		a += numbers[i];
	}
	return a/size;
}

/*
 * Function: medianNumbers
 * Description: takes as input an array of numbers and the number of elements in that array 
 * and returns the median of the array. Recall that the median is the number in the middle of 
 * the list of numbers in sorted order. If the number of elements is even then the median is 
 * the sum of the two middle elements divided by 2.
 * Param: numbers - the array to be initialized
 * Param: size - size of the array
 * Returns: median
 */
float medianNumbers(int numbers[], int size){
	sortNumbers(numbers, size);
	if (size % 2) {
		int a = size/2-.5;
		
		return numbers[a];
	} else {
		return numbers[size/2-1];
	}
}

/*
 takes as input an array of integers, the number of elements in that array, and an array to be initialized to the modes of the first array. Recall that the modes of a list of numbers are those numbers that occur the most frequently in the list. Each mode appears the same number of times, which is some number greater than 1. For example, if the list of numbers is {2, 3, 3, 1, 1, 5} then the modes are {3, 1}. If no number appears more than once in the list, then the list has no mode. The modes array will be initialized to the modes in the list and followed by a -1. Using the same example as above, the modes array would be initialized to {1, 3, -1} or {3, 1, -1}. If the array of numbers does not have a mode then the modes array would be initialized to {-1}. The size of the modes array is the same size as the numbers array; however, elements beyond the -1 are not initialized by this function. You can use your countNumbers function to help with this; call that function from within this one.
 */

/*
 * Function: modeNumbers
 * Description: takes as input an array of integers, the number of elements in that array, 
 * and an array to be initialized to the modes of the first array.
 * Param: numbers - the array to be initialized
 * Param: size - size of the array
 * Param: modes - an array to be initialized to the modes of the first array.
 * Returns: none
 */
void modeNumbers(int numbers[], int size, int modes[], int numberCount[]){
	int a = 0;
	int max = 0;
	int i;
	for (i = 0; i < NUMMAX+1; i++) {
		if (numberCount[i] > max) {
			max = numberCount[i];
		}
	}	
	for (i = 0; i < NUMMAX+1; i++) {
		if (numberCount[i] == max) {
			modes[a] = i;
			a++;
		}
	}
	modes[a] = -1;	
}


/*
 * Function: initialize
 * Description: initializes the contents of an array with randomly generated
 *              numbers in the range 0 to nummax
 * Param: numbers - the array to be initialized
 * Param: size - the number of elements in the array
 * Param: nummax - the maximum value to be stored in the array
 * Returns: none
 */

void initialize(int numbers[], int size, int nummax)
{
    int i;
    //use the time function to initialize the seed of the
    //used by the random number generator
    srandom((int) time(NULL)); 
    for (i = 0; i < size; i++)
    {
        numbers[i] = random() % (nummax + 1);
    }
}

