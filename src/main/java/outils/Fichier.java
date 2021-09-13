package outils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import labyrinthe.ISalle;
import labyrinthe.Salle;

/**
 * Classe Fichier
 * @author INFO Professors team
 */
public class Fichier {
    
    Scanner sc = null;
    
    /**
     * Constructeur de la classe Fichier.
     * @param nomFichier le nom du fichier à valider.
     */
    public Fichier(String nomFichier){
        try{
	    sc = new Scanner(new File(nomFichier));
	} catch(FileNotFoundException e) {  // FileNotFoundException ou Exception ?
            System.out.println(e);
        }     
    }
    
    // Retourne le prochain entier dans le fichier.
    // Retourne -1 s'il n'y en a pas.
    public int lireNombre(){
        if (sc.hasNextInt() && sc != null){
            return sc.nextInt();
        }
        return -1;
    }
    
    /**
     * Méthode qui vérifie si un fichier de Labyrinthe dont le nom est donné est valide.
     * @param nomFichier le nom du fichier testé.
     * @return true si le fichier est valide, false si l'inverse.
     */
    public boolean testValide(String nomFichier) {
        boolean fichierValide;
        Scanner scNom = new Scanner(System.in);
        System.out.println("Entrez le nom du fichier à lire. " + " " + " " + "(ex: labys/level7.txt)");
        nomFichier = scNom.nextLine();
        System.out.println("Le fichier nommé " + "'" + nomFichier + "'" + " est en cours de validation...");
        File f = new File(nomFichier);
        testCoordonneesSallesFichier(f);
        testPasDeDoublonFichier(f);
        if (testCoordonneesSallesFichier(f) == true && testPasDeDoublonFichier(f) == true) {
            fichierValide = true;
            System.out.println("Fichier " + nomFichier + " validé !");
        }
        else {
            fichierValide = false;
            System.out.println("Fichier " + nomFichier + " invalide.");
        }
        return fichierValide;
    }
    
    /**
     * Méthode qui test si des salles sont présentes en doubles dans un fichier.
     * @param f le fichier vérifié.
     * @return true s'il n'y a pas de doublon.
     */
    public static boolean testPasDeDoublonFichier(File f) {
        boolean valide = true;
        ArrayList<ISalle> sallesTest = new ArrayList<>(); // Salles à test pour doublons
        Fichier fichierTest = new Fichier(f.getPath()); 
        int valeurTestX = fichierTest.lireNombre();
        int valeurTestY = fichierTest.lireNombre();
        while (valeurTestX != -1 && valeurTestY != -1) {
            // Création et validation d'une nouvelle salle
            ISalle s = new Salle(valeurTestX, valeurTestY);
            if (!sallesTest.contains(s)) {
                sallesTest.add(s); // problème ?
            }
            else {
                valide = false;
            }
            // Salle suivante dans la boucle
            valeurTestY = fichierTest.lireNombre();
            valeurTestX = fichierTest.lireNombre();        
        }
        return valide;
    }
    
    /**
     * Méthode de test des coordonnées des salles de fichiers.
     * @param f le fichier utilisé.
     * @return true si les salles sont validées.
     */
    public static boolean testCoordonneesSallesFichier(File f) {
        boolean testSalles = false;
        boolean testLaby = false;
        boolean valide = false;
        // Initialisation du fichier et des valeurs test
        Fichier fichierTest = new Fichier(f.getPath()); 
        int largeurTest = fichierTest.lireNombre();
        int hauteurTest = fichierTest.lireNombre();
        ISalle entreeTest = new Salle(fichierTest.lireNombre(), fichierTest.lireNombre());
        ISalle sortieTest = new Salle(fichierTest.lireNombre(), fichierTest.lireNombre());
        // Vérification de la taille du Labyrinthe et de l'entrée / sortie.
        if (largeurTest > 0 && hauteurTest > 0 && entreeTest.getX() >= 0 && entreeTest.getY() >= 0 
                && entreeTest.getX() < largeurTest && entreeTest.getY() < hauteurTest && sortieTest.getX() >= 0 
                && sortieTest.getY() >= 0 && sortieTest.getX() < largeurTest && sortieTest.getY() < hauteurTest) {
            testLaby = true;
        }
        // Vérification des coordonnées des salles.
        int salleX = fichierTest.lireNombre();
        int salleY = fichierTest.lireNombre();
        while(salleX >= 0 && salleX < largeurTest && salleY >= 0 && salleY < hauteurTest) {
            salleX = fichierTest.lireNombre();
            salleY = fichierTest.lireNombre();
        }
        if (salleX == -1 && salleY == -1) {
            testSalles = true;
        }
        // Vérification des tests
        if (testSalles == true && testLaby == true) {
            valide = true;
        }
        return valide;
    }
    
}
