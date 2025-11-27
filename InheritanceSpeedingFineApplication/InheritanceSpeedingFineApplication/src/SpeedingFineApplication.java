import java.util.Scanner;
public class SpeedingFineApplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the person name: ");
        String person = scan.nextLine();
        System.out.print("Enter the speed: ");
        int speed = scan.nextInt();
        System.out.println("********************************");
        SpeedingFines fines = new SpeedingFines(person, speed);
        fines.PrintFine();
        System.out.println("********************************");
     }
}