package example.com.if26_tp6;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<String> sigles;
    public static List<Module> modules;

    //Code pour les intents
    public static final int CODE_AJOUT_MODULE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sigles = getSigles();
        modules = getModules();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_module:
                addModule();
                break;

            case R.id.list_sigle:
                listSigle();
                break;

            case R.id.list_module:
                listModule();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Recuperation des donnees
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //on le retour c'est bien passé
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CODE_AJOUT_MODULE:// si on vient de creer un module
                    AjoutModule(data);
                    break;
            }
        }
    }

    private void AjoutModule(Intent data) {
        if (data.hasExtra("Module")) {
            Module module = (Module) data.getSerializableExtra("Module");
            if (module != null) {
                Snackbar.make(findViewById(R.id.coordinator), "module crée", Snackbar.LENGTH_LONG);
                modules.add(module);//ajout du module
                sigles.add(module.getSigle());//ajout du sigle
            }
        }
        else {//si on a pas de module
            Snackbar.make(findViewById(R.id.coordinator), "Vous n'avez pas crée de module\nVoulez-vous en creer un", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            addModule();
                        }
                    })
                    .setActionTextColor(Color.RED)
                    .show();
        }
    }

    // lors d'ajout d'un module
    private void addModule() {
        startActivityForResult(new Intent(this, ModuleAddActivity.class), CODE_AJOUT_MODULE);
    }

    private void listSigle() {
        startActivity(new Intent(this, ModuleSigleListActivity.class));
    }

    private void listModule() {
        startActivity(new Intent(this, ModuleListActivity.class));
    }

    public List<Module> getModules() {
        List<Module> modules = new ArrayList<>();
        modules.add(new Module("GL02", 6, "CS", "ISI"));
        modules.add(new Module("NF16", 6, "CS", "ISI"));
        modules.add(new Module("NF20", 6, "CS", "ISI"));
        modules.add(new Module("IF07", 6, "TM", "ISI"));
        modules.add(new Module("IF09", 6, "TM", "ISI"));
        modules.add(new Module("IF14", 6, "TM", "ISI"));
        modules.add(new Module("LO02", 6, "TM", "ISI"));
        modules.add(new Module("IF02", 6, "CS", "ISI"));
        modules.add(new Module("LO12", 6, "CS", "ISI"));
        modules.add(new Module("RE04", 6, "CS", "ISI"));
        modules.add(new Module("EG23", 6, "TM", "ISI"));
        modules.add(new Module("IF03", 6, "TM", "ISI"));
        modules.add(new Module("LO07", 6, "TM", "ISI"));
        modules.add(new Module("NF19", 6, "TM", "ISI"));
        modules.add(new Module("GS13", 6, "CS", "ISI"));
        modules.add(new Module("IF10", 6, "CS", "ISI"));
        modules.add(new Module("IF15", 6, "CS", "ISI"));
        modules.add(new Module("GS11", 6, "TM", "ISI"));
        modules.add(new Module("IF16", 6, "TM", "ISI"));
        modules.add(new Module("IF17", 6, "TM", "ISI"));
        modules.add(new Module("IF20", 6, "TM", "ISI"));
        modules.add(new Module("IF26", 6, "TM", "ISI"));
        return modules;
    }

    private List<String> getSigles() {
        List<String> modules = new ArrayList<>();
        modules.add("GL02");
        modules.add("NF16");
        modules.add("NF20");
        modules.add("IF07");
        modules.add("IF09");
        modules.add("IF14");
        modules.add("LO02");
        modules.add("IF02");
        modules.add("LO12");
        modules.add("RE04");
        modules.add("EG23");
        modules.add("IF03");
        modules.add("LO07");
        modules.add("NF19");
        modules.add("GS13");
        modules.add("IF10");
        modules.add("IF15");
        modules.add("GS11");
        modules.add("IF16");
        modules.add("IF17");
        modules.add("IF20");
        modules.add("IF26");
        return modules;
    }
}
