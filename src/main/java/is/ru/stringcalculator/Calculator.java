package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		
		
		if(text.equals("")){
			return 0;
		}
		/*else if(text.startsWith("//"))
		{
			String[] val = takeApart(text);		
		}*/
		//If string contains newline character it will be replaced with a ','
		else if(text.contains("\n"))
		{
			text = text.replaceAll("\n", ",");
			return sum(splitNumbers(text));
		}

		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

    private static String[] takeApart(String text)
    {
    	String del = ",|\n";
    	if(text.contains("//"))
    	{
    		del += "|" + text.substring(2, 3);
    	}
    }

   

}

