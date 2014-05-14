import random
def main():

	print("Welcome to Rock, Paper, Scissors!\n")
	goal = int(input("How many points are required to win? "))
	uscore = cscore = 0
	while True:
		if uscore >= goal:
			print("Human reached the goal of " + str(goal))
			print("Human wins the match!")
			break
		elif cscore >= goal:
			print("Computer reached the goal of " + str(goal))
			print("Computer wins the match!")
			break
		u = input("\nChoose (R)ock, (P)aper, or (Scissors): ").lower()
		if u == "r" or u == "p" or u == "s":
			u = get_num(u)
			c = random.randint(0, 2)
			print("Human: " + get_rps(u) + "     Computer: " + get_rps(c))
			if (u>c and u-c==1) or (c>u and c-u==2):
				uscore += 1
				print("Human wins!\n")
			else:
				print("Computer wins!\n")
				cscore += 1
		elif u == "q" or u == "":
			break
		else:
			print("Invalid choice")
	print("Game Over")

def get_num(u):
	if u == "r":
		return 0
	elif u == "p":
		return 1
	elif u == "s":
		return 2
	return 99

def get_rps(u):
	if u == 0:
		return "Rock"
	elif u == 1:
		return "Paper"
	elif u == 2:
		return "Scissors"
	return "Error"

main()
