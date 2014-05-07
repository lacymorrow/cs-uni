//
//  table.c
//  
//
//  Created by Lacy Morrow on 9/27/12.
//
//

#include <stdio.h>
#include "table.h"
#include <string.h>
void initializeTable(tableType *Xtable){
    //init table to 0
    Xtable->size = 0;
}
void store(tableType *Xtable, char *key, int val){
    int s = Xtable->size;
    int i=0;
    for(i=0;i<s;i++){
        //check if key is in table
        if(strcmp(Xtable->table[i].key,key) == 0){
            //true - overwrite with new value
            Xtable->table[i].value = val;
            i = -1; //set found flag
            break;
        }
    }
    if(i != -1 && Xtable->size<TABLE_SIZE){
        //false - add key and value
        strncpy(Xtable->table[Xtable->size].key, key,20);
        Xtable->table[Xtable->size].value = val;
        Xtable->size++;
    }
}
int retrieve(tableType *Xtable, char *key){
    int i=0;
    for(i=0;i<Xtable->size;i++){
        //check if key is in table
        if(strcmp(Xtable->table[i].key,key) == 0){
            //found - return value
            return Xtable->table[i].value;
        }
    }
    //not found - error and exit
    printf("%s\n", "Error: element does not exist.");
    return 0;
}
