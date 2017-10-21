package example.com.if26_tp5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ModifyModule extends AppCompatActivity implements View.OnClickListener{

    //Module sur lequel on voit le detail
    Module module;

    Button valider, quitter;
    TextView sigle, categorie, parcours, credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_module);

        Bundle extras = getIntent().getExtras();

        if (extras == null)
            return;

        //on recupere le module
        module = (Module) extras.getSerializable("ModuleModif");

        ajoutTitre();
        addViews();
        addListener();
        addDonnees();
    }

    //Permet de changer le titre de l'activite
    private void ajoutTitre() {
        setTitle("Modification du module "+ module.getSigle());
    }
    //association des vues
    private void addViews() {
        sigle = (TextView) findViewById(R.id.amm_sigle);
        categorie = (TextView) findViewById(R.id.amm_categorie);
        parcours = (TextView) findViewById(R.id.amm_parcours);
        credit = (TextView) findViewById(R.id.amm_credit);
        valider = (Button) findViewById(R.id.amm_valider);
        quitter = (Button) findViewById(R.id.amm_quitter);
    }

    //ajout des listener
    private void addListener() {
        valider.setOnClickListener(this);
        quitter.setOnClickListener(this);
    }

    //ajout des donnees dans les vues
    private void addDonnees() {
        String str = Integer.toString(module.getCredit());
        sigle.setHint(module.getSigle());
        categorie.setHint(module.getCategorie());
        parcours.setHint(module.getParcours());
        credit.setHint(str);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.amm_valider:
                //TODO modifier la base de donnees
                break;
            case R.id.amm_quitter:
                this.finish();
                break;
        }
    }
}
