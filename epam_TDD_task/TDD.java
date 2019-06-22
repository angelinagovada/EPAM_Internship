/import java.util.*;

public class RemoveA
{
	String rem(String str)
	{
		str.toUpperCase();
	int l=str.length();
	
	if(l==0)
	{
		return str;
		
	}
	else if(l==1)
	{
		if(str.charAt(0)=='A')
			str="";
		else
			return str;
	}
	else
	{
		if(str.charAt(0)=='A' && str.charAt(1)=='A' ||str.charAt(0)=='a' && str.charAt(1)=='a' )
		{
			str=str.substring(2);
		}
		else if(str.charAt(0)=='A' || str.charAt(0)=='a')
		{
			str=str.substring(1);
		}
		else if(str.charAt(1)=='A' || str.charAt(1)=='a')
		{
			str=str.substring(0, 1).concat(str.substring(2));
		}
	}
	
			
	
	return str;
	
	}
}
