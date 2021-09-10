package application;

import java.io.IOException;
import java.util.Collection;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import vue2D.IVue;
import vue2D.sprites.HerosSprite;
import vue2D.sprites.ISprite;

/**
 * Classe Core
 * @author INFO Professors team
 */
public class Core {
    ISprite heros;
    ILabyrinthe labyrinthe;

    protected void initLabyrinthe() {
        // Création du labyrinthe
        labyrinthe = new labyrinthe.Labyrinthe();
        chargementLaby("labys/level3.txt");
    }

    protected void initSprites(IVue vue) {
        // Création du heros 
        System.out.println("Entree X: " + labyrinthe.getEntree().getX() + " | " + "Entree Y: " + labyrinthe.getEntree().getY());
        IPersonnage h = new personnages.Heros(labyrinthe.getEntree().getX(), labyrinthe.getEntree().getY());
        this.heros = new HerosSprite(h);
        // problème coordonnées héros
        // System.out.println("heroX: " + heros.getPosition().getX() + " | " + "heroY: " + heros.getPosition().getY());
        vue.add(this.heros);
    }

    protected void jeu(IVue vue) {
        // Boucle principale
        ISalle destination = null;
        while (!labyrinthe.getSortie().equals(heros.getPosition())) {
            // Choix et déplacement
            for (IPersonnage p : vue) {
                Collection<ISalle> sallesAccessibles = labyrinthe.sallesAccessibles(p);
                // On demande au personnage de faire son choix de salle
                destination = p.faitSonChoix(sallesAccessibles); 
                p.setPosition(destination); // Déplacement
            }
            // Détection des collisions
            boolean collision = false;
            ISprite monstre = null;
            for (ISprite p : vue) {
                if (p != heros) {
                    if (p.getPosition() == heros.getPosition()) {
                        System.out.println("Collision !!");
                        collision = true;
                        monstre = p;
                    }
                }
            }
            if (collision) {
                vue.remove(monstre);
                vue.remove(heros);
                System.out.println("Perdu !");
                System.out.println("Plus que " + vue.size() + " personnages ...");
            }
            temporisation(50);
        }
        System.out.println("Gagné!");
    }

    private void chargementLaby(String fic) {
        // try - catch en cas de fichier inexistant (?)
        try {
            labyrinthe.creerLabyrinthe(fic);
        } 
        catch (IOException ex) {
            try {
                labyrinthe.creerLabyrinthe("labys/level7.txt");
            } 
            catch (IOException ei) {   
                System.out.println("Fichier de secours invalide, extinction système...");
                System.exit(1);
            }
        }
    }

    protected void temporisation(int nb) {
        try {
            Thread.sleep(nb); // Pause de nb millisecondes
        } catch (InterruptedException ie) { };
    }
    
}
