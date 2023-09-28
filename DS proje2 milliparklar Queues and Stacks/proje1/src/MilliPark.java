public class MilliPark {
    private int no;
    private String milliParkAdı;
    private String ilAdi;
    private int yuzOlcumu;
    private String tarih;

    public MilliPark(int no, String milliParkAdı, String ilAdi, int yuzOlcumu, String tarih) {
        this.no = no;
        this.milliParkAdı = milliParkAdı;
        this.ilAdi = ilAdi;
        this.yuzOlcumu = yuzOlcumu;
        this.tarih = tarih;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getMilliParkAdı() {
        return milliParkAdı;
    }

    public void setMilliParkAdı(String milliParkAdı) {
        this.milliParkAdı = milliParkAdı;
    }

    public String getIlAdi() {
        return ilAdi;
    }

    public void setIlAdi(String ilAdi) {
        this.ilAdi = ilAdi;
    }

    public int getYuzOlcumu() {
        return yuzOlcumu;
    }

    public void setYuzOlcumu(int yuzOlcumu) {
        this.yuzOlcumu = yuzOlcumu;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String toString(){
        return ("Adı:"+milliParkAdı+" İl:"+ilAdi+" Yüz Ölçümü:"+yuzOlcumu+" Tarih:"+tarih);
    }
}
