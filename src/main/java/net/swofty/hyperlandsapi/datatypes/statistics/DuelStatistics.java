package net.swofty.hyperlandsapi.datatypes.statistics;

import lombok.Getter;

public class DuelStatistics {

      @Getter
      public Double buildUhcWins;
      @Getter
      public Double potWins;
      @Getter
      public Double ironWins;
      @Getter
      public Double archerWins;
      @Getter
      public Double sumoWins;
      @Getter
      public Double elo;
      @Getter
      public Double currentWinstreak;
      @Getter
      public Double bestWinstreak;

      public DuelStatistics(Double buildUhcWins, Double potWins, Double ironWins, Double archerWins, Double sumoWins, Double elo, Double currentWinstreak, Double bestWinstreak) {
            this.buildUhcWins = buildUhcWins;
            this.potWins = potWins;
            this.ironWins = ironWins;
            this.archerWins = archerWins;
            this.sumoWins = sumoWins;
            this.elo = elo;
            this.currentWinstreak = currentWinstreak;
            this.bestWinstreak = bestWinstreak;
      }

}
