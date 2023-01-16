class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int prev[]=new int[b];
        //Arrays.fill(prev,0);
        
        
        for(int i=0;i<a;i++)
        {
            int temp[]=new int[b];
            for(int j=0;j<b;j++)
            {
                if(i==0&&j==0)
                {
                    temp[j]=1;
                    continue;
                }
                int up=0,left=0;
                if(i>0)
                    up=prev[j];
                if(j>0)
                    left=temp[j-1];
                    
                temp[j]=up+left;
                
            }
            prev=temp;
        }
        return prev[b-1];
    }
}
