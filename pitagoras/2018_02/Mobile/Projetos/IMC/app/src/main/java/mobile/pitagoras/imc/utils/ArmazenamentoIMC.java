package mobile.pitagoras.imc.utils;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

public class ArmazenamentoIMC {

    private final SharedPreferences imcSharedPreferences;

    public ArmazenamentoIMC(Context context){
        this.imcSharedPreferences = context.getSharedPreferences("pessoas_imc",Context.MODE_PRIVATE);
    }

    public void salvar(String key, String value){
        this.imcSharedPreferences.edit().putString(key,value).apply();
    }

    public Map<String, ?> buscarTodos(){
        return this.imcSharedPreferences .getAll();
    }
}














/*


    public Map<String, ?> buscarTodos(){
        Map<String, ?> todasPessoas = this.imcSharedPreferences .getAll();
        for (Map.Entry<String, ?> entry : todasPessoas.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
        }
        return todasPessoas;
    }
*
* */
