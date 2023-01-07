package FrogJumps;

import java.util.Arrays;
import java.util.Scanner;

public class KJumpsWithTabulation {

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
		dp[0]=0;
		
		for(int idx=1;idx<n;idx++)
		{
			int minJump=Integer.MAX_VALUE;
			for(int j=1;j<=k;j++)
			{
				if(idx-j>=0)
				{
					int jump=dp[idx-j]+Math.abs(arr[idx]-arr[idx-j]);
					minJump=Math.min(minJump, jump);
				}
				else
					break;
			}
			dp[idx]=minJump;
		}
		System.out.println(dp[n-1]);
	}

}
