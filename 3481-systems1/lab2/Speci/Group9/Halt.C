
#include "Headers/Register.h"
#include "Headers/ProcessorStateWord.h"
#include "Headers/FpStatusWord.h"
#include "Headers/IntRegisterFile.h"
#include "Headers/FpRegisterFile.h"
#include "Headers/Memory.h"
#include "Headers/Cpu.h"
#include "Headers/Instruction.h"
#include "Headers/Group9.h"
#include "Headers/Halt.h"

Halt::Halt(Cpu * c, Memory * m):Group9(c, m)
{
 
}

void Halt::execute()
{

}
