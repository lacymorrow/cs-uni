
#include "Headers/Register.h"
#include "Headers/ProcessorStateWord.h"
#include "Headers/FpStatusWord.h"
#include "Headers/IntRegisterFile.h"
#include "Headers/FpRegisterFile.h"
#include "Headers/Memory.h"
#include "Headers/Cpu.h"
#include "Headers/Instruction.h"
#include "Headers/Group12a.h"
#include "Headers/Trap.h"

Trap::Trap(Cpu * c, Memory * m):Group12a(c, m)
{
 
}

void Trap::execute()
{

}
