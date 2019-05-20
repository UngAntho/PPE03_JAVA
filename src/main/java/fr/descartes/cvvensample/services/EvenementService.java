package fr.descartes.cvvensample.services;

import java.util.List;
import java.util.Objects;

import org.hibernate.SessionFactory;

import fr.descartes.cvvensample.dao.Evenement;

public class EvenementService {
	
	private final SessionFactory sessionFactory;
	
	public EvenementService(SessionFactory sessionFactory) {
		this.sessionFactory = Objects.requireNonNull(sessionFactory);
	}
	
	/**
	 * Méthode permettant d'insérer un {@link Evenement} en base de données.
	 * 
	 * @param evenement
	 * 			Objet {@link Evenement} devant être inséré en base de données.
	 */
	public void insertEvenement(Evenement evenement) {
		
	}
	
	/**
	 * Méthode permettant d'obtenir tous les {@link Evenement} présents en base de données.
	 * 
	 * @return
	 * 			Une liste d'objets {@link Evenement}.
	 */
	public List<Evenement> getAllEvenement(){
		return null;
	}
	
	/**
	 * Méthode permettant de mettre à jour un {@link Evenement}.
	 * 
	 * @param evenement
	 * 			Un {@link Evenement} présent en base de données qui doit être mis à jour.
	 */
	public void updateEvenement(Evenement evenement) {
		
	}
	
	/**
	 * Méthode permettant de supprimer un {@link Evenement} en base de données.
	 * 
	 * @param evenement
	 * 			Un objet {@link Evenement} présent en base de données.
	 */
	public void deleteEvenement(Evenement evenement) {
		
	}
	
	/**
	 * Méthode permettant de supprimer un {@link Evenement} identifié par son id en base de données.
	 * 
	 * @param numEvenement
	 * 			Numéro de l'{@link Evenement} à supprimer en base de données.
	 */
	public void deleteEvenement(int numEvenement) {
		
	}

}
