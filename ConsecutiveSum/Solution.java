public class Solution {
/*
 * Complete the function below.
 */

    static int consecutive(long num) {
        int result = 0;
        long max = (long)Math.ceil((double)num / 2);
        for (long i=1; i<max; i++) {
            if (test(i, num)) {
                result++;
            }
        }
        return result;
    }

    static boolean test(long num, long target) {
        long sum = 0;
        System.out.println("testing");
        for (long i=num; i<target; i++) {
            System.out.println(i + " " + sum);
            sum += i;
            if (sum == target) {
                System.out.println("ok");
                return true;
            }else if (sum > target) {
                System.out.println("fail");
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            long num = Long.parseLong(args[0]);
            int result = consecutive(num);
            System.out.println(result);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}