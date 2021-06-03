package siviotti.clausuladeguarda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorveteTest {

    private Sorvete sorvete = new Sorvete();

    @Test
    public void testPrecoSorvete() {
        // Sorvete Comum
        assertEquals(17, sorvete.precoSorvete(false, false, 1));
        // Soverte com somente casquinha ou somente coberturas = 18
        assertEquals(18, sorvete.precoSorvete(false, false, 3));
        assertEquals(18, sorvete.precoSorvete(false, true, 1));
        // Sorvete comum com casquinha e coberturas
        assertEquals(19, sorvete.precoSorvete(false, true, 3));
        // Sorvete Premium
        assertEquals(22, sorvete.precoSorvete(true, false, 1));
        assertEquals(23, sorvete.precoSorvete(true, false, 3));
        // Premium casquinha
        assertEquals(23, sorvete.precoSorvete(true, true, 1));
        // Premium Completo
        assertEquals(24, sorvete.precoSorvete(true, true, 3));
    }

    @Test
    public void testPrecoSorvete1() {
        // Sorvete Comum
        assertEquals(17, sorvete.precoSorvete1(false, false, 1));
        assertEquals(17, sorvete.precoSorvete1(false, false, 3));
        assertEquals(17, sorvete.precoSorvete1(false, true, 1));
        assertEquals(17, sorvete.precoSorvete1(false, true, 3));
        // Sorvete Premium
        assertEquals(22, sorvete.precoSorvete1(true, false, 1));
        assertEquals(22, sorvete.precoSorvete1(true, false, 3));
        // Premium casquinha
        assertEquals(23, sorvete.precoSorvete1(true, true, 1));
        // Premium Completo
        assertEquals(24, sorvete.precoSorvete1(true, true, 3));
    }

    @Test
    public void testPrecoSorvete2() {
        // Sorvete Comum
        assertEquals(17, sorvete.precoSorvete2(false, false, 1));
        assertEquals(17, sorvete.precoSorvete2(false, false, 3));
        assertEquals(17, sorvete.precoSorvete2(false, true, 1));
        assertEquals(17, sorvete.precoSorvete2(false, true, 3));
        // Sorvete Premium
        assertEquals(22, sorvete.precoSorvete2(true, false, 1));
        assertEquals(22, sorvete.precoSorvete2(true, false, 3));
        // Premium casquinha
        assertEquals(23, sorvete.precoSorvete2(true, true, 1));
        // Premium Completo
        assertEquals(24, sorvete.precoSorvete2(true, true, 3));
    }

    @Test
    public void testPrecoSorvete3() {
        // Pré-condições
        assertThrows(IllegalArgumentException.class, () -> // PC1: casquinha sem premium
            { sorvete.precoSorvete3(false, true, 1); });
        assertThrows(IllegalArgumentException.class, () -> // PC2: cobertura sem casquinha
            { sorvete.precoSorvete3(true, false, 3); });
        assertThrows(IllegalArgumentException.class, () -> // PC3: muitas coberturas
            { sorvete.precoSorvete3(true, true, 5); });
        // Sorvete Comum
        assertEquals(17, sorvete.precoSorvete3(false, false, 1));
        // Sorvete Premium
        assertEquals(22, sorvete.precoSorvete3(true, false, 1));
        // Premium casquinha
        assertEquals(23, sorvete.precoSorvete3(true, true, 1));
        // Premium Completo
        assertEquals(24, sorvete.precoSorvete3(true, true, 3));
    }


    @Test    public void testPrecoSorvete4Precondicoes() {
        assertThrows(IllegalArgumentException.class, () -> // PC1: casquinha sem premium
        { sorvete.precoSorvete3(false, true, 1); });
        assertThrows(IllegalArgumentException.class, () -> // PC2: cobertura sem casquinha
        { sorvete.precoSorvete3(true, false, 3); });
        assertThrows(IllegalArgumentException.class, () -> // PC3: muitas coberturas
        { sorvete.precoSorvete3(true, true, 5); });
    }

    @Test    public void testPrecoSorvete4() {
        // Sorvete Comum
        assertEquals(17, sorvete.precoSorvete4(false, false, 1));
        // Sorvete Premium
        assertEquals(22, sorvete.precoSorvete4(true, false, 1));
        // Premium casquinha
        assertEquals(23, sorvete.precoSorvete4(true, true, 1));
        // Premium Completo
        assertEquals(24, sorvete.precoSorvete4(true, true, 3));
    }

}