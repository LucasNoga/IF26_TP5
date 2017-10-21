package example.com.if26_tp5;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import static example.com.if26_tp5.MainActivity.CODE_DETAIL_MODULE;

//Classe qui gere les donnees
class ModuleAdapter extends BaseAdapter {

    List<Module> modules;
    LayoutInflater inflater;
    Context context;

    ModuleAdapter(Context context, List<Module> modules) {
        super();
        inflater = LayoutInflater.from(context);//on recupere le contexte de l'activite qui possede la listview (app_bar_activity_main)
        this.context = context;
        this.modules = modules;
    }

    //permet d'ajouter un module
    public void addModule(Module module){
        modules.add(module);
    }

    //retourne le nombre d'element present dans la liste
    public int getCount () {
        return modules.size();
    }

    //retourne l'element present dans la liste a la position pos
    public Module getItem (int pos) {
        return modules.get(pos);
    }

    //retourne la position d'un element present dans la liste
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        //on recupere la vue ayant le layout module_item en recuperant les vues enfants avec les id
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate (R.layout.module_item, null);
            holder.sigle = convertView.findViewById(R.id.sigle);
            //holder.button
            // convertView.setTag(holder);
        }
        //si on a des vus recyclés alors inutile d'instancier une convertview
        else {
            holder = (ViewHolder) convertView.getTag ();

        }
        holder.sigle = (TextView) convertView.findViewById (R.id.sigle);
        //holder.checked = (CheckBox) convertView.findViewById (R.id.checkbox);

        // envoie des donnees au holder
        holder.position = modules.get(position).getPosition ();
        holder.sigle.setText (modules.get(position).getSigle ());

        //envoie du holder a la vue
        convertView.setTag(holder);
        convertView.setOnClickListener(new View.OnClickListener() {

            //lorsqu'on clique sur un des modules
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailModule.class);
                intent.putExtra("ModuleDetail", getItem(position));
                context.startActivity(intent);
            }
        });
        Log.i("SIgle", getItem(position).getSigle());
        Log.i("cvPos", position+" itemPosSigle "+  getItem(position).getSigle() + " viewholder " + holder.sigle.getText().toString());
        return convertView;// on retourne la vue
    }

    //Classe permettant de sauvegarder l'etat de la personne et de pouvoir recuperer la position.
    private class ViewHolder{
        TextView	sigle;
        int         position;
    }
}
