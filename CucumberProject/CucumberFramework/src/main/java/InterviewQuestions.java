public class InterviewQuestions {
	
	
	
	
	
	    
	//driver code  
	public static void main (String args[])  
	{  
		
	
	long n = 9843543439L;  
	
	
	long finalvalue=digSum(n);
	System.out.println(finalvalue);
	System.out.println("finalvalue2 asian guy");
	
	}

	private static long digSum(long n) {
		if (n == 0)  
			//if number is equal to 0, return 0  
			return 0;  
			return (n % 9 == 0) ? 9 : (n % 9);
		
	}  
	  

}
