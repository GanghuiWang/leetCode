package zuoshen.stack.maxWindow;

import java.util.LinkedList;

public class GetMaxWindow {
    public static void main(String[] args) {
        int[] arr={4,3,5,4,3,3,6,7};
        int w=3;
        int[] result = getMaxWindow(arr, w);
        for (int i = 0; i <result.length ; i++) {
            System.out.print(result[i]+" ");
        }
    }

    public static int[] getMaxWindow(int[] arr,int w){
      //先判断arr是不是空，w是不是小于1，窗口长度是不是大于数组总长度
        if(arr==null||w<1||w>arr.length){
            return null;
        }
        //定义一个LinkedList数组
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        //定义一个结果集用来存放每个窗口中最大的数,这个结果集的长度等于数组总长减去窗口长度再加上1
        int[] res = new int[arr.length - w + 1];
        //定义一个起始点
        int index=0;
        //核心算法,qmax始终存放窗口中最大的数
        //①遍历
        for (int i = 0; i < arr.length; i++) {
           //②存放最大的,这个while循环会控制qmax,如果qmax不为空，那么qmax必定存arr[]中最大的数对应的下标
           while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]){
               qmax.pollLast();
           }
           qmax.addLast(i);
           //③如果qmax中存放的第一个下标大于当前i减去窗口长度，即i不在当前窗口内，自然要移除该下标
           if(qmax.peekFirst()==i-w){
                qmax.pollFirst();
           }
           //④如果i等于w-1，即i处于第一个窗口最后一位，这时开始记录当前窗口最大值
            if (i >= w - 1) {
                //index不等于i的值
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
