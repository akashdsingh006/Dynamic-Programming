static int minimumPathSum(int[][] triangle, int n){
     
     int front[] = new int[n];
     int cur[] = new int[n];
    
    for(int j=0;j<n;j++){
        front[j] = triangle[n-1][j];
    }
    
    for(int i=n-2; i>=0; i--){
        for(int j=i; j>=0; j--){
            
            int down = triangle[i][j]+front[j];
            int diagonal = triangle[i][j]+front[j+1];
            
            cur[j] = Math.min(down, diagonal);
        }
        front=cur;
    }
    
    return front[0];
    
}
