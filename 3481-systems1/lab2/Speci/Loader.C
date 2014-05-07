
#include "Headers/Register.h"
#include "Headers/ProcessorStateWord.h"
#include "Headers/FpStatusWord.h"
#include "Headers/IntRegisterFile.h"
#include "Headers/FpRegisterFile.h"
#include "Headers/Memory.h"
#include "Headers/Cpu.h"
#include "Headers/Loader.h"

Loader::Loader(Cpu * c, Memory * m)
{
   //the loader will need to access Memory and Cpu so provide
   //the loader with pointers to these
   cpu = c;
   mem = m;
}
