package com.GUIprojekt1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DzialPracownikow {
    private String nazwa;
    private static List<DzialPracownikow> listaDzialow = new ArrayList<>();
    private Map<Pracownik, List<Zadanie>> zadaniaPracownikow = new HashMap<>();
    private List<Pracownik> pracownicy = new ArrayList<>();

    public DzialPracownikow(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {

        return nazwa;
    }

    public void setNazwa(String nazwa) {

        this.nazwa = nazwa;
    }

    public static void dodajDzial (DzialPracownikow dzial) throws NotUniqueNameException {

             for (DzialPracownikow d : listaDzialow) {
                 if (d.getNazwa().equals(dzial.getNazwa())) {
                     throw new NotUniqueNameException("Nazwa działu już istnieje: " + d.getNazwa());
                 }
             }
             listaDzialow.add(dzial);
    }

    public static void usunDzial(DzialPracownikow dzial) {
        listaDzialow.remove(dzial);
    }

    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
    }

    public void usunPracownika(Pracownik pracownik) {
        pracownicy.remove(pracownik);
    }

    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void dodajZadanie(Pracownik pracownik, Zadanie zadanie) {
        if (!zadaniaPracownikow.containsKey(pracownik)) {
            zadaniaPracownikow.put(pracownik, new ArrayList<>());
        }
        zadaniaPracownikow.get(pracownik).add(zadanie);
    }

    public Map<Pracownik,List<Zadanie>> getZadaniaPracownikow() {
        return zadaniaPracownikow;
    }
}
