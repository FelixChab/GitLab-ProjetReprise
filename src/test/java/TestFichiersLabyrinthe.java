import static org.junit.Assert.*;
import java.io.File;
import labyrinthe.ISalle;
import labyrinthe.Salle;
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
            assertTrue(testCoordonneesSallesFichier(f));
            if (f.getName().contains("Invalide")) {
                assertFalse(testCoordonneesSallesFichier(f));
            }
        }
    }
    
    /**
     * Méthode de test des coordonnées des salles de fichiers.
     * @param f le fichier utilisé.
     * @return true si les salles sont validées.
     */
    public boolean testCoordonneesSallesFichier(File f) {
        boolean testSalles = false;
        boolean testLaby = false;
        boolean valide = false;
        // Initialisation du fichier et des valeurs test
        Fichier fichierTest = new Fichier(f.getName()); 
        int largeurTest = fichierTest.lireNombre();
        int hauteurTest = fichierTest.lireNombre();
        ISalle entreeTest = new Salle(fichierTest.lireNombre(), fichierTest.lireNombre());
        ISalle sortieTest = new Salle(fichierTest.lireNombre(), fichierTest.lireNombre());
        // Vérification de la taille du Labyrinthe et de l'entrée / sortie.
        if (largeurTest > 0 && hauteurTest > 0 && entreeTest.getX() >= 0 && entreeTest.getY() >= 0 
                && entreeTest.getX() < largeurTest && entreeTest.getY() < hauteurTest && sortieTest.getX() >= 0 
                && sortieTest.getY() >= 0 && sortieTest.getX() < largeurTest && sortieTest.getY() < hauteurTest) {
            testLaby = true;
        }
        // Vérification des coordonnées des salles.
        int salleX = fichierTest.lireNombre();
        int salleY = fichierTest.lireNombre();
        while(salleX >= 0 && salleX < largeurTest && salleY >= 0 && salleY < hauteurTest) {
            salleX = fichierTest.lireNombre();
            salleY = fichierTest.lireNombre();
        }
        if (salleX == -1 && salleY == -1) {
            testSalles = true;
        }
        // Vérification des tests
        if (testSalles == true && testLaby == true) {
            valide = true;
        }
        return valide;
    }

    @Test
    public void testPasDeDoublon() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

    @Test
    public void testChemin() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }
    
}
