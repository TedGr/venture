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
        if(node == null){
            return true;
        }
        //快慢节点，用来判断中间节点
        Node slowNode = node;
        Node fastNode = node;
        //下一次循环的node，用来做reverse的中间node
        Node cur = null;
        while(fastNode != null && fastNode.next != null){
            /*last = cur;
            cur = new Node(slowNode.value,last);*/
            Node last = cur;
            cur = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            cur.next = last;

        }

        //slowNode.next = cur;
        //若fastnode不为null，则是链长为奇数
        if(fastNode != null){
            slowNode = slowNode.next;
        }

        while (slowNode != null && cur != null){
            if(slowNode.value != cur.value){
                return false;
            }
            slowNode = slowNode.next;
            cur = cur.next;
        }
        return true;
    }

    //ConcurentHashMap value 不能为null ，hashmap可以为null
    public static void main(String[] args) {
        System.out.println(isPalindrome(stringToNode("abcba")));
    }
}
