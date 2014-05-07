
#ifndef LOADER_H
#define LOADER_H

class Loader
{
   private:
      Cpu * cpu;
      Memory * mem;
   public:
      Loader(Cpu *, Memory *);
};

#endif

