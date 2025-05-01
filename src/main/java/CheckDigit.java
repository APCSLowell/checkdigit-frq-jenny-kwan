public class CheckDigit {

    /** Returns the check digit for num, as described in part (a).  
     *  Precondition: The number of digits in num is between one and    
     *  six, inclusive.  
     *  num >= 0  
     */  
    public static int getCheck(int num) {
        int sum = 0;
        int numDigits = getNumberOfDigits(num);

        // Compute sum of digits weighted by their position from left to right
        for (int i = 1; i <= numDigits; i++) {
            int digit = getDigit(num, i);
            sum += digit * i;  // Multiply digit by its position from the left
        }

        return sum % 10;  // Return the check digit
    }

    /** Returns true if numWithCheckDigit is valid, or false    
     *  otherwise, as described in part (b). 
     *  Precondition: The number of digits in numWithCheckDigit   
     *  is between two and seven, inclusive.
     *  numWithCheckDigit >= 0     
     */     
    public static boolean isValid(int numWithCheckDigit) {
        int checkDigit = numWithCheckDigit % 10;  // Get the check digit from the number
        int originalNum = numWithCheckDigit / 10;  // Remove the check digit from the number

        // Validate if the check digit matches the calculated check digit
        return getCheck(originalNum) == checkDigit;
    }

    /** Returns the number of digits in num. */    
    public static int getNumberOfDigits(int num) {
        if (num < 10) return 1;
        return 1 + getNumberOfDigits(num / 10);    
    }

    /** Returns the nth digit of num.      
     *  Precondition: n >= 1 and n <= the number of digits in num     
     */    
    public static int getDigit(int num, int n) {      
        int pos = getNumberOfDigits(num) - n + 1;  // Find the nth digit from the left
        while (pos > 1) {
            num /= 10;  // Shift the number to the right
            pos--;
        }
        return num % 10;  // Extract the digit
    }
}
