package br.ulbra.apostila6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int placarJoagador = 0, placarApp = 0;
    Button btnReiniciar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionado("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionado("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionado("Tesoura");
    }

    public void opcaoSelecionado(String opcaoSelecionado) {
        ImageView imageResultado = findViewById(R.id.padrao);
        TextView txtResult = findViewById(R.id.txtResultado);
        String opcoes[] = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[new Random().nextInt(3)];
        btnReiniciar = (Button) findViewById(R.id.btnReiniciar);
        switch (opcaoApp) {
            case "Pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if ((opcaoApp.equals("Tesoura") && opcaoSelecionado.equals("Papel")) ||
                (opcaoApp.equals("Papel") && opcaoSelecionado.equals("Pedra")) ||
                (opcaoApp.equals("Pedra") && opcaoSelecionado.equals("Tesoura"))) {
            placarApp += 1;
            atualizarPlacar();
            if (placarApp == 2) {
                txtResult.setText("Você PERDEU...");
            }

        } else if ((opcaoSelecionado.equals("Tesoura") &&
                opcaoApp.equals("Papel")) ||
                (opcaoSelecionado.equals("Papel") && opcaoApp.equals("Pedra"))
                ||
                (opcaoSelecionado.equals("Pedra") && opcaoApp.equals("Tesoura"))) {
            placarJoagador += 1;
            atualizarPlacar();
            if (placarJoagador == 2) {
                txtResult.setText("Você GANHOU!!!");
            }
        } else {
            txtResult.setText("Você EMPATOU ...");
        }

    }

    public void atualizarPlacar() {
        TextView txtPlacar = findViewById(R.id.txPlacar);
        txtPlacar.setText("Jogador" + placarJoagador + "- App " + placarApp);
    }

    public void reiniciarJogo(View view) {
        placarJoagador = 0;
        placarApp = 0;
        atualizarPlacar();
        ImageView imageResultado = findViewById(R.id.padrao);
        imageResultado.setImageResource(android.R.color.transparent); // Limpa a imagem

    }
}
