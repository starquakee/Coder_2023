public class num2236 {
    public boolean checkTree(TreeNode root) {
        return root.val==root.left.val+root.right.val;
    }
}
