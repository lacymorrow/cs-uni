import sys,os
def main(d,u):
	f = os.listdir(d)
	f1=open(u, 'w')
	for i in range(len(f)):
		name, ext = os.path.splitext(f[i])
		if ext == '.txt':
			print(name + ': ', file=f1)
			with open(f[i], 'r') as fin:
				print(fin.read(), file=f1)
main(sys.argv[1],input("Enter a filename for output: \n"))