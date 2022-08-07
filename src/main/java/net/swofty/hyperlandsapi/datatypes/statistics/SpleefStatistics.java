package net.swofty.hyperlandsapi.datatypes.statistics;

import lombok.Getter;

public class SpleefStatistics {

      @Getter
      public Double wins;
      @Getter
      public Double currentWinstreak;
      @Getter
      public Double bestWinstreak;

      public SpleefStatistics(Double wins, Double currentWinstreak, Double bestWinstreak) {
            this.wins = wins;
            this.currentWinstreak = currentWinstreak;
            this.bestWinstreak = bestWinstreak;
      }

}
