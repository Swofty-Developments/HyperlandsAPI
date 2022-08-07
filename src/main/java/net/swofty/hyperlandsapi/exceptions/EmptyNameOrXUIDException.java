package net.swofty.hyperlandsapi.exceptions;

/**
 * This class is a custom exception that is thrown when a player's name or XUID is empty.
 */
public class EmptyNameOrXUIDException extends RuntimeException {

      public EmptyNameOrXUIDException(String errorMessage) { super(errorMessage); }

}