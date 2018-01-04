import java.io.IOException;

public class Solution {
    /*
    * Complete the function below.
    */
    static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
        int[] result = new int[lowerLimits.length];

        for (int i=0; i<lowerLimits.length; i++) {
            int count = 0;
            int lower = lowerLimits[i];
            int upper = upperLimits[i];
            for (int x=0; x<scores.length; x++) {
                int score = scores[x];
                if (score >= lower && score <= upper) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        try {
            int scoreCount = Integer.parseInt(args[0]);
            int[] scores = new int[scoreCount];
            for (int i=0; i<scoreCount; i++) {
                scores[i] = Integer.parseInt(args[i + 1]);
            }
            int lCount = Integer.parseInt(args[scoreCount + 1]);
            int[] lowerLimits = new int[lCount];
            for (int i=0; i<lCount; i++) {
                lowerLimits[i] = Integer.parseInt(args[i + scoreCount + 2]);
            }
            int uCount = Integer.parseInt(args[lCount + scoreCount + 2]);
            int[] upperLimits = new int[uCount];
            for (int i=0; i<uCount; i++) {
                upperLimits[i] = Integer.parseInt(args[i + scoreCount + lCount + 3]);
            }

            int[] result = jobOffers(scores, lowerLimits, upperLimits);
            for (int i=0; i<result.length; i++) {
                System.out.println(result[i]);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}