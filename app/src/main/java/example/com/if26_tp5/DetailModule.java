package example.com.if26_tp5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//TODO Dans cette classe on mettra deux boutons supprimer ou modifier
class DetailModule extends AppCompatActivity implements View.OnClickListener {

    //Module sur lequel on voit le detail
    Module module;

    Button modifier, supprimer;

    TextView sigle, categorie, parcours, credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_module);

        Bundle extras = getIntent().getExtras();

        if (extras == null)
            return;

        //on recupere le module
        module = (Module) extras.getSerializable("ModuleDetail");

        addViews();
        addListener();
        addDonnees();
    }

    //association des vues
    private void addViews() {
        sigle = (TextView) findViewById(R.id.adm_sigle);
        categorie = (TextView) findViewById(R.id.adm_categorie);
        parcours = (TextView) findViewById(R.id.adm_parcours);
        credit = (TextView) findViewById(R.id.adm_credit);
        modifier = (Button) findViewById(R.id.adm_modifier);
        supprimer = (Button) findViewById(R.id.adm_supprimer);
    }

    //ajout des listener
    private void addListener() {
        modifier.setOnClickListener(this);
        supprimer.setOnClickListener(this);
    }

    //ajout des donnees dans les vues
    private void addDonnees() {

        sigle.setText(module.getSigle());
        categorie.setText(module.getCategorie());
        parcours.setText(module.getParcours());
        String str = Integer.toString(module.getCredit());
        credit.setText(str);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.adm_modifier:
                //TODO intent vers ModifyModule
                break;
            case R.id.adm_supprimer:
                //mettre une fenetre de dialogue voulez vous supprimer le module
                break;

        }
    }
}
