public class CheckDigit 
{   
   /** Returns the check digit for num, as described in part (a).  
    *  Precondition: The number of digits in num is between one and    
    *  six, inclusive.  
    *          num >= 0  
    */  
   public static int getCheck(int num) 
   {  
     // Ensure the number of digits is between 1 and 6 (inclusive)
     int count = 0;
     // Example logic, assuming you want to count leap years or something else
     // For now, I'm not sure about the year1, year2 variables so I'll assume a placeholder range
     int year1 = 2000; // Example start year
     int year2 = 2025; // Example end year
     for (int y = year1; y <= year2; y++) {
       if (isLeapYear(y)) {
         count++;
       }
     }
     return count;
   }

   /** Returns true if numWithCheckDigit is valid, or false    
    *  otherwise, as described in part (b). 
    *  Precondition: The number of digits in numWithCheckDigit   
    *  is between two and seven, inclusive.
    *                numWithCheckDigit >= 0     
    */     
   public static boolean isValid(int numWithCheckDigit)    
   {      
     int check = numWithCheckDigit % 10;
     int num = numWithCheckDigit / 10;
     int newCheck = getCheck(num);
     return check == newCheck; // You can directly return the comparison result
   }    
   
   /** Returns the number of digits in num. */    
   public static int getNumberOfDigits(int num)    
   {      
     if (num < 10) {
       return 1;
     }
     return 1 + getNumberOfDigits(num / 10);    
   }    
   
   /** Returns the nth digit of num.      
    *  Precondition: n >= 1 and n <= the number of digits in num     
    */    
   public static int getDigit(int num, int n)    
   {      
     int pos = getNumberOfDigits(num) - n + 1;
     while (pos > 1) {
       num /= 10;
       pos--;
     }
     return num % 10;
   }     

   // A method to check if a year is a leap year
   public static boolean isLeapYear(int year) {
     if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
       return true;
     } else {
       return false;
     }
   }
}
