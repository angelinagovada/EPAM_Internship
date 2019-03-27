import java.util.*;
import java.io.*;

public class MetroPath{
	static Scanner in=new Scanner(System.in);
        public static void main( String[] args)  {
            Metro obj = new Metro();
            obj.solution();
        }
        static class Metro {
            public void solution() {
                int n = in.nextInt();
                int m = in.nextInt();
                ArrayList<path> arrayList[] = new ArrayList[n + 1];
                for (int i = 0; i <= n; i++) arrayList[i] = new ArrayList();
                for (int i = 0; i < m; i++) {
                    int s = in.nextInt();
                    long t = in.nextLong();
                    int arr[] = new int[s];
                    for (int j = 0; j < s; j++) arr[j] = in.nextInt();
                    for (int j = 0; j < s - 1; j++) {
                        int z = in.nextInt();
                        arrayList[arr[j]].add(new path(arr[j + 1], z,t));
                        t += z;
                    }
                }
                int start = in.nextInt();
                int end = in.nextInt();
                long dis[] = new long[n + 1];
                Arrays.fill(dis, Long.MAX_VALUE / 2);
                dis[start] = 0;
                PriorityQueue<path2> pq = new PriorityQueue<>(new Comparator<path2>() {
                    public int compare(path2 o1, path2 o2) {
                        return Long.compare(o1.dis, o2.dis);
                    }
                });
                pq.add(new path2(start, dis[start]));
                boolean visited[] = new boolean[n + 1];
                visited[start] = true;
                while (!pq.isEmpty()) {
                    path2 p = pq.poll();
                    if (p.node == end) {
                        System.out.println(dis[p.node]);
                        return;
                    }
                    for (path pp : arrayList[p.node]) {
                        if (dis[p.node] <= pp.t && dis[pp.u] > dis[p.node] + pp.w) {
                            dis[pp.u] = dis[p.node] + pp.w;
                            pq.add(new path2(pp.u, dis[pp.u]));
                        }
                    }
                }
                System.out.println(-1);
            }
            class path2 {
                int node;
                long dis;
     
                public path2(int node, long dis) {
                    this.node = node;
                    this.dis = dis;
                }
            }
            class path {
                int u;
                long w;
                long t;
     
                public path(int u, long w, long t) {
                    this.u = u;
                    this.w = w;
                    this.t = t;
                }
            }
        }
    }