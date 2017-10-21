package example.com.if26_tp5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//TODO Dans cette classe on mettra deux boutons supprimer ou modifier
class DetailModule extends AppCompatActivity implements View.OnClickListener {

    //Module sur lequel on voit le detail
    Module module;

    Button modifier, supprimer, quitter;

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

        if (module == null)
            return;

        ajoutTitre();
        addViews();
        addListener();
        addDonnees();
    }

    //Permet de changer le titre de l'activite
    private void ajoutTitre() {
        setTitle("Detail du module "+ module.getSigle());
    }

    //association des vues
    private void addViews() {
        sigle = (TextView) findViewById(R.id.adm_sigle);
        categorie = (TextView) findViewById(R.id.adm_categorie);
        parcours = (TextView) findViewById(R.id.adm_parcours);
        credit = (TextView) findViewById(R.id.adm_credit);
        modifier = (Button) findViewById(R.id.adm_modifier);
        supprimer = (Button) findViewById(R.id.adm_supprimer);
        quitter = (Button) findViewById(R.id.adm_quitter);
    }

    //ajout des listener
    private void addListener() {
        modifier.setOnClickListener(this);
        supprimer.setOnClickListener(this);
        quitter.setOnClickListener(this);
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
                Intent intent = new Intent(this, ModifyModule.class);
                intent.putExtra("ModuleModif", module);
                startActivity(intent);
                break;
            case R.id.adm_supprimer:
                //mettre une fenetre de dialogue voulez vous supprimer le module

                break;

            case R.id.adm_quitter:
                this.finish();
                break;
        }
    }
}
