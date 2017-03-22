package com.wafersystems.cloud.manage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by weiguo.ren on 2016/3/24.
 */
public class BinTreeTraverse2 {
    private static String[] array = {"a1", "a2", "a3", "a4", "a5", "a6"
            ,"a7","b1","b2","b3","b4","b5","b6"};
    private static List<Node> nodeList = null;

    /**
     * 内部类：节点
     *
     * @author ocaicai@yeah.net @date: 2011-5-17
     */
    private static class Node {
        Node leftChild;
        Node rightChild;
        String data;

        Node(String newData) {
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    public void createBinTree() {
        nodeList = new LinkedList<Node>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).leftChild = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).rightChild = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }

    /**
     * 先序遍历
     * <p/>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public static void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 中序遍历
     * <p/>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public static void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    /**
     * 后序遍历
     * <p/>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public static void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinTreeTraverse2 binTree = new BinTreeTraverse2();
        binTree.createBinTree();
        // nodeList中第0个索引处的值即为根节点
        Node root = nodeList.get(0);

        int dept = getNodeLevel(root);
        System.out.println("是不是深度：" + dept);
        System.out.println(array.length);
        ArrayList<ArrayList<String>> ret=levelTraversalRec(root);

        for(int i=0;i<ret.size();i++){
            if(ret.get(i).size()==1)
                System.out.println("i: "+ret.get(i).get(0)+" "+ret.size());
            else{
                String str="";

                for(int j=0;j<ret.get(i).size();j++){
                    count=0;
                    int count1= getLevle(ret,i+1,j+1);
                    System.out.println("i: "+ret.get(i).get(j)+" "+(count1+1));
                }
            }
        }





//        preOrderTraverse(root);
//        System.out.println("先序遍历："+getDepthRec(root));
//        System.out.println("是不是平衡二叉树："+getNodeNumKthLevel(root,3));
//        if (getNodeNumKthLevel(root, dept) < (getNodeNumKthLevel(root, dept - 1) * 2)) {

//        } else {
//            System.out.println("平衡二叉树：" + getNodeNumKthLevel(root, 3));
//        }
    }

   static int count=0;
    private static  int getLevle( ArrayList<ArrayList<String>> ret,int m,int n){

        for(int i=m;i<ret.size();i++){
            if(i>m)return count;
            if(ret.get(i).size()>=2*n) {
                count++;
                getLevle(ret,m+1,2*n);
            }else
                return count;
        }
        return count;
    }

    /**
     *  求二叉树中叶子节点的个数（迭代）
     *  还是基于Level order traversal
     */
    public static int getNodeNumLeaf(Node root) {
        if(root == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        int leafNodes = 0;              // 记录上一个Level，node的数量

        while( !queue.isEmpty() ){
            Node cur = queue.remove();      // 从队头位置移除
            if(cur.leftChild != null){               // 如果有左孩子，加到队尾
                queue.add(cur.leftChild);
            }
            if(cur.rightChild != null){              // 如果有右孩子，加到队尾
                queue.add(cur.rightChild);
            }
            if(cur.leftChild==null && cur.rightChild==null){          // 叶子节点
                leafNodes++;
            }
        }

        return leafNodes;
    }

    /**
     *  分层遍历二叉树（递归）
     *  很少有人会用递归去做level traversal
     *  基本思想是用一个大的ArrayList，里面包含了每一层的ArrayList。
     *  大的ArrayList的size和level有关系
     *
     *  这是我目前见到的最好的递归解法！
     *  http://discuss.leetcode.com/questions/49/binary-tree-level-order-traversal#answer-container-2543
     */
    public static ArrayList<ArrayList<String>> levelTraversalRec(Node root) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        dfs(root, 0, ret);
        System.out.println(ret);
        return ret;
    }

    private static void dfs(Node root, int level, ArrayList<ArrayList<String>> ret){
        if(root == null){
            return;
        }

        // 添加一个新的ArrayList表示新的一层
        if(level >= ret.size()){
            ret.add(new ArrayList<String>());
        }

        ret.get(level).add(root.data);   // 把节点添加到表示那一层的ArrayList里
        dfs(root.leftChild, level+1, ret);       // 递归处理下一层的左子树和右子树
        dfs(root.rightChild, level+1, ret);
    }
    /**
     * 分层遍历二叉树（按层次从上往下，从左往右）迭代
     * 相当于广度优先搜索，使用队列实现。队列初始化，将根节点压入队列。当队列不为空，进行如下操作：弹出一个节点
     * ，访问，若左子节点或右子节点不为空，将其压入队列
     */
    public static void levelTraversal(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.push(root);

        while (!queue.isEmpty()) {
            Node cur = queue.removeFirst();
            System.out.print(cur.data + " ");
            if (cur.leftChild != null) {
                queue.add(cur.leftChild);
            }
            if (cur.rightChild != null) {
                queue.add(cur.rightChild);
            }
        }
    }

    private static int getNodeLevel(Node root) {
        int dept = getDepthRec(root);
        if (dept < 3) {
            return 0;
        } else {
            if (getNodeNumKthLevel(root, dept) < (getNodeNumKthLevel(root, dept - 1) * 2)) {
                return dept - 1;
            } else {
                return dept;
            }
        }
    }


