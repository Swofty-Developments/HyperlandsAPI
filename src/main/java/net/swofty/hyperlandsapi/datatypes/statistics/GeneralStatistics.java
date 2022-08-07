package net.swofty.hyperlandsapi.datatypes.statistics;

import lombok.Getter;

public class GeneralStatistics {

      @Getter
      public String playerName;
      @Getter
      public String xuid;
      @Getter
      public Double level;
      @Getter
      public Double progress;
      @Getter
      public Double maxProgress;

      public GeneralStatistics(String playerName, String xuid, Double level, Double progress, Double maxProgress) {
            this.playerName = playerName;
            this.xuid = xuid;
            this.level = level;
            this.progress = progress;
            this.maxProgress = maxProgress;
      }

}
