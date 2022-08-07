package net.swofty.hyperlandsapi;

import lombok.Getter;

public enum Endpoints {
      SKIN("/skin/"),
      HEAD("/head/"),
      STATS("/stats/"),
      STATS_XUID("/xuid/"),
      FUZZY_SEARCH("/fuzzySearch/"),
      PLAYER_COUNT("/playerCounts"),
      ;

      @Getter
      public String urlPath;

      Endpoints(String urlPath) {
            this.urlPath = urlPath;
      }

}
