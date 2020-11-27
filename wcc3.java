import java.util.*;
import java.io.*;

public class wcc3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int cities = readInt(), fuel = readInt();
        Pair[] values = new Pair[cities];
        for (int i = 0; i < cities; i++) {
            values[i] = new Pair(readInt(), readInt());
        }
        Arrays.sort(values);
        int[] l = new int[201];
        int ptr = 0;
        for (int i = 1; i < 201; i++) {
            if (ptr < values.length && values[ptr].x + 100 == i) {
                l[i] = l[i - 1] + values[ptr++].y;
            } else {
                l[i] = l[i - 1];
            }
        }
        int max = 0;
        ArrayList<Integer> maxPath = new ArrayList<Integer>() {{ add(0); }};
        for (int i = 0; i <= Math.min(100, fuel); i++) {
            if (100 - fuel + 2 * i - 1 > 100) break;
            int tmp = (100 - fuel + 2 * i - 1) >= 0 ? l[100 + i] - l[100 - fuel + 2 * i - 1] : l[100 + i];
            if (tmp > max) {
                max = tmp;
                maxPath = new ArrayList();
                ptr = 0;
                while (values[ptr].x < 0) ptr++;
                for (int j = ptr; j < values.length && values[j].x <= i; j++) maxPath.add(values[j].x);
                for (int j = ptr - 1; j >= 0 && values[j].x >= 2 * i - fuel; j--) maxPath.add(values[j].x);
            }
        }
        for (int i = 0; i <= Math.min(100, fuel); i++) {
            if (100 + fuel - 2 * i < 100) break;
            int tmp = (100 - i - 1) > 0 ? l[Math.min(100 + fuel - 2 * i, 200)] - l[100 - i - 1] : l[Math.min(100 + fuel - 2 * i, 200)];
            if (tmp > max) {
                max = tmp;
                maxPath = new ArrayList();
                ptr = values.length - 1;
                while (values[ptr].x > 0) ptr--;
                for (int j = ptr; j >= 0 && values[j].x >= -1 * i; j--) maxPath.add(values[j].x);
                for (int j = ptr + 1; j < values.length && values[j].x <= fuel - 2 * i; j++) maxPath.add(values[j].x);
            }
        }
        System.out.println(maxPath);
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
    
    static class Pair implements Comparable<Pair> {
        int x, y;
        public Pair(int x, int y) { this.x = x; this.y = y; }
        @Override
        public int compareTo(Pair arg0) {
            return x > arg0.x ? 1 : -1;
        }
    }
}