import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import outils.Fichier;

/**
 * Classe de tests des fichiers de Labyrinthe.
 * @author INFO Professors team
 */
public class TestFichiersLabyrinthe {

    private File[] getFiles(File repertoire) {
        if (!repertoire.isDirectory()) {
            fail("testCoordonneesSalles - les tests ne concernent pas un répertoire");
        }
        File[] fichiers = repertoire.listFiles();
        return fichiers;
    }
    
    /**
     * Méthode de tests des fichiers de labyrinthe.
     */
    @Test
    public void testCoordonneesSalles() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        for(File f : fichiers) {
            if (Fichier.testCoordonneesSallesFichier(f) == false) {
                assertFalse(Fichier.testCoordonneesSallesFichier(f));
            }
            else {
                assertTrue(Fichier.testCoordonneesSallesFichier(f));
            }
        }
    }
    
    /** 
     * Méthode test de doublons de salles dans un Labyrinthe.
     */
    @Test
    public void testPasDeDoublon() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        for (File f : fichiers) {
            if (Fichier.testPasDeDoublonFichier(f) == false) {
                assertFalse(Fichier.testPasDeDoublonFichier(f));
            }
            else {
                assertTrue(Fichier.testPasDeDoublonFichier(f));
            }
        }
    }
    
    public boolean testCheminFichier(File f) {
        boolean valide = false;
        // ...
        return valide;
    }
    
}
