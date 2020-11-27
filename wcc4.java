import java.util.*;
import java.io.*;

public class wcc4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    final static int[] days = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public static void main(String[] args) throws IOException {
        int d = 1, y = 1900, count = 0;
        for (int m = 1; m < 13; m++) {
            if (m == 2) d += leap(y) ? 29 : 28;
            else d += days[m];
            d %= 7;
        }
        while (++y <= 2000) for (int m = 1; m < 13; m++) {
            if (m == 2) d += leap(y) ? 29 : 28;
            else d += days[m];
            d %= 7;
            if (d == 0) count++;
        }
        System.out.println(count);
    }
    
    static boolean leap(int y) {
        return y % 400 == 0 || y % 4 == 0 && y % 100 != 0; 
    }

    static String next() throws IOException {
        while (in == null || !in.hasMoreTokens())
            in = new StringTokenizer(br.readLine());
        return in.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine();
    }
}