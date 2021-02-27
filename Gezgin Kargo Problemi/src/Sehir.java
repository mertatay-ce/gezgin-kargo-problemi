
import java.util.ArrayList;


public class Sehir {
    private int id;
    private String sehir_adi;
    
    ArrayList<Sehir> komsular =new ArrayList<>();
    ArrayList<Integer>komsu_mesafe=new ArrayList<>();
    public static Sehir Kocaeli=new Sehir(41,"Kocaeli");
    public Sehir(int id, String sehir_adi) {
        this.id = id;
        this.sehir_adi = sehir_adi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSehir_adi() {
        return sehir_adi;
    }

    public void setSehir_adi(String sehir_adi) {
        this.sehir_adi = sehir_adi;
    }

    public ArrayList<Sehir> getKomsular() {
        return komsular;
    }

    public void setKomsular(ArrayList<Sehir> komsular) {
        this.komsular = komsular;
    }

    public ArrayList<Integer> getKomsu_mesafe() {
        return komsu_mesafe;
    }

    public void setKomsu_mesafe(ArrayList<Integer> komsu_mesafe) {
        this.komsu_mesafe = komsu_mesafe;
    }
    
}
