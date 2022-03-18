public class Calculator  {
    private String[] array;
    private int num1;
    private String operator;
    private int num2;
    private boolean flag;
    RomeToArabian romanArray = new RomeToArabian();


    public Calculator(String str1) throws CalcException {
        this.array = str1.split(" ");
        if (array.length != 3) {
            throw new CalcException("Формат математической операции не удовлетворяет заданию");
        }
        try {

            if (romanArray.chekRomanNamber(array[0]) && romanArray.chekRomanNamber(array[2])) {
                num1 = romanArray.convertRomToNum(array[0]);
                num2 = romanArray.convertRomToNum(array[2]);
                flag = true;


            } else {
                num1 = Integer.parseInt(array[0]);
                num2 = Integer.parseInt(array[2]);
            }
        }catch (NumberFormatException e) {
            System.out.println("Используются одновременно разные системы исчисления");
        }

    }




    public String calc() throws CalcException {
        if ((num1 > 10 || num1 < 1) || (num2 > 10 || num2 < 1)) {
            throw new CalcException("Калькулятор должен принимать на вход числа от 1 до 10 включительно, либо римские от I до X, не более.");
        }

        operator = array[1];

        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new CalcException("Не верный знак операции " + operator);
        }
        if (!flag) {
            return String.valueOf(result);
        } else {
            String res =  romanArray.convertNumToRom(result);
            return res;
        }
    }


}

