import java.io.IOException;

public class Solution {
    /*
    * Complete the function below.
    */
    static int minNum(int A, int K, int P) {
        int diff = K - A;

        if (diff <= 0) {
            return -1;
        }

        int result = (int)Math.ceil((double)P / diff);

        if (P % diff == 0) {
            result++;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        try {
            int asha = Integer.parseInt(args[0]);
            int kelly = Integer.parseInt(args[1]);
            int difference = Integer.parseInt(args[2]);

            int result = minNum(asha, kelly, difference);

            System.out.println(result);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}