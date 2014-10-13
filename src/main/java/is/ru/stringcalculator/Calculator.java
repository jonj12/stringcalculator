package is.ru.stringcalculator;

import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
		
		
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n"))
		{
			return sum(splitNumbers(text));	
		}
		else if(text.contains("-"))
		{
			return negative(text);
		}
		/*else
		{
			return negative(text);
		}*/

		//If string contains newline character it will be replaced with a ','
		/*else if(text.contains("\n"))
		{
			text = text.replaceAll("\n", ",");
			return sum(splitNumbers(text));
		}

		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}*/
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    //return numbers.split(",");
	    String del = "[,\n]";
	    if(numbers.startsWith("//")){
	    	char delNumDos = numbers.charAt(2);
	    	del = "[,\n" + delNumDos + "]";
	    	numbers = numbers.substring(4);
	    }
	    return numbers.split(del);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }   

    private static int negative(String numbers)
    {
    	String[] sting = splitNumbers(numbers);
    	int sum = 0;
    	int counter = 0;
    	ArrayList<Integer> ints = new ArrayList<Integer>();
    	//String neg = "";
    	for(String number : sting)
    	{
    		int arr = toInt(number);
    		if(arr < 0 || arr > 1000)
    		{
    			ints.add(arr);
    			//arr = 0;
    			//neg = arr.toString() + " ";
    			counter++;
    		}
    		else
    		{
    			sum += arr;
    		}
    	}
    	if(counter > 0)
    	{
    		throw new IllegalArgumentException("Negatives not allowed: " + ints.toString());
    	}
    	//else 
    	//{
    		return sum;
    	//}
    }

}

