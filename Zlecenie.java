package PRO1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Zlecenie implements Runnable { //TODO: implement runnable
    Brygada brygada;
    LocalDate dataUtworzenia;
    LocalDate dataZakonczenia;
    ArrayList<Praca> pracaCollection = new ArrayList<>();
    enum Rodzaj{PLANOWANE,NIEPLANOWANE}
    boolean czyPlanowane;
    public Zlecenie(Rodzaj rodzaj, Brygada brygada){
        switch (rodzaj){
            case PLANOWANE -> this.czyPlanowane = true;
            case NIEPLANOWANE -> this.czyPlanowane = false;
        }
        this.brygada = brygada;
    }

    @Override
    public void run() {

    }
}
