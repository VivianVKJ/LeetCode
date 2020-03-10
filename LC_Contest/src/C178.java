import java.util.Arrays;
import java.util.HashMap;

public class C178 {
    public static void main(String[] args) {
        String[] votes = {"BCA","CAB","CBA","ABC","ACB","BAC"};
//        System.out.println(rankTeams(votes));
    }
    /*
    public static String rankTeams(String[] votes) {
        int voter = votes.length;
        if(voter == 1) return votes[0];
        int cand = votes[0].length();
        int[][] record = new int[26][cand]; //name,
        for(String s : votes){
            for(int i=0;i<s.length();i++){ //i equals to rank
                record[s.charAt(i)-'A'][i]++;
            }
        }
        String res[] = new String[26];

        for(int i=0;i<26;i++){
            StringBuilder score = new StringBuilder();
            for(int c=0 ;c < cand; c++){
                if(record[i][c]>0) score.append(String.valueOf((cand-c)*record[i][c]));
                else score.append("0");
            }
            res[i] = score.toString();
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<26;i++){
            if(map.containsKey(res[i]))
                map.put()
            map.put(res[i],i);
        }
        Arrays.sort(res);
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<cand;i++){
            char name = (char) (map.get(res[26-i-1]) + 'A');
            ans.append(name);
        }
        return ans.toString();
    }
    */
}
