import java.util.Scanner;
public class EnglishLanguageReversed
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        //String inp = "abcdefghijklmnopqrstuvx";

        if (inp.length()!=23) {
            System.out.println("Your input is incorrect.");
            System.exit(0);
        }

        for (int i = 0; i<3; i++) {
         	inp=xor(inp);
            //System.out.println("("+i+") UnXored inp "+i+": " + inp);
            inp=untranspose(inp);
            //System.out.println("("+i+") UnTransposed inp "+i+": "+inp);   
        }
        
        System.out.println("The flag is: " + inp);

        for (int i = 0; i<3; i++) {
            inp=transpose(inp);
            //System.out.println("("+i+") Transposed inp "+i+": "+inp);
            inp=xor(inp);
            //System.out.println("("+i+") Xored inp "+i+": " + inp);
        }

        if (inp.equals("1dd3|y_3tttb5g`q]^dhn3j")) {
            System.out.println("Correct. Your input is the flag.");
        }
        else {
            System.out.println("Your input is incorrect.");
        }
    }
    public static String transpose(String input) {
        int[] transpose = {11,18,15,19,8,17,5,2,12,6,21,0,22,7,13,14,4,16,20,1,3,10,9};
        String ret = "";
        for (int i: transpose) {
            ret+=input.charAt(i);
        }
        return ret;
    }
    public static String xor(String input) {
        int[] xor = {4,1,3,1,2,1,3,0,1,4,3,1,2,0,1,4,1,2,3,2,1,0,3};
        String ret = "";
        for (int i = 0; i<input.length(); i++) {
            ret+=(char)(input.charAt(i)^xor[i]) ;
        }
        return ret;
    }
    public static String untranspose(String input) {
        int[] transpose = {11,18,15,19,8,17,5,2,12,6,21,0,22,7,13,14,4,16,20,1,3,10,9};

 		StringBuilder untranspose = new StringBuilder(input);

        int j = 0;
        for (int t: transpose) {
        	untranspose.setCharAt(t, input.charAt(j));
        	j++;
        }

        String ret = "";
        for (int i=0; i<untranspose.length(); i++) {
            ret+=untranspose.charAt(i);
        }
        return ret;
    }
}
