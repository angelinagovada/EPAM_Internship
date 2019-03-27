import java.util.*;
import java.io.*;

public class GlowingBulb{
    static long length;
static ArrayList<Integer> nums;
    public static void main(String args[] ) throws Exception
	{
        BufferedReader buffreader = new BufferedReader(new InputStreamReader(System.in));
       String a=buffreader.readLine();
        int N = Integer.parseInt(a);
        while(N-->0)
        {
             String line= buffreader.readLine();
             String ip=buffreader.readLine();
             long k = Long.parseLong(ip);
              nums=new ArrayList();
             int i,j;
             for(i=0;i<40;i++)
             {
                 if(line.charAt(i)=='1')
                 {
                     nums.add(i+1);
                 }
             }
             length=nums.size();
             long t=bins(k);
             System.out.println(t);
        }
    }
    static long bins(long k)
    {
        long lower=1; long higher=(long)Math.pow(10,15); higher*=37; long f=0;
        while(lower<=higher)
        {
            long mid=(lower+higher)/2;
            long check=checking( mid);
            if(check<k)
            {
                lower=mid+1;
            }
            else {f=mid;higher=mid-1;}
        }
        return f;
    }
    
    static long checking(long limit)
    {
        int y,n1=1; 
		long t=0; 
        for(y=1;y<(int)Math.pow(2,length);y++)
        {
            int check1=y;
            long m1=1; int nof1=0,ind=0;
            while(check1!=0)
            {
                if((check1&1)>0)
                {
                    m1*=(long)nums.get(ind); nof1++;
                }
                
                ind++; check1=check1>>1;
            }
            if(nof1%2==0)
            {
                t-=limit/m1;
            }
            else
            t+=limit/m1;
        }
        return t;
    }
}