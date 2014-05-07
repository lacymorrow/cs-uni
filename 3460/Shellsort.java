/*
 * Shell Sort
 * Lacy Morrow
 * 2/28/2011
 */

public class Shellsort
{
	Comparable[] array1, array2;
	final static int RANGE = 1000;
	final static int ELEMENTS = 20000;
	final static int ARRAYS = 1000;
	int c1 = 0;
	int c2 = 0;
	
	public static void main(String[] args)
	{
		new Shellsort();
	}
	
	public Shellsort()
	{
		for(int i=0;i<ARRAYS;i++)
			{
				array1 = fill(ELEMENTS);
				array2 = new Comparable[ELEMENTS];
				System.arraycopy(array1, 0, array2, 0, array1.length);
				int cur1 = shellSortA(array1,0,ELEMENTS-1);
				int cur2 = shellSortB(array2,0,ELEMENTS-1);
				c1 += cur1;
				c2 += cur2;
				}
		System.out.println(ARRAYS + " Arrays of " + ELEMENTS + " elements.");
		System.out.println("Average number of computations: " + (c1/ELEMENTS));
		System.out.println("Average number of computations for odd spaces: " + (c2/ELEMENTS));
	}
	
	public Comparable[] fill(int ELEMENTS)
	{
		Comparable[] arr = new Comparable[ELEMENTS];
		for(int i=0;i<ELEMENTS;i++)
			{
				arr[i] = (int) (Math.random() * RANGE - RANGE / 2);
			}
		return arr;
	}
	
	
	public static <T extends Comparable<? super T>> int shellSortB(T[] a, int first, int last)
	{
		int count = 0;
		
		int n = last - first + 1;
		
		for (int space = n/2; space > 0; space = space/2)
			{
				if(space%2 == 0)
					space++;
				for (int begin = first; begin < first + space; begin++)
					{
						count += incrementalInsertionSort(a, begin, last, space);
						}
				}
		return count;
	}
	
	public static <T extends Comparable<? super T>> int shellSortA(T[] a, int first, int last)
	{
		int count = 0;
		int n = last - first + 1;
		for (int space = n/2; space > 0; space = space/2)
			{
				for (int begin = first; begin < first + space; begin++)
					{
						count += incrementalInsertionSort(a, begin, last, space);
						}
				}
		return count;
	}
	
	private static <T extends Comparable<? super T>> int incrementalInsertionSort(T[] a, int first, int last, int space)
	{
		int count = 0;
		int unsorted, index;

		for (unsorted = first + space; unsorted <= last; unsorted = unsorted + space)
			{
				T firstUnsorted = a[unsorted];
				for (index = unsorted - space; (index >= first) && (firstUnsorted.compareTo(a[index]) < 0); index = index - space)
					{
						a[index + space] = a[index]; 
						count++;
						}
				a[index + space] = firstUnsorted; 
				}
		return count;
	}
}