def details(*l):
	''' takes in a variable amount of arguments. last name required'''
	ln = l[0] if len(l)>0 else False
	fn = l[1] if len(l)>1 else ""
	phone = l[2] if len(l)>2 else ""
	address = l[3] if len(l)>3 else ""
	city = l[4] if len(l)>4 else ""
	state = l[5] if len(l)>5 else ""
	zp = l[6] if len(l)>6 else ""
	return False if ln == False else True
	
def f_to_c_map(f):
	''' returns a list of tuples of farenheight converted to celcius '''
	l = []
	for i in range(f+1):
		l.append((i, f2c(i)))
	return l

def even(n):
	''' returns a list of even numbers ranged 0 to n '''
	r = list(range(0,n,2))
	return r

f2c = lambda x: (((x - 32)*5)/9)
