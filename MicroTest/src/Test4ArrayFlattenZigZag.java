/*
 * Given a 2 dimensional array, the problem was to flatten in into a one dimensional array
 * but following a zig zag pattern throught the columns
 * 
 * 
 */
public class Test4ArrayFlattenZigZag 
{
	public static void main (String[] args) 
	{
		
		char[][] array = {{'a','b','c','d','e','f'}, 
						  {'g','h','i','j','k','l'},
						  {'m','n','o','p','q','r'},
						  {'s','t','u','v','w','x'}};
			
		char[] oneD = flatten(array);
		
		System.out.print("With a for loop:   ");

		for (int i = 0; i < oneD.length; i++)
		{
			System.out.print(oneD[i] + ",");
			//output: a,g,m,s,t,n,h,b,c,i,o,u,v,p,j,d,e,k,q,w,x,r,l,f,
		}
		System.out.println();
		System.out.println();

		
		//another method for flattening in the same zigzag pattern, this one considered after the test,
		oneD = flatten2(array);
	
		System.out.print("With a while loop: ");

		for (int i = 0; i < oneD.length; i++)
		{
			System.out.print(oneD[i] + ",");
			//output: a,g,m,s,t,n,h,b,c,i,o,u,v,p,j,d,e,k,q,w,x,r,l,f,
		}

	}


	private static char[] flatten(char[][] array) 
	{
		
		char[] oneD = new char[array.length*array[0].length];
		int index = 0;
		
		for (int col = 0; col < array[0].length; col++) 
		{
			if (col % 2 == 0) 
			{
				for (int row = 0; row < array.length; row++) 
				{
					oneD[index++] = array[row][col];
				}
			} else 
			{
				for (int row = array.length - 1; row >= 0; row--) 
				{
					oneD[index++] = array[row][col];

				}
			}
		}
		
		return oneD;
	}
	

	private static char[] flatten2(char[][] array) 
	{
		char[] oneD = new char[array.length*array[0].length];
		int index = 0;
		int row = 0;
		int col = 0;
		int inc = 1;
		

		while (index < oneD.length ) 
		{
			oneD[index++] = array[row][col];	
			row += inc;
		
			if (row < 0 || row > array.length -1) 
			{
				inc *= -1;
				col++;
				row += inc;
			}
		}
		
		
		return oneD;
	}
}

