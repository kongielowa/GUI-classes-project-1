package com.GUIprojekt1;

public class NotUniqueNameException extends Exception {
    public NotUniqueNameException(String errormessage) {
        super(errormessage);
    }
}

//Powyższy kod tworzy klasę NotUniqueNameException, która dziedziczy po klasie Exception.
// Klasa ta posiada jedno pole - message, które jest przekazywane w konstruktorze.
// W przypadku rzucenia wyjątku NotUniqueNameException zostanie wyświetlony komunikat podany jako argument konstruktora.


//Klasa "Exception" jest częścią standardowej biblioteki języka Java i jest dostępna domyślnie
// w każdym programie napisanym w tym języku. Jest to klasa bazowa dla wielu rodzajów wyjątków,
// które mogą być rzucone podczas wykonywania programu.