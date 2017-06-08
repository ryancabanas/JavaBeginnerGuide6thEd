/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter05;

/**
 * A class for a simple encoding program.
 * @author Ryan Cabanas
 */
public class Problem07_Encode {
  
  private static final String ENCODING_KEY = "k3hqPZ+g";
  private static String originalMessage = "I like you.";
  private static StringBuilder encodedMessage = new StringBuilder(originalMessage.length());
  private static StringBuilder decodedMessage = new StringBuilder(originalMessage.length());
  
  
  public static void startProgram() {
    System.out.println("The string to be encoded is: " + originalMessage);
    System.out.println("Encoded string is: " + encodeMessage(originalMessage));
    System.out.println("After decoding, the message is: " + decodeMessage(encodedMessage.toString()));
  }
  
  private static String encodeMessage(String message) {
    for(int i = 0; i < originalMessage.length(); i++)
      encodedMessage.append((char)(message.charAt(i) ^ ENCODING_KEY.hashCode()));
    return encodedMessage.toString();
  }
  
  private static String decodeMessage(String message) {
    for(int i = 0; i < encodedMessage.length(); i++)
      decodedMessage.append((char)(message.charAt(i) ^ ENCODING_KEY.hashCode()));
    return decodedMessage.toString();
  }
  
}
