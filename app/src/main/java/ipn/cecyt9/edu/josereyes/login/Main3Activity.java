package ipn.cecyt9.edu.josereyes.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView datos;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        datos = findViewById(R.id.datos);
        Intent i = new Intent();
        i = this.getIntent();

        usuario = i.getStringExtra("usuario");

        datos.setText(usuario);
    }

    public void volver(View us) {
        Intent i = new Intent(this, MainActivity.class);
        finish();
        startActivity(i);
    }
}
