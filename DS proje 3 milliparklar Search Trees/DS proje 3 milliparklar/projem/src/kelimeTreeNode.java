public class kelimeTreeNode {
    kelimeTreeNode leftChild;
    kelimeTreeNode rightChild;
    String data;
    int kelimeSayisi;

    public kelimeTreeNode(int kelimeSayisi,String data){
        leftChild=null;
        rightChild=null;
        this.kelimeSayisi=kelimeSayisi;
        this.data=data;
    }

    public void displayNode(){
        System.out.println(data+":"+kelimeSayisi);
    }


}class kelimeTree {
    kelimeTreeNode root;

    public kelimeTree() {
        root = null;
    }



    public void yazdir(kelimeTreeNode localRoot) {
        if (localRoot != null) {
            yazdir(localRoot.leftChild);
            localRoot.displayNode();
            yazdir(localRoot.rightChild);
        }

    }


    public void insert(String data,int kelimeSayisi){ //Kelime ve kelimenin sayısı verilip bunları kelimeTree ağacına ekleyen metot.

        kelimeTreeNode newNode=new kelimeTreeNode(kelimeSayisi,data);

        if (root==null){
            root=newNode;
        }

        else {
            kelimeTreeNode current=root;
            kelimeTreeNode parent;

            while (true){
                parent=current;
                if (newNode.data.compareTo(current.data)<0){
                    current=current.leftChild;
                    if (current==null){
                        parent.leftChild=newNode;
                        return;
                    }
                }
                else {
                    current=current.rightChild;
                    if (current==null){
                        parent.rightChild=newNode;
                        return;
                    }
                }
            }
        }
    }
}

