import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class main {

    public static void yazdir(List[] milliParklar,int toplam){ //Milli parkların yazdırıldığı metot.
        for (int i=0;i<milliParklar.length;i++){
            for (int j=0;j<milliParklar[i].size();j++){
                System.out.println(milliParklar[i].get(j));
            }
        }
        System.out.println("Yüzölçümleri toplamı:"+toplam);
    }
    public static void main(String[] args) {

        stack milliParklarStacki=new stack(48);
        queue milliParklarQueuesi=new queue(48);
        PriorityQueue priorityQueue=new PriorityQueue();

        int toplamYuzOlcumu=0;


        List<MilliPark> buyukMilliParklar=new ArrayList<>(); //Generic Listler
        List<MilliPark> kucukMilliParklar=new ArrayList<>();

        List[] milliParklar={kucukMilliParklar,buyukMilliParklar}; //Generic listleri tutan dizi.


        String[] veriler; //Bu dizide okuduğumuz dosyadaki NO,MP ADI,İL ADI ve TARİH olmak üzere bu verileri sırayla saklıyoruz.

        Scanner inputText=null; //Verileri okuduğumuz yer.
        try {
            inputText=new Scanner(new FileInputStream("milliparklar.txt"));
            //System.out.println(inputText.nextLine());
        }
        catch (FileNotFoundException e){
            System.out.println("Dosya bulunamadı");
            System.exit(0);
        }

        while (inputText.hasNextLine()){
            veriler=inputText.nextLine().split(" ");
            int no=Integer.parseInt(veriler[0]);
            int yuzolcumu=Integer.parseInt(veriler[3]);
            toplamYuzOlcumu=toplamYuzOlcumu+yuzolcumu;

            MilliPark milliPark=new MilliPark(no,veriler[1],veriler[2],yuzolcumu,veriler[4]); //Veriler dizisinden alınan bilgilere göre yeni MP tipteki elemanı oluşturuyoruz.

            milliParklarStacki.push(milliPark);
            milliParklarQueuesi.push(milliPark);
            priorityQueue.push(milliPark);

            if (yuzolcumu<15000){ //Küçük mp listesine ekleme yapıyoruz.
                kucukMilliParklar.add(milliPark);
            }
            else { //Büyük mp listesine ekleme yapıyoruz.
                buyukMilliParklar.add(milliPark);
            }
        }


        System.out.println("Soru 1:");
        System.out.println();
        yazdir(milliParklar,toplamYuzOlcumu);


        System.out.println();
        System.out.println("Soru 2.1:");
        System.out.println();

        for (int i=0;i<48;i++){
            System.out.println(milliParklarStacki.pop());
        }

        System.out.println();
        System.out.println("Soru 2.2");
        System.out.println();

        for (int i=0;i<48;i++){
            System.out.println(milliParklarQueuesi.pop());
        }

        System.out.println();
        System.out.println("Soru 3");
        System.out.println();
        for (int i=0;i<48;i++){
            System.out.println(priorityQueue.pop());
        }
    }
}
