package PRO1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Zlecenie implements Runnable { //TODO: implement runnable
    private Brygada brygada;
    LocalDate dataUtworzenia;
    LocalDate dataRealizacji;
    LocalDate dataZakonczenia;

    enum Stan {Utworzone, Rozpoczete, Zakonczone}

    ;
    private ArrayList<Praca> listaPrac;
    static Map<Long, Zlecenie> zlecenieMap = new HashMap<>();
    static long idCounter = 0;
    private final long id;

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
        idCounter += 1;
        this.id = idCounter;
        zlecenieMap.put(id, this);

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
        idCounter += 1;
        this.id = idCounter;
        zlecenieMap.put(id, this);
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
        idCounter += 1;
        this.id = idCounter;
        zlecenieMap.put(id, this);
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
        idCounter += 1;
        this.id = idCounter;
        zlecenieMap.put(id, this);
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
            praca.kolejkaPrac.add(p);
        }
        this.listaPrac.add(praca);
    }

/*
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
                    }
                    System.out.println("2");
                }System.out.println("3");
                this.dataZakonczenia = LocalDate.now();
                System.out.println(this.dataZakonczenia);

            } catch (InterruptedException e) {
            }
        } else
            System.out.println("NIE MOŻNA WYKONAĆ ZLECENIA! UPEWNIJ SIĘ ZE ZLECENIE POSIADA BRYGADE I KOLEJKE PRAC.");

    }*/

    @Override
    public void run() {
        if (this.brygada != null && !this.listaPrac.isEmpty()) {
            if (!zlecenieMap.values().stream().anyMatch(zlecenie -> {
                if (zlecenie.brygada.workerList.stream().anyMatch(pracownik -> pracownik.isActive)) {
                    return true;
                }
                return false;
            })) {
                dataRealizacji = LocalDate.now();
                brygada.workerList.stream().forEach(pracownik -> pracownik.isActive = true);

                listaPrac.forEach(praca -> {
                            try {
                                praca.start();
                                praca.join();
                                listaPrac.forEach(praca1 -> {
                                    if (praca1.kolejkaPrac.contains(praca)) {
                                        praca1.kolejkaPrac.remove(praca);
                                    }
                                });
                            } catch (InterruptedException e) {
                            }
                        }
                );
                brygada.workerList.stream().forEach(pracownik -> pracownik.isActive = true);
                dataZakonczenia = LocalDate.now();
            } else {
                System.err.println("Jeden z pracowników jest zajęty innym zleceniem. Nie można wykonać zlecenia!");
            }
        }
    }

    public Stan stan() {
        if (dataZakonczenia != null) {
            return Stan.Zakonczone;
        } else if (dataRealizacji != null) return Stan.Rozpoczete;
        else return Stan.Utworzone;
    }

    public boolean addBrygada(Brygada brygada){
        if (this.brygada == null){
            this.brygada = brygada;
            return true;
        }else return false;
    }

    public Brygada getBrygada() {
        return brygada;
    }

    public Zlecenie getZlecenie(long id){
        return zlecenieMap.get(id);
    }

    @Override
    public String toString() {
        return "Zlecenie{" +
                "brygada=" + brygada +
                ", dataUtworzenia=" + dataUtworzenia +
                ", dataRealizacji=" + dataRealizacji +
                ", dataZakonczenia=" + dataZakonczenia +
                ", listaPrac=" + listaPrac +
                ", id=" + id +
                ", rodzaj=" + rodzaj +
                '}';
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
        ●voidrozpocznijZlecenie()[3p.] (DONE)
 */