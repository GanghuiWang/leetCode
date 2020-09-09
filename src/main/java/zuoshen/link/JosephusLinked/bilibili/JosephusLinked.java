package zuoshen.link.JosephusLinked.bilibili;

public class JosephusLinked {
    public static void main(String[] args) {
        //创建一个环形单链表
        Node lastNode = new Node(10);
        Node node9 = new Node(9, lastNode);
        Node node8 = new Node(8, node9);
        Node node7 = new Node(7, node8);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node headNode = new Node(1, node2);
        lastNode.next = headNode;
        josephu(headNode,lastNode,10,2,3);
    }

    /**
     * 约瑟夫问题
     * @param headNode  环形单链表首节点
     * @param lastNode  环形单链表尾节点
     * @param size      环形单链表中的节点个数
     * @param start     从标号为start的小孩开始报数
     * @param count     每次数几下
     */
    public static void josephu(Node headNode,Node lastNode,int size,int start,int count){
        //1、处理不合法输入数据
        //1.1、处理headNode为null
        if (headNode == null) {
            throw new NullPointerException("head is null");
        }
        //1.2、如果start、size、count不合法的情况
        if (start < 1 || start > size || count < 1) {
            throw new IllegalArgumentException("参数不合法");
        }
        //2、从编号为start的小孩开始报数，并且使headNode指向该节点
        //2.1、把headNode和lastNode 向后移动start-1次(因为节点从1开始，所以为start-1次)
        for (int i = 0; i < start - 1; i++) {
            headNode = headNode.next;
            lastNode = lastNode.next;
        }
        //3定义一个循环，用于循环的执行报数操作
        //3.1、如果size=0，则链表结束，终止报数
        while (size != 0) {
            //4、执行报数操作，找到需要出圈的小孩，使用headNode指向需要出圈的节点
            //把headNode和lastNode往后移动count-1次
            for (int i = 0; i < count - 1; i++) {
                headNode = headNode.next;
                lastNode = lastNode.next;
            }
            //5、输出需要出圈的小孩的编号，即输出headNode保存的数据值
            System.out.println(headNode.data);
            //6、实现小孩的出圈操作
            //6.1、获得删除节点后的下一个节点
            Node nextNode = headNode.next;
            //6.2、将lastNode的下一个节点指向nextNode
            lastNode.next = nextNode;
            //6.3、设置headNode的next节点为null
            headNode.next = null;
            //7、更新size的值
            size--;
            //8、设置headNode指向nextNode
            headNode = nextNode;
        }
    }
    public static class Node{
        //用于保存节点中的值
        private Object data;
        //用于保存节点的下一个节点地址
        private Node next;

        /**
         * 构造方法
         * 专门为data做初始化的工作
         * @param data
         */
        public Node(Object data) {
            this.data = data;
        }

        /**
         * 构造方法
         * 专门为data做初始化的工作
         * @param data
         */
        public Node(Object data,Node next) {
            this.data = data;
            this.next = next;
        }


    }

}
