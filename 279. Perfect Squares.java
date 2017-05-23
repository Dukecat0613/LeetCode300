public class Solution {
    public int numSquares(int n) {
        if(n<=0){
            return 0;
        }
        
        int[] dp=new int[n+1];
        dp[0]=0;
        for (int i=0;i<=n;i++){
            dp[i]=i;
            for (int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i-j*j]+1,dp[i]);
            }
        }
        
        return dp[n];
        
    }
}
