package PRO1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        DzialPracownikow biuro = DzialPracownikow.createDzial("biuro");
        Specjalista test1 = new Specjalista("test","test", LocalDate.now(),biuro,"Test");
        Specjalista test2 = new Specjalista("test2","test2",LocalDate.now(),biuro,"Test");
        Uzytkownik JanNowak = new Uzytkownik("Jan","Nowak",LocalDate.now(),biuro,"Test","test");
        System.out.println(JanNowak.getInicjal());
        JanNowak.setNazwisko("Dąbrowski");
        System.out.println(JanNowak.getInicjal());
        //System.out.println(Pracownik.getPracownikArrayList().get(0)==(test1));
        System.out.println(Pracownik.idCounter);
*/
        Praca praca1 = new Praca(1, "praca1", Praca.rodzajPracy.MONTAZ);
        Praca praca2 = new Praca(1, "praca2", Praca.rodzajPracy.MONTAZ);
        Praca praca3 = new Praca(1, "praca3", Praca.rodzajPracy.MONTAZ);
        Praca praca4 = new Praca(1, "praca4", Praca.rodzajPracy.MONTAZ);
        Praca praca5 = new Praca(1, "praca5", Praca.rodzajPracy.MONTAZ);
        Praca praca6 = new Praca(1, "praca6", Praca.rodzajPracy.MONTAZ);
        Praca praca7 = new Praca(1, "praca7", Praca.rodzajPracy.MONTAZ);
        Praca praca8 = new Praca(2,"praca8", Praca.rodzajPracy.WYMIANA);

            DzialPracownikow dzialPracownikow = DzialPracownikow.createDzial("Test");
            Brygadzista brygadzista = new Brygadzista("test", "test", LocalDate.now(), dzialPracownikow, "123", "123");
            Brygada brygada = new Brygada("test",brygadzista);
            Zlecenie zlecenie = new Zlecenie(true,brygada);
        Thread t1 = new Thread(zlecenie);
        zlecenie.addPraca(praca1);
        zlecenie.addPraca(praca2);
        zlecenie.addPraca(praca3);
        zlecenie.addPraca(praca4);
        zlecenie.addPraca(praca5);
        zlecenie.addPraca(praca6);
        zlecenie.addPraca(praca7);
       t1.start();
       System.out.println(zlecenie.stan());








        // praca2.kolejkaPrac.add(praca1);
        //praca4.start();
        //Zlecenie zlecenie = new Zlecenie(true,)

    }
}

/*ToDO:
id dla każej klasy

 */