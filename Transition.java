import java.util.*;

public class Transition extends Turing
{
	String[] Q = {"q1","q2","q3","q4","q5","q6","q7","q8","qaccept"};
	String state;
	
	public Transition()
	{
		state = Q[0];
	}
	
	public String getState()
	{
		return state;
	}
	
	//	WRITE SET OF METHODS DETERMINING WHAT TO WRITE / WHERE TO MOVE DEPENDING
	//	ON CURRENT STATE AND CURRENT HEAD
	
	public void q1Toq3()	//	1 is read at q1, write an 'x' and move R
	{
		write = "x";
		move = "R";
		state = Q[2];	//	now in state q3
	}
	
	public void q1Toq2()	//	0 is read at q1, write an 'x' and move R
	{
		write = "x";
		move = "R";
		state = Q[1];	//	now in state q2
	}
	
	public void q3Toq3()	//	0 or 1 read at q3, write nothing and move R
	{
		write = " ";
		move = "R";
		//	no change in state, stays at q3
	}
	
	public void q2Toq2()	//	0 or 1 read at q2, write nothing and move R
	{
		write = " ";
		move = "R";
		//	no change in state, stays at q2
	}
	
	public void q3Toq5()	//	# read at q3, write nothing and move R
	{
		write = " ";
		move = "R";
		state = Q[4];	//	now in state q5
	}
	
	public void q2Toq4()	//	# read at q2, write nothing and move R
	{
		write = " ";
		move = "R";
		state = Q[3];	//	now in state q4
	}
	
	public void q5Toq5()	//	x read at q5, write nothing and move R
	{
		write = " ";
		move = "R";
		//	no change in state, stays at q5
	}
	
	public void q4Toq4()	//	x read at q4, write nothing and move R
	{
		write = " ";
		move = "R";
		//	no change in state, stays at q4
	}
	
	public void q5Toq6()	//	1 read at q5, write an 'x' and move L
	{
		write = "x";
		move = "L";
		state = Q[5];	//	now in state q6
	}
	
	public void q4Toq6()	//	0 read at q4, write an 'x' and move L
	{
		write = "x";
		move = "L";
		state = Q[5];	//	now in state q6
	}
	
	public void q6Toq6()	//	0,1 or x read at q6, write nothing and move L
	{
		write = " ";
		move = "L";
		//	no change in state, stays at q6
	}
	
	public void q6Toq7()	//	# read at q6, write nothing and move L
	{
		write = " ";
		move = "L";
		state = Q[6];	//	now in state q7
	}
	
	public void q7Toq7()	//	0 or 1 read at q7, write nothing and move L
	{
		write = " ";
		move = "L";
		//	no change in state, stays at q7
	}
	
	public void q7Toq1()	//	x read at q7, write nothing and move R
	{
		write = " ";
		move = "R";
		state = Q[0];	//	goes back to state q1
	}
	
	public void q1Toq8()	//	# read at q1, write nothing and move R
	{
		write = " ";
		move = "R";
		state = Q[7];	//	now in state q8
	}
	
	public void q8Toq8()	//	x read at q8, write nothing and move R
	{
		write = " ";
		move = "R";
		//	no change in state, stays at q8
	}
	
	public void q8Toqaccept()	//	_ read at q8, write nothing and move R
	{
		write = " ";
		move = "R";
		state = Q[Q.length-1];	//	reached final state, qaccept
		accept = true;
		//System.out.println("Accept!");
	}
}