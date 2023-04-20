package PRO1;

import java.util.ArrayList;

public class DzialPracownikow {
    static long idCounter = 0; //zmienna pomocnicza do id
    private final long id;
    private static ArrayList<DzialPracownikow> dzialList = new ArrayList<>(); // lista wszystkich działów
    private String nazwa;

    private DzialPracownikow(String name) throws NotUniqeNameException {
        this.nazwa = name;
        idCounter +=1;
        this.id = idCounter;
        for(DzialPracownikow dzial: dzialList){
            if(this.nazwa.equalsIgnoreCase(dzial.nazwa)){
                throw new NotUniqeNameException();
                //System.out.println("error");
            }
        }
    }

    public static ArrayList<DzialPracownikow> getDzialList() {
        return dzialList;
    }

    public static DzialPracownikow createDzial(String name){
        DzialPracownikow dzial;
        try {
            dzial = new DzialPracownikow(name);
        } catch (NotUniqeNameException e) {
            throw new RuntimeException(e);
        }
        dzialList.add(dzial);
        return dzial;


    }



    @Override
    public String toString() {
        return "DzialPracownikow{" +
                "nazwa='" + nazwa + '\'' +
                '}';
    }

    public ArrayList<Pracownik> getListOfWorkers(){ //zwraca listę wszystkich pracowników z tego działu odwołując się do klasy Pracownik
        ArrayList<Pracownik> returnList = new ArrayList<>();
        for(Pracownik pracownik : Pracownik.getPracownikArrayList()){
            if(pracownik.dzial.equals(this)){
                returnList.add(pracownik);
            }
        }return returnList;
    }
}



    class NotUniqeNameException extends Exception{
        public NotUniqeNameException(){
            super("Error: Nazwy dzialow musza byc unikalne!");
        }

}


/*DzialPracowikow[1p.]
●Nazwa:String,nazwa musi być unikalna, jeśli nie jest unikalna wyrzuć NotUniqueNameException(trzeba stworzyć takąklasę)przy tworzeniu obiektu (DONE)
Metoda●staticDzialPracowikowcreatDzial(Nazwa:String),[0,5p.]●getListPracownik()-znajdzwszystkichpracownikówztegodziału[1p.] (DONE)

 */