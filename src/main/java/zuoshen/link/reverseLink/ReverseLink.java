package zuoshen.link.reverseLink;

import java.util.ArrayList;
import java.util.List;

public class ReverseLink {
    public static void main(String[] args) {
        Node single1 = new Node(5);
        single1.next = new Node(6);
        single1.next.next = new Node(7);
        single1.next.next.next = new Node(8);
        traverseSingleNode(reverseSingle(single1));

        //定义双向链表
        DoubleNode double1 = new DoubleNode(5);
        double1.next = new DoubleNode(6);
        double1.next.last = double1;
        double1.next.next = new DoubleNode(7);
        double1.next.next.last = double1.next;
        double1.next.next.next = new DoubleNode(8);
        double1.next.next.next.last = double1.next.next;
        DoubleNode res = reverseDouble(double1);
        traverseDoubleNode(reverseDouble(double1));
        System.out.println(res);
    }

    public static Node reverseSingle(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            //在pre前加上head.next;
            head.next = pre;
            pre = head;
            //将新赋head后部分赋值给head
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDouble(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void traverseSingleNode(Node head){
        List<Integer> list = new ArrayList<Integer>();
        while (head!=null) {
            list.add(head.value);
            head = head.next;
        }
        for (int i:list
             ) {
            System.out.println(i);
        }
    }

    public static void traverseDoubleNode(DoubleNode head){
        List<Integer> list = new ArrayList<Integer>();
        while (head!=null) {
            list.add(head.value);
            head = head.next;
        }
        for (int i:list
        ) {
            System.out.println(i);
        }
    }


}
