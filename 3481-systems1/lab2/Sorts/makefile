CC = gcc -g
sort: sort.o bubbleSort.o mergeSort.o quickSort.o
bubbleSort.o: bubbleSort.h
mergeSort.o: mergeSort.h
quickSort.o: quickSort.h
sort.o: types.h mergeSort.h quickSort.h bubbleSort.h
clean:
	rm -f *.o
