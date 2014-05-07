
#include "Headers/Register.h"
#include "Headers/ProcessorStateWord.h"
#include "Headers/FpStatusWord.h"
#include "Headers/IntRegisterFile.h"
#include "Headers/FpRegisterFile.h"
#include "Headers/Memory.h"
#include "Headers/Cpu.h"
#include "Headers/Instruction.h"
#include "Headers/Group9.h"

Group9::Group9(Cpu * c, Memory * m):Instruction(c, m)
{
 
}
