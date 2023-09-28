
public class queue {
    int index1; //Listeye ekleme yapmak için kullanılan index.
    int index2; //Listeden silme yapmak için kullanılan index.
    int kapasite;
    MilliPark[] liste;

    public queue(int kapasite){
        this.kapasite=kapasite;
        index1=-1;
        index2=0;
        liste=new MilliPark[kapasite];
    }

    public boolean isEmpty(){
        return index1 < 0 || index2 == kapasite;
    }

    public void push(MilliPark data){
        if (index1!=kapasite-1){
            index1++;
            liste[index1]=data;
        }
        else {
            System.out.println("Overflow!");
        }
    }

    public MilliPark pop(){
        if (isEmpty()){
            System.out.println("Underflow");
            return null;
        }
        else {
            MilliPark data=liste[index2];
            index2++;
            return data;
        }
    }
}
