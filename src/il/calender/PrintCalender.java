package il.calender;

import java.util.Locale;
import java.util.Scanner;

public class PrintCalender {

    public void runCalender(){
        Scanner scanner = new Scanner(System.in);
        Calender cal = new Calender();
        boolean onLoop = true;

        while(onLoop) {
            printMenu();

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> calSchedule(scanner, cal);
                case "2" -> calSearch(scanner, cal);
                case "3" -> printCal(scanner, cal);
                case "h" -> System.out.println("도움말");
                case "q" -> {
                    System.out.println("종료합니다");
                    onLoop = false;
                }
            }
        }
    }

    public void printMenu(){
        System.out.println("+ㅡㅡㅡㅡㅡㅡㅡㅡㅡ+");
        System.out.println("| 1. 일정 등록");
        System.out.println("| 2. 일정 검색");
        System.out.println("| 3. 달력 보기");
        System.out.println("| h. 도움말");
        System.out.println("| q. 종료       ");
        System.out.println("+ㅡㅡㅡㅡㅡㅡㅡㅡㅡ+");
        System.out.println("키를 입력해주세요");
    }


    private void calSchedule(Scanner s, Calender c){
        System.out.println("날짜를 입력해주세요");
        System.out.println("예)yyyy-MM-dd");
        String date = s.nextLine();

        System.out.println("일정을 입력해 주세요");
        String plan = s.nextLine();
        c.calPlan(date, plan);
    }

    private void calSearch(Scanner s, Calender c){
        System.out.println("일정을 확인할 날짜를 입력해주세요");
        System.out.println("예)yyyy-MM-dd");
        String date = s.nextLine();
        String plan = c.searchPlan(date);
        System.out.println(plan);
    }

    private void printCal(Scanner scanner, Calender c){

        System.out.println("연도를 입력해주세요");
        int year = scanner.nextInt();

        System.out.println("달을 입력해주세요");
        int month = scanner.nextInt();


        if (month>12 || month<1){
            System.out.println("다시 입력해주세요");
            return;
        }

        c.printCalender(year, month);
    }

    public static void main(String[] args) {
        PrintCalender p = new PrintCalender();
        p.runCalender();

    }

}
