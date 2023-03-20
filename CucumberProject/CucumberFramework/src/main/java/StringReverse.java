
public class StringReverse {

	public static void main(String[] args) {

		
		 long startTime = System.currentTimeMillis();  
		 StringBuilder sb = new StringBuilder("Java");  
	        
	        for (int i=0; i<100000; i++){  
	            sb.append("Tpoint");  
	        }  
	        System.out.println("Time taken by StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");  
	        startTime = System.currentTimeMillis();  
	        StringBuilder sb2 = new StringBuilder("Java");  
	        for (int i=100000; i>0; i--){  
	            sb2.append("Tpoint");  
	        }  
	        System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms");  
	    }  
 
		 
		
		 
	}

