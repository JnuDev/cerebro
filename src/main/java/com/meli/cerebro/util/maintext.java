package com.meli.cerebro.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class maintext {

    private final static String NUCLEOTIDES_REGEX = "A{4}|T{4}|C{4}|G{4}";

    private static Pattern pattern = Pattern.compile(NUCLEOTIDES_REGEX, Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {

        String[] vec = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
        if (vec == null || vec.length == 0)
            ;

        List<String> chrNucleotides = new ArrayList<String>();
        List<String> origen = Arrays.asList(vec);

        // captura horizontales
        chrNucleotides.addAll(origen);
        String newWord = "";
        // captura verticales
        for (int i = 0; i < origen.size(); i++) {
            newWord = "";
            for (String string : origen) {
                newWord += string.charAt(i);
            }
            chrNucleotides.add(newWord);
        }

        // capturar diagonales
        getWordDigPrin(vec, chrNucleotides);
        getWordDigSecund(vec, chrNucleotides);

        chrNucleotides.forEach(System.out::println);

        List<Integer> secuq = chrNucleotides.stream()
                .map(p -> evalSequenceRegex(p))
                .collect(Collectors.toList());

        IntSummaryStatistics totals = secuq.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        int valor = (int) totals.getSum();

        System.out.println(valor);
    }

    private static void getWordDigPrin(String[] vec, List<String> chrNucleotides) {

        String newWord = "";
        int word = 3; // palabra en lista (index)
        int ind = 0; // pocición del caracter (.charAt(i))
        int maxLen = vec.length - 1;
        for (int len = 0; len <= maxLen - 1; len++) {

            for (Integer vertical = word, horizontal = ind; (vertical >= 0 && horizontal <= maxLen); // límites.
                    vertical -= 1, horizontal += 1 // Avanza en diagonal incrementando ambos ejes.
                    ) {
                newWord += vec[vertical].charAt(horizontal);
            }

            if (word == maxLen) {
                ind += 1;
            } else {
                word += 1;
            }

            chrNucleotides.add(newWord);
            newWord = "";
        }
    }

    private static void getWordDigSecund(String[] vec, List<String> chrNucleotides) {

        String newWord = "";
        int word = 0; // palabra en lista (index)
        int ind = 3; // pocición del caracter (.charAt(i))
        int maxLen = vec.length - 1;

        for (int len = 0; len <= maxLen - 1; len++) {

            for (Integer vertical = word, horizontal = ind; (vertical <= maxLen && horizontal >= 0); // límites.
                    vertical += 1, horizontal -= 1 // Avanza en diagonal incrementando ambos ejes.
                    ) {
                newWord += vec[vertical].charAt(horizontal);
            }

            if (ind == maxLen) {
                word += 1;
            } else {
                ind += 1;
            }

            chrNucleotides.add(newWord);
            newWord = "";
        }
    }

    private static int evalSequenceRegex(String line) {

        Matcher matcher = pattern.matcher(line);
        return (matcher.find()) ? 1 : 0;
    }
}
