package example.com.if26_tp5;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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

//TODO dans la listview on affiche uniqument le nom du module et quand on click dessus ca affiche le detail du module
public class MainActivity extends AppCompatActivity {

    public List<Module> modules = new ArrayList<>();

    private ModuleAdapter adapter;

    //Code pour les intents
    public static final int CODE_AJOUT_MODULE = 1;
    public static final int CODE_DETAIL_MODULE = 2;

    String test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_activity_main);

        //gestion de la barre
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Gestion des modules
        creationModules();
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

    //creation des modules
    private void creationModules() {
        modules.add(new Module("IF26", "CS", "ISI", 6));
        modules.add(new Module("NF16", "TM", "ISI", 6));
        modules.add(new Module("LO02", "CS", "ISI", 6));
        modules.add(new Module("GL02", "TM", "ISI", 6));
        modules.add(new Module("LO10", "CS", "ISI", 6));
        modules.add(new Module("LO12", "CS", "ISI", 6));
        modules.add(new Module("IF07", "TM", "ISI", 6));
        modules.add(new Module("IF15", "CS", "ISI", 6));
        modules.add(new Module("SY04", "CS", "ISI", 6));
        modules.add(new Module("RE02", "CS", "RT", 6));
        modules.add(new Module("RE04", "TM", "RT", 6));
        modules.add(new Module("IF10", "CS", "ISI", 6));
        modules.add(new Module("IF16", "CS", "ISI", 6));
        modules.add(new Module("SY15", "TM", "ISI", 6));
        modules.add(new Module("SC00", "CS", "CE", 4));
        modules.add(new Module("LE08", "CS", "CE", 4));
        modules.add(new Module("LE03", "CS", "CE", 4));
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
    }

   @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
*/












/////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
public class CheckActivity extends ListActivity
{
	/** Called when the activity is first created.

    private EditText		_filterText		= null;
    private personAdapter	_adapter		= null;
    private List<Person>		Person;
    private ListView		personList;

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.main);

        person = new ArrayList<person> ();
        person.add (new person ("Toto", "Toti"));
        person.add (new person ("Tata", "Titi"));
        person.add (new person ("Padre", "Papa"));
        person.add (new person ("Mum", "Maman"));
        person.add (new person ("Aba", "ima"));
        person.add (new person ("Mickey", "Mouse"));
        person.add (new person ("Mini", "Mouse"));
        person.add (new person ("Testeur", "Pro"));
        person.add (new person ("Developpez", "Forum"));
        person.add (new person ("Voilou", "Voili"));

        Collections.sort (person);

        _adapter = new personAdapter (this, person);
        setListAdapter (_adapter);
        personList = getListView ();
        personList.setItemsCanFocus (false);
        personList.setOnItemClickListener (new OnItemClickListener ()
        {

            @Override
            public void onItemClick (AdapterView<?> parentView,
                                     View selectedItemView, int position, long id)
            {
                CheckBox c = (CheckBox) selectedItemView
                        .findViewById (R.id.checkbox);
//On recupere le tag
                ViewHolder view = ((ViewHolder) c.getTag ());
//On gere le check
                if (!c.isChecked ())
                {
                    person.get (view.position).setChecked (true);
                }
                else
                {
                    person.get (view.position).setChecked (false);
                }
//On replace la liste à la bonne position
                int pos = parentView.getFirstVisiblePosition ();
                personList.setSelection (pos);
            }
        });
    }
}
 */