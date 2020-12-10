import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int operand1 = getInt();
        int operand2 = getInt();
        char operation = getOperation();
        int result = calc (operand1, operand2, operation);
        System.out.println("Результат вычисления: " + result);
    }

    private static int getInt() {
        System.out.println("Введите любое число: ");
        int number;
        if(scanner.hasNextInt()){
            number = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            number = getInt();
        }
        return number;
    }

    private static char getOperation() {
        System.out.println("Введите операцию (+, -, * или /):");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    private static int calc(int operand1, int operand2, char operation) {
        int result;
        switch (operation){
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            default:
                System.out.println("Неподходящая операция. Необходимо указать: +, -, * или /");
                result = calc(operand1, operand2, getOperation());
        }
        return result;
    }
}