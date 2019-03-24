import com.sun.org.apache.regexp.internal.CharacterArrayCharacterIterator;
// подключаем библиотеки для работы с потоками ввода/вывода
import java.util.Scanner;
import java.io.*;

//  Главный класс с методом main()
public class CalculatorMain {
    public static void main (String [] args) {

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter Rome or Arabic number in formats (Num1 operation Num2) and press 'Enter'");
            String inputLine = new String(scan.nextLine());
            inputLine = inputLine.trim();

            if (SearchSolution.checksData(inputLine)) {

                //System.out.println("You entered: Right Datas");
                SearchSolution.findSolve(inputLine);

            } else {
                System.out.println("You entered: Wrong Datas");
                continue;
            }

            System.out.println("If you want exit please press 'n', for continue press Any other key. After press'Enter'");

            char key = scan.next().charAt(0);
            if ( key == 'N' || key == 'n' )
                break;


        }
    }
}
