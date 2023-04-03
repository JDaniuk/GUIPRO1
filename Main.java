package PRO1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DzialPracownikow biuro = DzialPracownikow.createDzial("biuro");
        Specjalista test1 = new Specjalista("test","test", LocalDate.now(),biuro,"Test");
        Specjalista test2 = new Specjalista("test2","test2",LocalDate.now(),biuro,"Test");
        Uzytkownik JanNowak = new Uzytkownik("Jan","Nowak",LocalDate.now(),biuro,"Test","test");
        System.out.println(JanNowak.getInicjal());
        JanNowak.setNazwisko("Dąbrowski");
        System.out.println(JanNowak.getInicjal());
        //System.out.println(Pracownik.getPracownikArrayList().get(0)==(test1));

    }
