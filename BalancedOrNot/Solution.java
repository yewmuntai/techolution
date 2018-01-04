public class Solution {
/*
 * Complete the function below.
 */

    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        int len = expressions.length;
        int[] result = new int[len];
        for (int i=0; i<len; i++) {
            result[i] = replace(expressions[i], maxReplacements[i]);
        }
        return result;
    }

    static int replace(String expr, int maxRep) {
        int count = 0;
        int len = expr.length();
        for (int i=0; i<len; i++) {
            char ch = expr.charAt(i);
            if (ch == '<') {
                count ++;
            }else {
                if (maxRep == 0) {
                    return 0;
                }
                maxRep --;
                count --;
            }
        }
        return count == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        try {
            int expCount = Integer.parseInt(args[0]);
            String[] exprs = new String[expCount];
            System.arraycopy(args, 1, exprs, 0, expCount);

            int maxRepCount = Integer.parseInt(args[expCount + 1]);
            int[] maxReps = new int[maxRepCount];
            for (int i=0; i<maxRepCount; i++) {
                maxReps[i] = Integer.parseInt(args[i + expCount + 2]);
            }
            int[] result = balancedOrNot(exprs, maxReps);
            
            for (int i=0; i<result.length; i++) {
                System.out.println(result[i]);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}