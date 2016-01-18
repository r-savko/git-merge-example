import java.util.ArrayDeque;

public class Calculator {


    private static final char[] operators = {'+', '-', '*'};

    public static double calculate(String expression) {

        ArrayDeque<String> rpn = getRPN(expression);
        double result = 0;

        switch (rpn.pop()) {
            case "+":
                result = Double.parseDouble(rpn.pop()) + Double.parseDouble(rpn.pop());
                break;
            case "-":
                result = Double.parseDouble(rpn.pop()) - Double.parseDouble(rpn.pop());
                break;
            case "*":
                result = Double.parseDouble(rpn.pop()) * Double.parseDouble(rpn.pop());
                break;
            default:
                result = 0;
                break;
        }

        return result;

    }

    private static boolean isOperator(char c) {
        for (char o : operators) {
            if (o == c) return true;
        }
        return false;
    }

    private static ArrayDeque<String> getRPN(String expression) {
        ArrayDeque<String> rpn = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        char[] expSequence = expression.toCharArray();
        for (char c : expSequence) {
            if (isOperator(c)) {
                rpn.add(String.valueOf(c));
                rpn.add(builder.toString());
                builder.setLength(0);
            } else {
                if (c != ' ') builder.append(c);
            }
        }
        rpn.add(builder.toString());
        return rpn;
    }

}
