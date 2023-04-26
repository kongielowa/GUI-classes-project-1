package com.GUIprojekt1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Recepcjonista implements IDobryPracownik {
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

    public List<Zadanie> getZadaniaForManagera() {
        List<Zadanie> result = new ArrayList<>();
        for (Zespol zespol : zespoly) {
            for (Zadanie zadanie : zespol.getZadania()) {
                if (zadanie.getZespol().getManager() == this) {
                    result.add(zadanie);
                }
            }
        }
        return result;
    }

    public void addZespol(Zespol zespol) {
        zespoly.add(zespol);
    }

    public void removeZespol(Zespol zespol) {
        zespoly.remove(zespol);
    }

    public void addZadanie(Zadanie zadanie) {
        zadania.add(zadanie);
        zadanie.setManager(this);
    }

    public void usunZadanie(Zadanie zadanie) {
        if (zadanie.getZespol().getManager() == this) {
            zadania.remove(zadanie);
            zadanie.setManager(null);
        }
    }


    public List<Zadanie> getZadaniaDlaZespolu(Zespol zespol) {
        List<Zadanie> result = new ArrayList<>();
        for (Zadanie zadanie : zadania) {
            if (zadanie.getZespol() == zespol) {
                result.add(zadanie);
            }
        }
        return result;
    }

    public List<Zespol> getZespolDlaZadania(Zadanie zadanie) {
        List<Zespol> result = new ArrayList<>();
        for (Zespol zespol : zespoly) {
            if (zespol.getZadania().contains(zadanie)) {
                result.add(zespol);
            }
        }
        return result;
    }

    public void uprzejmy() {
    }

    public void zdyscyplinowany() {
    }

    public void punktualny() {
    }
}
