package example.com.if26_tp6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModuleAddActivity extends AppCompatActivity {


    String sigle = "";
    String categorie = "";
    String parcours = "";
    String credit = "";
    Button envoie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_module);//on lance le layout possedant le drawerLayout

        envoie = (Button) findViewById(R.id.aam_button);
        envoie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //renvoie du nouveau module a la listview de l'activite principale
    public void finish() {
        if (envoie.isActivated()) {
            Log.i("test", "salut");
            creationModule();
        }
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        super.finish();
    }

    private void creationModule() {
        Intent intent = new Intent();
        EditText et_sigle = (EditText) findViewById(R.id.aam_sigle);
        EditText et_categorie = (EditText) findViewById(R.id.aam_categorie);
        EditText et_parcours = (EditText) findViewById(R.id.aam_parcours);
        EditText et_credit = (EditText) findViewById(R.id.aam_credit);

        sigle = et_sigle.getText().toString();
        categorie = et_categorie.getText().toString();
        parcours = et_parcours.getText().toString();
        credit = et_credit.getText().toString();

        //Gestion des erreurs
        if (sigle.isEmpty() || categorie.isEmpty() || parcours.isEmpty() || credit.isEmpty()) {
            affichageError(sigle, categorie, parcours, credit);
        } else {
            //Instanciation du nouveau module
            Module module = new Module(sigle, Integer.valueOf(credit), categorie, parcours);
            intent.putExtra("Module", module);
            setResult(RESULT_OK, intent);
        }
    }

    private void affichageError(String sigle, String categorie, String parcours, String credit) {
        String str = "";
        if (sigle.isEmpty())
            str+= "sigle manquant ";
        if ( categorie.isEmpty())
            str+= "categorie manquant ";
        if ( parcours.isEmpty())
            str+= "parcours manquant ";
        if ( credit.isEmpty())
            str+= "credit manquant ";
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
}
