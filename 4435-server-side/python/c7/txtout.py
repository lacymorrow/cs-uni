import sys,os
def main(d):
	f = os.listdir(d)
	for i in range(len(f)):
		name, ext = os.path.splitext(f[i])
		if ext == '.txt':
			print('\n' + name + ': ')
			with open(f[i], 'r') as fin:
				print(fin.read())
main(sys.argv[1])