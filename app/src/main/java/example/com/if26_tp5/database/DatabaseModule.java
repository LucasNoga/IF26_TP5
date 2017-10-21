package example.com.if26_tp5.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import example.com.if26_tp5.Module;

/*
DatabaseModule va permettre de gérer la table module de la BD
l'insert, le delete, l'update et le select de modules dans la BD et de faire des requêtes pour récupérer un module contenu dans la BD.
*/
public class DatabaseModule {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "IF26_TP5.db";

    private static final String TABLE_MODULE = "Module";

    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;

    private static final String COL_SIGLE = "SIGLE";
    private static final int NUM_COL_SIGLE = 1;

    private static final String COL_CATEGORIE = "CATEGORIE";
    private static final int NUM_COL_CATEGORIE = 2;

    private static final String COL_PARCOURS = "PARCOURS";
    private static final int NUM_COL_PARCOURS = 3;

    private static final String COL_CREDIT = "CREDIT";
    private static final int NUM_COL_CREDIT = 4;

    //represente notre base de données de module
    private MaDataBaseSQL databaseModule;

    //objet necessaire pour avoir acces en lecture ou en ecriture a la base de donnees complete
    private SQLiteDatabase database;

    //On crée la BDD et sa table
    public DatabaseModule(Context context){
        databaseModule = new MaDataBaseSQL(context, NOM_BDD, VERSION_BDD);
    }

    //on ouvre la BDD en écriture
    public void open(){
            database = databaseModule.getWritableDatabase();
    }

    //on ferme l'accès à la BDD
    public void close(){
        database.close();
    }

    //getter pour recuperer l'acces a notre base
    public SQLiteDatabase getDatabase(){
        return database;
    }

    //Insertion d'un tuple dans la base de donnees (fonctionne comme une HashMap)
    public long insertModule(Module module){
        ContentValues values = new ContentValues();

        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_SIGLE, module.getSigle());
        values.put(COL_CATEGORIE, module.getCategorie());
        values.put(COL_PARCOURS, module.getParcours());
        values.put(COL_CREDIT, module.getCredit());

        return database.insert(TABLE_MODULE, null, values);//on insère l'objet dans la BDD via le ContentValues
    }

    //Mise a jour d'un module fonctionne plus ou moins comme une insertion, on recupere le module grace a son ID
    public int updateModule(int id, Module module){
        ContentValues values = new ContentValues();
        values.put(COL_SIGLE, module.getSigle());
        values.put(COL_CATEGORIE, module.getCategorie());
        values.put(COL_PARCOURS, module.getParcours());
        values.put(COL_CREDIT, module.getCredit());
        return database.update(TABLE_MODULE, values, COL_ID + " = " +id, null);
    }

    //Suppression d'un module de la BD grâce à l'ID
    public int deleteModule(int id){
        return database.delete(TABLE_MODULE, COL_ID + " = " +id, null);
    }

    //Récupère dans un Cursor les valeurs correspondant à un module contenu dans la BDD (ici on sélectionne le module grâce à son sigle)
    public Module selectModule(String sigle){
        Cursor c = database.query(TABLE_MODULE, new String[] {COL_ID, COL_SIGLE, COL_CATEGORIE, COL_PARCOURS, COL_CREDIT}, COL_SIGLE + " LIKE \"" + sigle +"\"", null, null, null, null);
        return cursorToModule(c);
    }

    //Cette méthode permet de convertir un cursor en un Module
    private Module cursorToModule(Cursor c) {
        if (c.getCount() == 0) //si aucun élément n'a été retourné dans la requête, on renvoie null
            return null;
        c.moveToFirst(); //Sinon on se place sur le premier élément
        Module module = new Module();  //On créé un module

        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        module.setId(c.getInt(NUM_COL_ID));
        module.setSigle(c.getString(NUM_COL_SIGLE));
        module.setCategorie(c.getString(NUM_COL_CATEGORIE));
        module.setParcours(c.getString(NUM_COL_PARCOURS));
        module.setCredit(c.getInt(NUM_COL_CREDIT));

        c.close();  //On ferme le cursor

        //On retourne le module
        return module;
    }
}
