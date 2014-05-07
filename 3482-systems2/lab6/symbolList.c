#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "bool.h"
#include "symbolList.h"

extern symbolEntry * defined;
extern symbolEntry * undefined;

symbolEntry * insertSymbol(symbolEntry * first, char * symbolName, char type)
{
    symbolEntry * node;
    symbolEntry * entry = malloc(sizeof(symbolEntry));
    entry->type = type;
    entry->next = NULL;
    strcpy(entry->name, symbolName);
    if (first != NULL)
    {
        node = first;
        while(node->next != NULL)
        {
            node = node->next;
        }
        node->next = entry;
    } else {
        first = entry;
    }
    return first;
}

bool update(symbolEntry * entry)
{
    bool ret = false;
    symbolEntry * node = entry;
    if(getSymbolType(defined, node->name, "C"))
    {
        node->type = 'D';
        ret = true;
    }
    return ret;
}

bool getSymbolType(symbolEntry * entry, char * symbolName, char * t)
{
    bool ret = false;
    char type;
    symbolEntry * node = defined;
    strcpy(&type, t);
    if(node == NULL)
    {
        return false;
    }
    while(node->next != NULL)
    {
        if(strcmp(node->name, symbolName) == 0 && strcmp(&node->type, &type) == 0)
        {
            ret = true;
            entry = node;
        }
        node = node->next;
    }

    return ret;
}

void removeSymbol(symbolEntry * entry)
{
    symbolEntry * node = defined;

    while(node != NULL)
    {
        if(node->name == entry->name)
        {
            node->next = node->next->next;
            break;
        } else {
            node = node->next;
        }
    }
}

void printSymbols(symbolEntry * first)
{
    symbolEntry * node = first;
    printf("%s", "Defined Symbol Table\n-----------------------\n");
    while(node != NULL)
    {
        printf("%-32.32s %c\n", node->name, node->type);
        node = node->next;
    }
}

/*
void main(int argc, char * argv[])
{
    defined = NULL;
    defined = insertSymbol(defined, "Hello", 'C');
    defined = insertSymbol(defined, "Helo", 'U');
    defined = insertSymbol(defined, "sadha", 'T');
    defined = insertSymbol(defined, "asgatj", 'D');
    removeSymbol(defined->next);

    printSymbols(defined);
}
*/