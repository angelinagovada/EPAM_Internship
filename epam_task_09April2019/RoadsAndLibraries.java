import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RoadsAndLibraries {

    public static boolean[] visited;
    public static ArrayList<Integer>[] adjCities;
    public static int connectedComponents;
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt(); // number of queries
        for(int i = 0; i < q; i++){
            int n = sc.nextInt(); 
            // number of cities
            
            int r = sc.nextInt(); 
            // number of roads

            long l_cost = sc.nextLong(); 
            // cost of building a library

            long r_cost = sc.nextLong(); 
            // cost of repairing a road

             if (r_cost >= l_cost || r == 0)
            { 
                System.out.println(l_cost*n);
                for (int k = 0; k < (r*2); k++){
                    sc.nextInt();
                }
                continue;
            }
            else
            {
                
                adjCities = (ArrayList<Integer>[]) new ArrayList[n+1];
                for (int c = 0; c <= n; c++) {
                    adjCities[c] = new ArrayList<Integer>();
                }
                
                   
                //initializing adjCities
                for (int j = 0; j < r; j++){
                    int c1 = sc.nextInt();
                    int c2 = sc.nextInt();
                    
                    adjCities[c1].add(c2);
                    adjCities[c2].add(c1);
                }
                


            roadsAndLibraries(n,r,l_cost,r_cost,adjCities);
            }

        }
    }

            public static void roadsAndLibraries(int cities, int roads, long libCost, 
            long roadCost, ArrayList<Integer>[] adjCities) {

                visited = new boolean[cities+1];
                
              for(int c = 1; c <= cities; c++) {
                    if(!visited[c]) {
                        dfs(c);
                        connectedComponents++;
                    }
                }

                //System.out.println(connectedComponents);
                System.out.println(roadCost * (cities - connectedComponents) + libCost * connectedComponents);
                connectedComponents = 0;
                visited = new boolean[10000];
                adjCities = (ArrayList<Integer>[]) new ArrayList[10000+1];
            }


             private static void dfs(int city){
        visited[city] = true;
        for (int c = 0; c < adjCities[city].size(); c++){
            if(!visited[adjCities[city].get(c)]){
                dfs(adjCities[city].get(c));
            }
        }
    }

           
}