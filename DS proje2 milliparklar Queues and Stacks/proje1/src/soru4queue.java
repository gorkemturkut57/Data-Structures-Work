class soru4queue {
    int index1; //Listeye eklemede kullandığımız index.
    int index2; //Listeden silmede kllandığımız index.
    int kapasite; //Queue kapasitesi
    int[] liste; //Her müşterinin ürün adedinin tutulduğu liste.
    int toplamSure=0; //Numaralı müşterinin işlem süresi.
    int musteriNo=0; //Müşterinin numarası.
    int herkesinToplamSuresi=0; //Ortalamada kullanılmak üzere konulan,tüm müşterilerin sürelerinin teker teker toplanmasıyla elde edilen süre.

    public soru4queue(int kapasite){
        this.kapasite=kapasite;
        index1=-1;
        index2=0;
        liste=new int[kapasite];
    }

    public boolean isEmpty(){ //Listenin boş mu dolu mu olduğunu kontrol eder.
        return index1 < 0 || index2 == kapasite;
    }

    public void push(int urunAdedi){ //Listeye ekleme.
        if (index1!=kapasite-1){
            index1++;
            liste[index1]=urunAdedi;

        }
        else {
            System.out.println("Overflow!");
        }
    }

    public int pop(){ //Listeden silme.
        if (isEmpty()){
            System.out.println("Underflow!");
            return -1;
        }
        else {
            int urunAdeti=liste[index2]; //İlk sıradaki kişiden itibaren atama yapılır.
            index2++;
            musteriNo++;
            toplamSure=toplamSure+3*urunAdeti; //Numaralı müşteri için geçen sürenin hesaplandığı yer.
            System.out.println(musteriNo+". müşteri:"+toplamSure);
            herkesinToplamSuresi=herkesinToplamSuresi+toplamSure;
            return toplamSure;
        }
    }
    public double ortalamaSure(){ //Ortalama geçen sürenin bulunması.
        return herkesinToplamSuresi/musteriNo;
    }
}

