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

    public void setNazwa(String nazwa) {

        this.nazwa = nazwa;
    }

    public static DzialPracownikow createDzial(String nazwa) throws NotUniqueNameException {
        for (DzialPracownikow d : listaDzialow) {
            if (d.getNazwa().equals(nazwa)) {
            }
            throw new NotUniqueNameException("Nazwa już istnieje, wybierz inną.");
        }

        DzialPracownikow nowyDzial = new DzialPracownikow(nazwa);
        listaDzialow.add(nowyDzial);
        return nowyDzial;
    }

    public static void usunDzial(DzialPracownikow dzial) {
        listaDzialow.remove(dzial);
    }

    public String getNazwa() {
        return nazwa;
    }

    public String setNazwa() {
        return nazwa;
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

    public Map<Pracownik, List<Zadanie>> getZadaniaPracownikow() {
        return zadaniaPracownikow;
    }

    public String uzyskajInformacjeOPracownikach() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pracownicy działu ").append(nazwa).append(": ");
        for (Pracownik pracownik : pracownicy) {
            sb.append(pracownik.getImie()).append(" ").append(pracownik.getNazwisko()).append(", ");
        }
        if (!pracownicy.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length()); // usunięcie ostatniego przecinka i spacji
        }
        return sb.toString();
    }
}
