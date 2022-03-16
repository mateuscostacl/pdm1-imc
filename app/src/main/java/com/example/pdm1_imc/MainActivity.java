package com.example.pdm1_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etPeso;
    EditText etAltura;
    Button btResultado;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = findViewById(R.id.et_peso);
        etAltura = findViewById(R.id.et_altura);
        btResultado = findViewById(R.id.bt_resultado);
        tvResultado = findViewById(R.id.tv_resultado);

        btResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado();
            }
        });
    }


    private void resultado() {

        double peso = Double.parseDouble(etPeso.getText().toString());
        double altura = Double.parseDouble(etAltura.getText().toString());
        double resultado = calculaIMC(peso, altura);

        exibirResultado(resultado);
    }

    private void exibirResultado(double resultado){
        tvResultado.setText(
                String.format("%.1f", resultado)
                        + "\n"
                        + indicador(resultado));
    }

    private double calculaIMC(double peso, double altura) {
        altura = altura / 100;
        return peso / (altura * altura);
    }

    private String indicador(double result) {
        if (result < 18.5)
            return "Você está abaixo do peso ideal.";
        if (result >= 18.5 && result < 25)
            return "Parabéns, você está em seu peso normal.";
        else
            return "Você está acima de seu peso (sobrepeso).";
    }
}