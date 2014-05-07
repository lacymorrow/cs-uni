/**
 * A driver class used to create various patterns of squares on a display
 * canvas.
 * 
 * @author Thomas Morrow
 * 
 */
public class TestPatterns0 {


    public TestPatterns0() {
        // This statement is used to get the canvas to display
        // canvas, without other objects.
        Canvas.getCanvas();

        
        
        // 1. A (tedious) example method for creating a row of squares
        tediousTenSquares();
        displayCounter(0, 9);

        
        
        // 2. Ten squares using a while-loop
        tenSquaresWhileLoop();

        
        
        // 3. Ten squares using a for-loop
        tenSquaresForLoop();

        
        
        // 4. Your rowOfSquares method call to place 8 30x30 black squares
        //separated by 50 pixels in a row
        //starting at (x,y) = (100,400)
        rowOfSquares(8,100,300,30,50,"black");   // complete to correspond with your method

    } // end constructor

    /**
     * Creates a row of 10 blue squares, each is 40x40 pixels, repeated every 50
     * pixels on the x-axis. The top-left corner of the row is at (x,y) =
     * (100,100)
     */
    public void tediousTenSquares() {

        new Square(100, 100, 40, "blue");
        new Square(150, 100, 40, "blue");
        new Square(200, 100, 40, "blue");
        new Square(250, 100, 40, "blue");
        new Square(300, 100, 40, "blue");
        new Square(350, 100, 40, "blue");
        new Square(400, 100, 40, "blue");
        new Square(450, 100, 40, "blue");
        new Square(500, 100, 40, "blue");
        new Square(550, 100, 40, "blue");
    }

    /**
     * 
     * Displays integers from 'first' to 'last' inclusive, one per line, on the
     * display console If first is greater than last, the routine exits with an
     * error message. This is an example of a while-loop.
     * 
     */
    public void displayCounter(int first, int last) {

        if (first > last) {
            System.out.println("Error: first is greater than last.");
        }

        int i = first; // iteration counter, used in while-condition
        while (i <= last) {

            System.out.println(i);
            i++; // update counter. This is Java short-hand for i = i + 1;
        }
    }

    /**
     * Write a method that uses a while-loop for displaying 10 red squares, each
     * 20x20 pixels, repeated every 50 pixels with top-left of first square at
     * (100, 200)
     */
    public void tenSquaresWhileLoop() {
        int i = 0;
        while (i < 10){
            new Square(100+(i*50), 200, 20, "red");
            i++; // update counter. This is Java short-hand for i = i + 1;
        }
    }

    /**
     * Write the same as above using a for-loop only with green squares and the
     * top-left corner of first square at (100,250)
     */
    public void tenSquaresForLoop() {
        for(int i=0;i<10;i++){
            new Square(100+(i*50), 250, 20, "green");
        }
    }

    /**
     * Write a method rowOfSquares, using a for-loop that takes parameters
     * to specify: number of squares, position of top-left corner of row 
     * (xPos, yPos), size of the square in pixels, spacing between squares
     * in pixels, color of squares. You define the parameter list.
     */
    public void rowOfSquares(int squares, int xPos, int yPos, int size, int space, String color) {
        for(int i=0;i<squares;i++){
            new Square(xPos+(i*space), yPos, size, color);
        }
    }

} // end class TestPatterns
