import com.GUIprojekt1.DzialPracownikow;
import com.GUIprojekt1.Manager;
import com.GUIprojekt1.Zadanie;
import com.GUIprojekt1.Zadanie.Stan;
import com.GUIprojekt1.Zespol;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    private static int idZadania;

    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID zadania");
        idZadania = scanner.nextInt();

        //tworzę obiekt DzialPracownikow
        DzialPracownikow dzial = new DzialPracownikow("IT");

        //tworzę obiekt Manager
        Manager manager = new Manager("Lidia", "Kongiel", LocalDate.parse("1998-09-30"), dzial, "lkongiel", "pjatk");

        //tworzę obiekt Zespol
        Zespol zespol = new Zespol("Zespol programistów", manager);

        //pobranie zadani o wskazanym id
        Zadanie zadanie = zespol.pobierzPrace(idZadania);

        //tworzę obiekt Zadanie
        Zadanie zadanie = new Zadanie("Zadanie pierwsze", "Przetestuj program Lidii :) ", Stan.UTWORZONE, LocalDateTime.now());

        //dodaję zadanie do zespołu
        zespol.dodajZadanie(zadanie);

        //stan-zatwierdzone
        zadanie.setStan(Stan.ZATWIERDZONE);

        // start zadania
        zadanie.start();

        try {
            zadanie.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ustawienie daty zakonczenia zadania
        zadanie.setDataZakonczenia(LocalDateTime.now());

        //info o zespole i dodanym zadaniu
        System.out.println((zespol));
        System.out.println(zadanie);

        //info o stanie zadania po zakonczeniu
        System.out.println(zadanie);

        //check, czy ktoś chory
        if (zespol.czyPracownicySaChorzy()) {
            System.out.println("Nie można rozpocząć zadania, bo ktoś z zespołu jest chory.");
        } else {
            System.out.println("Wszystkie zadania wykonane.");
        }
    }
}


