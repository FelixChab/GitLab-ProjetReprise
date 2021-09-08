package Exceptions;

import java.io.IOException;

/**
 * Classe ExceptionInvalidFile
 * Renvoie une exception en cas de fichier invalide
 * @author fchabellard
 */
public class ExceptionInvalidFile extends IOException {
    
    public ExceptionInvalidFile(String message) {
        super(message);
    }
    
}
