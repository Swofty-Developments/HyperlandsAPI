# Hyperlands API
![badge](https://img.shields.io/github/v/release/Swofty-Developments/HyperlandsAPI)
[![badge](https://jitpack.io/v/Swofty-Developments/HyperlandsAPI.svg)](https://jitpack.io/#Swofty-Developments/HyperlandsAPI)
![badge](https://img.shields.io/github/last-commit/Swofty-Developments/HyperlandsAPI)
[![badge](https://img.shields.io/discord/476842419904708608?label=discord)](https://discord.gg/hyperlands)
[![badge](https://img.shields.io/github/license/Swofty-Developments/HyperlandsAPI)](https://github.com/Swofty-Developments/HyperlandsAPI/blob/master/LICENSE.txt)

**[JavaDoc 1.0.0](https://hyperlandsdoc.swofty.net/)**

Lightweight and fully documented Java implementation of the Hyperlands Public API.

## Table of contents

* [Getting started](#getting-started)
* [Creating a connection instance](#creating-a-connection-instance)
* [Fetching a users data](#fetching-a-users-data)
* [Fuzzy search](#fuzzy-search)
* [Fetching player counts](#fetching-player-counts)
* [Fetching player skins](#fetching-player-skins)
* [License](#license)

## Getting started

This API is intended for stand-alone usage, meaning that you do not need to run any extra dependencies to use this library.

### Add Hyperlands API to your project 

[![badge](https://jitpack.io/v/Swofty-Developments/HyperlandsAPI.svg)](https://jitpack.io/#Swofty-Developments/HyperlandsAPI)

First, you need to setup the dependency inside of your pom.xml. Replace **VERSION** with the version of the release.

> Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.Swofty-Developments</groupId>
        <artifactId>HyperlandsAPI</artifactId>
        <version>VERSION</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```


> Gradle

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.Swofty-Developments:HyperlandsAPI:VERSION'
}
```

## Creating a connection instance

To access the API, you will need a Connection instance. Every connection instance is async within itself, meaning that if you make two api calls using one connection, the second one will wait for the first one to finish. But if you get two different connections and make two API calls, they will both run asynchronously. The following code is to create a connection instance, you can make as many as needed;

```java
import net.swofty.hyperlandsapi.Connection;
import net.swofty.hyperlandsapi.HyperlandsAPI;

public class Test {

    public static void main(String[] args) {
        Connection connection = HyperlandsAPI.getConnection();
    }

}

```

## Fetching a users data

Fetching a users data is extremely simple. The main thing you need to remember is that because this library is asynchronous, every API call is a CompleteableFuture, and your code will have to reflect that. The following code is an example of how to fetch user data;

```java
import net.swofty.hyperlandsapi.Connection;
import net.swofty.hyperlandsapi.HyperlandsAPI;
import net.swofty.hyperlandsapi.XUID;
import net.swofty.hyperlandsapi.datatypes.PlayerStatistics;
import net.swofty.hyperlandsapi.datatypes.statistics.SkyWarsStatistics;
import net.swofty.hyperlandsapi.managers.PlayerManager;

import java.util.concurrent.ExecutionException;

public class Test {

      // If your code has any futures inside of it, your method will need to add these two method exceptions
      public static void main(String[] args) throws ExecutionException, InterruptedException {

            Connection connection = HyperlandsAPI.getConnection(); // The connection instance

            PlayerManager manager = connection.getPlayerManager(); // Fetching the PlayerManager from the connection, this is used to access all the endpoints that access player data

            PlayerStatistics statistics = manager.getStatistics("ProperPoli777").get(); // Fetching the players PlayerStatistics using their username. Note how this is a CompletableFuture as this method is what calls the API.
            PlayerStatistics xuidStatistics = manager.getStatistics(XUID.getFromString("815929105326")).get(); // Fetching the players PlayerStatistics using their XUID. Note how this is a CompletableFuture as this method is what calls the API.

            // You can fetch general player statistics straight from the PlayerStatistics object
            String rank = statistics.getRank(); // Fetches the rank from the PlayerStatistics
            String lastServer = statistics.getLastServer(); // Fetches the lastServer from the PlayerStatistics

            // For specific gamemode statistics, you will need to get the specific gamemodes object from the PlayerStatistics
            SkyWarsStatistics skyWarsStatistics = statistics.getSkyWarsStatistics(); // Specific game
            
            Double kills = skyWarsStatistics.getKills(); // Specific games statistics
            
      }

}
```

## Fuzzy search

A fuzzy search is a search for people with similar IGNs, this can only be done with IGNs - You cannot pass through XUIDs.
```java
import net.swofty.hyperlandsapi.Connection;
import net.swofty.hyperlandsapi.HyperlandsAPI;
import net.swofty.hyperlandsapi.managers.PlayerManager;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Test {

      // If your code has any futures inside of it, your method will need to add these two method exceptions
      public static void main(String[] args) throws ExecutionException, InterruptedException {

            Connection connection = HyperlandsAPI.getConnection(); // The connection instance

            PlayerManager manager = connection.getPlayerManager(); // Fetching the PlayerManager from the connection, this is used to access all the endpoints that access player data

            List<String> listOfSimilarIGNs = manager.executeFuzzySearch("ProperPoli777").get(); // Get a list of similar IGNs in the Hyperlands database

      }

}
```

## Fetching player counts

The process of fetching player counts is the exact same as everything else, with you first needing to access the connection object to call the ServerManager. Code is as follows;

```java
import net.swofty.hyperlandsapi.Connection;
import net.swofty.hyperlandsapi.HyperlandsAPI;
import net.swofty.hyperlandsapi.datatypes.PlayerCounts;
import net.swofty.hyperlandsapi.datatypes.playercounts.SkyWarsCount;
import net.swofty.hyperlandsapi.managers.ServerManager;

import java.util.concurrent.ExecutionException;

public class Test {

      // If your code has any futures inside of it, your method will need to add these two method exceptions
      public static void main(String[] args) throws ExecutionException, InterruptedException {

            Connection connection = HyperlandsAPI.getConnection(); // The connection instance

            ServerManager manager = connection.getServerManager(); // Fetching the ServerManager from the connection, this is used to access all the endpoints that access server data

            PlayerCounts counts = manager.getPlayerCount().get(); // Fetching the PlayerCounts object from the ServerManager, this is a CompleteableFuture

            Double totalPlayersOnline = counts.getTotal(); // Grabbing the total amount of players on the network
            
            SkyWarsCount skyWarsCount = counts.getSkyWarsCount(); // Grabbing the PlayerCount object for a specific gamemode
            
            Double playersInSoloGamemode = skyWarsCount.getSolos(); // Grabbing the specific gamemodes player count

      }

}
```

## Fetching player skins

The process of fetching player counts is the exact same as everything else, with you first needing to access the connection object to call the TextureManager. Code is as follows;

```java
import net.swofty.hyperlandsapi.Connection;
import net.swofty.hyperlandsapi.HyperlandsAPI;
import net.swofty.hyperlandsapi.managers.TextureManager;

import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutionException;

public class Test {

      // If your code has any futures inside of it, your method will need to add these two method exceptions
      public static void main(String[] args) throws ExecutionException, InterruptedException {

            Connection connection = HyperlandsAPI.getConnection(); // The connection instance

            TextureManager manager = connection.getTextureManager(); // Fetching the TextureManager from the connection, this is used to access all the endpoints that access texture data

            BufferedImage playerHead = manager.getHead("ProperPoli777").get(); // Gets the players head as a buffer image
            BufferedImage playerSkin = manager.getSkin("ProperPoli777").get(); // Gets the players skin as a buffer image

      }

}
```

## License
HyperlandsAPI is licensed under the permissive MIT license. Please see [`LICENSE.txt`](https://github.com/Swofty-Developments/HyperlandsAPI/blob/master/LICENSE.txt) for more information.
