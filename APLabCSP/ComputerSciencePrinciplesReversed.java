import java.util.Scanner;
public class ComputerSciencePrinciples
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        if (inp.length()!=18) {
            System.out.println("Your input is incorrect.");
            System.exit(0);
        }

        String shift_inp = shift(inp);
        String shift2_inp = shift2(inp);
        String shift2_shift_inp = shift2(shift(inp));
        System.out.println("shift(inp): " + shift_inp);
        System.out.println("shift2(inp): " + shift2_inp);
        System.out.println("shift2(shift(inp)): " + shift2_shift_inp);

        String unshift_inp = unshift(shift_inp);
        String unshift2_inp = unshift2(shift2_inp);
        String unshift2_unshift_inp = unshift2(unshift(shift2_shift_inp));
        System.out.println("unshift(inp): " + unshift_inp);
        System.out.println("unshift2(inp): " + unshift2_inp);
        System.out.println("unshift2(unshift(inp)): " + unshift2_unshift_inp);
        
        assert (inp == unshift_inp) : "unshift esta errado";
        assert (inp == unshift2_inp) : "unshift2 esta errado";
        assert (inp == unshift2_unshift_inp) : "unshift2 unshift esta errado";
        
        String flag = unshift2(unshift(inp));
        inp=shift2(shift(flag));
       
        if (inp.equals("inagzgkpm)Wl&Tg&io")) {
            System.out.println("Correct. Your input is the flag.");
            System.out.println("The flag is: "+ flag);
        }
        else {
            System.out.println("Your input is incorrect.");
        }
        System.out.println(inp);
    }
    public static String shift(String input) {
        String ret = "";
        for (int i = 0; i<input.length(); i++) {
            //System.out.println("CharAt("+i+") - "+i+": "+(char)(input.charAt(i)-i));
            ret+=(char)(input.charAt(i)-i);
        }
        return ret;
    }
    public static String shift2(String input) {
        String ret = "";
        for (int i = 0; i<input.length(); i++) {
            ret+=(char)(input.charAt(i)+Integer.toString((int)input.charAt(i)).length());
        }
        return ret;
    }
    public static String unshift(String input) {
        String ret = "";
        for (int i = 0; i<input.length(); i++) {
            //System.out.println("CharAt("+i+") - "+i+": "+(char)(input.charAt(i)+i));
            ret+=(char)(input.charAt(i)+i);
        }
        return ret;
    }
    public static String unshift2(String input) {
        String ret = "";
        for (int i = 0; i<input.length(); i++) {
            ret+=(char)(input.charAt(i)-Integer.toString((int)input.charAt(i)).length());
        }
        return ret;
    }
}
