package fr.esiee;

public class Main {
    public static void main(String[] args) {
        Devise montant = new Devise(100, "euro");
        System.out.println("Montant: " + montant.getQuantite() + " " + montant.getMonnaie());
    }
}

