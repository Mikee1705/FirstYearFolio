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
    static char operator, response;
    static boolean flag;
    static Scanner console = new Scanner(System.in);
    static double[] numInputs = new double[2];
    
    public static void main(String[] args) {
        System.out.println("\t My First Calculator App");
        System.out.println("\t VERSION 1\n");
        do
        {
            getOperator();
            getNumbers();
            arithmeticOperation(operator, numInputs);
        } while (!(programRetry()==false));
    }
    
    //Gets user input, return char operator
    public static char getOperator()
    {
         do 
            {            
                System.out.println("Enter operator (+ - / % *)");
                operator = console.next().charAt(0);
            } while (!(operator=='+'||operator=='-'||operator=='/'||operator=='%'||operator=='*'));
         return operator;
    }
    
    public static double [] getNumbers()
    {
         System.out.println("\nEnter 2 numbers: ");
            for(int i=0; i<numInputs.length;i++)
            {
                System.out.printf("Value #%d: ",i+1);
                numInputs[i] = console.nextDouble();
            }
        return numInputs;
    }
    
    //Outputs the operation
    public static void arithmeticOperation(char operator, double [] numInputs)
    {
        switch (operator) 
            {
                case '+':
                    System.out.println("Sum: "+addition(numInputs[0],numInputs[1])); break;
                case '-':
                    System.out.println("Difference: "+subtraction(numInputs[0],numInputs[1])); break;
                case '*':
                    System.out.println("Product: "+multiplication(numInputs[0],numInputs[1])); break;
                case '/':
                    division(numInputs[0], numInputs[1]); break;
                    //Add warning for division by Zero
                case '%':
                    System.out.println("Remainder: "+modulo(numInputs[0],numInputs[1])); break;
            }
    }
    
    //Arithmetic Operations
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
    
    public static void division(double num1, double num2)
    {
        if(num2==0)
            System.out.println("Division by Zero is not allowed!");
        else 
            System.out.println("Division: "+(num1/num2));
    }
    
    public static double modulo(double num1, double num2)
    {
        return num1%num2;
    }
    
    //method for program continuation, gets char input, returns boolean 
    public static boolean programRetry()
    {
        do
            {
                System.out.println("\nDo you want to continue? Y/N");
                response = Character.toUpperCase(console.next().charAt(0));
                if(response=='Y')
                    flag = true;
                else
                {
                    flag= false;
                    System.out.println("Program Terminated!");
                }
            } while (!(response=='Y'||response=='N'));
        return flag;
    }
}