public class C181 {
    public static void main(String[] args) {
        String s = "ababab";
        System.out.println(longestPrefix(s));
    }
    public static String longestPrefix(String s) {
        String ans = "";
        int n = s.length();
        StringBuilder pre = new StringBuilder();
        StringBuilder suf = new StringBuilder();
        if(n==1) return ans;
        for(int i=0;i<n-1;i++){
            pre = pre.append(s.charAt(i));
            suf = suf.insert(0,s.charAt(n-i-1));
            System.out.println("pre = "+pre+" , suf = "+suf);
            if(pre.toString().compareTo(suf.toString())==0) ans = pre.toString();
        }
        return ans;
    }
}
