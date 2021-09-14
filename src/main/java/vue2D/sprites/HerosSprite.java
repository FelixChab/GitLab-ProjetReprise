package vue2D.sprites;

import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import personnages.Heros;
import personnages.IPersonnage;
import vue2D.javafx.Dessin;

/**
 * Classe HerosSprite
 * @author fchabellard
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {
    
    private final Heros hero;
    // Booleans pour direction de déplacement.
    public static boolean haut, bas, gauche, droite = false;
    
    /**
     * Constructeur de la classe HerosSprite qui hérite d'ASprite.
     * @param perso le personnage dont on affiche le sprite.
     */
    public HerosSprite(IPersonnage perso) {
        super(perso);
        this.hero = ((Heros)perso);
        this.imagePerso = new Image("file:icons/link/LinkRunShieldD2.gif");
    }
    
    /**
     * Méthode pour dessiner le Héro.
     * @param g objet JavaFX
     */
    @Override
    public void dessiner(GraphicsContext g) {
        super.dessiner(g);
        // On charge le sprite correspondant à chaque directions.
        if (haut == true) {
            imagePerso = new Image("file:icons/link/LinkRunU1.gif");
        }
        if (bas == true) {
            imagePerso = new Image("file:icons/link/LinkRunShieldD1.gif");
        }
        if (gauche == true) {
            imagePerso = new Image("file:icons/link/LinkRunShieldL1.gif");
        }
        if (droite == true) {
            imagePerso = new Image("file:icons/link/LinkRunR1.gif");
        }
    }
    
    /**
     * Méthode qui permet de déplacer le personnage en fonction des touches du clavier.
     * @param key la touche appuyée.
     */
    @Override
    public void handle(KeyEvent key) {
        // On récupère les coordonnées du personnage.
        int persoX = hero.getPosition().getX();
        int persoY = hero.getPosition().getY();
        // On réinitialise les directions pour l'animation.
        haut = false;
        bas = false;
        droite = false;
        gauche = false;
        switch (key.getCode()) {
            // Déplacement Haut
            case UP:
                persoY--;
                haut = true;
                break;
            // Déplacement bas
            case DOWN:
                persoY++;
                bas = true;
                break;
            // Déplacement gauche
            case LEFT:
                persoX--;
                gauche = true;
                break;
            // Déplacement droite
            case RIGHT:
                persoX++;
                droite = true;
                break;
        }
        ISalle sallePerso = new Salle(persoX, persoY);
        hero.salleChoisie = sallePerso;
    }
    
}
