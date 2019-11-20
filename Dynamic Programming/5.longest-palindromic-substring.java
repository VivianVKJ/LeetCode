/*
 * @lc app=leetcode id=5 lang=java
 *  "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int start = 0,end = 0,max =1;
        if(s.length()<=1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i =0;i<s.length();i++)
            dp[i][i]=true;
    
        for(int j=1;j<s.length();j++){ //j is the length
            for(int i=0;i+j<s.length();i++){
                if(j==1) //len=2
                        dp[i][i+j]=s.charAt(i)==s.charAt(i+j)?true:false;
                else   //len>2
                    dp[i][i+j] = dp[i+1][i+j-1] && s.charAt(i)==s.charAt(i+j);
                //System.out.printf("dp[%d][%d]=%s ",i,i+j,dp[i][i+j]==true?"true":"fasle");
                if(dp[i][i+j]==true && j>end-start){
                    start = i ;
                    end =i+j;
                    max = j+1;
                } 
            }
        }
        return s.substring(start,end+1);
    }
}
// @lc code=end

