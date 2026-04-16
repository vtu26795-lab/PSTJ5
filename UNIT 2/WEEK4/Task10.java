import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            int top = layer;
            int bottom = m - 1 - layer;
            int left = layer;
            int right = n - 1 - layer;

            // top row
            for (int i = left; i <= right; i++)
                elements.add(matrix.get(top).get(i));

            // right column
            for (int i = top + 1; i <= bottom - 1; i++)
                elements.add(matrix.get(i).get(right));

            // bottom row
            for (int i = right; i >= left; i--)
                elements.add(matrix.get(bottom).get(i));

            // left column
            for (int i = bottom - 1; i >= top + 1; i--)
                elements.add(matrix.get(i).get(left));

            int size = elements.size();
            int rotation = r % size;

            // Rotate anti-clockwise
            List<Integer> rotated = new ArrayList<>();
            rotated.addAll(elements.subList(rotation, size));
            rotated.addAll(elements.subList(0, rotation));

            int index = 0;

            // put back top row
            for (int i = left; i <= right; i++)
                matrix.get(top).set(i, rotated.get(index++));

            // right column
            for (int i = top + 1; i <= bottom - 1; i++)
                matrix.get(i).set(right, rotated.get(index++));

            // bottom row
            for (int i = right; i >= left; i--)
                matrix.get(bottom).set(i, rotated.get(index++));

            // left column
            for (int i = bottom - 1; i >= top + 1; i--)
                matrix.get(i).set(left, rotated.get(index++));
        }

        // Print matrix
        for (List<Integer> row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
