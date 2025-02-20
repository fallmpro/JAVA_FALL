package fr.esiee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeviseTest {

    private Devise devise1;
    private Devise devise2;
    private Devise devise3;

    @BeforeEach
    void setUp() {
        System.out.println("Je suis avant exécution d'une méthode de test");
        devise1 = new Devise(12, "CHF");
        devise2 = new Devise(14, "CHF");
        devise3 = new Devise(10, "EUR");
    }

    @Test
    void testAddTwoDevises() throws MonnaieDifferenteException {
        Devise expected = new Devise(26, "CHF");
        Devise result = devise1.add(devise2);

        assertEquals(expected.getQuantite(), result.getQuantite(), "La somme des quantités doit être 26");
        assertEquals(expected.getMonnaie(), result.getMonnaie(), "La monnaie doit rester 'CHF'");
        assertEquals(expected, result, "Les objets Devise doivent être identiques");
    }

    @Test
    void testAddWithDifferentCurrency() {
        Exception exception = assertThrows(MonnaieDifferenteException.class, () -> {
            devise1.add(devise3);
        });

        String expectedMessage = "Monnaie différente : CHF != EUR";
        assertTrue(exception.toString().contains(expectedMessage), "Le message d'erreur doit mentionner les monnaies différentes");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Je suis APRES exécution d'une méthode de test");
    }
}
