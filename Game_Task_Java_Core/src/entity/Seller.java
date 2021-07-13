package entity;

import personage.PotionSeller;

public interface Seller {
    String sell(PotionSeller.Goods goods);
}

