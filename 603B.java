import java.io.*;

public class Main {
    final static long mod = (long) 1e9 + 7;

    public static long pow(long x, long n) {
        long ans = 1;
        while(n != 0) {
            if(n%2 == 1)
                ans *= x;
                ans %= mod;
            n/= 2;
            x *= x;
            x %= mod;
        }
        return ans % mod;
    }

	public static void main (String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().split(" ");
		long p = Integer.parseInt(input[0]);
		long k = Integer.parseInt(input[1]);
		long order = 1;
		long temp = k;

		if (k == 0)
		    System.out.println((int) pow(p, p - 1));
		else {
    	    while (order < p) {
    	        if(temp == 1)
    	            break;
    	        temp = ((k % p) * (temp % p)) % p;
    	        order++;
    	    }
    	   if (k == 1)
		        System.out.println(((pow(p,p))));
		    else
		    System.out.println(((pow(p, (p - 1)/order))));
		}
	}
}
