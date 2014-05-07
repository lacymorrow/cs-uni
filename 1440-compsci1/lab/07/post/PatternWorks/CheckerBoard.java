
/**
 * Write a description of class CheckerBoard here.
 * 
 * @author Thomas Morrow 
 */

import java.util.ArrayList;

public class CheckerBoard
{
    // instance variables - replace the example below with your own
    private int rowNum;
    private boolean colorPat;
    private ArrayList<Square> sqList;
    

    /**
     * Constructor for objects of class CheckerBoard
     */
    public CheckerBoard()
    {
        // initialise instance variables
        sqList = new ArrayList<Square>();
        rowNum = 8;//checkerboard traditionally has 8 squares
        colorPat = true;
    }
    
    public void makeBoard(int rowNum){
        int x = 0;
        for(int i = 1; i<=rowNum; i++){
           for(int a = 1; a<=rowNum; a++){
                sqList.add(new Square((i*51),(a*51),50,"blue"));
                if((x+i) % 2==0){
                    sqList.get(x).setColor("red");
                } else {
                    sqList.get(x).setColor("black");
                }
                x++;
            }
        }
    }
    public void reverseColors()
    {
        int x = 0;
        for(int i = 1; i<=rowNum; i++){
           for(int a = 1; a<=rowNum; a++){
                if((((x+i) % 2==0)&&colorPat)||(((x+i) % 2==1)&&!colorPat)){
                    sqList.get(x).setColor("black");
                } else {
                    sqList.get(x).setColor("red");
                }
                x++;
            }
        }
        colorPat = !colorPat;
    }
    public void blinkBoard(int blinkNum){
        for(int i=0;i<blinkNum;i++){
            reverseColors();
            delay(300);
            //delay
        }
    }
    public void fadeBoard(){
        for(int i = 0;i<rowNum*rowNum;i++){
            for(int a = 50;a>=0;a--){
                delay(3);
                sqList.get(i).setSize(a);
            }
        }
    }
    public void growBoard(int rowNum){
        int x = 0;
        for(int i = 1; i<=rowNum; i++){
           for(int a = 1; a<=rowNum; a++){
               delay(100);
                if(x==0){               
                    sqList.add(new Square((i*51),(a*51),10,"blue"));
                } else if(x==1){
                    sqList.get(x-1).setSize(30);
                    sqList.add(new Square((i*51),(a*51),10,"blue"));
                } else if(x==(rowNum*rowNum)){
                    
                } else {
                    sqList.get(x-2).setSize(50);
                    sqList.get(x-1).setSize(30);
                    sqList.add(new Square((i*51),(a*51),10,"blue"));
                }
                    if((x+i) % 2==0){
                        sqList.get(x).setColor("red");
                    } else {
                        sqList.get(x).setColor("black");
                    }
                x++;
            }
        }
        for(int b=0;b<2;b++){
            delay(100);
            sqList.get(x-2).setSize(50);
            if(x<rowNum*rowNum+1){
                sqList.get(x-1).setSize(30);
            }
                x++;
        }
    }
    public void delay(long waitAmount){
       long time = System.currentTimeMillis();
       while ((time+waitAmount)>=System.currentTimeMillis()){ 
           //nothing
        }
   }
}
