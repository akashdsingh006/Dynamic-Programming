package FrogJumps;

import java.util.Arrays;
import java.util.Scanner;
public class FrogWithKJumpsMemoization {

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
		int dp[]=new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println(kJumps(n-1,k,arr,dp));// 0-based indexing
	}
	static int kJumps(int idx,int k,int[] arr,int dp[])
	{
		if(idx==0)
			return 0;
		
		if(dp[idx]!=-1)
			return dp[idx];
		
		int minJumps=Integer.MAX_VALUE;
		for(int j=1;j<=k;j++)
		{
			if(idx-j>=0)
			{
				int jump=kJumps(idx-j,k,arr,dp)+Math.abs(arr[idx]-arr[idx-j]);
				minJumps=Math.min(minJumps, jump);
			}
			else
				break;
		}
		dp[idx]=minJumps;
		return dp[idx];
	}
}
