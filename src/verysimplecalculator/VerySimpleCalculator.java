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
        
            System.out.println("\nEnter 2 numbers: ");
            for(int i=0; i<numInputs.length;i++)
            {
                System.out.printf("Value #%d: ",i+1);
                numInputs[i] = console.nextDouble();
            }
        
            switch (operator) 
            {
                case '+':
                    System.out.println("Sum: "+addition(numInputs[0],numInputs[1])); break;
                case '-':
                    System.out.println("Difference: "+subtraction(numInputs[0],numInputs[1])); break;
                case '*':
                    System.out.println("Product: "+multiplication(numInputs[0],numInputs[1])); break;
                case '/':
                    System.out.println("Quotient: "+division(numInputs[0],numInputs[1])); break;
                case '%':
                    System.out.println("Remainder: "+modulo(numInputs[0],numInputs[1]));
            }
            //checks if user wants to continue.
            do
            {
                System.out.println("\nDo you want to continue? Y/N");
                flag = Character.toUpperCase(console.next().charAt(0));
            } while (!(flag=='Y'||flag=='N'));
        } while (!(flag=='N'));
    }
    
    public static double addition(double num1, double num2)
    {
        return num1+num2;
    }
    
    public static double subtraction(double num1, double num2)
    {
        return num1-num2;
    }
    
    public static double multiplication(double num1, double num2)
    {
        return num1*num2;
    }
    
    public static double division(double num1, double num2)
    {
        return num1/num2;
    }
    
    public static double modulo(double num1, double num2)
    {
        return num1%num2;
    }
}