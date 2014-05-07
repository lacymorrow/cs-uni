//
//  table.h
//  
//
//  Created by Lacy Morrow on 9/27/12.
//
//

#ifndef _table_h
#define _table_h

#define TABLE_SIZE 20 //20 elements maximum in the table.
#define KEY_SIZE 20 //20 characters maximum for the key.

typedef struct{
	char key[KEY_SIZE];
	int value;
} tableEntry;

typedef struct{
	tableEntry table[TABLE_SIZE];
	int size;
} tableType;

//Function prototypes.
void initializeTable(tableType *Xtable);
void store(tableType *Xtable, char *key, int val);
int retrieve(tableType *Xtable, char *key);

#endif
