package net.swofty.hyperlandsapi.exceptions;

/**
 * This class is a custom exception that is thrown when the rate limit is exceeded
 */
public class RatelimitedException extends RuntimeException {

      public RatelimitedException(String errorMessage) {
            super(errorMessage);
      }

}