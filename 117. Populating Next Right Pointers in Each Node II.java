public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode tmp = dummy;
        while (root != null) {
            if (root.left != null) {
                tmp.next = root.left;
                tmp = tmp.next;
            }
            if (root.right != null) {
                tmp.next = root.right;
                tmp = tmp.next;   
            }
            root = root.next;
            if (root == null) {
                tmp = head;
                root = head.next;
                head.next = null;
            }
        }
    }
}
