package labyrinthe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import outils.Fichier;
import personnages.IPersonnage;

/**
 * Classe Labyrinthe
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    protected ISalle entree, sortie;
    private int largeur, hauteur;

    @Override
    public void creerLabyrinthe(String file) {
        Fichier f = new Fichier(file);    
        // Dimensions du Labyrinthe
        largeur = f.lireNombre(); 
        hauteur = f.lireNombre();
        // Création du Labyrinthe
        entree = new Salle(f.lireNombre(), f.lireNombre());
        sortie = new Salle(f.lireNombre(), f.lireNombre());
        int boucleX = f.lireNombre();
        int boucleY = f.lireNombre();
        while (boucleX >= 0 && boucleY >= 0 && boucleX <= largeur && boucleY <= hauteur) {
            this.add(new Salle(boucleX, boucleY)); // On ajoute chaque nouvelle salle à l'ArrayList<ISalle>
            boucleX++;
            boucleY++;
        }
    }

    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        return null;
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
