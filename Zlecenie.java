package PRO1;

import java.time.LocalDate;
public class Zlecenie { //TODO: implement runnable
    Brygada brygada;
    LocalDate dataUtworzenia;
    LocalDate dataZakonczenia;
    enum Rodzaj{PLANOWANE,NIEPLANOWANE}
    boolean czyPlanowane;
    public Zlecenie(Rodzaj rodzaj, Brygada brygada){
        switch (rodzaj){
            case PLANOWANE -> this.czyPlanowane = true;
            case NIEPLANOWANE -> this.czyPlanowane = false;
        }
        this.brygada = brygada;
    }



}
