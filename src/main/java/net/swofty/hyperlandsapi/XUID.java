package net.swofty.hyperlandsapi;

import lombok.Getter;

public class XUID {

      @Getter
      public String XUID;

      XUID(String XUID) {
            this.XUID = XUID;
      }

      public static XUID getFromLong(Long XUID) {
            return new XUID(String.valueOf(XUID));
      }

      public static XUID getFromString(String XUID) {
            return new XUID(XUID);
      }

}
