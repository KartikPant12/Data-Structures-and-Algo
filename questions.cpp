
Hi 
The differences between cpp and java are as follows:-
Java doesn't support default arguments like C++. 
Java does not support header files like C++. 
Java uses the import keyword to include different 

1.
Most imp question :
Tree Traveral
struct Node {
    int data;
    struct Node *left, *right;
    Node(int data)
    {
        this->data = data;
        left = right = NULL;
    }
};
 
/* Given a binary tree, print its nodes according to the
"bottom-up" postorder traversal. */
void printPostorder(struct Node* node)
{
    if (node == NULL)
        return;
 
    // first recur on left subtree
    printPostorder(node->left);
 
    // then recur on right subtree
    printPostorder(node->right);
 
    // now deal with the node
    cout << node->data << " ";
}
 
/* Given a binary tree, print its nodes in inorder*/
void printInorder(struct Node* node)
{
    if (node == NULL)
        return;
 
    /* first recur on left child */
    printInorder(node->left);
 
    /* then print the data of node */
    cout << node->data << " ";
 
    /* now recur on right child */
    printInorder(node->right);
}
 
/* Given a binary tree, print its nodes in preorder*/
void printPreorder(struct Node* node)
{
    if (node == NULL)
        return;
 
    /* first print data of node */
    cout << node->data << " ";
 
    /* then recur on left subtree */
    printPreorder(node->left);
 
    /* now recur on right subtree */
    printPreorder(node->right);
}
 
/* Driver program to test above functions*/
int main()
{
    struct Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);
 
    cout << "\nPreorder traversal of binary tree is \n";
    printPreorder(root);
 
    cout << "\nInorder traversal of binary tree is \n";
    printInorder(root);
 
    cout << "\nPostorder traversal of binary tree is \n";
    printPostorder(root);
 
    return 0;
}

/// path sum
class Solution {
public:
    bool helper(TreeNode* root, int targetSum) {
        if (!root) return false;
        if (!root->left && !root->right) {
            return targetSum - root->val == 0;
        }
        
        return helper(root->left, targetSum - root->val) || helper(root->right, targetSum - root->val);
    }
    bool hasPathSum(TreeNode* root, int targetSum) {        
        return helper(root, targetSum);
    }
};



// sum rot to leaf
class Solution {
public:
    int sol=0;
    int sumNumbers(TreeNode* root) {
        build(root,0);
        return sol;
    }
    void build(TreeNode* root,int n)
    {
        if(root)
        {
             n=n*10+root->val;
            if(root->left==NULL && root->right==NULL)
            {
                sol+=n;
                return ;
            }
            build(root->left,n);
            build(root->right,n);
        }
    }
};

class Solution {
public:
    int sol=0;
    int sumNumbers(TreeNode* root) {
        build(root,0);
        return sol;
    }
    void build(TreeNode* root,int n)
    {
        if(root)
        {
             n=n*10+root->val;
            if(root->left==NULL && root->right==NULL)
            {
                sol+=n;
                return ;
            }
            build(root->left,n);
            build(root->right,n);
        }
    }
};

//  C++ || DFS || BFS || DFS IS BETTER IN BOTH T.C AND S.C
class Solution {
public:
    //DFS 
   /* int ans=0;
    void solve(int h, TreeNode* root, int cur_depth){
        if(root==NULL) return;
        if(cur_depth==h && root->left==NULL && root->right==NULL) ans+=root->val;
        solve(h,root->left,cur_depth+1);
        solve(h,root->right,cur_depth+1);
     }
    
    
    int depth(TreeNode* root){
        if(root==NULL) return 0;
         int ld=depth(root->left);
          int rd=depth(root->right);
          return 1+max(ld,rd);
    }
    
    int deepestLeavesSum(TreeNode* root) {
       int max_depth= depth(root);
        solve(max_depth,root,1);
        return ans;
    }
     
//BFS
    /* 
	int deepestLeavesSum(TreeNode* root) {
         if(root==NULL) return 0;
          vector<int> temp;
          queue<TreeNode*> q;
          q.push(root);
         while(!q.empty()){
             temp.clear();           
             int sz=q.size();
             
             for(int i=0; i<sz; i++){
                 auto x=q.front();
                 q.pop();
                 temp.push_back(x->val);
                 if(x->left) q.push(x->left);
                 if(x->right) q.push(x->right);
             }
             
         }
             return accumulate(temp.begin(),temp.end(),0);
    }
    */
};


// C++ | Iterative | Level Order Traversal | BFS | TC : O(N) SC : O(N)
int deepestLeavesSum(TreeNode* root) {
		priority_queue<pair<int,int>> maxHeap;
        queue<TreeNode*> Q;
		
        Q.push(root);
        Q.push(new TreeNode(-1));
        int depth = 0;
		
        while(!Q.empty()){
            if(Q.front()->val == -1) {
                Q.push(new TreeNode(-1));
                Q.pop();
                depth++;
            }
            
            TreeNode *tempNode = Q.front();
            Q.pop();
            
            if(!tempNode->left && !tempNode->right && !(tempNode->val == -1))
                maxHeap.push(make_pair(depth,tempNode->val));
            
            if(tempNode->left)
                Q.push(tempNode->left);
            
            if(tempNode->right)
                Q.push(tempNode->right);
        }
        
        int sum = 0, maxDepth = maxHeap.top().first;
        while(!maxHeap.empty()){
            if(maxHeap.top().first != maxDepth)
                break;
            sum += maxHeap.top().second;
            maxHeap.pop();
        }
        
        return sum;
    }
