package example.com.if26_tp5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutModule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_module);//on lance le layout possedant le drawerLayout

        Button envoie = (Button) findViewById(R.id.aam_button);
        envoie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //renvoie du nouveau module a la listview de l'activite principale
    public void finish() {
        Intent intent = new Intent();
        EditText et_sigle = (EditText) findViewById(R.id.aam_sigle);
        EditText et_categorie = (EditText) findViewById(R.id.aam_categorie);
        EditText et_parcours = (EditText) findViewById(R.id.aam_parcours);
        EditText et_credit = (EditText) findViewById(R.id.aam_credit);

        String sigle = et_sigle.getText().toString();
        String categorie = et_categorie.getText().toString();
        String parcours = et_parcours.getText().toString();
        String credit = et_credit.getText().toString();

        //Gestion des erreurs
        if (sigle.isEmpty() || categorie.isEmpty() || parcours.isEmpty() || credit.isEmpty()) {
            affichageError(sigle, categorie, parcours, credit);
            return;
        }

        //Instanciation du nouveau module
        Module module = new Module(sigle, categorie, parcours, Integer.valueOf(credit));
        intent.putExtra("Module", module);
        setResult(RESULT_OK, intent);
        super.finish();
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
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
