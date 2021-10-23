


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



right view of a bst
public void rightview(TreeNode root,ArrayList<Integer> ans)
    {
        LinkedList<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        
        
        while(qu.size()!=0)
        {
            int size = qu.size();
            ans.add(qu.getFirst().val);
            while(size -- >0)
            {
                
                TreeNode vtx = qu.removeFirst();
                
                if(vtx.right!=null) qu.addLast(vtx.right);
                if(vtx.left != null) qu.addLast(vtx.left);
                
            }
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return new ArrayList<>();
        
      ArrayList<Integer> ans = new ArrayList<>();
        
        rightview(root,ans);
        return ans;
        
    }

  post order traversal
  
   public class pair{
        TreeNode node = null;
        boolean leftdone = false;
        boolean rightdone = false;
        boolean selfdone = false;
        
        pair(TreeNode node ,  boolean selfdone, boolean leftdone , boolean rightdone){
            this.node = node;
            this.selfdone = selfdone;
            this.leftdone = leftdone;
            this.rightdone = rightdone;
        }
    }
    
    
    
    public List<Integer> postorderTraversal(TreeNode root) {
     if(root == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        Stack<pair> st = new Stack<>();
        st.push(new pair(root,false,false,false));
        while(st.size()!=0){
            pair rp = st.peek();
            
            if(!rp.leftdone){
                rp.leftdone = true;
                if(rp.node.left!=null) st.push(new pair(rp.node.left,false,false,false));
            }else if(!rp.rightdone){
                rp.rightdone = true;
                if(rp.node.right!=null) st.push(new pair(rp.node.right,false,false,false));
            }else if(!rp.selfdone){
                rp.selfdone = true;
                ans.add(rp.node.val);
            }else{
                st.pop();
            }
        }
        return ans;
    }

find the sum from root

public int NumSum(TreeNode root ,int val){
        if(root == null) return 0;
        
        val = val*10 + root.val;
        
        if(root.left == null && root.right == null) return val;
        
        
        return NumSum(root.left,val)+NumSum(root.right,val);
    }
    
    public int sumNumbers(TreeNode root) {
        return NumSum(root,0);
        // return a;
    }


preorder traversal

public class pair{
        TreeNode node = null;
        boolean selfdone = false;
        boolean leftdone = false;
        boolean rightdone = false;
        
        pair(TreeNode node,boolean selfdone,boolean leftdone,boolean rightdone){
            this.node = node;
            this.selfdone = selfdone;
            this.leftdone = leftdone;
            this.rightdone = rightdone;
        }
    }
    
    
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<pair>  st = new Stack<>();
        st.push(new pair(root,false,false,false));
        
        
        while(st.size()!=0){
            pair rp = st.peek();
            
            if(!rp.selfdone){
                rp.selfdone = true;
                ans.add(rp.node.val);
                // System.out.print(rp.node.val+" ");
            }else if(!rp.leftdone){
                rp.leftdone = true;
                if(rp.node.left!=null) st.push(new pair(rp.node.left,false,false,false));
            }else if(!rp.rightdone){
                rp.rightdone = true;
                if(rp.node.right!=null) st.push(new pair(rp.node.right,false,false,false));
            }else{
                st.pop();
            }
            
        }
        return ans;
    }


