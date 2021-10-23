#DSA

Add the dsa problems here!


inorder traversal of a tree

class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}

find unoque binary trees

public int catalan(int n , int [] dp)
    {
        
        dp[0] = dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = 0;
            for(int j=0;j<i;j++){
                dp[i] +=  dp[j] * dp[i-j-1];
            }
        }
        
        return dp[n];
    }
    public int numTrees(int n) {
        
        
        int [] dp = new int[n+2];
        
        return catalan(n,dp);
    }



//check if bst is valid

class Solution {
public:
    long btsval = -1e14;
    
    bool isValidBST(TreeNode* root) {
     
        
        if(root == nullptr) return true;
        
        if(!isValidBST(root->left))  return false;
        
        if(btsval>=root->val) return false;
        btsval = root->val;
        if(!isValidBST(root->right)) return false;
        
        return true;
    }
};

<!-- Please upvote to motivate me in my quest of documenting all leetcode solutions. HAPPY CODING:) -->
class Solution {
public:
int deepestLeavesSum(TreeNode* root) {
queue<TreeNode* > q;
if(root==nullptr)
return 1;
q.push(root);
int sum=0;
int curr_sum;
while(!q.empty())
{
size_t size=q.size();
curr_sum=0;
for(int i=0;i<size;i++)
{
TreeNode* curr=q.front();
q.pop();
curr_sum+=curr->val;
if(curr->left)
q.push(curr->left);
if(curr->right)
q.push(curr->right);
}
sum=curr_sum;
}
return sum;
}
};


