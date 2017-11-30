package come.example.dal32.datossqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class UsuariosSQLite extends SQLiteOpenHelper {
    String sqlCreacion = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT)";

    public UsuariosSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.sqlCreacion = sqlCreacion;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreacion);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL(sqlCreacion);
    }
}
