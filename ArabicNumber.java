
//класс работы с арабскими числами

public class ArabicNumber {
    private int [] number = new int [2];
    private char operation;
    private String inputDatas;

    public ArabicNumber (String inputDatas){
        this.inputDatas = inputDatas;
    }

    //метод разбивает входящуюю строку на слогаемые, вычисляет необходимую операцию
    // так же устанавлевает значения полю numbers

    public void findParametersOperation (){
        String [] arguments = {"-", "+", "*", "/"};
        String [] forNumb;
        for (int i = 0; i < arguments.length; i++){
            if ( inputDatas.contains( arguments[i] ) ) {
                operation = arguments[i].charAt(0);
                break;
            }
        }

        // System.out.println("op "+operation);
        if ( operation == '+'){
            forNumb = inputDatas.split("\\+", 2);

        } else {
            if ( operation == '*'){
                forNumb = inputDatas.split("\\*", 2);

            } else {
                forNumb = inputDatas.split(Character.toString(operation), 2);

            }
        }
        for ( int i = 0; i < forNumb.length; i++) {
            forNumb [i] = forNumb[i].trim();
            number [i] = Integer.parseInt( forNumb [i]);
        }

        // System.out.println("Param1= "+number[0]+" Oper= "+operation+" param2= "+number[1]);
    }

    //Вычисляет результат операции

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
                System.out.println("Unexpected Error! ");
                break;
            }
        }

    }
}
