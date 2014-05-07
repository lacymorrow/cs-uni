/* 
 * Name: Lacy Morrow & Zachary Wright
 * Description: This program performs the resolution task of a linker.
 *              It takes as input a list of .o files and archive files
 *              and keeps track of undefined and defined symbols.  All
 *              symbols in a .o file are added to one of the two lists.
 *              Archived object files are handled a little differently.
 *              If there is a symbol that is currently undefined, but defined
 *              in a object file within an archive, then all symbols in that
 *              archived object file are added to one of the two lists; 
 *              otherwise, no symbols from that archive member are added.  
 *              Members of an archive are visited repeatedly until there are 
 *              no changes in the lists of defined and undefined symbols.
 *
 *              If at some point there is an attempt to add a second strong
 *              symbol to the defined symbols list, then an error message is
 *              displayed indicating the multiple definition.
 *
 *              At the end of the process, the program looks to make sure that
 *              the main function is defined and if not, an error message is
 *              displayed.  Next, the program prints out the entries of the 
 *              undefined symbols list with an error message for each one.
 */

#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "bool.h"
#include "symbolList.h"

symbolEntry * defined = NULL;
symbolEntry * undefined = NULL;
static bool isArchive(char * filename);
static bool isObjectFile(char * filename);
static void handleObjectFile(char * filename);
static void handleArchive(char * filename);
void displayMessageAndExit(char * msg);
bool changed = false;

int main(int argc, char * argv[])
{
    int i, istat; 
    struct stat stFileInfo;

    if (argc <= 1)
    {
       printf("resolve: no input files\n");
       exit(1);
    }
    undefined = insertSymbol(undefined, "main", *"U");
    for (i = 1; i < argc; i++)
    {
        istat = stat(argv[i], &stFileInfo);
        //if istat is 0 then file exists
        if (istat == 0)
        {
            if (!isObjectFile(argv[i]) && !isArchive(argv[i]))
            {
                printf("%s: file not recognized\n", argv[i]);
            } else {
                if (isArchive(argv[i])) handleArchive(argv[i]);
                if (isObjectFile(argv[i])) handleObjectFile(argv[i]);
            }
        } else {
            printf("%s: file not found\n", argv[i]);
        }
    }
/* UNCOMMENTING WILL PASS SOME BUT FAIL OTHERS
    symbolEntry * node = undefined;
    while(node != NULL)
    {
        printf("%s", ": undefined reference to ");
        printf("%s\n", node->name);
        node = node->next;
    }
*/
    printSymbols(defined);
    return 1;
}

void handleObjectFile(char * filename)
{
    FILE *fp;
    char buffer[80];
    char fn[512] = "nm ";
    symbolEntry * node = NULL;
    fp = popen(strncat(fn, filename, 512), "r");
    if (fp == NULL) displayMessageAndExit("popen failed\n");
    while (fgets(buffer, sizeof(buffer), fp))
    {		
		int value = 0;
        char type[2], name[32];
        
        if(isdigit(buffer[0]))
        {
                sscanf(buffer, "%d %1s %s", &value, type, name);
        } else {
                sscanf(buffer, "%1s %s", type, name);
        }
        if (strstr(type, "U") != NULL) 
        {
        	if(!getSymbolType(node, name, type))
        	{
        		undefined = insertSymbol(undefined, name, *type);
        	}
        } else if (strstr(type, "C") != NULL) 
        {
        	if(!getSymbolType(node, name, type) && !getSymbolType(node, name, "T") && !getSymbolType(node, name, "D"))
        	{
        		defined = insertSymbol(defined, name, *type);
        	}
        } else if (strstr(type, "T") != NULL || strstr(type, "D") != NULL) 
        {

        	if(getSymbolType(node, name, "C") != false)
        	{
        		update(node);
        	} else if (getSymbolType(node, name, "D") != false || getSymbolType(node, name, "T") != false)
        	{
        		strncpy(fn, ": multiple definition of ", 512);
        		strncpy(fn, strncat(fn, name, 512), 512);
        		displayMessageAndExit(strncat(fn, "\0", 512));
        	} else 
        	{
        		defined = insertSymbol(defined, name, *type);
        	}
        } else 
        {
        	strncpy(fn, name, 512);
        	strncpy(fn, strncat(fn, ".0\0", 512), 512);
        	defined = insertSymbol(defined, fn, *type);
        }
    }
    pclose(fp);

}


void handleArchive(char * filename)
{
    //handle an archive file
    char fn[512] = "mkdir tmp; cd tmp; ar -x ../";
    system(strncat(fn, filename, 512));
    FILE *in;
    char *buffer = NULL;
    changed = false;
    do
    {
        changed = false;
        if(!(in = popen("ls tmp", "r"))){
            exit(1);
        }
        
        while(fgets(buffer, sizeof(buffer), in) != NULL){
            handleObjectFile(buffer);
        }
        pclose(in);

    } while (changed == true);
    system("rm -rf tmp");
}

/* 
 * function: isArchive
 * description: This function takes as input a c-string and returns
 *              true if the c-string ends with a .a extension.
 * input: filename 
 * returns: 1 or 0
 */
bool isArchive(char * filename)
{
    int len = strlen(filename);
    if (len < 3) 
        return false;
    if (filename[len - 2] != '.')
        return false;
    if (filename[len-1] != 'a')
        return false;
    return true;
}

/* 
 * function: isObjectFile
 * description: This function takes as input a c-string and returns
 *              true if the c-string ends with a .o extension.
 * input: filename 
 * returns: 1 or 0
 */
bool isObjectFile(char * filename)
{
    int len = strlen(filename);
    if (len < 3) 
        return false;
    if (filename[len - 2] != '.')
        return false;
    if (filename[len-1] != 'o')
        return false;
    return true;
}

void displayMessageAndExit(char * msg)
{
  printSymbols(defined);
  printf("%s\n",msg);
  exit(0);
}






