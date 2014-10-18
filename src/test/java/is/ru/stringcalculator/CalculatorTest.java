package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}


	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	
    //Nr.2
	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
    //Nr.3
    @Test
    public void testNewLineChar(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    //Nr.4
    @Test
    public void testDifferentDelim(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    //Nr.5
    @Test
    public void testNegatives(){
    	try
    	{
    		Calculator.add("2,-4,3,-5");
    		
    	}
    	catch(IllegalArgumentException exc)
    	{
    		assertEquals("Negatives not allowed: [-4, -5]" , exc.getMessage());
    	}
    }
    //Nr.6
    @Test
    public void testNumToBig(){
    	try
    	{
    		Calculator.add("2000,1,3,5");
    		
    	}
    	catch(IllegalArgumentException exc)
    	{
    		assertEquals("Number can not be over 1000: [2000]" , exc.getMessage());
    	}
    }


}