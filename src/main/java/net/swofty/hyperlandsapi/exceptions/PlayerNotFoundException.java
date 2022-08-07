package net.swofty.hyperlandsapi.exceptions;

/**
 * The PlayerNotFoundException class extends the RuntimeException class and is used to throw an exception when a player is
 * not found
 */
public class PlayerNotFoundException extends RuntimeException  {

      public PlayerNotFoundException(String errorMessage) { super(errorMessage); }

}