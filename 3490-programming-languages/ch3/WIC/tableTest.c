//
//  tableTest.c
//  
//
//  Created by Lacy Morrow on 9/27/12.
//
//
#include <stdio.h>
#include "table.h"

int main(void)
{
    tableType table;
    int tmp;
    char * key; 
    printf("initializing table...\n");
    initializeTable(&table);
    printf("storing to table...\n");
    key="key1";
    store(&table,key,3);
    printf("storing to table...\n");
    key = "key2";
    store(&table,key,99);
    printf("storing to table...\n");
    key = "key3";
    store(&table,key,79);
    
    printf("retrieving from table...\n");
    key = "key1";
    tmp = retrieve(&table, key);
    if (tmp != 3)
        printf("You suck at writing a table\n");
    store(&table,key,13);
    tmp = retrieve(&table, key);
    if (tmp != 13)
        printf("You suck at writing a table\n");
    printf("retrieving from table...\n");
    key = "key2";
    tmp = retrieve(&table, key);
    if (tmp != 99)
        printf("You suck at writing a table\n");
    printf("retrieving from table...\n");
    key = "key3";
    tmp = retrieve(&table, key);
    if (tmp != 79)
        printf("You suck at writing a table\n");
    printf("All tests passed!\n");
    return 0;
}
