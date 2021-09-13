package vue2D.sprites;

import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
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
    public boolean enMouvement = false;
    
    /**
     * Constructeur de la classe HerosSprite qui hérite d'ASprite.
     * @param perso le personnage dont on affiche le sprite.
     */
    public HerosSprite(IPersonnage perso) {
        super(perso);
        this.hero = ((Heros)perso);
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return spritePerso.faitSonChoix(sallesAccessibles);
    }
    
    /**
     * Méthode pour dessiner le Héro.
     * @param g objet JavaFX
     */
    @Override
    public void dessiner(GraphicsContext g) {
        g.drawImage(imageHero, spriteX*Dessin.unite, spriteY*Dessin.unite, Dessin.unite, Dessin.unite);
    }
    
    /**
     * Méthode qui permet de déplacer le personnage en fonction des touches du clavier.
     * @param key la touche appuyée.
     */
    @Override
    public void handle(KeyEvent key) {
        if (enMouvement) {
            return; // On quitte la condition
        }
        // On récupère les coordonnées du personnage.
        int persoX = hero.getPosition().getX();
        int persoY = hero.getPosition().getY();
        switch (key.getCode()) {
            // Déplacement Haut
            case UP:
                persoY--;
                enMouvement = true;
                break;
            // Déplacement bas
            case DOWN:
                persoY++;
                enMouvement = true;
                break;
            // Déplacement gauche
            case LEFT:
                persoX--;
                enMouvement = true;
                break;
            // Déplacement droite
            case RIGHT:
                persoX++;
                enMouvement = true;
                break;
        }
        ISalle sallePerso = new Salle(persoX, persoY);
        hero.salleChoisie = sallePerso;
    }
    
}
