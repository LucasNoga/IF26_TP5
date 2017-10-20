package example.com.if26_tp5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ModuleAdapter extends ArrayAdapter<Module> {

    private Context context;

    public ModuleAdapter(Context context, List<Module> modules) {
        super(context, 0, modules);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.module_item, parent, false);
        }

        ModuleViewHolder viewHolder = (ModuleViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ModuleViewHolder();
            viewHolder.sigle = convertView.findViewById(R.id.sigle);
            convertView.setTag(viewHolder);
        }

        Module module = getItem(position);

        //remplir la nouvelle vue
        viewHolder.sigle.setText(context.getResources().getString(R.string.sigle) +" : " + module.getSigle());
        viewHolder.categorie.setText(context.getResources().getString(R.string.categorie) +" : " + module.getCategorie());
        viewHolder.parcours.setText(context.getResources().getString(R.string.parcours) +" : " + module.getParcours());
        viewHolder.credit.setText(context.getResources().getString(R.string.credit) +" : " + module.getCredit());
        return convertView;
    }

    //permet de recycler les vues
    private class ModuleViewHolder{
        public TextView sigle;
        public TextView categorie;
        public TextView parcours;
        public TextView credit;

    }
}
