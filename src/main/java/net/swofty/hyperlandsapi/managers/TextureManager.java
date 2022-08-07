package net.swofty.hyperlandsapi.managers;

import lombok.SneakyThrows;
import net.swofty.hyperlandsapi.Connection;
import net.swofty.hyperlandsapi.Endpoints;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TextureManager {

      // Creating a connection to the server and an executor service.
      private Connection connection;
      private ExecutorService executor;

      // A constructor that takes in a connection and an executor service.
      public TextureManager(Connection connection, ExecutorService executor) {
            this.connection = connection;
            this.executor = executor;
      }

      /**
       * It returns a Future object that will contain the skin of the player with the given username
       * Note that this by default will pass through a steve skin if the username is invalid.
       *
       * @param playerUsername The username of the player you want to get the skin of.
       * @return A Future object that will contain the skin of the player.
       */
      @SneakyThrows
      public Future<BufferedImage> getSkin(String playerUsername) {
            return executor.submit(() -> ImageIO.read(new URL(Connection.baseURL + Endpoints.SKIN.getUrlPath() + playerUsername)));
      }

      /**
       * Get the head of a player asynchronously.
       * Note that this by default will pass through a steve skin if the username is invalid.
       *
       * @param playerUsername The username of the player you want to get the head of.
       * @return A Future object that will contain the image of the player's head.
       */
      @SneakyThrows
      public Future<BufferedImage> getHead(String playerUsername) {
            return executor.submit(() -> ImageIO.read(new URL(Connection.baseURL  + Endpoints.HEAD.getUrlPath() + playerUsername)));
      }
}
