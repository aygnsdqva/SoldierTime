/* This code is intended for those who have 1 year of military service. */
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String name;
        String surname ;
        String leftDate;
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome , Please enter soldier's information");
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        System.out.println("Enter name :");
        name = sc.nextLine();
        System.out.println("Enter surname :");
        surname= sc.nextLine();
        System.out.println("Now enter the day "+ name + " "+ surname + " went to the military  ");
        System.out.println("Please enter : (yyyy-mm-dd) format");
        leftDate=sc.next();
        LocalDate lt=LocalDate.parse(leftDate);
        LocalDate nextDay=lt.plusYears(1);
        System.out.println("It will be with you on " + nextDay);
        //Past
        LocalDate now= LocalDate.now();
        long pastDay= (now.getDayOfYear() - lt.getDayOfYear() + 1);
        if(pastDay>0) {
            System.out.println("Already " + pastDay + " days have passed");
        } else if (pastDay<0) {
            pastDay=pastDay(lt , now);
        }
        //Left
        long leftDay= (365-pastDay);
        System.out.println("Already " + leftDay + " left ");
        //Vacation
        LocalDate vacation = lt.plusMonths(6);
        Month vacationMonth = vacation.getMonth();
        System.out.println("He will go on vacation in "+ vacationMonth);

    }
    private static long pastDay(LocalDate date,LocalDate now) {
        String newYear = "2022-12-31";
        String januaryOne = "2023-01-01";
        LocalDate newYearDate = LocalDate.parse(newYear);
        LocalDate januaryOneDate = LocalDate.parse(januaryOne);
        long step1 = (newYearDate.getDayOfYear() - date.getDayOfYear() + 1) ;
        long step2 = (now.getDayOfYear() - januaryOneDate.getDayOfYear() + 1);
        long step3 = step1 + step2;
        System.out.println("There are still " + step3 + " days left");
        return step3;
    }

}