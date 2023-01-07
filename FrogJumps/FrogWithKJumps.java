package FrogJumps;

import java.util.*;
public class FrogWithKJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=in.nextInt();
		}
		System.out.println(kJumps(n-1,k,arr));// 0-based indexing
	}
	static int kJumps(int idx,int k,int[] arr)
	{
		if(idx==0)
			return 0;
		int minJumps=Integer.MAX_VALUE;
		for(int j=1;j<=k;j++)
		{
			if(idx-j>=0)
			{
				int jump=kJumps(idx-j,k,arr)+Math.abs(arr[idx]-arr[idx-j]);
				minJumps=Math.min(minJumps, jump);
			}
			else
				break;
		}
		return minJumps;
	}
}
