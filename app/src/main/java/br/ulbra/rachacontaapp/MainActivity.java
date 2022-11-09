package br.ulbra.rachacontaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText total;
    EditText pessoas;
    Button calcular, limpar;

    public void MonstrarResultado(String titulo, String mensagem, String botao){
        AlertDialog.Builder resultado = new AlertDialog.Builder(MainActivity.this);
        resultado.setTitle(titulo);
        resultado.setMessage(mensagem);
        resultado.setNegativeButton(botao, null);
        resultado.show();
    }



    public double Calcular(int op, double valor1, double valor2)
    {
        double res = 0;

        if (op == 4) {
            res = valor1 / valor2;
        }
        return res;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total = findViewById(R.id.total);
        pessoas = findViewById(R.id.pessoas);
        calcular = findViewById(R.id.calcular);
        limpar = findViewById(R.id.limpar);


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int op = 4;
                double Valor1, Valor2, div;
                Valor1 = Double.parseDouble(total.getText().toString());
                Valor2 = Double.parseDouble(pessoas.getText().toString());
                div = Valor1 / Valor2;
                MonstrarResultado("Resultado", "Quantidade de cada um é de" + Calcular(op, Valor1, Valor2), "Certo");

                if (total.getText().toString().isEmpty() && pessoas.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Campo em branco", Toast.LENGTH_LONG);
                }else{
                    MonstrarResultado("Resultado", "Quantidade de cada um é de" + Calcular(op, Valor1, Valor2), "Certo");
                }
            };
            }
        );
    }
};