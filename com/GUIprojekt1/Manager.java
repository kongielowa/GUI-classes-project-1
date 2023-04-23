package com.GUIprojekt1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Recepcojnista implements IDobryPracownik {
    private List<Zespol> zespoly;
    private List<Zadanie> zadania;

    public Manager(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial, String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzial, login, haslo);
        this.zespoly = new ArrayList<>();
        this.zadania = new ArrayList<>();
    }

    public List<Zespol> getZespoly() {
        return zespoly;
    }

    public List<Zadanie> getZadania() {
        return zadania;
    }

    public void addZespol(Zespol zespol) {
        zespoly.add(zespol);
    }

    public void removeZespol(Zespol zespol) {
        zespoly.remove(zespol);
    }

    public void addZadanie(Zadanie zadanie) {
        zadania.add(zadanie);
    }

    public void removeZadanie(Zadanie zadanie) {
        zadania.remove(zadanie);
    }
    public void uprzejmy() {
    }

    public void zdyscyplinowany() {
    }

    public void punktualny() {
    }
}
