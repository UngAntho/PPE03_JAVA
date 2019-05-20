package fr.descartes.cvvensample.dao;


import java.util.Date;

/*
 * TODO :
 * Rendre la classe Participant persistante avec les annotations de Hibernate.
 */

public class Participant {

	/*
	 * TODO :
	 * Rajouter les champs, constructeurs et méthodes de la classe Participant
	 *  Participant(num_pers,nom,prenom,email,date_naiss,organisation,observations)*/
	
         private int num_pers;
         private String nom;
         private String prenom;
         private String email;
         private Date date_naiss;
         private String organisation;
         private String observations;

    public Participant(int num_pers, String nom, String prenom, String email, Date date_naiss, String organisation, String observations) {
        this.num_pers = num_pers;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisation = organisation;
        this.observations = observations;
    }
    
    @Override
    public String toString() {
        return this.email;
    }

    public int getNum_pers() {
        return num_pers;
    }

    public void setNum_pers(int num_pers) {
        this.num_pers = num_pers;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
         
         
         
}
