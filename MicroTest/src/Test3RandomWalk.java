/*
 * This program simulates a random walk, the function move(); randomly moves a hypothetical counter 
 * either forward or backwards along a number line.
 * The goal of each function, bob with and without memory, is to ensure that the walk ends when the 
 * counter has taken a step forward from its orgiginal starting position.
 */


import java.util.Random;


public class Test3RandomWalk {
	
	static Random rand = new Random();
	
	public static void main (String[] args) 
	{
		// method 1, using memoy to store the counters position
		bobWithMemory();

		// method 2, using no memory, but a recursive function,
		bobWithOutMemory();
		
	}
	
	public static int move(){
		return (rand.nextInt(2) == 1 ? 1: -1);
	}
	
	public static void bobWithOutMemory() 
	{
		if (move() != 1)
		{
			bobWithOutMemory();
			bobWithOutMemory();
		}
	}
	
	public static void bobWithMemory()
	{
	int position = 0;
		
		while (position != 1)
			{
				position += move();
			}
	}
}
