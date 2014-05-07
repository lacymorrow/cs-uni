
#ifndef REGISTER
#define REGISTER

class Register
{
	private:
		unsigned int reg;
	public:
		Register();
		void set(unsigned int n);
		unsigned int get();
		unsigned int getBit(unsigned int n);
};

#endif
