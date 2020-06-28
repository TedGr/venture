package algorithm;

/**
 * Description:
 * 判断链表是否有环
 * @author: gongran
 * @date: 2020/6/22
 */
public class Cycle {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fastNode = null;
        while(head != null && head.next!=null){
            fastNode = head.next.next;
            if(head == fastNode){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(-4);
        listNode.next.next.next.next = listNode.next;
        hasCycle(listNode);
    }
}
