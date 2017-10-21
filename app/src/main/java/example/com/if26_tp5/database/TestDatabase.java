package example.com.if26_tp5.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import example.com.if26_tp5.Module;
import example.com.if26_tp5.R;

public class TestDatabase extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_test);

        //Création d'une instance de ma classe LivresBDD
        DatabaseModule moduleBD = new DatabaseModule(this);

        //Création d'un module
        Module module = new Module("IF30", "CS", "ISI", 10);
        Module module2 = new Module("SY46", "CS", "ISI", 5);
        Module module3 = new Module("LO05", "TM", "ISI", 3);

        moduleBD.open();

        moduleBD.insertModule(module);
        moduleBD.insertModule(module2);
        moduleBD.insertModule(module3);

        Module mod = moduleBD.selectModule(module.getSigle());
        Toast.makeText(this, "modif dans la base", Toast.LENGTH_SHORT).show();
        if(mod != null){
            Toast.makeText(this, "Module modifié : "+mod.getSigle()+" "+mod.getCategorie()+" "+mod.getParcours()+" "+mod.getCredit(), Toast.LENGTH_LONG).show();
            mod.setSigle("IF40");
            //Puis on met à jour la BDD
            moduleBD.updateModule(mod.getId(), mod);
        }

        //on ferme la BD
        moduleBD.close();
    }
}
