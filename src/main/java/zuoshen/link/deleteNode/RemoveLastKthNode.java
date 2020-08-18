package zuoshen.link.deleteNode;

public class RemoveLastKthNode {
    public static void main(String[] args) {
        Node node1 = new Node(5);
        node1.next = new Node(6);
        node1.next.next = new Node(7);
        node1.next.next.next = new Node(8);
        removeLastKthNode(node1,2);
        //System.out.println(removeLastKthNode(node1,3));

        DoubleNode node2 = new DoubleNode(10);
        node2.next = new DoubleNode(9);
        node2.next.last = node2;
        node2.next.next = new DoubleNode(8);
        node2.next.next.last=node2.next;
        node2.next.next.next = new DoubleNode(7);
        node2.next.next.next.last=node2.next.next;
        node2.next.next.next.next = new DoubleNode(6);
        node2.next.next.next.last = node2.next.next.next;
        removeLastKthDoubleNode(node2,2);
        //System.out.println(removeLastKthDoubleNode(node2,3));
    }
    public static Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
    public static DoubleNode removeLastKthDoubleNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
            head.last = null;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = cur;
            }
        }
        return head;
    }
}
