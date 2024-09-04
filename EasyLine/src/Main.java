//Fall Mouhamad
//04/09/2024
//TP Exploratoire

public class Main {

    public static void main(String[] args) {
        Voyage dakar = new Voyage();
        dakar.setDestination("Paname");
        dakar.setPrix(2000);
        dakar.setDuree(24);
        System.out.println("La destination est " + dakar.getDestination());

        System.out.println("La prix est " + dakar.getPrix() + "€");

        System.out.println("La Duree est " + dakar.getDuree() + "H");
    }
}