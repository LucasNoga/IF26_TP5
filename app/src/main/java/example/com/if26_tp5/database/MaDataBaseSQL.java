package example.com.if26_tp5.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/*Cette classe va nous permettre de définir la table qui sera produite lors de l'instanciation de celle-ci.*/
public class MaDataBaseSQL extends SQLiteOpenHelper{

    private static final String TABLE_MODULE = "Module";
    private static final String COL_ID = "ID";
    private static final String COL_SIGLE = "SIGLE";
    private static final String COL_CATEGORIE = "CATEGORIE";
    private static final String COL_PARCOURS = "PARCOURS";
    private static final String COL_CREDIT = "CREDIT";

    //Requete pour la creation de la table
    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_MODULE + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_SIGLE + " VARCHAR NOT NULL, "
            + COL_CATEGORIE + " VARCHAR NOT NULL, "
            + COL_PARCOURS + " VARCHAR NOT NULL, "
            + COL_CREDIT + " INTEGER NOT NULL);";

    /*Constructeur de la base*/
    public MaDataBaseSQL(Context context, String name, int version) {
        super(context, name, null, version);
    }


    @Override  //on crée la table à partir de la requête écrite dans la variable CREATE_BDD
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }

    @Override
    //suppression de la table et on la recréer
    //comme ça lorsque je change la version les id repartent de 0
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_MODULE + ";");
        onCreate(db);
    }
}
