package fr.esiee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviseTest {

    private Devise devise1;
    private Devise devise2;

    @BeforeEach
    void setUp() {
        devise1 = new Devise(12, "CHF");
        devise2 = new Devise(14, "CHF");
    }

    @Test
    void testAddTwoDevises() {
        Devise expected = new Devise(26, "CHF");
        Devise result = devise1.add(devise2);

        assertEquals(expected.getQuantite(), result.getQuantite(), "La somme des quantités doit être 26");
        assertEquals(expected.getMonnaie(), result.getMonnaie(), "La monnaie doit rester 'CHF'");
        assertEquals(expected, result, "Les objets Devise doivent être identiques");
    }
}
