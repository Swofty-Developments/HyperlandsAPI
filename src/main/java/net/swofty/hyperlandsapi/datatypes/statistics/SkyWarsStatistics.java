package net.swofty.hyperlandsapi.datatypes.statistics;

import lombok.Getter;

public class SkyWarsStatistics {

      @Getter
      public Double wins;
      @Getter
      public Double kills;

      public SkyWarsStatistics(Double wins, Double kills) {
            this.wins = wins;
            this.kills = kills;
      }

}
