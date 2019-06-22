import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveTest {
	
	/*private StringBuffer str;
	public RemoveTest(StringBuffer string)
	{
		
		this.str=string;
	}*/
	
	@Test
	public void test()
	{
		RemoveA a=new RemoveA();
		//System.out.println("String after modification:"+a.rem("CABDG"));
		assertEquals("CBDG",a.rem("CABDG"));
		assertEquals("BDG",a.rem("ABDG"));
		assertEquals("",a.rem(""));
		assertEquals("C",a.rem("CA"));
		assertEquals("",a.rem("A"));
		assertEquals("BCDEFGH",a.rem("ABCDEFGH"));
		assertEquals("sk",a.rem("ask"));
		
	}
}

