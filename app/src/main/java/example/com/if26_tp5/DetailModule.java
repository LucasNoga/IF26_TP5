package example.com.if26_tp5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

//TODO Dans cette classe on mettra deux boutons supprimer ou modifier
class DetailModule extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_module);


        Bundle extras = getIntent().getExtras();

        if (extras == null) {
            return;
        }

        //on recupere le module
        Module module = (Module) extras.getSerializable("ModuleDetail");

        //recuperation des views
        TextView sigle = (TextView) findViewById(R.id.adm_sigle);
        TextView categorie = (TextView) findViewById(R.id.adm_categorie);
        TextView parcours = (TextView) findViewById(R.id.adm_parcours);
        TextView credit = (TextView) findViewById(R.id.adm_credit);



        Log.i("test", module.getParcours());

        //ajout des donnees dans les views
        String str = "Module : "+ module.getSigle();;
        sigle.setText(str);

        str = "Categorie : "+ module.getCategorie();
        categorie.setText(str);

        str = "Parcours : "+ module.getParcours();
        parcours.setText(str);

        str = "Credit : "+ module.getCredit();
        credit.setText(str);

    }
}
