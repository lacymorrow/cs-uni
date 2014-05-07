/**
 * @author 
 *
 */

// imports??

public class TestPatterns1 {

	/**
    *  1. Declare an "ArrayList of Square" field called 'sqList'
    */

   
   
   /**
    * When invoked, this constructor will invoke the methods you design for 
    * Lab07 Activity 1.
    * 
    */
   public TestPatterns1() {
      // 2. Create an "ArrayList of Square" object and assign it to your 'sqList' field.

	   
	   
      // 3. This method should fill sqList with 8 Square objects--complete it below.
      addSquaresToList();  // write this method
      

      
      // 4. This method should change the size of the Square objects in the list to 48 pixels
      //    on a side. See method comments below...
      changeSquareSize();  // write this method
      
      
      // 5. This method should set the color of all the even numbered squares to black 
      //    starting with 0.
      changeEvenToBlack(); // write this method
      
      
   } // end constructor
   /**
    * Uses a while-loop to create and add 8 Square objects to the
    * sqList. Use your methods from the TestPatterns0 class as a 
    * starting point for building this one. Create Square objects
    * that form a row, starting at (0,0), each one 50x50 pixels and
    * no space between them (spacing is 50 pixels), color is red.
    */
   public void addSquaresToList(){

   
   
   
   } // end method
   
   /**
    * Changes the size of all the squares in the list to 48 pixels on a side.
    * Uses a for-each loop to access the Squares in the list one at 
    * a time and uses the setSize method to change the size of each one.
    */
   public void changeSquareSize(){

	   
   }
   
   /**
    * Changes the color of the even numbered squares in the list to black.
    * Use a for-loop and the 'get' method of the ArrayList class to access
    * elements of the list. Use the size() method in the loop condition to
    * control the limit of the index. One way to test for an even index is 
    * to see of the result of a division by 2 produces a zero remainder. 
    * The modulus operator does this: for example  (i % 2 == 0) is true
    * if 'i' is even, false otherwise. 
    * Another way to select squares is to increment the index by 2 instead of 1.
    */
   public void changeEvenToBlack(){
	   
	   
	   
	   
   }
   /**
    * delays a specified number of milliseconds. Not the best way to write a delay
    * for performance, but serves our purpose for now...
    */
   public void delay(long waitAmount ){

	   
	   
   } // end method
}
