import java.util.ArrayList;
import java.util.List;

class soru4PQ {
    List<Integer> liste; //Müşterilerin ürün adedinin tutulduğu yer.
    int size; //Listenin büyüklüğü.
    int toplamSure;
    int musteriNo;
    int herkesinToplamSuresi;

    public soru4PQ(){
        liste=new ArrayList<>();
        toplamSure=0;
        musteriNo=0;
        size=0;
        herkesinToplamSuresi=0;
    }

    public boolean isEmpty(){
        return size<1;
    }

    public void push(int urunAdedi){
        size++;
        liste.add(urunAdedi);
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("Underflow!");
            return -1;
        }
        else {
            musteriNo++;
            int enKucukDeger=liste.get(0); //En küçük değere ilk olarak listenin en başındaki kişiyi atıyoruz.
            for (int i=0;i<liste.size();i++){ //Ardından listeyi gezerek daha en küçük değerden daha küçük bir değer varsa enKucukDeger'i değiştiriyoruz.
                if (liste.get(i)<enKucukDeger){
                    enKucukDeger=liste.get(i);
                }
            }
            int index=liste.indexOf(enKucukDeger); //En küçük değerin indexini buluyoruz.
            liste.remove(index); //Bulunan indexe göre o müşteriyi sıradan çıkarıyoruz.
            toplamSure=toplamSure+3*enKucukDeger; //O müşteri için toplam işlem süresi.
            System.out.println(musteriNo+".müşterinin süresi:"+toplamSure);
            herkesinToplamSuresi=herkesinToplamSuresi+toplamSure;
            return toplamSure;
        }
    }
    public double ortalamaSure(){
        return herkesinToplamSuresi/musteriNo;
    }
}