    public static int getLevel(int dept) {
        int level = 0;
        switch (dept) {
            case 3:
                level = 1;
                break;
            case 4:
                level = 2;
                break;
            case 5:
                level = 3;
                break;
            case 6:
                level = 6;
                break;
            default:
                level=0;
                break;
        }
        return level;
    }


    /**
     * 求二叉树第K层的节点个数   递归解法：
     * （1）如果二叉树为空或者k<1返回0
     * （2）如果二叉树不为空并且k==1，返回1
     * （3）如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和
     * <p/>
     * 求以root为根的k层节点数目 等价于 求以root左孩子为根的k-1层（因为少了root那一层）节点数目 加上
     * 以root右孩子为根的k-1层（因为少了root那一层）节点数目
     * <p/>
     * 所以遇到树，先把它拆成左子树和右子树，把问题降解
     */
    public static int getNodeNumKthLevelRec(Node root, int k) {
        if (root == null || k < 1) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }
        int numLeft = getNodeNumKthLevelRec(root.leftChild, k - 1);      // 求root左子树的k-1层节点数
        int numRight = getNodeNumKthLevelRec(root.rightChild, k - 1);    // 求root右子树的k-1层节点数
        return numLeft + numRight;
    }


    /**
     * 求二叉树第K层的节点个数   迭代解法：
     * 同getDepth的迭代解法
     */
    public static int getNodeNumKthLevel(Node root, int k) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        int i = 1;
        int currentLevelNodes = 1;      // 当前Level，node的数量
        int nextLevelNodes = 0;         // 下一层Level，node的数量

        while (!queue.isEmpty() && i < k) {
            Node cur = queue.remove();      // 从队头位置移除
            currentLevelNodes--;            // 减少当前Level node的数量
            if (cur.leftChild != null) {               // 如果有左孩子，加到队尾
                queue.add(cur.leftChild);
                nextLevelNodes++;           // 并增加下一层Level node的数量
            }
            if (cur.rightChild != null) {          // 如果有右孩子，加到队尾
                queue.add(cur.rightChild);
                nextLevelNodes++;
            }

            if (currentLevelNodes == 0) { // 说明已经遍历完当前层的所有节点
                currentLevelNodes = nextLevelNodes;     // 初始化下一层的遍历
                nextLevelNodes = 0;
                i++;            // 进入到下一层
            }
        }

        return currentLevelNodes;
    }

    public static int getDepthRec(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepthRec(root.leftChild);
        int rightDepth = getDepthRec(root.rightChild);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 判断二叉树是不是平衡二叉树 递归解法：
     * （1）如果二叉树为空，返回真
     * （2）如果二叉树不为空，如果左子树和右子树都是AVL树并且左子树和右子树高度相差不大于1，返回真，其他返回假
     */
    public static boolean isAVLRec(Node root) {
        if (root == null) {           // 如果二叉树为空，返回真
            return true;
        }

        // 如果左子树和右子树高度相差大于1，则非平衡二叉树, getDepthRec()是前面实现过的求树高度的方法
        if (Math.abs(getDepthRec(root.leftChild) - getDepthRec(root.rightChild)) > 1) {
            return false;
        }

        // 递归判断左子树和右子树是否为平衡二叉树
        return isAVLRec(root.leftChild
        ) && isAVLRec(root.rightChild);
    }

    /**
     * 14.  判断二叉树是不是完全二叉树（递归）
     * http://stackoverflow.com/questions/1442674/how-to-determine-whether-a-binary-tree-is-complete
     */
    public static boolean isCompleteBinaryTreeRec(Node root) {
//      Pair notComplete = new Pair(-1, false);
//      return !isCompleteBinaryTreeSubRec(root).equalsTo(notComplete);
        return isCompleteBinaryTreeSubRec(root).height != -1;
    }

    // 递归，要创建一个Pair class来保存树的高度和是否已满的信息
    public static Pair isCompleteBinaryTreeSubRec(Node root) {
        if (root == null) {
            return new Pair(0, true);
        }

        Pair left = isCompleteBinaryTreeSubRec(root.leftChild);
        Pair right = isCompleteBinaryTreeSubRec(root.rightChild);

        // 左树满节点，而且左右树相同高度，则是唯一可能形成满树（若右树也是满节点）的情况
        if (left.isFull && left.height == right.height) {
            return new Pair(1 + left.height, right.isFull);
        }

        // 左树非满，但右树是满节点，且左树高度比右树高一
        // 注意到如果其左树为非完全树，则它的高度已经被设置成-1，
        // 因此不可能满足第二个条件！
        if (right.isFull && left.height == right.height + 1) {
            return new Pair(1 + left.height, false);
        }

        // 其他情况都是非完全树，直接设置高度为-1
        return new Pair(-1, false);
    }

    private static class Pair {
        int height;             // 树的高度
        boolean isFull;     // 是否是个满树

        public Pair(int height, boolean isFull) {
            this.height = height;
            this.isFull = isFull;
        }

        public boolean equalsTo(Pair obj) {
            return this.height == obj.height && this.isFull == obj.isFull;
        }
    }
}
