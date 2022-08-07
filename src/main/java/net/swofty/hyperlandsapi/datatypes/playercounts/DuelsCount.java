package net.swofty.hyperlandsapi.datatypes.playercounts;

import lombok.Getter;

public class DuelsCount {

      @Getter
      public Double total;

      public DuelsCount(Double total) {
            this.total = total;
      }

}