package com.GUIprojekt1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Pracownik implements Comparable<Pracownik> {
    private String imie;
    private String nazwisko;
    private LocalDate dataUrodzenia;
    private DzialPracownikow dzial;
    private boolean czyZdrowy = true;
    private String specjalizacja;
    private String login;
    private String haslo;

    private static List<Pracownik> listaPracownikow = new ArrayList<>();

    public Pracownik(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.dzial = dzial;
        listaPracownikow.add(this);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public DzialPracownikow getDzial() {
        return dzial;
    }

    public boolean isCzyZdrowy() {
        return czyZdrowy;
    }

    public void setCzyZdrowy(boolean czyZdrowy) {
        this.czyZdrowy = czyZdrowy;
    }

    public static List<Pracownik> getListaPracownikow() {
        return listaPracownikow;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin() {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public int compareTo(Pracownik other) {
        int compare = this.dataUrodzenia.compareTo(other.dataUrodzenia);
        if (compare == 0) {
            compare = this.nazwisko.compareTo(other.nazwisko);
        }
        return compare;
    }
}
