package example.com.if26_tp6;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ModuleAdapter extends ArrayAdapter<Module> {

    private LayoutInflater inflater;
    private Context context;

    public ModuleAdapter(Context context, List<Module> modules) {
        super(context, android.R.layout.simple_list_item_1, modules);
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final int pos = position;
        final Module module = getItem(position);

        ViewHolder holder;
        //on recupere la vue ayant le layout module_item en recuperant les vues enfants avec les id
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.module_item, parent, false);
            //convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.module_item, parent, false);
        }

        //si on a des vus recyclés alors inutile d'instancier une convertview
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.sigle = convertView.findViewById(R.id.mi_sigle);
        holder.parcours = convertView.findViewById(R.id.mi_parcours);
        holder.categorie = convertView.findViewById(R.id.mi_categorie);
        holder.credit = convertView.findViewById(R.id.mi_credit);

        // envoie des donnees au holder
        holder.sigle.setText(module.getSigle());
        holder.parcours.setText(module.getParcours());
        holder.categorie.setText(module.getCategorie());
        holder.credit.setText(String.valueOf(module.getCredit()));

        //envoie du holder a la vue
        convertView.setTag(holder);

        // ajout d'un listener
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View view) {
                // a modifier
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext())
                        .setTitle("Suppression Module")
                        .setMessage("voulez vous supprimer le module " + module.getSigle())
                        .setCancelable(true);
                dialog.create();

                dialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteModule(i);
                        //MainActivity.modules.remove(position);
                        notifyDataSetChanged();
                    }
                });

                dialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Module non creer", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.show();
                return false;
            }

        });
        return convertView;
    }

    private void deleteModule(int pos) {
        this.remove(getItem(pos));
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    //Classe permettant de sauvegarder l'etat de la personne et de pouvoir recuperer la position.
    private class ViewHolder{
        TextView	sigle;
        TextView	parcours;
        TextView	categorie;
        TextView	credit;
    }
}