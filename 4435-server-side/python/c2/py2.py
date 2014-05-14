def dog_breeds():
	db = ["Shiba Inu","Rottweiler", "Boxer", "Labrador", "Bulldog"]
	for i in db:
		print i

def list_prime():
	n = 100
	for i in range(2, n):
		p = True
		for j in range(2, int(i**.5)+1):
			if i % j == 0:
				p = False
		if p == True:
			print str(i)

def return_list(l):
	if len(l) < 2:
		print "Please enter an integer list of two or longer."
	l.sort()
	piv = len(l) / 2
	if len(l) % 2 == 0:
		med = (l[piv] + l[piv-1]) / 2
	else:
		med = l[piv]
	print "Median: " + str(med)

def friend_list(r = False):
	print "Friend Lister - press enter to finish"
	l = []
	while True:
		n = raw_input("Enter the name of a friend: ")
		if n == "":
			break
		l.append(n)
	if r == True:
		l.reverse()
	for i in l:
		print i
	return l

def friend_list_rev():
	friend_list(True)

def friend_find():
	l = friend_list()
	print "Friend Finder - \nenter a name to search, press enter to finish"
	while True:
		n = raw_input("Search: ")
		if n == "":
			break
		elif n in l:
			print n + " is in your friend list."
		else:
			print n + " is not in your friend list."
	
def my_pop():
	t = st[len(st)-1]
	del st[len(st)-1]
	return t
def my_push(e):
	st.append(e)
	return st[len(st)-1]
def my_top():
	return st[len(st)-1]

def main():
	global st
	st = [1, 2, 3, 4, 5]
	my_top()
	print "Testing stack...\n"
	print "Top: " + str(my_top())
	print "Pushing 9..."
	my_push(9)
	print "Pushing 8..."
	my_push(8)
	print "Top: " + str(my_top())
	print "Pop: " + str(my_pop())
	print "Top: " + str(my_top())
	print "Finished stack test.\n"
	print "Dog breeds:\n"
	dog_breeds()
	print "Listing primes: \n"
	list_prime()
	return_list([1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1])
	friend_list()
	friend_list_rev()
	friend_find()
		
if __name__ == "__main__":
    main()

