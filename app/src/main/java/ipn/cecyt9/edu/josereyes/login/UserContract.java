package ipn.cecyt9.edu.josereyes.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserContract extends SQLiteOpenHelper {

    String tabla = "create table usuario(idUsuario integer primary key autoincrement, nombre text, contra text)";
    String eliminar = "drop table if exists usuario";

    public UserContract(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(eliminar);
        db.execSQL(tabla);
    }
}
