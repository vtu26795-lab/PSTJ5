import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.print("Enter option (even/odd): ");
        String option = sc.next();

        int sum = 0;

        while(num > 0) {
            int digit = num % 10;

            if(option.equalsIgnoreCase("even") && digit % 2 == 0) {
                sum += digit;
            }
            else if(option.equalsIgnoreCase("odd") && digit % 2 != 0) {
                sum += digit;
            }

            num = num / 10;
        }

        System.out.println("Sum of " + option + " digits = " + sum);

        sc.close();
    }
}