
class Instruction
{
   protected:
      Cpu * cpu;
      Memory * mem;
   public:
      Instruction(Cpu * c, Memory * m);
      virtual void execute();
};
