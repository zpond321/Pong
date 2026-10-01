public class random
{
    // Constructor with inputs
    public static int randint(int min, int max)
    {
       return (int)(Math.random() * (max) + (min));
    }
    
    //false = tails,  true = heads
    public static boolean coinFlip()
    {
        int coin = (int)(Math.random() * 2 + 1);
        if(coin==1){
            return true;
        }
        else{
            return false;
        }
    }
    
}