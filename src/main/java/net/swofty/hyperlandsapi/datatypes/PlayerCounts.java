package net.swofty.hyperlandsapi.datatypes;

import lombok.Getter;
import net.swofty.hyperlandsapi.datatypes.playercounts.*;
import org.json.JSONObject;

public class PlayerCounts {

      @Getter
      private final JSONObject object;

      @Getter
      public Double total;
      @Getter
      public BedWarsCount bedWarsCount;
      @Getter
      public DuelsCount duelsCount;
      @Getter
      public LobbyCount lobbyCount;
      @Getter
      public SkyWarsCount skyWarsCount;
      @Getter
      public TheBridgeCount theBridgeCount;
      @Getter
      public UHCMeetupCount uhcMeetupCount;

      public PlayerCounts(JSONObject object) {
            this.object = object;

            this.total = object.getDouble("total");

            this.bedWarsCount = new BedWarsCount(
                    object.getJSONObject("bedwars").getDouble("total"),
                    object.getJSONObject("bedwars").getJSONObject("modes").getDouble("solos"),
                    object.getJSONObject("bedwars").getJSONObject("modes").getDouble("doubles"),
                    object.getJSONObject("bedwars").getJSONObject("modes").getDouble("squads")
            );

            this.lobbyCount = new LobbyCount(
                    object.getJSONObject("lobby").getDouble("total")
            );

            this.skyWarsCount = new SkyWarsCount(
                    object.getJSONObject("skywars").getDouble("total"),
                    object.getJSONObject("skywars").getJSONObject("modes").getDouble("solos"),
                    object.getJSONObject("skywars").getJSONObject("modes").getDouble("doubles"),
                    object.getJSONObject("skywars").getJSONObject("modes").getDouble("duels")
            );

            this.theBridgeCount = new TheBridgeCount(
                    object.getJSONObject("thebridge").getDouble("total"),
                    object.getJSONObject("thebridge").getJSONObject("modes").getDouble("solos-ranked"),
                    object.getJSONObject("thebridge").getJSONObject("modes").getDouble("solos-casual"),
                    object.getJSONObject("thebridge").getJSONObject("modes").getDouble("doubles-casual")
            );

            this.uhcMeetupCount = new UHCMeetupCount(
                    object.getJSONObject("uhcmeetup").getDouble("total"),
                    object.getJSONObject("uhcmeetup").getJSONObject("modes").getDouble("solos")
            );

            this.duelsCount = new DuelsCount(
                    object.getJSONObject("uhcmeetup").getDouble("total")
            );
      }
}
