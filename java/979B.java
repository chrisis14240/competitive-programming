import java.io.*;
import java.util.*;

public class Main {

    static HashMap<Character, Integer> count;

    public static int maxBeauty(String ribbon, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ribbon.length(); i++) {
            if (!count.containsKey(ribbon.charAt(i)))
                count.put(ribbon.charAt(i), 1);
            else
                count.replace(ribbon.charAt(i), count.get(ribbon.charAt(i)) + 1);

            max = Math.max(max, count.get(ribbon.charAt(i)));
        }
        if (n == 1 && max == ribbon.length())
             return Math.min(max + n, ribbon.length()-1);

        return Math.min(max + n, ribbon.length());
    }


	public static void main (String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		count = new HashMap<>();
		int n = Integer.parseInt(bf.readLine());
		int winnerBeauty = Integer.MIN_VALUE, idx = -1, temp = 0;
		String[] ribbons = new String[3];
		String ans = "";

		ribbons[0] = bf.readLine();
		ribbons[1] = bf.readLine();
		ribbons[2] = bf.readLine();

		for(int i = 0; i < 3; i++) {
		    temp = maxBeauty(ribbons[i], n);
		    if ( temp > winnerBeauty) {
		        winnerBeauty = temp;
		        idx = i;
		    } else if (temp == winnerBeauty) {
		       ans = "Draw";
		       idx = -1;
		    }

		    count.clear();
		}

		if (idx == 0)
		    ans = "Kuro";
		if (idx == 1)
		    ans = "Shiro";
		if (idx == 2)
		    ans = "Katie";

		System.out.println(ans);
	}
}
