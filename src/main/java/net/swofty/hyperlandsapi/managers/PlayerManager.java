package net.swofty.hyperlandsapi.managers;

import lombok.SneakyThrows;
import net.swofty.hyperlandsapi.Connection;
import net.swofty.hyperlandsapi.Endpoints;
import net.swofty.hyperlandsapi.XUID;
import net.swofty.hyperlandsapi.datatypes.PlayerStatistics;
import net.swofty.hyperlandsapi.exceptions.EmptyNameOrXUIDException;
import net.swofty.hyperlandsapi.exceptions.PlayerNotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class PlayerManager {

      // Creating a connection to the server and an executor service.
      private Connection connection;
      private ExecutorService executor;

      // A constructor that takes in a connection and an executor service.
      public PlayerManager(Connection connection, ExecutorService executor) {
            this.connection = connection;
            this.executor = executor;
      }

      /**
       * It takes a player's username, and returns a Future object that will contain the player's statistics
       *
       * @param playerUsername The username of the player you want to get the statistics of.
       * @return A Future object that contains a PlayerStatistics object.
       * @throws PlayerNotFoundException if the player ign passed through is not able to be located
       */
      @SneakyThrows
      public Future<PlayerStatistics> getStatistics(String playerUsername) {
            return executor.submit(() -> {
                  JSONObject json = new JSONObject();
                  try {
                        URL url = new URL(Connection.baseURL + Endpoints.STATS.getUrlPath() + playerUsername);
                        InputStream is = url.openStream();
                        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                        String jsonText = readAll(rd);
                        json = new JSONObject(jsonText);
                  } catch (Exception e) {}

                  if (json.has("error") && json.getString("error").contains("Player not found"))
                        throw new PlayerNotFoundException("Unable to locate a player with the IGN '" + playerUsername + "'");

                  return new PlayerStatistics(json);
            });
      }

      /**
       * It takes a player's username, and returns a Future object that will contain a JSONObject of the player's
       * statistics
       *
       * @param playerUsername The username of the player you want to get the statistics of.
       * @return A Future object that contains a JSONObject
       * @throws PlayerNotFoundException if the player ign passed through is not able to be located
       */
      @SneakyThrows
      public Future<JSONObject> getStatisticsAsJson(String playerUsername) {
            return executor.submit(() -> {
                  JSONObject json = new JSONObject();
                  try {
                        URL url = new URL(Connection.baseURL + Endpoints.STATS.getUrlPath() + playerUsername);
                        InputStream is = url.openStream();
                        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                        String jsonText = readAll(rd);
                        json = new JSONObject(jsonText);
                  } catch (Exception e) {}

                  if (json.has("error") && json.getString("error").contains("Player not found"))
                        throw new PlayerNotFoundException("Unable to locate a player with the IGN '" + playerUsername + "'");

                  if (json.has("error") && json.getString("error").contains("name or xuid cannot be empty"))
                        throw new EmptyNameOrXUIDException("The player's name or xuid cannot be empty");

                  return json;
            });
      }

      /**
       * It takes a player's xuid, and returns a Future object that will contain the player's statistics
       *
       * @param playerXUID The xuid of the player you want to get the statistics of.
       * @return A Future object that contains a PlayerStatistics object.
       * @throws PlayerNotFoundException if the player xuid passed through is not able to be located
       */
      @SneakyThrows
      public Future<PlayerStatistics> getStatistics(XUID playerXUID) {
            return executor.submit(() -> {
                  JSONObject json = new JSONObject();
                  try {
                        URL url = new URL(Connection.baseURL + Endpoints.STATS_XUID.getUrlPath() + playerXUID.XUID);
                        InputStream is = url.openStream();
                        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                        String jsonText = readAll(rd);
                        json = new JSONObject(jsonText);
                  } catch (Exception e) {}

                  if (json.has("error") && json.getString("error").contains("Player not found"))
                        throw new PlayerNotFoundException("Unable to locate a player with the XUID '" + playerXUID.XUID + "'");

                  return new PlayerStatistics(json);
            });
      }

      /**
       * It takes a player's xuid, and returns a Future object that will contain the player's statistics
       *
       * @param playerXUID The xuid of the player you want to get the statistics of.
       * @return A Future object that contains a JSONObject
       * @throws PlayerNotFoundException if the player xuid passed through is not able to be located
       */
      @SneakyThrows
      public Future<JSONObject> getStatisticsAsJson(XUID playerXUID) {
            return executor.submit(() -> {
                  JSONObject json = new JSONObject();
                  try {
                        URL url = new URL(Connection.baseURL + Endpoints.STATS_XUID.getUrlPath() + playerXUID.getXUID());
                        InputStream is = url.openStream();
                        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                        String jsonText = readAll(rd);
                        json = new JSONObject(jsonText);
                  } catch (Exception e) {}

                  if (json.has("error") && json.getString("error").contains("Player not found"))
                        throw new PlayerNotFoundException("Unable to locate a player with the XUID '" + playerXUID.getXUID() + "'");

                  return json;
            });
      }

      /**
       * It takes a player's username, and returns a list of all the usernames that are similar to it
       *
       * @param playerUsername The username of the player you want to search for.
       * @return A list of strings.
       */
      public Future<List<String>> executeFuzzySearch(String playerUsername) {
            return executor.submit(() -> {
                  JSONArray json = new JSONArray();
                  try {
                        URL url = new URL(Connection.baseURL + Endpoints.FUZZY_SEARCH.getUrlPath() + playerUsername);
                        InputStream is = url.openStream();
                        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                        String jsonText = readAll(rd);
                        json = new JSONArray(jsonText);
                  } catch (Exception e) {}

                  ArrayList<String> toReturn = new ArrayList<>();
                  json.iterator().forEachRemaining(string -> toReturn.add((String) string));
                  return toReturn;
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
