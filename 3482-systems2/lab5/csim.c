#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <getopt.h>
#include <math.h>
#include "cachelab.h"
// Zachary Wright(wrightzt) & Lacy Morrow(morrowtl)



typedef struct Cache
{
    int numOfSets;
    int numberOfSetIndexBits;
    int associativity;
    int numberOfBlockBits;
    int sizeOfBlock;
    unsigned long int **tags;
} Cache;
int get_bits(int start, int end, unsigned long tag);
void error();
void place_in_set(Cache * cache, unsigned long int tag, int setInt, int * hit, int * miss, int * evictions);
void parse(char * file, Cache * cache, int * hit, int * miss, int * evictions);
void evictOne(Cache * cache, int setInt);

int main(int argc, char * argv[])
{
    Cache cache;
    int i,c,j;
    char file[80];
    while ((c = getopt (argc, argv, "vhs:b:E:t:")) != -1)
     switch (c)
       {
       case 's':
        cache.numberOfSetIndexBits = strtol(optarg, NULL, 10);
        cache.numOfSets = pow(2, cache.numberOfSetIndexBits);
         break;
       case 'b':
         cache.numberOfBlockBits = strtol(optarg, NULL, 10);
         cache.sizeOfBlock = pow(2, cache.numberOfBlockBits);
         break;
       case 'E':
         cache.associativity = strtol(optarg, NULL, 10);
         break;
       case 't':
         strncpy(file, optarg, 80);
       }
    cache.tags = (unsigned long int**) malloc(cache.numberOfSetIndexBits*sizeof(unsigned long int*));
    for(i=0; i<cache.numberOfSetIndexBits; i++)
    {
       cache.tags[i] = (unsigned long int*) malloc (cache.associativity*sizeof(unsigned long int));
    }
    for(i=0; i<cache.numberOfSetIndexBits; i++)
    {
        for(j=0; j<cache.associativity; j++)
        {
            cache.tags[i][j] = -1;
        }
    }

    int hits = 0;
    int misses = 0;
    int evictions = 0;

    parse(file, &cache, &hits, &misses, &evictions);

    // pass to printSummary the number of hits, misses and evictions
    printSummary(hits, misses, evictions);
    return 0;
}

int get_bits(int start, int end, unsigned long tag)
{
    if(start > end)
    {
        error();
    }
    //check for valid range of input
    else if(start>=0 && end < 64)
    {

        //create mask  and shift
        int m = 0x1<<31;
        m = m >> (31-(end-start+1));

        //shift source to important bits
        tag = tag>>start;
        return tag&~m;
    }
    else
    {
        //invalid input
        error();
    }
    return 1;
}
void parse(char * file, Cache * cache, int * hit, int * miss, int * evictions)
{
    char c1;
    unsigned long int int2;
    char string[80];
    FILE * fp = fopen(file, "r");
    while(fgets(string, 80, fp) != NULL)
    {
	    if(string[0] == ' ')
	    {
		sscanf (string, " %c %lx", &c1, &int2);
		printf("%s\n", string);

		int start = cache->associativity * cache->numOfSets;
		int end = start + cache->numberOfSetIndexBits;

		int setIndex = get_bits(start, end, int2);
		place_in_set(cache, int2, setIndex, hit, miss, evictions);
	    }
    }
}

void place_in_set(Cache * cache, unsigned long int tag, int setInt, int * hit, int * miss, int * evictions)
{
    int associativity = cache->associativity;
    int i;
    int wasEntered = 0;

    for(i=0; i<associativity; i++)
    {
        if(cache->tags[setInt][i] == -1 && wasEntered == 0)
        {
            cache->tags[setInt][i] = tag;
            wasEntered = 1;
            *miss += 1;
        }
        else if(cache->tags[setInt][i] == tag && wasEntered == 0)
        {
            wasEntered = 1;
            *hit += 1;
        }
    }

    if(wasEntered == 0)
    {
        *miss += 1;
        *evictions += 1;
        evictOne(cache, setInt);
        cache->tags[setInt][0] = tag;
    }
}

void evictOne(Cache * cache, int setInt)
{
    int associativity = cache->associativity;
    int i;

    for(i = associativity; i > 0; i--)
    {
        cache->tags[setInt][i] = cache->tags[setInt][i-1];
    }
}


void error()
{
    printf("%s", "You have encountered an error.\nUsage: get_bits(start<int 0:63>, end<int 0:63>, <unsigned long>)");
    exit(1);
}
