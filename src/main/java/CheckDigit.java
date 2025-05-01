public class CheckDigit 
{   
  /** Returns the check digit for num.
   *  Precondition: num has 1 to 6 digits, num >= 0
   */
  public static int getCheck(int num) 
  {  
    int sum = 0;
    int numDigits = getNumberOfDigits(num);

    for (int i = 1; i <= numDigits; i++) 
    {
      sum += getDigit(num, i) * i;
    }

    return sum % 10;
  }

  /** Returns true if numWithCheckDigit is valid, or false otherwise.
   *  Precondition: numWithCheckDigit has 2 to 7 digits, num >= 0
   */
  public static boolean isValid(int numWithCheckDigit)    
  {      
    int numDigits = getNumberOfDigits(numWithCheckDigit);
    int num = numWithCheckDigit / 10; // original number
    int checkDigit = numWithCheckDigit % 10; // last digit

    return getCheck(num) == checkDigit;
  }    
   
  /** Returns the number of digits in num. */    
  public static int getNumberOfDigits(int num)    
  {      
    if(num < 10)
      return 1;
    return 1 + getNumberOfDigits(num / 10);    
  }    
   
  /** Returns the nth digit of num.
   *  Precondition: n >= 1 and n <= number of digits
   *  Example: getDigit(12345, 1) returns 1; getDigit(12345, 5) returns 5
   */    
  public static int getDigit(int num, int n)    
  {      
    int pos = getNumberOfDigits(num) - n + 1;
    while(pos > 1){
      num /= 10;
      pos--;
    }
    return num % 10;
  }     
}
