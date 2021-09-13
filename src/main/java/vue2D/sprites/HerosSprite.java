package vue2D.sprites;

import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import personnages.Heros;
import personnages.IPersonnage;

/**
 * Classe HerosSprite
 * @author fchabellard
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {
    
    private final Heros hero;
    
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
    
    @Override
    public ISalle getPosition() {
        return spritePerso.getPosition();
    }
    
    @Override
    public void setPosition(ISalle s) {
        spritePerso.setPosition(s);
    }
    
    /**
     * Méthode qui permet de déplacer le personnage en fonction des touches du clavier.
     * @param key la touche appuyée.
     */
    @Override
    public void handle(KeyEvent key) {
        // On récupère les coordonnées du personnage.
        /// hero ou spritePerso (?)
        int persoX = spritePerso.getPosition().getX();
        int persoY = spritePerso.getPosition().getY(); 
        switch (key.getCode()) {
            // Déplacement Haut
            case UP:
                persoY--;
                // ...
                break;
            // Déplacement bas
            case DOWN:
                persoY++;
                // ...
                break;
            // Déplacement gauche
            case LEFT:
                persoX--;
                // ...
                break;
            // Déplacement droite
            case RIGHT:
                persoX++;
                // ...
                break;
        }
        ISalle salleChoix = new Salle(persoX, persoY);
        hero.salleChoisie = salleChoix;
    }
    
}
