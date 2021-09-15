package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import vue2D.sprites.ISprite;
import vue2D.sprites.HerosSprite;

/**
* Classe Dessin
* @author INFO Professors team
*/

public class Dessin extends Canvas {
    
    public final Collection<ISprite> sprites;
    private final ILabyrinthe labyrinthe;
    public static final int UNITE = 15;
    private final GraphicsContext tampon;
    private Image solImage, ground, exit;
   
    /**
     * Constructeur de la classe
     * @param labyrinthe le labyrinthe
     * @param sprites les sprites
     */
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites) {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        setWidth(labyrinthe.getLargeur()*UNITE);
        setHeight(labyrinthe.getHauteur()*UNITE);
        tampon = this.getGraphicsContext2D();
        chargementImages(); 
    }
    
    /**
     * Méthode qui charge les images utilisées par le jeu.
     */
    public final void chargementImages() {
    	solImage = new Image("file:icons/black.png");
        ground = new Image("file:icons/ground.gif");
        exit = new Image("file:icons/sortie.gif");
    }
    
    /**
     * Méthode qui dessine l'image de fond du Labyrinthe.
     */
    public final void dessinFond() {
        tampon.drawImage(solImage, 0, 0, UNITE*labyrinthe.getLargeur(), UNITE*labyrinthe.getHauteur());
    }
    
    /**
     * Méthode qui dessine les salles du Labyrinthe.
     */
    public void dessinSalles() {
        // Implémenter dans dessinEclairageSalles() !
    }
    
    /**
     * Méthode qui dessine les sprites du Labyrinthe.
     */
    public void dessinSprites() {
        sprites.forEach(sprite -> { sprite.dessiner(tampon); });
    }
    
    /**
     * Méthode qui dessine la sortie du Labyrinthe.
     */
    public void dessinSortie() {
        tampon.drawImage(exit, labyrinthe.getSortie().getX()*UNITE, labyrinthe.getSortie().getY()*UNITE, UNITE, UNITE);
    }
    
    /**
     * Méthode pour l'éclairage autour du Héros.
     * @param hero le Héros.
     */
    public void dessinEclairageSalles(ISprite hero) {
        // On parcours le Labyrinthe pour "masquer" les salles.
        for (int i = 0; i < labyrinthe.size(); i++) {
            tampon.setGlobalAlpha(0);
        }
        for (ISalle salle : labyrinthe) {
            int distance = distanceHeros(salle, hero);
            // Les salles à affichier.
            if (distance <= 6 && distance >= -6) {
                distance = -distance+5;
                tampon.setGlobalAlpha(0.6*distance);
                // dessinSalles()
                tampon.drawImage(ground, salle.getX()*UNITE, salle.getY()*UNITE, UNITE, UNITE);
            }
        }
        tampon.setGlobalAlpha(1);
    }
    
    /**
     * Méthode qui renvoi la distance entre le héros et une salle donnée.
     * @param salle la salle dont on veut savoir la distance.
     * @param hero le personnage.
     * @return le distance (en entier) entre la salle et le héros.
     */
    public int distanceHeros(ISalle salle, ISprite hero) {
        int x = hero.getPosition().getX();
        int y = hero.getPosition().getY();
        int j = (hero.getPosition().getX() - salle.getX())*(hero.getPosition().getX() - salle.getX());
        j += (hero.getPosition().getY() - salle.getY())*(hero.getPosition().getY() - salle.getY());
        j = (int) Math.sqrt(j);
        return j;
    }
    
}
