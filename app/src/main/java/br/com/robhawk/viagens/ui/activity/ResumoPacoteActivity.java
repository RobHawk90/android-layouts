package br.com.robhawk.viagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.robhawk.viagens.R;
import br.com.robhawk.viagens.model.Pacote;
import br.com.robhawk.viagens.util.DataUtil;
import br.com.robhawk.viagens.util.DiasUtil;
import br.com.robhawk.viagens.util.DrawableUtil;
import br.com.robhawk.viagens.util.MoedaUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        mostraImagem(pacote);
        mostraLocal(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);

        Intent intent = new Intent(this, PagamentoActivity.class);
        startActivity(intent);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatada = DataUtil.formataPeriodo(pacote.getDias());
        data.setText(dataFormatada);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String precoFormatado = MoedaUtil.formataPrecoReal(pacote.getPreco());
        preco.setText(precoFormatado);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasFormatado = DiasUtil.formataDias(pacote.getDias());
        dias.setText(diasFormatado);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawable = DrawableUtil.getDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }
}
