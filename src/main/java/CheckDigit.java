public class CheckDigit 
{   
  /** Returns the check digit for num. */
  public static int getCheck(int num) 
  {  
    int sum = 0;
    int numDigits = getNumberOfDigits(num);
    for (int i = 1; i <= numDigits; i++) 
    {
      int digit = getDigit(num, i);
      sum += digit * (numDigits - i + 1); // position from the right
    }
    return sum % 10;
  }

  /** Returns true if numWithCheckDigit is valid. */
  public static boolean isValid(int numWithCheckDigit)    
  {      
    int checkDigit = numWithCheckDigit % 10;
    int original = numWithCheckDigit / 10;
    return getCheck(original) == checkDigit;
  }

  /** Returns the number of digits in num. */
  public static int getNumberOfDigits(int num)    
  {      
    if (num < 10) return 1;
    return 1 + getNumberOfDigits(num / 10);    
  }

  /** Returns the nth digit of num (n = 1 means leftmost digit). */
  public static int getDigit(int num, int n)    
  {      
    int pos = getNumberOfDigits(num) - n + 1;
    while (pos > 1) {
      num /= 10;
      pos--;
    }
    return num % 10;
  }     
}
