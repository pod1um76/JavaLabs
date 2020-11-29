import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook
{
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
        HashMap<String,String> namesAndNumbers = new HashMap<>();
        String[] lineArr;
        String[] fio;
        String numb;
        String str = "";
        int it = 0;
        String aLine = "";
        boolean check = false;
        boolean checkN = true;

        System.out.println("Для выхода из программы введите - EXIT");

        String line = read.nextLine();

        while (!line.equals("EXIT"))
        {
            lineArr = line.split(" ");

            if (lineArr[0].equals("LIST") && lineArr.length == 1)
            {
                if (lineArr.length == 1)
                    for(Map.Entry<String, String> entry: namesAndNumbers.entrySet())
                    {
                        System.out.println(entry.getValue() + "\n" + entry.getKey() + "\n");
                    }
                else
                    System.out.println("Неизвестная команда.");
            }
            else if(((lineArr[0].charAt(0) >= 'А' && lineArr[0].charAt(0) <= 'Я') || (lineArr[0].charAt(0) >= 'а' && lineArr[0].charAt(0) <= 'я')) && lineArr.length <= 3)
            {
                it = 0;
                fio = lineArr;
                str = "";
                check = false;
                for(int i = 0; i < fio.length; i++)
                {
                    for (int j = 0; j < fio[i].length(); j++)
                    {
                        if ((fio[i].charAt(j) < 1040 || fio[i].charAt(j) > 1103) && fio[i].charAt(j) != 45 || fio[i].charAt(i) > 47 && fio[i].charAt(i) < 58)
                        {
                            check = true;
                            j = fio[i].length();
                            i = fio.length;
                        }
                    }
                    str += fio[i] + " ";
                }
                if(!check)
                {
                    System.out.println("Введите номер абонента");
                    numb = read.nextLine();
                    aLine = "";
                    while (checkN)
                    {
                        checkN = false;
                        for(int i = 0; i < numb.length();i++)
                        {
                            if (numb.charAt(i) > 47 && numb.charAt(i) < 58)
                            {
                                it++;
                                aLine += numb.charAt(i);
                            }
                            else if (numb.charAt(i) != '-' && numb.charAt(i) != '(' && numb.charAt(i) != ')' && numb.charAt(i) != '+' && numb.charAt(i) != ' ') {
                                System.out.println("Введен неправильный формат номера. Повторите попытку");
                                checkN = true;
                                break;
                            }
                        }
                    }

                    if(it == 10) {
                        aLine = "+" + 7 + " (" + aLine.substring(0, 3) + ") " + aLine.substring(3, 6) + "-" + aLine.substring(6, 8) + "-" + aLine.substring(8, 10);
                        namesAndNumbers.put(aLine, str);
                        System.out.println("Добавлено");
                    }
                    else if (it == 11 && (aLine.charAt(0) == '7' || aLine.charAt(0) == '8')) {
                        aLine = "+" + 7 + " (" + aLine.substring(1, 4) + ") " + aLine.substring(4, 7) + "-" + aLine.substring(7, 9) + "-" + aLine.substring(9, 11);
                        namesAndNumbers.put(aLine, str);
                        System.out.println("Добавлено");
                    }
                }
                else
                    System.out.println("Введен неверный формат имени. Повторите попытку");
            }
            else if(lineArr[0].charAt(0) > 47 && lineArr[0].charAt(0) < 58 || line.charAt(0) == '-' || line.charAt(0) == '(' || line.charAt(0) == ')' || line.charAt(0) == '+' || line.charAt(0) == ' ')
            {
                aLine = "";
                str = "";
                it = 0;
                checkN = false;
                for(int i = 0; i < line.length();i++)
                {
                    if (line.charAt(i) > 47 && line.charAt(i) < 58)
                    {
                        it++;
                        aLine += line.charAt(i);
                    }
                    else if (line.charAt(i) != '-' && line.charAt(i) != '(' && line.charAt(i) != ')' && line.charAt(i) != '+' && line.charAt(i) != ' ') {
                        System.out.println(it);
                        checkN = true;
                        System.out.println("Введен неправильный формат номера. Повторите попытку");
                        break;
                    }
                }

                if(!checkN && (it == 10 || it == 11))
                {
                    System.out.println("Введите имя абонента");
                    line = read.nextLine();
                    fio = line.split(" ");

                    check = true;

                    while(check)
                    {
                        check = false;
                        if (fio.length <= 3 && fio.length >= 1)
                        {
                            for (int i = 0; i < fio.length; i++)
                            {
                                for (int j = 0; j < fio[i].length(); j++)
                                {
                                    if ((fio[i].charAt(j) < 1040 || fio[i].charAt(j) > 1103) && fio[i].charAt(j) != '-')
                                    {
                                        check = true;
                                        j = fio[i].length();
                                        i = fio.length;
                                        System.out.println("Введен неверный формат имени. Повторите попытку");
                                    }
                                }
                                str += fio[i] + " ";
                            }
                        }
                    }

                    if(it == 10) {
                        aLine = "+" + 7 + " (" + aLine.substring(0, 3) + ") " + aLine.substring(3, 6) + "-" + aLine.substring(6, 8) + "-" + aLine.substring(8, 10);
                        namesAndNumbers.put(aLine, str);
                        System.out.println("Добавлено");
                    }
                    else if (it == 11 && (aLine.charAt(0) == '7' || aLine.charAt(0) == '8')) {
                        aLine = "+" + 7 + " (" + aLine.substring(1, 4) + ") " + aLine.substring(4, 7) + "-" + aLine.substring(7, 9) + "-" + aLine.substring(9, 11);
                        namesAndNumbers.put(aLine, str);
                        System.out.println("Добавлено");
                    }

                }
                else
                    System.out.println("Введен неверный формат номера. Повторите попытку");
            }
            else
                System.out.println("Неизвестная команда");

            line = read.nextLine();
        }
    }
}