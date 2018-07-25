package br.com.robhawk.viagens.util;

public class DiasUtil {

    private static final String DIAS = " dias";
    private static final String DIA = " dia";

    public static String formataDias(int dias) {
        String label = dias > 1 ? DIAS : DIA;
        return dias + label;
    }

}
