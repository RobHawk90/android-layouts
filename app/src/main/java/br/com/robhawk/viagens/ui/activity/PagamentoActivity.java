package br.com.robhawk.viagens.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.robhawk.viagens.R;
import br.com.robhawk.viagens.model.Pacote;
import br.com.robhawk.viagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        mostraPreco(pacote);
    }

    private void mostraPreco(Pacote pacote) {
        TextView valor = findViewById(R.id.pagamento_valor);
        String valorFormatado = MoedaUtil.formataPrecoReal(pacote.getPreco());
        valor.setText(valorFormatado);
    }
}
