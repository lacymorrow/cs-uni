/*
 * instruction.c
 */

#include <stdio.h>
#include <stdlib.h>
#include "instruction.h"
#include "stack.h"
#include "table.h"


typedef struct{
	char opcode[OPCODE_SIZE];
	char operand[OPERAND_SIZE];
} instruction;

typedef struct{
	instruction instructions[INSTRUCTION_SIZE];
	int size;
} instructionTable;

static instructionTable iTable;
tableType jTable;
tableType sTable;
Stack stack;

int pc = 0;

void initialize()
{
    initializeStack(&myStack);
    initializeTable(&myTable);
    iTable.size = 0;
}

int hasOperand(char * opcode)
{
    if(strncmp(opcode, "get", 6) ||
       strncmp(opcode, "put", 6) ||
       strncmp(opcode, "push", 6)||
       strncmp(opcode, "pop", 6) ||
       strncmp(opcode, "halt", 6)||
       strncmp(opcode, "add", 6) ||)
        return 1;
    else
        return 0;
}

void insertInstruction(int address, char * opcode, char * operand)
{
    store(*iTable, *opcode, *operand);
}

char * fetchOpcode(int address)
{
    if(address <= iTable.size && address >= 0))
    {
        return iTable[i].opcode;
    }
    printf("Opcode Address does not exist");
    return 0;
}

char * fetchOperand(int address)
{
    if(address <= iTable.size && address >= 0))
    {
        return iTable[i].operand;
    }
    printf("Operand Address does not exist");
    return 0;
}


int get(int pc)
{
    if(hasOperand(pc) == 1)
    {
        tmpc *char = fetchOperand(pc);
        int tmp;
        printf("");
        scanf("%d", tmp);
        table.store(&myTable, *tmpc, tmp);
    }
    return pc++;
}

int push(char * key)
{
    retrieve(&iTable, key);
    return pc++;
}

int add(int pc){
    int lop = stackpop(&myStack);
    int rop = stackpop(&myStack);
    stackpush(&myStack, lop + rop);
    return pc + 1;
}

int pop(int pc)
{
    char * operand = fetchOperand(pc);
    int var = stackpop(&stack);
    myTable.store(&myTable, operand, var);
    return pc++;
}

int put(char *key, int val)
{
    store(*myTable, key, val);
    pc++;
}

void halt()
{
    
}