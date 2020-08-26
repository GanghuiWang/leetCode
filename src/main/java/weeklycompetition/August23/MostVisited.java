package weeklycompetition.August23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MostVisited {
    public static void main(String[] args) {
        int[] rounds={1,3,1,2};
        for (int i:mostVisited(4,rounds)
             ) {
            System.out.println(i);
        }
    }
    public static List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<Integer>();
        int s=rounds[0];
        int e=rounds[rounds.length-1];
        if (s<=e){
            for (int i=s;i<=e;i++){
                ans.add(i);
            }
        }else {
            for (int i=s;i<=n;i++){
                ans.add(i);
            }
            for (int i=1;i<=e;i++){
                ans.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }

}
