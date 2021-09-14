package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import vue2D.sprites.ISprite;

/**
* Classe Dessin
* @author INFO Professors team
*/

public class Dessin extends Canvas {
    
    public final Collection<ISprite> sprites;
    private final ILabyrinthe labyrinthe;
    public static final int UNITE = 15;
    private final GraphicsContext tampon;
    private Image solImage, ground;
   
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
        dessinFond(); 
    }
    
    /**
     * Méthode qui charge les images utilisées par le jeu.
     */
    public final void chargementImages() {
    	solImage = new Image("file:icons/pyramide.jpg");
        ground = new Image("file:icons/ground.gif");
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
        labyrinthe.forEach(s -> { tampon.drawImage(ground, s.getX()*UNITE, s.getY()*UNITE, UNITE, UNITE); });
    }
    
    /**
     * Méthode qui dessine les sprites du Labyrinthe.
     */
    public void dessinSprites() {
        sprites.forEach(sprite -> { sprite.dessiner(tampon); });
    }
    
}
