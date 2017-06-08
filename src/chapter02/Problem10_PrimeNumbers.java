/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter02;

/**
 * Class used to find the prime numbers within a specified integer range.
 * @author Ryan
 */
public class Problem10_PrimeNumbers {
  
  /**
   * Prints a list of prime number between a stated range of integers.  Start and end integers are
   * included.
   * @param start The starting integer value of the range to be tested.
   * @param end The ending integer value of the range to be tested.
   */
  public static void printPrimes(int start, int end) {
    StringBuilder result = new StringBuilder();
    String resultString;
    int resultStringLength;
    
    for(; start <= end; start++) {
      if(isPrime(start)) result.append(start).append(", ");
    }

    resultString = result.toString();
    resultStringLength = resultString.length();
    
    System.out.print(resultString.substring(0, resultStringLength - 2));
    System.out.println();
  }
  
  /**
   * Tests a number to see if it is a prime.  Only accepts positive integer values.
   * @param number The integer number to be tested for prime status.
   * @return Returns true if the number is a prime.  Returns false otherwise.
   */
  public static boolean isPrime(int number) {
    if(number < 2) return false;
    if(number == 2) return true;
    
    int divisor = (int) Math.ceil(Math.sqrt(number));
    
    while(divisor >= 2) {
      if(number % divisor == 0) return false;
      divisor--;      
    }
    
    return true;
  }
  
}
