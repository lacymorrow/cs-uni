typedef struct symbolEntry
{
    char type;
    char name[31];
    struct symbolEntry * next;
} symbolEntry;

symbolEntry * insertSymbol(symbolEntry * first, char * symbolName, char type);
bool update(symbolEntry * entry);
bool getSymbolType(symbolEntry * entry, char symbolName[31], char * type);
void removeSymbol(symbolEntry * entry);
void printSymbols(symbolEntry * first);
