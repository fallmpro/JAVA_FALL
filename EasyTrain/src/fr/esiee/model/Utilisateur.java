package fr.esiee.model;
import java.time.LocalDate;

public class Utilisateur {
    private int id;
    private String prenom;
    private String nom;
    private String login;
    private String mdp;
    private LocalDate dateEmbauche;
    private Role role;

public Utilisateur(int id, String prenom, String nom, String login, String mdp, LocalDate dateEmbauche){
    this.id = id;
    this.login = login;
    this.mdp = mdp;
    this.nom = nom;
    this.prenom = prenom;
    this.dateEmbauche = dateEmbauche;
    this.role = role;
    }

    public int getId() {
    return id;
    }

    public void setId(int id) {
    this.id = id;
    }

    public String getPrenom() {
    return prenom;
    }

    public void setPrenom(String prenom) {
    this.prenom = prenom;
    }

    public String getNom() {
    return nom;
    }

    public void setNom(String nom) {
    this.nom = nom;
    }

    public String getLogin() {
    return login;
    }

    public void setLogin(String login) {
    this.login = login;
    }
    public String getMdp() {
    return mdp;
    }

    public void setMdp(String mdp) {
    this.mdp = mdp;
    }

    public LocalDate getDateEmbauche() {
    return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
    this.dateEmbauche = dateEmbauche;
    }

    public Role getRole() {
    return role;
    }

    public void setRole(Role role) {
    this.role = role;
    }

}




