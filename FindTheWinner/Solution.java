import java.io.IOException;

public class Solution {
    /*
    * Complete the function below.
    */
    static String winner(int[] andrea, int[] maria, String s) {
        int andreaPts = 0;
        int mariaPts = 0;

        int start = "Odd".equals(s) ? 1 : 0;

        for (int i=start; i<andrea.length; i+=2) {
            andreaPts += andrea[i] - maria[i];
            mariaPts += maria[i] - andrea[i];
        }

        return andreaPts > mariaPts ? "Andrea" : mariaPts > andreaPts ? "Maria" : "TIE";
    }

    public static void main(String[] args) throws IOException {
        try {
            int aCount = Integer.parseInt(args[0]);
            int[] andrea = new int[aCount];
            for (int i=0; i<aCount; i++) {
                andrea[i] = Integer.parseInt(args[i + 1]);
            }
            int mCount = Integer.parseInt(args[aCount + 1]);
            int[] maria = new int[mCount];
            for (int i=0; i<mCount; i++) {
                maria[i] = Integer.parseInt(args[i + aCount + 2]);
            }
            String s = args[aCount+mCount+2];
            String result = winner(andrea, maria, s);

            System.out.println(result);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}