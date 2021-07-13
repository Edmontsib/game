package entity;

import personage.Merchant;

public interface Seller {
    String sell(Merchant.Goods goods);
}
