package net.swofty.hyperlandsapi.datatypes.playercounts;

import lombok.Getter;

public class TheBridgeCount {

      @Getter
      public Double total;
      @Getter
      public Double solosRanked;
      @Getter
      public Double solosCasual;
      @Getter
      public Double doublesCasual;

      public TheBridgeCount(Double total, Double solosRanked, Double solosCasual, Double doublesCasual) {
            this.total = total;
            this.solosRanked = solosRanked;
            this.solosCasual = solosCasual;
            this.doublesCasual = doublesCasual;
      }

}