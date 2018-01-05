public class Solution {
/*
 * Complete the function below.
 */

    static String[] circles(String[] info) {
        String[] result = new String[info.length];

        for (int i = 0; i < info.length; i++) {
            String line = info[i];

            String[] data = line.split(" ");

            try {
                int x1 = Integer.parseInt(data[0]);
                int y1 = Integer.parseInt(data[1]);
                int r1 = Integer.parseInt(data[2]);
                int x2 = Integer.parseInt(data[3]);
                int y2 = Integer.parseInt(data[4]);
                int r2 = Integer.parseInt(data[5]);

                if (x1 == x2 && y1 == y2) {
                    result[i] = "Concentric";
                }else {
                    int distance = x1 == 0 ? Math.abs(y2 - y1) : Math.abs(x2 - x1);
                    int d1 = r1 + r2;
                    int d2 = Math.abs(r1 - r2);

                    if (distance < d2) {
                        result[i] = "Disjointed-Inside";
                    }else if (distance == d2 || distance == d1) {
                        result[i] = "Touching";
                    }else if (distance > d1) {
                        result[i] = "Disjointed-Outside";
                    }else {
                        result[i] = "Intersecting";
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            int len = Integer.parseInt(args[0]);
            String[] info = new String[len];
            System.arraycopy(args, 1, info, 0, len);

            String[] result = circles(info);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}