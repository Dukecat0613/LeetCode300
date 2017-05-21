public class Solution {
    TreeNode errOne = null;
    TreeNode errTwo = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        // inorder traversal of BST is always sorted
        // once the previous node is greater than later node
        // there must be somthing wrong
        inorder(root);
        if (errOne != null) {
            int tmp = errOne.val;
            errOne.val = errTwo.val;
            errTwo.val = tmp;
        }
    }
    
    public void inorder (TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        // sth wrong
        if (prev != null && prev.val > root.val) {
            if (errOne == null) {
                errOne = prev;
                errTwo = root;
            } else {
                errTwo = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
