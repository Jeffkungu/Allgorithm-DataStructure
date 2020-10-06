import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {
    private static BSTNode root;

    public static void main(String[] args) {

        int[] arr = new int[]{6, 3, 5, 8, 2, 10, 4, 7};

        for(int i = 0; i<arr.length; i++){
            recursiveAddNode(root ,arr[i]);
        }

        inOrderTraversal_WithoutRecursion(root);

    }

    public static void addNode(int value) {
        BSTNode newNode = new BSTNode(value);

        if (root == null) {
            root = newNode;
        } else {
            BSTNode focusNode = root;

            if(value <= root.getValue()){

                while(focusNode.getLeftNode() != null){
                    focusNode = focusNode.getLeftNode();
                }

                if(value <= focusNode.getValue()){
                    focusNode.setLeftNode(newNode);
                } else {
                    focusNode.setRightNode(newNode);
                }

            } else {

                while(focusNode.getRightNode() != null){
                    focusNode = focusNode.getRightNode();
                }

                if(value <= focusNode.getValue()){
                    focusNode.setLeftNode(newNode);
                } else {
                    focusNode.setRightNode(newNode);
                }

            }
        }
     }

    public static BSTNode recursiveAddNode(BSTNode node, int value){
        BSTNode newNode = new BSTNode(value);

        if(node == null){
            root = newNode;
            return root;
        } else {
            if(value <= node.getValue() && node.getLeftNode() != null){
                return recursiveAddNode(node.getLeftNode(), value);
            } else if (value <= node.getValue() && node.getLeftNode() == null){
                node.setLeftNode(newNode);
                return node;
            } else if (value > node.getValue() && node.getRightNode() != null){
                return recursiveAddNode(node.getRightNode(), value);
            } else if (value > node.getValue() && node.getRightNode() == null){
                node.setRightNode(newNode);
                return node;
            }
        }

        return recursiveAddNode(node, value);

    }

    /**
     * @return List containing values added from inOrder traversal of a BST
     * 
     * Create a Stack that saves the nodes visited in memory.
     * 
     * Use a while loop to traverse through the nodes while adding them to the Stack. When you reach a
     * node with the null value, start removing the nodes from the stack.
     */
     public static List<Integer> inOrderTraversal_WithoutRecursion(BSTNode node){
        BSTNode tree = node;
        List<Integer> values = new ArrayList<>();
        Stack<BSTNode> stack = new Stack<>();
        
        
        while(!stack.isEmpty() || tree != null){
            /**
             * Left: go as left as possible, the stack keeps the history of nodes that need
             * searching
             */
            while(tree != null){
                stack.push(tree);
                tree = tree.getLeftNode();
            }

            /**
             * after the above loop tree becomes null, so we start poping values from the stack
             * and following the inOrder traversal
             * */ 
            tree = stack.pop();
            values.add(tree.getValue());

            tree = tree.getRightNode();
        }

        System.out.println(values.toString());
        return values;
     }

}

class BSTNode{
    private int value;
    private BSTNode leftNode;
    private BSTNode rightNode;

    public BSTNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Val = " + value + " Nodes = (" + " l = " + leftNode + " r = " + rightNode + ")";
    }

    /**
     * @return int return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return Node return the leftNode
     */
    public BSTNode getLeftNode() {
        return leftNode;
    }

    /**
     * @return Node return the rightNode
     */
    public BSTNode getRightNode() {
        return rightNode;
    }

    

    /**
     * @param leftNode the leftNode to set
     */
    public void setLeftNode(BSTNode leftNode) {
        this.leftNode = leftNode;
    }

    /**
     * @param rightNode the rightNode to set
     */
    public void setRightNode(BSTNode rightNode) {
        this.rightNode = rightNode;
    }


    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

}
