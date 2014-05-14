import os
def main():
	f = os.listdir()
	for i in range(len(f)):
		name, ext = os.path.splitext(f[i])
		print(name + "\t" + ext)

main()