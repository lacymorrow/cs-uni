import random
def main():
	count = int(input("How many sets of Powerball numbers should be generated?\n"))
	print("\nLotto Numbers (final number is your Powerball number):\n")
	for j in range(count):
		nums = []
		balls = list(range(1,54))
		powers = list(range(1,43))
		for i in range(5):
			nums.append(random.choice(balls))
			balls.remove(nums[len(nums)-1])
		nums.sort()
		nums.append(random.choice(powers))
		print(nums)

main()