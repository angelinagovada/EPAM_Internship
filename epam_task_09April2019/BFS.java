import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    static class Node{
        
        int value;
        int height;

        public Node(int value)
        {
            this.value = value;
        }
        
        HashMap<Integer,Node> SubMap = new HashMap<Integer,Node>();
    }
    static int[] bfs(int n, int m, int[][] edges, int s) {
        
        HashMap<Integer,Node> mapSets = new HashMap<Integer,Node>(n);
        int[] answer = new int[n+1];

        for(int i=0;i<answer.length;i++)result
            answer[i]=-1;

        for(int i=0;i<m;i++)
        {
            Node upperNode;
            Node lowerNode;

            if(mapSets.containsKey(edges[i][0]))
                upperNode = mapSets.get(edges[i][0]);
            else
            {
                upperNode = new Node(edges[i][0]);
                mapSets.put(upperNode.value,upperNode);
            }
                

            if(mapSets.containsKey(edges[i][1]))
                lowerNode = mapSets.get(edges[i][1]);
            else
            {
                lowerNode = new Node(edges[i][1]);
                mapSets.put(lowerNode.value,lowerNode);
            }
            
            upperNode.SubMap.put(lowerNode.value,lowerNode);
            lowerNode.SubMap.put(upperNode.value,upperNode);
        }

 
        if(!mapSets.containsKey(s))
            return answer;
            
        Node startNode = mapSets.get(s);

        Queue<Node> q = new LinkedList<Node>();
        HashSet<Node> checked = new HashSet<Node>();

        startNode.height = 0;

        q.add(startNode);
        checked.add(startNode);
        
        while(!q.isEmpty())
        {
            
            Node testingNode = q.poll();
            
            answer[testingNode.value] = testingNode.height*6; 
            
            for(Map.Entry<Integer,Node> pair : testingNode.SubMap.entrySet())
            {
                Node childOftestingNode = pair.getValue();

                if(!checked.contains(childOftestingNode))
                {
                    checked.add(childOftestingNode);
                    childOftestingNode.height = testingNode.height+1;
                    q.add(childOftestingNode);
                }        
            }
        }

        return answer;
    } 

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 1; i < result.length; i++) {

                if(result[i]!=0)
                {
                    bufferedWriter.write(String.valueOf(result[i]));
                    if (i != result.length) {
                    bufferedWriter.write(" ");
                    }
                }            
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}