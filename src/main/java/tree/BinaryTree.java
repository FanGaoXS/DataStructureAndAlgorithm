package tree;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/23/23:03
 * @Description:
 */
public class BinaryTree {
    public static void main(String[] args) {
        /**
         *                      1
         *                 null     2
         *                       3
         */
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        System.out.println("preOrderByDfs(root) = " + preOrderByDfs(root));             //前序遍历（DFS）
        System.out.println("inOrderByDfs(root) = " + inOrderByDfs(root));               //中序遍历（DFS）
        System.out.println("posOrderByDfs(root) = " + posOrderByDfs(root));             //后序遍历（DFS）
        System.out.println("levelOrderByQueue(root) = " + levelOrderByQueue(root));     //层序遍历（Queue）
    }

    public static List<Integer> inOrderByStack(TreeNode root){
        ArrayList<Integer> integers = new ArrayList<>();
        if (root == null) return integers;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            
        }
        return null;
    }

    //中序遍历（深度优先遍历）
    public static List<Integer> inOrderByDfs(TreeNode root){
        ArrayList<Integer> integers = new ArrayList<>();
        inOrderDfs(root,integers);
        return integers;
    }

    private static void inOrderDfs(TreeNode node,List<Integer> integers){
        if (node == null) return;
        inOrderDfs(node.left, integers);    //遍历左子树
        integers.add(node.val);             //打印
        inOrderDfs(node.right, integers);   //遍历右子树
    }

    //前序遍历
    public static List<Integer> preOrderByDfs(TreeNode root){
        ArrayList<Integer> integers = new ArrayList<>();
        preOrderDfs(root,integers);
        return integers;
    }

    private static void preOrderDfs(TreeNode node, List<Integer> integers) {
        if (node == null) return;
        integers.add(node.val);             //打印
        preOrderDfs(node.left, integers);    //遍历左子树
        preOrderDfs(node.right, integers);   //遍历右子树
    }

    //后序遍历
    public static List<Integer> posOrderByDfs(TreeNode root){
        ArrayList<Integer> integers = new ArrayList<>();
        posOrderDfs(root,integers);
        return integers;
    }

    private static void posOrderDfs(TreeNode node, List<Integer> integers) {
        if (node == null) return;
        posOrderDfs(node.left, integers);    //遍历左子树
        posOrderDfs(node.right, integers);   //遍历右子树
        integers.add(node.val);             //打印
    }

    //层序遍历（利用队列实现）
    public static List<Integer> levelOrderByQueue(TreeNode root){
        ArrayList<Integer> integers = new ArrayList<>();
        if (root==null) return integers;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            //当前层有多少个节点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                integers.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return integers;
    }
}

class TreeNode {
    public int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
