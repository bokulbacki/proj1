import java.io.*;
import java.util.*;
//Project 1: A Caesar Cipher
//This program is an implementation of the Caesar Cipher with user input for
//keys and the message
//Bo Kulbacki - rkulbacki@sandiego.edu
//Dalton Kohl - dkohl@sandiego.edu
//Date modified: 2-17-21
//

public class proj1
{
	public static void main (String[] args)
	{
		Scanner kb = new Scanner(System.in);
		//create a Scanner object 
		String playAgain = "y";
		//boolean which is used for "run again" feature
		boolean continueProgram = true;
		while(continueProgram)//loop that allows user to run program again
		{
		System.out.println("Enter the individual key values (positive or negative integers, one after another in the same line with a blank between two values): ");
			String keys = kb.nextLine();
			//splits the line of key values at the space " " 
			String [] strKeyValues = keys.split(" ");
			
			int keyValues [] = new int [strKeyValues.length];
			for(int i = 0; i<strKeyValues.length; i++)
			{
				//cast all key values as integers to be stored in keyValues
				//array 
				keyValues[i] = Integer.parseInt(strKeyValues[i]);
			}

			System.out.println("Enter a string to be encoded: ");
			//read message from next Line
			String message = kb.nextLine();
			char [] messageChars = new char [message.length()];
			for(int i = 0; i<message.length(); i++)
			{
				//put all characters into an array of the same length as the
				//message string
				messageChars[i] = message.charAt(i);
			}
			String encodedMessage = "";
			//loops through all characters and adjusts ascii value according
			//to the correspodning key value
			for(int i =0; i<messageChars.length; i++)
			{
				int ascii = (int)messageChars[i];
				if ((ascii + (keyValues[i% (keyValues.length)])) >126)//new ascii decimal is above range
				{
					int leftover = (ascii + (keyValues[i% (keyValues.length)])) - 126;
					ascii = 31 + leftover;
				//for testing purposes:	System.out.println(keyValues[i% (keyValues.length)]);

				}
				else if ((ascii + (keyValues[i% (keyValues.length)])) <32) // new ascii decimal is below range
				{
					int leftover = 32 - (ascii + (keyValues[i% (keyValues.length)]));
					ascii = 127 - leftover;
				//for testing purposes:	System.out.println(keyValues[i% (keyValues.length)]);
				}
				else //new ascii decimal is within range
				{
					ascii =  ascii + (keyValues[i% (keyValues.length)]);
				//for testing purposes:	System.out.println(keyValues[i% (keyValues.length)]);
				}
				//append new character to encoded message	
				encodedMessage = encodedMessage.concat(Character.toString((char) ascii));
					
			}
			System.out.println("Encoded message: \n" + encodedMessage);
			
			//DECODE SECTION
			String decodedMessage = "";
			//loops through the encodedMessage backwards so that the keys
			//matched up correctly
			for(int i = encodedMessage.length() - 1; i > -1; i--)
			{
				char charAscii = encodedMessage.charAt(i);
				int ascii = (int)charAscii;
				if ((ascii - (keyValues[i% (keyValues.length)])) > 126)//new ascii is above the range
				{
					int leftover = (ascii - (keyValues[i%(keyValues.length)])) -126;
					ascii = 31 + leftover;
				}
				else if ((ascii - (keyValues[i% (keyValues.length)])) <32) // new ascii decimal is below range
				{   
				int leftover = 32 - (ascii - (keyValues[i% (keyValues.length)]));
				ascii = 127 - leftover;
			     }
			   else //new ascii decimal is within range
			    {   
			     ascii =  ascii - (keyValues[i% (keyValues.length)]);
			    }
			    //append new character to encoded message   
				decodedMessage= (Character.toString((char)ascii)) + decodedMessage;
			}
			System.out.println("Decoded message: \n" + decodedMessage);

			//run again option
			System.out.println("Do you want the program run again (y for yes and n for no)?: ");
			playAgain = kb.nextLine();
			if (playAgain.equalsIgnoreCase("n") || playAgain.equalsIgnoreCase("no"))
			{	//sets continueProgram to false which stops the while loop
				continueProgram = false;
			}


		}	
	}


}
