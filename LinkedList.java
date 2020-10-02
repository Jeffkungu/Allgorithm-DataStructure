public class LinkedList {
    private static ListNode root;

    public static void main(String[] args) {
        
        for (int i = 1; i < 8; i++) {
            recusiveInsert(root, i);
        }

        traverseList(root);
    }

    public static void insert(int value) {
        ListNode listNode = new ListNode();
        listNode.setValue(value);

        if(root == null){
            root = listNode;
        } else {
            ListNode focuss = root;
            System.out.println("focuss a = " + focuss.toString());
            while(focuss.getNode() != null){
                // System.out.println("Add 1 " + focuss.toString());
                focuss = focuss.getNode();
            }
            System.out.println("focuss b = " + focuss.toString());
            focuss.setListNode(listNode);
            System.out.println("focuss c = " + focuss.toString());
            System.out.println("root a = " + root.toString());          
        }
        System.out.println("root b = " + root.toString());
    }

    public static ListNode recusiveInsert(ListNode node, int value){
        ListNode newNode = new ListNode();
        newNode.setValue(value);

        if(node == null){
            root = newNode;
            return root;
        } else if (node.getNode() == null ){
            node.setListNode(newNode);
            return node;
        } else if (node.getNode() != null) {
            return recusiveInsert(node.getNode(), value);
        }

        return recusiveInsert(node, value);

    }

    public static void traverseList(ListNode node){
        System.out.println("Trvs 1 " + node.toString());
        while(node != null){
            System.out.println("Trvs " + node.toString());
            node = node.getNode();
        }
    }
}

class ListNode{
    int value;
    ListNode node;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "value = " + this.value + " Node = (" + node + ")";
    }

    public int getValue(){
        return this.value;
    }

    public ListNode getNode() {
        return this.node;
    }

    public void setListNode(ListNode node){
        this.node = node;
    }

    public void setValue(int value){
        this.value = value;
    }
}
