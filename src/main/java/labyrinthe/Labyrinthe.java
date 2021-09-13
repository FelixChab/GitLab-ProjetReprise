package labyrinthe;

import Exceptions.ExceptionInvalidFile;
import java.util.ArrayList;
import java.util.Collection;
import outils.Fichier;
import personnages.IPersonnage;

/**
 * Classe Labyrinthe
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    protected ISalle entree, sortie;
    private int largeur, hauteur;
    
    /**
     * Méthode qui permet la création du Labyrinthe en lisant le fichier texte donné.
     * @param file le fichier texte donné.
     * @throws Exceptions.ExceptionInvalidFile
     */
    @Override
    public void creerLabyrinthe(String file) throws ExceptionInvalidFile {
        Fichier f = new Fichier(file);
        if (f.testValide(file) == false) {
            throw new ExceptionInvalidFile("Fichier invalide.");
        }
        // Dimensions du Labyrinthe
        largeur = f.lireNombre(); 
        hauteur = f.lireNombre();
        // Création du Labyrinthe
        entree = new Salle(f.lireNombre(), f.lireNombre());
        sortie = new Salle(f.lireNombre(), f.lireNombre());
        this.add(entree);
        this.add(sortie);
        int boucleX = f.lireNombre();
        int boucleY = f.lireNombre();
        while (boucleX >= 0 && boucleY >= 0 && boucleX <= largeur && boucleY <= hauteur) {
            // On ajoute chaque nouvelle salle à l'ArrayList<ISalle>
            this.add(new Salle(boucleX, boucleY)); 
            boucleX = f.lireNombre();
            boucleY = f.lireNombre();
        }
    }
    
    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        ArrayList<ISalle> sallesDispo = new ArrayList<>();
        int x = bob.getPosition().getX();
        int y = bob.getPosition().getY();
        ISalle sallePerso = new Salle(x, y);
        // On Parcourt les salles du Labyrinthe
        for (ISalle salles : this) {
            if (salles.estAdjacente(sallePerso)) {
                sallesDispo.add(salles);
            }
        }
        return sallesDispo;
    }

    @Override
    public ISalle getEntree() {
        return entree;
    }

    @Override
    public ISalle getSortie() {
        return sortie;
    }

    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    @Override
    public int getLargeur() {
        return largeur;
    }

    @Override
    public int getHauteur() {
        return hauteur;
    }

}
