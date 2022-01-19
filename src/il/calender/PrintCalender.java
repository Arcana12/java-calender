package il.calender;

import java.util.Scanner;

public class PrintCalender {

    public void runCalender(){
        Scanner scanner = new Scanner(System.in);
        Calender cal = new Calender();

        while(true) {
            System.out.println("연도를 입력해주세요");
            int year = scanner.nextInt();
            System.out.println("달을 입력해주세요");
            int month = scanner.nextInt();

            if (month == -1) {
                break;
            }
            if (month>12){
                System.out.println("다시 입력해주세요");
                continue;
            }

            cal.printCalender(year, month);
        }
    }

    public static void main(String[] args) {
        PrintCalender p = new PrintCalender();
        p.runCalender();
    }
}
