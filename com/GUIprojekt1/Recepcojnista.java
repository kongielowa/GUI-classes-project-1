package com.GUIprojekt1;

import java.time.LocalDate;

public class Recepcojnista extends Pracownik implements IDobryPracownik {
    private String login;
    private String haslo;
    private String initial;

    public Recepcojnista(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial, String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzial);
        this.login = login;
        this.haslo = haslo;
        this.initial = generateInitial(imie, nazwisko);
    }

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public void setImie(String imie) {
        super.setImie(imie);
        this.initial = generateInitial(imie, this.getNazwisko());
    }

    public void setNazwisko(String nazwisko) {
        super.setNazwisko(nazwisko);
        this.initial = generateInitial(this.getImie(), nazwisko);
    }

    private String generateInitial(String imie, String nazwisko) {
        return Character.toString(imie.charAt(0)) + Character.toString(nazwisko.charAt(0));
    }

    public void uprzejmy() {
        System.out.println("Recepcjonista jest uprzejmy");
    }

    @Override
    public void zdyscyplinowany() {
        System.out.println("Recepcjonista jest zdyscyplinowany");
    }

    @Override
    public void punktualny() {
        System.out.println("Recepcjonista jest punktualny");
    }
}

