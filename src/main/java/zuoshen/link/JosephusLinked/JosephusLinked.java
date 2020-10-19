package zuoshen.link.JosephusLinked;


import java.util.ArrayList;
import java.util.List;

/**
 * 环形单链表约瑟夫问题
 */
public class JosephusLinked {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(5);
        node.next.next.next = new Node(7);
        node.next.next.next.next = new Node(8);
        node.next.next.next.next.next = node.next;
        traverseSingleNode(JosephusKill(node, 3));
    }
    public static Node JosephusKill(Node head,int m){
        if(head==null||head.next==head||m<1){
            return head;
        }
        //打造链式结构
        Node last = head;
        while (last.next!=null){
            last = last.next;
        }
        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
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
}
