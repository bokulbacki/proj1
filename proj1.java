import java.io.*;
import java.util.*;
public class proj1.java
{
	public static void main (String[] args)
	{
		Scanner kb = new Scanner(System.in);
		String playAgain = "y";
		boolean continueProgram = True;
		while(continueProgram)
		{
			System.out.println("Enter the individual key values (positive or negative integers, one after another in the same line with a blank between two values): ");
			String keys = kb.nextLine();
			int [] keyValues= Integer.parseInt(keys.split(" "));

			System.out.println("Enter a string to be encoded: ");
			String message = kb.nextLine();
			char [] messageChars = message.split('');
			
			String encodedMessage = "";
			for(int i =0; i<messageChars.length; i++)
			{
				int ascii = (int)messageChars[i];
				//int ascii = ascii + (keyValues[i % keyValues.length]);
				if (ascii+ (keyValues[i% (keyValues.length-1)] >126)
				{
					//fix
				}
				else if (ascii + (keyValues[i% (keyValues.length-1)]<32)
				{
					int leftover = 32 - (ascii + (keyValues[i% (keyValues.length-1)]));
					int ascii = 127 - leftover;
				}		
				
			}



			//run again option
			System.out.println("Do you want the program run again (y for yes and n for no)?: ");
			playAgain = kb.nextLine();
			if (playAgain.equalsIgnoreCase("n") || playAgain.equalsIgnoreCase("no"));
			{	
				continueProgram = False;
			}		
		}	
	}


}
