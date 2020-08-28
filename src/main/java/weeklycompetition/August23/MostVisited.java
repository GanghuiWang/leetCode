package weeklycompetition.August23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MostVisited {
    public static void main(String[] args) {
        int[] rounds={1,3,5,7};
        for (int i:mostVisited(7,rounds)
             ) {
            System.out.println(i);
        }
    }
    public static List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<Integer>();
        int s=rounds[0];
        int e=rounds[rounds.length-1];
        if (s<=e){
            //如果未走满1圈，则经过的区域的次数都是1，只需将经过的区域依次放置到结果集即可。
            for (int i=s;i<=e;i++){
                ans.add(i);
            }
        }else {
            //如果走满一圈，只需要计算多出一圈的区域。
            //先计算起始点到该圈结束（该环形最大区域的节点）经过的区域
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
