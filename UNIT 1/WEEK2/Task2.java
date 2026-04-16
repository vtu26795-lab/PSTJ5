import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    PerformOperation isOdd() {
        return new PerformOperation() {
            public boolean check(int a) {
                return a % 2 != 0;
            }
        };
    }

    PerformOperation isPrime() {
        return new PerformOperation() {
            public boolean check(int a) {
                if (a < 2) return false;
                for (int i = 2; i <= Math.sqrt(a); i++) {
                    if (a % i == 0)
                        return false;
                }
                return true;
            }
        };
    }

    PerformOperation isPalindrome() {
        return new PerformOperation() {
            public boolean check(int a) {
                int original = a;
                int reverse = 0;

                while (a > 0) {
                    int digit = a % 10;
                    reverse = reverse * 10 + digit;
                    a /= 10;
                }

                return original == reverse;
            }
        };
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {

        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int ch = Integer.parseInt(input[0]);
            int num = Integer.parseInt(input[1]);

            PerformOperation op;
            boolean ret;

            if (ch == 1) {
                op = ob.isOdd();
                ret = MyMath.checker(op, num);
                System.out.println(ret ? "ODD" : "EVEN");
            } 
            else if (ch == 2) {
                op = ob.isPrime();
                ret = MyMath.checker(op, num);
                System.out.println(ret ? "PRIME" : "COMPOSITE");
            } 
            else {
                op = ob.isPalindrome();
                ret = MyMath.checker(op, num);
                System.out.println(ret ? "PALINDROME" : "NOT PALINDROME");
            }
        }
    }
}