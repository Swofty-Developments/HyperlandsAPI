package net.swofty.hyperlandsapi.datatypes.statistics;

import lombok.Getter;

public class UHCMeetupStatistics {

      @Getter
      public Double wins;
      @Getter
      public Double kills;

      public UHCMeetupStatistics(Double wins, Double kills) {
            this.wins = wins;
            this.kills = kills;
      }

}
