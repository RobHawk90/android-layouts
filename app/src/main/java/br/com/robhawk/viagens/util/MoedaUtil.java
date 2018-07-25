package br.com.robhawk.viagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

public class MoedaUtil {

    private static final String LINGUAGEM = "pt";
    private static final String PAIS = "br";
    private static final String MOEDA = "R$";
    private static final String MOEDA_FORMATADA = "R$ ";

    public static String formataPrecoReal(BigDecimal preco) {
        return DecimalFormat
                .getCurrencyInstance(new Locale(LINGUAGEM, PAIS))
                .format(preco)
                .replace(MOEDA, MOEDA_FORMATADA);
    }

}
