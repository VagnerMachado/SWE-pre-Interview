
package pack;
import java.util.ArrayList;
import java.util.Arrays;

/**                                                         
 * These questions were asked during a pre-interview for an internship as SWE.
 * Correctness was emphasized over efficiency.
 * 
 * @author Vagner Machado
 */
class solution
{
	public static void main(String[] args) 
	{

		Integer [] xx = {1,2,5,7,8,9,10,6,2,};
		Integer [] arr = solution1(xx,2);
		System.out.println("Highest sequence: " + Arrays.toString(arr));

		//Test
		//		String l = new String ("aXbbXcccX dddd                   XeeeXee");
		//		String [] lNew = l.split("\\s+"); //one or more spaces
		//		System.out.println(Arrays.toString(lNew) + " with length " + lNew.length);


		String x = "abcd,aabc,bd";
		String y = "aaa,aa,bdf";
		int [] k = (solution2(x,y));
		System.out.println("This is the string precedence comparator " + Arrays.toString(k));
	}

	/**
	 * 
	 * Find the highest consecutive run of K integers in array N
	 * @param N - an array of integers
	 * @param K - the number of sequence
	 * @return - an array with highest run.
	 * 
	 * Integer [] K = {1,2,5,7,8,9,10,6,2,}, K = 3
	 * returns {8,9,10}
	 */
	static Integer[] solution1(Integer[] N, int K) 
	{

		ArrayList<Integer []> arrays = new ArrayList<>();
		for(int i = 0; i < (N.length - K + 1); i++)
			arrays.add(Arrays.copyOfRange(N, i, i + K));

		int start = -1;
		int maxStart = Integer.MIN_VALUE;
		for(int i = 0; i < arrays.size();i++)
		{
			//find max
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < K; j++)
			{
				if(arrays.get(i)[j] > max)
					max = arrays.get(i)[j];
				if(arrays.get(i)[j] < min)
					min = arrays.get(i)[j];
			}
			if (max - min == K - 1 && max > maxStart)
				start = i;
		}
		return Arrays.copyOfRange(N, start, start + K);
	}

	/**
	 * Given two string containing strings delimited by commas, return an array of integers representing
	 * how many strings in A are greater than each each string in B.
	 * 
	 * String A= "abcd,aabc,bd";
	 * String B = "aaa,aa,bdf";
	 * returns [3,3,0]  because aaa < 3 strings in A; aa < 3 strings in A, 0 because bdf < 0 strings in A
	 * @param A - the string of strings to compare to 
	 * @param B - the string of strings being compared
	 * @return - an array of integers
	 */
	static int[] solution2(String A, String B) 
	{
		String [] arr = A.split(",");
		String [] brr = B.split(",");

		int [] ans = new int [brr.length];
		for(int i = 0; i < brr.length; i++)
		{
			for(int j = 0; j < arr.length; j++)
			{
				if(brr[i].compareTo(arr[j]) < 0)
					ans[i]++;
			}
		}

		return ans;
	}

}
