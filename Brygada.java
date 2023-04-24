package PRO1;

import java.util.ArrayList;

public class Brygada {
    static ArrayList<Brygada> brygadaArrayList = new ArrayList<>();
    static long idCounter = 0;
    private final long id;
    String nazwa;
    Brygadzista brygadzista;
    ArrayList<Pracownik> workerList = new ArrayList<>();


    public Brygada(){
        idCounter+=1;
        id=idCounter;
        nazwa = "Brygada "+id;
    }

    public Brygada(String nazwa){
        idCounter+=1;
        id=idCounter;
        this.nazwa = nazwa;
    }
    public Brygada(String nazwa, Brygadzista brygadzista){
        idCounter+=1;
        id=idCounter;
        this.nazwa = nazwa;
        this.brygadzista = brygadzista;
    }
    public void add(Pracownik p){
        workerList.add(p);
    }

    public void add(ArrayList<Pracownik> pracownikArrayList){
        workerList.addAll(pracownikArrayList);
    }

    @Override
    public String toString() {
        return "Brygada{" +
                "nazwa='" + nazwa + '\'' +
                ", brygadzista=" + brygadzista +
                ", workerList=" + workerList +
                '}';
    }
}
/*
Brygada[1p.]
    ●Nazwabrygady:String (DONE)
    ●Lista<Pracownik>,pustaprzytworzeniuobiektu,(DONE)
    ●brygadzista:Brygadzista,(DONE)
    Metody:
        ●voidadd(List<Pracownik>list)[0,25p.](DONE)
        ●voidadd(Pracownikp)[0,25p.](DONE)
 */