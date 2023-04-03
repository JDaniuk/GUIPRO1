package PRO1;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Pracownik implements Comparable<Pracownik> { //TODO: Implement Comparable
    private static ArrayList<Pracownik> pracownikArrayList = new ArrayList<>();
    String imie, nazwisko;
    LocalDate dataUrodzenia;
    DzialPracownikow dzial;
    public Pracownik(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.dzial = dzial;
        pracownikArrayList.add(this);
    }

    public int compareTo(Pracownik p) {
        return this.dataUrodzenia.compareTo(p.dataUrodzenia);
    }

    public static ArrayList<Pracownik> getPracownikArrayList() {
        return pracownikArrayList;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
}


class Specjalista extends Pracownik{
   private String specjalizacja;
    public Specjalista(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial, String specjalizacja){
        super(imie,nazwisko,dataUrodzenia,dzial);
        this.specjalizacja = specjalizacja;
    }


    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    @Override
    public int compareTo(Pracownik p) {
        return super.compareTo(p);
    }
}

class Uzytkownik extends Pracownik{
    private String login, haslo,inicjal;

    public Uzytkownik(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial,String login, String haslo){
        super(imie,nazwisko,dataUrodzenia,dzial);
        this.login = login;
        this.haslo =haslo;
        inicjal = generateInicjal(imie,nazwisko);
    }

    private String generateInicjal(String imie, String nazwisko){
        return ""+imie.charAt(0)+nazwisko.charAt(0);
    }

    public String getInicjal() {
        return inicjal;
    }

    @Override
    public void setImie(String imie) {
        super.setImie(imie);
        inicjal = generateInicjal(imie, this.nazwisko);
    }

    @Override
    public void setNazwisko(String nazwisko) {
        super.setNazwisko(nazwisko);
        inicjal = generateInicjal(this.imie, nazwisko);
    }
}

class Brygadzista extends Uzytkownik{

    public Brygadzista(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial,String login, String haslo){
        super(imie,nazwisko,dataUrodzenia,dzial,login,haslo);
    }
    public ArrayList<Brygada> getListaBrygad(){
        ArrayList<Brygada> returnList = new ArrayList<>();
        for(Brygada brygada : Brygada.brygadaArrayList){
            if(brygada.brygadzista.equals(this)){
                returnList.add(brygada);
            }
        }return returnList;
    }
}