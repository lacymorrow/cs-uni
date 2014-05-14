import sys, os, pickle
def main():
	print("Loading game state...\n")
	game =[]
	if os.path.exists('state.dat'):
		game = pickle.load(open('state.dat', 'rb'))
	user = input("Enter your username: ")
	new = True
	for i in game:
		if i[0] == user:
			print('Current level: ' + str(i[1]))
			new = False
	if new:
		game.append((user, 0))
	print('\nAll Players')
	print('------------')
	for i in game:
		print(i[0] + '\t' + str(i[1]))
	lev = input("\nEnter your current level: ")
	for i in game:
		if i[0] == user:
			game.remove(i)
			game.append((user,lev))
	print('Saving game state...')
	pickle.dump(game, open('state.dat', 'wb'))
	print('Done.')

main()