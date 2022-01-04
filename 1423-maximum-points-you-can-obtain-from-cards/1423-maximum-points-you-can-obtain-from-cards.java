class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] prefix = new int[k+1];
        int[] suffix = new int[k+1];
        prefix[0]=0;
        for(int i=1;i<=k;i++)
            prefix[i]=prefix[i-1]+cardPoints[i-1];
        suffix[k]=0;
        int l=cardPoints.length-1;
        for(int j=k-1;j>=0;j--)
            suffix[j]=suffix[j+1]+cardPoints[l--];
        int sum=Integer.MIN_VALUE;
        for(int i=0;i<=k;i++)
            sum=Math.max(prefix[i]+suffix[i], sum);
        return sum;
    }
}