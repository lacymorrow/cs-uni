

#include "Headers/Register.h"
#include "Headers/ProcessorStateWord.h"
#include "Headers/FpStatusWord.h"
#include "Headers/IntRegisterFile.h"
#include "Headers/FpRegisterFile.h"
#include "Headers/Memory.h"
#include "Headers/Cpu.h"
#include "Headers/Instruction.h"


Instruction::Instruction(Cpu * c, Memory * m)
{
   cpu = c;
   mem = m;
}

void Instruction::execute()
{ 

}
