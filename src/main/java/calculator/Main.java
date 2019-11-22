package calculator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi!");
        System.out.println("Please, enter the first number:");

        Scanner in = new Scanner(System.in);
        int first = in.nextInt();

        System.out.println("Please, enter the second number");
        int second = in.nextInt();

        int sum = first + second;
        System.out.println("sum = " + sum);

        int subtr = first - second;
        System.out.println("Subtraction = " + subtr);

        int mult = first*second;
        System.out.println("Multiplication = " + mult);

        float div = (float)first / second;
        System.out.print("Division = "+ div);
    }

}
