package ipn.cecyt9.edu.josereyes.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText usuario, contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        usuario = findViewById(R.id.usuario);
        contra = findViewById(R.id.contra);
    }

    public void altaUsuario(View us) {
        UserContract usr = new UserContract(this, "administracion", null, 1);
        SQLiteDatabase db = usr.getWritableDatabase();
        String nombre = usuario.getText().toString().trim();
        String pass = contra.getText().toString().trim();

        ContentValues registro = new ContentValues();
        registro.put("nombre", nombre);
        registro.put("contra", pass);

        db.insert("usuario", null, registro);
        db.close();

        usuario.setText("");
        contra.setText("");
    }

    public void irLogin(View us) {
        Intent i = new Intent(this, MainActivity.class);
        finish();
        startActivity(i);
    }
}
