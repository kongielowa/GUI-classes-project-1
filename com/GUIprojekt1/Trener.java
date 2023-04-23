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
    }

    public void zdyscyplinowany() {
    }

    public void punktualny() {
    }

}
