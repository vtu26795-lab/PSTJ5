import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {10, 20, 30, 40, 50, 60};

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int left = 0, right = arr.length - 1;
        boolean found = false;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == key) {
                System.out.println("Element found at index: " + mid);
                found = true;
                break;
            }
            else if(arr[mid] < key) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        if(!found)
            System.out.println("Element not found");

        sc.close();
    }
}