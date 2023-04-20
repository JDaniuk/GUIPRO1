package PRO1;

import java.util.*;

public class Praca extends Thread {
    enum rodzajPracy {OGOLNA, MONTAZ, DEMONTAZ, WYMIANA}

    static int idCounter = 0;
    int id;

    static Map<Integer, Praca> pracaMap = new HashMap<>();
    rodzajPracy rodzaj;
    int czasPracy; //w sekundach
    boolean czyZrealizowane = false;
    String opis;

    ArrayList<Praca> kolejkaPrac = new ArrayList<>();

    public Praca(int czasPracy, String opis, rodzajPracy rodzaj) {
        this.czasPracy = czasPracy;
        this.opis = opis;
        rodzaj = rodzaj;
        idCounter += 1;
        this.id = idCounter;
        pracaMap.put(this.id, this);

    }


    @Override
    synchronized public void run() { //
        //działaj dopóki nie zostanie wykonany
        if (!kolejkaPrac.isEmpty()) {
            for (Praca p : kolejkaPrac) {
                try {
                    p.start();
                    p.join();
                } catch (InterruptedException e) {
                }
            }
            try {
                this.wait(czasPracy * 1000);
                czyZrealizowane = true;
                System.out.println(this);
                this.interrupt();
               /* for (Praca p : pracaMap.values()) {
                    if (p.kolejkaPrac.contains(this)) {
                        p.kolejkaPrac.remove(this);
                    }
                }*/
            } catch (InterruptedException e) {
            }
        } else {
            try {
                this.wait(czasPracy * 1000);
                czyZrealizowane = true;
                System.out.println(this);
                this.interrupt();
             /*   for (Praca p : pracaMap.values()) {
                    if (p.kolejkaPrac.contains(this)) {
                        p.kolejkaPrac.remove(this);
                    }
                }*/

            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public String toString() {
        return "Praca{" +
                "czasPracy=" + czasPracy +
                ", czyZrealizowane=" + czyZrealizowane +
                ", opis='" + opis + '\'';

    }

    public Praca findPracaById(int id) {
        return pracaMap.get(id);
    }
}

/*
Praca(Thread)[3p.]
    ●rodzajPracy(Ogólna,Montaz,Demontaz,Wymiana)[0,25p.] (DONE)
    ●czasPracy:int(wmin) TODO (Na razie jest w sekundach)
    ●czyZrealizowane:boolean (DONE)
    ●opis:String(DONE)
    klasiePracaorazZleceniemasiępojawićstatycznametodadopozyskaniaobiektu,podającnumerpracylubzlecenia.Proszędotegowykorzystaćkolekcjętypu-Map. TODO
 */
