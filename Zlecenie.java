package PRO1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Zlecenie implements Runnable { //TODO: implement runnable
    private Brygada brygada;
    LocalDate dataUtworzenia;
    LocalDate dataRealizacji;
    LocalDate dataZakonczenia;
    private ArrayList<Praca> listaPrac;

    enum Rodzaj {PLANOWANE, NIEPLANOWANE}

    Rodzaj rodzaj;

    //pierwszy konstruktor, pole typu boolean
    public Zlecenie(Boolean czyPlanowane) {
        if (czyPlanowane) {
            rodzaj = Rodzaj.PLANOWANE;
        } else if (!czyPlanowane) {
            rodzaj = Rodzaj.NIEPLANOWANE;
        }
        this.brygada = null;
        this.listaPrac = new ArrayList<>();
        this.dataUtworzenia = LocalDate.now();

    }

    public Zlecenie(Boolean czyPlanowane, Brygada brygada) { //konstruktor 2, pole typu boolean, Brygada
        if (czyPlanowane) {
            rodzaj = Rodzaj.PLANOWANE;
        } else if (!czyPlanowane) {
            rodzaj = Rodzaj.NIEPLANOWANE;
        }
        this.brygada = brygada;
        listaPrac = new ArrayList<>();
        this.dataUtworzenia = LocalDate.now();
    }

    //trzeci konstruktor, pole typu boolean, lista prac(ArrayList)
    public Zlecenie(Boolean czyPlanowane, ArrayList<Praca> listaPrac) {
        if (czyPlanowane) {
            rodzaj = Rodzaj.PLANOWANE;
        } else if (!czyPlanowane) {
            rodzaj = Rodzaj.NIEPLANOWANE;
        }
        this.listaPrac = listaPrac;
        this.brygada = null;
        this.dataUtworzenia = LocalDate.now();
    }

    //czwarty konstruktor, pola typu boolean, lista prac(ArrayList), Brygada
    public Zlecenie(Boolean czyPlanowane, ArrayList<Praca> listaPrac, Brygada brygada) {
        if (czyPlanowane) {
            rodzaj = Rodzaj.PLANOWANE;
        } else if (!czyPlanowane) {
            rodzaj = Rodzaj.NIEPLANOWANE;
        }
        this.brygada = brygada;
        this.listaPrac = listaPrac;
        this.dataUtworzenia = LocalDate.now();
    }
/*
    public boolean setBrygada(Brygada brygada) {
        if (this.brygada != null) {
            this.brygada = brygada;
            return true;
        }
        return false;
    } */

    public void addPraca(Praca praca) {

        for (Praca p : this.listaPrac) {
            p.kolejkaPrac.add(praca);
        }
        this.listaPrac.add(praca);
    }


    @Override
    public void run() {
        if (this.brygada != null && !this.listaPrac.isEmpty()) {
            try {
                this.dataRealizacji = LocalDate.now();
                for (Praca praca : listaPrac) {
                    System.out.println("1");
                    praca.start();
                    praca.join();
                    //praca.czyZrealizowane = true;
                    for (Praca p : Praca.pracaMap.values()) {
                        /*
                        if (p.kolejkaPrac.contains(praca)) {
                            p.kolejkaPrac.remove(praca);
                            System.out.println("4");
                        }  */
                    }
                    System.out.println("2");
                }System.out.println("3");
                this.dataZakonczenia = LocalDate.now();
                System.out.println(this.dataZakonczenia);

            } catch (InterruptedException e) {
            }
        } else
            System.out.println("NIE MOŻNA WYKONAĆ ZLECENIA! UPEWNIJ SIĘ ZE ZLECENIE POSIADA BRYGADE I KOLEJKE PRAC.");

    }
}



/*
Zlecenie[1p.],
    0,25pzakażdykonstruktor(DONE x4)
    ●pracaList:ArrayList<Praca>,pustaprzytworzeniuobiektu(DONE)
    ●brygada:Brygada,jakonullprzytworzeniuobiektu (DONE)
    ●stanZlecenia-enum(Planowane,Nieplanowane,Realizowane,Zakonczone)[0,25p.](DONE)
    ●dataUtworzenia-dataiczasutworzeniaobiektuzlecenia(DONE)
    ●dataRealizacji-dataiczasrozpoczęciadziałaniawątku (DONE)
    ●dataZakończenia-dataiczaszakończeniadziałaniawątku (DONE)
    Metody:
        ●voidaddPraca(Pracap)-dodanieobiektupracadolistyprac.[0.5p.](DONE)
        ●booleanaddBrygada(Brygadab)-jeślibrygadaniejestnullzwróćfalseizakończdziałania[0.5p.](DONE)
        ●voidrozpocznijZlecenie()[3p.] TODO
 */