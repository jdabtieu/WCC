import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class wcc2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static List<Integer> primes = Arrays.asList(new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97});

    public static void main(String[] args) throws IOException {
        int n = readInt();
        BigInteger ans = BigInteger.ONE;
        for (int i = 2; i <= n; i++) if (!primes.contains(i)) {
            ans = ans.multiply(new BigInteger(Integer.toString(i)));
        }
        System.out.println(ans);
    }

    static String next() throws IOException {
        while (in == null || !in.hasMoreTokens())
            in = new StringTokenizer(br.readLine());
        return in.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}