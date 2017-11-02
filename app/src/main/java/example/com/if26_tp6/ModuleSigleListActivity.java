package example.com.if26_tp6;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ModuleSigleListActivity extends ListActivity {

    public static ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigle_list);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.sigles);
        setListAdapter(adapter);
    }


}