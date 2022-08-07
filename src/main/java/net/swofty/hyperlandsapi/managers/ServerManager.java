package net.swofty.hyperlandsapi.managers;

import lombok.SneakyThrows;
import net.swofty.hyperlandsapi.Connection;
import net.swofty.hyperlandsapi.Endpoints;
import net.swofty.hyperlandsapi.datatypes.PlayerCounts;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ServerManager {

      // Creating a connection to the server and an executor service.
      private Connection connection;
      private ExecutorService executor;

      // A constructor that takes in a connection and an executor service.
      public ServerManager(Connection connection, ExecutorService executor) {
            this.connection = connection;
            this.executor = executor;
      }

      /**
       * Get the player count of the server, and return it asynchronously.
       *
       * The `@SneakyThrows` annotation is used to tell the compiler that we're going to throw an exception, but we're
       * going to handle it ourselves
       *
       * @return A Future object that will return a PlayerCounts object.
       */
      @SneakyThrows
      public Future<PlayerCounts> getPlayerCount() {
            return executor.submit(() -> {
                  JSONObject json = new JSONObject();
                  try {
                        URL url = new URL(Connection.baseURL + Endpoints.PLAYER_COUNT.getUrlPath());
                        InputStream is = url.openStream();
                        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                        String jsonText = readAll(rd);
                        json = new JSONObject(jsonText);
                  } catch (Exception e) {}

                  return new PlayerCounts(json);
            });
      }

      private static String readAll(Reader rd) throws IOException {
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                  sb.append((char) cp);
            }
            return sb.toString();
      }
}
