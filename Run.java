import java.util.Scanner;

public class Run {

    public static void main(String[] strings) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter simple expression ex. 12 + 5:");
        String expression = scanner.nextLine();
        double result = Calculator.calculate(expression);
        System.out.println("Result = " + result);
    }

}
