public class Task4 {
    public static void main(String[] args) {

        int[] arr = {12, 45, 67, 23, 89, 34};

        int max = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Maximum element is: " + max);
    }
}