import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Калькулятор умеет работать только с целыми числами. Арабскими и римскими от 1 до 10.");
        try {

            Scanner scan = new Scanner(System.in);
            String str1 = scan.nextLine();

            Calculator calcApp = new Calculator(str1);
            System.out.println(calcApp.calc());
        } catch (CalcException e) {

        }
    }
}
