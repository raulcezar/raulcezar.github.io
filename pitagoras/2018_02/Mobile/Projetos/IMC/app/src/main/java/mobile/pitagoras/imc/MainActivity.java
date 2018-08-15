package mobile.pitagoras.imc;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private ViewHolder mainViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        this.mainViewHolder.imc = (TextView) findViewById(R.id.imc);
        this.mainViewHolder.classificacao = (TextView) findViewById(R.id.classificacao);
        this.mainViewHolder.nome = (EditText) findViewById(R.id.nome);
        this.mainViewHolder.peso = (EditText) findViewById(R.id.peso);
        this.mainViewHolder.altura = (EditText) findViewById(R.id.altura);
        this.mainViewHolder.calcular = (Button) findViewById(R.id.calcular);
    }
    private class ViewHolder {
        TextView imc;
        TextView classificacao;
        EditText nome;
        EditText peso;
        EditText altura;
        Button calcular;
    }
    public void Calcular(View view) {
        Double peso = Double.valueOf(this.mainViewHolder.peso.getText().toString());
        Double altura = Double.valueOf(this.mainViewHolder.altura.getText().toString());
        Double imc = calcularIMC(peso,altura);
        String classificacao = classificarIMC(imc);
        this.mainViewHolder.imc.setText(String.format("%.2f",imc));
        this.mainViewHolder.classificacao.setText(classificacao);
    }
    public Double calcularIMC(Double peso, Double altura){
        return  peso/(altura*altura);
    }
    public String classificarIMC(Double imc){
        if(imc < 17)
            return "Muito abaixo do peso";
        if(imc < 18.49)
            return "Abaixo do peso";
        if(imc < 24.99)
            return "Peso normal";
        if(imc < 29.99)
            return "Acima do peso";
        if(imc < 34.99)
            return "Obesidade I";
        if(imc < 39.99)
            return "Obesidade II (severa)";
        return "Obesidade III (mórbida)";
    }
}
