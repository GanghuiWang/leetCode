package zuoshen.link.commonPart;

//为这个类新建一个Link结构
public class Node {
    /**
     * 构建单链表的单个节点
     */
    //基本类型
    public int value;
    //想要创建本类的一个对象

    public Node next;

    public Node (int data){
        this.value=data;
    }
}
