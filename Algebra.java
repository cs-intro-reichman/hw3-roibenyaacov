// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  
	
	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 > 0){
		for (int i = 1; i <= x2; i++) {
			x1++;
		}
	}
	else {
		for (int i = -1; i >= x2; i--) {
		x1--;
	}
	}
	return x1;
}


	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2>0) {
			for (int i = 0; i < x2 ; i++) {
				x1--;
			}
		}
		else {
			for (int i = 0; i > x2; i--) {
			x1++;
		}
		}
		return x1;
	}
	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int x3 = 0 ; 
		int zero = 0;
		if (x1 >= 0 && x2 >= 0 ){
			for (int i = 0; i < x2 ; i++) {
			int sum = plus(x3, x1);   
			x3 = sum;	
			} 
		}
		else if (x1 >= 0 && x2 < 0 ){
			 x2 = minus(zero, x2);
			for (int i = 0; i < x2 ; i++) {
					int sum = plus(x3, x1);   
					x3 = sum;	
					} 
					x3 = minus(zero, x3);
				}
			
				else if (x1 < 0 && x2 >= 0 ){
				x1 = minus(zero , x1);
						for (int i = 0; i < x2 ; i++) {
						int sum = plus(x3, x1);   
						x3 = sum;	
						} 
						x3 = minus(zero, x3);
				
			}
			else  {
				x2 = minus(zero, x2);
				x1 = minus(zero, x1);
				for (int i = 0; i < x2 ; i++) {
				int sum = plus(x3, x1);   
				x3 = sum;	
				} 
	
			}
			return x3;	
		}
		
	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int x3 = 1 ;
		if (n > 0) {
			for (int i = 0; i < n ; i++) {
			int sum = times(x3 , x);   
			x3 = sum;	 
			}
		}
			return x3;
		}
	

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int count = 0; 
		int zero = 0; 
		boolean isNegative = (x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0);
		if (x1 == 0 || x2 == 0) {
			count = 0;
		}
		if (x1 < 0) {
			x1 = minus(zero, x1);
		}
		if (x2 < 0) {
			x2 = minus(zero, x2);
		}
		int sum = x2;
		while (sum <= x1) {
			sum = plus(sum, x2);
			count++;
		}
		if (isNegative) {
			count = minus(zero, count);
		}

		return count;
	}
		
		
	

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		 int x3 = div(x1, x2); 
		 int sum = 0 ;
		 if (x1 - x2 * x3 == 0 ){
		 return 0;
		 }
		 else {
		 sum = x1 - x2 * x3;
		 }
		return sum;
		
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int root = 0;
		int sum = 0 ;
		while (sum <= x) { 
			root++;
			sum = times(root, root);
		}
		return root -1;
	}
}  
