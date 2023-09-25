package be.bstorm.ylorth;

import lombok.Data;

@Data
public class Javanais {

    private long id;
    private String nom;
    private String prenom;
    private int numeroRoueInfortune;
    private Voiture voiture;


    @Override
    public String toString() {;
        if(voiture == null)
            return "Je m'appelle "+ prenom+ " et je n'ai pas de voiture";
        else
            return "Je m'appelle "+ prenom+ " et je roule en " +voiture.getMarque();
    }
}
