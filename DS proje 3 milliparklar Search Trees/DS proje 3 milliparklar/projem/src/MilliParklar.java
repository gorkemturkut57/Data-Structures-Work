import java.util.List;

public class MilliParklar {
    private String adi;
    private String sehir;
    private int yuzOlcumu;
    private String tarih;

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    private List<String> aciklama;

    public MilliParklar(String adi, String sehir, int yuzOlcumu, String tarih,List<String> aciklama) {
        this.adi = adi;
        this.sehir = sehir;
        this.yuzOlcumu = yuzOlcumu;
        this.tarih = tarih;
        this.aciklama=aciklama;
    }

    public String getAdi() {
        return adi;
    }

    public int getYuzOlcumu(){return yuzOlcumu;}

    @Override
    public String toString() {
        return "Adı:"+adi+" Şehir:"+sehir+" Yüzölçümü:"+yuzOlcumu+" Tarih:"+tarih+" Açıklama:"+aciklama;
    }


}
