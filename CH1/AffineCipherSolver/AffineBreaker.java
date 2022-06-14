import edu.duke.*;

public class AffineBreaker
{
    private int a;  // multiply
    private int b;  // sum
    private int c;  // modulus
    private int d;  // inverse
    private String alpha = "abcdefghijklmnopgrstuvwxyz";
    
    public AffineBreaker(int multiply, int sum, int modulus){
        a = multiply;
        b = sum;
        c = modulus;
    }
    
    public int findInverse(){
        for (int i = 0; i < c; i++){
            if (i * a % c == 1){
                d = i;
            }
        }
        return d;
    }
    
    public String decrypt(String encrypted){
        String decrypted = new String();
        for (int i=0; i < encrypted.length(); i++){
            char enc_letter = encrypted.charAt(i);
            int enc_loc = alpha.indexOf(enc_letter);
            
            int dec_loc = (d * (enc_loc - b)) % c;
            
            if (dec_loc < 0){
                dec_loc = dec_loc + c;
            }
            
            System.out.println("Encrypted letter: " + enc_letter + " Location: " + enc_loc);
            char dec_letter = alpha.charAt(dec_loc);
            System.out.println("Decrypted letter: " + dec_letter + " Location: " + dec_loc);
            decrypted = decrypted + dec_letter;
        }
        return decrypted;
    }
    
    public static void main(String[] args){
        int multiply = 7;
        int sum = 22;
        int modulus = 26;
        AffineBreaker ab = new AffineBreaker(7, 22, 26);
        int inverse = ab.findInverse();
        System.out.println("Inverse of: " + multiply + " in " + modulus + " is: " + inverse);
        FileResource fr = new FileResource("msg.txt");
        String msg = fr.asString();
        String plaintext = ab.decrypt(msg);
        System.out.println(plaintext);
    }
}
