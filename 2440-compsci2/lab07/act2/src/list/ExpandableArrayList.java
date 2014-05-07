package list;

/**
 * A class that implements the ADT list by using an expandable array.
 * 
 * @author Frank M. Carrano
 * @version 2.0
 */
public class ExpandableArrayList<T> implements ListInterface<T>, java.io.Serializable
{
	// private data fields:
	private T[] list;			 			// array of list entries
	private int length;  			 	// current number of entries on list
	private static final int DEFAULT_INITIAL_CAPACITY = 25; 	// initial length of list 

	// public methods:	
	public ExpandableArrayList()
	{
		this(DEFAULT_INITIAL_CAPACITY);
	} // end default constructor

	public ExpandableArrayList(int initialCapacity)
	{
		length = 0;
		list = (T[]) new Object[initialCapacity];
	} // end constructor

	// exercise -------------------------
	public ExpandableArrayList(T[] items, int numberOfItems, int initialCapacity)
	{
		length = numberOfItems;
		list = (T[]) new Object[initialCapacity];

		for (int index = 0; index < numberOfItems; index++)
			list[index] = items[index];
	} // end constructor
	// ----------------------------------

	public boolean add(T newEntry)
	{
		if (isArrayFull()) 
			doubleArray();

		// add new entry after last current entry
		list[length] = newEntry;
		length++;

		return true;
	} // end add

	public boolean add(int newPosition, T newEntry)
	{
		boolean isSuccessful = true;

		if ((newPosition >= 1) && (newPosition <= length+1)) 
		{	
			if (isArrayFull()) 
				doubleArray();

			makeRoom(newPosition);				
			list[newPosition - 1] = newEntry;
			length++;
		}
		else
			isSuccessful = false;

		return isSuccessful;
	} // end add

	public T remove(int givenPosition)
	{
		T result = null; // return value

		if ((givenPosition >= 1) && (givenPosition <= length)) // test catches empty list
		{	
			assert !isEmpty();

			result = list[givenPosition - 1]; // get entry to be removed

			// move subsequent entries towards entry to be removed, 
			// unless it is last in list
			if (givenPosition < length)
				removeGap(givenPosition);

			length--;
		} // end if

		return result; // return reference to removed entry,
		               // or null if list is empty
	} // end remove

	public void clear()
	{
		for (int index = 0; index < length; index++) // loop is part of Q4
			list[index] = null;

		length = 0; // no need to create a new array
	} // end clear

	public boolean replace(int givenPosition, T newEntry)
	{
		boolean isSuccessful = true;

		if ((givenPosition >= 1) && (givenPosition <= length)) // test catches empty list
		{
			assert !isEmpty();
			list[givenPosition - 1] = newEntry;
		}
		else
			isSuccessful = false;

		return isSuccessful;
	} // end replace

	public T getEntry(int givenPosition)
	{
		T result = null; // result to return

		if ((givenPosition >= 1) && (givenPosition <= length))
		{
			assert !isEmpty();
			result = list[givenPosition - 1];
		} // end if

		return result;
	} // end getEntry

	public boolean contains(T anEntry)
	{
		boolean found = false;
		for (int index = 0; !found && (index < length); index++)
		{
			if (anEntry.equals(list[index]))
				found = true;
		} // end for

		return found;
	} // end contains

	public int getLength()
	{
		return length;
	} // end getLength

	public boolean isEmpty()
	{
		return length == 0;
	} // end isEmpty

	public boolean isFull()
	{
		return false;
	} // end isFull

	public void display()
	{
		// iterative
		for (int index = 0; index < length; ++index)
			System.out.println(list[index]);
		// recursive
		//		displayArray(0, length-1);
		//		System.out.println();
	} // end display

	private void displayArray(int first, int last) 
	{ 
		System.out.print(list[first] + " ");
		if (first < last)
			displayArray(first+1, last);
	}// end  displayArray

	/** @return true if the array of list entries is full,
	 *          that is, if the length of the list equals 
	 *          the size of the array. */
	private boolean isArrayFull()
	{
		return length == list.length;
	} // end isArrayFull

	/** Task: Doubles the size of the array of list entries. */
	private void doubleArray()
	{
		T[] oldList = list; // save reference to array of list entries
		int oldSize = oldList.length;     // save old max size of array

		list = (T[]) new Object[2 * oldSize];    // double size of array

		// copy entries from old array to new, bigger array
		for (int index = 0; index < oldSize; index++)
			list[index] = oldList[index];
//  System.arraycopy(oldList, 0, list, 0, oldSize); // Question 13
	} // end doubleArray

  /** Task: Makes room for a new entry at newPosition.
   *  Precondition: 1 <= newPosition <= length + 1; 
	 *                length is lists length before addition. */
	private void makeRoom(int newPosition)
	{
	  assert (newPosition >= 1) && (newPosition <= length + 1);
	  
	  int newIndex = newPosition - 1;
	  int lastIndex = length - 1;

  // move each entry to next higher index, starting at end of
  // list and continuing until the entry at newIndex is moved
    for (int index = lastIndex; index >= newIndex; index--)
	    list[index + 1] = list[index];
	}  // end makeRoom

	/** Task: Shifts entries that are beyond the entry to be removed 
	 *        to the next lower position.
	 *  Precondition: list is not empty; 1 <= givenPosition < length;
	 *                length is lists length before removal. */
	private void removeGap(int givenPosition)
	{
	  assert (givenPosition >= 1) && (givenPosition < length);
	  
		// move each entry to next lower position starting at entry after the  
		// one removed and continuing until end of list
	  int removedIndex = givenPosition - 1;
	  int lastIndex = length - 1;
	  
	  for (int index = removedIndex; index < lastIndex; index++)
	    list[index] = list[index + 1];
	} // end removeGap
} // end ExpandableArrayList

