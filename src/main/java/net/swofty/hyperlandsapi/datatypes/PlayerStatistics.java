package net.swofty.hyperlandsapi.datatypes;

import lombok.Getter;
import net.swofty.hyperlandsapi.datatypes.statistics.*;
import org.json.JSONObject;

public class PlayerStatistics {

      @Getter
      private final JSONObject object;

      @Getter
      public Boolean isOnline;
      @Getter
      public Double lastLogout;
      @Getter
      public String lastServer;
      @Getter
      public String rank;
      @Getter
      public String tag;
      @Getter
      public String plusColor;
      @Getter
      public Double expiry;

      @Getter
      public GeneralStatistics generalStatistics;
      @Getter
      public SkyWarsStatistics skyWarsStatistics;
      @Getter
      public BedWarsStatistics bedWarsStatistics;
      @Getter
      public TheBridgeStatistics theBridgeStatistics;
      @Getter
      public SpleefStatistics spleefStatistics;
      @Getter
      public DuelStatistics duelStatistics;
      @Getter
      public UHCMeetupStatistics uhcMeetupStatistics;

      public PlayerStatistics(JSONObject object) {
            this.object = object;

            this.isOnline = object.getJSONObject("status").getBoolean("online");
            this.lastLogout = object.getJSONObject("status").getDouble("lastLogout");
            this.lastServer = object.getJSONObject("status").getString("lastServer");

            this.rank = object.getJSONObject("rankData").getString("rank");
            this.tag = object.getJSONObject("rankData").getString("tag");
            this.plusColor = object.getJSONObject("rankData").getString("pluscolor");
            this.expiry = object.getJSONObject("rankData").getDouble("expiry");

            this.generalStatistics = new GeneralStatistics(
                    object.getJSONObject("stats").getJSONObject("general").getString("playerName"),
                    object.getJSONObject("stats").getJSONObject("general").getString("xuid"),
                    object.getJSONObject("stats").getJSONObject("general").getDouble("level"),
                    object.getJSONObject("stats").getJSONObject("general").getDouble("progress"),
                    object.getJSONObject("stats").getJSONObject("general").getDouble("maxProgress")
            );

            this.skyWarsStatistics = new SkyWarsStatistics(
                    object.getJSONObject("stats").getJSONObject("skywars").getDouble("wins"),
                    object.getJSONObject("stats").getJSONObject("skywars").getDouble("kills")
            );

            this.bedWarsStatistics = new BedWarsStatistics(
                    object.getJSONObject("stats").getJSONObject("bedwars").getDouble("wins"),
                    object.getJSONObject("stats").getJSONObject("bedwars").getDouble("kills"),
                    object.getJSONObject("stats").getJSONObject("bedwars").getDouble("finalKills"),
                    object.getJSONObject("stats").getJSONObject("bedwars").getDouble("bedsBroken"),
                    object.getJSONObject("stats").getJSONObject("bedwars").getDouble("currentWinstreak"),
                    object.getJSONObject("stats").getJSONObject("bedwars").getDouble("bestWinstreak")
            );

            this.theBridgeStatistics = new TheBridgeStatistics(
                    object.getJSONObject("stats").getJSONObject("thebridge").getDouble("wins"),
                    object.getJSONObject("stats").getJSONObject("thebridge").getDouble("goals"),
                    object.getJSONObject("stats").getJSONObject("thebridge").getDouble("currentWinstreak"),
                    object.getJSONObject("stats").getJSONObject("thebridge").getDouble("bestWinstreak"),
                    object.getJSONObject("stats").getJSONObject("thebridge").getDouble("peakRatingSolos")
            );

            this.spleefStatistics = new SpleefStatistics(
                    object.getJSONObject("stats").getJSONObject("spleef").getDouble("wins"),
                    object.getJSONObject("stats").getJSONObject("spleef").getDouble("currentWinstreak"),
                    object.getJSONObject("stats").getJSONObject("spleef").getDouble("bestWinstreak")
            );

            this.duelStatistics = new DuelStatistics(
                    object.getJSONObject("stats").getJSONObject("duels").getDouble("buildUhcWins"),
                    object.getJSONObject("stats").getJSONObject("duels").getDouble("potWins"),
                    object.getJSONObject("stats").getJSONObject("duels").getDouble("ironWins"),
                    object.getJSONObject("stats").getJSONObject("duels").getDouble("archerWins"),
                    object.getJSONObject("stats").getJSONObject("duels").getDouble("sumoWins"),
                    object.getJSONObject("stats").getJSONObject("duels").getDouble("elo"),
                    object.getJSONObject("stats").getJSONObject("duels").getDouble("currentWinstreak"),
                    object.getJSONObject("stats").getJSONObject("duels").getDouble("bestWinstreak")
            );

            this.uhcMeetupStatistics = new UHCMeetupStatistics(
                    object.getJSONObject("stats").getJSONObject("uhcmeetup").getDouble("wins"),
                    object.getJSONObject("stats").getJSONObject("uhcmeetup").getDouble("kills")
            );
      }
}
