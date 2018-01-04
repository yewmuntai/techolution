public class Solution {
/*
 * Complete the function below.
 */

    static long waitingTime(int[] tickets, int p) {
        long result = buyTicket(tickets, p, 0l);
        return result;
    }

    static long buyTicket(int[] tickets, int pos, long time) {
        int current = tickets[0];
        System.out.println(toString(tickets));
        System.out.println(current + " " + pos + ' ' + time);
        System.out.println("-----------");
        time++;
        if (pos == 0) {
            if (current == 1) {
                return time;
            }
            pos = tickets.length-1;
        }else {
            pos--;
        }
        int newSize = tickets.length;
        if (current == 1) {
            newSize--;
        }
        int[] newOrder = new int[newSize];
        System.arraycopy(tickets, 1, newOrder, 0, tickets.length - 1);
        if (current > 1) {
            newOrder[tickets.length-1] = current - 1;
        }
        return buyTicket(newOrder, pos, time);
    }

    private static String toString(int[] tickets) {
        StringBuffer sb = new StringBuffer();
        sb.append(tickets[0]);
        for (int i=1; i< tickets.length; i++) {
            sb.append(", ").append(tickets[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            int ticCount = Integer.parseInt(args[0]);
            int[] tics = new int[ticCount];
            for (int i=0; i<ticCount; i++) {
                tics[i] = Integer.parseInt(args[i + 1]);
            }
            int pos = Integer.parseInt(args[ticCount + 1]);
            long result = waitingTime(tics, pos);
            
            System.out.println(result);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}