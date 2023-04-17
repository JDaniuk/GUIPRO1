package PRO1;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Pracownik implements Comparable<Pracownik> { //TODO: Implement Comparable
    private static ArrayList<Pracownik> pracownikArrayList = new ArrayList<>();
    static long idCounter = 0;
    private final long id;
    String imie, nazwisko;
    LocalDate dataUrodzenia;
    DzialPracownikow dzial;

    public Pracownik(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial) {
        idCounter += 1;
        this.id = idCounter;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.dzial = dzial;
        pracownikArrayList.add(this);
    }

    public int compareTo(Pracownik p) {
        if (this.nazwisko.toLowerCase().charAt(0) > p.nazwisko.toLowerCase().charAt(0)) {
            return 1;
        } else if (this.nazwisko.toLowerCase().charAt(0) < p.nazwisko.toLowerCase().charAt(0)) {
            return -1;
        } else if (this.nazwisko.toLowerCase().charAt(0) == p.nazwisko.toLowerCase().charAt(0)) {
            if (this.imie.toLowerCase().charAt(0) > p.imie.toLowerCase().charAt(0)) {
                return 1;
            } else if (this.imie.toLowerCase().charAt(0) < p.imie.toLowerCase().charAt(0)) {
                return -1;
            } else if (this.imie.toLowerCase().charAt(0) == p.imie.toLowerCase().charAt(0)) {
                if (this.dataUrodzenia.compareTo(p.dataUrodzenia) > 0) {
                    return 1;
                } else if (this.dataUrodzenia.compareTo(p.dataUrodzenia) < 0) {
                    return -1;
                }
            }
        }
        return 0;

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

    @Override
    public String toString() {
        return "Pracownik{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", dzial=" + dzial +
                '}';
    }
}


class Specjalista extends Pracownik {
    private String specjalizacja;
    static long idCounter = 0; //pomocnicza do id
    private final long id;

    public Specjalista(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial, String specjalizacja) {
        super(imie, nazwisko, dataUrodzenia, dzial);
        idCounter += 1;
        this.id = idCounter;
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

    @Override
    public String toString() {
        return "Specjalista{" +
                "specjalizacja='" + specjalizacja + '\'' +
                ", id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", dzial=" + dzial +
                '}';
    }
}

class Uzytkownik extends Pracownik {
    private String login, haslo, inicjal;

    public Uzytkownik(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial, String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzial);
        this.login = login;
        this.haslo = haslo;
        inicjal = generateInicjal(imie, nazwisko);
    }

    private String generateInicjal(String imie, String nazwisko) {
        return "" + imie.charAt(0) + nazwisko.charAt(0);
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

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", inicjal='" + inicjal + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", dzial=" + dzial +
                '}';
    }
}

class Brygadzista extends Uzytkownik {

    public Brygadzista(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial, String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzial, login, haslo);
    }

    public ArrayList<Brygada> getListaBrygad() {
        ArrayList<Brygada> returnList = new ArrayList<>();
        for (Brygada brygada : Brygada.brygadaArrayList) {
            if (brygada.brygadzista.equals(this)) {
                returnList.add(brygada);
            }
        }
        return returnList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}