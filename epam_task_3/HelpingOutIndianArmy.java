//import for Scanner and other utility classes
import java.util.*;

class HelpingIndianArmy {
    public static void main(String args[] ) throws Exception {

        // Write your code here
        
		long s,e,m,p;
		int num;
       	Scanner sc = new Scanner(System.in);
		num =sc.nextInt();
		s = sc.nextLong();
		e = sc.nextLong();
		TreeMap<Long,Long> tree1=new TreeMap<Long,Long>();
		TreeMap<Long,Long> tree2=new TreeMap<Long,Long>();
		for(int i=0;i<num;i++)
		{
			m = sc.nextLong();
			p = sc.nextLong();
			tree1.put((m-p),(m+p));
    }
    List<Long> list1=new ArrayList<Long>(tree1.keySet());
    List<Long> list2=new ArrayList<Long>(tree1.values());
    	long x = list1.get(0);
		long y = list2.get(0);
		for(int i=1;i<tree1.size();i++)
		{
			if(list1.get(i)<=y)
				y = Math.max(y,list2.get(i));
			else
			{
				
				tree2.put(x,y);
				x = list1.get(i);
				y = list2.get(i);
			}
			
		}
		tree2.put(x,y);
	 	int i;
		long a = 0;
    list1=new ArrayList<Long>(tree2.keySet());
    list2=new ArrayList<Long>(tree2.values());
		for(i=0;i<list1.size();i++)
		{
			if(s>=e)
			{
				s=e;
				break;
			}
			if(list1.get(i)<=s && s<=list2.get(i))
				s = list2.get(i);
			else if(s<=list1.get(i) && e>=list2.get(i))
			{
				a+=list1.get(i)-s;
				s = list2.get(i);
				
			}
			else if(s<=list1.get(i) && e>=list1.get(i) &&  e<=list2.get(i))
			{
				a+=list1.get(i)-s;
				s = e;
			}
			else if(s<=list1.get(i) && e<=list1.get(i))
			{
				a+=e-s;
				s = e;
			}
		}
		if(s<e)
			a+=e-s;
		System.out.println(a);
	

    }
}
