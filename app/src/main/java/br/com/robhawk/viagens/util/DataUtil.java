package br.com.robhawk.viagens.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DataUtil {

    public static final String FORMATO_DIA_MES = "dd/MM";

    public static String formataPeriodo(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatter = new SimpleDateFormat(FORMATO_DIA_MES, Locale.getDefault());
        String dataIdaFormatada = formatter.format(dataIda.getTime());
        String dataVoltaFormatada = formatter.format(dataVolta.getTime());
        int ano = dataVolta.get(Calendar.YEAR);
        return dataIdaFormatada + " - " + dataVoltaFormatada + " de " + ano;
    }

}
