package net.swofty.hyperlandsapi.datatypes.statistics;

import lombok.Getter;

public class TheBridgeStatistics {

      @Getter
      public Double wins;
      @Getter
      public Double goals;
      @Getter
      public Double currentWinstreak;
      @Getter
      public Double bestWinstreak;
      @Getter
      public Double peakRatingSolos;

      public TheBridgeStatistics(Double wins, Double goals, Double currentWinstreak, Double bestWinstreak, Double peakRatingSolos) {
            this.wins = wins;
            this.goals = goals;
            this.currentWinstreak = currentWinstreak;
            this.bestWinstreak = bestWinstreak;
            this.peakRatingSolos = peakRatingSolos;
      }

}
