import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Simulates the Hopper game
 * @author (Patrick Barber) 
 * @version (12/20/18)
 */
public class Hoppers
{
    private int[]board;
    private ArrayList<Jumps> jumps;
    private ArrayList<Jumps> jumpsMade;
    /**
     * Constructor for objects of class Hoppers
     */
    public Hoppers()
    {
        board = new int[13];
        jumps = new ArrayList<Jumps>();
        jumpsMade = new ArrayList<Jumps>();
        jumps.add(new Jumps(0,1,2));
        jumps.add(new Jumps(0,3,6));
        jumps.add(new Jumps(0,5,10));
        jumps.add(new Jumps(1,3,5));
        jumps.add(new Jumps(1,4,7));
        jumps.add(new Jumps(1,6,11));
        jumps.add(new Jumps(2,1,0));
        jumps.add(new Jumps(2,4,6));
        jumps.add(new Jumps(2,7,12));
        jumps.add(new Jumps(3,6,9));
        jumps.add(new Jumps(4,6,8));
        jumps.add(new Jumps(5,3,1));
        jumps.add(new Jumps(5,6,7));
        jumps.add(new Jumps(5,8,11));
        jumps.add(new Jumps(6,3,0));
        jumps.add(new Jumps(6,4,2));
        jumps.add(new Jumps(6,9,12));
        jumps.add(new Jumps(6,8,10));
        jumps.add(new Jumps(7,4,1));
        jumps.add(new Jumps(7,9,11));
        jumps.add(new Jumps(7,6,5));
        jumps.add(new Jumps(8,6,4));
        jumps.add(new Jumps(9,6,3));
        jumps.add(new Jumps(10,5,0));
        jumps.add(new Jumps(10,8,6));
        jumps.add(new Jumps(10,11,12));
        jumps.add(new Jumps(11,8,5));
        jumps.add(new Jumps(11,6,1));
        jumps.add(new Jumps(11,9,7));
        jumps.add(new Jumps(12,11,10));
        jumps.add(new Jumps(12,9,6));
        jumps.add(new Jumps(12,7,2));

        //         for(int i=0;i<jumps.size();i++)
        //         {
        //             System.out.print(jumps.get(i).getSourcePeg() + " ");
        //         }
        //        System.out.println("");
    }

    public void setBoard(int[] array)
    {
        //takes an array of int values.  These int values will list the locations of green and red frogs.  
        //The red frog will always be the last value in the array.  
        //The array will contain only legal, non-duplicate int values on the interval [0, 12].  
        //Positions of green frogs can exist in the array in any order; however, the red frog will always be last.
        for(int i=0;i<array.length;i++)
        {
            int peg;

            if (i == array.length-1)
            {
                //2 is for red peg
                peg = 2;
            }
            else
            {
                //1 is for green peg
                peg = 1;
            }

            if(array[i] == 0)
            {
                board[0] = peg;
            }
            else if(array[i] ==1)
            {
                board[1] = peg;
            }
            else if(array[i] == 2)
            {
                board[2] = peg;
            }
            else if(array[i] == 3)
            {
                board[3] = peg;
            }
            else if(array[i] == 4)
            {
                board[4] = peg;
            }
            else if(array[i] == 5)
            {
                board[5] = peg;
            }
            else if(array[i] == 6)
            {
                board[6] = peg;
            }
            else if(array[i] == 7)
            {
                board[7] = peg;
            }
            else if(array[i] == 8)
            {
                board[8] = peg;
            }
            else if(array[i] == 9)
            {
                board[9] = peg;
            }
            else if(array[i] == 10)
            {
                board[10] = peg;
            }
            else if(array[i] == 11)
            {
                board[11] = peg;
            }
            else if(array[i] == 12)
            {
                board[12] = peg;
            }
        }
        //System.out.println(Arrays.deepToString(board).replace("], ", "]\n "));
        //for(int i=0; i<board.length;i++)
        //{
        //    System.out.print(board[i]+" ");
        //}
    }        

