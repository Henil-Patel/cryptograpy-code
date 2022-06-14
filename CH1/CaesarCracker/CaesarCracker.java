import edu.duke.*;

public class CaesarCracker {
    char mostCommon;
    String alph = "abcdefghijklmnopqrstuvwxyz";

    public CaesarCracker() {
        mostCommon = 'e';
    }
    
    public CaesarCracker(char c) {
        mostCommon = c;
    }
    
    public int[] countLetters(String message){
        int[] counts = new int[26];
        for(int k=0; k < message.length(); k++){
            int dex = alph.indexOf(Character.toLowerCase(message.charAt(k)));
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int k=0; k < vals.length; k++){
            if (vals[k] > vals[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
    }

    public int getKey(String encrypted, char mostCommon){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        //System.out.println("Letter: " + alph.charAt(maxDex) + " occurred: " + freqs[maxDex] + " times.");
        int mostCommonPos = mostCommon - 'a';
        int dkey = maxDex - mostCommonPos;
        //System.out.println(maxDex);
        if (maxDex < mostCommonPos) {
            dkey = 26 - (mostCommonPos-maxDex);
        }
        return dkey;
    }
    
    public void decrypt(String encrypted){
        for (int i = 0; i < 26; i++){
            char mostCommon = alph.charAt(i);
            System.out.println("Trying most common: " + mostCommon);
            int key = getKey(encrypted, mostCommon);
            CaesarCipher cc = new CaesarCipher(key);
            System.out.println(cc.decrypt(encrypted));
        }
    }
    
    // tester
    
    public void breakCipher(){
        FileResource fr = new FileResource("msg.txt");
        String encrypted = fr.asString();
        decrypt(encrypted);
        //System.out.println(plainText);
    }
   
}
