package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		
		
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n"))
		{
			return sum(splitNumbers(text));	
		}
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

}

