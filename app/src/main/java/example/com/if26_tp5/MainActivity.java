package example.com.if26_tp5;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

//TODO dans la listview on affiche uniquement le nom du module et quand on click dessus ca affiche le detail du module
//TODO in instancie la base de donnee on se base sur l'activite livre si elle est null on utilise la methode IOModule.lireModules
public class MainActivity extends AppCompatActivity {

    public List<Module> modules = new ArrayList<>();

    private ModuleAdapter adapter;

    //Code pour les intents
    public static final int CODE_AJOUT_MODULE = 1;
    public static final int CODE_DETAIL_MODULE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);

        //gestion de la barre
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //Gestion des modules
        //creationModules();
        modules = IOModule.lireModules(this);
        initPositionModules();

        ListView lw_modules = (ListView) findViewById(R.id.lw_modules);
        adapter = new ModuleAdapter(MainActivity.this, modules);
        lw_modules.setAdapter(adapter);//ajout des modules dans la listview
    }

    @Override
// Inflate the menu; this adds items to the action bar if it is present.
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Initialisation de la position des modules
    private void initPositionModules() {
        for (int i = 0; i < modules.size(); i++)
            modules.get(i).setPosition(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.add_module:
                Intent intent = new Intent(this, AjoutModule.class);
                startActivityForResult(intent, CODE_AJOUT_MODULE);
                break;
            case R.id.delete_module:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Recuperation des donnees
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("retour", "yo1");
        //on le retour c'est bien passé
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CODE_AJOUT_MODULE:// si on vient de creer un module
                    if (data.hasExtra("Module")) {
                        Module module = (Module) data.getSerializableExtra("Module");
                        if (module != null) {
                            Snackbar.make(findViewById(R.id.coordinator), "module crée", Snackbar.LENGTH_LONG);
                            adapter.addModule(module);//on ajoute le module
                        } else {
                            Snackbar.make(findViewById(R.id.coordinator), "erreur sur la creation du module", Snackbar.LENGTH_LONG);
                        }
                    }
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //TODO sauvegarder dans la bd les nouveaux tuples
    }

    @Override
    protected void onStop() {
        super.onStop();
        //TODO sauvegarder dans la bd les nouveaux tuples
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //TODO sauvegarder dans la bd les nouveaux tuples
    }
}