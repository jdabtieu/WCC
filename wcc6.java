import java.util.*;
import java.io.*;

public class wcc6 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        boolean encrypt = readLine().equals("encrypt");
        char[] l = readLine().toCharArray();
        if (encrypt) {
            for (int i = 0; i < l.length; i++) {
                int j = i + 1;
                l[i] = (char) ((l[i] + ((j & 1) == 1 ? -j + 95 : j) + 63) % 95 + 32);
            }
        } else {
            for (int i = 0; i < l.length; i++) {
                int j = i + 1;
                l[i] = (char) ((l[i] + ((j & 1) == 1 ? j : -j + 95) + 63) % 95 + 32);
            }
        }
        System.out.println(new String(l));
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