    public void getSolution()
    {
        //prints the jumps made on a new line followed by done, or no solution
        boolean var = solve(board);
        if(var==false)System.out.println("No Solution");
        else 
        {
            for(int a = jumpsMade.size()-1;a>=0;a--)
            {
                System.out.println(jumpsMade.get(a).getSourcePeg() + " - " + jumpsMade.get(a).getDestPeg() );
            }
            System.out.println("Done!");
        }
    }

    public boolean checkForValidMove(int[] boardIn) //method that checks for any valid move
    {
        int[] board3 = new int[13];
        for(int i = 0; i<boardIn.length; i++)
        {
            board3[i] = boardIn[i];
        }

        int j,k,l;
        for(int a = 0;a<jumps.size();a++)//go through the list of possible jumps
        {
            j = (jumps.get(a).getSourcePeg()); //get the source peg
            //System.out.print("Source Peg " +j +" , ");

            if(board3[j] == 1 || board3[j] == 2)
            {
                k = (jumps.get(a).getJumpPeg()); //get the peg to be jumped
                //System.out.print("Jump Peg " +k +" , ");   
                if(board3[k] == 1)
                {
                    l = (jumps.get(a).getDestPeg()); //get the spot to jump to
                    //System.out.println("Dest Peg " +l +" , ");
                    if(board3[l] == 0)
                    {
                        return true; //there is a possible move
                    }
                }
            }
        }
        return false; //no possible moves
    }

    public boolean solve(int[] boardIn)
    {
        int[] board2 = new int[13];
        for(int i = 0; i<boardIn.length; i++)
        {
            board2[i] = boardIn[i];
        }

        int greenFrog = 0;
        int redFrog= 0;
        //int j,k,l;
        for(int i = 0; i<board2.length; i++)//base case - if there is only one red peg left
        {
            if (board2[i] == 1) greenFrog++;
            else if (board2[i] == 2) redFrog++;
        }
        if(greenFrog==0 && redFrog==1) return true;

        boolean var = checkForValidMove(board2); //check if there is a valid move
        if(var == false)
        {
            return false; //if there is no valid move
        }

        for(int a = 0;a<jumps.size();a++)//go through the list of possible jumps
        {
            int j = (jumps.get(a).getSourcePeg()); //get the source peg
            //System.out.print("Source Peg " +j +" , ");
            if (board2[j] == 1 || board2[j] == 2) //if the source peg is a green or red frog
            {
                int k = (jumps.get(a)).getJumpPeg(); //get the peg to be jumped
                //System.out.print("Jump peg " +k + " , ");
                if (board2[k] == 1) //if the peg to be jumped is a green frog
                {
                    int l = (jumps.get(a)).getDestPeg(); //get the spot to jump to
                    //System.out.println("Dest Peg: "+l + " , ");
                    if (board2[l] == 0) //if the spot to jump to does not have a frog in it
                    {
                        int[] boardCopy = new int[13];
                        for(int i = 0; i<board2.length; i++)
                        {
                            boardCopy[i] = board2[i];
                        }
                        boardCopy[l] = boardCopy[j];//destination peg = source peg
                        boardCopy[k] = 0; //remove the jump peg	
                        boardCopy[j] = 0; // remove the source peg
                        boolean x = solve(boardCopy);
                        if(x==true)
                        {
                            //System.out.println(j +" - "+ l);
                            jumpsMade.add(new Jumps(j,k,l)); //add the jump just made into a new array list
                            return true;
                        }
                        else
                        {
                            boardCopy[l] = board2[l];
                            boardCopy[k] = board2[k];
                            boardCopy[j] = board2[j];
                            //for(int i = 0; i<board2.length; i++)
                            //{
                            //    boardCopy[i] = board2[i];
                            //}
                        }
                    }
                }
            }
        }
        return false;
    }
}
