from datetime import date

class MyRangeError(Exception):
	pass

def getY():
	y = input("Enter the year: ")
	if y == '':	
		print(date.today().year)
	try:
		if int(y) < 1:
			raise MyRangeError("Invalid year. Year must be a positive integer.")
	except ValueError:
		print("You must enter an integer.")
	return y

def getM():
	m = input("Enter the month: ")
	if m == '':	
		print(date.today().month)
	try:
		if int(m) < 1 or int(m) > 12:
			raise "Invalid month. Month must be in range 1 - 12."
	except ValueError:
		print("You must enter an integer.")
	return m

def getD():
	d = input("Enter the day: ")
	if d == '':	
		print(date.today().day)
	try:
		if int(d) < 1 or int(d) > 31:
			raise "Invalid day. Day must be in range 1 - 31."
	except ValueError:
		print("You must enter an integer.")
	return d

def getH():
	h = input("Enter the hour: ")
	if h == '':	
		print(date.today().hour)
	try:
		if int(h) < 0 or int(h) > 23:
			raise "Invalid hour. Hour must be in range 0 - 23."
	except ValueError:
		print("You must enter an integer.")
	return h

def getMn():
	mn = input("Enter the minute: ")
	if mn == '':	
		print(date.today().minute)
	try:
		if int(mn) < 0 or int(mn) > 59:
			raise "Invalid minute. Minute must be in range 0 - 59."
	except ValueError:
		print("You must enter an integer.")
	return mn

def getS():
	s = input("Enter the second: ")
	if s == '':	
		print(date.today().second)
	try: 
		if int(s) < 0 or int(s) > 59:
			raise "Invalid second. Second must be in range 0 - 59."
	except ValueError:
		print("You must enter an integer.")
	return s


def get_time_date():
	try:
		y = getY()
		m = getM()
		d = getD()
		h = getH()
		mn = getMn()
		s = getS()
		print(y + '-' + m + '-' + d + ' ' + h + ':' + mn + ':' + s)
	except MyRangeError as error:
		print("Invalid input. " + str(error))

get_time_date()