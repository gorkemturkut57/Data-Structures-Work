public class TreeNode {
    TreeNode leftChild;
    TreeNode rightChild;
    MilliParklar data;

    public TreeNode(MilliParklar data){
        leftChild=null;
        rightChild=null;
        this.data=data;
    }

    public void displayNode(){  //Ağacın bilgilerini yazdırmak için kullandığımız metot.
        System.out.println(" "+data+" ");
    }
}

class Tree {
    TreeNode root;
    int toplamNode;

    public Tree() {
        root = null;
        toplamNode=0;
    }

    public void inOrder(TreeNode localRoot) { //Ağaçta inOrder gezinmeyi sağlayan metot.
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            localRoot.displayNode();
            inOrder(localRoot.rightChild);
        }
    }


    public void insert(MilliParklar data){ //MP'nesnelerini tree'ye ekleyen metot.

        TreeNode newNode=new TreeNode(data);

        if (root==null){
            root=newNode;
        }

        else {
            TreeNode current=root;
            TreeNode parent;

            while (true){
                parent=current;
                if (newNode.data.getAdi().compareTo(current.data.getAdi())<0){ //Eğer eklenecek kelime sözlük sırasında geçerli roottan daha önce geliyorsa soluna sonra geliyorsa sağına ekliyoruz.
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

    public int maxDerinlik(TreeNode root){ //Ağaçtaki derinliği bulan metot.
        if (root==null){
            return -1;
        }
        else {
            int leftDepth=maxDerinlik(root.leftChild);
            int rightDepth=maxDerinlik(root.rightChild);

            if (leftDepth>rightDepth){
                return (leftDepth+1);
            }
            else {
                return (rightDepth+1);
            }
        }
    }

    public int toplamNode(TreeNode localRoot){ //Ağacı dolaşarak dolaştığı kadar toplamNode değerini arttırıp toplam düğüm sayısını bulan metot.
        if (localRoot != null) {
            toplamNode++;
            toplamNode(localRoot.leftChild);
            toplamNode(localRoot.rightChild);
            return toplamNode;
        }
        else {
            return -1;
        }
    }

    public void milliParkAra(TreeNode localRoot,String input){ //İlk üç harfi verilen MP'yi ağaçta gezip bulan ve bilgilerini yazdıran metot.
        MilliParklar arananMp;

        if (localRoot!=null){
            if (localRoot.data.getAdi().substring(0,3).equals(input)){
                arananMp=localRoot.data;
                System.out.println(arananMp);
            }
            else {
                milliParkAra(localRoot.leftChild,input);
                milliParkAra(localRoot.rightChild,input);
            }

        }
    }

    public int dengeliAgacDerinligi(int nodeSayisi){ //Ağaç eğer dengeli bir ağaç ise bu ağacın derinliğini bulan metot.(Logaritma 2 tabanında mantığıyla çalışır.)
        int toplamNode=0;
        int derinlik=-1;
        int sayac=0;
        while (toplamNode<nodeSayisi){
            toplamNode= (int) (toplamNode+(Math.pow(2,sayac)));
            sayac++;
            derinlik++;
        }
        return derinlik;
    }





}

