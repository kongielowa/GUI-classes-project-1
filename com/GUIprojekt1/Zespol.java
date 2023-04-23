package com.GUIprojekt1;

import java.util.ArrayList;
import java.util.List;

public class Zespol {
    private String nazwa;
    private Manager manager;
    private List<Pracownik> pracownicy;
    private List<Zadanie> zadania;


    public Zespol(String nazwa, Manager manager) {
        this.nazwa = nazwa;
        this.manager = manager;
        this.pracownicy = new ArrayList<>();
        this.zadania = new ArrayList<>();
    }

    public String getNazwa() {
        return nazwa;
    }

    public Manager getManager() {
        return manager;
    }

    public void dodajPracownika(Pracownik pracownik) {
        if (pracownik instanceof Manager) {
            System.out.println("Nie ma możliwości dodania managera jako szeregowego pracownika.");
            return;
        }
        pracownicy.add(pracownik);
    }

    public boolean czyPracownicySaChorzy() {
        for (Pracownik pracownik : pracownicy) {
            if (pracownik.isCzyZdrowy()) {
                return true;
            }
        }
        return false;
    }


    public void dodajPracownika(List<Pracownik> nowiPracownicy) {
        for (Pracownik pracownik : nowiPracownicy) {
            dodajPracownika(pracownik);
        }
    }

    public void dodajZadanie(Zadanie zadanie) {
        this.zadania.add(zadanie);
    }

    public List<Zadanie> getZadania() {
        return zadania;
    }

    public void setZadania(List<Zadanie> zadania) {
        this.zadania = zadania;
    }

}
