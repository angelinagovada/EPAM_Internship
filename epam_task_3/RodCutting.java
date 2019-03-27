//import for Scanner and other utility classes
import java.util.*;


class RodCutting {
    public static void main(String args[] ) throws Exception
	{
		int testcases,num,l=0,k=0;
        Scanner sc=new Scanner(System.in);
        testcases=sc.nextInt();
        for(int i=0;i<testcases;i++)
        {
            num=sc.nextInt();
            if(num!=1)
            {
               while(num!=0)
			   {
				   if(num%2==0)
				   {
                     k=1;
                   }
                   if(num==1 && k==1)
                   {
                     l--;
                   }
                  num=num/2;
                  if(num!=1)
                  {
                    l++;
                  }
               }
            }
            System.out.println(l);
			l=0;
            k=0;
        }
	}
}



