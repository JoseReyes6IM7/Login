package ipn.cecyt9.edu.josereyes.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText usuario, contra;
    TextView msj;
    Button btLogin;
    int marca = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.usuario);
        contra = findViewById(R.id.contra);
        msj = findViewById(R.id.msj);
        btLogin = findViewById(R.id.button);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarUsuario(v);
                if(marca == 1)
                    iniciarSesion(v);
                else
                    msj.setText("Usuario y/o contraseña incorrectos");
            }
        });
    }

    public void irRegistro(View us) {
        Intent i = new Intent(this, Main2Activity.class);
        finish();
        startActivity(i);
    }

    public void iniciarSesion(View us) {
        Intent i = new Intent(this, Main3Activity.class);
        i.putExtra("usuario", usuario.getText().toString().trim());
        finish();
        startActivity(i);
    }

    public void verificarUsuario(View us) {
        UserContract usr = new UserContract(this, "administracion", null, 1);
        SQLiteDatabase bd = usr.getWritableDatabase();
        String nombre = usuario.getText().toString().trim();
        String pass = contra.getText().toString().trim();
        Cursor fila = bd.rawQuery("select idUsuario from usuario where nombre='"+ nombre +"' and contra='"+ pass +"'", null);

        if(fila.moveToFirst()) {
            marca = 1;
        }

        bd.close();
    }
}
