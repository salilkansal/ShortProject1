import java.util.Stack;

class BTNode
{
    BTNode left, right;
    int data;
    public BTNode(){
        left = null;
        right = null;
        data = 0;
    }
    public BTNode(int n){
        left = null;
        right = null;
        data = n;
    }
}

class BT
{
    private BTNode root;
    public BT(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void insert(int data){
        root = insert(root, data);
    }
    private BTNode insert(BTNode node, int data){
        if (node == null)
            node = new BTNode(data);
        else
        {
            if (node.right == null)
                node.right = insert(node.right, data);
            else
                node.left = insert(node.left, data);
        }
        return node;
    }
    public void inorder(){
        inorder(root);
    }
    private void inorder(BTNode r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.data +" ");
            inorder(r.right);
        }
    }
    public void preorder(){
        preorder(root);
    }
    private void preorder(BTNode r)
    {
        if (r != null)
        {
            System.out.print(r.data +" ");
            preorder(r.left);
            preorder(r.right);
        }
    }
    public void postorder(){
        postorder(root);
    }
    private void postorder(BTNode r)
    {
        Stack<BTNode> st1 = new Stack<>();
        Stack<BTNode> st2 = new Stack<>();
        if (r != null)
            st1.push(r);
        while(!st1.empty()){
            BTNode temp = st1.pop();
            if(temp.left!=null)
                st1.push(temp.left);
            if(temp.right!=null)
                st1.push(temp.right);
            st2.push(temp);
        }
        while(!st2.empty())
            System.out.print(st2.pop().data+" ");
    }
}

public class Program4
{
    public static void main(String[] args)
    {
        BT bt = new BT();
        for(int i=1;i<11;i++)
            bt.insert(new Integer(i));
        System.out.print("\nPost order : ");
        bt.postorder();
        System.out.print("\nPre order : ");
        bt.preorder();
        System.out.print("\nIn order : ");
        bt.inorder();
        System.out.println();
    }
}