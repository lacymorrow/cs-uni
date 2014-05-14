from my_stats import *
def calc(*l):
	for i in range(len(l)):
		with open(l[i]) as f:
			lines = f.readlines()
			nums = []
			# Remove comment data
			for j in lines:
				if j[0] != '*' and j[1] != '*':
					nums.append(int(j))
			print("\n***File " + str(i+1) + "***")
			print("Sum: " + str(sum(nums)))
			print("Mean: " + str(mean(nums)))
			print("Median: " + str(median(nums)))
			print("Standard Deviation: " + str(stddev(nums)))

calc('a.txt', 'b.txt')