package net.swofty.hyperlandsapi;

import net.swofty.hyperlandsapi.managers.PlayerManager;
import net.swofty.hyperlandsapi.managers.ServerManager;
import net.swofty.hyperlandsapi.managers.TextureManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The class that handles all of the outgoing connections to the API
 * Note that even though all calls are async, they are dependent on the Connection object
 * So if you call two different API method with the same Connection object they will wait for
 * one another
 */
public class Connection {

      // The base URL of the API.
      public static String baseURL = "https://api.hyperlandsmc.net";

      // It's a variable that stores the time the connection was last used.
      private long usedTimestamp;

      // It's creating a new thread that will be used to execute the code.
      private final ExecutorService executor = Executors.newSingleThreadExecutor();

      Connection() {
            usedTimestamp = 0;
      }

      /**
       * This function returns a new instance of the TextureManager class, which is a class that manages the accessing of
       * textures
       *
       * @return A new instance of TextureManager.
       */
      public TextureManager getTextureManager() {
            return new TextureManager(this, executor);
      }

      /**
       * This function returns a new instance of the ServerManager class, which is a class that manages server functions
       * such as player counts
       *
       * @return A new instance of ServerManager.
       */
      public ServerManager getServerManager() {
            return new ServerManager(this, executor);
      }


      /**
       * This function returns a new instance of the PlayerManager class, which is a class that manages the accessing of
       * player statistics
       *
       * @return A new instance of PlayerManager.
       */
      public PlayerManager getPlayerManager() {
            return new PlayerManager(this, executor);
      }

      /**
       * This function returns the timestamp of the last time the connection was used
       *
       * @return The usedTimestamp variable is being returned.
       */
      public Long getUsedTimestamp() {
            return usedTimestamp;
      }

      private void updateTimestamp() {
            usedTimestamp = System.currentTimeMillis();
      }

}
