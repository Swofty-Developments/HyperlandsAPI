package net.swofty.hyperlandsapi.datatypes.playercounts;

import lombok.Getter;

public class SkyWarsCount {

      @Getter
      public Double total;
      @Getter
      public Double solos;
      @Getter
      public Double doubles;
      @Getter
      public Double duels;

      public SkyWarsCount(Double total, Double solos, Double doubles, Double duels) {
            this.total = total;
            this.solos = solos;
            this.doubles = doubles;
            this.duels = duels;
      }

}