/**
 * Created by Ben on 29/01/2015.
 */
import java.util.Scanner;

public class Tables {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer:");
        int num = input.nextInt();
        for(int x=1;x<=10;x++){
            System.out.println(x+" * "+num+" = "+(x*num));
        }
    }
}
