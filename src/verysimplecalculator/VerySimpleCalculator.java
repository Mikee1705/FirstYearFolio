//Author: Chonkchilla
/**
 * This calculator is very simple, it only covers the 4 basic arithmetic operations.
 * 
 * This version only makes use of concepts that were taught to me in our introductory programming subject 
 * the first year of college.
 * 
 * Down the line, calculator version will become more complex
 * The final version of the calculator will make use of Java GUI
 * 
 * Made on: 10/26/2024
 */
package verysimplecalculator;
import java.util.Scanner;

public class VerySimpleCalculator {
    static char operator, flag;
    public static void main(String[] args) {
        double[] numInputs = new double[2];
        Scanner console = new Scanner(System.in);
        System.out.println("\t My First Calculator App");
        System.out.println("\t VERSION 1\n");
        
        do //outer loop, checks if you want to continue the code excution
        {            
            do //gets which operator that you will use
            {            
                System.out.println("Enter operator (+ - / % *)");
                operator = console.next().charAt(0);
            } while (!(operator=='+'||operator=='-'||operator=='/'||operator=='%'||operator=='*'));
        
            int ctr =0;
            System.out.println("\nEnter 2 numbers: ");
            do // loop for number input, makes use of arrays, lentgth is 2
            {            
                System.out.printf("Value #%d: ",ctr+1);
                numInputs[ctr] = console.nextDouble();
                ctr++;
            } while (ctr<2);
        
            switch (operator) 
            {
                case '+':
                    System.out.println("Sum: "+(numInputs[0] + numInputs[1])); break;
                case '-':
                    System.out.println("Difference: "+(numInputs[0] - numInputs[1])); break;
                case '*':
                    System.out.println("Product: "+(numInputs[0] * numInputs[1])); break;
                case '/':
                    System.out.println("Quotient: "+(numInputs[0] / numInputs[1])); break;
            }
            System.out.println("\nDo you want to continue? Y/N");
            flag = Character.toUpperCase(console.next().charAt(0));
        } while (!(flag=='N'));
    }
}