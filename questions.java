


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


// to check if the trees are symettric or not

public boolean isSymmetric_(TreeNode root1,TreeNode root2){
        
        if(root1 == null && root2 == null) return true;
        else if(root1 == null || root2 == null || root1.val!=root2.val) return false;
        return isSymmetric_(root1.left,root2.right) && isSymmetric_(root1.right,root2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric_(root.left,root.right);
    }




// level order traversal of tree

public void solve(TreeNode root,  List<List<Integer>>  ans)
    {
        if(root == null) return;
        
        
        LinkedList<TreeNode> que  = new LinkedList<>();
        
        que.addLast(root);
        
        while(que.size()!=0){
            int size =que.size();
            ArrayList<Integer> res = new ArrayList<>();
            while(size-->0){
                TreeNode vtx = que.removeFirst();
                
                res.add(vtx.val);
                
                if(vtx.left!=null) que.addLast(vtx.left);
                 if(vtx.right!=null) que.addLast(vtx.right);
            }
            
            ans.add(res);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>>  ans = new ArrayList<>();
        solve(root,ans);
        
        
        return ans;
        
    }

