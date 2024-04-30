import java.util.Stack;

// Main class should be named 'Solution' and should not be public.
class ExpressionEval {

    public static boolean hasPresidance(char op1, char op2) {
        // 4 * 2 / 2
        if( (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-' ) ) {
            return false;
        }
        return true;
    }

    public static int applyOperator(char operator, int first, int second) {
        switch(operator) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                if(second == 0) {
                    //throws exception;
                    return 0;
                }
                return first / second;
        }
        return 0;

    }

    public static int evaluate(String expression) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i = 0; i < expression.length(); i ++) {
            char c = expression.charAt(i);
            if(c ==' ') continue;
            if(Character.isDigit(c)) {
                // Double number = 0.0;
                StringBuilder sb = new StringBuilder();
                while( i < expression.length() && i != ' ' && (Character.isDigit(expression.charAt(i)))) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                numbers.push(Integer.parseInt(sb.toString()));
                i--;
            } else if(c == '+' || c =='-' || c == '/' || c =='*') {
                while(!operators.isEmpty() && hasPresidance(c, operators.peek())) {
                    numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(c);
            }
        }

        while(!operators.isEmpty()) {
            int first = numbers.pop();
            int second = numbers.pop();
            numbers.push(applyOperator(operators.pop(), second, first));
        }
        return numbers.pop();
    }
    public static void main(String[] args) {
        System.out.println("Hello, World");

        String expression = "10 * 2 - 2";
        System.out.print(evaluate(expression));
    }
}


