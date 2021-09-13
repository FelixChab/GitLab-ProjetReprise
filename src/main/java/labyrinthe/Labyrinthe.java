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
        ArrayList<ISalle> salles = new ArrayList<>();
        // On vérifie que la salle du haut est accessible.
        ISalle salleHaut = new Salle(bob.getPosition().getX(), bob.getPosition().getY()-1);
        if (bob.getPosition().estAdjacente(salleHaut) && this.contains(salleHaut)) {
            salles.add(salleHaut);
        }
        // On vérifie que la salle du bas est accessible.
        ISalle salleBas = new Salle(bob.getPosition().getX(), bob.getPosition().getY()+1);
        if (bob.getPosition().estAdjacente(salleBas) && this.contains(salleBas)) {
            salles.add(salleBas);
        }
        // On vérifie que la salle de gauche est accessible.
        ISalle salleGauche = new Salle(bob.getPosition().getX()-1, bob.getPosition().getY());
        if (bob.getPosition().estAdjacente(salleGauche) && this.contains(salleGauche)) {
            salles.add(salleGauche);
        }
        // On vérifie que la salle de droite est accessible.
        ISalle salleDroite = new Salle(bob.getPosition().getX()+1, bob.getPosition().getY());
        if (bob.getPosition().estAdjacente(salleDroite) && this.contains(salleDroite)) {
            salles.add(salleDroite);
        }
        return salles;
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
