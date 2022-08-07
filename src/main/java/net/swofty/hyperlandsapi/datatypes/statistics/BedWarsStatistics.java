package net.swofty.hyperlandsapi.datatypes.statistics;

import lombok.Getter;

public class BedWarsStatistics {

      @Getter
      public Double wins;
      @Getter
      public Double kills;
      @Getter
      public Double finalKills;
      @Getter
      public Double bedsBroken;
      @Getter
      public Double currentWinstreak;
      @Getter
      public Double bestWinstreak;

      public BedWarsStatistics(Double wins, Double kills, Double finalKills, Double bedsBroken, Double currentWinstreak, Double bestWinstreak) {
            this.wins = wins;
            this.kills = kills;
            this.finalKills = finalKills;
            this.bedsBroken = bedsBroken;
            this.currentWinstreak = currentWinstreak;
            this.bestWinstreak = bestWinstreak;
      }

}
