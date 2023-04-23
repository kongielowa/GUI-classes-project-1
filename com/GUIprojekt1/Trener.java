package com.GUIprojekt1;

import java.time.LocalDate;

public class Trener extends Pracownik implements IDobryPracownik {
    private String specjalizacja;

    public Trener(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial, String specjalizacja) {
        super(imie, nazwisko, dataUrodzenia, dzial);
        this.specjalizacja = specjalizacja;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }
    public void uprzejmy() {
        System.out.println("Trener jest uprzejmy");
    }

    public void zdyscyplinowany() {
        System.out.println("Trener jest zdyscyplinowany");
    }

    public void punktualny() {
        System.out.println("Trener jest punktualny");
    }
}






