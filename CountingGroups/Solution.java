import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
/*
 * Complete the function below.
 */

    static int[] countGroups(int[][] matrix, int[] test) {
        int[] result = new int[test.length];
        Map<String, Integer> map = new HashMap<>();

        int mrow = matrix.length;
        int mcol = matrix[0].length;

        int grp = 0;
        int row = 0;
        int col = 0;
        int maxMapSize = mrow * mcol;

        while (row < mrow && map.size() < maxMapSize) {
            grp++;
            processGroup(matrix, map, grp, row, col, false);
            int[] nx = getNx(matrix, map, row, col);
            row = nx[0];
            col = nx[1];
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (Iterator<Integer> it = map.values().iterator(); it.hasNext(); ) {
            grp = it.next();
            int count = 0;
            if (map2.containsKey(grp)) {
                count = map2.get(grp);
            }
            map2.put(grp, count+1);
        }

        Map<Integer, Integer> map3 = new HashMap<>();
        for (Iterator<Integer> it = map2.values().iterator(); it.hasNext(); ) {
            Integer size = it.next();

            int count = 0;
            if (map3.containsKey(size)) {
                count = map3.get(size);
            }
            map3.put(size, count+1);
        }

        for (int i = 0; i < test.length; i++) {
            result[i] = map3.containsKey(test[i]) ? map3.get(test[i]) : 0;
        }

        return result;
    }

    static int[] getNx(int[][] matrix, Map<String, Integer> map, int row, int col) {
        int[] result = {row, col};
        int mcol = matrix[0].length;

        boolean found0 = false;
        while (!found0) {
            result = inc(result, mcol);
            found0 = checkMap(matrix, result[0], result[1], 0);
        }
        boolean found1 = false;
        while (!found1) {
            map.put(result[0]+""+result[1], 0);
            result = inc(result, mcol);

            found1 = checkMap(matrix, result[0], result[1], 1);
        }
        return result;
    }

    static int[] inc(int[] pos, int maxCol) {
        if (pos[1]+1 < maxCol) {
            pos[1]++;
        }else {
            pos[0]++;
            pos[1] = 0;
        }

        return pos;
    }

    static boolean checkMap(int[][] matrix, int row, int col, int val) {
        int mrow = matrix.length;

        boolean found = false;
        if (row < mrow) {
            found = matrix[row][col] == val;
        }else {
            found = true;
        }
        return found;
    }

    static void processGroup(int[][] matrix, Map<String, Integer> map, int grp, int row, int col, boolean replace) {
        if (map.containsKey(row+""+col)) {
            if (replace) {
                int old = map.get(row+""+col);
                if (old == grp) {
                    return;
                }
            }
            return;
        }

        int val = matrix[row][col];
        if (val == 0) {
            map.put(row+""+col, 0);
            return;
        }

        map.put(row+""+col, grp);

        if (col-1 >= 0) {
            processGroup(matrix, map, grp, row, col-1, replace);
        }
        int mcol = matrix[0].length;
        if (col+1 < mcol) {
            processGroup(matrix, map, grp, row, col+1, replace);
        }
        int mrow = matrix.length;
        if (row + 1 < mrow) {
            processGroup(matrix, map, grp, row+1, col, replace);
        }
        if (row-1 >= 0) {
            processGroup(matrix, map, grp, row-1, col, true);
        }
    }

    public static void main(String[] args) {
        try {
            int row = Integer.parseInt(args[0]);
            int col = Integer.parseInt(args[1]);

            int max = row + 2;
            int[][] matrix = new int[row][col];
            for (int i=2; i<max; i++) {
                String rowData = args[i];
                String[] rowArr = rowData.split(" ");
                int[] data = new int[rowArr.length];
                for (int x=0; x<rowArr.length; x++) {
                    data[x] = Integer.parseInt(rowArr[x]);
                }
                matrix[i-2] = data;
            }
            int testCount = Integer.parseInt(args[row + 2]);
            int[] tests = new int[testCount];
            for (int i=0; i<testCount; i++) {
                tests[i] = Integer.parseInt(args[row + i + 3]);
            }

            int[] result = countGroups(matrix, tests);

            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}