import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example input: n = 3, trust array
        int n = 3;
        int[][] trust = {{1,3},{2,3}};
        
        int judge = sol.findJudge(n, trust);
        System.out.println("The judge is: " + judge);
    }
}

class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean peopleTrust[] = new boolean[n+1];

        for(int i=0; i < trust.length; i++){
            peopleTrust[trust[i][0]] = true;
        }
        int count = 0;
        int i = 1;
        for(; i <= n; i++){
            if(!peopleTrust[i]){
                for(int j = 0; j < trust.length; j++){
                    if(trust[j][1] == i){
                        count++;
                    }
                }
                break;
            }
        }
        if(count == n-1){
            return i;
        }
        return -1;
    }
}