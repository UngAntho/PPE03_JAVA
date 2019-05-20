package fr.descartes.cvvensample.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/*
 * TODO :
 * Rendre la classe Evenement persistante avec les annotations de Hibernate.
 */

public class Evenement {

    /*
     * TODO :
     * Rajouter les champs, constructeurs et méthodes de la classe Evenement
     *Evenement(num_even,intitule,theme,date_debut,duree,nb_part_max,description,organisateur
    anisateur,type_even)*/
    
    private int num_even;
    private String intitule;
    private String theme;
    private Date date_debut;
    private int duree;
    private int nb_part_max;
    private String description;
    private String organisateur;
    private int type_event;
    private List<Participant> participants;

    public Evenement(int num_even, String intitule, String theme, Date date_debut, int duree, int nb_part_max, String description, String organisateur, int type_event) {
        this.num_even = num_even;
        this.intitule = intitule;
        this.theme = theme;
        this.date_debut = date_debut;
        this.duree = duree;
        this.nb_part_max = nb_part_max;
        this.description = description;
        this.organisateur = organisateur;
        this.type_event = type_event;
        this.participants = new ArrayList<Participant>();
    }

    @Override
    public String toString() {
        return this.intitule;
    }
    
    public String getParticipantsEmails() {
        String emails = "";
        for(Participant participant : participants ) {
            emails += participant.getEmail() + "\n";
        }
        return emails;
    }

    public int getNum_even() {
        return num_even;
    }

    public void setNum_even(int num_even) {
        this.num_even = num_even;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getNb_part_max() {
        return nb_part_max;
    }

    public void setNb_part_max(int nb_part_max) {
        this.nb_part_max = nb_part_max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public int getType_event() {
        return type_event;
    }

    public void setType_event(int type_event) {
        this.type_event = type_event;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
    
    
}
