/*
 *  mywc.c
 *  Created by Lacy Morrow on 12/5/10.
 *	Takes one or more files and adds up their lines, words and bytes
 *
 */


#include <stdio.h>

int readFile(char * filename, int * lines, int * words, int * bytes);

/* 
 *
 * main
 * calls readFile on one or more files and displays line, word and byte counts
 * of each as well as the total of all files
 * Accepts: list of files
 *
 */
int main ( int argc, char * argv[] )
{
    if ( argc < 2 ) /* Error 1 */
    {
        printf( "usage: %s <filename1> <filename2> <filename3> ...\n", argv[0] );
    } else {
		int i;
		char file;
		int tLines,tWords,tBytes;
		tLines = tWords = tBytes = 0;
		int l,w,b;
		int *lines = &l;
		int *words = &w;
		int *bytes = &b;
		for (i = 1; i < argc; i++){
			int success = readFile(argv[i], lines, words, bytes);
			if (success == 0) {
				printf("%s: no such file\n", argv[i]); /* Error 2 */
			} else {
				// add to total
				tLines += l;
				tWords += w;
				tBytes += b;
				printf("%d %d %d %s\n", *lines, *words, *bytes, argv[i]);
			}	
		}
		// if more than one file, display total
		if (argc > 2) {
			printf("%d %d %d Total\n", tLines, tWords, tBytes);
		}
	}

}

/* 
 *
 * readFile
 * counts the lines, words and bytes in a text file
 * Accepts: four pointers for filename, and line, word and byte counts
 * Returns: 1 if successful, 0 otherwise
 *
 */
int readFile(char * filename, int * lines, int * words, int * bytes){
        FILE *file = fopen(filename, "r" );
        /* fopen returns 0, the NULL pointer, on failure */
        if (file == 0 )
        {
			return 0;
        } else {
            int x;
			*lines = *words = *bytes = 0;
			char prev = ' ';
            /* read one character at a time from file, stopping at EOF, which
			 indicates the end of the file.  Note that the idiom of "assign
			 to a variable, check the value" used below works because
			 the assignment statement evaluates to the value assigned. */
            while  ( ( x = fgetc( file ) ) != EOF )
            {
				// counts lines
				if (x == '\n')
					(*lines)++;
				// counts words
				if (((prev == '\t') || (prev == ' ') || (prev == '\n')) && ((x != '\t') && (x != '\n') && (x != ' '))) 
						(*words)++;
				prev = x;
				// counts bytes
				(*bytes)++;
            }
            fclose( file );
			return 1;
        }
}
