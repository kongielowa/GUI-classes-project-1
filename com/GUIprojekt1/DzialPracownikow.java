package com.GUIprojekt1;

import java.util.ArrayList;
import java.util.List;

public class DzialPracownikow {
    private String nazwa;
    private static List<DzialPracownikow> listaDzialow = new ArrayList<>();

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
}
