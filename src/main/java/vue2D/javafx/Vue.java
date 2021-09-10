package vue2D.javafx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import labyrinthe.ILabyrinthe;
import vue2D.IVue;
import vue2D.AVue;
import vue2D.sprites.ISprite;

/**
* Classe Vue
* @author INFO Professors team
*/
public class Vue extends AVue implements IVue {
    
    public Dessin dessin;
    public ILabyrinthe labyrinthe;
    public Scene scene;
    
    /**
     * Constructeur de la classe Vue.
     * @param labyrinthe le labyrinthe utilisé.
     */
    public Vue(ILabyrinthe labyrinthe) {
        this.labyrinthe=labyrinthe;
        dessin = new Dessin(labyrinthe, this);
        Group root = new Group();
        this.scene = new Scene(root);
        root.getChildren().add(dessin);
    }
    
    @Override
    public void dessiner() {
     	// Recopie du fond (image): murs + salles
        dessin.dessinFond();
        dessin.dessinSalles();
        // Chargement des sprites
        dessin.dessinSprites();
    }	
    
    @Override
    public boolean add(ISprite sprite) {
        super.add(sprite);
        // Si le sprite est contrôlé par le clavier.
        if (sprite instanceof EventHandler) {
            System.out.println("registering keylistener");
            // Association de l'écouteur sur le clavier avec le composant graphique principal.
            this.scene.setOnKeyPressed((EventHandler)sprite);
        }
        return true;
    }

}
