# 1. A 1-element tuple needs a comma to distinguish it as a tuple rather than an expression. The comma is required, the parenthesis are not.
# 
# 2.
# sets x to 1 and y to 2
# x, y = 1, 2
# swaps x and y
# x,y = y,x
# sets x to 1 and y to list [2,3,4] 
# x, *y = 1,2,3,4
#
# 3.
list("Split into chars")
# 
# 4.
def remove_dupes(l):
	nl = []
	while len(l) > 0:
		if l[0] not in nl:
			nl.append(l[0])
		l.remove(l[0])
	return nl
# 
# 5. set is mutable and not hashable, frozenset is immutable and hashable. frozenset may also be used as a dictionary key or an element of another set.
# 
# 6.
def copy_s(s, n):
	ns = ''
	for i in range(n):
		ns += s
	return ns
# 
# 7.
def replace_space(s, r):
	return s.replace(" ", r)
# 
# 8.
def bin2num(b):
	return int(b, 2)
# 
# 9.
def is_palindrome(p):
	for i in range(int(len(p)/2)):
		if p[i] != p[-(i+1)]:
			return False
	return True
# 
# 10.
def underscores():
	s = input("Enter a phrase to convert: \n")
	s = ' '.join(s.split()).replace(' ','_')
	print(s)
	return s
# 
# 11.
def acronym():
	s = input("Enter a phrase to acronymize:\n")
	a = [s[0].upper()]
	for i in range(len(s)):
		if s[i-1] == ' ':
			a.append(s[i].upper())
	print(a)
	return a
# 
# 12.
def translate_abrv():
	dict = {'lol':'Laugh out loud','g2g':'Got to go'}
	while True:
		s = input("Enter an abbreviation to translate:\n")
		if s == "":
			break
		elif s.lower() in dict:
			print(dict[s]+"\n")

		else:
			print("Not Found\n")
