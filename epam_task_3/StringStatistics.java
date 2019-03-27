

//import for Scanner and other utility classes
import java.util.*;
import java.io.*;

class StringStatistics {
    static int solve(int n, int a, int m) {
		d = new int[n];
		int s = 0;
		for (int k = 1; k < n; k++)
			for (int v = 2; v < 1 << n - k + 1; v += 2)
				s = (s + solution(k, v, n, a, m)) % m;
		return s;
	}
	
	static int solution(int k, int v, int n, int a, int m) {
		Arrays.fill(d, -1);
		int count = 0, cnt = n;
		for (int i = 1; i < n; i++)
			if ((v & 1 << i) > 0) {
				for (int j = i; j < i + k; j++)
					if (join(j, j - i))
						cnt--;
				count++;
			}
		int sum = power(a, cnt, m);
		return count % 2 == 1 ? sum : (m - sum) % m;
	}
	
	static boolean join(int i, int j) {
		i = find(i);
		j = find(j);
		if (i == j)
			return false;
		if (d[i] > d[j])
			d[i] = j;
		else {
			if (d[i] == d[j])
				d[i]--;
			d[j] = i;
		}
		return true;
	}
	
	static int power(int a, int b, int m) {
		if (b == 0)
			return 1;
		int p = power(a, b / 2, m);
		p = (int) ((long) p * p % m);
		if (b % 2 == 1)
			p = (int) ((long) p * a % m);
		return p;
	}
	static int[] d;
	static int find(int i) {
		return d[i] < 0 ? i : (d[i] = find(d[i]));
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader buffreader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stoken = new StringTokenizer(buffreader.readLine());
		int n = Integer.parseInt(stoken.nextToken());
		int a = Integer.parseInt(stoken.nextToken());
		int m = Integer.parseInt(stoken.nextToken());
		System.out.println(solve(n, a, m));
	}
}
