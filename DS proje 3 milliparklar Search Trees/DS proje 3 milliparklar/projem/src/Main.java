import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> tumKelimeler=new ArrayList<>(); //Açıklamalarda bulunan tüm kelimelerin bulunduğu arraylist.

        Hashtable<String, MilliParklar> hashtable=new Hashtable<>(); //MP'lerin tutulduğu hashtable.
        Hashtable<Object, Object> hashtableKelimeler=new Hashtable<>(); //MP'lerin açıklamalarında bulunan kelimelerin toplam sayılarının tutulduğu hashtable.

        Tree tree=new Tree(); //MP'lerin bulunduğu ağaç.
        kelimeTree kelimelerAgaci=new kelimeTree(); //Kelimelerin bulunduğu ağaç.

        Heap heap = new Heap(48);

        String[] veriler; //Dosyadan okunan verilerin tutulduğu array.

        Scanner inputText=null;
        try { //Verileri dosyadan çekme kısmı.
            inputText=new Scanner(new FileInputStream("milliparklar.txt"));
        }
        catch (FileNotFoundException e){
            System.out.println("Dosya bulunamadı");
            System.exit(0);
        }

        while (inputText.hasNextLine()){
            veriler=inputText.nextLine().split(";"); //verileri ; ler ile ayırıp veriler arrayine ekliyoruz.
            int yuzOlcumu=Integer.parseInt(veriler[2]);
            List<String> kelimeler=new ArrayList<>(); //Açıklamadaki kelimelerin geçici olarak tutulup MP'lere atadığımız List.
            String[] ayrilanKelimeler=veriler[4].split(" "); //Açıklamada bulunan tüm kelimeleri ayrı ayrı " " a göre splitleyip tuttuğumuz kısım.
            Collections.addAll(kelimeler, ayrilanKelimeler); //Ayrılankelimeler arrayini tek tek geziyoruz.
            for (String s : ayrilanKelimeler) {
                if (!tumKelimeler.contains(s)){
                    tumKelimeler.add(s);
                }
                if (hashtableKelimeler.containsKey(s)) { //Kelimelerin tutulduğu hashtable'da gerekli güncellemelerin yapıldığı kısım.
                    String tempValue = String.valueOf(hashtableKelimeler.get(s));
                    int eskiValue = Integer.parseInt(tempValue);
                    int yeniValue = eskiValue + 1;
                    hashtableKelimeler.replace(s, yeniValue);
                } else {
                    hashtableKelimeler.put(s, 1);
                }
            }
            MilliParklar milliPark=new MilliParklar(veriler[0],veriler[1],yuzOlcumu,veriler[3],kelimeler); //MP'lerin oluşturulup ağaca, heape ve hashtable'a aktarıldığı kısım.
            tree.insert(milliPark);
            heap.insert(milliPark);

            hashtable.put(milliPark.getAdi(),milliPark);
        }

        for (String s : tumKelimeler) { //tumKelimeler arraylistini tek tek gezip sırdaki kelimenin sayısını hashtabledan çekip bunu kelimeTree ağacına aktarıyoruz.
            int kelimeSayisi= Integer.parseInt(String.valueOf(hashtableKelimeler.get(s)));
            kelimelerAgaci.insert(s,kelimeSayisi);
        }
        //Yazdırma işlemlerinin yapıldığı yerler.

        heap.remove();heap.remove();heap.remove();// Heapten 3 en yuksek verinin cikarilmasi
        heap.displayHeap();

        kelimelerAgaci.yazdir(kelimelerAgaci.root);

        tree.inOrder(tree.root);

        System.out.println();
        System.out.println();
        System.out.println("Ağaçtaki düğüm sayısı:"+tree.toplamNode(tree.root));
        System.out.println();
        System.out.println("Ağacın derinliği:"+tree.maxDerinlik(tree.root));
        System.out.println();

        System.out.println("Dengeli ağaç derinliği:"+tree.dengeliAgacDerinligi(tree.toplamNode(tree.root)));
        System.out.println();

        Scanner scanner=new Scanner(System.in);
        System.out.print("Aranan milli parkın ilk üç harfini giriniz:");
        String input=scanner.nextLine();
        tree.milliParkAra(tree.root,input);
        System.out.println();

        System.out.print("Milli park ismini giriniz:");
        String mpIsmi=scanner.nextLine();
        System.out.println();
        System.out.print("Tarih giriniz:");
        String tarih=scanner.nextLine();
        System.out.println();

        MilliParklar yeniMp=hashtable.get(mpIsmi); //Geçici olarak eski mp yi tutuyoruz.
        yeniMp.setTarih(tarih); //Eski mp yi güncel hale getiriyoruz.
        hashtable.replace(mpIsmi,yeniMp); //Güncellenenen mp yi önceki ile yer değiştiriyoruz.

    }
}