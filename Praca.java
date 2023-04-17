package PRO1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Praca extends Thread {
    enum rodzajPracy {OGOLNA, MONTAZ, DEMONTAZ, WYMIANA}

    int czasPracy; //w sekundach
    boolean czyZrealizowane;
    String opis;
    ArrayList<Praca> kolejkaPrac = new ArrayList<>();

    @Override
    public void run() {
        if (kolejkaPrac.stream().allMatch(o -> o.czyZrealizowane == false)) {
            try {
                sleep(czasPracy);
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
