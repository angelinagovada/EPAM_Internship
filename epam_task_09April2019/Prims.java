import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
class Pair implements Comparable<Pair> {
    int node;
    int value;

    public int compareTo(Pair b) {
        return (value < b.value) ? -1: 1;
    }
    public Pair(int n, int v) {
        node = n;
        value = v;
    }
    
}
public class Prims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
        ArrayList<ArrayList<Pair>> matrix = new ArrayList<ArrayList<Pair>>();
        int wt = 0;
        int n,m,S;
        n = sc.nextInt();
        m = sc.nextInt();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < m; i++) {
            int x, y, r;
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            r = sc.nextInt();
            matrix.get(x).add(new Pair(y, r));
            matrix.get(y).add(new Pair(x, r));
        }
        S = sc.nextInt() - 1;
        queue.add(new Pair(S, 0));
        while (queue.size() > 0) {
            Pair curr = queue.poll();
            if (!visited[curr.node]) {
                for (int i = 0; i < matrix.get(curr.node).size(); i++) {
                    Pair tmp = matrix.get(curr.node).get(i);
                    if (!visited[tmp.node]) {
                        queue.add(tmp);
                    }
                }
                wt += curr.value;
                visited[curr.node] = true;
            }
        }
        System.out.println(wt);
    }
}