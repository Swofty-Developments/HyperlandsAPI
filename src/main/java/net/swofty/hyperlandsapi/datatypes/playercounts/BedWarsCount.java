package net.swofty.hyperlandsapi.datatypes.playercounts;

import lombok.Getter;

public class BedWarsCount {

      @Getter
      public Double total;
      @Getter
      public Double solos;
      @Getter
      public Double doubles;
      @Getter
      public Double squads;

      public BedWarsCount(Double total, Double solos, Double doubles, Double squads) {
            this.total = total;
            this.solos = solos;
            this.doubles = doubles;
            this.squads = squads;
      }

}