#
# Makefile for UNIX lab
# 
CC = gcc
CFLAGS = -g -Wall -Werror

all: resolve
	# Created resolve

resolve: resolve.c symbolList.c
	$(CC) $(CFLAGS) -o resolve resolve.c symbolList.c -lm 

#
# Clean the src dirctory
#
clean:
	rm -rf *.o
	rm -f resolve