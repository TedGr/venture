package algorithm;

/**
 * Description:
 * 回文字符串
 * @author: gongran
 * @date: 2020/6/17
 */
public class Palindrome {

    public static class Node{
        char value;
        Node next;

        public Node(char value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //将字符串转化成字符数组从链尾依次插入
    private Node stringToNode(String str){
        char[] c = str.toCharArray();
        Node first = new Node(Character.MIN_VALUE,null);
        Node last = null;
        for(int i = 0;i < c.length;i++){
            Node cur = new Node(c[i],null);
            if(i == 0){
                first.next = cur;
            }else {
                last.next = cur;
            }
            last = cur;
        }
        return first;
    }

    private boolean isReverse(Node node){
        //是否是奇数node，若是则从中间node的next node开始比对，若不是则从中间node开始比对
        boolean isOddNode = true;
        //快慢节点，用来判断中间节点
        Node slowNode = node;
        Node fastNode = node;
        Node last;
        while(fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if(fastNode == null){
                isOddNode = false;
                fastNode = fastNode.next;
            }
            last = slowNode;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
