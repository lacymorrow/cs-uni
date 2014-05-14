def sum(l):
	s = 0
	for i in range(len(l)):
		s += l[i];
	return s

def mean(l):
	return sum(l)/len(l)

def median(l):
	l.sort()
	if not len(l) % 2:
		return (l[int(len(l) / 2)] + l[int(len(l) / 2) - 1]) / 2
	return l[int(len(l) / 2)]

def stddev(l):
	s = 0
	m = 0
	for i in range(1,len(l)+1):
		tm = m
		m += (l[i-1] - tm) / i
		s += (l[i-1] - tm) * (l[i-1] - m)
	return (s / (i-1))**.5

