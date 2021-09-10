package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import vue2D.javafx.Vue;

/**
 * Classe MainJavaFX
 * @author INFO Professors team
 */
public class MainJavaFX extends Application {
    private Core core;

    @Override
    public void start(Stage stage) {
        core = new Core();
        // Initialisation du labyrinthe
        core.initLabyrinthe(); 
        // Création de la vue
        Vue vue = new vue2D.javafx.Vue(core.labyrinthe); 
        // Création des sprites dans la vue  
        core.initSprites(vue); 
        stage.setScene(vue.scene);
        stage.show();
        // Rafraîchissement de la vue
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                vue.dessiner();
            }
        };
        timer.start();
        Task<Void> task = new Task<Void>() {
            @Override public Void call() {
                 core.jeu(vue); // go !
                 return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    public static void main(String[] args) {
        launch();
    }

}