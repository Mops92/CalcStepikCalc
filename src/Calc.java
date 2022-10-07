import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// это типа калькулятор
public class Calc {
    public static void main(String[] args) throws FileNotFoundException, NumberFormatException, Exception {

        File input = new File("C:\\Users\\SuperUser\\Desktop\\input.txt");
        Scanner sc = new Scanner(input);
        File output = new File("C:\\Users\\SuperUser\\Desktop\\output.txt");
        PrintWriter printWriter = new PrintWriter(output); // этот должен записывать в файл
        while(sc.hasNextLine()) { //цикл читает исходный файл построчно, метод hasNextLine() проверяет файл на наличие следующей строки.
            String line = sc.nextLine();




            double a = 0.0;
            double b = 0.0;
            char znak = ' ';
            int m = 0;
            boolean is = true;



            for (String num : line.split(" ")) {
                m++;


                if (m == 1) {
                    try {
                        a = Double.valueOf(num);


                    } catch (NumberFormatException e) {
                        System.out.println(a + " " +znak+" " + b + " = " + "Error! Not number");
                        printWriter.println(a + " " +znak+" " + b + " = " + "Error! Not number");

                        is = false;
                        break;
                    }
                }
                if (m == 3) {
                    try {
                        b = Double.valueOf(num);
                    } catch (NumberFormatException e) {
                        System.out.println(a + " " +znak+" " + b + " = " + "Error! Not number");
                        printWriter.println(a + " " +znak+" " + b + " = " + "Error! Not number");

                        is = false;
                        break;
                    }
                }
            }
            if (is) {
                m = 0;
                for (String num : line.split(" ")) {
                    m++;
                    if (m == 2) {
                        try {
                            znak = result(num, znak);
                        } catch (Exception s) {
                            System.out.println(a + " " +znak+" " + b + " = " + "Operation Error!");
                            printWriter.println(a + " " +znak+" " + b + " = " + "Operation Error!");

                            is = false;
                            break;
                        }
                    }
                }
            }
            if (is) {
                switch (znak) {
                    case ('+'):
                        String s = a + " " +znak+" " + b + " = " + (a + b);
                        System.out.println(s);
                        printWriter.println(s);


                        break;
                    case ('-'):
                        String st = a + " " +znak+" " + b + " = " + (a - b);
                        System.out.println(st);
                        printWriter.println(st);


                        break;
                    case ('/'):
                        String str = a + " " +znak+" " + b + " = " + (a / b);
                        if (b == 0.0) {
                            System.out.println(a + " " +znak+" " + b + " = " + "Error! Division by zero");
                            printWriter.println(a + " " +znak+" " + b + " = " + "Error! Division by zero");


                        }
                        else System.out.println(str);
                        printWriter.println(str);


                        break;
                    case ('*'):
                        String strng = a + " " +znak+" " + b + " = " + (a * b);
                        System.out.println(strng);
                        printWriter.println(strng);


                        break;
                }
            }

        }
        sc.close();
        printWriter.close();

    }
    public static char result(String nms, char znak) throws Exception {


        if(nms.equals("/") || nms.equals("*") || nms.equals("+") || nms.equals("-")) {
            znak = nms.charAt(0);
            return znak;
        }
        else throw new Exception("OperationError");

    }
}
