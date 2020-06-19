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
    private static Node stringToNode(String str){
        if(str == null){
            return null;
        }
        char[] c = str.toCharArray();
        Node first = null;
        Node last = null;
        for(int i = 0;i < c.length;i++){
            Node cur = new Node(c[i],null);
            if(i == 0){
                first = cur;
            }else {
                last.next = cur;
            }
            last = cur;
        }
        return first;
    }

    private static boolean isPalindrome(Node node){
        if(node == null || node.next == null){
            return false;
        }
        //是否是奇数node若是则从slowNode的next node开始比对，若不是则从slowNode开始比对
        boolean isOddNode = true;
        //快慢节点，用来判断中间节点
        Node slowNode = node;
        Node fastNode = node;
        //下一次循环的node，用来做reverse的中间node
        Node cur = null;
        Node last = null;
        while(fastNode != null && fastNode.next != null){
            last = cur;
            cur = new Node(slowNode.value,last);

            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if(fastNode == null){
                isOddNode = false;
            }

        }
        Node successor;
        if(isOddNode) {
            successor = slowNode.next;
        }else{
            successor = slowNode;
        }
        while (successor != null && cur != null){
            if(successor.value != cur.value){
                return false;
            }
            successor = successor.next;
            cur = cur.next;
        }
        return true;
    }

    //ConcurentHashMap value 不能为null ，hashmap可以为null
    public static void main(String[] args) {
        System.out.println(isPalindrome(stringToNode("abcba")));
    }
}
