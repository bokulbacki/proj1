import java.io.*;
import java.util.*;
public class proj1
{
	public static void main (String[] args)
	{
		Scanner kb = new Scanner(System.in);
		String playAgain = "y";
		boolean continueProgram = true;
		while(continueProgram)
		{
			System.out.println("Enter the individual key values (positive or negative integers, one after another in the same line with a blank between two values): ");
			String keys = kb.nextLine();
			String [] strKeyValues = keys.split(" ");
			int keyValues [] = new int [strKeyValues.length];
			for(int i = 0; i<strKeyValues.length; i++)
			{
				keyValues[i] = Integer.parseInt(strKeyValues[i]);
			}

			System.out.println("Enter a string to be encoded: ");
			String message = kb.nextLine();
			char [] messageChars = new char [message.length()];
			for(int i = 0; i<message.length(); i++)
			{
				messageChars[i] = message.charAt(i);
			}
			String encodedMessage = "";
			for(int i =0; i<messageChars.length; i++)
			{
				int ascii = (int)messageChars[i];
				//int ascii = ascii + (keyValues[i % keyValues.length]);
				if ((ascii + (keyValues[i% (keyValues.length)])) >126)//new ascii decimal is above range
				{
					int leftover = (ascii + (keyValues[i% (keyValues.length)])) - 126;
					ascii = 31 + leftover;
					System.out.println(keyValues[i% (keyValues.length)]);

				}
				else if ((ascii + (keyValues[i% (keyValues.length)])) <32) // new ascii decimal is below range
				{
					int leftover = 32 - (ascii + (keyValues[i% (keyValues.length)]));
					ascii = 127 - leftover;
					System.out.println(keyValues[i% (keyValues.length)]);
				}
				else //new ascii decimal is within range
				{
					ascii =  ascii + (keyValues[i% (keyValues.length)]);
					System.out.println(keyValues[i% (keyValues.length)]);
				}
				//append new character to encoded message	
				encodedMessage = encodedMessage.concat(Character.toString((char) ascii));
					
			}
			System.out.println("Encoded message: \n" + encodedMessage);
			
			//decode
			String decodedMessage = "";
			for(int i = encodedMessage.length() - 1; i > -1; i--)
			{
				int ascii = Integer.parseInt(encodedMessage.substring(i, i+1));
				if ((ascii - (keyValues[i% (keyValues.length)])) > 126)
				{
					int leftover = (ascii + (keyValues[i%(keyValues.length)])) -126;
					ascii = 31 - leftover;

			}
			//run again option
			System.out.println("Do you want the program run again (y for yes and n for no)?: ");
			playAgain = kb.nextLine();
			if (playAgain.equalsIgnoreCase("n") || playAgain.equalsIgnoreCase("no"))
			{	
				continueProgram = false;
			}


		}	
	}


}
