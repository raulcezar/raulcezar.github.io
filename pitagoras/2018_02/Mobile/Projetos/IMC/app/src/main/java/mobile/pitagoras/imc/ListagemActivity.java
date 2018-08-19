package mobile.pitagoras.imc;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Map;

import mobile.pitagoras.imc.utils.ArmazenamentoIMC;
import mobile.pitagoras.imc.utils.PessoaIMC;

public class ListagemActivity extends AppCompatActivity {
    private ArmazenamentoIMC armazenamentoIMC;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        armazenamentoIMC = new ArmazenamentoIMC(this);
        Buscar();
    }

    public void Buscar(){
        //View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_listagem, null);
        LinearLayout listagem_layout = (LinearLayout)findViewById(R.id.listagem_layout);
        Map<String, ?> todasPessoas = armazenamentoIMC.buscarTodos();
        listagem_layout.removeAllViews();
        LinearLayout.LayoutParams layoutParamsTitulo = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsTitulo.setMargins(10,30,0,0);
        layoutParamsTitulo.gravity = Gravity.CENTER;
        LinearLayout.LayoutParams layoutParamsNome = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsNome.setMargins(10,20,0,0);
        LinearLayout.LayoutParams layoutParamsDados = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsDados.setMargins(10,0,0,0);
        TextView textIMCFamilia = new TextView(this);
        textIMCFamilia.setTextSize(30);
        textIMCFamilia.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        textIMCFamilia.setText("IMC da Família");
        textIMCFamilia.setLayoutParams(layoutParamsTitulo);
        listagem_layout.addView(textIMCFamilia);
        for (Map.Entry<String, ?> entry : todasPessoas.entrySet()) {
            PessoaIMC pessoaIMC = gson.fromJson(entry.getValue().toString(), PessoaIMC.class);
            TextView textNome = new TextView(this);
            textNome.setLayoutParams(layoutParamsNome);
            textNome.setTextSize(20);
            textNome.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            textNome.setText(pessoaIMC.nome);
            listagem_layout.addView(textNome);
            TextView textPeso = new TextView(this);
            textPeso.setLayoutParams(layoutParamsDados);
            textPeso.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            textPeso.setText("peso: "+pessoaIMC.peso);
            listagem_layout.addView(textPeso);
            TextView textAltura = new TextView(this);
            textAltura.setLayoutParams(layoutParamsDados);
            textAltura.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            textAltura.setText("altura: "+pessoaIMC.altura);
            listagem_layout.addView(textAltura);
            TextView textImc = new TextView(this);
            textImc.setLayoutParams(layoutParamsDados);
            textImc.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            textImc.setText("IMC: "+pessoaIMC.imc);
            listagem_layout.addView(textImc);
            TextView textClassificacao = new TextView(this);
            textClassificacao.setLayoutParams(layoutParamsDados);
            textClassificacao.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            textClassificacao.setText("classificação: "+pessoaIMC.classificacao);
            listagem_layout.addView(textClassificacao);
        }
    }
}
