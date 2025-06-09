import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter number of people (n): ");
        int n = sc.nextInt();

        System.out.print("Enter number of trust relationships: ");
        int m = sc.nextInt();

        int[][] trust = new int[m][2];
        System.out.println("Enter trust pairs (a b) meaning 'a trusts b':");
        for(int i = 0; i < m; i++){
            trust[i][0] = sc.nextInt();
            trust[i][1] = sc.nextInt();
        }

        int judge = sol.findJudge(n, trust);
        System.out.println("The judge is: " + judge);
        sc.close();
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
