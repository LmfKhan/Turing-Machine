//-------------------------------------------------------------------------------------------
// A Turing machine is a 7-tuple (Q, sigma, T, delta, q0, qaccept, qreject)
// Implement a turing machine that is defined by the 7-tuple and receives as input to decide.
// It should be designed in a way to be working for multiple examples by providing 
// different delta functions and other parameters.
//-------------------------------------------------------------------------------------------

import java.util.*;

public class Turing
{
   protected static String ptr = "", write = "", move = "";
   protected static boolean accept = false;
   
   public static void main (String[] args)
   {
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter the input to decide: ");
      String input = scan.nextLine();

      int headIndex = 0;

      String[] modified = new String[input.length()+1];  // +1 is for extra blank at the end
      for (int i=0; i<modified.length-1; i++)
      {
         modified[i] = Character.toString(input.charAt(i));
      }
      modified[modified.length-1] = " ";	//	appends the blank at the end

	  Transition t = new Transition();
	  System.out.println("Current(Start) Configuration: " + t.getState() + " " + input);
      ptr = modified[0];
	  String modifiedIn = "";
      while (!accept) 
      {
        if (t.getState().equals("q1"))  // IF CHARACTER READ FROM INPUT STREAM IS A '1' & WE ARE AT START STATE
        {
            if (ptr.equals("1"))
			{
				t.q1Toq3();	//	invoking this sets write to 'x', move to 'R' and state to q3
				modified[headIndex] = write;
				modifiedIn = "";
				for (int i=0; i<modified.length; i++)
					modifiedIn += modified[i];
				ptr = modified[++headIndex];   // head points to next symbol to the right
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0, headIndex) + t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else if (ptr.equals("0"))	// IF CHARACTER READ FROM INPUT STREAM IS A '0' & WE ARE AT START STATE
			{
				t.q1Toq2();	//	invoking this sets write to 'x', move to 'R' and state to q2
				modified[headIndex] = write;
				modifiedIn = "";
				for (int i=0; i<modified.length; i++)
					modifiedIn += modified[i];
				ptr = modified[++headIndex];   // head points to next symbol to the right
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0, headIndex) + t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else if (ptr.equals("#"))
			{
				t.q1Toq8();	//	invoking this sets write to _ , move to R and state to q8
				ptr = modified[++headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0,headIndex)
										+ t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else break;
		}
		
		
		if (t.getState().equals("q3"))
		{
			if (ptr.equals("0") || ptr.equals("1"))
			{
				t.q3Toq3();	//	invoking this sets write to _ and move to R, state remains q3
				ptr = modified[++headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0,headIndex) + 
											t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else if (ptr.equals("#"))
			{
				t.q3Toq5();	//	invoking this sets write to _ , move to R and state to q5
				ptr = modified[++headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0,headIndex)
										+ t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else break;
		}

		if (t.getState().equals("q2"))
		{
			if (ptr.equals("0") || ptr.equals("1"))
			{
				t.q2Toq2();	//	invoking this sets write to _ and move to R, state remains q2
				ptr = modified[++headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0,headIndex) + 
											t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else if (ptr.equals("#"))
			{
				t.q2Toq4();	//	invoking this sets write to _ , move to R and state to q4
				ptr = modified[++headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0,headIndex)
										+ t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else break;
		}
			
				
		if (t.getState().equals("q7"))
		{
			if (ptr.equals("x"))
			{
				t.q7Toq1();	//	invoking this sets write to _ , move to R and state goes to q1
				ptr = modified[++headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0, headIndex)
										+ t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else if (ptr.equals("0") || ptr.equals("1"))
			{
				t.q7Toq7();	//	invoking this sets write to _ , move to L and state remains at q7
				ptr = modified[--headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				if (headIndex != 0)
					System.out.println("Current Configuration: " + modifiedIn.substring(0,headIndex) + 
											t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
				else 
					System.out.println("Current Configuration: " + 
											t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else break;
		}
		
		if (t.getState().equals("q5"))
		{
			if (ptr.equals("1"))
			{
				t.q5Toq6();	//	invoking this sets write to 'x', move to L and state goes to q6
				modified[headIndex] = write;
				modifiedIn = "";
				for (int i=0; i<modified.length; i++)
					modifiedIn += modified[i];
				ptr = modified[--headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0, headIndex)
										+ t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else if (ptr.equals("x"))
			{
				t.q5Toq5();	//	invoking this sets write to _ , move to R and state remains q5
				ptr = modified[++headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0, headIndex)
										+ t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else break;
		}
		
		
		if (t.getState().equals("q4"))
		{
			if (ptr.equals("0"))
			{
				t.q4Toq6();	//	invoking this sets write to 'x', move to L and state goes to q6
				modified[headIndex] = write;
				modifiedIn = "";
				for (int i=0; i<modified.length; i++)
					modifiedIn += modified[i];
				ptr = modified[--headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0, headIndex)
										+ t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else if (ptr.equals("x"))
			{
				t.q4Toq4();	//	invoking this sets write to _ , move to R and state remains q4
				ptr = modified[++headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0, headIndex)
										+ t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else break;
		}
		
		
		if (t.getState().equals("q6"))
		{
			if (ptr.equals("0") || ptr.equals("1") || ptr.equals("x"))
			{
				t.q6Toq6();	//	invoking this sets write to _ , move to L and state remains at q6
				ptr = modified[--headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0, headIndex)
									+ t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else if (ptr.equals("#"))
			{
				t.q6Toq7();	//	invoking this sets write to _ , move to L and state to q7
				ptr = modified[--headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				if (headIndex != 0)
					System.out.println("Current Configuration: " + modifiedIn.substring(0,headIndex)
										+ t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
				else
					System.out.println("Current Configuration: "
										+ t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else break;
		}
		
		
		if (t.getState().equals("q8"))
		{
			if (ptr.equals(" "))
			{
				t.q8Toqaccept();	//	invoking this sets write to _ , move to R and state goes to qaccept
				System.out.println("Accept State reached!");
				System.out.println("Current Configuration: " + modifiedIn.substring(0,modifiedIn.length()) + t.getState());
			}
			else if (ptr.equals("x"))
			{
				t.q8Toq8();	//	invoking this sets write to _ , move to R and state remains at q8
				ptr = modified[++headIndex];
				if (headIndex != modified.length)
					System.out.println("Head at: " + ptr + "\n" + "Tape: " + modifiedIn);
				System.out.println("Current Configuration: " + modifiedIn.substring(0, headIndex)
										+ t.getState() + modifiedIn.substring(headIndex, modifiedIn.length()));
			}
			else break;
		} 
      }
	  
	  if (!accept)
		  System.out.println("Reject!");
      
      
   }
}