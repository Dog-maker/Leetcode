package leetcode.editor.cn;


public class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public void out() {
        ListNode node = new ListNode();
        node.val = val;
        node.next = next;
        while (true){
            System.out.print(node.val+" ");
            if(node.next == null)
                break;
            node = node.next;
        };
        System.out.println();
    }
}