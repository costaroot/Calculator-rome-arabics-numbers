
//класс работы с арабскими числами

public class RomeNumber {
    private int [] number = new int [2];
    private String [] romeNumber;
    private char operation;
    private String inputDatas;


    public RomeNumber (String inputDatas){
        this.inputDatas = inputDatas;
    }

    // Вычисляет результат операции, или выдает ошибку если формат римского числа не верный

    public void resultOperation (  ){
        int answer =0;
        switch (operation){
            case '+': {
                answer = number [0] + number[1];
                System.out.println("Answer= " + answer);
                break;
            }
            case '-': {
                answer = number [0] - number[1];
                System.out.println("Answer= " + answer);
                break;
            }
            case '*': {
                answer = number [0] * number[1];
                System.out.println("Answer= " + answer);
                break;
            }
            case '/': {
                if ( number[1] != 0) {
                    answer = number [0] / number[1];
                    System.out.println("Answer= " + answer);
                    break;
                } else
                    System.out.println("Error: Division by zero");
                break;
            }
             default: {
                 System.out.println("Yours Rome numbers are wrong! ");
                 break;
             }
        }

    }

    //метод приводит римское число в обычный вид, паралельно проверяет правильность
    // формата римского числа может переводить числа от 1 до 39
    //устанавлиеват полю number значения

    public void romeToArabic (){
        int sum = 0;
        int j = 0;
        while ( j < 2) {

            sum = 0;
            int oneCheck = 0, tenCheck = 0;
            boolean fiveCheck = false,multyOneCheck = false;
            for (int i = 0; i < romeNumber[j].length(); i++) {

                if ( romeNumber[j].charAt(i) == 'I' && romeNumber[j].length()-1 != i) {
                    if (romeNumber[j].charAt(i + 1) == 'V') {
                        sum += 4;
                        if ( oneCheck != 0)
                            multyOneCheck = true;
                        if ( romeNumber[j].length()-1 > i + 1 || fiveCheck || multyOneCheck )
                            operation = ' ';
                        break;
                    } else {
                        if (romeNumber[j].charAt(i + 1) == 'X') {
                            sum += 9;
                            if ( oneCheck != 0)
                                multyOneCheck = true;
                            if ( romeNumber[j].length()-1 > i + 1 || multyOneCheck )
                                operation = ' ';
                            break;
                        } else {
                            ++oneCheck;
                            if ( oneCheck > 1 )
                                multyOneCheck = true;
                        }
                    }
                } else {
                    if (romeNumber[j].charAt(i) == 'X'){
                        tenCheck += 10;

                    }
                    else {
                        if ( romeNumber[j].charAt(i) == 'V') {
                            sum += 5;
                            if ( fiveCheck )
                                operation = ' ';
                            fiveCheck = true;
                        }
                        else {
                            ++oneCheck;
                        }
                    }
                }
            }
            if ( oneCheck < 4 && tenCheck < 40 )
                number[j] = sum +oneCheck+tenCheck;
            else
                operation = ' ';

            ++j;
        }

        //System.out.println("Rome "+romeNumber[0]+" Result = "+ number[0]);
       // System.out.println("Rome "+romeNumber[1]+" Result = "+ number[1]);
    }

    //метод разбивает входящуюю строку на слогаемые, вычисляет необходимую операцию

    public void findParametersOperation (){
        String [] arguments = {"-", "+", "*", "/"};

        for (int i = 0; i < arguments.length; i++){
            if ( inputDatas.contains( arguments[i] ) ) {
                operation = arguments[i].charAt(0);
                break;
            }
        }

       // System.out.println("op "+operation);
        if ( operation == '+'){
            romeNumber = inputDatas.split("\\+", 2);

        } else {
            if ( operation == '*'){
                romeNumber = inputDatas.split("\\*", 2);

            } else {
                romeNumber = inputDatas.split(Character.toString(operation), 2);

            }
        }
        romeNumber [0] = romeNumber [0].trim();
        romeNumber [1] = romeNumber [1].trim();
        // System.out.println("Param1= "+romeNumber[0]+" Oper= "+operation+" param2= "+romeNumber[1]);
    }
}
