package pl.coderslab.spring01hibernatekrkw07.ut.zad2;

// Napisz klasę Factors mającą jedną statyczną metodę generatePrimeFactors(n), która wygeneruje wszystkie dzielniki podanej liczby n w kolejności numerycznej (od najmniejszego).
//
//Napisz to zadanie, używając w pełni metodologii TDD.
//
//Wykonuj commit po każdy z 3 etapów procesu, czyli:
//
//po napisaniu testów
//po napisaniu kodu
//po refaktoryzacji

import java.util.ArrayList;
import java.util.List;

public class Factors {
    public static List<Integer> generatePrimeFactors(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                result.add(i);
            }
        }

        result.add(n);

        return result;
    }
}
