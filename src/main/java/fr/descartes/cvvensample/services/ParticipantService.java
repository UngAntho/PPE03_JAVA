package fr.descartes.cvvensample.services;

import java.util.List;
import java.util.Objects;

import org.hibernate.SessionFactory;

import fr.descartes.cvvensample.dao.Participant;

public class ParticipantService {
	
	private final SessionFactory sessionFactory;
	
	public ParticipantService(SessionFactory sessionFactory) {
		this.sessionFactory = Objects.requireNonNull(sessionFactory);
	}
	
	/**
	 * Méthode permettant d'insérer un {@link Participant} en base de données.
	 * 
	 * @param Participant
	 * 			Objet {@link Participant} devant être inséré en base de données.
	 */
	public void insertParticipant(Participant participant) {
		
	}
	
	/**
	 * Méthode permettant d'obtenir tous les {@link Participant} présents en base de données.
	 * 
	 * @return
	 * 			Une liste d'objets {@link Participant}.
	 */
	public List<Participant> getAllParticipant(){
		return null;
	}
	
	/**
	 * Méthode permettant de mettre à jour un {@link Participant}.
	 * 
	 * @param Participant
	 * 			Un {@link Participant} présent en base de données qui doit être mis à jour.
	 */
	public void updateParticipant(Participant participant) {
	
	}
	
	/**
	 * Méthode permettant de supprimer un {@link Participant} en base de données.
	 * 
	 * @param Participant
	 * 			Un objet {@link Participant} présent en base de données.
	 */
	public void deleteParticipant(Participant participant) {
	
	}
	
	/**
	 * Méthode permettant de supprimer un {@link Participant} identifié par son id en base de données.
	 * 
	 * @param numParticipant
	 * 			Numéro du {@link Participant} à supprimer en base de données.
	 */
	public void deleteParticipant(int numParticipant) {
	
	}

}
