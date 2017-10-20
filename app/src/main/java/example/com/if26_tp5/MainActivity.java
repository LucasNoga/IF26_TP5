package example.com.if26_tp5;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

//TODO dans la listview on affiche uniqument le nom du module et quand on click dessus ca affiche le detail du module
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    // Inflate the menu; this adds items to the action bar if it is present.
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_module) {
            Snackbar.make(findViewById(R.id.coordinator), "Creation module", Snackbar.LENGTH_LONG).show();
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.delete_module) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


/*
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public DrawerLayout drawer;
    public ActionBarDrawerToggle toggle;
    public List<Module> modules = new ArrayList<>();
    ModuleAdapter adapter;

    private static final int CODE_REQUETE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nav_main);//on lance le layout possedant le drawerLayout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Gestion des modules
        creationModules();

        ListView lw_modules = (ListView) findViewById(R.id.lw_modules);
        adapter = new ModuleAdapter(MainActivity.this, modules);
        lw_modules.setAdapter(adapter);

    }

    //creation des modules
    private void creationModules(){
        modules.add(new Module("IF26", "CS", "ISI", 6));
        modules.add(new Module("NF16", "TM", "ISI", 6));
        modules.add(new Module("LO02", "CS", "ISI", 6));
        modules.add(new Module("GL02", "TM", "ISI", 6));
        modules.add(new Module("LO10", "CS", "ISI", 6));
        modules.add(new Module("LO12", "CS", "ISI", 6));
        modules.add(new Module("IF07", "TM", "ISI", 6));
        /*modules.add(new Module("IF15", "CS", "ISI", 6));
        modules.add(new Module("SY04", "CS", "ISI", 6));
        modules.add(new Module("RE02", "CS", "RT", 6));
        modules.add(new Module("RE04", "TM", "RT", 6));
        modules.add(new Module("IF10", "CS", "ISI", 6));
        modules.add(new Module("IF16", "CS", "ISI", 6));
        modules.add(new Module("SY15", "TM", "ISI", 6));
        modules.add(new Module("SC00", "CS", "CE", 4));
        modules.add(new Module("LE08", "CS", "CE", 4));
        modules.add(new Module("LE03", "CS", "CE", 4));*/
 /*    }

   @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //gere la navigation
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addModule:
                Intent intent =  new Intent(this, AjoutModule.class);
                startActivityForResult(intent, CODE_REQUETE);
                break;
            case R.id.modifyModule:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Recuperation des donnees
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("retour", "yo1");
        if (resultCode == RESULT_OK && requestCode == CODE_REQUETE) {
            Log.i("retour", "yo2");
            if (data.hasExtra("Module")) {
                Log.i("retour", "yo3");
                Module module = (Module) data.getSerializableExtra("Module");
                if (module != null) {
                    Log.i("retour", "yo4");
                    Toast.makeText(this, "module crée", Toast.LENGTH_SHORT).show();
                    adapter.add(module);//on ajoute le module
                }
                else {
                    Log.i("retour", "yo5");
                    Toast.makeText(this, "erreur sur la creation du module", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
*/