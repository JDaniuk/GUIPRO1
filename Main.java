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
        Praca praca1 = new Praca(4, "praca1", Praca.rodzajPracy.MONTAZ);
        Praca praca2 = new Praca(1, "praca2", Praca.rodzajPracy.MONTAZ);
        Praca praca3 = new Praca(1, "praca3", Praca.rodzajPracy.MONTAZ);
        Praca praca4 = new Praca(1, "praca4", Praca.rodzajPracy.MONTAZ);
        Praca praca5 = new Praca(1, "praca5", Praca.rodzajPracy.MONTAZ);
        Praca praca6 = new Praca(1, "praca6", Praca.rodzajPracy.MONTAZ);
        Praca praca7 = new Praca(1, "praca7", Praca.rodzajPracy.MONTAZ);

            DzialPracownikow dzialPracownikow = DzialPracownikow.createDzial("Test");
            Brygadzista brygadzista = new Brygadzista("test", "test", LocalDate.now(), dzialPracownikow, "123", "123");
            Brygada brygada = new Brygada("test",brygadzista);
            Zlecenie zlecenie = new Zlecenie(true,brygada);

           praca1.kolejkaPrac.add(praca2);
           praca2.kolejkaPrac.add(praca3);
           praca2.kolejkaPrac.add(praca4);
           praca2.kolejkaPrac.add(praca5);
           //praca4.kolejkaPrac.add(praca7);
           //praca5.kolejkaPrac.add(praca7);
           praca1.start();









        // praca2.kolejkaPrac.add(praca1);
        //praca4.start();
        //Zlecenie zlecenie = new Zlecenie(true,)

    }
}

/*ToDO:
id dla każej klasy

 */