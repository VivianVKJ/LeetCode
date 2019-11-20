/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */
class Solution {
       public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<String>();
        if(s.length()<4||s.length()>12) return results;
        List<String> current = new ArrayList<String>();
        findIp(s,results,0,current);
        return results;
    }
        public void findIp(String s,List<String> results,int index,List<String> current){
        if(current.size()==4 && index==s.length()) {
            results.add(outputIP(current));
            // System.out.print(" √ ");
            return;
        }
        else if(current.size()==4||index>=s.length()) return;
        for(int i=index;i<s.length()&&i<index+3;i++){  //ERROR 1
            //Tip: substring(begin,end) 
 
            if(isValid(s.substring(index,i+1))){
                current.add(s.substring(index,i+1));
                findIp(s,results,i+1,current);
                current.remove(current.size()-1);
            }
        }
    }
    public boolean isValid(String add){
        int temp=0,len=add.length();
        if(len>1 && add.charAt(0)=='0')
            return false;
        for(int i=0;i<len;i++)
            temp = temp*10 + (add.charAt(i)-'0');
        if(temp>=0 && temp<256) return true;
        return false;
    }
    public String outputIP(List<String> current){
        StringBuilder ip = new StringBuilder();
        for(int i=0;i<4;i++){
            ip.append(current.get(i));
            if(i<3) ip.append(".");
        }
        System.out.print(ip.toString()+"| ");
        return ip.toString();
    }
}

