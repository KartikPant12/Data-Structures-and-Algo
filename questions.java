


Recover a bst
https://leetcode.com/problems/recover-binary-search-tree/
class Solution {
    
    TreeNode a = null , b = null,prev = null;
    public boolean recover(TreeNode root)
    {
        if(root == null) return false;
        
        if(recover(root.left)) return true;
        
        if(prev!=null && prev.val >  root.val)
        {
            b = root;
            if(a == null) a = prev;
            else return true;
        }
        
        prev = root;
        if(recover(root.right)) return true;
        
        return false;
    }
    
    
    public void recoverTree(TreeNode root) {
      
        recover(root);
        
        if(a!=null)
        {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }
}




// 
to check if the tree is same or not!


class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
     
        
        if(p == null && q == null) return true;
        else if (p== null || q == null) return false;
        
        
        if(p.val!=q.val) return false;
        
        
    
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}




