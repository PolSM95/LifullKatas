package com.gildedrose;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final int ITEM_QUALITY_MAX = 50;
    private static final int ITEM_SELLIN_LEVEL_ONE = 11;
    private static final int ITEM_SELLIN_LEVEL_TWO = 6;
    private static final int ITEM_EXPIRED_DATE = 0;
    private static final int ITEM_QUALITY_MIN = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int index = 0; index < items.length; index++) {

            assign_sell_in_and_quality_for_the_items(items[index]);
        }
    }

    private void assign_sell_in_and_quality_for_the_items(Item item) {
        String itemName = item.name;
        int itemQuality = item.quality;
        int itemSellIn = item.sellIn;

        itemQuality = modify_quality_of_item(itemName, itemQuality, itemSellIn);

        if (!itemName.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            itemSellIn--;
        }

        if (itemSellIn < ITEM_EXPIRED_DATE) {
            itemQuality = modify_quality_when_item_is_expired(itemName, itemQuality);
        }
        item.quality = itemQuality;
        item.sellIn = itemSellIn;
    }

    private int modify_quality_when_item_is_expired(String itemName, int itemQuality) {
        if (!itemName.equals(AGED_BRIE)) {
            return decrease_quality_when_is_not_backstage_and_quality_zero_for_backstage(itemName, itemQuality);
        }
        return  increase_quality_below_max(itemQuality);
    }

    private int decrease_quality_when_is_not_backstage_and_quality_zero_for_backstage(String itemName, int itemQuality) {
        if (!itemName.equals(BACKSTAGE_PASSES)) {
            return decrease_quality_when_is_not_sulfuras_and_quality_more_than_zero(itemName, itemQuality);
        }
        return ITEM_QUALITY_MIN;
    }

    private int modify_quality_of_item(String itemName, int itemQuality, int itemSellIn) {
        if (!itemName.equals(AGED_BRIE) && !itemName.equals(BACKSTAGE_PASSES)) {
            return decrease_quality_when_is_not_sulfuras_and_quality_more_than_zero(itemName, itemQuality);
        }
        return increase_quality_when_item_is_agedbrie_or_backstage(itemName, itemQuality, itemSellIn);

    }

    private int increase_quality_when_item_is_agedbrie_or_backstage(String itemName, int itemQuality, int itemSellIn) {
        if (itemQuality < ITEM_QUALITY_MAX) {
            itemQuality++;
            itemQuality = increase_quality_for_backstage(itemName, itemQuality, itemSellIn);
        }
        return itemQuality;
    }

    private int increase_quality_for_backstage(String itemName, int itemQuality, int itemSellIn) {
        if (itemName.equals(BACKSTAGE_PASSES)) {
            itemQuality = increase_quality_when_item_sell_in_level_one(itemQuality, itemSellIn);
            itemQuality = increase_quality_when_item_sell_in_level_two(itemQuality, itemSellIn);
        }
        return itemQuality;
    }

    private int increase_quality_when_item_sell_in_level_two(int itemQuality, int itemSellIn) {
        if (itemSellIn < ITEM_SELLIN_LEVEL_TWO) {
            itemQuality = increase_quality_below_max(itemQuality);
        }
        return itemQuality;
    }

    private int increase_quality_below_max(int itemQuality) {
        if (itemQuality < ITEM_QUALITY_MAX) {
            itemQuality++;
        }
        return itemQuality;
    }

    private int increase_quality_when_item_sell_in_level_one(int itemQuality, int itemSellIn) {
        if (itemSellIn < ITEM_SELLIN_LEVEL_ONE) {
            itemQuality = increase_quality_below_max(itemQuality);
        }
        return itemQuality;
    }

    private int decrease_quality_when_is_not_sulfuras_and_quality_more_than_zero(String itemName, int itemQuality) {
        if (itemQuality > ITEM_QUALITY_MIN && !itemName.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            itemQuality--;
        }
        return itemQuality;
    }

}