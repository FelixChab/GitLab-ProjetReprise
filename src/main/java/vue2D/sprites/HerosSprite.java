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
    // Boolean pour mouvement plus fluide.
    public boolean enMouvement = false;
    // Booleans pour direction de déplacement.
    public boolean haut, bas, gauche, droite = false;
    
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
        g.drawImage(imageHeroD, spriteX*Dessin.UNITE, spriteY*Dessin.UNITE, Dessin.UNITE, Dessin.UNITE);
        if (haut == true) {
            g.drawImage(imageHeroU, spriteX*Dessin.UNITE, spriteY*Dessin.UNITE, Dessin.UNITE, Dessin.UNITE);
        }
        if (bas == true) {
            g.drawImage(imageHeroD, spriteX*Dessin.UNITE, spriteY*Dessin.UNITE, Dessin.UNITE, Dessin.UNITE);
        }
        if (gauche == true) {
            g.drawImage(imageHeroL, spriteX*Dessin.UNITE, spriteY*Dessin.UNITE, Dessin.UNITE, Dessin.UNITE);
        }
        if (droite == true) {
            g.drawImage(imageHeroR, spriteX*Dessin.UNITE, spriteY*Dessin.UNITE, Dessin.UNITE, Dessin.UNITE);
        }
    }
    
    /**
     * Méthode qui permet de déplacer le personnage en fonction des touches du clavier.
     * @param key la touche appuyée.
     */
    @Override
    public void handle(KeyEvent key) {
        /// IMPLEMENTATION enMouvement (Ex 19) à faire
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
                enMouvement = true;
                haut = true;
                break;
            // Déplacement bas
            case DOWN:
                persoY++;
                enMouvement = true;
                bas = true;
                break;
            // Déplacement gauche
            case LEFT:
                persoX--;
                enMouvement = true;
                gauche = true;
                break;
            // Déplacement droite
            case RIGHT:
                persoX++;
                enMouvement = true;
                droite = true;
                break;
        }
        ISalle sallePerso = new Salle(persoX, persoY);
        hero.salleChoisie = sallePerso;
    }
    
}
