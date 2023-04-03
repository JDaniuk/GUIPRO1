package PRO1;

import java.util.ArrayList;

public class Brygada {
    static ArrayList<Brygada> brygadaArrayList = new ArrayList<>();
    String nazwa;
    Brygadzista brygadzista;
    ArrayList<Pracownik> workerList;

    public void addWorker(Pracownik p){
        workerList.add(p);
    }

    public void addWorker(ArrayList<Pracownik> pracownikArrayList){
        workerList.addAll(pracownikArrayList);
    }
}
