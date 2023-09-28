import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {

    int size;
    List<MilliPark> liste; //Generic List.

    public PriorityQueue(){

        size=0;
        liste=new ArrayList<>();
    }

    public boolean isEmpty(){
        return size < 1;
    }

    public void push(MilliPark data){
            liste.add(data);
            size++;
    }


    public MilliPark pop(){
        int enKucukAlan =liste.get(0).getYuzOlcumu(); //İlk olarak en küçük mp'ye listenin başındaki elemanı atıyorız daha sonra listede gezinerek daha küçük bir eleman varsa değişkeni değiştiriyoruz.
        MilliPark enKucukMilliPark=liste.get(0);

        if (isEmpty()){
            System.out.println("Underflow!");
            return null;
        }

        else {
            for (int i=0;i<size;i++){
                int currentYuzOlcumu=liste.get(i).getYuzOlcumu();

                if (currentYuzOlcumu<enKucukAlan){
                    enKucukAlan=currentYuzOlcumu;
                    enKucukMilliPark=liste.get(i);
                }
            }
            liste.remove(enKucukMilliPark); //En küçük mp bulunduktan sonra listeden çıkarılıyor.
            size--;
            return enKucukMilliPark;
        }
    }





}
