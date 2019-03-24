// Класс для проверки формата ввода,

public class SearchSolution {
    private static boolean rome;
    private static boolean arabic;

    // статический метод checksData проверяет правильность формата введенных данных

    public static boolean checksData (String checkLine){
        rome = false;
        arabic = false;

        if ( checkLine.length() == 0 || checkLine.charAt(0) == '/' || checkLine.charAt(0) == '*'
                || checkLine.charAt(0) == '-' || checkLine.charAt(0) == '+'
                || checkLine.charAt(checkLine.length()-1) == '*'
                || checkLine.charAt(checkLine.length()-1) == '/'
                || checkLine.charAt(checkLine.length()-1) == '-'
                || checkLine.charAt(checkLine.length()-1) == '+')
            return false;
        else {
            char buf;

            for (int i = 0; i < checkLine.length(); i++){
                buf = checkLine.charAt(i);
                if (Character.isDigit(buf) || Character.isWhitespace(buf) || buf == 'X'
                    || buf == 'V' || buf == 'I'|| buf == '+'|| buf == '-'|| buf == '*'|| buf == '/'){
                    if ( Character.isDigit(buf))
                        arabic = true;
                    if ( buf == 'X' || buf == 'V' || buf == 'I' )
                        rome = true;
                }else{
                    return false;
                }
            }
        }
        if ( rome && arabic )
            return false;
        else
            return true;
    }

    // метод определения типа чисел для работы, а так же вычисляет результат
    public static void findSolve (String inputDatas){
       // System.out.println("You are used Rome number: "+rome);
        if ( rome ){

            RomeNumber var = new RomeNumber(inputDatas);
            var.findParametersOperation();
            var.romeToArabic();
            var.resultOperation();
        } else {
            ArabicNumber var = new ArabicNumber(inputDatas);
            var.findParametersOperation();
            var.resultOperation();

        }


    }

}
