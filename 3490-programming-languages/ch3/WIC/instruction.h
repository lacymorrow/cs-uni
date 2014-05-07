//
//  instruction.h
//
//
//  Created by Lacy Morrow
//
//

#ifndef INSTRUCTION_H
#define INSTRUCTION_H

#define OPCODE_SIZE 6
#define OPERAND_SIZE 21
#define INSTRUCTION_SIZE 100

void initialize();
int hasOperand(char * opcode);
void insertInstruction(int address,char * opcode,char * operand);
char * fetchOpcode(int address);
char * fetchOperand(int address);
int get(int pc);
int push(int pc);
int add(int pc);
int pop(int pc);
int put(char * key, int value);
void halt();

#endif
