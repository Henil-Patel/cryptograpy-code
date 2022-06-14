import java.util.ArrayList;
/**
 * This will attempt to find an inverse of rings 
 * Z_11, Z_12, Z_13
 */
public class RingInverse
{
    
    private int a = 17;

    public int[] fillRing(int[] z){
        for (int i = 0; i < z.length; i++){
            z[i] = i;
        }
        return z;
    }
    
    public ArrayList<Integer> findInverse(int[] ring){
        ArrayList<Integer> inverses = new ArrayList<Integer>();
        int modulus = ring.length;
        for (int i = 0; i < ring.length; i++){
            System.out.println((a * ring[i]) % modulus);
            if ((a * ring[i]) % modulus == 1){
                inverses.add(ring[i]);
            }
        }
        return inverses;
    }
    
    public static void main(String[] args){
        // instance variables - replace the example below with your own
        /**
        int[] z11 = new int[11];
        int[] z12 = new int[12];
        int[] z13 = new int[13];
        RingInverse ri = new RingInverse();
        z11 = ri.fillRing(z11);
        z12 = ri.fillRing(z12);
        z13 = ri.fillRing(z13);
        ArrayList<Integer> inv5_11 = ri.findInverse(z11);
        System.out.println("Inverse of 5 in Z_11 is: " + inv5_11);
        ArrayList<Integer> inv5_12 = ri.findInverse(z12);
        System.out.println("Inverse of 5 in Z_12 is: " + inv5_12);
        ArrayList<Integer> inv5_13 = ri.findInverse(z13);
        System.out.println("Inverse of 5 in Z_13 is: " + inv5_13);
        */
       int[] z30 = new int[30];
       RingInverse ri = new RingInverse();
       z30 = ri.fillRing(z30);
       ArrayList<Integer> inv17_30 = ri.findInverse(z30);
       System.out.println("Inverse of 17 in Z_30 is: " + inv17_30);
        
    }
} 
