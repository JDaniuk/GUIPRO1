package PRO1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Praca extends Thread {
    static enum rodzajPracy {OGOLNA, MONTAZ, DEMONTAZ, WYMIANA}
    rodzajPracy rodzaj;
    int czasPracy; //w sekundach
    boolean czyZrealizowane = false;
    String opis;
    ArrayList<Praca> kolejkaPrac = new ArrayList<>();

    public Praca(int czasPracy, String opis, rodzajPracy rodzaj){
        this.czasPracy = czasPracy;
        this.opis = opis;
        rodzaj = rodzaj;

    }

    @Override
    public void run() {
        if (kolejkaPrac.stream().allMatch(o -> o.czyZrealizowane == false)) {
            try {
                long start = System.currentTimeMillis();
               Thread.sleep(Long.valueOf(czasPracy*1000));
                System.out.println("Sleep time in ms = " + (System.currentTimeMillis() - start));
                System.out.println(this.toString());
                czyZrealizowane = true;
            }catch (InterruptedException e){
                System.err.println(e);
            }
        }
    }

    @Override
    public String toString() {
        return "Praca{" +
                "czasPracy=" + czasPracy +
                ", czyZrealizowane=" + czyZrealizowane +
                ", opis='" + opis + '\'' +
                ", kolejkaPrac=" + kolejkaPrac +
                '}';
    }
}
