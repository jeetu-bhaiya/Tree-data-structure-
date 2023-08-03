public class ConstructTreeFromPreorderInorder {
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val=val;
        }

    }
    TreeNode helper(int[] preorder,int prelo,int prehi,int[] inorder,int inlo,int inhi){
        if(prelo>prehi) return null;
        TreeNode root=new TreeNode(preorder[prelo]);
        int i=inlo;
        while(inorder[i]!=preorder[prelo]) i++;
        int leftSize=i-inlo;
        root.left=helper(preorder,prelo+1,prelo+leftSize,inorder,inlo,i-1);
        root.right=helper(preorder,prelo+leftSize+1,prehi,inorder,i+1,inhi);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return helper(preorder,0,n-1,inorder,0,n-1);

    }
}
