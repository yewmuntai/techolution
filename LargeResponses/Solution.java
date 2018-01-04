import java.io.*;

public class Solution {
    /*
    * Complete the function below.
    */

    public static void main(String[] args) throws IOException {
        try {
            String filename = args[0] + ".txt";

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();

            int count = 0;
            long total = 0;

            int i=0;
            while (line != null){
                i++;
                int idx = line.lastIndexOf(' ');
                long bytes = Long.parseLong(line.substring(idx+1).trim());
                if (bytes > 5000) {
                    count++;
                    total += bytes;
                }
                line = reader.readLine();
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter("bytes_"+filename));
            writer.write(count+"");
            writer.newLine();
            writer.write(total+"");
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}