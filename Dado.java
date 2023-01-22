import java.io.Serializable;
import java.util.Random;
public final class Dado implements Serializable{
    private int sideUp;
    public Dado() {
        roll();
    }
    public void roll(){
        Random random = new Random();
        sideUp = 1 + random.nextInt(6);
    }
    public int getSideUp (){
        return sideUp;
    }
    @Override
    public String toString() {
        return super.toString();
    }
    
}
