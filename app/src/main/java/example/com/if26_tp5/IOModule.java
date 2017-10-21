package example.com.if26_tp5;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*LectureModule permet de stocker dans un fichier les modules avec leur credit, leur categorie et leur type*/
class IOModule {

    /*lireModules est la methode qui le le fichier ou sont contenus les modules et les instancie en objet java*/
    static List<Module> lireModules(Context context) {
        List<Module> modules = new ArrayList<>();
        BufferedReader reader;
        String ligne;

        String listeMots[]; //Represente les mots d'une ligne
        String nomModule, parcoursModule, categorieModule;
        int creditModule;
        InputStream inputStream = context.getResources().openRawResource(R.raw.modules);

        //Parcours toutes les lignes du fichier texte
        if (inputStream != null) try {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((ligne = reader.readLine()) != null) {
                listeMots = ligne.split(" ");
                creditModule = Integer.valueOf(listeMots[1]);
                nomModule = listeMots[0];
                categorieModule = listeMots[2];
                parcoursModule = listeMots[3];
                modules.add(new Module(nomModule, categorieModule, parcoursModule, creditModule));
            }
            //on fermer les flux
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Erreur de fichier");
            e.printStackTrace();
        }
        return modules;
    }
}