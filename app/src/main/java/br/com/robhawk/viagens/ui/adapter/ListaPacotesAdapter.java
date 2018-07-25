package br.com.robhawk.viagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.robhawk.viagens.R;
import br.com.robhawk.viagens.model.Pacote;
import br.com.robhawk.viagens.util.DiasUtil;
import br.com.robhawk.viagens.util.DrawableUtil;
import br.com.robhawk.viagens.util.MoedaUtil;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(Context context, List<Pacote> pacotes) {
        this.context = context;
        this.pacotes = pacotes;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Object getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        if (view == null)
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);

        mostraImagem(view, pacote);
        mostraDias(view, pacote);
        mostraLocal(view, pacote);
        mostraPreco(view, pacote);

        return view;
    }

    private void mostraPreco(View view, Pacote pacote) {
        TextView preco = view.findViewById(R.id.item_pacote_preco);
        String precoFormatado = MoedaUtil.formataPrecoReal(pacote.getPreco());
        preco.setText(precoFormatado);
    }


    private void mostraLocal(View view, Pacote pacote) {
        TextView local = view.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }

    private void mostraDias(View view, Pacote pacote) {
        TextView dias = view.findViewById(R.id.item_pacote_dias);
        String labelDias = DiasUtil.formataDias(pacote.getDias());
        dias.setText(labelDias);
    }

    private void mostraImagem(View view, Pacote pacote) {
        ImageView imagem = view.findViewById(R.id.item_pacote_imagem);
        Drawable drawable = DrawableUtil.getDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

}
