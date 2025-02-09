class Solution {
    //tc-o(mn) sc-o(mn)
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        //toprow
        for(int j=1;j<dp[0].length;j++)
        {
            dp[0][j] = j;
        }

        //first column
        for(int i=1;i<dp.length;i++)
        {
            dp[i][0] = i;
        }

        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                //case where last char is matching take Diagonal
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]))+1;
                }
            }
        }
        return dp[m][n];
    }
}