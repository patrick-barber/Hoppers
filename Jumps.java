import java.util.List;
import java.util.ArrayList;
/**
 * @author (Patrick Barber) 
 */
public class Jumps
{
    private int sourcePeg;
    private int jumpPeg;
    private int destPeg;
    
    /**
     * Constructor for objects of class Jumps
     */
    public Jumps(int sourcePegIn, int jumpPegIn, int destPegIn)
    {
        sourcePeg = sourcePegIn;
        jumpPeg = jumpPegIn;
        destPeg = destPegIn;
        
        
    }
    
    public int getSourcePeg()
    {
        return sourcePeg;
    }

    public int getJumpPeg()
    {
        return jumpPeg;
    }
    
    public int getDestPeg()
    {
        return destPeg;
    }
    
}
