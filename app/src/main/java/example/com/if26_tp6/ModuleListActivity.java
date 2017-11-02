package example.com.if26_tp6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ModuleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_list);

        ListView liste = (ListView) findViewById(R.id.aam_listeModule);
        ModuleAdapter adapter = new ModuleAdapter(this, MainActivity.modules);
        liste.setAdapter(adapter);
    }


}


