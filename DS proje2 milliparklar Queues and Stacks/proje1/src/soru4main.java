

public class soru4main {
    public static void main(String[] args) {
        soru4queue kuyruk=new soru4queue(11); //Kuyruk oluşturuyoruz.


        System.out.println("Soru 4.a");
        System.out.println();
        kuyruk.push(8);
        kuyruk.push(9);
        kuyruk.push(6);
        kuyruk.push(7);
        kuyruk.push(10);
        kuyruk.push(1);
        kuyruk.push(11);
        kuyruk.push(5);
        kuyruk.push(3);
        kuyruk.push(4);
        kuyruk.push(2);
        kuyruk.pop();
        kuyruk.pop();
        kuyruk.pop();
        kuyruk.pop();
        kuyruk.pop();
        kuyruk.pop();
        kuyruk.pop();
        kuyruk.pop();
        kuyruk.pop();
        kuyruk.pop();
        kuyruk.pop();
        System.out.println("Ortalama süre:"+kuyruk.ortalamaSure());


        System.out.println();
        System.out.println("Soru 4.b");
        System.out.println();


        soru4PQ pq=new soru4PQ(); //PQ'nun oluşturulduğu yer.
        pq.push(8);
        pq.push(9);
        pq.push(6);
        pq.push(7);
        pq.push(10);
        pq.push(1);
        pq.push(11);
        pq.push(5);
        pq.push(3);
        pq.push(4);
        pq.push(2);

        pq.pop();
        pq.pop();
        pq.pop();
        pq.pop();
        pq.pop();
        pq.pop();
        pq.pop();
        pq.pop();
        pq.pop();
        pq.pop();
        pq.pop();
        System.out.println("Ortalama süre:"+pq.ortalamaSure());
    }
}
