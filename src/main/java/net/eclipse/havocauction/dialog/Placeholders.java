package net.eclipse.havocauction.dialog;

import net.eclipse.havocauction.model.Listing;
import net.eclipse.havocauction.util.NumberUtil;
import net.eclipse.havocauction.util.TimeUtil;

import java.util.HashMap;
import java.util.Map;

public final class Placeholders {

    private Placeholders() {
    }

    public static Map<String, String> of(Listing listing) {
        Map<String, String> map = new HashMap<>();
        map.put("seller", listing.getSellerName());
        map.put("player", listing.getSellerName());
        map.put("buyer", listing.getBuyerName());
        map.put("item", listing.getItemName());
        map.put("material", listing.getItemName());
        map.put("amount", NumberUtil.count(listing.getAmount()));
        map.put("price", NumberUtil.money(listing.getPrice()));
        map.put("unit_price", NumberUtil.money(listing.getUnitPrice()));
        map.put("expires", TimeUtil.shortDuration(listing.getMillisUntilExpiry()));
        map.put("status", listing.getStatus().name());
        map.put("time", listing.getSoldAt() == null
                ? TimeUtil.shortDuration(System.currentTimeMillis() - listing.getCreatedAt())
                : TimeUtil.shortDuration(System.currentTimeMillis() - listing.getSoldAt()));
        return map;
    }
}
