# Lacy Morrow
# Kyle Somers
# Hampton Davis

def calBurn():
	w = raw_input("Enter your weight (in pounds): \n")
	m = raw_input("Enter the number of miles run: \n")
	return .75 * int(w) * int(m)

def minList(l):
	m = l[0]
	for i in l:
		if i < m:
			m = i
	return m

def convertMi(i):
	return str(i)+' miles is equal to '+str(i*1.60934)+' kilometers'

def uFib():
	i = raw_input("Enter a number to view the Fibbonacci value:\n")
	return fib(int(i))

def aFib(i):
	print "Listing:\n"
	return fib(i, True)

def fib(i, all = False):
	s = 0
	c = 1
	n = 1
	while (n <= i):
		t = s
		s = c + s
		c = t
		n = n + 1
		if all == True:
			print str(s) + "\n"
	if all == True:
		return s
	print "Fibonacci number " + str(i) + " is " + str(s)
	return s

def main():
	print str(convertMi(int(raw_input("Enter miles: \n"))))
	uFib()
	aFib(int(raw_input("Count Fibonacci numbers to value: \n")))
	print "Minimum value: " + str(minList([1,2,3,4,5,6,7,8,9,0]))
	print str(calBurn())
if __name__ == "__main__":
    main()
