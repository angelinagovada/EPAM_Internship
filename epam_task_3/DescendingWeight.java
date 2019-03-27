/* IMPORTANT: Multiple classes and nested static classes are supported */

//import for Scanner and other utility classes
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
		int num,x,v,w;
        num=sc.nextInt();
        x=sc.nextInt();
        int []ar=new int[num];
        List<Integer>[] weights = (List<Integer>[]) new List[x];
        for (int i=0; i < x; i++)
            weights[i] = new ArrayList<>();
        for (int i=0; i < num; i++) {
            v=sc.nextInt();
            ar[i]=v;
            w=v%x;
            weights[w].add(v);
        }
 
        for (int i = x-1; i >= 0; i--) {
            Collections.sort(weights[i]);
            for (int j = 0; j < weights[i].size(); j++) {
                System.out.print(weights[i].get(j));
                System.out.print(" ");
            }
        }
    }
}
