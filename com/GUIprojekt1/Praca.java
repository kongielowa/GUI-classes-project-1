package com.GUIprojekt1;

import java.util.HashMap;
import java.util.Map;

public class Praca implements Runnable {
    private Map<Integer, Zadanie> zadania;
    private String opis;
    private Zespol zespol;

    public Praca(String opis, Zespol zespol) {
        this.opis = opis;
        this.zespol = zespol;
        this.zadania = new HashMap<>();
    }

    public static Praca pobierzPrace(Map<Integer, Zadanie> wszystkieZadania, int id) {
        Zadanie zadanie = wszystkieZadania.get(id);
        if (zadanie == null) {
            throw new IllegalArgumentException("Brak zadania o wskazanym ID.");
        }
        if (!zadanie.isZatwierdzone()) {
            throw new IllegalArgumentException("Nie można rozpocząć zadania, bo nie zostało zatwierdzone.");
        }
        Praca praca = new Praca(zadanie.getOpis(), zadanie.getZespol());
        praca.dodajZadanie(id, zadanie);
        return praca;
    }

    public void dodajZadanie(int id, Zadanie zadanie) {
        zadania.put(id, zadanie);
    }

    public void wykonaj() {
        if (zadania.isEmpty()) {
            System.out.println("Nie ma zadań do wykonania.");
            return;
        }
        for (Zadanie zadanie : zadania.values()) {
            if (!zadanie.isWykonane()) {
                synchronized (zadanie) {
                    while (!zadanie.isWykonane()) {
                        try {
                            zadanie.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Przerwano wykonywanie zadania.");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Wykonano wszystkie zadania. :)");
    }

    @Override
    public void run() {
        wykonaj();
    }
}
