
/**
 * @author (Patrick Barber) 
 */
public class Driver
{
    public static void main(String[]args)
    {
        int board[] = {0, 3, 5, 6, 9, 11, 12, 8};
        int board2[] = {0,1,2,3,4,5,6,7,8,9,10,11};
        int board3[] = {0,1,2,3,4,5,7,8,10,11,12};
        Hoppers h = new Hoppers();
        h.setBoard(board);
        h.getSolution();
    }
}
