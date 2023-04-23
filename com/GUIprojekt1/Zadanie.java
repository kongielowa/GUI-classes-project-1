package com.GUIprojekt1;

import java.time.LocalDateTime;
import com.GUIprojekt1.Manager;

public class Zadanie extends Thread {
    private String nazwa;
    private String opis;
    private Stan stan;
    private LocalDateTime dataUtworzenia;
    private LocalDateTime dataZakonczenia;
    private int czasWykonania;
    private Zespol zespol;
    private Manager manager;

    public Zadanie(String nazwa, String opis, Stan stan, LocalDateTime now) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.stan = stan;
        this.dataUtworzenia = LocalDateTime.now();
        this.czasWykonania = (int) (Math.random() * (8 -3 +1) + 3);
    }

    public Zadanie(String nazwa) {
        this(nazwa, "Opis zadania", Stan.UTWORZONE, LocalDateTime.now());
    }

    public Stan getStan() {
        return stan;
    }

    public void run() {
        if (czyPracownicySaChorzy()) {
            System.out.println("Brak możliwości rozpoczęcia zadania, co najmniej jedna osoba chora.");
            stan = Stan.UTWORZONE;
            return;
        }

        stan = Stan.ROZPOCZETE;
        System.out.println("Rozpoczynam zadanie " + nazwa);
        for (int i = 0; i < czasWykonania; i++) {
            System.out.println("Minęło " + i + " sekund od rozpoczęcia zadania");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        dataZakonczenia = LocalDateTime.now();
        stan = Stan.ZAKONCZONE;
        System.out.println("Zadanie " + nazwa + " zakończone.");
    }

    private boolean czyPracownicySaChorzy() {
        // Tutaj można dodać kod sprawdzający, czy co najmniej jeden pracownik jest chory
        return false;
    }

    public void setDataZakonczenia(LocalDateTime dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public boolean isZatwierdzone() {
        return true;
    }

    public String getOpis() {
        return opis;
    }

    public Zespol getZespol() {
        return zespol;
    }

    public boolean isWykonane() {
        return true;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }

    public void setManager(Manager manager) {
        if (this.manager != null) {
            this.manager.usunZadanie(this);
        }

    }


    public enum Stan {
        UTWORZONE,
        ROZPOCZETE,
        ZAKONCZONE,
        ZATWIERDZONE

    }

}
