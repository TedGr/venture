package algorithm;

/**
 * Description:
 * 回文字符串
 * @author: gongran
 * @date: 2020/6/17
 */
public class Reverse {

    public static class Node{
        char value;
        Node next;

        public Node(char value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        String s = "aaaabbbbaaaa";
        char[] c = s.toCharArray();
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
        System.out.println(first);





    }
}
