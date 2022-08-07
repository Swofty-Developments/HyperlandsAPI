package net.swofty.hyperlandsapi.datatypes.playercounts;

import lombok.Getter;

public class UHCMeetupCount {

      @Getter
      public Double total;
      @Getter
      public Double solos;

      public UHCMeetupCount(Double total, Double solos) {
            this.total = total;
            this.solos = solos;
      }

}