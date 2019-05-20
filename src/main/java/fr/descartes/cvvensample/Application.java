package fr.descartes.cvvensample;

import fr.descartes.cvvensample.dao.Evenement;
import fr.descartes.cvvensample.dao.Participant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    private static int compteurEvenements = 0;
    private static int compteurParticipants  = 0;

    private static List<Evenement> evenements = new ArrayList<Evenement>();
    //int num_even, String intitule, String theme, Date date_debut, int duree, int nb_part_max, String description, String organisateur, int type_event
    private static List<Participant> participants = new ArrayList<Participant>();
   
    private String login = "login";
    private String motDePasse = "mdp";
    private String checkLogin, checkMotDePasse;

    private String eventIntitule, eventTheme, eventDescription, eventOrganisateur;
    private Date eventDateDebut;
    private int eventDuree; private int eventNbPersMax; private int evenType;
    
    private String participantNom, participantPrenom, participantEmail, participantOrganisation, participantObservation; 
    private Date participantDateNaiss;
    
    private BorderPane root;
    private GridPane loginScreen;
    private TabPane tabsPane;
    private GridPane creerEvenement;
    private GridPane ajouterParticipant;
    
    private ObservableList<Evenement> evenementListObservable = FXCollections.observableArrayList(evenements);
    private ComboBox<Evenement> comboBoxEvenements = new ComboBox<Evenement>();

    private TableView<Evenement> tableauEvenements = new TableView<Evenement>();
     
    public static void main(String[] args) {
        // Lance le programme JavaFX
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CCVEN PPE09");
        
        root = new BorderPane();
        root.setPadding(new Insets(10, 50, 50, 50));
        root.setPrefWidth(1300);
        root.setPrefHeight(800);

        // Création des screens
        initLoginScreen();
        initTabs();

        // LoginScreen
        root.setCenter(loginScreen);

        // Ajout BorderPane dans la scène
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    private void initLoginScreen() {
        loginScreen = new GridPane();
        loginScreen.setPadding(new Insets(20, 20, 20, 20));
        loginScreen.setHgap(5);
        loginScreen.setVgap(5);

        // Création des interfaces
        Label labelLogin = new Label("Login");
        final TextField textLogin = new TextField();
        Label labelMotDePasse = new Label("Mot de passe");
        final PasswordField passwordField = new PasswordField();
        Button buttonConnexion = new Button("Connexion");
        final Label labelMessage = new Label();

        // Ajout des interfaces dans le loginScreen
        loginScreen.add(labelLogin, 0, 0);
        loginScreen.add(textLogin, 1, 0);
        loginScreen.add(labelMotDePasse, 0, 1);
        loginScreen.add(passwordField, 1, 1);
        loginScreen.add(buttonConnexion, 2, 1);
        loginScreen.add(labelMessage, 1, 2);

        // Action bouton login
        buttonConnexion.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                checkLogin = textLogin.getText();
                checkMotDePasse = passwordField.getText();
                if (checkLogin.equals(login) && checkMotDePasse.equals(motDePasse)) {
                    root.setCenter(tabsPane);
                } else {
                    labelMessage.setText("Connexion échouée");
                    labelMessage.setTextFill(Color.RED);
                }
                textLogin.setText("");
                passwordField.setText("");
            }
        });
    }

    private void initTabs() {
        initCreerEvenementScreen();
        initVoirEvenementsScreen();
        initAjouterParticipantsScreen();
        
        tabsPane = new TabPane();
        tabsPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabCreerEvenement = new Tab();
        tabCreerEvenement.setText("Créer évènement");
        tabCreerEvenement.setContent(creerEvenement);
        tabsPane.getTabs().add(tabCreerEvenement);

        Tab tabVoirEvenements = new Tab();
        tabVoirEvenements.setText("Voir évènement");
        tabVoirEvenements.setContent(tableauEvenements);
        tabsPane.getTabs().add(tabVoirEvenements);

        Tab tabAjouterParticipants = new Tab();
        tabAjouterParticipants.setText("Ajouter Participant");
        tabAjouterParticipants.setContent(ajouterParticipant);
        tabsPane.getTabs().add(tabAjouterParticipants);
    }
   
    private void initCreerEvenementScreen() {
        
        creerEvenement = new GridPane();
        creerEvenement.setPadding(new Insets(20, 20, 20, 20));
        creerEvenement.setHgap(8);
        creerEvenement.setVgap(8);

        // Création des interfaces
       // Label headerLabel = new Label("Création d'évenements");
        Label labelIntitule = new Label("Intitulé :");
        final TextField textIntitule = new TextField();
        Label labelTheme = new Label("Theme :");
        final TextField textTheme = new TextField();
        Label labelDateDebut = new Label ("Date début :");
        final DatePicker dateDebutPicker = new DatePicker();
        Label labelDuree = new Label("Durée : (nombre)");
        final TextField textDuree = new TextField();
        Label labelNbPersMax = new Label("Nombre de personnes maximum :");
        final TextField textNbPersMax = new TextField();
        Label labelDescription = new Label("Description :");
        final TextField textDescription = new TextField();
        Label labelOrganisateur = new Label("Organisateur :");
        final TextField textOrganisateur = new TextField();
        Label labelTypeEvent = new Label("Type événement : (nombre)");
        final TextField textTypeEvent = new TextField();        
        
        
        Button buttonValide = new Button("Valider");
        final Label labelMessage = new Label();

        // Ajout des interfaces dans le loginScreen
        creerEvenement.add(labelIntitule, 0, 0);
        creerEvenement.add(textIntitule, 1, 0);
        creerEvenement.add(labelTheme, 0, 1);
        creerEvenement.add(textTheme, 1, 1);
        creerEvenement.add(labelDateDebut, 0, 2);
        creerEvenement.add(dateDebutPicker, 1, 2);
        creerEvenement.add(labelDuree, 0, 3);
        creerEvenement.add(textDuree, 1, 3);
        creerEvenement.add(labelNbPersMax, 0, 4);
        creerEvenement.add(textNbPersMax, 1, 4);
        creerEvenement.add(labelDescription, 0, 5);
        creerEvenement.add(textDescription, 1, 5);
        creerEvenement.add(labelOrganisateur, 0, 6);
        creerEvenement.add(textOrganisateur, 1, 6);
        creerEvenement.add(labelTypeEvent, 0, 7);
        creerEvenement.add(textTypeEvent, 1, 7);
        creerEvenement.add(buttonValide, 2, 7);
        creerEvenement.add(labelMessage, 1, 8);
        
        
        // Action bouton login 
        buttonValide.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                eventIntitule = textIntitule.getText();
                eventTheme = textTheme.getText();
                eventDateDebut = java.sql.Date.valueOf(dateDebutPicker.getValue());
                eventDuree = Integer.valueOf(textDuree.getText()); 
                eventNbPersMax = Integer.valueOf(textNbPersMax.getText());
                eventDescription = textDescription.getText();
                eventOrganisateur = textOrganisateur.getText();
                evenType = Integer.valueOf(textTypeEvent.getText());
                
                Evenement evenement = new Evenement(compteurEvenements ,eventIntitule,eventTheme,eventDateDebut,eventDuree,eventNbPersMax,eventDescription,eventOrganisateur, evenType);
                evenements.add(evenement);
                compteurEvenements++;
                
                evenementListObservable = FXCollections.observableArrayList(evenements);
                comboBoxEvenements.setItems(evenementListObservable);
                tableauEvenements.setItems(evenementListObservable);
            }
        });

    }
    
    private void initVoirEvenementsScreen() {
        TableColumn idCol = new TableColumn("Id");
        idCol.setMinWidth(20);
        idCol.setCellValueFactory(
                new PropertyValueFactory<Evenement, Integer>("num_even"));
 
        TableColumn intituleCol = new TableColumn("Intitulé");
        intituleCol.setMinWidth(100);
        intituleCol.setCellValueFactory(
                new PropertyValueFactory<Evenement, String>("intitule"));
 
        TableColumn themeCol = new TableColumn("Thème");
        themeCol.setMinWidth(100);
        themeCol.setCellValueFactory(
                new PropertyValueFactory<Evenement, String>("theme"));
        
        TableColumn dateCol = new TableColumn("Date");
        dateCol.setMinWidth(50);
        dateCol.setCellValueFactory(
                new PropertyValueFactory<Evenement, Date>("date_debut"));
        
        TableColumn dureeCol = new TableColumn("Durée");
        dureeCol.setMinWidth(20);
        dureeCol.setCellValueFactory(
                new PropertyValueFactory<Evenement, Integer>("duree"));
        
        TableColumn persMaxCol = new TableColumn("Participants max");
        persMaxCol.setMinWidth(20);
        persMaxCol.setCellValueFactory(
                new PropertyValueFactory<Evenement, Integer>("nb_part_max"));
        
        TableColumn descCol = new TableColumn("Description");
        descCol.setMinWidth(200);
        descCol.setCellValueFactory(
                new PropertyValueFactory<Evenement, String>("description"));
        
        TableColumn orgaCol = new TableColumn("Organisateur");
        orgaCol.setMinWidth(100);
        orgaCol.setCellValueFactory(
                new PropertyValueFactory<Evenement, String>("organisateur"));
        
        TableColumn typeCol = new TableColumn("Type");
        typeCol.setMinWidth(20);
        typeCol.setCellValueFactory(
                new PropertyValueFactory<Evenement, Integer>("type_event"));
        
        TableColumn participantsCol = new TableColumn("Participants");
        participantsCol.setMinWidth(100);
        participantsCol.setCellValueFactory(
                new PropertyValueFactory<Evenement, String>("participantsEmails"));
 
        tableauEvenements.setItems(evenementListObservable);
        tableauEvenements.getColumns().addAll(idCol, intituleCol, themeCol, dateCol, dureeCol, persMaxCol, descCol, orgaCol, typeCol, participantsCol);
    }

    private void initAjouterParticipantsScreen() {
        ajouterParticipant = new GridPane();
        ajouterParticipant.setPadding(new Insets(20, 20, 20, 20));
        ajouterParticipant.setHgap(7);
        ajouterParticipant.setVgap(7);

        // Création des interfaces
        Label labelNom = new Label("Nom");
        final TextField textNom = new TextField();
        Label labelPrenom = new Label("Prénom");
        final TextField textPrenom = new TextField();
        Label labelEmail = new Label("Email");
        final TextField textEmail = new TextField();
        Label labelDateNaiss = new Label ("Date de Naissance");
        final DatePicker dateNaissPicker = new DatePicker();
        Label labelOrganisation = new Label("Organisation");
        final TextField textOrganisation = new TextField();
        Label labelObservation = new Label("Observation");
        final TextField textObservation = new TextField();
        
        Label labelEvenement = new Label("Evènement");
        evenementListObservable = FXCollections.observableArrayList(evenements);
        comboBoxEvenements.setItems(evenementListObservable);
        
        Button buttonOk = new Button("Ok");
        final Label labelMessage = new Label();

        // Ajout des interfaces dans le loginScreen
        ajouterParticipant.add(labelNom, 0, 0);
        ajouterParticipant.add(textNom, 1, 0);
        ajouterParticipant.add(labelPrenom, 0, 2);
        ajouterParticipant.add(textPrenom, 1, 2);
        ajouterParticipant.add(labelEmail, 0, 3);
        ajouterParticipant.add(textEmail, 1, 3);
        ajouterParticipant.add(labelDateNaiss, 0, 4);
        ajouterParticipant.add(dateNaissPicker, 1, 4);
        ajouterParticipant.add(labelOrganisation, 0, 5);
        ajouterParticipant.add(textOrganisation, 1, 5);
        ajouterParticipant.add(labelObservation, 0, 6);
        ajouterParticipant.add(textObservation, 1, 6);
        ajouterParticipant.add(labelEvenement, 0, 7);
        ajouterParticipant.add(comboBoxEvenements, 1, 7);
        
        ajouterParticipant.add(buttonOk, 2, 8);
        ajouterParticipant.add(labelMessage, 1, 7);
        
        
        buttonOk.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                participantNom = textNom.getText();
                participantPrenom = textPrenom.getText();
                participantEmail = textEmail.getText();
                participantDateNaiss = java.sql.Date.valueOf(dateNaissPicker.getValue());
                participantOrganisation = textOrganisation.getText(); 
                participantObservation= textObservation.getText();
                
                Participant participant = new Participant(compteurParticipants, participantNom, participantPrenom, participantEmail, participantDateNaiss, participantOrganisation, participantObservation);
                compteurParticipants++;
                
                Evenement evenementParticipant = comboBoxEvenements.getValue();
                for(int i  = 0; i < evenements.size(); i++) {
                    if(evenements.get(i).getNum_even() == evenementParticipant.getNum_even()) {
                        evenements.get(i).getParticipants().add(participant);
                        i = evenements.size();
                    }
                }
                
                // Pour forcer l'update du tableau on actualise la liste evenements
                evenements.add(null);
                //evenements.remove(evenements.size() -1);
                
                evenementListObservable = FXCollections.observableArrayList(evenements);
                tableauEvenements.setItems(evenementListObservable);
                tableauEvenements.refresh();
            }
        });
    }

}