package net.swofty.hyperlandsapi.datatypes.playercounts;

import lombok.Getter;

public class LobbyCount {

      @Getter
      public Double total;

      public LobbyCount(Double total) {
            this.total = total;
      }

}