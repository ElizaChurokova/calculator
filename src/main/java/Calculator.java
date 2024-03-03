import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа для калькулятора в одной строке, нужны пробелы между вводимыми данными: ");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Вывод: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input){
        String [] strings = input.split("\\s");
        if (strings.length !=3){
            throw new IllegalArgumentException("Введите в виде числа или римскими");
        }

        int number1 = convertNumber(strings[0]);
        int number2 = convertNumber(strings[2]);
        char ch = strings[1].charAt(0);

        int result = doOperate(number1, number2, ch);
        if (number1>=1 && number1<=10 && number2 >=1 && number2<=10){
            return convert(result, number1);
        }else {
            throw new IllegalArgumentException("Надо ввести числа только до 10");
        }
        }
       private static int convertNumber(String number){
           Map<String, Integer> rimNum = new HashMap<>();
           rimNum.put("I", 1);
           rimNum.put("II", 2);
           rimNum.put("III", 3);
           rimNum.put("IV", 4);
           rimNum.put("V", 5);
           rimNum.put("VI", 6);
           rimNum.put("VII", 7);
           rimNum.put("VIII", 8);
           rimNum.put("IX", 9);
           rimNum.put("X", 10);

         if(rimNum.containsKey(number)){
             return rimNum.get(number);
         }else{
             return Integer.parseInt(number);
         }
    }
    private static int doOperate(int number1, int number2, char ch){
        switch(ch){
            case '+' :
                return number1 + number2;
            case '-' :
                return number1 - number2;
            case '*' :
                return number1 * number2;
            case '/' :
                if(number2 == 0){
                    throw new ArithmeticException("Нельзя делить на 0");
                }
                return number1 / number2;
            default:
                throw new IllegalArgumentException("Неправильный ввод: " + ch);
        }
    }
    private static String convert(int result, int number1){
        if(number1>=1 && number1<=10){
            return Integer.toString(result);
        }else {
            throw new IllegalArgumentException("Введите числа толькр до 10");

        }
    }

}
