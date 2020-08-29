package leetcode.questionBank.linkedSum;


import java.util.ArrayList;
import java.util.List;

public class LinkedSum {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(6);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(9);
        node2.next.next = new ListNode(2);
        traverseSingleNode(addTwoNumbers(node1, node2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)return l2;
        if(l2 == null)return l1;
        ListNode res = l1, pre = l1;
        //都给l1节点值加上，先不算进位
        while(l1 != null && l2 != null){
            pre = l1;
            l1.val += l2.val;
            l1 = l1.next;
            l2 = l2.next;
        }
        //l2比l1节点多，链入l1后面
        if(l2 != null)pre.next = l2;
        //从头计算进位
        int carry = 0;
        //讲最初的l1重新赋值给l1
        l1 = res;
        while(l1 != null){
            l1.val += carry;//计算进位，加在下一位（l1.next.val）
            carry = l1.val / 10;//计算进位
            l1.val %= 10;//不管l1.val是否大于10，都可以取余，然后取余后加在下一位
            pre = l1;//处理过的l1交给pre
            l1 = l1.next;//处理l1的下一个节点
        }
        //最后如果carry>0，添加一位
        if(carry > 0)pre.next = new ListNode(carry);
        return res;
    }
    public static void traverseSingleNode(ListNode head){
        List<Integer> list = new ArrayList<Integer>();
        while (head!=null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i:list
        ) {
            System.out.println(i);
        }
    }
}
