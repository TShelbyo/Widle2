package com.example.tho.widle;

/**
 * Created by Théo on 18/02/2018.
 */

public class Salle {

    private String libelle;
    private String capacite;
    private String description;

    public Salle(String l,String c,String d) {
        libelle=l;
        capacite=c;
        description=d;
    }

    public Salle(String l) {
        libelle=l;
        capacite=null;
        description=null;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getCapacite() {
        return capacite;
    }

    public String getDescription() {
        return description;
    }
}
